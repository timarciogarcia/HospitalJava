package Model;

public class JB_Patologia {
	private int idpatologia;
	private String nome;
	private String descricao;
	
	public JB_Patologia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Patologia(int idpatologia, String nome, String descricao) {
		super();
		this.idpatologia = idpatologia;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getIdpatologia() {
		return idpatologia;
	}

	public void setIdpatologia(int idpatologia) {
		this.idpatologia = idpatologia;
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

	
	
	
	
}
