package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Artem on 24.02.2016.
 */

public class HtmlView implements View {
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/")
            + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        try {
            Document doc = getDocument();
            Element original = doc.getElementsByClass("template").first();
            Element template = original.clone();
            template.removeClass("template").removeAttr("style");
            doc.getElementsByAttributeValue("class", "vacancy").remove();

            for(Vacancy vacancy : vacancies){
                Element clone = template.clone();
                clone.getElementsByAttributeValue("class", "city").first().text(vacancy.getCity());
                clone.getElementsByAttributeValue("class", "companyName").first().text(vacancy.getCompanyName());
                clone.getElementsByAttributeValue("class", "salary").first().text(vacancy.getSalary());
                Element link = clone.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                original.before(clone.outerHtml());
            }
            return doc.html();

        }catch(IOException e){
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String data){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(data);
            writer.close();
        }catch (IOException e){

        }
    }
    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Kiev");
    }
}
