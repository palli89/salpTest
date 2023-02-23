import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class folderFilePut {
    @Test
    //проверка валидного запроса
    public void folderFilesPutValid(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"succes\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"OK");

    }

    @Test
    //проверка на обязательность параметра folderUuid
    public void folderFilesPutFolderUuidRequired(){
        String responseBody = "{\"uuids\": [\"succes\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("folderUuid"));
    }
    @Test
    //проверка на обязательность параметра Uuids
    public void folderFilesPutUuidsRequired(){
        String responseBody = "{\"folderUuid\": \"folder_name\"}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("uuids"));
    }
    @Test
    //проверка на обязательность параметра Uuids
    public void folderFilesPutRequestError(){
        String responseBody = "";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"RequestError");
    }
    @Test
    //проверка при получении 503 кода
    public void folderFilesPutError503(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error503\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("503"));
    }
    @Test
    //проверка при получении 504 кода
    public void folderFilesPutError504(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error504\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("504"));
    }

    @Test
    //проверка при получении 400 кода
    public void folderFilesPutError400(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error400\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("400"));
    }
    @Test
    //проверка при получении 401 кода
    public void folderFilesPutError401(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error401\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),401);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Unauthorized");
        Assertions.assertTrue(responseDescription.contains("401"));
    }
    @Test
    //проверка при получении 403 кода
    public void folderFilesPutError403(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error403\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),403);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Forbidden");
        Assertions.assertTrue(responseDescription.contains("403"));
    }
    @Test
    //проверка при получении 404 кода
    public void folderFilesPutError404(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error404\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"DataNotFound");
        Assertions.assertTrue(responseDescription.contains("404"));
    }
    @Test
    //проверка при получении 500 кода
    public void folderFilesPutError500(){
        String responseBody = "{\"folderUuid\": \"folder_name\",\"uuids\": [\"error500\", \"uuid_02\"]}";
        Response response= new salpIntegrationTsec().folderFilePut(responseBody);
        String responseDescription= response.getBody().jsonPath().get("result.description");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("500"));
    }
}
