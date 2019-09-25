package webdemo.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.entidades.Produto;

public class ProdutosController extends Controller {

	public ProdutosController(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void list() throws ServletException, IOException {
		List<Produto> produtos = Produto.Todos();

		getRequest().setAttribute("Produtos", produtos);

		getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/list.jsp")
			.forward(getRequest(), getResponse());
	}

	@Override
	public void show(int id) {
		//TODO: Implementar
	}

	@Override
	public void create() throws ServletException, IOException {
		getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/criar.jsp")
			.forward(getRequest(), getResponse());
	}

	@Override
	public void create(Map<String, String> formData) throws IOException, ServletException {

		if(isValid(formData)) {
			String nome = formData.get("nome");
			Double preco = Double.parseDouble(formData.get("preco"));

			Produto produto = new Produto(nome, preco);
			produto.salvar();

			getResponse().sendRedirect("/produtos?success=true");
		}else {
			getRequest()
				.getRequestDispatcher("/WEB-INF/templates/produtos/criar.jsp?success=false")
				.forward(getRequest(), getResponse());
		}
	}

	@Override
	public void edit(int id) throws ServletException, IOException {
		Produto produto = Produto.GetById(id);

		getRequest().setAttribute("Produto", produto);

		getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/editar.jsp")
			.forward(getRequest(), getResponse());	
	}

	@Override
	public void edit(int id, Map<String, String> formData) throws IOException, ServletException {
		Produto produto = Produto.GetById(id);

		String nome = formData.get("nome");
		Double preco = Double.parseDouble(formData.get("preco"));

		if(isValid(formData)) {
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.salvar();

			getResponse().sendRedirect("/produtos?success=true");
		}else {
			Produto produtoInvalido = new Produto(nome, preco);
			produtoInvalido.setId(id);
			getRequest().setAttribute("Produto", produto);

			getRequest()
				.getRequestDispatcher("/WEB-INF/templates/produtos/editar.jsp?success=false")
				.forward(getRequest(), getResponse());
		}
	}

	@Override
	public void delete(int id) throws ServletException, IOException{
		Produto produto = Produto.GetById(id);

		getRequest().setAttribute("Produto", produto);

		produto.remover();

		getResponse().sendRedirect("/produtos?success=true");
	}

	private boolean isValid(Map<String, String> formData) throws UnsupportedEncodingException {
		boolean isValid = true;

		if(!formData.containsKey("nome") || formData.get("nome").isEmpty()) {
			getRequest().setAttribute("NomeInvalido", "O nome é obrigatório!");
			isValid = false;
		}

		if(!formData.containsKey("preco") || formData.get("preco").isEmpty()) {
			getRequest().setAttribute("PrecoInvalido", "O preco é obrigatório!");
			isValid = false;
		}

		return isValid;
	}
}