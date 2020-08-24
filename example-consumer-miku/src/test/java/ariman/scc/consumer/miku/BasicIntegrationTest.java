package ariman.scc.consumer.miku;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Line;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "example:example-provider:+:stubs:8080")
public class BasicIntegrationTest {

//    @Autowired
//    private MockMvc mockMvc;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Test
//    public void basicTest()
//            throws Exception {
//
//        System.out.println("Sleeping -------------------------------------------------------> ");
//        Thread.sleep(1000*60*10);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/information")
//                .queryParam("name", "Miku")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Hatsune Miku"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nationality").value("Japan"));
//    }

    @Test
    public void testWithRestTemplate() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

//        ResponseEntity<Information> response =
//                restTemplate.getForEntity("http://localhost:8080/information?name=Miku", Information.class);
//        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(response.getBody().getName()).isEqualTo("Hatsune Miku");
//        Assertions.assertThat(response.getBody().getNationality()).isEqualTo("Japan");

//        Information information =
//                restTemplate.getForObject("http://localhost:8080/information?name=Miku", Information.class);

        Information information = new ProviderService().getInformation();

        Assertions.assertThat(information.getName()).isEqualTo("Hatsune Miku");
        Assertions.assertThat(information.getNationality()).isEqualTo("Japan");

    }
}
