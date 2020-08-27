package ariman.scc.consumer.miku;

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
public class MikuIntegrationTest {

    @Test
    public void testWithRestTemplate() throws Exception {
        Information information = new ProviderService().getInformation();

        Assertions.assertThat(information.getName()).isEqualTo("Hatsune Miku");
        Assertions.assertThat(information.getNationality()).isEqualTo("Japan");

    }
}
