	package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.CategoryBean;
import Bean.ProductBean;
import bo.CategoryBo;
import bo.ProductBo;


/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			//sai ProductBo lay ve dslop
			CategoryBo lbo = new CategoryBo();
			ArrayList<CategoryBean> listCC = lbo.getloai();
			ProductBo pbo = new ProductBo();
			ArrayList<ProductBean> listP = pbo.getAllProduct();
			// lay ve ml va txttim tu home.jsp
			String ml = request.getParameter("ml");
			String key = request.getParameter("txttim");
//			if(ml!=null)
//			{
//				listP = pbo.TimMa(ml);
//			}else{
//					if(key!= null){
//						listP = pbo.Tim(key);
//						}
//			} 
			//chuyen dslop va dshocvien ve ht.sach
			request.setAttribute("listP", listP);
			request.setAttribute("listCC",listCC);
			//request.setAttribute("p", list);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
