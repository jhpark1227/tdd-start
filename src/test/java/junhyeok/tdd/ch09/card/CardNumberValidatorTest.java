package junhyeok.tdd.ch09.card;

import junhyeok.tdd.ch07.autoDebit.CardValidity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CardNumberValidatorTest {
    /*private MockServerHttpResponse wireMockServer;

    @BeforeEach
    void setUp(){
        wireMockServer = new WireMockServer(options().port(8090));
        wireMockServer.start();
    }

    @AfterEach
    void tearDown(){
        wireMockServer.stop();
    }

    @Test
    void valid(){
        wireMockServer.stubFor(post(urlEqualTo("/card"))
                .withRequestBody(equalTo("1234567890"))
                .willReturn(aResonse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("ok")
                ));

        CardNumberValidator validator =
                new CardNumberValidator("http://localhost:8089");
        CardValidity validity = validator.validate("1234567890");
        assertEquals(CardValidity.VALID, validity);
    }

    @Test
    void timeout(){
        wireMockServer.stubFor(post(urlEqualTo("/card"))
                .willReturn(aResponse()
                        .withFixedDelay(5000))
        );
        CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
        CardValidity validity = validator.validate("1234567890");
        assertEquals(CardValidity.TIMEOUT, validity);
    }*/
}
