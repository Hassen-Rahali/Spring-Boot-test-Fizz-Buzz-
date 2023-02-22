package partie3.test.sprinbootapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenInputIsThree_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/3";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsFive_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/5";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsFifteen_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\",\"Fizz\",\"7\",\"8\",\"Fizz\",\"Buzz\",\"11\",\"Fizz\",\"13\",\"14\",\"FizzBuzz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/15";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsNegativeNumber_thenReturnsBadRequest() {
        String url = "http://localhost:" + port + "/fizzbuzz/-1";
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void whenInputIsZero_thenReturnsEmptyList() {
        String expectedOutput = "[]";
        String url = "http://localhost:" + port + "/fizzbuzz/0";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsLargeNumber_thenReturnsCorrectList() {
        String expectedOutput = "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\",\"Fizz\",\"7\",\"8\",\"Fizz\",\"Buzz\",\"11\",\"Fizz\",\"13\",\"14\",\"FizzBuzz\",\"16\",\"17\",\"Fizz\",\"19\",\"Buzz\",\"Fizz\",\"22\",\"23\",\"Fizz\",\"Buzz\",\"26\",\"Fizz\",\"28\",\"29\",\"FizzBuzz\",\"31\",\"32\",\"Fizz\",\"34\",\"Buzz\",\"Fizz\",\"37\",\"38\",\"Fizz\",\"Buzz\",\"41\",\"Fizz\",\"43\",\"44\",\"FizzBuzz\",\"46\",\"47\",\"Fizz\",\"49\",\"Buzz\",\"Fizz\",\"52\",\"53\",\"Fizz\",\"Buzz\",\"56\",\"Fizz\",\"58\",\"59\",\"FizzBuzz\",\"61\",\"62\",\"Fizz\",\"64\",\"Buzz\",\"Fizz\",\"67\",\"68\",\"Fizz\",\"Buzz\",\"71\",\"Fizz\",\"73\",\"74\",\"FizzBuzz\",\"76\",\"77\",\"Fizz\",\"79\",\"Buzz\",\"Fizz\",\"82\",\"83\",\"Fizz\",\"Buzz\",\"86\",\"Fizz\",\"88\",\"89\",\"FizzBuzz\",\"91\",\"92\",\"Fizz\",\"94\",\"Buzz\",\"Fizz\",\"97\",\"98\",\"Fizz\",\"Buzz\"]";
        String url = "http://localhost:" + port + "/fizzbuzz/100";
        String actualOutput = this.restTemplate.getForObject(url, String.class);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void whenInputIsNonNumeric_thenReturnsBadRequest() {
        String url = "http://localhost:" + port + "/fizzbuzz/abc";
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}

