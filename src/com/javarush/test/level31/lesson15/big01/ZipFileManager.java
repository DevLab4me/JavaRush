package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Artem on 12.04.2016.
 */

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile){
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
        try(ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile))){
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(zipEntry);

            try(InputStream is = Files.newInputStream(source)) {
                byte[] buffer = new byte[1024];
                int count;
                while ((count = is.read(buffer)) > -1) {
                    zos.write(buffer, 0, count);
                    zos.flush();
                }
                zos.closeEntry();
            }
        }
    }
}
