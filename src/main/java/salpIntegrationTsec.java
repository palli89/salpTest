import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class salpIntegrationTsec {

    public Response permissionsAcquireFiles(String responseBody){
    RestAssured.baseURI="http://salp-integration-tsec-st.oslb-dev01.corp.dev.vtb";
    RequestSpecification request = RestAssured.given().log().all();
    RestAssured.useRelaxedHTTPSValidation();
    request.header("Content-Type","application/json");
  //      request.header("Content-Length","2");
 //       request.header("Host","salp-integration-tsec-salp-dso-st.oslb-dev01.corp.dev.vtb");
    request.body(responseBody);
    Response response = request.post("/api/v1/permissions/acquire/files");

    //mdmId=response.getBody().jsonPath().get("data.mdmId");
    response.getBody().prettyPrint();

    return response;
    }

    public Response folderFilePut(String responseBody){
        RestAssured.baseURI="http://salp-integration-tsec-st.oslb-dev01.corp.dev.vtb";
        RequestSpecification request = RestAssured.given().log().all();
        RestAssured.useRelaxedHTTPSValidation();
        request.header("Content-Type","application/json");
        //      request.header("Content-Length","2");
        //       request.header("Host","salp-integration-tsec-salp-dso-st.oslb-dev01.corp.dev.vtb");
        request.body(responseBody);
        Response response = request.post("/api/v1/folder/file/put");
        response.getBody().prettyPrint();

        return response;
    }

    public Response permissionsGrantFile(String responseBody){
        RestAssured.baseURI="http://salp-integration-tsec-st.oslb-dev01.corp.dev.vtb";
        RequestSpecification request = RestAssured.given().log().all();
        RestAssured.useRelaxedHTTPSValidation();
        request.header("Content-Type","application/json");
        //      request.header("Content-Length","2");
        //       request.header("Host","salp-integration-tsec-salp-dso-st.oslb-dev01.corp.dev.vtb");
        request.body(responseBody);
        Response response = request.post("/api/v1/permissions/grant/file");
        response.getBody().prettyPrint();

        return response;
    }

    public Response fileGet(String responseBody){
        RestAssured.baseURI="http://salp-integration-tsec-st.oslb-dev01.corp.dev.vtb";
        RequestSpecification request = RestAssured.given().log().all();
        RestAssured.useRelaxedHTTPSValidation();
        request.header("Content-Type","application/json");
        //      request.header("Content-Length","2");
        //       request.header("Host","salp-integration-tsec-salp-dso-st.oslb-dev01.corp.dev.vtb");
        request.body(responseBody);
        Response response = request.post("/api/v1/file/get");
        response.getBody().prettyPrint();

        return response;
    }







}