
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fatou
 */
public class main {

    public static void test_gitea() throws InterruptedException {
        String prefix = "cmd /c ";
        String gitStatus = "git status";
        String gitInit = "git init";
        String gotoDir = "cd C:\\new\\test1";

        String pushFirstTime = "git add . & git commit -am \"Initial\" & git remote add origin git@github.com:Ahmed-Fouad0440/test.git & "
                + "git branch -M main & "
                + "git push -u origin main";
        String pushNextTime = "git add . & git commit -am \"latest update\" & git push";
        String command = prefix + gotoDir + " && " + pushNextTime;

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream()));
            writer.write("09-20-14");
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("Abnormal process termination");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        test_gitea();
    }

    public static void test1() throws IOException {

        String command = "ping www.codejava.net";

        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();

    }

    public static void test2() {
        String command = "cmd /c date";

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream()));
            writer.write("09-20-14");
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
