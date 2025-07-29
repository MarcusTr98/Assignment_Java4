package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BanDAO;
import entity.BanEntity;

/**
 * Servlet implementation class BanServlet
 */
@WebServlet({ "/ban/hien-thi", "/ban/add", "/ban/remove" })
public class BanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BanDAO banDAO = new BanDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getRequestURI().contains("/hien-thi")) {
			request.setAttribute("listBan", banDAO.getAll());
			request.getRequestDispatcher("/views/hien-thi.jsp").forward(request, response);
		}
		else if (request.getRequestURI().contains("/ban/remove")) {
			int id = Integer.parseInt(request.getParameter("id"));
			banDAO.delete(id);
			String path = request.getContextPath();
			response.sendRedirect(path + "/ban/hien-thi");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getRequestURI().contains("/add")) {
			int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
			String ma = request.getParameter("ma");
			String ten = request.getParameter("ten");
			String soThich = request.getParameter("soThich");

			// Validate rỗng
			boolean error = false;
			if (ma == null || ma.trim().isEmpty()) {
				request.setAttribute("loiMa", "Mã bạn không được để trống!");
				error = true;
			}
			if (ten == null || ten.trim().isEmpty()) {
				request.setAttribute("loiTen", "Tên bạn không được để trống!");
				error = true;
			}
			if (soThich == null || soThich.trim().isEmpty()) {
				request.setAttribute("loiSoThich", "Sở thích không được để trống!");
				error = true;
			}

			// Trả lại trang nếu có lỗi
			if (error) {
				request.setAttribute("listBan", banDAO.getAll());
				request.getRequestDispatcher("/views/hien-thi.jsp").forward(request, response);
				return;
			}

			BanEntity ban = new BanEntity(ma, ten, soThich, gioiTinh);
			banDAO.insert(ban);
			String path = request.getContextPath();
			response.sendRedirect(path + "/ban/hien-thi");
		}
	}

}
