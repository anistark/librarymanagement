package librarymanagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class main extends JFrame implements ActionListener{
JButton b1,b2,b3,b4,b5,b6;
JLabel l1;
main()
{
Mywindow w=new Mywindow();addWindowListener(w);
ImageIcon i=new ImageIcon("icon1.jpg");
l1=new JLabel(i);
b1=new JButton("ADD BOOK");
b2=new JButton("UPDATE AND DELETE");
b3=new JButton("PURCHASE");
b4=new JButton("EXIT");
b5=new JButton("ISSUE RECORD");
b6=new JButton("PURCHASE RECORD");
setLayout(new BorderLayout());
JPanel p1=new JPanel();p1.add(l1);add("Center",p1);
JPanel p2=new JPanel();
p2.add(b1);p2.add(b2);p2.add(b3);p2.add(b5);p2.add(b6);p2.add(b4);add("South",p2);
setSize(800,400);
setLocation(300,100);
setResizable(false);
setVisible(true);
setTitle("LIBRARY MANAGEMENT SYSTEM");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1)
{
new insert();
}
if(ae.getSource()==b2)
{
new update();
}
if(ae.getSource()==b3)
{
new update();
}
if(ae.getSource()==b4)
{
dispose();
}
if(ae.getSource()==b5)
{
new salerec();
}
if(ae.getSource()==b6)
{
new purrec();
}
}
public static void main(String args[])
{
main f=new main();
}
}
class Mywindow extends WindowAdapter{
public void windowClosing(WindowEvent ae)
{
}
}