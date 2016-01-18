This is a simple solution to merge swagger json files. Instead of creating jsons for each APIs this can be used to create a single json for multiple APIs. Host name should be common for all the APIs. This can be simply used in WSO2 API manager.

Follow bellow steps to merge swagger files.
1)Place all swagger files in /SwaggerJsonMerger/wso2jsonmerger/inputSwagger folder.
2)Use static merger.merge() method to merge.
3)You can find the output swagger file in SwaggerJsonMerger/swagger.json
