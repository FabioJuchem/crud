package br.com.fabio;

import br.com.fabio.crud.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
