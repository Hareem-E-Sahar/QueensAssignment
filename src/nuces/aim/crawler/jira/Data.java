package nuces.aim.crawler.jira;

public class Data {
	
	String type;
	String assignee;
	String dateCreated;
	String description;
	String comments;
	
	public Data(){}
	public Data(String typ, String assign, String date, String descp, String com) {
		super();
		this.type = typ;
		this.assignee = assign;
		this.dateCreated = date;
		this.description = descp;
		this.comments=com;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
