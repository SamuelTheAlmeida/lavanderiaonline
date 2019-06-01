/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMUEL
 */
import model.Pessoa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name="PessoaMB")
@SessionScoped
public class PessoaManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public List<Pessoa> getPessoas() {
        Session session = HibernateUtil.getSessionFactory().
        openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Pessoa");
        this.pessoas = query.list();
        session.getTransaction().commit();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

        
    public String cadastrar(){
        Session session = HibernateUtil.getSessionFactory().
        openSession();

        session.beginTransaction();
        session.save(pessoa);
        session.getTransaction().commit();
        System.out.println(pessoa.getNome() + " Inserido com sucesso.");
        return "lista";
    }
    
    
}