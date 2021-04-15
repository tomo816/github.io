package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class textDao {


	 String driverName = "com.mysql.cj.jdbc.Driver";
     String jdbcUrl	 = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
     String userId    ="tomoki";
     String userPass	="tomoki" ;



     public List<textDto> doSelect() {
         try {
      	   Class.forName(driverName);
         }catch (ClassNotFoundException e) {
      	   e.printStackTrace();
         }

         Connection	con = null ;
         PreparedStatement ps = null;
         ResultSet      rs = null;

         textDto dto = null;

         List<textDto> dtoList = new ArrayList<textDto>();

         try {
      	   con = DriverManager.getConnection(jdbcUrl, userId, userPass);


      	   StringBuffer buf = new StringBuffer() ;
      	   buf.append(" SELECT		");
      	   buf.append(" user_name 		,	");
      	   buf.append(" text 		,	");
      	   buf.append(" insert_date 	,	");
      	   buf.append(" update_date 	,	");
      	   buf.append(" profileImage        ");
      	   buf.append(" FROM			");
      	   buf.append(" message	");





      	   ps = con.prepareStatement(buf.toString());



      	   rs =ps.executeQuery();

         	while(rs.next()){
         		dto = new textDto();
         		dto.setUserName(rs.getString("user_name"));
         		dto.setText( rs.getString( "text" ));
         		dto.setInsert_date(rs.getTimestamp("insert_date"));
         		dto.setUpdate_date(rs.getTimestamp("update_date"));
         		dto.setProfileIcon(rs.getString("profileImage"));
         		dtoList.add(dto);
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

  		return dtoList;
         }





	public boolean doInsert(textDto dto) {
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

			 buf.append(" insert into message(		");
			 buf.append(" user_name 	,	");
	    	   buf.append(" text 	,	");
	    	   buf.append(" insert_date 		,	");
	    	   buf.append(" update_date			,	");
	    	   buf.append(" profileImage		    ");
	    	   buf.append(" )values(			");
	    	   buf.append(" ?	,	");
	    	   buf.append(" ?	,	");
	    	   buf.append(" ?	,		");
	    	   buf.append(" ?	,		");
	    	   buf.append(" ?		");
	    	   buf.append(" ) ");

	    	   ps = con.prepareStatement(buf.toString());

	    	   ps.setString(1,dto.getUserName());
	    	   ps.setString(2,dto.getText());
	    	   ps.setTimestamp(3,dto.getInsert_date());
	    	   ps.setTimestamp(4,dto.getInsert_date());
	    	   ps.setString(5,dto.getProfileIcon());


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



	public boolean doDelete(String deleteText, String deleteUser, String deleteTime) {
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

			 buf.append(" delete from message		");
	    	   buf.append(" where text=? and user_name=? and insert_date=? ");

	    	   ps = con.prepareStatement(buf.toString());

	    	   ps.setString(1,deleteText);
	    	   ps.setString(2, deleteUser);
	    	   ps.setString(3, deleteTime);



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





	public boolean textUpdate(textDto dto, String originalId) {
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

			 buf.append(" update message	");
			   buf.append(" set ");
			   buf.append("user_name =?      ,");
	    	   buf.append(" profileImage = ?		");
	    	   buf.append(" where		");
	    	   buf.append(" user_name = ?		");


	    	   ps = con.prepareStatement(buf.toString());


	    	   ps.setString(1,dto.getUserName());
	    	   ps.setString(2,dto.getProfileIcon());
	    	   ps.setString(3,originalId);


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

