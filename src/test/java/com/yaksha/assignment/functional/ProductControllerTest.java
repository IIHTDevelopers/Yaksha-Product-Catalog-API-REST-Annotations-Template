package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.controller.ProductController;
import com.yaksha.assignment.utils.JavaParserUtils;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetProductById() throws Exception {
		// Perform GET request to /products/{id} endpoint and capture the response
		String response = mockMvc.perform(get("/products/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		// Assert using YakshaAssert that the response contains expected values
		boolean result = response.contains("\"id\":1");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testCreateProduct() throws Exception {
		// Create a new product JSON object
		String productJson = "{\"id\":3,\"name\":\"Product X\",\"category\":\"Gadgets\",\"price\":200}";

		// Perform POST request to create the new product
		String response = mockMvc
				.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content(productJson))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		// Assert using YakshaAssert that the response contains expected values
		boolean result = response.contains("\"id\":3") && response.contains("\"name\":\"Product X\"")
				&& response.contains("\"category\":\"Gadgets\"");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testUpdateProduct() throws Exception {
		// Create a new product JSON object to update an existing product
		String productJson = "{\"id\":1,\"name\":\"Updated Product\",\"category\":\"Updated Category\",\"price\":250}";

		// Perform PUT request to update the product with ID 1
		String response = mockMvc
				.perform(put("/products/1").contentType(MediaType.APPLICATION_JSON).content(productJson))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		// Assert using YakshaAssert that the response contains updated values
		boolean result = response.contains("\"id\":1") && response.contains("\"name\":\"Updated Product\"")
				&& response.contains("\"category\":\"Updated Category\"");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testRestControllerAnnotation() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the class is annotated with @RestController
		boolean result = JavaParserUtils.checkClassAnnotation(filePath, "RestController");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testReturnTypeOfGetProduct() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the getProduct method has the correct return type (Product)
		boolean result = JavaParserUtils.checkMethodReturnType(filePath, "getProduct", "Product");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetProductAnnotation() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the getProduct method has @GetMapping annotation with value "/{id}"
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getProduct", "GetMapping")
				&& JavaParserUtils.checkMethodParameterAnnotation(filePath, "getProduct", "id", "PathVariable");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetAllProductsAnnotation() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the getAllProducts method has @GetMapping annotation
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getAllProducts", "GetMapping");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testCreateProductAnnotation() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the createProduct method has @PostMapping annotation
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "createProduct", "PostMapping");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testUpdateProductAnnotation() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the updateProduct method has @PutMapping annotation with value
		// "/{id}"
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "updateProduct", "PutMapping")
				&& JavaParserUtils.checkMethodParameterAnnotation(filePath, "updateProduct", "id", "PathVariable");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testDeleteProductAnnotation() throws Exception {
		// Specify the file path to the ProductController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/ProductController.java"; // Update path to
																									// your controller

		// Check if the deleteProduct method has @DeleteMapping annotation with value
		// "/{id}"
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "deleteProduct", "DeleteMapping")
				&& JavaParserUtils.checkMethodParameterAnnotation(filePath, "deleteProduct", "id", "PathVariable");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

}
