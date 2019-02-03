package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
import service.UtilisateurService;

@WebServlet(name="utilisateurServelet",
urlPatterns={"/utilisateurServelet"})
public class UtilisateurServelet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	UtilisateurDaoImp utilisateurDaoImp = new UtilisateurDaoImp();
	UtilisateurService utilisateurService;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("utilisateurs", utilisateurDaoImp.getListUtilisateur());
			PrintWriter out = response.getWriter();
			List<Utilisateur> list = utilisateurDaoImp.getListUtilisateur();
			out.println("<H1>Recapitulatif des informations</H1>\n");
			for(Utilisateur u : list) {
			out.println("<HTML>\n<BODY>\n" +
					"<UL>\n" +			
					" <LI>Mail: "
					+ u.getMail()+
					" <LI>Nom: "
					+ u.getNom()+
					"\n"+
					" <LI>Prenom: "
					+ u.getPrenom()+
					"</UL>\n" +				
					"</BODY></HTML>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.getServletContext().getRequestDispatcher("/index.jsp?utilisateurs").forward(request,response);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("mail");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setMail(email);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateurDao.save(utilisateur);
		PrintWriter out = response.getWriter();
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
	}
}
