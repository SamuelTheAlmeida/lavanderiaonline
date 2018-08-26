import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {
    // classe DAO que contém somente métodos relacionados a manipulação do banco, na tabela tb_usuario
    public ArrayList<Usuario> listaUsuarios(){
        // instancia uma conexão
        Connection con = ConnectionFactory.getConnection();
        
        // query para listar todos os usuários
        String query = "SELECT * FROM tb_usuario";
        // lista de Usuarios que irá conter os usuários retornados do select
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            // cria uma consulta ao banco de dados com a query declarada
            PreparedStatement st = con.prepareStatement(query);
            // executa a consulta, guardando o resultado na variável rs
            // o ResultSet sempre aponta para o próxima linha com o .next()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                // para cada linha retornada, cria um Usuario e joga na lista
                // rs.getInt(1) significa obter o inteiro que está na primeira coluna
                // no caso, obtém o id_usuario
                // poderia ser também: rs.getInt("id_usuario"), também funciona
                Usuario usu = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                usuarios.add(usu);
            }
        } catch (SQLException e) {
            // joga exceção em caso de algum erro
            throw new RuntimeException(e);
        }
        // retorna a lista de Usuarios
        return usuarios;
    }
    
    public Usuario consultaUsuario(String login, String senha){
        // método para consultar um usuário específico no banco, usado para logar
        // cria um objeto usuário null, que será preenchido depois
        Usuario usu = null;
        // obtém conexão com o banco
        Connection con = ConnectionFactory.getConnection();
        // cria a query
        // cada "?" é um parâmetro que será definido depois
        String query = "SELECT * FROM tb_usuario WHERE login_usuario = ? AND senha_usuario = ?";
        // cria a lista de Usuarios que será preenchida pelo resultado da query
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            // cria uma consulta ao banco de dados com a query declarada
            PreparedStatement st = con.prepareStatement(query);
            // define os parâmetros do WHERE
            st.setString(1, login);
            st.setString(2, senha);
            // executa a query e grava no resultset
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                // cria um objeto Usuario com os dados retornados do banco
                usu = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            // joga exceção em caso de falha
            throw new RuntimeException(e);
        }
        return usu; // retorna o Usuario obtido 
        // se usuario não existir, vai retornar null
    }
    
    public boolean cadastraUsuario(Usuario usuario) {
        // método de cadastro no banco, returna true em caso de sucesso, false em caso de falha
        Connection con = null;
        con = ConnectionFactory.getConnection();
        // query não precisa definir o id_usuario, pois a coluna possui auto_increment
        String query = "INSERT INTO tb_usuario(login_usuario, nome_usuario, senha_usuario) VALUES (?, ?, ?)";
        try {
            // prepara a query
            PreparedStatement st = con.prepareStatement(query);
            // define os parametros
            st.setString(1, usuario.getLoginUsuario());
            st.setString(2, usuario.getNomeUsuario());
            st.setString(3, usuario.getSenhaUsuario());
            // o insert não retorna um resultSet, então utilizamos o executeUpdate()
            // o executeUpdate() retorna o número de linhas inseridas
            // se uma linha foi inserida, então retorna true
            // caso contrário retorna false
            return (st.executeUpdate() == 1);
        } catch (SQLException e) {
            // exceção em caso de falha
            throw new RuntimeException(e);
        }
    }
}
