package com.serene.tests.features.steps;

import com.serene.tests.features.Entity.Content;
import com.serene.tests.features.Entity.ResponseData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class PetAPISteps {

    private Response res = null; //Response
    private JsonPath jp = null; //JsonPath
    private RequestSpecification requestSpec;

    @Step
    public void buildRequestGetPetByID(String petID) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBasePath(petID);
        builder.setContentType("application/json");
//        System.out.println("{\"username\":\""+petID+"\",\"password\": \""+petID+"\"}");
//        builder.setBody("{\"petID\":\""+petID+"\"}");
        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        requestSpec.log().all();

    }

    @Step
    public void sendGetPetByIDRequest() {
        RequestSpecification requestSpec2= RestAssured.given();
        res = requestSpec.when().get();
        System.out.println("res ====>");
        System.out.println(res.toString());
        String responseBody = requestSpec.get("/").getBody().asString();
        String responseBody2 = requestSpec2.get("/endpoint").getBody().asString();
        System.out.println("responseBody: =====================>");
        System.out.println(responseBody);
        System.out.println("responseBody: <=====================");
        System.out.println(requestSpec2);
    }

    @Step
    public  void test(){
        Assert.assertEquals("Status check test oke",'a','a');

    }

    @Step
    public void verifyGetPetByIDSuccess() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Chuyển đổi JSON thành đối tượng Java
            ResponseData responseData = objectMapper.readValue(new File("C:\\selenium\\cucumberApi\\src\\test\\java\\com\\serene\\tests\\features\\dataJson\\data.json"), ResponseData.class);

            // Sử dụng đối tượng Java đã chuyển đổi
            Content content = responseData.getContent();
            String[] list = content.getList();
            int totalRecord = content.getTotalRecord();
            int currentPage = content.getCurrentPage();
            String warning = content.getWarning();

            // In ra các giá trị
            System.out.println("List: " + Arrays.toString(list));
            System.out.println("Total Record: " + totalRecord);
            System.out.println("Current Page: " + currentPage);
            System.out.println("Warning: " + warning);
        } catch (IOException e) {
            e.printStackTrace();
        }

        jp = res.jsonPath();
        Assert.assertEquals("Status Check Failed!", 400, res.getStatusCode());
    }




    @Step
    public void buildRequestCreatePet(String petID, String petName, String petStatus) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        // builder.setBasePath();
        builder.setContentType("application/json");
        //System.out.println("{\"username\":\""+username+"\",\"password\": \""+password+"\"}");
        builder.setBody("{\"id\":\"" + petID + "\", \"name\":\"" + petName + "\" , \"status\":\"" + petStatus + "\"}");
        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        requestSpec.log().all();

    }

    @Step
    public void sendPostCreatePetRequest() {
        res = requestSpec.when().post();
    }

    @Step
    public void verifyCreatePetSuccess() {
        jp = res.jsonPath();

        Assert.assertEquals("Status Check Failed!eeee", 200, res.getStatusCode());

    }

}


