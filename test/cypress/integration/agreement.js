const config = require('../hippoconfig');

describe('Agreement', () => {
  it('can be requested by user.', () => {
    cy.login();
    cy.get('#agreement-button').click();
    cy.url().should('contain', 'agreement');
    cy.get('#propertyPostCode').type('PL10 222');
    cy.get('#propertyValue').type('250000');
    cy.get('#amountToBorrow').type('150000');
    cy.get('#about').type('Nothing to add - it looks great!');
    cy.get('#firstName').type('Scott');
    cy.get('#lastName').type('Tolley');
    cy.get('#nationalInsuranceNumber').type('JJ1234');
    cy.get('#streetAddress').type('10 Portland St');
    cy.get('#city').type('London');
    cy.get('#postCode').type('SE1 9SQ');
    cy.get('#changes').click();
    cy.get('#pushNothing').click();
    cy.get('#submit-button').click();
    
    cy.contains('got your request!');
  });
})