package models;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String nome;
	@Required
	public String sobreNome;
	@Required
	public String login;
	@Required
	public String senha;
	@Required
	public String email;
	@Required
	public Date dataNascimento;
	@Required
	public String cpf;
	
	public static Model.Finder<Long,User> find = new Model.Finder<Long,User>(Long.class,User.class);
	
	public static Map<String,String> options() {
		LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
		for (User c : User.find.orderBy("nome").findList()) {
			options.put(c.id.toString(),c.nome);
		}
		return options;
	}
}
