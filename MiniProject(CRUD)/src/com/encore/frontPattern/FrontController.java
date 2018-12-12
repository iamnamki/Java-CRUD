package com.encore.frontPattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.model.DTO;
import com.encore.model.StudentDTO;
import com.encore.model.userDTO;
import com.encore.util.studentUtil;

@WebServlet("*.nk")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getContextPath();
		System.out.println(path);
		String uri = request.getRequestURI();
		System.out.println(uri);
		String requestURI = uri.substring(path.length(), uri.length());
		RequestDispatcher rd = null;
		response.setCharacterEncoding("utf-8");
		CommonController controller = null;
		Map<String, Object> data = new HashMap<>();
		String page = null;
		String method = request.getMethod().toLowerCase();
		data.put("method", method);
		HttpSession session = request.getSession();

		if (requestURI.equals("/login/signOut.nk")) {
			session.invalidate();
			response.sendRedirect("../index.jsp");
			return;
		}
		Object sessionObj = session.getAttribute("user");
		if (!requestURI.equals("/login/sign.nk") && sessionObj == null) {
			response.sendRedirect(path + "/login/sign.nk");
			return;
		}

		// total_list
		// ======================================================================

		switch (requestURI) {
		case "/student/deleteStudent.nk":
			controller = new deleteStudentController();
			data.put("studentID", request.getParameter("studentID"));
			page = "result.jsp";
			break;
		case "/student/studentselectlist.nk":
			controller = new selectByConditionController2();
			data.put("name", request.getParameter("name"));
			data.put("major_id", request.getParameter("major_id"));
			page = "studentselectlist.jsp";
			break;
		case "/student/studentlist.nk":
			controller = new studentListController();
			page = "studentlist.jsp";
			break;
		case "/student/selectByCondition.nk":
			controller = new selectByConditionController();
			String id = request.getParameter("studentID");
			data.put("studentid", id);
			page = "totalDetail.jsp";
			break;
		// major
		// =======================================================================
		case "/student/deleteMajor.nk":
			controller = new deleteMajorController();
			data.put("major_id", request.getParameter("major_id"));
			page = "result.jsp";
			break;
		case "/student/majorinfo.nk":
			controller = new majorinfoController();
			page = "majorinfo.jsp";
			break;
		case "/student/majorDetail.nk":
			if (method.equals("post")) {
				controller = new majorupdatecontroller();
				String mid = request.getParameter("major_id");
				String title = request.getParameter("major_title");
				data.put("major_id", mid);
				data.put("major_title", title);
				page = "majorDetail.jsp";
			} else {
				controller = new majorupdatecontroller();
				String mid = request.getParameter("major_id");
				data.put("major_id", mid);
				page = "majorDetail.jsp";

			}
			break;
		// student
		// ========================================================================
		case "/student/studentinfo.nk":
			controller = new studentinfoController();
			page = "studentinfo.jsp";
			break;
		case "/student/studentDetail.nk":
			controller = new studentupdatecontroller();
			if (method.equals("get")) {
				String sid = request.getParameter("studentID");
				data.put("studentID", sid);
				page = "studentDetail.jsp";
			} else {
				StudentDTO student = studentUtil.MakeStudent(request);
				data.put("student", student);
				page = "result.jsp";
			}

			break;

		// Login
		// ========================================================================
		case "/login/sign.nk":
			controller = new LoginController();
			if (method.equals("get")) {
				page = "sign.jsp";
			} else {
				String userid = request.getParameter("userid"); // first_name
				String userpass = request.getParameter("userpass"); // last_name
				data.put("userid", userid);
				data.put("userpass", userpass);
			}
			break;
		}

		controller.execute(data);

		Object result = data.get("loginResult");
		if (result != null) {
			String yesno = (String) result;
			if (yesno.equals("yes")) {
				// 인증O index.jsp
				if (data.containsKey("user")) {
					userDTO user = (userDTO) data.get("user");
					session.setAttribute("user", user);
				} else if (data.containsKey("login_student")) {
					StudentDTO login_student = (StudentDTO) data.get("login_student");
					session.setAttribute("user", login_student);
				}
				session.setAttribute("signMessage", " ");
				response.sendRedirect("../index.jsp");
				return;
			} else {
				// 인증X sign.jsp
				session.setAttribute("signMessage", "인증실패");
				response.sendRedirect("sign.nk");
				return;
			}
		}

		for (String key : data.keySet()) {
			System.out.println(key + ":" + data.get(key));
			request.setAttribute(key, data.get(key));
		}
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

}
