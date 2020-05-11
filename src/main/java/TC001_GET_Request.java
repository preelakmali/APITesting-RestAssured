import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class TC001_GET_Request {

    @Test
    public void getWeatherDetails() {
        //Specify base URL
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        //Requesting a Object
        RequestSpecification httpRequest = RestAssured.given();
        //Response object
        Response response = httpRequest.request(Method.GET, "/colombo");
        //Print the Response in console window ,Normally not doing this
        //response .getBody() return with Json object hear going to convert to string
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is  : " + responseBody);

        //Status code validation is started
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :" + statusCode);
        Assert.assertEquals(statusCode, 200);

        //Status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status Line is  :" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }
}
