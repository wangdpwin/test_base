# Test Project
```
This is my test project, a demo for common skill
``` 

## first: replace class in jar file
```
1. 编写源java文件，如com.example.test.hotfix.ReplaceClazz,main方法输出hello
2. 打包成jar文件，java -jar test.jar测试输出内容，使用maven，指定main class,参见pom.xml -> build -> plugin
3. 在测试目录下，创建相同package，创建同名java文件，main方法输出hello world,javac编译为class文件
4. 检查目录下class文件是否存在,执行命令替换jar包中同路径同名class文件
   jar uvf ../../../target/test-1.0-SNAPSHOT.jar com/example/test/hotfix/ReplaceClazz.class
5. java -jar test-1.0-SNAPSHOT.jar 测试输出内容
```