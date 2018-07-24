package glue.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.WaitTool;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.ContactPage;
import pages.HomePage;
import pages.Search;
import pages.SearchResults;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyStepdefs extends Browser {


    private static String url;
    private static String endpoint;
    private static Response response;


    @Given("^browser \"([^\"]*)\" with remote address: \"([^\"]*)\"$")
    public void browserWithRemoteAddress(String browserName, String address) throws Throwable {
        openRemoteWebDriver(browserName, address);
    }

    @Given("^browser \"([^\"]*)\"$")
    public void browser(String browserName) throws Throwable {
        openLocalWebDriver(browserName);
    }

    @And("^website loaded this address: \"([^\"]*)\"$")
    public void websiteLoadedThisAddress(String url) throws Throwable {
        driver.get(url);
    }

    @When("^I execute a search for \"([^\"]*)\"$")
    public void iExecuteASearchFor(String textForSearching) throws Throwable {
        Search searchInStore = new Search();
        searchInStore.searchInStore(textForSearching);
    }

    //    @After
    public void tearDown() {
        driver.close();
    }

    @Then("^I should expect there is a result$")
    public void iShouldExpectThereIsAResult() throws Throwable {
        SearchResults searchResults = new SearchResults();
        searchResults.verifyResults();
    }

    @Then("^I should verify all buttons$")
    public void iShouldVerifyAllButtons() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.verifyAllButons();
    }


    @Given("^base url: \"([^\"]*)\"$")
    public void baseUrl(String baseUrl) throws Throwable {
        this.url = baseUrl;
    }

    @And("^endpoint: \"([^\"]*)\"$")
    public void endpoint(String endpoint) throws Throwable {
        this.endpoint = endpoint;
    }

    @When("^I made a call$")
    public void iMadeACall() throws Throwable {
//        https://airtube.info/api/get_data_current.php?location_id=3129
        response = RestAssured.given().get(this.url + this.endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("^I should receive data$")
    public void iShouldReceiveData() throws Throwable {
        ArrayList<ArrayList> spisuk = response.jsonPath().get("sensordatavalues");
        response.prettyPrint();
        /*int i = 0;
        for (ArrayList a : spisuk) {
            Map map = (Map) a.get(i);
            String value = map.get("value").toString();
            String valueType = map.get("value_type").toString();
            System.out.println("Stoinostta na prahovite cahstici "+valueType+": " + value);
            i++;
        }*/
    }

    @Then("^I should receive data for my repos$")
    public void iShouldReceiveDataForMyRepos() throws Throwable {
        response.prettyPrint();
    }

    @Given("^url \"([^\"]*)\"$")
    public void url(String baseUrl) throws Throwable {
        this.url = baseUrl;

    }

    @And("^with endpoint \"([^\"]*)\"$")
    public void withEndpoint(String endpoint) throws Throwable {
        this.endpoint = endpoint;
    }

    @When("^i submit get request$")
    public void iSubmitGetRequest() throws Throwable {
        this.response = RestAssured.given().get(this.url + this.endpoint);

    }

    @Then("^i should get status (\\d+)$")
    public void iShouldGetStatus(int statusCode) throws Throwable {
        Assert.assertEquals(response.getStatusCode(), statusCode);
        response.prettyPrint();
//       ArrayList data = response.getBody().jsonPath().get("page");
//        for (Object map : data) {
//            System.out.println(((Map) map).get("avatar"));

    }

    @When("^i submit post request$")
    public void iSubmitPostRequest() throws Throwable {
        String body = "{\n" +
                " \"name\": \"morpheus\",\n" +
                " \"job\": \"leader\"n" +
                "}";
 Header header = new Header("", "");
        response = RestAssured.given().baseUri(this.url + this.endpoint).contentType("aplication/json").header(header).when().post(body);

    }

    @Given("^contactURL https://progressbg.net/$")
    public void contacturlHttpsProgressbgNet(String contactURL) throws Throwable {
       this.url = contactURL;
    }

    @And("^click on contacts$")
    public void clickOnContacts() throws Throwable {
        ContactPage contactPage = new ContactPage();
        contactPage.clickOnContacts();

    }

    @And("^verify contact title is displayed$")
    public void verifyContactTitleIsDisplayed() throws Throwable {
        ContactPage contactPage = new ContactPage();
        contactPage.verifyButtons();
    }

    @And("^click on partners$")
    public void clickOnPartners() throws Throwable {
             ContactPage contactPage = new ContactPage();
             contactPage.clickOnPartners();
    }

    @And("^verify partners title is displayed$")
    public void verifyPartnersTitleIsDisplayed() throws Throwable {
        ContactPage contactPage = new ContactPage();
        contactPage.verifyPartnersTitleIsDisplayed();
    }
}

