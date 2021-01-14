const config = require('../hippoconfig');

describe('Home Page', () => {
  it('displays correctly', () => {
    cy.visit(config.baseUrl);
    cy.contains("Get a mortgage!");
    cy.contains("Blog");
  });

  it('provides sign in.', () => {
    cy.visit(config.baseUrl);
    cy.get("#signin").click();
    cy.url().should('contain', 'signin');
  });
})
