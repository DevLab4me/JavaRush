package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by Artem on 04.11.2015.
 */

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        int amount;
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage(res.getString("before"));
        while(true){
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String am = ConsoleHelper.readString();
            try {
                amount = Integer.parseInt(am);
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }
            if(amount <= 0){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if(!manipulator.isAmountAvailable(amount)){
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try {
                manipulator.withdrawAmount(amount);
            }catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
            break;
        }
    }
}
