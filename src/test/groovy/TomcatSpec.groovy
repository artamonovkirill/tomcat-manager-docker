import org.testcontainers.containers.GenericContainer
import spock.lang.Specification
import spock.lang.Unroll

import static org.testcontainers.containers.BindMode.READ_ONLY
import static org.testcontainers.containers.wait.strategy.Wait.forLogMessage

class TomcatSpec extends Specification {

    def port = 8080

    @Unroll
    def 'starts Tomcat #version with a manager application'() {
        given:
        def container = new GenericContainer("tomcat:$version")
                .withExposedPorts(port)
                .withClasspathResourceMapping('manager.xml', '/usr/local/tomcat/conf/Catalina/localhost/manager.xml', READ_ONLY)
                .withClasspathResourceMapping('users.xml', '/usr/local/tomcat/conf/tomcat-users.xml', READ_ONLY)
                .waitingFor(forLogMessage(/.*Server startup in [\[]?[0-9]+[\]]? (ms|milliseconds).*/, 1))

        when:
        container.start()

        then:
        "http://admin@${container.containerIpAddress}:${container.getMappedPort(port)}/manager/status"
            .toURL()
            .text

        cleanup:
        container.stop()

        where:
        version << [7, 8, 9, 10]
    }

}
