package com.pivotal.brighton.repository;

import com.pivotal.brighton.MoneyMoverApplication;
import net.codestory.simplelenium.SeleniumTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pivotal on 1/26/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoneyMoverApplication.class)
@WebIntegrationTest
public class AccountDetailsRepositoryTest extends SeleniumTest {



    @Override
    protected String getDefaultBaseUrl() {
        return "http://localhost:8080";
    }
}
