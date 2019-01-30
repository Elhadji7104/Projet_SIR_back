package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import daoImpl.UtilisateurDaoImp;
import jpa.EntityManagerHelper;
import metier.Utilisateur;
import service.UtilisateurService;
@PersistenceUnit
@WebServlet(name="userInfo2",
urlPatterns={"/UserInfo2"})
public class UserInfo2 extends HttpServlet {
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDaoImp utilisateurDaoImp ;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int i = 0;
	
		request.setAttribute("utilisateur",utilisateurDaoImp.getListUtilisateur());
		response.setContentType("text/html");
		utilisateurDaoImp.commit();
		PrintWriter out = response.getWriter();
		while(i<4) {
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +			
				" <LI>Mail: "
				+ request.getParameter("MAIL") + "\n" +
				" <LI>Nom: "
				+ request.getParameter("NOM") + "\n" +
				" <LI>Prenom: "
				+ request.getParameter("PRENOM") + "\n" +
				"</UL>\n" +				
				"</BODY></HTML>");
		i++;
		}
	}
}
