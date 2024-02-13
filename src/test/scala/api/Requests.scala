package api

import io.restassured.RestAssured.`given`
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import responsevalidation.PostRequest

import java.io.File

class Requests extends AnyFreeSpec {

  val baseurl = "https://reqres.in"

  val jsonFile = new File("./src/test/resources/data/input.json")

  "*Feature* - Creating and getting single user request [success = 201 and 200]" - {
    "POST - Creating user" in {
      val sut = given()
        .header("Content-Type", "application/json")
        .body(jsonFile)
        .when()
        .post(s"$baseurl/api/users")
      sut
        .`then`()
        .assertThat()
        .statusCode(201)

      val message = sut.`then`().extract().response().getBody().asString()
      println("post_message:", message)

      val actual = sut.as(classOf[PostRequest])

      //val name = actual.name

      val expected = PostRequest(
        name = sut.jsonPath().get[String]("name"),
        job = sut.jsonPath().get[String]("job"),
        id = sut.jsonPath().get[String]("id"),
        createdAt = sut.jsonPath().get[String]("createdAt")
      )
      actual mustEqual expected

      val responseJson = sut.jsonPath().get[String]("name")
      responseJson mustEqual "morpheus"
    }

    "GET - Getting single user by ID" in {
      val sut = given()
        .header("Content-Type", "application/json")
        .when()
        .get(s"$baseurl/api/users/2")
      sut
        .`then`()
        .statusCode(200)

      val responseMessage = sut.`then`().extract().response().getBody().asString()
      println("get_message:", responseMessage)

      val checkId = sut.jsonPath().get[Object]("data.id").toString()
      checkId mustEqual "2"
    }
  }
}
