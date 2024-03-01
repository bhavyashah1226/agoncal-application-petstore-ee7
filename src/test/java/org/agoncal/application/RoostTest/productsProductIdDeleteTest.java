// ********RoostGPT********
/*
Test generated by RoostGPT for test ZBIO-4912-Rest-Assured-Testing using AI Type Open AI and AI Model gpt-4

Test generated for /products/{productId}_delete for http method type DELETE in rest-assured framework

RoostTestHash=47d9fe845f


*/

// ********RoostGPT********

package org.agoncal.application.RoostTest;
// ...
import org.junit.jupiter.api.BeforeEach; // Changed from JUnit 4 to JUnit 5
import org.agoncal.application.TestdataLoader; // Assuming this is the correct package

public class productsProductIdDeleteTest {
// ...
    @BeforeEach // Changed from @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/org/agoncal/application/RoostTest/products_productIdDeleteTest.csv");
    }

    @Test  
    public void productsProductIdDelete_Test() {
        this.setUp();
        for (Map<String, String> map : envList) {
          RestAssured.baseURI = map.get("BASE_URL");  
  
            Response response = given()
				.pathParam("productId", map.get("productId") != null ? map.get("productId") : "")
                .when()
                .delete("/products/{productId}")  
                .then() 
                .extract().response();    
         
            // Added else if to handle other status codes
            if (response.statusCode() == 200) {
                System.out.println("Description: Product deleted");
            } else if (response.statusCode() == 404) {
                System.out.println("Description: Not Found");
            } else {
                System.out.println("Description: Unexpected status code " + response.statusCode());
            }
        }  
    }
}
