package Model;

public class JB_Funcionario {

	private int idfuncionario;
	private String nome;
	private String endereco;
	private String cidade;
	private String bairro;
	private int idestado;
	private String nascimento;
	private String telefone;
	private int iddepartamento;
	private String rg;
	private String cpf;
	private String admissao;
	private String demissao;
	private String cep;
	
	public JB_Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JB_Funcionario(int idfuncionario, String nome, String endereco, String cidade, String bairro,
			int idestado, String nascimento, String telefone, int iddepartamento, String rg, String cpf,
			String admissao, String demissao, String cep) {
		super();
		this.idfuncionario = idfuncionario;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.idestado = idestado;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.iddepartamento = iddepartamento;
		this.rg = rg;
		this.cpf = cpf;
		this.admissao = admissao;
		this.demissao = demissao;
		this.cep = cep;
	}

	public int getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getDemissao() {
		return demissao;
	}

	public void setDemissao(String demissao) {
		this.demissao = demissao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
