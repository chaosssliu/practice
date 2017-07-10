#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;import javax.persistence.*;import java.io.Serializable;import java.util.List;/** * The persistent class for the project_lookup database table. *  */@Entity@Table(name="project_lookup")@NamedQuery(name="ProjectLookup.findAll", query="SELECT p FROM ProjectLookup p")public class ProjectLookup implements Serializable {	private static final long serialVersionUID = 1L;	@Id	@GeneratedValue(strategy= GenerationType.IDENTITY)	private int id;	@Column(name="inactive_ind")	private String inactiveInd;	private String type;	private String value;	//bi-directional many-to-one association to Project	@OneToMany(mappedBy= "status")	private List<Project> projects;	//bi-directional many-to-one association to Enterprise	@ManyToOne	private Enterprise enterprise;	//bi-directional many-to-one association to ProjectStatusTrack	@OneToMany(mappedBy="projectLookup")	private List<ProjectStatusTrack> projectStatusTracks;	//bi-directional one-to-one association to ProjectUserAssoc	@OneToOne(mappedBy="projectLookup")	private ProjectUserAssoc projectUserAssoc;	public ProjectLookup() {	}	public ProjectLookup(int id) {		this.id = id;	}	public int getId() {		return this.id;	}	public void setId(int id) {		this.id = id;	}	public String getInactiveInd() {		return this.inactiveInd;	}	public void setInactiveInd(String inactiveInd) {		this.inactiveInd = inactiveInd;	}	public String getType() {		return this.type;	}	public void setType(String type) {		this.type = type;	}	public String getValue() {		return this.value;	}	public void setValue(String value) {		this.value = value;	}	public List<Project> getProjects() {		return this.projects;	}	public void setProjects(List<Project> projects) {		this.projects = projects;	}	public Project addProject(Project project) {		getProjects().add(project);		project.setStatus(this);		return project;	}	public Project removeProject(Project project) {		getProjects().remove(project);		project.setStatus(null);		return project;	}	public Enterprise getEnterprise() {		return this.enterprise;	}	public void setEnterprise(Enterprise enterprise) {		this.enterprise = enterprise;	}	public List<ProjectStatusTrack> getProjectStatusTracks() {		return this.projectStatusTracks;	}	public void setProjectStatusTracks(List<ProjectStatusTrack> projectStatusTracks) {		this.projectStatusTracks = projectStatusTracks;	}	public ProjectStatusTrack addProjectStatusTrack(ProjectStatusTrack projectStatusTrack) {		getProjectStatusTracks().add(projectStatusTrack);		projectStatusTrack.setProjectLookup(this);		return projectStatusTrack;	}	public ProjectStatusTrack removeProjectStatusTrack(ProjectStatusTrack projectStatusTrack) {		getProjectStatusTracks().remove(projectStatusTrack);		projectStatusTrack.setProjectLookup(null);		return projectStatusTrack;	}	public ProjectUserAssoc getProjectUserAssoc() {		return this.projectUserAssoc;	}	public void setProjectUserAssoc(ProjectUserAssoc projectUserAssoc) {		this.projectUserAssoc = projectUserAssoc;	}}