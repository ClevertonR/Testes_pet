import io.restassured.response.ValidatableResponse;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LojaTest {

    private static StringBuilder report = new StringBuilder();

    @Test
    public void testCadastroAnimalStatusCode200() {
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;

        try {
            // Cadastrar um animalzinho vulgo pet POST
            ValidatableResponse validatableResponse = given()
                    .log().all()  // Adiciona logs da requisição
                    .body("{\n" +
                            "  \"id\": 101,\n" +
                            "  \"category\": {\n" +
                            "    \"id\": 101,\n" +
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
                    .log().all()  // Adiciona logs da resposta
                    .assertThat()
                    .statusCode(200);

            report.append("testCadastroAnimalStatusCode200:Testes OK\n");
        } catch (AssertionError e) {
            report.append("testCadastroAnimalStatusCode200: Falha detectada! - ").append(e.getMessage()).append("\n");
        }
    }

    @Test
    public void testPesquisarPetInexistente() {
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;

        try {
            // Pesquisar por um pet inexistente GET
            given()
                    .log().all()  // Adiciona logs da requisição
                    .when()
                    .get("/pet/1000")
                    .then()
                    .log().all()  // Adiciona logs da resposta
                    .statusCode(404)
                    .body("message", equalTo("Cadastro de PET não encontrado em nossa base de dados"));

            report.append("testPesquisarPetInexistente: Testes OK\n");
        } catch (AssertionError e) {
            report.append("testPesquisarPetInexistente: Falha detectada! - ").append(e.getMessage()).append("\n");
        }
    }

    @Test
    public void testAtualizarPetExistente() {
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;


        try {
            // Atualizar dados de um pet existente PUT
            given()
                    .contentType("application/json")
                    .log().all()  // Adiciona logs da requisição
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
                    .log().all()  // Adiciona logs da resposta
                    .statusCode(200);

            report.append("testAtualizarPetExistente:Testes OK\n");
        } catch (AssertionError e) {
            report.append("testAtualizarPetExistente: Falha detectada! - ").append(e.getMessage()).append("\n");
        }
    }

    @Test
    public void testPesquisarPetsPorStatus() {
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;


        try {
            // Pesquisar por pets com status GET
            given()
                    .log().all()  // Adiciona logs da requisição
                    .when()
                    .get("/pet/findByStatus?status=available")
                    .then()
                    .log().all()  // Adiciona logs da resposta
                    .statusCode(200)
                    .body("status", everyItem(equalTo("available")));

            report.append("testPesquisarPetsPorStatus:Testes OK\n");
        } catch (AssertionError e) {
            report.append("testPesquisarPetsPorStatus: Falha detectada! - ").append(e.getMessage()).append("\n");
        }
    }

    @Test
    public void testPesquisarPetsPorStatusPending() {
        // Configurar Caminho de API
        String baseUrl = "https://petstore.swagger.io/v2/";
        String basePath = "/pet";

        // Configurar RestAssured
        baseURI = baseUrl;


        try {
            // Pesquisar por pets com status GET
            given()
                    .log().all()  // Adiciona logs da requisição
                    .when()
                    .get("/pet/findByStatus?status=pending")
                    .then()
                    .log().all()  // Adiciona logs da resposta
                    .statusCode(200)
                    .body("status", everyItem(equalTo("pending")));

            report.append("testPesquisarPetsPorStatus:Testes OK\n");
        } catch (AssertionError e) {
            report.append("testPesquisarPetsPorStatus: Falha detectada! - ").append(e.getMessage()).append("\n");
        }
    }

    @AfterClass
    public static void generateReport() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("test-report.html"))) {
            writer.println("<html><body><h1>Relatorios de Testes Cleverton Rodrigues</h1><pre>");
            writer.println(report.toString());
            writer.println("</pre></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
