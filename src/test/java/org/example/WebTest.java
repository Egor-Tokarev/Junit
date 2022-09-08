package org.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WebTest {
/*
    @BeforeAll
    static void configure() {
        Configuration.holdBrowserOpen = true;
    }

    @Disabled
    @ValueSource(strings = {"facebook", "vk", "origin"})
    @ParameterizedTest(name = "Результаты поиска не пустые для {0}")
    void testSearch(String testData) {
        open("https://github.com/");
        $("[placeholder=\"Search GitHub\"]").setValue(testData).pressEnter();
        $$("li.repo-list-item").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    @Disabled
    @CsvSource(value = {
            "facebook,  huandu/facebook",
            "vk, vknet/vk",
            "origin, openshift/origin",

    })

    @ParameterizedTest(name = "Содержит  {1} для запроса {0}")
    void testComplexSearch(String testData, String expectedResult) {
        open("https://github.com/");
        $("[placeholder=\"Search GitHub\"]").setValue(testData).pressEnter();
        $$("li.repo-list-item").first().shouldHave(text(expectedResult));


    }*/

    static Stream<Arguments> dataProviderForSelenideSiteMenuTest() {
        return Stream.of(
                Arguments.of(Lang.ENG, List.of("About VK", "Terms", "Developers")),
                Arguments.of(Lang.UA, List.of("Про VK", "Правила", "Для бізнесу", "Розробникам")),
                Arguments.of(Lang.RU, List.of("О ВКонтакте", "Правила", "Для бизнеса", "Разработчикам"))
        );
    }

    @MethodSource("dataProviderForSelenideSiteMenuTest")
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    void selenideSiteMenuTest(Lang lang, List<String> expectedButtons) {
        open("https://vk.com/");
        $$(".footer_lang a").find(text(lang.name())).click();
        $$(".footer_links a")
                .filter(visible)
                .shouldHave(CollectionCondition.texts(expectedButtons));

    }
/*
    @EnumSource(Lang.class)
    @ParameterizedTest
    void vkEnumTest(Lang lang) {
        open("https://vk.com/");
        $$(".footer_lang a").find(text(lang.name())).click();
        $("#index_login").shouldBe(visible);
        $(".login_mobile_header").shouldBe(visible); // Хедер виден
        $(".login_mobile_info").shouldBe(visible); // Аннотация видна
        $(".LoginMobilePromo__devices").shouldBe(visible); // Див с картинками телефонов виден

    }*/
}

