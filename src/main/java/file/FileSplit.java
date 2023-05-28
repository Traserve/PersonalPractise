package file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: Martin
 * @date: 2023/5/11 23:56
 * Description:
 */
public class FileSplit {

    public static void main(String[] args) throws IOException {
        fileSplit();
        fileMerge();
    }

    /**
     * 大文件进行切块
     *
     * @throws IOException
     */
    public static void fileSplit() throws IOException {
        //源文件地址
        File sourceFile = new File("G:\\IdeaProjects\\PersonalPractise\\src\\main\\resources\\chunk\\share.mkv");
        //块文件目录
        String chunkFileFolder = "G:\\IdeaProjects\\PersonalPractise\\src\\main\\resources\\chunk\\chunks";
        //块文件大小
        int chunkFileSize = 100 * 1024 * 1024;
        //块文件数量
        //256,879,275
        System.out.println(sourceFile.length());
        int chunkFileNum = (int) Math.ceil(sourceFile.length() * 1.0 / chunkFileSize);
        //
        RandomAccessFile readFile = new RandomAccessFile(sourceFile, "r");
        byte[] bytes = new byte[1024];
        for (int i = 0; i < chunkFileNum; i++) {
            File chunkFile = new File(chunkFileFolder + "\\" + i + "\\" + sourceFile.getName());
            int len = -1;
            //创建块文件
            RandomAccessFile writeFile = new RandomAccessFile(chunkFile, "rw");
            while ((len = readFile.read(bytes)) != -1) {
                writeFile.write(bytes, 0, len);
                //如果块文件大小达到1M，就读下一块
                if (chunkFile.length() >= chunkFileSize) {
                    break;
                }
            }
            writeFile.close();
        }
        readFile.close();
    }

    /**
     * 文件合并
     *
     * @throws IOException
     */
    public static void fileMerge() throws IOException {
        //块文件目录
        String chunkFileFolderPath = "E:\\chunck\\chunks";
        //获取块文件对象
        File chunkFileFolder = new File(chunkFileFolderPath);
        //块文件列表
        File[] files = chunkFileFolder.listFiles();
        //将文件排序
        List<File> filesList = Arrays.asList(files);
        Collections.sort(filesList, (o1, o2) -> {
            if (Integer.parseInt(o1.getName()) > Integer.parseInt(o2.getName())) {
                return 1;
            }
            return -1;
        });
        //合并后的文件
        File mergerFile = new File("E:\\chunck\\share_merger.mp4");
        //创建新文件
        boolean newFile = mergerFile.createNewFile();
        //创建写对象
        RandomAccessFile writeFile = new RandomAccessFile(mergerFile, "rw");

        byte[] b = new byte[1024];
        for (File chunkFile : filesList) {
            int len = -1;
            //创建读块文件的对象
            RandomAccessFile readFile = new RandomAccessFile(chunkFile, "r");
            while ((len = readFile.read(b)) != -1) {
                writeFile.write(b, 0, len);
            }
            readFile.close();
        }
        writeFile.close();
    }
}
