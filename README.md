# Exploring tracing with Sleuth

https://cloud.spring.io/spring-cloud-sleuth/
http://ryanjbaxter.com/cloud/spring%20cloud/spring/2016/07/07/spring-cloud-sleuth.html


Start Zipkin

    docker run -d -p 9411:9411 openzipkin/zipkin
    
[Open web page](http://localhost:9411/)


Start ActiveMQ

    docker run -p 61613:61613 -p 5672:5672 -p 8161:8161 -p 1883:1883 -p 61616:61616 webcenter/activemq:5.14.3