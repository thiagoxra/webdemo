

package webdemo.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Esta classe está emulando um repositório de dados no modelo ActiveRecord
public class Produto {
			
	private int id;
	private String nome;
	private String descricao;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public void salvar() {
		if(this.id == 0) {
			_ProdutoSeq++;
			this.setId(_ProdutoSeq);
			_ProdutosDict.put(_ProdutoSeq, this);
		}else {
			_ProdutosDict.replace(this.getId(), this);
		}
	}
	
	public void remover() {
		_ProdutosDict.remove(this.id);
	}
	
	public static List<Produto> Todos(){
		return new ArrayList<Produto>(_ProdutosDict.values());
	}
	
	public static Produto GetById(int id) {
		return _ProdutosDict.get(id);
	}
	
	private static HashMap<Integer, Produto> _ProdutosDict = new HashMap<>();
	private static int _ProdutoSeq = 0;
}
