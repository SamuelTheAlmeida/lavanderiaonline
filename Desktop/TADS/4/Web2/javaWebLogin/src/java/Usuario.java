public class Usuario {
    // atributos do usuario
    private int idUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String nomeUsuario;

    // construtor vazio, usado para cadastro de novo usuário
    public Usuario() {
        
    }
    
    // construtor completo, usado para listagem e consulta de usuários
    public Usuario(int idUsuario, String loginUsuario, String senhaUsuario, String nomeUsuario) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.nomeUsuario = nomeUsuario;
    }
    
    // getters e setters padrão
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
