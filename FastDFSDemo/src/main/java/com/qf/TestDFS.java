package com.qf;

import org.csource.fastdfs.*;

public class TestDFS {
    public static  void main(String args[]) throws Exception{
        //tracker storage
        TrackerClient trackerClient=null;
        TrackerServer trackerServer=null;
        StorageClient storageClient=null;
        StorageServer storageServer=null;
        //1.加载配置文件
        ClientGlobal.init("client.conf");
        System.out.println(ClientGlobal.configInfo());

        //2,创建trackerclient对象
         trackerClient = new TrackerClient();
        //3.得到trackerServer对象
        trackerServer= trackerClient.getConnection();

        //4.构建storageclient对象
        storageClient = new StorageClient(trackerServer,storageServer);

        //5.上传图片


    }
}
