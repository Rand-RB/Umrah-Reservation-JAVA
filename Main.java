//Rand Abdulaziz Barnawi-1911336
package com.first_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class Main extends JFrame{
    Intro_Page welcome = new Intro_Page();
    JTextField N = new JTextField ();
    JTextField ID = new JTextField ();
    JTextField MN = new JTextField ();
    JTextField E = new JTextField ();
    ImageIcon ic = new ImageIcon("/Users/ranood/Desktop/t.jpg");
    JLabel pic = new JLabel(ic);
    JLabel wel = new JLabel();
    public Main() {
        setLayout(null);
        pic.setBounds(0,0,500,700);
        wel = new JLabel("WELCOME TO UMRAH RESERVATION");
        wel.setBounds(15, 5, 450, 100);
        wel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        wel.setForeground(Color.BLACK );
        add(wel);
        JLabel per = new JLabel("Enter your personal information:");
        per.setBounds(10, 400, 400, 30);
        per.setFont(new Font("Calibri", Font.BOLD, 16));
        per.setForeground(Color.BLACK );
        add(per);
        JLabel ln = new JLabel("Enter Your Name:");
        ln.setForeground(Color.BLACK );
        ln.setFont(new Font("Calibri", Font.BOLD, 12));
        ln.setBounds(10, 430, 250, 50);
        add(ln);
        N.setBounds(180, 440,250, 30);
        add(N);
        JLabel ld = new JLabel("Enter Your National ID:");
        ld.setBounds(10,470,250,50);
        ld.setFont(new Font("Calibri", Font.BOLD, 12));
        ld.setForeground(Color.BLACK );
        add(ld);
        ID.setBounds(180,480,250,30);
        add(ID);
        JLabel lm = new JLabel("Enter Your Mobile Number:");
        lm.setBounds(10,510,250,50);
        lm.setFont(new Font("Calibri", Font.BOLD, 12));
        lm.setForeground(Color.BLACK );
        add(lm);
        MN.setBounds(180,520,250,30);
        add(MN);
        JLabel le = new JLabel("Enter Your Email");
        le.setBounds(10,550,250,50);
        le.setFont(new Font("Calibri", Font.BOLD, 12));
        le.setForeground(Color.BLACK );
        add(le);
        E.setBounds(180,560,250,30);
        add(E);
        JButton next = new JButton("NEXT");
        next.setBounds(150,610,100,30);
        add(next);
        //create the menu
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Settings");
        JMenuItem menuItem2 = new JMenuItem("Addition");
        JMenuItem menuItem3 = new JMenuItem("Service");
        JMenuItem menuItem4 = new JMenuItem("License");
        menubar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        setJMenuBar(menubar);

        menuItem1.addActionListener(new MenuAction());
        menuItem2.addActionListener(new MenuAction());
        menuItem3.addActionListener(new MenuAction());
        menuItem4.addActionListener(new MenuAction());

        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){
                //names with letters only
            if (!N.getText().matches("[A-Za-z]+\\s*[A-Za-z]+")){
                JOptionPane.showMessageDialog(null,"Wrong value please enter your name correctly","input error",JOptionPane.ERROR_MESSAGE);}
                //numbers for 10 digits only
            else if (!ID.getText().matches("[0-9]{10}")){
                JOptionPane.showMessageDialog(null,"Wrong value please enter your ID correctly","input error",JOptionPane.ERROR_MESSAGE);}
                // phones should start with 05
            else if (!MN.getText().matches("(05)[0-9]{8}")){
                JOptionPane.showMessageDialog(null,"Wrong value please enter your Mobile Number with this format'05xxxxxxxx'","input error",JOptionPane.ERROR_MESSAGE);}
                //Emails should contain .com and @
            else if((!E.getText().matches("[A-Za-z0-9]+[@][A-Za-z]+(.com)(.)*[A-Za-z]*"))){
              JOptionPane.showMessageDialog(null,"Wrong value please enter your email should include @ and ends with .com\n","input error",JOptionPane.ERROR_MESSAGE);}
            else
            {   //move to complete reservation
                getContentPane().removeAll();
                getContentPane().invalidate();
                getContentPane().add(welcome);
                getContentPane().revalidate();
                try {
                    // write the information to the file
                    FileWriter Writer = new FileWriter("reservation.txt");
                    Writer.write("\n\t  RESERVATION INFORMATION\n\n");
                    Writer.write("DEAR ");Writer.write(N.getText()); Writer.write(",\n");
                    Writer.write("\nYOU HAVE UMRAH RESERVATION ON ");
                    Writer.write(String.valueOf(welcome.ll.getSelectedItem()));
                    Writer.write(" AT ");Writer.write(String.valueOf(welcome.lll.getSelectedItem()));
                    Writer.write(" \n\nWITH THE FOLLOWING INFORMATION:\n\n");
                    Writer.write("ID: ");Writer.write(ID.getText());
                    Writer.write("\nMOBILE NUMBER: ");Writer.write(MN.getText());
                    Writer.write("\nEMAIL: ");Writer.write(E.getText());
                    Writer.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }}}});
        add(pic);}



    public static void main(String[] args) {
        Main f = new Main();
        f.setSize(460, 730);
        f.setTitle("UMRAH RESERVATION");
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }


    private class MenuAction implements ActionListener {
        public MenuAction() {}
        @Override
        public void actionPerformed(ActionEvent e) {
            Message ();
        }}
    //this method will implements action to the menu
    private void Message () {
        JFrame jf = new JFrame();
        jf.setLayout(null);
        JLabel qw = new JLabel("Coming Soon...");
        qw.setBounds(120,30,200,100);
        qw.setFont(new Font("Calibri", Font.PLAIN, 24));
        jf.add(qw);
        jf.setSize(400, 200);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

    }
}






