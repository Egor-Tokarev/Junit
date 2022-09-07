package org.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @CsvSource (value = {
            "Selenide,  это фреймворк для автоматизированного тестирования веб-приложений",
            "Allure java, -framework успешно применяется в работе автоматизатора",
    })
    @ParameterizedTest (name = "Результаты поиска содержат текст {1} для запроса {0}")
    void commonComplexSearchTest(String testData, String expectedResult) {
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").filter(not(text("Реклама")))
                .first()
                .shouldHave(text(expectedResult));
    }
}
/*
    @Disabled("Причина") // откл тест, исключаем тест из прогона
    @DisplayName("Страница открывается") // вывод названия теста в аллюр и тд
    @Test
        // аннотация теста
    void selenideTest() {
        open("https://ya.ru");
    }*/

    // параметризованный тест
 //   @DisplayName("Результаты поиска не пустые для запроса )
 /*   @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest (name = "Результаты поиска не пустые для запроса {0}")
    void commonSearchTest(String testData) {
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }*/


