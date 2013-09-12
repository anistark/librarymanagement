package librarymanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class buy extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5;
buy(){
Qywindow w=new Qywindow();
addWindowListener(w);
t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);
t5=new JTextField(10);
l1=new JLabel("     BOOK ID     ");
l2=new JLabel("     BOOK NAME   ");
l3=new JLabel("     UNIT PRICE     ");
l4=new JLabel("     STOCK          ");
l5=new JLabel("     DESCRIPTION    ");
l6=new JLabel(" OR ");
b1=new JButton("OK");
b2=new JButton("ISSUE");
b3=new JButton("EXIT");
setLayout(new GridLayout(6,2));
JPanel p;
p=new JPanel();p.add(l1);p.add(t1);p.add(l6);p.add(l2);p.add(t2);add(p);
p=new JPanel();p.add(b1);add(p);
p=new JPanel();p.add(l3);p.add(t3);add(p);
p=new JPanel();p.add(l4);p.add(t4);add(p);
p=new JPanel();p.add(l5);p.add(t5);add(p);
p=new JPanel();p.add(b2);p.add(b3);add(p);
setLocation(350,200);
pack();
setTitle("ISSUE BOOKS");
setVisible(true);
t3.setEditable(false);
t4.setEditable(false);
t5.setEditable(false);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)
{dispose();}
if(ae.getSource()==b2)
{
try{
int c=Integer.parseInt(t4.getText().trim());
if(c >10)
{
int p=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the books u want to issue"));
String fo=JOptionPane.showInputDialog("Enter todays date");
if(p<c)
{
String z1=t1.getText().trim();
String z2=t2.getText().trim();
String z3=Integer.toString(p);
String z5=fo;
int q=Integer.parseInt(t3.getText().trim());
String a=t1.getText().trim();
int r=c-p;
int g=q*p;
String v1 =Integer.toString(g);
JOptionPane.showMessageDialog(this,"you have to pay Rs "+v1);
String z4=v1;
String v2 =Integer.toString(r);
t4.setText(v2);
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
//Connection con1=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt=con.prepareStatement("update Tab1 set quantity=? where id=?");
smt.setInt(1,r);
smt.setString(2,a);
PreparedStatement smt1=con.prepareStatement("insert into Tab3 values(?,?,?,?,?)");
smt1.setString(1,z1);smt1.setString(2,z2);smt1.setString(3,z3);smt1.setString(4,z4);smt1.setString(5,z5);
smt.executeUpdate();
smt1.executeUpdate();
con.close();
}
else{JOptionPane.showMessageDialog(this,"Requested books are more than Stock...Redefine");}
}
else
{
JOptionPane.showMessageDialog(this,"Books are short u cant issue");
}
}
catch(Exception ef) {System.out.println(ef);}
}
//start here
if(ae.getSource()==b1)
{
try{
String a=t1.getText().trim();
String b=t2.getText().trim();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt=con.prepareStatement("select * from Tab1 where id=? or name=?");
smt.setString(1,a);
smt.setString(2,b);
ResultSet rs=smt.executeQuery();
if(rs.next()){
t1.setText(rs.getString(1));
t2.setText(rs.getString(2));
t3.setText(rs.getString(3));
t4.setText(rs.getString(4));
t5.setText(rs.getString(5));
}
else{JOptionPane.showMessageDialog(this,"no data is found");}
con.close();
}
catch(Exception e) {System.out.println(e);}
}
}
public static void main(String args[])
{
buy f=new buy();
}
}
class Qywindow extends WindowAdapter{
public void windowClosing(WindowEvent ae)
{
}
}