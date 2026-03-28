# Test Suite Documentation

This document provides an overview of the test suite structure and explains the test coverage for contributors.

## Overview

The project contains **37 tests** distributed across 4 test classes, each serving a specific purpose in the testing pyramid:

```
┌─────────────────────────────────────────┐
│     ShopwaveStarterApplicationTests     │  ← 1 test (Integration)
├─────────────────────────────────────────┤
│          ProductServiceTest             │  ← 12 tests (Unit - Service Layer)
├─────────────────────────────────────────┤
│        ProductControllerTest            │  ← 11 tests (Unit - Controller Layer)
├─────────────────────────────────────────┤
│         ProductRepositoryTest           │  ← 12 tests (Integration - Repository)
└─────────────────────────────────────────┘
```


## Test Classes

### 1. ShopwaveStarterApplicationTests
**Location:** `src/test/java/com/shopwave/shopwavestarter/ShopwaveStarterApplicationTests.java`

**Annotation:** `@SpringBootTest`

**Purpose:** Smoke test to verify the entire Spring Boot application context loads successfully.

**Tests:**
- `contextLoads()` - Verifies the application starts without errors

---

### 2. ProductServiceTest
**Location:** `src/test/java/com/shopwave/ProductServiceTest.java`

**Annotation:** `@ExtendWith(MockitoExtension.class)`

**Purpose:** Unit tests for the business logic layer using Mockito to mock dependencies.

**Dependencies Mocked:**
- `ProductRepository`
- `CategoryRepository`
- `ProductMapper`

**Tests (12 total):**

| Test Method | Description |
|-------------|-------------|
| `testCreateProduct` | Happy path: create product with valid category |
| `testCreateProductWithoutCategory` | Creates product without category (category is optional) |
| `testGetAllProducts` | Returns paginated products |
| `testGetProductById` | Returns product by ID when exists |
| `testGetProductByIdNotFound` | Throws ProductNotFoundException when not found |
| `testSearchProducts` | Search products by keyword |
| `testSearchProductsByMaxPrice` | Search products by max price |
| `testSearchProductsWithKeywordAndMaxPrice` | Combined search with both parameters |
| `testUpdateStock` | Successfully increase stock |
| `testUpdateStockNegative` | Throws IllegalArgumentException when stock would go negative |
| `testUpdateStockDecrease` | Successfully decrease stock |
| `testUpdateStockProductNotFound` | Throws ProductNotFoundException when product doesn't exist |



### 3. ProductControllerTest
**Location:** `src/test/java/com/shopwave/ProductControllerTest.java`

**Annotation:** `@WebMvcTest(ProductController.class)` with `@Import(GlobalExceptionHandler.class)` and `@TestPropertySource`

**Purpose:** Unit tests for the REST controller layer using MockMvc to test HTTP endpoints without starting a full server.

**Configuration:**
- Excludes DataSource and JPA auto-configuration via `@TestPropertySource`
- Uses a nested TestConfig class with `@SpringBootApplication`
- Mocks the `ProductService` dependency

**Tests (11 total):**

| Test Method | HTTP Method | Endpoint | Expected Status | Description |
|-------------|-------------|----------|-----------------|-------------|
| `testGetAllProducts` | GET | `/api/products` | 200 | Returns paginated product list |
| `testGetProductById` | GET | `/api/products/{id}` | 200 | Returns product by ID |
| `testGetProductByIdNotFound` | GET | `/api/products/999` | 404 | Returns 404 for non-existent product |
| `testCreateProduct` | POST | `/api/products` | 201 | Creates new product |
| `testCreateProductValidationError` | POST | `/api/products` | 400 | Returns 400 for validation errors |
| `testSearchProducts` | GET | `/api/products/search?keyword=` | 200 | Search by keyword |
| `testSearchProductsByMaxPrice` | GET | `/api/products/search?maxPrice=` | 200 | Search by max price |
| `testSearchProductsNoResults` | GET | `/api/products/search` | 200 | Returns empty list |
| `testUpdateStock` | PATCH | `/api/products/{id}/stock` | 200 | Update stock successfully |
| `testUpdateStockMissingDelta` | PATCH | `/api/products/{id}/stock` | 400 | Returns 400 when delta is missing |
| `testUpdateStockNegativeResult` | PATCH | `/api/products/{id}/stock` | 400 | Returns 400 for negative stock result |
| `testUpdateStockProductNotFound` | PATCH | `/api/products/999/stock` | 404 | Returns 404 for non-existent product |



### 4. ProductRepositoryTest
**Location:** `src/test/java/com/shopwave/ProductRepositoryTest.java`

**Annotation:** `@SpringBootTest` with `WebEnvironment.RANDOM_PORT`

**Purpose:** Integration tests for the repository layer using the actual Spring context with an embedded database.

**Features:**
- Uses the full Spring Boot application context
- Uses the configured database (H2 in-memory for test profile)
- Automatically configures EntityManager and transaction management
- Cleans up data before each test via `@BeforeEach`

**Tests (12 total):**

| Test Method | Description |
|-------------|-------------|
| `testFindByCategoryId` | Find products by category ID |
| `testFindByPriceLessThanEqual` | Find products with price <= specified value |
| `testFindByNameContainingIgnoreCase` | Case-insensitive name search |
| `testFindTopByOrderByPriceDesc` | Find highest priced product |
| `testSaveProduct` | Persist new product to database |
| `testUpdateProduct` | Update existing product |
| `testDeleteProduct` | Remove product from database |
| `testFindAll` | Retrieve all products |
| `testFindByNonExistentCategory` | Returns empty list for non-existent category |
| `testFindByPriceLessThanEqualNoResults` | Returns empty list when no products match |
| `testProductCategoryRelationship` | Verify bidirectional relationship between Product and Category |



## Running the Tests

### Run all tests:
```bash
mvn test
```

### Run specific test class:
```bash
mvn test -Dtest=ProductServiceTest
```

### Run specific test method:
```bash
mvn test -Dtest=ProductControllerTest#testGetAllProducts
```

### Generate test report:
```bash
mvn surefire-report:report
```


## Testing Best Practices

1. **Unit Tests (ProductServiceTest):** Focus on business logic, use mocks for dependencies
2. **Controller Tests (ProductControllerTest):** Focus on HTTP contract, request/response handling
3. **Repository Tests (ProductRepositoryTest):** Focus on database queries and relationships
4. **Integration Tests (ShopwaveStarterApplicationTests):** Verify the application starts correctly



## Adding New Tests

When adding new functionality:

1. Add corresponding tests to the appropriate test class
2. Follow the naming convention: `test<MethodName><Scenario>`
3. Include both happy path and error path tests
4. Update this documentation with new test details