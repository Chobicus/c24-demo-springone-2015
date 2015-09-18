# c24-demo-springone-2015

This project demonstrates the use of C24 Preon technology with Spring-Boot, Spring-Integration, Spring-Batch and Hazelcast.


# Get the project

The project is available from the C24 public Git repository.

To clone it:

``` git clone https://github.com/C24-Technologies/c24-demo-springone-2015 ```

# Build the project with Maven

To build the project execute the following maven command from the project root directory:

``` mvn clean install ```

#About the Application

On start up a Hazelcast server is started with two cache regions.
These are named "usd" and "other"

``` 
        Config config = new Config();
        return Hazelcast.newHazelcastInstance(config);
```

```
         IMap<Long, Object> other = hazelcastInstance.getMap("other");
         IMap<Long, Object> usd = hazelcastInstance.getMap("usd");
```

A File poller polls for files ending in .zip containing trades in the inbound/read directory

When a file is discovered it is ingested and passed to a Spring Batch job

The Spring Batch job parses the file and creates instances of biz.c24.trades.Trades

A configured C24ItemReader performs the task of parsing

```
    public C24ItemReader ioItemReader(ZipFileSource zipFileSource, C24Model tradeModel) {
        C24ItemReader c24ItemReader = new C24ItemReader();
        c24ItemReader.setSource(zipFileSource);
        c24ItemReader.setElementStartPattern(".*");
        c24ItemReader.setModel(tradeModel);
        c24ItemReader.setValidate(true);
        return c24ItemReader;
    }
```
Batches of parsed object instances are then channeled to a Spring Integration flow for processing

The SI flow splits the objects into single biz.c24.trades.trade objects and transforms them into Preon objects.

A lookup is performed on the currency field to determine which cache to insert into

```
    public IntegrationFlow tradeWrites(
            @Qualifier(DemoApplication.TRADE_ITEM_WRITER_CHANNEL) MessageChannel channel,
            @Qualifier(DemoApplication.HAZELCAST_USD_CHANNEL) MessageChannel usd,
            @Qualifier(DemoApplication.HAZELCAST_ALL_OTHERS_CHANNEL) MessageChannel others) {
        return IntegrationFlows.from(channel)
                .split()
                .split("payload.trade", (org.springframework.integration.dsl.support.Consumer<SplitterEndpointSpec<ExpressionEvaluatingSplitter>>) null)
                .transform((Trade trade) -> { // regular trade to SDO trade
                    try {
                        biz.c24.trades.sdo.Trade sdoTrade = C24.toSdo(trade);
                        return sdoTrade;
                    } catch (IOException e) {
                        throw new RuntimeException("Trade could not be transformed to SDO", e);
                    }
                })
                .route(new AbstractMessageRouter() {
                    @Override
                    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
                        biz.c24.trades.sdo.Trade cast = biz.c24.trades.sdo.Trade.class.cast(message.getPayload());
                        return Collections.singletonList(cast.getCurrency1().equalsIgnoreCase("USD") ? usd : others);
                    }
                })
                .get();
    }
```

# Generating a trade file

Use biz.c24.io.demo.utils.TradeGenerator to generate a million sample trades with randomised data.

# Running the application

The application is boot strapped using Spring Boot

``` mvn spring-boot:run ```

Once it is running you can place the generated trade file into the inbound/read directory in the project root

The console output should show the number of trades going into each cache

#Querying the Cache

There is a class in biz.c24.io.demo.client called QueryClient that you can run to query the cache

## Query commands

By default commands will be run against the "other" cache
```
> h  (show help)

> usd (change to usd cache)

> other (change to other cache)

> size  (return the number of objects in the cache)

> <Attribute> <Operand> <value>  (Query predicates to run)

> limit <number>  (number of found instances to return with the query result. limit 0 will turn off this feature)
```
### Some examples
```
> BuySell = Buy

> BuySell = Buy and Currency1 = GBP and Currency2 = USD

> TradeDate > 2015-03-20 and SettlementDate < 2015-05-20
```

The client application can be run in a separate console window using

``` mvn exec:java -Dexec.mainClass="biz.c24.io.demo.client.QueryClient" ```

Once it is running you can use the above commands to query the cache

# Links

* [C24 IO] (http://c24tech.com)
* [C24 Git Hub Repository] (https://github.com/C24-Technologies)
* [C24 Preon with Hazelcast] (http://www.c24tech.com/integrations/hazelcast)
