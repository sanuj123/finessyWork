package com.finessy.web.notifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.finessy.web.commonDAO.CommonDAO;

public class NotificationDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Integer> calcGroups(int studentId) throws ClassNotFoundException, SQLException {
	
		ArrayList<Integer> groupArrayList = new ArrayList<Integer>();
		try {
			
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(NotificationSQL.CALC_GROUPS);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			
			
			if (!rs.isBeforeFirst() ) { 
				groupArrayList.add(0);
				return groupArrayList;
			} 
			
			while(rs.next()) {
				groupArrayList.add(rs.getInt(1));
			}
			return groupArrayList;
			
		
		}finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
	public HashMap<Integer,ArrayList<String>> eachGroupQuestion(int studentId, String date1) throws ClassNotFoundException, SQLException{
		
		ArrayList<Integer> groupArrayList = new ArrayList<Integer>();
		groupArrayList = calcGroups(studentId);
		
		HashMap<Integer,ArrayList<String>> questionMap = new HashMap<Integer,ArrayList<String>>();
		
		if(groupArrayList.lastIndexOf(0) == 0) {
			System.out.println("no elements");
			ArrayList<String> questions = new ArrayList<String>();
			questions.add("null");
			questionMap.put(new Integer(0), questions);
			return questionMap;
		}
			
		
		con = CommonDAO.getConnection();
		ps = con.prepareStatement(NotificationSQL.READ_ALL_QUESTIONS_BY_GROUP_AND_DATE);
				
		try {
			for(Integer i:groupArrayList) {
				
				ArrayList<String> questions = new ArrayList<String>();
				
				ps.setInt(1, i);
				ps.setString(2, date1);
				rs = ps.executeQuery();
				
				if(!rs.isBeforeFirst()) {
					questions.add("null");
					questionMap.put(i, questions);
				}
				else {
					while(rs.next()) {
						questions.add(rs.getString(1));
					}
				}
				questionMap.put(i, questions);
			}
			System.out.println(questionMap);
			
			return questionMap;							
			
		}finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
	
//	public static void main(String[] args) {
//		
//		NotificationDAO dao = new NotificationDAO();
//		try {
//			dao.eachGroupQuestion(1,"2017-12-27 10:40:30");
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	}

}
