package lk.usj.usjaccommodationfinder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("mock")
@ContextConfiguration(classes = {TestAppInitializer.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsjAccommodationFinderApplicationTests {

	@Test
	void contextLoads() {
	}

}
