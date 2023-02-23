import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class permissionAcquiresFiles {

    @Test
    //проверка валидного запроса
    public void permissionsAcquireFilesValid(){
        String responseBody = "{\"uuids\": [\"succes\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"OK");

    }
    @Test
    //проверка кривого запроса
    public void permissionsAcquireFilesRequestError(){
        String responseBody = "";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"RequestError");
//        Assertions.assertTrue(responseDescription.contains("uuids"));
    }
    @Test
    //проверка обязательности параметра uuid
    public void permissionsAcquireFilesUuidsRequired(){
        String responseBody = "{}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("uuids"));
    }
    @Test
    //проверка приполучении 503 кода http
    public void permissionsAcquireFiles503(){
        String responseBody = "{\"uuids\": [\"error503\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("503"));
    }
    @Test
    //проверка приполучении 503 кода http
    public void permissionsAcquireFiles504(){
        String responseBody = "{\"uuids\": [\"error504\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("504"));
    }

    @Test
    //проверка приполучении 400 кода http
    public void permissionsAcquireFiles400(){
        String responseBody = "{\"uuids\": [\"error400\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("400"));
    }

    @Test
    //проверка приполучении 401 кода http
    public void permissionsAcquireFiles401(){
        String responseBody = "{\"uuids\": [\"error401\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),401);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Unauthorized");
        Assertions.assertTrue(responseDescription.contains("401"));
    }

    @Test
    //проверка приполучении 403 кода http
    public void permissionsAcquireFiles403(){
        String responseBody = "{\"uuids\": [\"error403\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),403);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Forbidden");
        Assertions.assertTrue(responseDescription.contains("403"));
    }
    @Test
    //проверка приполучении 404 кода http
    public void permissionsAcquireFiles404(){
        String responseBody = "{\"uuids\": [\"error404\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"DataNotFound");
        Assertions.assertTrue(responseDescription.contains("404"));
    }
    @Test
    //проверка приполучении 500 кода http
    public void permissionsAcquireFiles500(){
        String responseBody = "{\"uuids\": [\"error500\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().permissionsAcquireFiles(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("500"));
    }



}