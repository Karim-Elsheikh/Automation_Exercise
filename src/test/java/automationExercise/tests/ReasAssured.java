package automationExercise.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;



public class ReasAssured {


    @Test
    public void API(){
        createToken();
        System.out.println(token);
        creatBooking();
        System.out.println(BookingID);
        deleteBooking();
        System.out.println(status);




    }


    String  BookingID ;
    String token;
    String status ;



    private String body = """
            {{
                 "firstname" : "Jim",
                 "lastname" : "Brown",
                 "totalprice" : 111,
                 "depositpaid" : true,
                 "bookingdates" : {
                     "checkin" : "2018-01-01",
                     "checkout" : "2019-01-01"
                 },
                 "additionalneeds" : "Breakfast"
             }
            }
            """;
    private String boDy = """ 
            {
                             "username" : "admin",
                             "password" : "password123"
            
            }
            """;


    public void creatBooking() {

        BookingID = RestAssured.
                        given()
                        .header("Content-type", "application/json")
                        .body(body)
                        .log().all()
                        .when()
                        .post("//restful-booker.herokuapp.com/booking")
                        .then().statusCode(200).
                         log().body().extract().response().jsonPath().get("bookingid").toString();

    }

    public void createToken() {
        token = RestAssured.
                given().
                body(boDy).
                header("Content-Type", "application/json").
                log().all().
                when().
                post( "https://restful-booker.herokuapp.com/auth").
                then().statusCode(201).
                log().body().extract().body().path("token").toString();
    }

    @Test
    public void deleteBooking() {

        status =RestAssured.
                given()
                .header("Content-type", "application/json").
                 header("Cookie","token=" +token ).
                log().all()
                .when()
                .request("DELETE","https://restful-booker.herokuapp.com/booking/")
                .then().statusCode(201).
                log().body().extract().statusLine();
    }
}
