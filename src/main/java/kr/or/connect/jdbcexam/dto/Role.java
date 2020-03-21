package kr.or.connect.jdbcexam.dto;

public class Role {
	private Integer roldId;
	private String description;
	public Integer getRoldId() {
		return roldId;
	}
	public Role() {
		
	}
	public Role(Integer roldId, String description) {
		super();
		this.roldId = roldId;
		this.description = description;
	}
	public void setRoldId(Integer roldId) {
		this.roldId = roldId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roldId=" + roldId + ", description=" + description + "]";
	}
}
