const config = require('../hippoconfig');

describe('Blog', () => {
  it('is accessible from the Home Page', () => {
    cy.visit(config.baseUrl);
    cy.get('#blog-button').click();
    cy.contains('All the HippoTech news that\'s fit to print!');
  });

  it('allows the user to sign up for notifications', () => {
    cy.visit(config.baseUrl + '/blog');
    cy.get('#email-address').type('test@test.com');
    cy.get('#submit-button').click();
    cy.url().should('contain', 'blog');
  });
})