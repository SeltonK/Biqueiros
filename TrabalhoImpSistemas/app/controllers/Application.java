package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Biqueiros"));
    }
    public static Result home() {
        return ok(views.html.home.render("Biqueiros"));
    }
    public static Result cadastro() {
        return ok(views.html.cadastro.render("Biqueiros"));
    }
    public static Result mensagens() {
        return ok(views.html.mensagens.render("Biqueiros"));
    }
}