package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.ProductBean;


public class ProductDao {
	public ArrayList<ProductBean> getAllProduct() throws Exception{
		ArrayList<ProductBean> list= new ArrayList<ProductBean>();
		//b1 ket noi
		ketnoidao kn = new ketnoidao();
		kn.KetNoi();
		String sql="select * from product";
		//B3: tao cau lenh prepareStatemnt
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//b4 thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//b5 duyet rs de luu vao mang 
		while(rs.next()) {
			int id=rs.getInt("id");
			String name= rs.getString("name");
			String image= rs.getString("image");
			Double price = rs.getDouble("price");
			String description = rs.getString("description");
			String cid = rs.getString("cid");
			list.add(new ProductBean(id, name, image, price, description, cid));
		}
		//b6: dong ket  noi va rs
				rs.close();
				kn.cn.close();
			return list;
	}
}
//	public static void main(String [] args) {
//		productdao dao = new productdao();
//		ArrayList<ProductBean> list = dao.getAllproduct() ;
//		for(ProductBean o : list) {
//			System.out.println(o);
//		}
//	}
