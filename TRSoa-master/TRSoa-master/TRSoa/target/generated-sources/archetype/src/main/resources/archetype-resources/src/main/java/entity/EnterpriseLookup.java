#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;import javax.persistence.*;import java.io.Serializable;import java.util.List;/** * The persistent class for the enterprise_lookup database table. *  */@Entity@Table(name="enterprise_lookup")@NamedQuery(name="EnterpriseLookup.findAll", query="SELECT e FROM EnterpriseLookup e")public class EnterpriseLookup implements Serializable {	private static final long serialVersionUID = 1L;	@Id	@GeneratedValue(strategy= GenerationType.IDENTITY)	private int id;	private String description;	@Column(name="inactive_ind")	private String inactiveInd;	private String type;	private String value;	public EnterpriseLookup() {	}	public int getId() {		return this.id;	}	public void setId(int id) {		this.id = id;	}	public String getDescription() {		return this.description;	}	public void setDescription(String description) {		this.description = description;	}	public String getInactiveInd() {		return this.inactiveInd;	}	public void setInactiveInd(String inactiveInd) {		this.inactiveInd = inactiveInd;	}	public String getType() {		return this.type;	}	public void setType(String type) {		this.type = type;	}	public String getValue() {		return this.value;	}	public void setValue(String value) {		this.value = value;	}}