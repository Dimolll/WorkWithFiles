package com.dimoll;

import java.io.*;

public class FileOperation {


    public static void copy(File fromDirectory, File toDirectory) throws IOException {
        byte[] buffer = new byte[1024 * 1024];
        int readByte = 0;
        File[] files = fromDirectory.listFiles((dir, name) -> {
            return name.endsWith(".png");
        });
        for (int i = 0; i < files.length; i++) {
            try (FileInputStream fis = new FileInputStream(files[i]);
                 FileOutputStream fos = new FileOutputStream(
                         new File(toDirectory.getPath() + "\\" + files[i].getName()))) {
                for (; (readByte = fis.read(buffer)) > 0; ) {
                    fos.write(buffer, 0, readByte);
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }

    public static File unitedFiles(File firstFile, File secondFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(firstFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(secondFile,true))) {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                if(line!=null) {
                    writer.append( "\n" + line);
                }
            }

        } catch (IOException e) {
            throw e;
        }
        return secondFile;
    }
}
