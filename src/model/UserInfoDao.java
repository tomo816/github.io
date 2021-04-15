package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserInfoDao {




        //DB接続用定数
	 String driverName = "com.mysql.cj.jdbc.Driver";
     String jdbcUrl	 = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
     String userId    ="tomoki";
     String userPass	="tomoki" ;

	public UserInfoDto doSelect(String inputUserId, String passWord) {
     try {
  	   Class.forName(driverName);
     }catch (ClassNotFoundException e) {
  	   e.printStackTrace();
     }

     Connection	con = null ;
     PreparedStatement ps = null;
     ResultSet      rs = null;

	   UserInfoDto dto = new UserInfoDto();

     try {
  	   con = DriverManager.getConnection(jdbcUrl, userId, userPass);


  	   StringBuffer buf = new StringBuffer() ;
  	   buf.append(" SELECT		");
  	   buf.append(" user_id 	,	");
  	   buf.append(" user_name 		,	");
  	   buf.append(" password,		");
  	   buf.append(" profileImage    ");
  	   buf.append(" FROM			");
  	   buf.append(" user_info	");
  	   buf.append(" WHERE		");
  	   buf.append(" user_id = ?		and	");
  	   buf.append(" password = ?");


  	   ps = con.prepareStatement(buf.toString());

     	ps.setString(1,inputUserId);
     	ps.setString(2,passWord);

  	   rs =ps.executeQuery();

     	if(rs.next()){
     		dto.setUserId( rs.getString( "user_id" ));
     		dto.setUserName(rs.getString("user_name"));
     		dto.setPassWord(rs.getString("password"));
     		dto.setProfileImage(rs.getString("profileImage"));

  	   }
     }catch (SQLException e ) {
  	   e.printStackTrace();
     }finally {
  	   if(rs != null) {
  		   try {
  			   rs.close();


  		   }catch(SQLException e) {
  			   e.printStackTrace();
  		   }
  	   }

     	 if(ps != null) {
  		   try {
  			   ps.close();
  		   }catch(SQLException e) {
  			   e.printStackTrace();
  		   }
  	   }

  	   if(con != null) {
  		   try {
  			   con.close();
  		   }catch(SQLException e){
  			   e.printStackTrace();
  		   }
  	   }
     }

		return dto;
     }





	public boolean doInsert(UserInfoDto dto) {
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}


		Connection   con = null;
		PreparedStatement ps = null;


		boolean isSuccess = true;

		try {
			con = DriverManager.getConnection(jdbcUrl, userId, userPass);

			con.setAutoCommit(false);

			StringBuffer buf = new StringBuffer();

			 buf.append(" insert into user_info(		");
	    	   buf.append(" user_id 	,	");
	    	   buf.append(" user_name 		,	");
	    	   buf.append(" password	,	");
	    	   buf.append(" profileImage		");
	    	   buf.append(" )values(			");
	    	   buf.append(" ?,	");
	    	   buf.append(" ?,		");
	    	   buf.append(" ?,	");
	    	   buf.append(" ?	");
	    	   buf.append(" ) ");

	    	   ps = con.prepareStatement(buf.toString());

	    	   ps.setString(1,dto.getUserId());
	    	   ps.setString(2,dto.getUserName());
	    	   ps.setString(3,dto.getPassWord());
	    	   ps.setString(4, dto.getProfileImage());


	    	    ps.executeUpdate();


		}catch (SQLException e) {
			e.printStackTrace();

			isSuccess = false;
		}finally {
			if (isSuccess) {
				try {
					con.commit();
				}catch (SQLException e) {
					e.printStackTrace();
				}

			}else {
				try {
					con.rollback();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}


			 if(ps != null) {
	    		   try {
	    			   ps.close();
	    		   }catch(SQLException e) {
	    			   e.printStackTrace();
	    		   }
	    	   }

	    	   if(con != null) {
	    		   try {
	    			   con.close();
	    		   }catch(SQLException e){
	    			   e.printStackTrace();
	    		   }
	    	   }
	       }

			return isSuccess;
		}





	public boolean doUpdate(UserInfoDto dto, String originalId) {
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}


		Connection   con = null;
		PreparedStatement ps = null;


		boolean isSuccess = true;

		try {
			con = DriverManager.getConnection(jdbcUrl, userId, userPass);

			con.setAutoCommit(false);

			StringBuffer buf = new StringBuffer();

			 buf.append(" update user_info	");
			   buf.append(" set ");
	    	   buf.append(" user_id = ? 	,	");
	    	   buf.append(" user_name = ? 	,	");
	    	   buf.append(" password = ? 	,	");
	    	   buf.append(" profileImage = ?		");
	    	   buf.append(" where		");
	    	   buf.append(" user_id = ?		");


	    	   ps = con.prepareStatement(buf.toString());


	    	   ps.setString(1,dto.getUserId());
	    	   ps.setString(2,dto.getUserName());
	    	   ps.setString(3,dto.getPassWord());
	    	   ps.setString(4,dto.getProfileImage());
	    	   ps.setString(5,originalId);

	    	   ps.executeUpdate();


		}catch (SQLException e) {
			e.printStackTrace();

			isSuccess = false;
		}finally {
			if (isSuccess) {
				try {
					con.commit();
				}catch (SQLException e) {
					e.printStackTrace();
				}

			}else {
				try {
					con.rollback();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}


			 if(ps != null) {
	    		   try {
	    			   ps.close();
	    		   }catch(SQLException e) {
	    			   e.printStackTrace();
	    		   }
	    	   }

	    	   if(con != null) {
	    		   try {
	    			   con.close();
	    		   }catch(SQLException e){
	    			   e.printStackTrace();
	    		   }
	    	   }
	       }

			return isSuccess;
		}
	}


