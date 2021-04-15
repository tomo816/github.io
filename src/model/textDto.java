package model;

import java.sql.Timestamp;

public class textDto {
	private int 		id;
	private String     userName;
	private String		text		;
	private Timestamp		insert_date	;
	private Timestamp		update_date	;
	private String     profileIcon;

	public int 		getId() {return id;}
	public void 		setId(int id) {this.id=id;}

	public String 		getUserName() {return userName;}
	public void 		setUserName(String userName) {this.userName=userName;}

	public String		getText(){return text;}
	public void		setText(String text) {this.text=text;}

	public Timestamp		getInsert_date(){return insert_date;}
	public void     setInsert_date(Timestamp insert_date) {this.insert_date=insert_date;}


	public Timestamp		getUpdate_date(){return update_date;}
	public void     setUpdate_date(Timestamp update_date) {this.update_date=update_date;}

	public String  		getProfileIcon() {return profileIcon;}
	public void setProfileIcon(String profileIcon) {this.profileIcon=profileIcon;}


	}
