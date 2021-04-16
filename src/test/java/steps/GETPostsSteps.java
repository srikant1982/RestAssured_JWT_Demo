package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import model.Address;
import model.Location;
import model.LoginBody;
import utilities.APIConstant;
import utilities.EARestAssuredV2;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GETPostsSteps {


    public static ResponseOptions<Response> response;
    public static String token;

    @Given("^I perform authentication operation for \"([^\"]*)\" with body$")
    public void iPerformAuthenticationOperationForWithBody(String url, DataTable table) throws Throwable {

        var data = table.raw();

        LoginBody loginBody = new LoginBody();
        loginBody.setEmail(data.get(1).get(0));
        loginBody.setPassword(data.get(1).get(1));

        EARestAssuredV2 eaRestAssuredV2 = new EARestAssuredV2(url, APIConstant.ApiMethods.POST, token);

        token = eaRestAssuredV2.Authenticate(loginBody);
    }

    @And("^I perform GET operation with path parameter for address \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterForAddress(String url, DataTable table) throws Throwable {
        var data = table.raw();

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", data.get(1).get(0));

        EARestAssuredV2 eaRestAssuredV2 = new EARestAssuredV2(url,APIConstant.ApiMethods.GET,token);
        response = eaRestAssuredV2.ExecuteWithQueryParams(queryParams);
    }

    @Then("^I should see the street name as \"([^\"]*)\"$")
    public void iShouldSeeTheStreetNameAs(String streetName) throws Throwable {

        var a = response.getBody().as(Location[].class);
        Address address = a[0].getAddress().stream().filter(x -> x.getType().equalsIgnoreCase("primary")).findFirst().orElse(null);
        assertThat(address.getStreet(), equalTo(streetName));
    }
}
