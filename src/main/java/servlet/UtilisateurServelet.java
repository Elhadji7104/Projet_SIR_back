package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Utilisateur;
import service.UtilisateurService;

@WebServlet(name="utilisateur",
urlPatterns={"/utilisateur"})
public class UtilisateurServelet extends HttpServlet {
	

    private UtilisateurService utilisateurService;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Utilisateur> utilisateurs =  utilisateurService.findAll();
	        request.setAttribute("utilisateurs", utilisateurs); // Will be available as ${products} in JSP
	        request.getRequestDispatcher("/testjpa/src/main/webapp/accueil.jsp").forward(request, response);
	    }
}
