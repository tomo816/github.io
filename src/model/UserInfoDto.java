package model;




	public class UserInfoDto {


		private String		userId		;
		private String		userName	;
		private String		passWord	;
		private String     profileImage;


		public String		getUserId(){return userId;}
		public void		setUserId(String userId) {this.userId=userId;}

		public String		getUserName(){return userName;}
		public void     setUserName(String userName) {this.userName=userName;}

		public String		getPassWord(){return passWord;}
		public void     setPassWord(String passWord) {this.passWord=passWord;}

		public String		getProfileImage() {return profileImage;}
		public void	setProfileImage(String profileImage) {this.profileImage=profileImage;}

}
