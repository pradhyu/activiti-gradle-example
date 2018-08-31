
Source code from Activiti in Action https://code.google.com/p/activitiinaction/downloads/list

The source code use groovy 1.7.5 for the script task but since version 2.0 the groovy engine was moved to groovy-all
You have to use  groovy-all:2.2.2 instead of groovy 1.7.5 - 1.8.9 for embedded groovy in your application


If you get an exception

org.activiti.engine.ActivitiException: Can't find scripting engine for 'groovy'

make sure you are using the right dependency for the script task:

compile "org.codehaus.groovy:groovy-all:2.2.2"


https://github.com/Activiti/Activiti/commit/bb96ca6ae22437b0851196abefce88569f13d682