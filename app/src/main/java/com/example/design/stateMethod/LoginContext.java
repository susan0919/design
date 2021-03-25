package com.example.design.stateMethod;

public class LoginContext {
    private UserState userState = new Logoutstate();

    private static LoginContext loginContext = new LoginContext();

    private LoginContext() {
    }

    public static LoginContext getInstance() {
        return loginContext;
    }

    public void login() {
        userState = new LoginState();
    }

    public void logout() {
        userState = new Logoutstate();
    }

    public void pay() {
        userState.pay();
    }

    public void share() {
        userState.share();
    }

    public void editMessage() {
        userState.editMessage();
    }
}
