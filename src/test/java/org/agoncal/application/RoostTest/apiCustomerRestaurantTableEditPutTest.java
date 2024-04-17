// ********RoostGPT********
/*
Test generated by RoostGPT for test ZBIO-4963-Rest-assured-errors-testing using AI Type Open AI and AI Model gpt-4

Test generated for /api/customer/restaurantTable/edit_put for http method type PUT in rest-assured framework

RoostTestHash=905dfcdcfd


*/

// ********RoostGPT********
package org.agoncal.application.RoostTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class apiCustomerRestaurantTableEditPutTest {

	List<Map<String, String>> envList = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		TestdataLoader dataloader = new TestdataLoader();
		String[] envVarsList = { "" };
		envList = dataloader.load(
				"src\\test\\java\\org\\agoncal\\application\\RoostTest\\api_customer_restaurantTable_editPutTest.csv",
				envVarsList);
	}

	@Test
	public void apiCustomerRestaurantTableEditPut_Test() throws JSONException {
		this.setUp();
		Integer testNumber = 1;
		for (Map<String, String> testData : envList) {
			RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty())
					? testData.get("BASE_URL") : "https://virtserver.swaggerhub.com/VOK/Payfix/1.2.14";

			Response responseObj = given()
				.queryParam("company", testData.get("company") != null ? testData.get("company") : "")
				.queryParam("tableId", testData.get("tableId") != null ? testData.get("tableId") : "")
				.queryParam("number", testData.get("number") != null ? testData.get("number") : "")
				.queryParam("name", testData.get("name") != null ? testData.get("name") : "")
				.when()
				.put("/api/customer/restaurantTable/edit")
				.then()
				.extract()
				.response();
			JsonPath response;
			String contentType = responseObj.getContentType();

			System.out.printf("Test Case %d: apiCustomerRestaurantTableEditPut_Test \n", testNumber++);
			System.out.println("Request: PUT /api/customer/restaurantTable/edit");
			System.out.println("Status Code: " + responseObj.statusCode());
			if (testData.get("statusCode") != null) {
				MatcherAssert.assertThat(responseObj.statusCode(),
						equalTo(Integer.parseInt(testData.get("statusCode"))));
			}
			else {
				List<Integer> expectedStatusCodes = Arrays.asList(200);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
			}

			switch (responseObj.statusCode()) {

				case 200:

					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

			}

			if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
				String xmlResponse = responseObj.asString();
				JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
				JSONObject jsonData = jsonResponse.getJSONObject("xml");
				String jsonString = jsonData.toString();
				response = new JsonPath(jsonString);

			}
			else if (contentType.contains("application/json")) {
				response = responseObj.jsonPath();
			}
			else {
				System.out.println("Response content type found: " + contentType
						+ ", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
				continue;
			}

			if (responseObj.statusCode() == 200) {
				System.out.println("Description: Edit new Restaurant Table");

				if (response.get("id") != null) {
					MatcherAssert.assertThat(response.get("id"), instanceOf(Integer.class));
				}

				if (response.get("external_id") != null) {
					MatcherAssert.assertThat(response.get("external_id"), instanceOf(String.class));
				}

				if (response.get("number") != null) {
					MatcherAssert.assertThat(response.get("number"), instanceOf(String.class));
				}

				if (response.get("name") != null) {
					MatcherAssert.assertThat(response.get("name"), instanceOf(String.class));
				}

				if (response.get("restaurant_table_group_id") != null) {
					MatcherAssert.assertThat(response.get("restaurant_table_group_id"), instanceOf(Integer.class));
				}

				if (response.get("updated_at") != null) {
					MatcherAssert.assertThat(response.get("updated_at"), instanceOf(String.class));
				}

				if (response.get("created_at") != null) {
					MatcherAssert.assertThat(response.get("created_at"), instanceOf(String.class));
				}
			}

		}
	}

}
