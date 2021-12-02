package Model;

public class JB_Pelagem {
	private int idpelagem;
	private String nome;
	
	public JB_Pelagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Pelagem(int idpelagem, String nome) {
		super();
		this.idpelagem = idpelagem;
		this.nome = nome;
	}

	public int getIdpelagem() {
		return idpelagem;
	}

	public void setIdpelagem(int idpelagem) {
		this.idpelagem = idpelagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
