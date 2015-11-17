package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Artem on 04.11.2015.
 */

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute()throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();

        String[] nominal = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        try{
            int denomination = Integer.parseInt(nominal[0]);
            int count = Integer.parseInt(nominal[1]);
            manipulator.addAmount(denomination, count);
            ConsoleHelper.writeMessage(String.format((res.getString("success.format")), (denomination*count), currencyCode));
        } catch (NumberFormatException e){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
