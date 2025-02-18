package com.example.crudwithvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.textfield.TextField;

@Route("signup")
@AnonymousAllowed
public class SignupView extends VerticalLayout {

    public SignupView() {

        add(new H2("Sign up for an account with an email address"));
        TextField emailField = new TextField("Email address");
        emailField.setPlaceholder("Email address");
        add(emailField);
        add(new Button("Generate magic link"));
    }

}
