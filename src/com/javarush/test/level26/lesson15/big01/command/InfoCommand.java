package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by Artem on 04.11.2015.
 */

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator current : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if(current.hasMoney()) {
                if(current.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(current.getCurrencyCode() + " - " + current.getTotalAmount());
                    money = true;
                }
            }
        }
        if(!money)
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
