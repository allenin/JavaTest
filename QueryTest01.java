import java.sql.*;
/*
 * 1.加载mysql驱动
 * 2.创建Connection  （mysql链接 ）
 * 3.创建Statement  （调用SQL语句）
 * 4.遍历结果
 */
public class QueryTest01 {
	public static void main (String args[]){
			Connection conn=null; //Connection 
			Statement stmt =null; //防止使用过多的
			ResultSet rs =null;
			String sql;
			String url = "jdbc:mysql://localhost:3306/mysql?user=root&password=root";
			String sql_1="select * from db";
		
		try{
			//加载数据库驱动
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Loading in Mysql Driver !");
			//得到数据库链接（句柄）
			conn=DriverManager.getConnection(url);
			System.out.println(conn);
			//创建stmtment 执行sql语句 
			stmt =conn.createStatement();//调用数据库链接创建stmt 
			rs=stmt.executeQuery(sql_1);//stmt执行数据库语句
			whileRs(rs);//遍历结果 我专门写了一个子程序
		}
		catch(Exception e){  //加载数据库会出现空class  所以这里要try catch
					//这里是简写的方法 直接用Exception 其他的
			e.printStackTrace();
	
		}finally{
			try{
				//close Connection Statement ResultSet 
				if(rs!=null){
				rs.close();
							}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null)
				{
					conn.close();
				}	
				//关闭原则 从里到外 
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		

	}
	public static void whileRs(ResultSet rs) throws Exception{
		//子程序 用于输出结果
			String SearchName;
			SearchName="Db";
			while(rs.next())
			{
			String tmp1=rs.getString(SearchName);
			
			System.out.println("----->"+tmp1);
			
			
			}
		
	}
	
	
}
