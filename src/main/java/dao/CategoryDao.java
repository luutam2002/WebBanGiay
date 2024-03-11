package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.CategoryBean;

public class CategoryDao {
	public ArrayList<CategoryBean> getLoai() throws Exception{
		ArrayList<CategoryBean> list = new  ArrayList<CategoryBean>();
		//b1 ket noi
		ketnoidao kn = new ketnoidao();
		kn.KetNoi();
		String sql = "Select * from Category";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//b4 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5 duyet rs de luu vao mang 
		while(rs.next()) {
			String cid = rs.getString("cid");
			String cname = rs.getString("cname");
			list.add(new CategoryBean(cid, cname));
		}
		rs.close();
		kn.cn.close();
		return list;
	}
}
