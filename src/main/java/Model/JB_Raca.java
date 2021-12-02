package Model;

public class JB_Raca {

	private int idraca;
	private int idespecie;
	private String nome;
	private String nomeespecie;
	
	public JB_Raca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Raca(int idraca, int idespecie, String nome, String nomeespecie) {
		super();
		this.idraca = idraca;
		this.idespecie = idespecie;
		this.nome = nome;
		this.nomeespecie=nomeespecie;
	}

	public int getIdraca() {
		return idraca;
	}

	public void setIdraca(int idraca) {
		this.idraca = idraca;
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
	
	public String getNomeEspecie() {
		return nomeespecie;
	}

	public void setNomeEspecie(String nomeespecie) {
		this.nomeespecie = nomeespecie;
	
	}
}
