# c24-demo-springone-2015

This project demonstrates the use of C24 Preon technology with Spring-Boot, Spring-Integration, Spring-Batch and Hazelcast.


# Get the project

The project is available from the C24 public Git repository.

To clone it:

``` git clone https://github.com/C24-Technologies/c24-demo-springone-2015 ```

# Build the project with Maven

To build the project execute the following maven command from the project root directory:

``` mvn clean install ```

# Running the project as a standalone service with Spring Boot

``` mvn spring-boot:run ```

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

A File poller polls for files ending in .zip in the inbound/read directory

When a file is discovered it is ingested and passed to a Spring Batch job

The Spring Batch job parses the file and creates instances of biz.c24.trades.Trades



