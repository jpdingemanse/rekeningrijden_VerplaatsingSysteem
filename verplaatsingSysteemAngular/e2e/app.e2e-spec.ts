import { VerplaatsingSysteemAngularPage } from './app.po';

describe('verplaatsing-systeem-angular App', function() {
  let page: VerplaatsingSysteemAngularPage;

  beforeEach(() => {
    page = new VerplaatsingSysteemAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
