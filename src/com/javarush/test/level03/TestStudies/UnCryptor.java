package com.javarush.test.More.TestStudies;

/**
 * Created by Artem on 10.11.2015.
 */

public class UnCryptor {
    public static void main(String[] args) {
        new UnCryptor().execute();
    }

    public void execute() {
        System.out.println("password.request");
        String previousPass = "gfhjkmartemio25";
        String correctPass = unCrypt(toBytes(previousPass));
        System.out.println(correctPass);
    }
    private byte [] toBytes(String prevPass)
    {
        char [] charArray = previousPass.toCharArray();
        byte [] byteArray = new byte[prevPass.length()];
        for (int i = 0; i < charArray.length; i++)
        {
            byteArray[i] = (byte) charArray[i];
        }
        return byteArray;
    }

    private String unCrypt(byte[] byteArray)
    {
        byte [] pass = new byte[byteArray.length];
        int key = 10;
        for (int i = 0; i < pass.length; i++)
        {
            pass[i] = (byte) (byteArray[i] ^ key);
        }

        StringBuilder res = new StringBuilder();
        for (byte b : pass) {
            res.append((char) b);
        }
        return res.toString();
    }
}