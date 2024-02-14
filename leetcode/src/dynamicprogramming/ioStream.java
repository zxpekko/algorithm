package dynamicprogramming;

import java.io.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:55 2023/2/23
 */
public class ioStream {
    public static void main(String[] args) {
        Stream("D:\\LeStoreDownload\\QQ\\2250612787\\FileRecv\\guess.txt");

    }
    public static void Stream(String pathname){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(pathname));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("ER20.pkl"));
            int len;
            byte[] bytes = new byte[1024];
            while((len=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(bufferedInputStream!=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }
}
