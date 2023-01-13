package bibliotheque.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", columnDefinition = "ENUM('admin','inscrit','bibliothecaire')" )
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME, 
		include = JsonTypeInfo.As.PROPERTY, 
		property = "type")
@JsonSubTypes({ 
	@Type(value = Bibliothecaire.class, name = "bibliothecaire"), 
	@Type(value = Inscrit.class, name = "inscrit"),
	@Type(value = Admin.class, name = "admin")})
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	protected Integer id;

	@Column(unique = true, nullable=false)
	@JsonView(Views.ViewBase.class)
	protected String login;

	@JsonView(Views.ViewBase.class)
	@Column(nullable=false)
	protected String password;

	public Compte() {}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}