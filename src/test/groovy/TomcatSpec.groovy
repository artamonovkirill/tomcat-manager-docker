import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import spock.lang.Specification
import spock.lang.Unroll

import static org.testcontainers.containers.BindMode.READ_ONLY

class TomcatSpec extends Specification {

    def port = 8080

    @Unroll
    def 'starts Tomcat #version with a manager application'() {
        given:
        def container = new GenericContainer("tomcat:$version")
                .withExposedPorts(port) // for debug purposes
                .withClasspathResourceMapping('manager.xml', '/usr/local/tomcat/conf/Catalina/localhost/manager.xml', READ_ONLY)
                .withClasspathResourceMapping('users.xml', '/usr/local/tomcat/conf/tomcat-users.xml', READ_ONLY)
                .waitingFor(Wait.forHttp('/manager/status'))

        when:
        container.start()

        then:
        noExceptionThrown()

        cleanup:
        container.stop()

        where:
        version << [7, 8, 9, 10]
    }

}
