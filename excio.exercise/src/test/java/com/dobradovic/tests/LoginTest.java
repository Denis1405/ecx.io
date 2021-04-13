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
    public void validLoginTest() {
        login.with("standard_user", "secret_sauce");
        login.assertValidLogin();
    }
}