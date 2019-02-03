package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoImpl.UtilisateurDaoImp;
import jpa.EntityManagerHelper;
import service.UtilisateurService;

@WebServlet(name="UserInfo2",
urlPatterns={"/UserInfo2"})
public class UserInfo2 extends HttpServlet {
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDaoImp utilisateurDaoImp ;
	UtilisateurService utilisateurService;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("utilisateurs", utilisateurDaoImp.getListUtilisateur());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("accueil.jsp").forward(request,response);
	}
}