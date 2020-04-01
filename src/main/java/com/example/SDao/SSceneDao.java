package com.example.SDao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.SDao.ISDao.ISSceneDao;
import com.example.entity.*;

import util.DBTool;

@Component
public class SSceneDao implements ISSceneDao{
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		SSceneDao a = new SSceneDao();
		System.out.println(a.addScene("xxx"));
		
	}
	
*/
	//Scene scene = new Scene();
	
	//手动添加场景[1] 往场景表中插入一条场景信息(创建时间表里会自动添加)√
	@Override
	public Boolean addScene(Scenesmall scene) {
		PreparedStatement stmt = null;
        boolean addSceneResult = false;
        String sceneNamer = null;
        String uuid = null;
//        //LocalDateTime createTime = LocalDateTime.now();
        try {
        	//uuid函数生成唯一且不规则的主键id
        	 uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        	
        	String x = "xxx";
        	String sql = "insert into scene (sceneNum,sceneName) values (?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, scene.getSceneId());
            stmt.setString(2, scene.getSceneName());
//            stmt.setTimestamp(4, Timestamp.valueOf(createTime));
            
            if(stmt.executeUpdate()>0){
            	addSceneResult = true;
            	sceneNamer = x;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return addSceneResult;
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       // return sceneNamer ;
        return addSceneResult;
	}

	@Override //22手动删除场景[2]  涉及关联表删除 √
	public boolean removeScene(String sceneNum) {
		boolean deletSceneResult = false;
		PreparedStatement stmt = null;
        try {
        	String Num = "2";
        	String sql = "delete from scene where sceneNum = ?";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, sceneNum);
            
            if(stmt.executeUpdate() > 0)
                   deletSceneResult = true;
            else
            	deletSceneResult = false;
            
           
        } catch (SQLException e) {
        	deletSceneResult = false;
            e.printStackTrace();
        }finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deletSceneResult;
	}

	//查询所有设备 //多表查询重新写！！！！从facility表中查询设备 √
		/*private String facilityId;//设备编号
		private String facilityName;//设备名称
		private String facilityPicture;//设备图片
		private int facilityRoomId;//设备所在房间号
		private String facilityStatus;//设备状态
	*/	
	public ArrayList<FacilityInfoAll> queryAllFacilty() {
			ArrayList<FacilityInfoAll> facilityInfoAll = new ArrayList<>();
			Statement stmt = null;
	        ResultSet rs = null;
	        
	        String sql = "select facilityId,name,roomId,status,image  from facility,facilitytype where  facility.type = facilitytype.type";
	       try {
	            stmt = DBTool.getConnection().createStatement();
	            rs = stmt.executeQuery(sql);
	           
	            while (rs.next()){
	                String facilityId  = rs.getString("facilityId");
	                String facilityName  = rs.getString("name");
	                //String type  = rs.getString(3);
	                String facilityPicture  = rs.getString("image");
	                int facilityRoomId  = rs.getInt("roomId");
	                String facilityStatus  = rs.getString("status");
	           
	                FacilityInfoAll facilityInfo = new FacilityInfoAll(facilityId,facilityName, facilityRoomId,facilityStatus,facilityPicture);
	                facilityInfoAll.add(facilityInfo);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally{
	            try {
	                if(stmt != null)
	                    stmt.close();
	                if(rs != null)
	                    rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return facilityInfoAll;
			
			
		}

	@Override //23添加场景设备[3]  在场景设备表中添加设备，添加设备id和场景id就行 √
	public boolean addFacility(ArrayList<ChooseFacility> choosefacility) {
		PreparedStatement stmt = null;
        boolean addFacilityResult = false;
        
       
        try {
            String sql = "insert into scenefacility (facilityId,sceneId) values (?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            for(ChooseFacility facilitys: choosefacility) {
            	
            	stmt.setString(1, facilitys.getFacilityNum());//给设备编号赋值
                stmt.setString(2, facilitys.getSceneNum());//给场景编号赋值(其他木有赋值的就是空)
            	stmt.addBatch();//批处理命令
            
            }
            /*//返回executeUpdate()更新所影响的行数
            if(stmt.executeUpdate()>0){
            	addFacilityResult =true;
            }*/
            int[] rows = stmt.executeBatch();
            if(rows.length > 0)
            	addFacilityResult = true;
            else
            	addFacilityResult = false;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return addFacilityResult;
		
	}

	//24设置场景设备[4] (修改场景设备表中设备的状态和启动时间)通过场景id和设备id找到设备然后修改 √
	public boolean amendFacility(String sceneId, ArrayList<SceneFacility> SceneFacilitys) {
		PreparedStatement ps = null;
		boolean setFacilityResult = false;
        
        int row = 0;
        try {
        	
        	String sql = "update scenefacility set facilityStatus=?,facilityStartTime=?  where sceneId=? and facilityId=?";		//sql语句改记得
        	ps  = DBTool.getConnection().prepareStatement(sql);
        	
        	for(SceneFacility sceneFacility: SceneFacilitys) {
        		ps.setBoolean(1, sceneFacility.getFacilityStatus());
        		ps.setString(2, sceneFacility.getFacilityStartTime());
                ps.setString(3, sceneFacility.getSceneNum());
                ps.setString(4, sceneFacility.getFacilityNum());
                ps.addBatch();//添加批处理命令！！！！！
        	}
        	
        	
        	int[] rows = ps.executeBatch();//执行批处理操作并返回计数组成的数组！！！！
        	row = rows.length;//对行数赋值
        	
            if (row == SceneFacilitys.size())
            	setFacilityResult = true;
            else
            	setFacilityResult = false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return setFacilityResult;
	}

	@Override//25删除场景设备[5] 通过场景id和设备id在场景设备表中删除设备 √
	public boolean removeFacility(String sceneId, String facilityId) {
		boolean removeFacilityResult = false;
        Statement stmt = null;
        try {
            stmt = DBTool.getConnection().createStatement();
            /*for(String deleteId:facilityId) {
            	String sql = "delete from scenefacility where facilityId ='"+deleteId+"' and sceneId = "+sceneId;
            	if(stmt.executeUpdate(sql) > 0)
            		removeFacilityResult = true;
            	
            }*/
            String sql = "delete from scenefacility where facilityId ='"+facilityId+"' and sceneId = "+sceneId;
        	if(stmt.executeUpdate(sql) > 0)
        		removeFacilityResult = true;
           
        } catch (SQLException e) {
            e.printStackTrace();
            
        }finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return removeFacilityResult;
	}

	//26更换场景背景图[6] 在场景表中修改背景图片 √
	public boolean modifySceneBg(String sceneId, String scenePicture) {
		PreparedStatement ps = null;
		boolean modifyBgResult = false;
        String sql = "update scene set scenePicture=? where sceneNum=?" ;		
        try {
        	
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, scenePicture);
            ps.setString(2, sceneId);
            if (ps.executeUpdate()>0)
            	modifyBgResult = true;
            else
            	modifyBgResult = false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modifyBgResult;
	}

	//查看设备是否存在  通过场景Id在场景设备表中查询设备数量是否为空，为空返回false √
	public boolean isExistFacility(String sceneId) {
		 	Statement stmt = null;
	        ResultSet rs = null; 
	        int count = 0;
	        boolean isExistResult = false;
	       // String sql = "select name,type,roomId,lastTime,lastData,status,isCommon,isOnline from facility where facilityId ='"+sceneId+"'";
	        String sql = "select * from scenefacility where sceneId='"+sceneId+"'";
	        try {
	        	int i = 0;
	            stmt = DBTool.getConnection().createStatement();
	            rs = stmt.executeQuery(sql);
	           while(rs.next()) {
	        	   i++;
	        	}
	            
	            //返回查询结果(设备数量是否为空)
	            
	            if(i>0)
	            	isExistResult = true;
	            else
	            	isExistResult = false;
	            	
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally{
	            try {
	                if(stmt != null)
	                    stmt.close();
	                if(rs != null)
	                    rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return isExistResult;
	}

	//27一键启用场景[7]		
	//28一键停用场景[8]  修改场景表中的指令，启动为start，停用为stop √
	public boolean setSceneOrder(String sceneId, String order) {
		
		

		PreparedStatement ps = null;
		boolean modifyOrderResult = false;
        String sql = "update scene set directive=? where sceneNum =?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, order);
            ps.setString(2, sceneId);
            if (ps.executeUpdate()>0)
            	modifyOrderResult = true;
            else
            	modifyOrderResult = false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modifyOrderResult;
        
		
	}

	@Override/*29更新离家场景序列图（用到了算法）[9] 先放着*/
	public boolean renewalLHFacility(String sceneId,ArrayList<String> facilityId) {
		PreparedStatement stmt = null;
        boolean renewalLHFacilityResult = false;
        
       
        try {
            String sql = "insert into scenefacility (facilityId,sceneId) values (?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            for(String facilitys: facilityId) {
            	
            	stmt.setString(1, facilitys);//给设备编号赋值
                stmt.setString(2, sceneId);//给场景编号赋值(其他木有赋值的就是空)
            	stmt.addBatch();//批处理命令
            
            }
            /*//返回executeUpdate()更新所影响的行数
            if(stmt.executeUpdate()>0){
            	addFacilityResult =true;
            }*/
            int[] rows = stmt.executeBatch();
            if(rows.length > 0)
            	renewalLHFacilityResult = true;
            else
            	renewalLHFacilityResult = false;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return renewalLHFacilityResult;
	}

	
	
	@Override//30移除离家场景设备[10] 在场景设备表中删除设备 √
	public boolean deleteLHFacility(String sceneId, ArrayList<String> facilityId) {
		boolean deleteLHFacilityResult = false;
        Statement stmt = null;
        try {
        	stmt = DBTool.getConnection().createStatement();
            for(String deleteId:facilityId) {
            	String sql = "delete from scenefacility where facilityId ='"+deleteId+"' and sceneId = "+sceneId;
            	if(stmt.executeUpdate(sql) > 0)
            		deleteLHFacilityResult = true;
            	
            	}
        
        } catch (SQLException e) {
            e.printStackTrace();
           
        }finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deleteLHFacilityResult;
	}

	@Override//31设置离家场景启用时间!!!!!!![11] 通过场景Id在场景表中修改启动时间，默认为null √
	public boolean setLHLaunchTime(String sceneId, String startTime) {
		PreparedStatement ps = null;
		boolean modifyLHTimeResult = false;
        String sql = "update scene set startTime=? where sceneNum =?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, startTime);
            ps.setString(2, sceneId);
            if (ps.executeUpdate()>0)
            	modifyLHTimeResult = true;
            else
            	modifyLHTimeResult = false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modifyLHTimeResult;
	}

	@Override//32启用离家场景[12]//33停用离家场景[13] 修改场景表中的指令信息
	public boolean modifyLHSceneOrder(String order) {
		PreparedStatement ps = null;
		boolean modifyLHOrderResult = false;
		String sceneId = "informscene001";
        String sql = "update scene set directive=? where sceneNum =?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, order);
            ps.setString(2, sceneId);
            if (ps.executeUpdate()>0)
            	modifyLHOrderResult = true;
            else
            	modifyLHOrderResult = false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modifyLHOrderResult;
	}

	@Override//34更新通知场景（）[14]
	public boolean renewalInformFacility(String sceneId,ArrayList<String> facilityId) {
		PreparedStatement stmt = null;
        boolean renewalInformFacilityResult = false;
        
       
        try {
            String sql = "insert into scenefacility (facilityId,sceneId) values (?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            for(String facilitys: facilityId) {
            	
            	stmt.setString(1, facilitys);//给设备编号赋值
                stmt.setString(2, sceneId);//给场景编号赋值(其他木有赋值的就是空)
            	stmt.addBatch();//批处理命令
            
            }
            /*//返回executeUpdate()更新所影响的行数
            if(stmt.executeUpdate()>0){
            	addFacilityResult =true;
            }*/
            int[] rows = stmt.executeBatch();
            if(rows.length > 0)
            	renewalInformFacilityResult = true;
            else
            	renewalInformFacilityResult = false;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return renewalInformFacilityResult;
	}

	@Override// √35设置通知场景启用时间!!!!!!!!![15]31  在场景表中中修改通知场景的启用时间
	public boolean setInformTime(String sceneId, String startTime) {
		PreparedStatement ps = null;
		boolean modifyInformTime = false;
        String sql = "update scene set startTime=? where sceneNum =?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, startTime);
            ps.setString(2, sceneId);
            if (ps.executeUpdate()>0)
            	modifyInformTime = true;
            else
            	modifyInformTime = false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modifyInformTime;
	}

	//36启用通知场景startInformOrder[16]
	//37停用通知场景stopInformOrder[17]  在场景表中中修改通知场景的命令 √
	public boolean modifyInformSceneOrder(String sceneId, String order) {
		PreparedStatement ps = null;
		boolean modifyLHOrderResult = false;
        String sql = "update scene set directive=? where sceneNum =?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, order);
            ps.setString(2, sceneId);
            if (ps.executeUpdate()>0)
            	modifyLHOrderResult = true;
            else
            	modifyLHOrderResult = false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return modifyLHOrderResult;
	}
	
	
	
}
