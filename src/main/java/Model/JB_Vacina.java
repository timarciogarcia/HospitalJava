package Model;

public class JB_Vacina {
	private int idvacina;
	private String nome;
	private int status;
	private int idgrupovacina;
	private String laboratorio;
	private String nomegrupovacina;

	
	public JB_Vacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Vacina(int idvacina, int status, String nome, int idgrupovacina, String laboratorio, String nomegrupovacina) {
		super();
		this.idvacina = idvacina;
		this.nome = nome;
		this.status = status;
		this.idgrupovacina = idgrupovacina;
		this.laboratorio = laboratorio;
		this.nomegrupovacina = nomegrupovacina;
	}

	public int getIdvacina() {
		return idvacina;
	}

	public void setIdvacina(int idvacina) {
		this.idvacina = idvacina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdgrupovacina() {
		return idgrupovacina;
	}

	public void setIdgrupovacina(int idgrupovacina) {
		this.idgrupovacina = idgrupovacina;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getNomegrupovacina() {
		return nomegrupovacina;
	}

	public void setNomegrupovacina(String nomegrupovacina) {
		this.nomegrupovacina = nomegrupovacina;
	}

	
    
	
}
