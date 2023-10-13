# Build and Deploy the Docker Image
## Build the Docker Image
1. From the main directory, run the following command:
   ```bash
   mvn package -Dskiptests
   ```
   This will build jars of our services.
2. Next, we'll go into the `deployment` directory and start our Docker containers.
   ```bash
   cd deployment
   docker-compose up
   ```
   The necessary files will be downloaded and your services should start running!

## Deploying your container to Dockerhub


1. Run `docker-compose build` to build the images.
2. Run `docker login` to log into your DockerHub account.
3. Run `docker-compose push` to push your images to your DockerHub account.
4. Log into your DockerHub account. You should see the new image repositories.
5. Lastly, we want to run these from DockerHub. But we want to delete the local copies to ensure we can access.
   the DockerHub ones. First, go into Docker Desktop, click Containers, and delete the containers.
6. Then, go into the Images, and delete all the images by first pressing "Clean up...'
7. Finally, inside the `deployment` folder, run `docker-compose -f docker-compose-prod.yml up`. The images should be downloaded and will start running!

