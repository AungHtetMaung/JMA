package com.jms.controlleraid.model;

import java.util.List;

/*@Entity*/
public class MasterRecord {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MasterRecId")*/
	private Long Id;
	private String catalogName;
	private Integer actor;
	
	/*@OneToMany
	@JoinColumn(name="SubCatId", referencedColumnName="MasterRecId")*/
	private List<CatalogAid> caid;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public Integer getActor() {
		return actor;
	}
	public void setActor(Integer actor) {
		this.actor = actor;
	}
	public List<CatalogAid> getCaid() {
		return caid;
	}
	public void setCaid(List<CatalogAid> caid) {
		this.caid = caid;
	}
	
	

}
