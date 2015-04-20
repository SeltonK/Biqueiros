package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Projeto;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Option;
import scala.Option;

public class ProjetoCRUD extends Controller {


		private static final Form<Projeto> projetoForm = Form.form(Projeto.class);

		public static Result lista() {

			List<Projeto> usuarios = Projeto.find.orderBy("nome").findList();


			String userName = "guest";
			return TODO;

		}
		
		public static Result remover(Long id) {
			try {
				Projeto user = Projeto.find.ref(id)
								;
				flash("sucesso","Diretor removido com sucesso");
			} catch (Exception e) {
				flash("erro",play.i18n.Messages.get("global.erro"));
			}
			return lista();
		}

		public static Result novoProjeto() {

			return ok(views.html.cadastroProjeto.render(projetoForm));

		}

	public static Result detalhar(Long id) {
			Form<Projeto> userForm = form(Projeto.class).fill(Projeto.find.byId(id));
			return TODO;
		}

		public static Result alterar(Long id) {
			form(Projeto.class).fill(Projeto.find.byId(id));

			Form<Projeto> alterarForm = form(Projeto.class).bindFromRequest();
			if (alterarForm.hasErrors()) { 
				return TODO;
				}
			alterarForm.get().update(id);
			flash("sucesso","Diretor " + alterarForm.get().nome + " alterado com sucesso");

			return TODO;

		}

		public static Result gravar() {
			Form<Projeto> form = projetoForm.bindFromRequest();
			if (form.hasErrors()) {
				flash("erro","Foram identificados problemas no cadastro");
				return badRequest(views.html.cadastroProjeto.render(projetoForm));
			}
			Projeto user = form.get();
			user.save();
			// ou form.get().save();
			flash("sucesso","Registro gravado com sucesso");
			return redirect(routes.Application.index());

		}

}
