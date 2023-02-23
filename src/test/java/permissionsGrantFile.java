import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class permissionsGrantFile {
    @Test
    //проверка валидного запроса
    public void folderFilesPutValid(){
        String responseBody = "{\"uuid\": \"succes\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"OK");
    }
    @Test
    //проверка на обязательность параметра uuid
    public void folderFilesPutUuidRequired(){
        String responseBody = "{\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("uuid"));
    }
    @Test
    //проверка на обязательность параметра permissions
    public void folderFilesPutPermissionsRequired(){
        String responseBody = "{\"uuid\": \"succes\",\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("permissions"));
    }
    @Test
    //проверка на обязательность параметра serviceTo
    public void folderFilesPutServiceToRequired(){
        String responseBody = "{\"uuid\": \"succes\",\"permissions\": [\"ACQUIRE\"]}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("serviceTo"));
    }
    @Test
    //проверка при получении 503 кода
    public void folderFilesPut503(){
        String responseBody = "{\"uuid\": \"error503\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("503"));
    }
    @Test
    //проверка при получении 504 кода
    public void folderFilesPut504(){
        String responseBody = "{\"uuid\": \"error504\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("504"));
    }
    @Test
    //проверка при получении 400 кода
    public void folderFilesPut400(){
        String responseBody = "{\"uuid\": \"error400\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("400"));
    }
    @Test
    //проверка при получении 401 кода
    public void folderFilesPut401(){
        String responseBody = "{\"uuid\": \"error401\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),401);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Unauthorized");
        Assertions.assertTrue(responseDescription.contains("401"));
    }
    @Test
    //проверка при получении 403 кода
    public void folderFilesPut403(){
        String responseBody = "{\"uuid\": \"error403\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),403);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Forbidden");
        Assertions.assertTrue(responseDescription.contains("403"));
    }
    @Test
    //проверка при получении 404 кода
    public void folderFilesPut404(){
        String responseBody = "{\"uuid\": \"error404\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"DataNotFound");
        Assertions.assertTrue(responseDescription.contains("404"));
    }
    @Test
    //проверка при получении 500 кода
    public void folderFilesPut500(){
        String responseBody = "{\"uuid\": \"error500\",\"permissions\": [\"ACQUIRE\"],\"serviceTo\": \"string\"}";
        Response response= new salpIntegrationTsec().permissionsGrantFile(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("500"));
    }

}
