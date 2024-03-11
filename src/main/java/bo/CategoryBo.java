package bo;

import java.util.ArrayList;

import Bean.CategoryBean;
import Bean.CategoryBean;
import dao.CategoryDao;


public class CategoryBo {
	CategoryDao ldao = new CategoryDao();
	 public ArrayList<CategoryBean> getloai() throws Exception{
			return ldao.getLoai();
		}
	
}
