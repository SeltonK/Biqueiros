
package controllers;

import java.util.Map;

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
    	
    	if (userName.equals("Binho") && senha.equals("123")) {
    		return ok(views.html.home.render("Voce Logou"));
			
		}else{
    	
    	
        return ok(views.html.home.render("Voce se fudeu"));
        }
    }

}