package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Artem on 28.08.2016.
 */

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if(f.isDirectory()){
            return true;
        }else {
            String file = f.getName().toLowerCase();
            return file.endsWith(".html") || file.endsWith(".htm");
        }
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
