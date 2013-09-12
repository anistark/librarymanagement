package librarymanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class update extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5;
JButton b1,b2,b3,b4,b5,b6;
JTextField t1,t2,t3,t4,t5;
update(){
Pywindow w=new Pywindow();addWindowListener(w);
t1=new JTextField(20);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);
t5=new JTextField(20);
l1=new JLabel("     BOOK ID     ");
l2=new JLabel("     UNIT PRICE     ");
l3=new JLabel("     NUMBER         ");
l4=new JLabel("     DESCRIPTION    ");
l5=new JLabel("     BOOK NAME   ");
b1=new JButton("UPDATE");
b2=new JButton("RESET");
b3=new JButton("EXIT");
b4=new JButton("CURRENT STATUS");
b5=new JButton("DELETE");
b6=new JButton("PURCHASE BOOK");
setLayout(new GridLayout(7,1));
JPanel p;
p=new JPanel();p.add(l1);p.add(t1);add(p);
p=new JPanel();p.add(l5);p.add(t5);add(p);
p=new JPanel();p.add(b4);p.add(b6);add(p);
p=new JPanel();p.add(b1);p.add(b5);p.add(b2);p.add(b3);add(p);
p=new JPanel();p.add(l2);p.add(t2);add(p);
p=new JPanel();p.add(l3);p.add(t3);add(p);
p=new JPanel();p.add(l4);p.add(t4);add(p);
setLocation(350,200);
pack();
setTitle("UPDATE AND SEARCH STATUS");
setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)  {dispose();}
if(ae.getSource()==b2)  {t1.setText(""); t2.setText("");  t3.setText("");  t4.setText("");t5.setText("");}
if(ae.getSource()==b4)
{
try{
String a=t1.getText().trim();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt=con.prepareStatement("select * from Tab1 where id=?");
smt.setString(1,a);
ResultSet rs=smt.executeQuery();
if(rs.next()){
t5.setText(rs.getString(2));
t2.setText(rs.getString(3));
t3.setText(rs.getString(4));
t4.setText(rs.getString(5));
}
else{
JOptionPane.showMessageDialog(this,"no data is found");
}
con.close();
}
catch(Exception e) {System.out.println(e);}
}
if(ae.getSource()==b6){
int p=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the Book"));
int q=Integer.parseInt(JOptionPane.showInputDialog("Enter the unit price of the book"));
int r=p*q;
String fo=JOptionPane.showInputDialog("Enter the Date");
String m1 = Integer.toString(r);
JOptionPane.showMessageDialog(this,"You have spent  "+m1);
String m3=t3.getText();
int s1=Integer.parseInt(m3);
int x1=s1+p;
String n1 = Integer.toString(x1);
t3.setText(n1);
String m2=t2.getText();
int s2=Integer.parseInt(m2);
int x2=q;
String n2 = Integer.toString(x2);
t2.setText(n2);
String z1=t1.getText().trim();
String z2=t2.getText().trim();
String z3=Integer.toString(p);
String z5=fo;
String z4=Integer.toString(r);
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt1=con.prepareStatement("insert into Tab2 values(?,?,?,?,?)");
smt1.setString(1,z1);smt1.setString(2,z2);smt1.setString(3,z3);smt1.setString(4,z4);smt1.setString(5,z5);
smt1.executeUpdate();
con.close();
}
catch(Exception e) {System.out.println(e);}
JOptionPane.showMessageDialog(this,"Please Update...");
}
if(ae.getSource()==b1)
{
try{
String a=t1.getText().trim();
String d=t4.getText().trim();
int c=Integer.parseInt(t3.getText().trim());
int b=Integer.parseInt(t2.getText().trim());
String e=t5.getText().trim();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt=con.prepareStatement("update Tab1 set price=?,quantity=? where id=?");
smt.setInt(1,b);
smt.setInt(2,c);
smt.setString(3,a);
smt.executeUpdate();
con.close();
}
catch(Exception ef) {System.out.println(ef);}
JOptionPane.showMessageDialog(this,"Record Updated");
}
if(ae.getSource()==b5)
{
try{
String a=t1.getText().trim();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt=con.prepareStatement("Delete from Tab1 where id=?");
smt.setString(1,a);
smt.executeUpdate();
con.close();
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
}
catch(Exception ef) {System.out.println(ef);}
JOptionPane.showMessageDialog(this,"RECORD DELETED");
}
}
public static void main(String args[])
{
update f=new update();
}
}
class Pywindow extends WindowAdapter{
public void windowClosing(WindowEvent ae)
{
}
}