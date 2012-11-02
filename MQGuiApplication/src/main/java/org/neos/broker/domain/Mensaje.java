package org.neos.broker.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author camus
 */
@Entity
@Table(name = "TW_MENSAJE")
public class Mensaje implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "ID_MENSAJE")
	private Integer idMensaje;
	
	@Column(name = "TITULO_MENSAJE", nullable = false, length = 50)
	private String tituloMensaje;
	
	@Column(name = "REQUEST_MESSAGE", nullable = false, length = 5000)
	private String requestMensaje;
	
	@Column(name = "RESPONSE_MESSAGE", nullable = false, length = 5000)
	private String responseMensaje;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "ID_CONEXION", nullable = false)
	private Conexion conexion;
	
    
	public Integer getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(Integer idMensaje) {
		this.idMensaje = idMensaje;
	}
	public String getTituloMensaje() {
		return tituloMensaje;
	}
	public void setTituloMensaje(String tituloMensaje) {
		this.tituloMensaje = tituloMensaje;
	}
	public String getRequestMensaje() {
		return requestMensaje;
	}
	public void setRequestMensaje(String requestMensaje) {
		this.requestMensaje = requestMensaje;
	}
	public String getResponseMensaje() {
		return responseMensaje;
	}
	public void setResponseMensaje(String responseMensaje) {
		this.responseMensaje = responseMensaje;
	}
	public Conexion getConexion() {
		return conexion;
	}
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
}
