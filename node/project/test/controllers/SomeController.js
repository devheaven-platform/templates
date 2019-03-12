const chai = require('chai');

chai.should();

describe('SomeController', () => {
    it('should do something', async() => {
        const string = 'name';
        string.should.be.equal('name');
    });
});