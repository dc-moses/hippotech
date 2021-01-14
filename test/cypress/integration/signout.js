const config = require('../hippoconfig');

describe('Signin', () => {
  it('is possible after signing in', () => {
    cy.login();
    cy.get('#signout').click();
    cy.contains('Sign in');
  });
})