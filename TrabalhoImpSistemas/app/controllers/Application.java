
package controllers;

import java.util.List;
import java.util.Map;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Biqueiros"));
    }
    public static Result home() {
    	Map<String, String[]> getData=request().body().asFormUrlEncoded();
    	String userName = getData.get("login")[0];
    	String senha = getData.get("senha")[0];
    	List<User> userdb;
    	
    		userdb = User.find.where("t0.login= \""+ userName+"\"").findList();
    		for(User user: userdb){
    			if (user.login.equals(userName) && user.senha.equals(senha)) {
    				return ok(views.html.home.render("Login realizado com sucesso",user));
				}
    		}
    		
    		return TODO;
 


}
 }