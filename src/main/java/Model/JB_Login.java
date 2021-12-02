package Model;

import java.util.List;

public class JB_Login {
	private String dominio;
	private int idusuario;
	private String usuario;
	private String nivelacesso;
	private List<?> listaacessos;
	
	public JB_Login(String dominio, int idusuario, String usuario, String nivelacesso, List<?> listaacessos) {
		super();
		this.dominio = dominio;
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.nivelacesso = nivelacesso;
		this.listaacessos = listaacessos;
	}

	public JB_Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNivelacesso() {
		return nivelacesso;
	}

	public void setNivelacesso(String nivelacesso) {
		this.nivelacesso = nivelacesso;
	}

	public List<?> getListaacessos() {
		return listaacessos;
	}

	public void setListaacessos(List<?> listaacessos) {
		this.listaacessos = listaacessos;
	}
	
	
	
	
	
	
}
