package com.hrizantemovich;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormTest {
    @BeforeAll
    static void Beforeall(){
        Configuration.startMaximized = true;
    }
    @Test
    void fillFormTest(){

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Zhenia");
        $("#lastName").setValue("Zhenia");
        $("#userEmail").setValue("Zhenia@gmail.com");
        $("#genterWrapper");
        $(byText("Male")).click();
        $("#userNumber").setValue("1212121212");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper");
        $(byText("Music")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Lenina 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Zhenia Zhenia"),text("Zhenia@gmail.com"),text ("Male"),
                text("1212121212"),text("29 December,1989"),text("Maths"),text("Music, Reading"),text("1.png"),
                text("Maths"),text("Lenina 1"),text("Lenina 1"),text("NCR Noida") );

    }


}
