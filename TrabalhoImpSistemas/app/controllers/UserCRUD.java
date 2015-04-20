package controllers;

import static play.data.Form.form;

import java.util.List;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Option;
import scala.Option;

public class UserCRUD extends Controller {


		private static final Form<User> userForm = Form.form(User.class);

		public static Result lista() {

			List<User> usuarios = User.find.orderBy("nome").findList();


			String userName = "guest";
			return ok(views.html.user.render(usuarios,userName));

		}
		
		public static Result remover(Long id) {
			try {
				User user = User.find.ref(id)
								;
				flash("sucesso","Diretor removido com sucesso");
			} catch (Exception e) {
				flash("erro",play.i18n.Messages.get("global.erro"));
			}
			return lista();
		}

		public static Result novoUsuario() {

			return ok(views.html.cadastro.render(userForm));

		}

	public static Result detalhar(Long id) {
			Form<User> userForm = form(User.class).fill(User.find.byId(id));
			return TODO;
		}

		public static Result alterar(Long id) {
			form(User.class).fill(User.find.byId(id));

			Form<User> alterarForm = form(User.class).bindFromRequest();
			if (alterarForm.hasErrors()) { 
				return TODO;
				}
			alterarForm.get().update(id);
			flash("sucesso","Diretor " + alterarForm.get().nome + " alterado com sucesso");

			return redirect(routes.UserCRUD.lista());

		}

		public static Result gravar() {
			Form<User> form = userForm.bindFromRequest();
			if (form.hasErrors()) {
				flash("erro","Foram identificados problemas no cadastro");
				return badRequest(views.html.cadastro.render(userForm));
			}
			User user = form.get();
			user.save();
			// ou form.get().save();
			flash("sucesso","Registro gravado com sucesso");
			return redirect(routes.Application.index());

		}

}
