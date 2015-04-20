package models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Projeto extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	public Long id;
	
	@Required
	public String nome;
	@Required
	public String descricao;
	@Required
	public String tipo;
	@ManyToOne
	public User user;
	
public static Model.Finder<Long,Projeto> find = new Model.Finder<Long,Projeto>(Long.class,Projeto.class);
	
	public static Map<String,String> options() {
		LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
		for (User c : User.find.orderBy("nome").findList()) {
			options.put(c.id.toString(),c.nome);
		}
		return options;
	}
}
