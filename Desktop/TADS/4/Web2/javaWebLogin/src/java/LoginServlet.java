import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pega os dados passados pelo formulario de login
        String usuarioForm = request.getParameter("usuario");
        String senhaForm = request.getParameter("senha");
        // instancia um usuarioDAO para usar a função de consulta no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // consulta se o usuário existe no banco, e guarda o usuario retornado (pode ser null)
        Usuario usuario = usuarioDAO.consultaUsuario(usuarioForm, senhaForm);
        
        // se usuario veio null, então falhou o login
        if (usuario == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ErroServlet");
            request.setAttribute("msg", "Erro no login");
            request.setAttribute("page", "index.html");
            dispatcher.forward(request,response);
        } else {
            // usuário existe, então cria ou reutiliza uma sessão
            HttpSession session = request.getSession(true);
            // grava o login e a senha na sessão
            session.setAttribute("login", usuarioForm);
            session.setAttribute("senha", senhaForm);
            // redireciona para o portalservlet
            response.sendRedirect("PortalServlet");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
