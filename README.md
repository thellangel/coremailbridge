本地archetype工程添加到localcatalog，以便eclipse生成项目
mvn clean 
mvn archetype:create-from-project
cd target\generated-sources\archetype
mvn install

mvn archetype:update-local-catalog

生成项目以后，需要需改下logback.xml，将日志类的路径修改下。

工程名称尽量不要待 下划线和横线 _ -