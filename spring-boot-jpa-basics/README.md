`**JPA**`

Hibernate Default JPA implementation:
------------------------------------
Because present in classpath by default

JPA Terms:
---------------
Entity - Equivalent to Java Object, JPA creates a corresponding table for this (Class AaaBbb, Table Aaa_Bbb, similar also column)
EntityManager - Manages Entities , performs CRUD
Persistence Context - EntityManager keeps track of Entities
@Transactional - Each DB operation as a transaction
CommandLineRunner - Runs when Spring Context launches up

Spring Data JPA:
-----------------------
Simplifies Entity DAO Service . Just create a Spring Data repository(Extends JPARepository) instead of Dao service And
It handles EntityManager and interact with DB to perform CRUD on Entities

JPA Implementation KeyNote:
--------------------------------
Entity --> DaoService with Entity manager or JPARepository --> Caller of DaoService or JPARepository(example: CommandLineRunner)

**JPA**

table/Column naming wrt Class/Property(Camel case becomes Underscore)
custom find method based on columns (check naming convention)

Examples in Exercise
--------------------------------
data.sql(TO run all SQL automatically by Spring, Keep in resource)
OneToMany Relationship in JPA
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**`SPRING BOOT 2.3`**

Spring Starter : To reduce overhead of adding dependency(Package of dependencies)
Spring initializer : Quickly create a spring project online,download, use
Spring Boot : Just focus on application logic of rest service/Web App, rest all ( dispatcher/tomcat will be taken care by auto-configuration ??)

Vs Spring MVC has below things do
------------------------------------
Select frameworks and versions
add jackson
add log4j
add dispatcher Servlet to web.xml
Need to implement default exception handling
implement message source
implement Locale resolver

Spring Boot -> how creates bean
------------------------------------
1.Checks the classes in classpath for eg, if Datasource.class is there ,create datasource bean
2.Beans configured in the application

Auto-Config details:(spring-boot-autoconfigure.jar) does it
--------------------------------------------------------------------------------
1.logging.level.org.springframework: DEBUG Add this to ap.properties to know more
2.It looks at some class in classpath to auto configure spring beans such as DispatcherServlet,
ViewResolver and Embedded Tomcat. Check DEBUG logs.

Default Embedded Webserver tomcat:
---------------------------------
Because spring-boot-starter-web --> spring-boot-starter-tomcat --> org.apache.tomcat.embed

View Resolver
----------------------
The 'view' result of your controller is resolved to a real View using a ViewResolver. Depending on the ViewResolver the result can be jsp page, a tiles view, a thymeleaf template or many other 'Views'. In your case the ViewResolver resolves a view name (e.g. 'myPage') to a jsp file (e.g. /WEB-INF/jsp/myPage.jsp)

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

@SpringBootApplication:
----------------------------
1.Says the class is Spring context
2.Auto configuration enabled
3.Component Scanning enabled(From same or sub-packages)

CommandLineRunner
---------------------------
Runs when Spring Context launches up

@RestController
---------------------------
Define Rest Services

Spring BOOT actuator:
---------------------------------
Exposes many helper rest APIs'(using HAL browser) to give info about application health, httpTrace, how much a request took and lot cool stuff
For monitoring purpose also
HAL full: Hypertext application lang
http://localhost:8080/actuator

Spring BOOT Dev tools:
----------------------
Hot deploy on the fly for JAVA changes

ServletUriComponentsBuilder
--------------------------------
To build URI for eg: 201

ResponseEntity
--------------------------------
TO form response with HTTP status etc

Centralized /one uniform /Custom exception Exception Handler across resources
------------------------------------------------------------------------------
Extend ResponseEntityExceptionHandler
and @RestController(as it returns a response in case of Error)
and @ControllerAdvice(To use this Exception handling controller for all other controllers)

Java Validation API
--------------------
Provides validation annotation for beans
Implementation: Hibernate-validator
http://www.baeldung.com/javax-validation
http://www.baeldung.com/javax-validation-method-constraints (Validation on Method params and return values)

Spring + Java Validation API Usage
-------------------------------------
Exception Handling

HATEOAS Starter
----------------
Full form: hyper media as the Engine of Application state
Along with resource -> some metadata or additional resource(eg links)
User Resource.class for the actual resource of API + additional resource

i18n
----------
By using Beans 1. LocaleResolver(Define default locale and Other use : AcceptHeaderLocaleResolver to pick Locale from Accept-Lang header) 2.ResourceMessageBundleSource(Define property file base name)
Ideally locale should come as "Accept-Language" header

Content Negotiation
--------------------------------
Support different request / response format (XML/JSON) for API
Headers : content-type , Accept
Can be achieved by just adding a jar

Swagger2 for Documentation(similar to SOAP WSDL)
--------------------------------------------------
Imp sections in Generated Doc: Info(Desc of Application) / APIs/Definitions(Resources used in APIS/Validation Desc about Field)
SwaggerConfig
http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-docs

Filtering
-----------
TO ignore a propery to be sent in response
Static(ignore one property always for eg, password) : @JsonIgnore
Dynamic(ignore one property based on requirement) : Return a wrapper MappingJacksonValue with config to ignore required properties in API response

Versioning
--------------
Refer DifferentVersioningWays.PNG

Security of API
------------------
Basic Authentication(UserName and Password) -> Just add a Jar

Richardson Maturity Model
--------------------------------------------
LEVEL 0: Use SOAP actions as REST URI(getUser or deleteUser etc)
LEVEL 1: Use resource as REST URI(Demerit: Improper use of HTTP method)
LEVEL 2: LEVEL 0+LEVEL 1 (Now Improper use of HTTP method)
LEVEL 3: LEVEL 2 + Next possible action(HATEAOS)

BEST PRACTICES:
--------------------------------------------
Proper HTTP methods(LEVEL 2)
Use plurals (/users/1)
Use Noun(/user, not /account)
put actions in URI(eg of GIT, /commits/{id}/star, star included here)

Reference:
--------------------------------------------
http://springboottutorial.com
docs.spring.io

TO READ
--------------------------------------------
Security using Spring Boot