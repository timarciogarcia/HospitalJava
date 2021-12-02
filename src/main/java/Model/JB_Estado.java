package Model;

public class JB_Estado {

	private int idestado;
	private String uf;
	private String nome;

	//Data em String
	//Date dataAtual = new Date();
    //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    //public String dataexclusao = dateFormat.format(dataAtual);
    //String em Data
    //DateFormat formatter;
    //formatter = new SimpleDateFormat("dd-MM-yyyy");
    //Date data = formatter.parse(request.getParameter("txtData"));
    
    public JB_Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Estado(int idestado, String uf, String nome) {
		super();
		this.idestado = idestado;
		this.uf = uf;
		this.nome = nome;
		
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
