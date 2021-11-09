package com.provectus.kafka.ui.pages;

import org.openqa.selenium.Keys;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class ProduceMessagePage{

    private final SelenideElement keyField = $(By.xpath("//div[@id = 'key']/textarea"));
    private final SelenideElement contentField = $(By.xpath("//div[@id = 'content']/textarea"));
    private final SelenideElement headersField = $(By.xpath("//div[@id = 'headers']/textarea"));
    private final SelenideElement sendBtn = $(By.xpath("//button[@type = 'submit']"));

    public ProduceMessagePage setKeyField(String value) {
        Wait().until(ExpectedConditions.urlContains("message"));
        keyField.sendKeys(Keys.chord(Keys.DELETE));
        keyField.setValue(value);
        return new ProduceMessagePage();
    }

    public ProduceMessagePage setContentFiled(String value) {
        Wait().until(ExpectedConditions.urlContains("message"));
        contentField.sendKeys(Keys.DELETE);
        contentField.setValue(value);
        return new ProduceMessagePage();
    }

    public ProduceMessagePage setHeaderFiled(String value) {
        headersField.waitUntil(Condition.visible, 10000).setValue(value);
        return new ProduceMessagePage();
    }

    public TopicView submitProduceMessage() {
        sendBtn.click();
        return new TopicView();
    }
}
