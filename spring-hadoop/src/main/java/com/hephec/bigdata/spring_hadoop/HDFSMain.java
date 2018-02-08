package com.hephec.bigdata.spring_hadoop;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Hadoop HDFS JAVA API操作
 * 
 * @author hephe
 *
 */
public class HDFSMain {

	public static final String HFDS_PATH = "hdfs://192.168.11.88:8020";
	
	
	FileSystem fileSystem = null;
	Configuration configuration = null;
	FSDataInputStream in = null;
	
	/**
	 * 创建HDFS目录
	 * 
	 * @throws Exception
	 */
	@Test
	public void mkdir() throws Exception{
		fileSystem.mkdirs(new Path("hdfsapi/test1"));
	}
	
	/**
	 * 创建文件
	 * 
	 * @throws Exception
	 */
	@Test
	public void create() throws Exception{
		FSDataOutputStream output = fileSystem.create(new Path("/t.txt"));
		output.writeChars("test test test test test test test test test test test test test");
		
	}
	/**
	 * 查看HDFS文件的内容
	 * @throws Exception
	 */
	@Test
	public void cat() throws Exception{
		in = fileSystem.open(new Path("/t.txt"));
		IOUtils.copyBytes(in, System.out, 1024);
		
	}
	/**
	 * 重命名
	 * s
	 * @throws Exception
	 */
	@Test
	public void rename() throws Exception{
		Path src = new Path("");
		Path dst = new Path("");
		fileSystem.rename(src, dst);
	}
	
	/**
	 * 从HDFS下载文件到本地
	 * 
	 * @throws Exception
	 */
	@Test
	public void copyToLocalFile() throws Exception{
		Path localPath = new Path("");
		Path hdfsPath = new Path("");
		fileSystem.copyToLocalFile(hdfsPath, localPath);
	}
	/**
	 * 查看hdfs文件目录下的文件
	 * @throws Exception
	 */
	@Test
	public void listFiles() throws Exception{
		FileStatus[] fileStatus = fileSystem.listStatus(new Path("/"));
		for (FileStatus fileStatus2 : fileStatus) {
			boolean isDir = fileStatus2.isDirectory();
			System.out.println("dir");
			fileStatus2.getReplication();
			fileStatus2.getLen();
			fileStatus2.getPermission();
			
		}
		
	}
	@Before
	public void setUp()throws Exception{
		System.out.println("setUp...");
		configuration = new Configuration();
		//configuration.set("fs.default.name", "hdfs://192.168.11.88:8020");
		fileSystem = FileSystem.get(new URI(HFDS_PATH),configuration);
		
	}
	
	
	@After
	public void tearDown() throws Exception{
		configuration = null;
		fileSystem.close();
		in.close();
		System.out.println("tearDown...");
	}
}
