
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
       public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println(RunCommandAndGetOutput("cmd /c git branch", new ArrayList<String>()));
//        System.out.println(Arrays.toString(GetGitBranches()));
//HasGitChanges();
ComitAndPushToBranch("mybranch", "default-message");
    }
       
       public static void ComitAndPushToBranch(String branch, String commitMSG){
           System.out.println( RunCommandAndGetOutput("cmd /c git checkout " + branch + " && git add . && git commit -am \"" + commitMSG + "\" && git push", new ArrayList<>()).toString());
       }
       
    
    public static boolean HasGitChanges(){
        ArrayList<String> changes= RunCommandAndGetOutput("cmd /c git status", new ArrayList<>());
        boolean treeClean = changes.toString().indexOf("working tree clean") >= 0;
        System.out.println("tree clean: " + treeClean);
        return !treeClean;
    }

    public static String[] GetGitBranches() {

        ArrayList<String> branches = RunCommandAndGetOutput("cmd /c git branch", new ArrayList<>());
        for (int i = 0; i < branches.size(); i++) {
            String line = branches.get(i);
            line.trim();
            if (line.startsWith("*")) {
                line = line.substring(1);
            }
            line = line.trim();

            branches.set(i, line);
        }

        return branches.toArray(new String[branches.size()]);
    }

    // returns the output lines of the program.
    public static ArrayList<String> RunCommandAndGetOutput(String fullCommand, ArrayList<String> inputLines) {
        ArrayList<String> outputLines = new ArrayList<>();

        try {
            Process process = Runtime.getRuntime().exec(fullCommand);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            for (String input : inputLines) {
                writer.write(input);
            }
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
            }
            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("Abnormal process termination");
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return outputLines;
    }

    public static void test002() {
        String command = "cmd /c git branch";

        try {
            Process process = Runtime.getRuntime().exec(command);

//    BufferedWriter writer = new BufferedWriter(            new OutputStreamWriter(process.getOutputStream()));
//    writer.write("09-20-14");
//    writer.close();
            System.out.println();
            System.out.print("The output of the program is: [[[");
            //StringBuilder sb = new StringBuilder();
            ArrayList<String> branches = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                line = line.trim();
                if (line.startsWith("*")) {
                    line = line.substring(1);
                }
                line = line.trim();
                //sb.append(line);
                branches.add(line);
            }
            System.out.print("]]]");
            System.out.print("\nBrances are: " + Arrays.toString(branches.toArray(new String[branches.size()])));

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // pushtoBranch(branchname)
    // commit()
    // pushFirstTime()
    // pushNextTime()
    public static void test_gitea() throws InterruptedException {
        String prefix = "cmd /c ";
        //String gitStatus = "git status";
        //String gitInit = "git init";
        String gotoDir = "cd C:\\new\\test1";

        //String pushFirstTime = "git add . & git commit -am \"Initial\" & git remote add origin git@github.com:Ahmed-Fouad0440/test.git & "                + "git branch -M main & "                + "git push -u origin main";
        String commitMSG = "any message user wants";

        String pushNextTime = "git add . & git commit -am \"" + commitMSG + "\" & git push";

        String remoteName = "origin";
//        String branch2 = "mybranch";
        String branchName = "mybranch";
        String gotoBranch = "git checkout " + branchName;
        String setUpstream = "git push --set-upstream " + remoteName + " " + branchName;

        String command = prefix + gotoDir + " & " + gotoBranch + " & " + setUpstream + " & " + pushNextTime;

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

    public static void test02() {
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
