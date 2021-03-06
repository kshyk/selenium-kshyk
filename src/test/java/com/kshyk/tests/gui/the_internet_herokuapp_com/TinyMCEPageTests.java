package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

class TinyMCEPageTests extends TestCase {
    @BeforeAll
    public void openTinyMCEPage() {
        open("http://the-internet.herokuapp.com/tinymce");
    }

    @Test
    public void clearAndSetNewContent() {
        var jsCode = "tinymce.activeEditor.setContent(arguments[0]);";
        executeJavaScript(jsCode, "");
        executeJavaScript(jsCode, LocalDateTime.now().toString());
    }
}