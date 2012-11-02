package org.neos.broker.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author camus
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario implements  Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;
	
	@Column(name = "USUARIO", nullable = false, length = 20)
	private String usuario;
	
	
	@Column(name = "PASSWORD", nullable = false, length = 10)
	private String password;
	
   
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
