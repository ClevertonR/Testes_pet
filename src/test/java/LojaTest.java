import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LojaTest {

    @Test
    public void testCadastroAnimalStatusCode200(){
        // Configurar Caminho de API Araujo testes
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;

        // Cadastrar um animalzinho vulgo pet POST
        ValidatableResponse validatableResponse = given()
                .body("{\n" +
                        "  \"id\": 100,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 5,\n" +
                        "    \"name\": \"cleverton rodrigues testes \"\n" +
                        "  },\n" +
                        "  \"name\": \"ddd\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 1111,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .contentType("application/json")
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .log().all()  // Adiciona logs da requisição
                .statusCode(200);
    }

    @Test
    public void testPesquisarPetInexistente(){
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;

        // Pesquisar por um pet enexistente GET

        given()
                .when()
                .get("/50")
                .then()
                .statusCode(404)
                .log().all()  // Adiciona logs da requisição
                .body("message", equalTo("Seu Animalzinho, não foi encontrado na nossa base de dados"));
    }

    @Test
    public void testAtualizarPetExistente(){

        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;
        basePath = basePath;

        // Atualizar dados de um pet existente PUT
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 97,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"Trocar nome gato\"\n" +
                        "  },\n" +
                        "  \"name\": \"Gatinho\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 999,\n" +
                        "      \"name\": \"TestesCleverton R2\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("/pet")
                .then()
                .log().all()  // Adiciona logs da requisição
                .statusCode(200);
    }

    @Test
    public void testPesquisarPetsPorStatus(){
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;
        basePath = basePath;

        // Pesquisar por pets com status GET
        given()
                .when()
                .get("/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log().all()  // apresentar dados de requisição
                .body("status", everyItem(equalTo("available")));
    }
}