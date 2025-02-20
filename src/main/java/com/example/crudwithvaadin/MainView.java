package com.example.crudwithvaadin;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

@Route("/home")
@PermitAll
public class MainView extends VerticalLayout {

	public MainView() {

		String userName = "Not Logged In User";

		add(new H2("Home page"));
		add(new H3("Welcome " + userName + "!"));
		add(new H3("You should only see this page if you are logged in"));

	}
}