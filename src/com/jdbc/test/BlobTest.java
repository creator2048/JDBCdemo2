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
			//��ȡͼƬ
			Blob blob = res.getBlob("img");
			//��ȡͼƬ��������
			InputStream in = blob.getBinaryStream();
			//�ѳ����е��ļ�д�����
			Files.copy(in, Paths.get("d:/test2.jpg"));
			
		}
		JDBCUtil.close(conn, ps, null);
	}
	void write() throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into student (img) values(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ��ȡ�����е��ļ�������ת����ʶ��Ķ������ļ�
		// FileInputStream ������
		// �ѵ����еĳ�����ڳ����У������ƣ�
		FileInputStream in = new FileInputStream("d:/test.jpg");
		ps.setBlob(1, in);
		ps.executeUpdate();
		JDBCUtil.close(conn, ps, null);
	}
}
