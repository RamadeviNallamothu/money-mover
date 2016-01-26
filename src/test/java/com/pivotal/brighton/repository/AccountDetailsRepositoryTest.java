package com.pivotal.brighton.repository;

import net.codestory.simplelenium.SeleniumTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pivotal.brighton.MoneyMoverApplication;

/**
 * Created by pivotal on 1/26/16.
 */

@WebIntegrationTest
public class AccountDetailsRepositoryTest extends SeleniumTest {


    /*@Test
    public void itContainsMessage() {
        goTo(getDefaultBaseUrl().concat("/accounts/11111"));
        find("body").should().contain("1111");
    }*/

    @Override
    protected String getDefaultBaseUrl() {
        return "http://localhost:8080/staus";
    }


}
