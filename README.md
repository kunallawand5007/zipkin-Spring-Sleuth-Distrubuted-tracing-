Observality Design Pattern:


1. Distrubuted Tracing :

2. health sprng boot actuator:


In microservice based application,there many microservices interact with downstreams  microservices to get data/result,microsevices are scattered on different environment/locations and we need anlayze which microservices causing promblem,it is very 
tedious task to handle this scanario, so we need to anayalaze all services log one by one to then come to conclusion what causing promblem do the required step to fix the promblem

but Zipkin and Sleuth handle these kind promblem by centralizing all trace log on single URL then we can see services call
and analyze how much time taken by each microservice. 

Zipkin is very efficient tool for distributed tracing in microservices.
Distributed tracing, in general, is latency measurement of each component in a distributed transaction where multiple microservices are invoked to serve a single business usecase.

In Zipkin sever run as service as spring boot 2.0 not campatible with zip ,i,e we used spring boot 1.5 version

In application.properties of zipkin server service add below 2 properties 
spring.application.name=zipkin server
server.port=9411

to analyze tracing for services we need to add below property in services application.properties

spring.application.name=zipkin server2
spring.zipkin.base-url=http://localhost:9411/
spring.sleuth.sampler.probability=1

only thing is spring.application.name should start with name that has given in zipkin-serves service application properties like for E.g --zipkin server2,zipkin server3


Step to Run :

1. Run Zipkin-server services by entering these url 
      http://localhost:9411/
2. Run student-service by entering these url 
	http://localhost:8081/api/colleges
	http://localhost:8081/api/colleges/students/pict
	
3. Run college-service by entering these url 
	http://localhost:8082/api/student/pict


4. Then go zipkin server url 
      go to ->Find a trace->you can see service name in dropdown ->press find traces button then you can see all tracing info for these url
  	we can also searrch based on search text in Annotations Query text box 
	
