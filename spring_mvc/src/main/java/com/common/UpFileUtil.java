package com.common;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpFileUtil {
    public static void uploadFile(String path, InputStream in) {
        try {
            FileOutputStream bu = new FileOutputStream(path);
            BufferedOutputStream out = new BufferedOutputStream(bu);
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            out.flush();
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
