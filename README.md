# vaadin-magic-link
MagicLink based security 



This is a Vaadin, SpringBoot project.

- There are 2 Vaadin views : MainView (Route is "") and SignupView (Route is "/signup").
- For an unathenticaed user, localhost:8080 should redirect to "localhost:8080/signup".

- Here on the SignupView, user enters their email address and clicks the "Generate Magic Link" button.
- This generates a link like "localhost:8080/login/ott?token=1dae1fee-58c4-4462-a1fb-bff3a259d05d".
- Clicking on the link should validate the token,
  - if valid, user should be redirected to MainView,
  - else, navigate back to SignupView
