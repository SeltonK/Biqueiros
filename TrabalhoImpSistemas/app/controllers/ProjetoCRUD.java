package controllers;

import static play.data.Form.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Projeto;
import models.User;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Option;
import scala.Option;

public class ProjetoCRUD extends Controller {


		private static final Form<Projeto> projetoForm = Form.form(Projeto.class);

		public static Result lista(Long id) {

			List<Projeto> usuarios = User.find.ref(id).projetos;


			String userName = "guest";
			return ok(views.html.projeto.render(usuarios,userName));

		}
		
		public static Result remover(Long id) {
			try {
				Projeto.find.ref(id).delete();
				flash("sucesso","Projeto removido com sucesso");
			} catch (Exception e) {
				flash("erro",play.i18n.Messages.get("global.erro"));
			}
			return lista(Long.parseLong(session("id")));
		}

		public static Result novoProjeto() {
			
			return ok(views.html.cadastroProjeto.render(projetoForm));

		}

	public static Result detalhar(Long id) {
			Form<Projeto> userForm = form(Projeto.class).fill(Projeto.find.byId(id));
			return ok(views.html.alterarProjeto.render(id,userForm));
		}

		public static Result alterar(Long id) {
			form(Projeto.class).fill(Projeto.find.byId(id));

			Form<Projeto> alterarForm = form(Projeto.class).bindFromRequest();
			if (alterarForm.hasErrors()) { 
				return badRequest(views.html.alterarProjeto.render(id,alterarForm));
				}
			alterarForm.get().update(id);
			flash("sucesso","Diretor " + alterarForm.get().nome + " alterado com sucesso");

			return redirect(routes.ProjetoCRUD.lista(Long.parseLong(session("id"))));

		}

		public static Result gravar() {
			
			Form<Projeto> form = projetoForm.bindFromRequest();

			User user = User.find.ref(Long.parseLong(session("id")));
			if (form.hasErrors()) {
				flash("erro","Foram identificados problemas no cadastro");
				return badRequest(views.html.cadastroProjeto.render(projetoForm));
			}
			Projeto projeto = form.get();
			projeto.user = user;
			user.projetos.add(projeto);
			user.save();
			projeto.save();
			flash("sucesso","Registro gravado com sucesso");
			return redirect(routes.Application.home());

		}

}
