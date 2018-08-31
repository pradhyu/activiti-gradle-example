// A simple Groovy script running a BPMN 2.0 process with the Activiti engine (http://www.activiti.org/).
// One of the tasks contains a Groovy script!

// Resources:
// Activiti, http://www.activiti.org/
// http://www.jorambarrez.be/blog/2010/08/09/hello_world_on_mysql/
// http://www.javabeat.net/articles/print.php?article_id=362
// H2, http://www.h2database.com/

@GrabResolver(name='activiti.repo', root='https://mvnrepository.com/artifact/org.activiti/activiti-engine')
@Grab(group='org.activiti', module='activiti-engine', version='5.22.0')
@Grab(group='com.h2database', module='h2', version='1.3.164')
import org.activiti.engine.ProcessEngineConfiguration 


// Create Activiti process engine using an in memory H2 database instance
def processEngine = ProcessEngineConfiguration
    .createStandaloneInMemProcessEngineConfiguration()
    .buildProcessEngine()
  
// Get Activiti services
def repositoryService = processEngine.repositoryService
def runtimeService = processEngine.runtimeService

// Deploy the process definition
println repositoryService.createDeployment()
    .addClasspathResource("hello-world.bpmn20.xml")
    .deploy()

// Start a process instance
runtimeService.startProcessInstanceByKey("test")
