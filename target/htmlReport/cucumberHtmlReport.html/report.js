$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ComplexDataGET.feature");
formatter.feature({
  "line": 1,
  "name": "ComplexDataGet",
  "description": "",
  "id": "complexdataget",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify GET operation for complex data",
  "description": "",
  "id": "complexdataget;verify-get-operation-for-complex-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I perform authentication operation for \"/auth/login\" with body",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ],
      "line": 5
    },
    {
      "cells": [
        "srikantpanda@email.com",
        "srikantpanda"
      ],
      "line": 6
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I perform GET operation with path parameter for address \"/location/\"",
  "rows": [
    {
      "cells": [
        "id"
      ],
      "line": 8
    },
    {
      "cells": [
        "1"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I should see the street name as \"1st street\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/auth/login",
      "offset": 40
    }
  ],
  "location": "GETPostsSteps.iPerformAuthenticationOperationForWithBody(String,DataTable)"
});
formatter.result({
  "duration": 1706074771,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/location/",
      "offset": 57
    }
  ],
  "location": "GETPostsSteps.iPerformGETOperationWithPathParameterForAddress(String,DataTable)"
});
formatter.result({
  "duration": 39475846,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1st street",
      "offset": 33
    }
  ],
  "location": "GETPostsSteps.iShouldSeeTheStreetNameAs(String)"
});
formatter.result({
  "duration": 93771727,
  "status": "passed"
});
});