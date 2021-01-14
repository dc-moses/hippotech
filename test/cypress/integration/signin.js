const config = require('../hippoconfig');

describe('Signin', () => {
  it('does not allow signing in with incorrect credentials.', () => {
    cy.visit(config.baseUrl + '/signin');
    cy.get('#email').type('mtolley@synopsys.com');
    cy.get('#password').type('passwordxxx')
    cy.get('#submit-button').click();
    cy.url().should('contain', 'error');
  });

  it('allows signin with the correct credentials.', () => {
    cy.visit(config.baseUrl + '/signin');
    cy.get('#email').type('mtolley@synopsys.com');
    cy.get('#password').type('password123')
    cy.get('#submit-button').click();
    cy.contains('Get a mortgage');
  });
})