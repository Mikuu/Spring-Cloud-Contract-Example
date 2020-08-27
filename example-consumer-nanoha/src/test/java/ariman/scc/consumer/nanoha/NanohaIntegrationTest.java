package ariman.scc.consumer.nanoha;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "scc-example:example-provider:+:stubs:8080")
public class NanohaIntegrationTest {

    @Test
    public void testWithRestTemplate() throws Exception {
        Information information = new ProviderService().getInformation();

        Assertions.assertThat(information.getName()).isEqualTo("Takamachi Nanoha");
        Assertions.assertThat(information.getSalary()).isEqualTo(80000);
        Assertions.assertThat(information.getNationality()).isEqualTo("Japan");

    }
}
