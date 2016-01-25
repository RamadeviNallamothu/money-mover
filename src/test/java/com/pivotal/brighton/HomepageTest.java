package com.pivotal.brighton;

import net.codestory.simplelenium.SeleniumTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pivotal on 1/25/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoneyMoverApplication.class)
@WebIntegrationTest
public class HomepageTest extends SeleniumTest {

    @Test
    public void itContainsMessage1() {
        goTo(getDefaultBaseUrl().concat("/"));
        find("body").should().contain("404");
    }

    @Test
    public void itContainsMessage() {
        goTo(getDefaultBaseUrl().concat("/status"));
        find("body").should().contain("200");
    }


    @Override
    protected String getDefaultBaseUrl() {
        return "http://localhost:8080";
    }


}
