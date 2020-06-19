# pollAPI

#### Description

Doodle Backend Engineer coding challenge



## Getting Started

These instructions will help you to set up the project and ready to be run with docker.

### Prerequisites

Prepare dependencies, docker images and generate image  by using `Dockerfile`

#### Dependency

- Spring Boot 2.3.1.RELEASE

- JDK 1.8

## Docker file

### Build Docker Image

```
docker build -t pollapi .
```

### Run Docker Image

```
docker run -d -p 8080:8080 pollapi
```

### Localhost connection

Now you can connect the API with localhost:8080. For example to get the list of polls in the database:

```
http://localhost:8080/polls/list
```



## Functionality

### API swagger documentation

If the container is running the API swagger specification is available under this url:

```htttp
http://localhost:8080/swagger-ui.html
```



## Future works and thoughts



## Development flow

I focus on the **end-to-end** software development process, according to following processes:

1. Analysis and Planning Requirements 
2. Design and Prototyping 
3. Software Development 
4. Testing 
5. Deployment
6. Maintenance and Updates
   - Use Google Java code formatter







