#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;import org.apache.commons.lang3.builder.EqualsBuilder;import org.apache.commons.lang3.builder.HashCodeBuilder;import javax.persistence.*;import java.io.Serializable;import java.util.Date;import java.util.List;import java.util.Set;/** * The persistent class for the ts_approval database table. *  */@Entity@Table(name="ts_approval")@NamedQueries({	@NamedQuery(name="TsApproval.findAll", query="SELECT t FROM TsApproval t"),	@NamedQuery(name="TsApproval.findById", query="SELECT t FROM TsApproval t where t.id = :id"),	@NamedQuery(name="TsApproval.updateStatusById", query="Update TsApproval t SET t.status.id = :statusId, t.statusDate = :statusDate, t.comment = :comment where t.id = :approvalId"),	@NamedQuery(name="TsApproval.findPendingTsToApproveByApproverId", query="SELECT t FROM TsMain t where t.approval.approver.id = :approverId and t.inactiveInd = 'N' and t.approval.inactiveInd = 'N' and t.approval.status.id in :statusIds and t.approval.id in :approvalIdList order by t.slot.date"),	@NamedQuery(name="TsApproval.findByUserIdAndStartMonday", query="SELECT t FROM TsApproval t where t.submitter.id = :submitterId and t.startMonday = :startMonday and t.inactiveInd = 'N' order by t.statusDate desc")})public class TsApproval implements Serializable {	private static final long serialVersionUID = 1L;	@Id	@GeneratedValue(strategy= GenerationType.IDENTITY)	private int id;	@Column(name="inactive_ind")	private String inactiveInd = "N";	@Temporal(TemporalType.TIMESTAMP)	@Column(name="status_date")	private Date statusDate;	@Column(name="comment")	private String comment;	@Temporal(TemporalType.TIMESTAMP)	@Column(name="start_period_monday")	private Date startMonday;	//bi-directional many-to-one association to User	@ManyToOne	@JoinColumn(name="approver_id")	private User approver;	@ManyToOne	@JoinColumn(name="submitter_id")	private User submitter;	//bi-directional many-to-one association to AdminLookup	@ManyToOne	@JoinColumn(name="status_id")	private AdminLookup status;	@OneToMany(mappedBy = "approval")	private Set<TsMain> tsMains;	@Column(name = "total_hrs")	private Integer totalHours;	@Transient	private List<Date> dateList;	public TsApproval() {	}	public int getId() {		return this.id;	}	public void setId(int id) {		this.id = id;	}	public String getInactiveInd() {		return this.inactiveInd;	}	public void setInactiveInd(String inactiveInd) {		this.inactiveInd = inactiveInd;	}	public Date getStatusDate() {		return this.statusDate;	}	public void setStatusDate(Date statusDate) {		this.statusDate = statusDate;	}	public User getApprover() {		return this.approver;	}	public void setApprover(User user) {		this.approver = user;	}	public User getSubmitter() {		return submitter;	}	public void setSubmitter(User submitter) {		this.submitter = submitter;	}	public AdminLookup getStatus() {		return this.status;	}	public void setStatus(AdminLookup adminLookup) {		this.status = adminLookup;	}	public Date getStartMonday() {		return startMonday;	}	public void setStartMonday(Date startMonday) {		this.startMonday = startMonday;	}	public Set<TsMain> getTsMains() {		return tsMains;	}	public void setTsMains(Set<TsMain> tsMains) {		this.tsMains = tsMains;	}	public Integer getTotalHours() {		return totalHours;	}	public void setTotalHours(Integer totalHours) {		this.totalHours = totalHours;	}	public String getComment() {		return comment;	}	public void setComment(String comment) {		this.comment = comment;	}	public List<Date> getDateList() {		return dateList;	}	public void setDateList(List<Date> dateList) {		this.dateList = dateList;	}	@Override	public boolean equals(Object o) {		if (this == o) return true;		if (o == null || getClass() != o.getClass()) return false;		TsApproval approval = (TsApproval) o;		return new EqualsBuilder()				.append(id, approval.id)				.append(inactiveInd, approval.inactiveInd)				.isEquals();	}	@Override	public int hashCode() {		return new HashCodeBuilder(17, 37)				.append(id)				.append(inactiveInd)				.toHashCode();	}}