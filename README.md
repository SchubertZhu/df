# Datafibers Kappa Architecture

Datafibers Kappa Architecture is based on a immutable log appender model. This project provides an implementation of streaming a very large file using vert.x client to a vert.x server. Parsing data on server and sending the records to Kafka Queue.

Then records are read by Kafka queue and processed by Apache Flink framework.

It is a maven multi-module project. It contains following modules

*  vertx-reactive-client - reads a very large file and streams it to server
*  vertx-reactive-server - non-blocking server, that reads stream of data from client, parses data and sends it to Kafka queue.
*  flink-kafka-processor - uses streaming data processing framework Apache Flink to read data from Kafka and in this project it uses Cassandra DB to store the processed data.
** This project also uses Spring Data Cassandra APIs for CRUD operations to Cassandra DB.


###To Run a Docker Cassandra DB image
`$ docker run --name cassandraapp -p 0.0.0.0:9042:9042  -d cassandra:2.2.5`

We are using cassandra 2.x version because Spring data APIs currently support Cassandra DB 2.x version.

###Licence

Read [Licence](https://github.com/tuhingupta/kappa-streaming/blob/master/license.md) information.

### TODO
1. Constent streamer
//{"transaction_date":"2015-12-29","account_number":"201418777876948","transaction_amount":"803.02","last_name":"Willis","id":"405067","first_name":"Billy","email":"bwillis10@spotify.com"}
//{"transaction_date":"2015-05-30","account_number":"4905709701528306163","transaction_amount":"224.86","last_name":"Lee","id":"405068","first_name":"Douglas","email":"dleep6@posterous.com"}
