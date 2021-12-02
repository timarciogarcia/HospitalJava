package Model;

import java.util.ArrayList;

import DAO.Dao_Grupovacina;

public class JB_Grupovacina {
	private int idgrupovacina;
	private String nome;
	
	public JB_Grupovacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Grupovacina(int idgrupovacina, String nome) {
		super();
		this.idgrupovacina = idgrupovacina;
		this.nome = nome;
	}

	public int getIdgrupovacina() {
		return idgrupovacina;
	}

	public void setIdgrupovacina(int idgrupovacina) {
		this.idgrupovacina = idgrupovacina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<JB_Grupovacina> GrupovacinaparaForm()
	{
		Dao_Grupovacina ListaEspecie = new Dao_Grupovacina();
		return ListaEspecie.listargrupovacinas();
	}	

}
