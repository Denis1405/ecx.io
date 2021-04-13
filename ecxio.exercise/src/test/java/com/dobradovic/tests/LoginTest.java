package com.dobradovic.tests;

import org.junit.Before;
import org.junit.Test;
import com.dobradovic.pages.Login;

public class LoginTest {
    Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    @Test
    public void correctLoginTest() {
        login.with("standard_user", "secret_sauce");
        login.assertValidLogin();
    }

    @Test
    public void performanceLoginTest() {
        login.with("performance_glitch_user", "secret_sauce");
        login.assertValidLogin();
    }

    @Test
    public void invalidLoginTest() {
        login.with("locked_out_user","secret_sauce");
        login.assertInValidLogin("locked_out_user");
        login.with("problem_user","secret_sauce");
        login.assertInValidLogin("problem_user");
    }
}