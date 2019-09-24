Scenario: Validate all page details
When I make a get request to get Eventpage details for eventId
Then validate the status code is statusCode
And validate the response having type,title,eventTitle,eventUrl,eventDate,isPast
Examples:
|eventId|statusCode|type|title|eventTitle|eventUrl|eventDate|isPast|
|EVENT_ID|200|Main|title|Title_Name|https://autorqa.events.epam.com/events/| 1 Aug 2019|false|
