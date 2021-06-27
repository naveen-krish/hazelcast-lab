mvn clean install
cp opentelemetry-javaagent-all.jar spboot-tracing-ms1/ 
cp opentelemetry-javaagent-all.jar spboot-tracing-ms2/
docker-compose up --build
