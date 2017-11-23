/*
package com.sjp.upload;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import javax.sound.sampled.Port;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpUploadTest {
    @Test
    public void testFTPClient() throws IOException {
        //创建一个FTP客户端对象
        FTPClient ftpClient=new FTPClient();
        //发送链接
        ftpClient.connect("10.31.161.73",21);
        //使用登录方法
        ftpClient.login("ftpuser001", "sjp123sjp");
        //封装一个输入流
        FileInputStream fs = new FileInputStream(new File("f:\\images\\pic2.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser001/www/images");
        //设置上传文件类型为二进制文件
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //执行上传方法
        ftpClient.storeFile("hel.jpg", fs);
        //释放资源
        fs.close();
        ftpClient.logout();

    }
}
*/
