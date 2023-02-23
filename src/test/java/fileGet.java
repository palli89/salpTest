import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class fileGet {
    @Test
    //проверка валидного запроса
    public void fileGetValid(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"testSucces\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"OK");
        Assertions.assertEquals(response.getBody().jsonPath().get("data.uuid"),"testSucces");

    }

    @Test
    //проверка что при includeFileName=False не вызывается
    public void fileGetIncludeFileNameFalse(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"testSucces\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"OK");
        Assertions.assertNull(response.getBody().jsonPath().get("data.name"));

    }
    @Test
    //проверка обязательности параметра uuid
    public void fileGetUuidRequired(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ParameterNotFound");
        Assertions.assertTrue(responseDescription.contains("uuid"));
    }
    @Test
    //проверка при получении пустого запроса
    public void fileGetRequestError(){
        String responseBody = "";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"RequestError");
    }

    @Test
    //проверка при получении 400 кода
    public void fileGet400GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error400\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("400"));
    }

    @Test
    //проверка при получении 401 кода
    public void fileGet401GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error401\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),401);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Unauthorized");
        Assertions.assertTrue(responseDescription.contains("401"));
    }

    @Test
    //проверка при получении 403 кода
    public void fileGet403GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error403\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),403);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Forbidden");
        Assertions.assertTrue(responseDescription.contains("403"));
    }

    @Test
    //проверка при получении 404 кода
    public void fileGet404GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error404\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"DataNotFound");
        Assertions.assertTrue(responseDescription.contains("404"));
    }

    @Test
    //проверка при получении 503 кода
    public void fileGet503GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error503\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("503"));
    }

    @Test
    //проверка при получении 504 кода
    public void fileGet501GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error504\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("504"));
    }
    @Test
    //проверка при получении 500 кода
    public void fileGet500GetFileContent(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error500\",\"version\": 1,\"includeFileName\": false}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("500"));
    }

    @Test
    //проверка при получении 401 кода
    public void fileGet401GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error4001\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),401);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Unauthorized");
        Assertions.assertTrue(responseDescription.contains("401"));
    }

    @Test
    //проверка при получении 403 кода
    public void fileGet403GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error4003\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),403);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"Forbidden");
        Assertions.assertTrue(responseDescription.contains("403"));
    }
    @Test
    //проверка при получении 400 кода
    public void fileGet400GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error4000\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("400"));
    }

    @Test
    //проверка при получении 404 кода
    public void fileGet404GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error4004\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"DataNotFound");
        Assertions.assertTrue(responseDescription.contains("404"));
    }

    @Test
    //проверка при получении 500 кода
    public void fileGet500GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error5000\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemError");
        Assertions.assertTrue(responseDescription.contains("500"));
    }
    @Test
    //проверка при получении 503 кода
    public void fileGet503GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error5003\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("503"));
    }
    @Test
    //проверка при получении 504 кода
    public void fileGet504GetFileName(){
        String responseBody = "{\"attachmentType\": \"pdf\",\"includeAttachments\": true,\"uuid\": \"error5004\",\"version\": 1,\"includeFileName\": true}";
        Response response= new salpIntegrationTsec().fileGet(responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonShema/salpIntegrationTsecFileGetShema.json"));
        String responseDescription= response.getBody().jsonPath().get("result.description");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.getBody().jsonPath().get("result.code"),"ExternalSystemNotAvailable");
        Assertions.assertTrue(responseDescription.contains("504"));
    }



}
