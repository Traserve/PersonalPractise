package file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: Martin
 * @date: 2023/5/27 3:18
 * Description:
 * 效果：将源目录所有md文件内容中tihuan配置内容替换为tihuanTO内容，最终输出到指定路径。
 * 配置说明：填写四个配置即可
 * COPY_ORIGN：源目录
 * COPY_ORIGN：目标输出目录(可填自己源目录)
 * tihuan：被替换内容
 * tihuanTO：替换内容
 * <p>
 * 说明：想要将md文件中的1替换为2，那么被替换内容就是1、替换内容就是2
 */
@Slf4j
public class MarkDownModify {

    //源目录
    private static String COPY_ORIGN = "F:\\GitHub\\traserve.github.io\\_posts\\algorithm";

    //目标目录
    private static String COPY_TO = "F:\\GitHub\\traserve.github.io\\_posts\\algorithm";

    //被替换内容
    private static String tihuan = "https://gitee.com/changluJava/picture-bed/raw/master/";

    //替换内容
    private static String tihuanTO = "https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/beifen-gitee/";


    public static void main(String[] args) throws Exception {
        Files.walk(Paths.get(COPY_ORIGN)).forEach(path -> {
            String originFile = path.toFile().getAbsolutePath();
            String targetFile = path.toFile().getAbsolutePath().replace(COPY_ORIGN, COPY_TO);
            try {
                //若是文件目录，则创建目标目录
                if (Files.isDirectory(path)) {
                    //判断是否存在，不存在则创建
                    if (!new File(targetFile).exists()) {
                        Files.createDirectory(Paths.get(targetFile));
                    }
                } else {
                    if (targetFile.contains(".md")) {
                        String content = readFile(originFile);
                        System.out.println(content);
                        //执行替换任务
                        doWork(originFile, targetFile, tihuan, tihuanTO);
                        System.out.println(targetFile + "已经覆盖完成!");
                    } else {
                        Files.copy(path, Paths.get(targetFile));
                    }
                }
            } catch (Exception e) {
                if (e instanceof FileAlreadyExistsException) {
                    log.info("目标文件:" + targetFile + " 已经存在");
                } else {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("所有的文件已全部替换！");
    }

    private static void doWork(String originFile, String targetFile, String tihuan, String tihuanTO) throws IOException {
//        //读取一个文件，获取到内容
//        String content = readFile(originFile);
//        //将内容中的文字进行替换
//        String newContent = content.replaceAll(tihuan, tihuanTO);
//        //写入到指定的目录
//        writeFile(newContent, targetFile);
        RandomAccessFile raf = new RandomAccessFile(originFile, "r");
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
        String content = readFile(originFile).replace(title, newHeader);
        //写入到指定的目录
        writeFile(content, targetFile);
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