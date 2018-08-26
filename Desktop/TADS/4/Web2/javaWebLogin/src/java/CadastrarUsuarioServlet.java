import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Instancia um objeto DAO para poder acessar a função de inserir no BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // Declara uma variável que guardará a mensagem de sucesso ou falha na inserção
        String result = null;
        // Instancia um objeto Usuario que conterá os dados passados pelo formulario
        Usuario usu = new Usuario();
        // Pega os dados passados pelo formulario
        String usuarioForm = request.getParameter("usuario");
        String nomeForm = request.getParameter("nome");
        String senhaForm = request.getParameter("senha");
        // Verifica se os dados não estão vazios
        if (!usuarioForm.isEmpty() & !nomeForm.isEmpty() & !senhaForm.isEmpty()) {
            // se dados não vazios, então preenche o objeto Usuario
            usu.setLoginUsuario(usuarioForm);
            usu.setNomeUsuario(nomeForm);
            usu.setSenhaUsuario(senhaForm);
            // tenta a inserção no banco e grava o resultado na string result
            if (usuarioDAO.cadastraUsuario(usu)) {
                result = "Usuário cadastrado com sucesso";
            } else {
                result = "Erro ao cadastrar o usuário";
            }
        } else { // dados passados vazios pelo formulario
            result = "Dados inválidos";
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastrarUsuarioServlet</title>");   
            out.println("<link href=\"https://bootswatch.com/3/superhero/bootstrap.css\" rel=\"stylesheet\">");
            out.println("<style type=\"text/css\">\n" +
"    	#center {\n" +
"    		width: 30%;\n" +
"    		margin: 150px auto;\n" +
"    	}\n" +
"    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container text-center\" id=\"center\">");
            // result mostra a string dizendo se inseriu ou não
            out.println("<h1> " + result + "</h1>");
            out.println("<h2>");
            out.println("<a href='PortalServlet'>Retornar</a>");
            out.println("</h2>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
