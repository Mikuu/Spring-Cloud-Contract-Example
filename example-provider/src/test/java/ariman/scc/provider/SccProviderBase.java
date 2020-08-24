package ariman.scc.provider;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class SccProviderBase {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new InformationController());
    }

}
