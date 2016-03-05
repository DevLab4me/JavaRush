package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 27.02.2016.
 */

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int pageNumber = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, pageNumber++);

                if (doc == null) break;

                Elements allElements = doc.getElementsByClass("job");
                if (allElements.size() == 0) break;

                for (Element element : allElements) {
                    Vacancy vacancy = new Vacancy();
                    String siteName = "https://moikrug.ru";

                    vacancy.setUrl(siteName + element.getElementsByClass("title").select("a").attr("href"));
                    vacancy.setTitle(element.getElementsByClass("title").text());
                    vacancy.setCity(element.getElementsByClass("location").text());
                    vacancy.setCompanyName(element.getElementsByClass("company_name").select("a[href]").text());
                    vacancy.setSiteName(siteName);
                    Element salaryElement = element.getElementsByClass("count").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }
                    vacancy.setSalary(salary);

                    vacancies.add(vacancy);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int pageNumber) throws IOException {
        String url = String.format(URL_FORMAT, searchString, pageNumber);
        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36")
                    .referrer("none").get();
        } catch (IOException e) {
        }
        return doc;
    }
}