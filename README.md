# pollAPI

#### Description

Restful API implementation for polls.



## Getting Started

These instructions will help you to set up the project and ready to be run with docker.

### Prerequisites

Prepare dependencies, docker images and generate image  by using `Dockerfile`

#### Dependency

- Spring Boot 2.3.1.RELEASE

- JDK 1.8

### Docker file

#### Docker Image

##### Build Docker Image

```
docker build -t pollapi .
```

##### Run Docker Image

```
docker run -d -p 8080:8080 pollapi
```

##### Localhost connection

Now you can connect the API with localhost:8080. For example to see the API documentation under this url:

```
http://localhost:8080/swagger-ui.html
```



#### Docker compose

Service is defined in `docker-compose.yml` so they can be run in an isolated environment.

```
docker-compose up
```

##### Localhost connection

Now you can connect the API with localhost:8080. For example to see the API documentation under this url:

```
http://localhost:8080/swagger-ui.html
```



## Functionality

### API swagger documentation

If the container is running the API swagger specification is available under this url:

```htttp
http://localhost:8080/swagger-ui.html
```



### Functionalities explanation

1. **Get poll list**

   Get full poll list in database

   ```
   GET localhost:8080/polls/list
   ```

2. **List all polls created by a user**

   Query polls created by a user

   ```
   GET localhost:8080/polls/user=John%20Doe
   ```

3. **Search polls by its title**

   Query polls by its title

   ```
   GET localhost:8080/polls/title=Qui%20sont%20les%20superh%C3%A9ros%20Marvel%20les%20plus%20oufs?
   ```

4. **List all polls created after a certain date**

   Query polls created after a certain date

   ```
   GET localhost:8080/polls/dateAfter=1485521569055
   ```

   

## Future works and thoughts

1. Functionalities improvement

   There are still some functionalities can be improved:

   - Change date format to support real world usage format
   - Support query combination
   - Extend the DAO layer to support full shape of the polls in JSON format

2. Comprehensive testing

   - More broader coverage testing, especially for exception handling 
   - Integration testing

3. Database

   - Use PostgreSQL rather than H2 in-memory database

4. Exception handling

   - More exception handling, ex: database time out etc.

## Development flow

Focused on the **end-to-end** software development process, according to following processes:

1. Analysis and Planning Requirements
2. Design and Prototyping 
   - Use SQL database
3. Software Development 
   - Functionalities implementation
   - JPA query
   - Exception handling
4. Testing 
   - Unit testing
5. Deployment
   - Dockerfile
   - Docker-compose
6. Maintenance and Updates
   - Use Google Java code formatter

### Priorities

- DAO:
  - Simple necessary JSON format :ballot_box_with_check:
  - Full JSON format
- Exception handling
  - Global exception handler :ballot_box_with_check:
  - Runtime exception handler :ballot_box_with_check:
  - Database exception handler
- Database
  - H2 in-memory database :ballot_box_with_check:
  - PostgreSQL database
- Query
  - Simple query :ballot_box_with_check:
  - Query combination
  - more flexible quries
- Testing
  - Unit testing :ballot_box_with_check:
  - Integration testing
  - End-to-end testing
- Documentation
  - Logger :ballot_box_with_check:
  - Swapper API documentation :ballot_box_with_check:
  - Code style consistency:ballot_box_with_check:
- Docker
  - Dockerfile :ballot_box_with_check:
  - Docker-Compose :ballot_box_with_check:







