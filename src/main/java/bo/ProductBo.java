package bo;

import java.util.ArrayList;

import Bean.ProductBean;
import Bean.ProductBean;
import dao.ProductDao;



public class ProductBo {
	ProductDao pdao = new ProductDao();
	ArrayList<ProductBean> ds;
	 public ArrayList<ProductBean> getAllProduct() throws Exception{
		 ds= pdao.getAllProduct();
			return ds;
		}
	//viet ham de tim kiem theo cid Product
		public ArrayList<ProductBean> TimMa(String maloai) throws Exception{
			ArrayList<ProductBean> tam=new ArrayList<ProductBean>();
			for(ProductBean s:ds) {
				if(s.getCid().equals(maloai));
				tam.add(s);
			}			
			return tam;
		}
		//viet ham de tim theo ten
		public ArrayList<ProductBean> Tim(String key) throws Exception{
			ArrayList<ProductBean> tam = new ArrayList<ProductBean>();
			for(ProductBean s:ds)
				if(s.getName().toLowerCase().contains(key.toLowerCase()))	
					tam.add(s);
			return tam;
		}
	}

