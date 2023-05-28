package file;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author: Martin
 * @date: 2023/5/27 3:30
 * Description:
 */
public class FileOperation {

    public static void main(String[] args) throws IOException {
        String path = "G:\\IdeaProjects\\PersonalPractise\\src\\main\\resources\\2023-05-26-0072. 编辑距离.md";
        RandomAccessFile raf = new RandomAccessFile(path, "rwd");
        String title = new String(raf.readLine().getBytes(StandardCharsets.ISO_8859_1));
        String newTitle = null;
        if (title.startsWith("# [")) {
            newTitle = title.substring(title.indexOf("[") + 1, title.indexOf("]"));
        } else {
            newTitle = title;
        }
        String newHeader = "---\n" +
                "layout: post\n" +
                "title: " + newTitle + "\n" +
                "tags: [Algorithm]\n" +
                "math: true\n" +
                "toc:  true\n" +
                "---";
        String content = readFile(path).replace(title, newHeader);
        writeFile(content, path);
        raf.close();
    }

    private static void writeFile(String newContent, String targetFile) throws IOException {
        File file = new File(targetFile);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write(newContent);
        osw.flush();
    }

    private static String readFile(String originFile) throws IOException {
        FileInputStream fis = new FileInputStream(originFile);
        final InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String content = "";
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content += line + "\r\n";
        }
        return content;
    }

}
