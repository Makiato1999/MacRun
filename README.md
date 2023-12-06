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
2. Go into the main project directory and run `mvn test`, you should see the tests are running automatically and the result of pass/fail are shown.

## Approach 2: through postman

1. Open the Postman and fork the [collection](https://www.postman.com/xiaoranxie/workspace/cas735-project/collection/30263408-35a84955-db56-458b-8094-cb62825e07e3?action=share&creator=30263408), 
you should be able to see a series of test case. One thing worth mentioning here is the user id are set to random long number after the post request, so in the get request, you need to use the id 
that is generated from the post request.
