package Model;

public class JB_Departamento {

	private int iddepartamento;
	private String nome;
	
	public JB_Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Departamento(int iddepartamento, String nome) {
		super();
		this.iddepartamento = iddepartamento;
		this.nome = nome;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}	
