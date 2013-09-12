package librarymanagement;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class purrec extends JFrame{
	public static void main(String[] args) {
		new purrec();
	}
	public purrec(){
            super("purchase record");
setVisible(true);
setSize(500,500);
		//JFrame frame = new JFrame("Purchase record");
		JPanel panel = new JPanel();
		String data[][] = {{"id","prod_name","quantity","totalmoney","purchase_date"}};
		String col[] ={"id","prod_name","quantity","totalmoney","purchase_date"};
		DefaultTableModel model = new DefaultTableModel(data,col);
		JTable table = new JTable(model);
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
System.out.println("connected");
PreparedStatement smt=con.prepareStatement("select * from Tab2");
ResultSet rs=smt.executeQuery();
while(rs.next()){
String f1=rs.getString(1);
String f2=rs.getString(2);
String f3=rs.getString(3);
String f4=rs.getString(4);
String f5=rs.getString(5);
System.out.println(f1+""+f2+""+f3+""+f4+""+f5);
model.insertRow(1,new Object[]{f1,f2,f3,f4,f5});
panel.add(table);
//frame.add(panel);
getContentPane().add(panel);
//frame.setSize(600,600);
setLocation(150,100);
//frame.setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
con.close();
}
catch(Exception e) {System.out.println(e);}
}
}