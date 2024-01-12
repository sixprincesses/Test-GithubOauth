APP_NAME=spring_container
IMAGE=spring_github

docker rm -f $APP_NAME

docker image rm $IMAGE
docker build . -t $IMAGE

docker run -d \
-p 8080:8080 \
--name $APP_NAME \
$IMAGE


