package com.dimoll;

import java.io.File;
import java.io.IOException;

public class Main {

    public  static void main(String[] args) throws IOException {
        File fromDirectory = new File("E:\\Programing\\Prog.Kiev\\from");
        File toDirectory = new File("E:\\Programing\\Prog.Kiev\\test");
        try{
            FileOperation.copy(fromDirectory,toDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOperation.unitedFiles(
                    new File("text1.txt"),
                    new File("text2.txt"));
        }catch (IOException o){
            o.printStackTrace();
        }
    }
}
