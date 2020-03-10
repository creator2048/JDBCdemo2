package com.jdbc.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.util.JDBCUtil;

public class BlobTest {
	public static void main(String[] args) throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "select * from student where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ResultSet res = ps.executeQuery();
		if (res.next()) {
			//获取图片
			Blob blob = res.getBlob("img");
			//获取图片二进制流
			InputStream in = blob.getBinaryStream();
			//把程序当中的文件写入磁盘
			Files.copy(in, Paths.get("d:/test2.jpg"));
			
		}
		JDBCUtil.close(conn, ps, null);
	}
	void write() throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (img) values(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		// 读取磁盘中的文件，将它转成能识别的二进制文件
		// FileInputStream 输入流
		// 把电脑中的程序放在程序当中（二进制）
		FileInputStream in = new FileInputStream("d:/test.jpg");
		ps.setBlob(1, in);
		ps.executeUpdate();
		JDBCUtil.close(conn, ps, null);
	}
}
