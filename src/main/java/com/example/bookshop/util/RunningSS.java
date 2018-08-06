package com.example.bookshop.util;

import java.io.*;

public class RunningSS {

    public static void sendMsg(String s) {
        String path = getPath();
        modifyFile(path+"/src/main/java/com/example/bookshop/scripts/send.sh","privet",s);
        Process p;
        try {
            String[] cmd = {"sh", path+"/src/main/java/com/example/bookshop/scripts/send.sh"};

            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        modifyFile(path+"/src/main/java/com/example/bookshop/scripts/send.sh",s,"privet");


    }

    private static String getPath() {
        Process p;
        String line="";
        StringBuilder sb = new StringBuilder();
        try {
            p = Runtime.getRuntime().exec("pwd");
            p.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                line=reader.readLine();
                if(line!=null){
                    sb.append(line);
                }else {break;}

            }

        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

return sb.toString();
    }

  public   static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }



}
