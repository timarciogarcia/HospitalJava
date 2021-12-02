package Model;

import java.util.ArrayList;

import DAO.Dao_Especie;

public class JB_Especie {
	private int idespecie;
	private String nome;
	
	public JB_Especie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Especie(int idespecie, String nome) {
		super();
		this.idespecie = idespecie;
		this.nome = nome;
	}

	public int getIdespecie() {
		return idespecie;
	}

	public void setIdespecie(int idespecie) {
		this.idespecie = idespecie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<JB_Especie> EspeciesparaForm()
	{
		Dao_Especie ListaEspecie = new Dao_Especie();
		return ListaEspecie.listarespecies();
	}

}
