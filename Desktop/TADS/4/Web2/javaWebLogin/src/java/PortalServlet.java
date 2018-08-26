import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pega a sessão ativa
        HttpSession session = request.getSession();
        // verifica se os atributos login e senha estão na sessão, ou seja, se o usuário está logado
        if (session.getAttribute("login" ) == null && session.getAttribute("senha") == null) {
            // se não está logado, então redireciona para a erroservlet, passando a mensagem de erro
            request.setAttribute("msg", "Usuário não está logado");
            request.setAttribute("page", "index.html");
            RequestDispatcher rd = request.getRequestDispatcher("/ErroServlet");
            rd.forward(request, response);           
        } else {
            // usuário logado
            // instancia um novo usuarioDAO para listar usuarios do banco
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            // lista de usuários obtida do banco
            ArrayList<Usuario> usuarios = usuarioDAO.listaUsuarios();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Portal</title>"); 
                out.println("<link href=\"https://bootswatch.com/3/superhero/bootstrap.css\" rel=\"stylesheet\">");
                out.println("<style type=\"text/css\">\n" +
"    	#center {\n" +
"    		width: 60%;\n" +
"    		margin: 150px auto;\n" +
"    	}\n" +
"    </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("	<div class=\"container text-center\" id=\"center\">\n" +
"    <div class=\"row\">\n" +
"      <div class=\"col-lg-6\">");
                out.println("<h2>Cadastrar Usuário</h2>");
                out.println("<form method=\"POST\" action=\"CadastrarUsuarioServlet\">\n" +
"      <div class=\"form-group\">\n" +
"        <label for=\"inputUsuario\">Usuario</label>\n" +
"        <input name=\"usuario\" type=\"text\" class=\"form-control\" id=\"inputUsuario\" placeholder=\"Usuario\">\n" +
"      </div>\n" +
"      <div class=\"form-group\">\n" +
"        <label for=\"inputNome\">Nome</label>\n" +
"        <input name=\"nome\" type=\"text\" class=\"form-control\" id=\"inputNome\" placeholder=\"Nome\">\n" +
"      </div>\n" +
"      <div class=\"form-group\">\n" +
"        <label for=\"inputSenha\">Senha</label>\n" +
"        <input name=\"senha\" type=\"password\" class=\"form-control\" id=\"exampleInputSenha\" placeholder=\"Senha\">\n" +
"      </div>\n" +
"      <button type=\"submit\" class=\"btn btn-default\">Salvar</button>\n" +
"    </form>");
                out.println("</div>");
                out.println("<div class=\"col-lg-6\">");
                out.println("  <h2>Usuários Cadastrados</h2>\n" +
"      <table class=\"table table-bordered table-striped table-hover\">\n" +
"        <thead>\n" +
"          <tr>\n" +
"            <td>ID</td>\n" +
"            <td>Nome</td>\n" +
"            <td>Login</td>\n" +
"            <td>Senha</td>\n" +
"          </tr>\n" +
"        </thead>\n" +
"        <tbody>\n");  
           // percorre a lista de usuários, exibindo uma linha na tabela para cada
           for (Usuario user: usuarios) {
                out.println("<tr>");
                out.println("<td>" + user.getIdUsuario() + "</td>");
                out.println("<td>" + user.getNomeUsuario()+ "</td>");
                out.println("<td>" + user.getLoginUsuario() + "</td>");
                out.println("<td>" + user.getSenhaUsuario() + "</td>");
                out.println("</tr>");
            }

            out.println("        </tbody>\n" +
            "      </table>\n");
            out.println("<a href='LogoutServlet'>Logout</a>");   
            out.println("</div></div></div>");
                out.println("</body>");
                out.println("</html>");
            }
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
