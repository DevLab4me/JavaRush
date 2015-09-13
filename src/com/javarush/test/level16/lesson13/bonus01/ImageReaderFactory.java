package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created with IntelliJ IDEA.
 * User: Artem
 * Date: 20.08.14
 * Time: 21:34
 * To change this template use File | Settings | File Templates.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageTypes) {
        ImageReader reader;

        if(imageTypes == ImageTypes.JPG) {
            reader = new JpgReader();
        }
        else if (imageTypes == ImageTypes.PNG) {
            reader = new PngReader();
        }
        else if (imageTypes == ImageTypes.BMP) {
            reader = new BmpReader();
        }
        else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
