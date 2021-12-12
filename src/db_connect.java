
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguye
 */
public class db_connect {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    public void connect_db() throws SQLException{
        try {
 
            String url ="jdbc:mysql://ltnc-group5-2021.mysql.database.azure.com:3306/ltnc?useSSL=true&requireSSL=false";
            con = DriverManager.getConnection(url, "group5@ltnc-group5-2021", "ltnc@2021");
            pstm=con.prepareStatement("select * from sinhvien WHERE (idsinhvien>= ?) AND (idsinhvien <=?)",ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_UPDATABLE);
    }
        catch (SQLException ex) {
            
        }
        
        
 
         if (!con.isClosed()) {
                DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                
                
                
                
//                System.out.println("Connected to MySQL!");
//                //stm=con.createStatement();
//                //rs=stm.executeQuery("select * from sinhvien");
//                pstm.setString(1,"1");
//                pstm.setString(2,"2");
//                rs=pstm.executeQuery();
//                rs.next(); //Đi đến sinh viên đầu tiên
//                hienthiSinhVien();
                
            }
        }
    
   public void add_db
        //(){
        (int id, String password,  String username){
        //(int id, String password, String last_login, int is_superuser, String username, String last_name, String email, int is_staff, int is_active, String date_joined, String first_name){
       try{
           stm=con.createStatement();
           
           //st.executeUpdate("INSERT INTO auth_user(id, password,  username) value ('"+id"', '"+password"', '"+username"')");
           //String add_comand="INSERT INTO auth_user(id, password,  username) value (6, 20172749, \"cong\" )";
           //String add_comand="INSERT INTO auth_user(id, password,  username) value ('"+id"', '"+password"', '"+username"')";
           //st.executeUpdate(add_comand);
           stm.executeUpdate("INSERT INTO auth_user(id, password,  username) value ('"+id+"', '"+password+"', '"+username+"')");
       }
       catch(Exception e){}
       
       
   }
        public boolean login(String name, String pass) throws SQLException{
           boolean flag= false;
            try {
            
                stm=con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
                rs=stm.executeQuery("SELECT * FROM ltnc.auth_user");
                while(rs.next()){
                if(name.equals(rs.getString(5))&& pass.equals(rs.getString(2))){
                    flag=true;
                    
                     
                }
                }
            }
                
                
                
                
                
  
      
      
            catch (SQLException ex) {
            Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
      
      
  }
            return flag;
        
        }
  
    
    
    
    
    
   public static void main(String []args) {
      db_connect new_db= new db_connect();
        try {
            new_db.connect_db();
            new_db.add_db(7,  "2013", "nguyen");
            new_db.login("phuc","20172749");
        } catch (SQLException ex) {
            Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }       
    
}
        
