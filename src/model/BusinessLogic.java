package model;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {


	public UserInfoDto executeSelectUserInfo(String inputUserId, String passWord){
		UserInfoDto dto = new UserInfoDto();
		UserInfoDao dao = new UserInfoDao();
		dto = dao.doSelect(inputUserId, passWord);
	return dto;

}

	public boolean executeInsertUserInfo(UserInfoDto dto) {

		boolean succesInsert = false;


		UserInfoDao dao =new UserInfoDao();
		succesInsert=dao.doInsert(dto);
		return succesInsert;
	}

	public boolean textInsert(textDto dto) {
		boolean  correctInsert = false;

		textDao dao = new textDao();
		correctInsert = dao.doInsert(dto);
		return correctInsert;
	}



	public List<textDto> executeSelect(){
		 List<textDto> dto= new ArrayList<textDto>();

		textDao dao = new textDao();

		dto = (List<textDto>) dao.doSelect();
	return  dto;

	}


	public void executeDelete(String deleteText, String deleteUser, String deleteTime ) {
		textDao dao = new textDao();
		dao.doDelete(deleteText, deleteUser, deleteTime);

	}

	public boolean executeUpdateUserInfo(UserInfoDto dto, String originalId) {
		boolean succesInsert = false;


		UserInfoDao dao =new UserInfoDao();
		succesInsert=dao.doUpdate(dto,originalId);
		return succesInsert;
	}



	public void executeTextUpdate(textDto dto, String originalId) {
		// TODO 自動生成されたメソッド・スタブ




		textDao dao =new textDao();
		dao.textUpdate(dto,originalId);


	}





}
