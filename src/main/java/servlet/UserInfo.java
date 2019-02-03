
package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.UtilisateurDaoImp;
import jpa.EntityManagerHelper;
import metier.Utilisateur;

@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
	
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setMail(email);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateurDao.save(utilisateur);
		PrintWriter out = response.getWriter();
		this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request,response);
	}
}
