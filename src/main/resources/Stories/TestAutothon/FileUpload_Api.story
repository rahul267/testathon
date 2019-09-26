Meta:

Narrative:
As a user I have to upload a file to the given URL

Scenario: upload a file as an multi-part
When I make post request to  <service> with fields like <upfile>,<note> values
Then validate the status code is <statusCode>
Examples:
|service|upfile|note|statusCode|
|https://cgi-lib.berkeley.edu/ex/fup.cgi|D:\TestAutoThon\testathon\src\main\resources\data.json|test-123|200|


