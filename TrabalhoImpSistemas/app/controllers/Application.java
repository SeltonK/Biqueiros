
package controllers;

import java.util.List;
import java.util.Map;

import models.Projeto;
import models.User;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	session().clear();
        return ok(index.render("Biqueiros"));
    }
    public static Result home() {
    	Map<String, String[]> getData=request().body().asFormUrlEncoded();
    	List<User> userdb;
    	String userName;
    	String senha;
    	List<Projeto> projetos =  Projeto.find.all();
    	Logger.info(session("id"));
    	if(session().containsKey("connected")){
    		userName = session("connected");
    		userdb = User.find.where("t0.nome= \""+ userName+"\"").findList();
    		for(User user: userdb){
    		return ok(views.html.home.render(projetos,user));
    		}
    	}
    	userName = getData.get("login")[0];
    	senha = getData.get("senha")[0];
    	
    	
    	
    	
    		userdb = User.find.where("t0.login= \""+ userName+"\"").findList();
    		for(User user: userdb){
    			if (user.login.equals(userName) && user.senha.equals(senha)) {
    				session("connected",user.nome);
    				session("id",user.id.toString());
    				Logger.info(session("id"));
    				return ok(views.html.home.render(projetos,user));
				}
    		}
    		
    		return TODO;
 


}
 }