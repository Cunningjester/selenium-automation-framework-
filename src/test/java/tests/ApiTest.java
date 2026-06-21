package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void testGetUser() {
        
        Response response = RestAssured
            .given()
                .header("Content-Type", "application/json")
            .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
            .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
        
        String name = response.jsonPath().getString("name");
        System.out.println("Name: " + name);
        
        Assert.assertNotNull(name);
    }

    @Test
    public void testCreateUser() {
        
        String requestBody = "{\n" +
            "  \"name\": \"Sandeep\",\n" +
            "  \"username\": \"sandeep123\",\n" +
            "  \"email\": \"mssandeep400@gmail.com\"\n" +
            "}";

        Response response = RestAssured
            .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .post("https://jsonplaceholder.typicode.com/users")
            .then()
                .statusCode(201)
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
        
        String name = response.jsonPath().getString("name");
        System.out.println("Created user name: " + name);
        
        Assert.assertEquals(name, "Sandeep");
    }
}
