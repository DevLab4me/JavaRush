package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Artem on 17.01.2016.
 */

public class Aggregator {
    public static void main(String[] args) {
        HtmlView htmlView = new HtmlView();
        Provider provider = new Provider(new MoikrugStrategy());
        Provider[] providers = new Provider[]{provider};
        Model model = new Model(htmlView, providers);
        htmlView.setController(new Controller(model));
        htmlView.userCitySelectEmulationMethod();

    }
}
