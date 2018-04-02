package tool.convert;

import java.io.*;

public class JspConverter {

    public static void main(String[] args) throws IOException {
        File dir = new File("work/in/");
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            convertFile(file);
        }
    }

    public static void convertFile(File inFile) throws IOException {
        File outFile = new File("work/out/"+inFile.getName());
        try(BufferedReader b_reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile),"Shift_jis"));
        PrintWriter p_writer    = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8")))){
            String s;
            while((s = b_reader.readLine())!=null){
                p_writer.println(s);
            }
        }
    }
}
