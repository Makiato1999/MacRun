# How to run our service

## Approach 1: through github 

1. Clone the GitHub repo onto your computer by `git clone` or simply download the zip file.
2. Go into the `deployment` directory and start our Docker images.
   ```bash
   cd deployment
   docker-compose up
   ```
   The necessary files will be downloaded and your services should start running!

## Approach 2: through Dockerhub

1. Similarly, clone the GitHub repo onto your computer. 
2. Go into the `deployment` directory and start our Docker containers.
   ```bash
   cd deployment
   docker-compose -f docker-compose-prod.yml up
   ```
   The images should be downloaded and will start running!

# How to test our service

## Approach 1: through mvn test

1. Clone the GitHub repo onto your computer by `git clone` or simply download the zip file.
2. Go into the main project directory and run `mvn test`, you should see the tests are running automatically and the result of pass/fail are shown/

## Approach 2: through postman

1. open the postman TODO: the link?? the removed verb version

## App
1. User Register -> Trail Allocation -> Game Center
   - start up user-opt service, trail-center service, game-center service by ```mvn spring-boot:run```
   - send a POST request such as
     ```
     url: http://localhost:8075/user/register
     body:
     {
        "email": "Daryl@mcmaster.ca",
        "userName": "Daryl"
     }
     ```
2. User Operation -> Game Center (Attack Decision)
   - start up user-opt service and game-center service by ```mvn spring-boot:run```
   - send a POST request such as
     ```
     url: http://localhost:8075/user/opt
     body:
     {
        "optID": "2"
     }
     ```
3. Eureka service discovery
   - run eureka server by ```mvn spring-boot:run```
     - access the web UI by `http://localhost:8761/`
   - run gateway service by ```mvn spring-boot:run```
   - run service by ```mvn spring-boot:run```
      - open a new terminal and create another instance by ```mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=9091 --server.instance.id=2"```