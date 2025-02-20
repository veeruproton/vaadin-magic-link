package com.example.crudwithvaadin;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import java.util.UUID;

@Route("/signup")
@AnonymousAllowed
public class SignupView extends VerticalLayout {

    public SignupView() {

        add(new H2("Sign up for an account with an email address"));
        TextField emailField = new TextField("Email address");
        emailField.setPlaceholder("Email address");
        add(emailField);
        Button button = new Button("Generate magic link");
        button.addClickListener(clickEvent -> {
            // Simulate token reception
            String token = receiveToken();
            // Redirect if token is received
            if (token != null) {
                redirectUser("http://localhost:8081/login/ott" + "?token=" + token);
                System.out.println("http://localhost:8081/login/ott" + "?token=" + token);
            }

            VaadinSession.getCurrent().getSession().setAttribute(
                        HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                        SecurityContextHolder.getContext());
        });
        add(button);
    }

    private String receiveToken() {
        // Generate a token
        String token = UUID.randomUUID().toString();
        VaadinSession.getCurrent().getSession().setAttribute("token", token);
        return token;
    }

    private void redirectUser(String url) {
        UI.getCurrent().getPage().setLocation(url);
    }
}
