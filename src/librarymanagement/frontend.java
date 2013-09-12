package librarymanagement;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
class frontend extends Frame implements ActionListener
{
JLabel l1,l2,l3,l4;
JButton b1,b2,b3;
JTextField t1,t2;

frontend(){
Nywindow w=new Nywindow();
addWindowListener(w);
l1=new JLabel("ADMIN     ");
l2=new JLabel("USER       ");
l3=new JLabel("USERNAME");
l4=new JLabel("PASSWORD");
b1=new JButton("GO");
b2=new JButton("GO");
b3=new JButton(">>");
t1=new JTextField(20);
t2=new JTextField(20);
//t2.setEchoChar('*');

setLocation(350,200);
setLayout(new GridLayout(4,4));
JPanel p;

p=new JPanel();
p.add(l3);
p.add(t1);
add(p);
p=new JPanel();
p.add(l4);
p.add(t2);
add(p);
p=new JPanel();
p.add(l1);
p.add(b1);
p.add(b3);
add(p);
p=new JPanel();
p.add(l2);
p.add(b2);
add(p);
t1.setEditable(false);
t2.setEditable(false);
pack();
setTitle("WELCOME");
setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}

public void actionPerformed(ActionEvent ae)
         {
if(ae.getSource()==b1)
     {
t1.setEditable(true);
t2.setEditable(true);
      }
if(ae.getSource()==b3)
       {
String s1=t1.getText().trim();
String s2=t2.getText().trim();
String s3="admin";
String s4="password";
if(s1.compareTo(s3)==0 && s2.compareTo(s4)==0 )
      {
new main();
      }
else{
JOptionPane.showMessageDialog(this,"Enter the data correctly");
}
}
if(ae.getSource()==b2)
       {
new buy();
        }
}

public static void main(String args[])
{
frontend f=new frontend();
}
}

class Nywindow extends WindowAdapter{
public void windowClosing(WindowEvent ae)
{
System.exit(0);
}
}