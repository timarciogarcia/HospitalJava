import java.util.ArrayList;

public class Auxiliar {
	
	private ArrayList<String> ArrayCampos = new ArrayList<>();
	private String Tabela;
	private int Tipo;

	public Auxiliar(ArrayList<String> arrayCampos, String tabela, int tipo) {
		super();
		// Traz Campos INPUT da Pagina HTML em Forma de Array
		ArrayCampos = arrayCampos;
		Tabela = tabela;
		Tipo = tipo;
		
		if (this.Tipo == 1 ){ // Inserção no Banco de Dados
			
		}else if (this.Tipo == 2 ) { // Alteração no Banco de Dados
		
		}else if (this.Tipo == 3 ) { // Exclusão no Banco de Dados
			
		}
	}

	public ArrayList<String> getArrayCampos() {
		return ArrayCampos;
	}

	public void setArrayCampos(ArrayList<String> arrayCampos) {
		ArrayCampos = arrayCampos;
	}

	public String getTabela() {
		return Tabela;
	}

	public void setTabela(String tabela) {
		Tabela = tabela;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}
	
	@SuppressWarnings("unused")
	private void Inserir(int Tipo, String Tabela,ArrayList<String> ArrayCampos) {
		String Selecao = null;
		String Campos = null;
		String Valores = null;
		for(int n=1;n <= ArrayCampos.size(); n++) {
			Campos = Campos +ArrayCampos.get(n); 
		}
		Selecao = "Insert into " + Tabela + "(";
		Selecao = Selecao + Campos;
		Selecao = Selecao + ") VALUES(";
	}
	
	@SuppressWarnings("unused")
	private void Alterar() {
		
	}

	@SuppressWarnings("unused")
	private void Excluir() {
		
	}
}
