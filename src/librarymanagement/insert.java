package librarymanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class insert extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3,t4,t5;
Choice ch;
JButton b1,b2,b3;
insert(){
t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
l1=new JLabel("   Book id      ");
l2=new JLabel("   Book name  ");
l3=new JLabel("   unit price     ");
l4=new JLabel("   quantity       ");
l5=new JLabel(" description    ");
ch=new Choice();
ch.add("Medical");
ch.add("Engineering");
ch.add("History");
ch.add("Geography");
ch.add("Histology");
ch.add("Tautology");
ch.add("Computer");
b1=new JButton("  insert  ");
b2=new JButton("  reset  ");
b3=new JButton("  exit   ");
setLocation(300,200);
Oywindow w=new Oywindow();addWindowListener(w);
setLayout(new GridLayout(6,1));
JPanel p;
p=new JPanel();p.add(l1);p.add(t1);add(p);
p=new JPanel();p.add(l2);p.add(t2);add(p);
p=new JPanel();p.add(l3);p.add(t3);add(p);
p=new JPanel();p.add(l4);p.add(t4);add(p);
p=new JPanel();p.add(l5);p.add(ch);add(p);
p=new JPanel();p.add(b1);p.add(b2);p.add(b3);add(p);
pack();
setTitle("INSERT BOOK");
setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)  {dispose();}
if(ae.getSource()==b2)  {t1.setText(""); t2.setText("");  t3.setText("");  t4.setText("");}
if(ae.getSource()==b1)
{
try{
String a=t1.getText().trim();
String b=t2.getText().trim();
int c=Integer.parseInt(t3.getText().trim());
int d=Integer.parseInt(t4.getText().trim());
String e=ch.getSelectedItem();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:EDSN");
PreparedStatement smt=con.prepareStatement("insert into Tab1 values(?,?,?,?,?)");
smt.setString(1,a);smt.setString(2,b);smt.setInt(3,c);smt.setInt(4,d);smt.setString(5,e);
smt.executeUpdate();
con.close();
}
catch(Exception e) {System.out.println(e);}
JOptionPane.showMessageDialog(this,"1 book added");
}
}
public static void main(String args[])
{
insert f=new insert();
}
}
class Oywindow extends WindowAdapter{
public void windowClosing(WindowEvent ae)
{
}
}