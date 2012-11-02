package org.neos.broker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



/**
 *
 * @author camus
 */
@Entity
@Table(name = "TC_CONEXION")
public class Conexion implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CONEXION" ,nullable = false, length = 50)
	private String idConexion;
	
	@Column(name = "TIPO_AMBIENTE", nullable = false)
	private String tipoAmbiente;
	
	@Column(name = "HOST", nullable = false, length = 100)
	private String host;
	
	@Column(name = "QMANAGER", nullable = false, length = 100)
	private String qManager;
	
	@Column(name = "QPUT", nullable = false, length = 100)
	private String qPut;
	
	@Column(name = "QGET", nullable = false, length = 100)
	private String qGet;
	
	@Column(name = "QPORT", nullable = false)
	private Integer qPort;
	
	@Column(name = "QCHANEL", nullable = false, length = 100)
	private String qChanel;
	
	@Column(name = "FECHA_ALTA", nullable = false)
	private Date fechaAlta;
	
	@Column(name = "BND_SECURITY", nullable = false)
	private Integer bndSecurity;
	
	@ManyToOne(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	
        @OneToMany(mappedBy="conexion", cascade= CascadeType.ALL,fetch= FetchType.EAGER)        
	private Set<Mensaje> mensaje;

   
	public String getIdConexion() {
		return idConexion;
	}
	public void setIdConexion(String idConexion) {
		this.idConexion = idConexion;
	}
	public String getTipoAmbiente() {
		return tipoAmbiente;
	}
	public void setTipoAmbiente(String tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getqManager() {
		return qManager;
	}
	public void setqManager(String qManager) {
		this.qManager = qManager;
	}
	public String getqPut() {
		return qPut;
	}
	public void setqPut(String qPut) {
		this.qPut = qPut;
	}
	public String getqGet() {
		return qGet;
	}
	public void setqGet(String qGet) {
		this.qGet = qGet;
	}
	public Integer getqPort() {
		return qPort;
	}
	public void setqPort(Integer qPort) {
		this.qPort = qPort;
	}
	public String getqChanel() {
		return qChanel;
	}
	public void setqChanel(String qChanel) {
		this.qChanel = qChanel;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Integer getBndSecurity() {
		return bndSecurity;
	}
	public void setBndSecurity(Integer bndSecurity) {
		this.bndSecurity = bndSecurity;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Set<Mensaje> getMensaje() {
		return mensaje;
	}
	public void setMensaje(Set<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}
        
        public void addMessage(Mensaje msg) {
            if (mensaje!=null) {
                   mensaje.add(msg);
            } else {
                mensaje = new HashSet<Mensaje>();
                mensaje.add(msg);
            }
        }
}
