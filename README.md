This is a simple solution to merge swagger json files. Instead of creating jsons for each APIs this can be used to create a single json for multiple APIs. Host name should be common for all the APIs. This can be simply used in WSO2 API manager.

## Follow bellow steps to merge swagger files.
<ol>
  <li>Build this using mvn clean install command on your linux system</li>
  <li>Place all swagger files in /SwaggerJsonMerger/modules/wso2jsonmerger/inputSwagger folder. Swagger files should be named as 0.josn,1.json and 2.json likewise</li>
  <li>Execute merger.sh file.</li>
  <li>You can find the output swagger file in SwaggerJsonMerger/distribution/swagger.json</li>
</ol>
