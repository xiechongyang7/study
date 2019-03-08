package com.seesea.rely.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

/**
 * @Author lidey
 * @DATE 2018/12/17
 */
public class hbase2 {
    private static Configuration configuration;
    private static Connection connection;

    public static void main(String[] args) throws IOException {
        configuration = new Configuration();
        configuration.set("hbase.zookeeper.quorum", "119.3.82.153");
//        configuration.set("hbase.zookeeper.quorum", "master:2181,master:2182,master:2183");
//        configuration.set("hbase.zookeeper.quorum", "master");
//        configuration.set("hbase.zookeeper.quorum", "172.10.5.75,172.10.5.77,172.10.5.78");
//        configuration.set("hbase.zookeeper.quorum", "master,node01,node02");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        //rpc请求的超时时间默认为60秒,修改为5秒
        configuration.set("hbase.rpc.timeout", "5000");
        //客户端重试最大次数默认35,修改为3
        configuration.set("hbase.client.retries.number", "1");
        //失败重试时等待时间
        configuration.set("hbase.client.pause", "50");
        //zookeeper重试次数修改为3
        configuration.set("zookeeper.recovery.retry", "3");
        //zookeeper重试的休眠时间,默认为1秒,修改为200毫秒
        configuration.set("zookeeper.recovery.retry.intervalmill", "200");
        //HBase客户端发起一次数据操作直至得到响应之间总的超时时间默认为20分钟,修改为30秒
        configuration.set("hbase.client.operation.timeout", "30000");
        connection = ConnectionFactory.createConnection(configuration);
        System.out.println("get test");
        Table table = connection.getTable(TableName.valueOf("test1"));

//        System.out.println("get test over");
//        System.out.println(table.get(new Get("1234".getBytes())));
//        System.out.println("over");
        Put put = new Put("1234".getBytes());
        put.addColumn("test".getBytes(),"test".getBytes(),"456".getBytes());
        table.put(put);
    }
}
