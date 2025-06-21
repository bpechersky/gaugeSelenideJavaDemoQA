@echo off
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%
mvn -Dsurefire.suiteXmlFiles=testng.xml test
start test-output\index.html
pause
