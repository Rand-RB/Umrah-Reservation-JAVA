package com.first_app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Intro_Page extends JPanel {
    JTextField count = new JTextField();
    JTextArea text = new JTextArea();
    JButton cb = new JButton("Choose Color");
    JComboBox ll = new JComboBox();
    JComboBox lll = new JComboBox();
    JLabel l = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l1 = new JLabel();
    JButton pos = new JButton();
    JButton neg = new JButton();
    JButton ok = new JButton();
    JButton r = new JButton();
    JLabel l4 = new JLabel();
    ImageIcon ic = new ImageIcon("/Users/ranood/Desktop/t.jpg");
    JLabel pic = new JLabel(ic);
    int counter = 0;

    public Intro_Page() {
        //booking information
        setLayout(null);
        setSize(460, 730);
        pic.setBounds(0, 0, 500, 700);
        l = new JLabel("Options Selection");
        l.setBounds(60, 5, 450, 100);
        l.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        l.setForeground(Color.BLACK );
        add(l);
        l4 = new JLabel("May Allah Accept Your Umrah:)");
        l4.setBounds(35, 530, 450, 100);
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        l4.setForeground(Color.BLACK );

        l2 = new JLabel("Please Select Date");
        l2.setBounds(60, 75, 200, 100);
        l2.setFont(new Font("Calibri", Font.BOLD, 14));
        l2.setForeground(Color.BLACK);
        add(l2);

        String arr[] = {"2 DEC, 2020", "3 DEC, 2020", "4 DEC, 2020", "5 DEC, 2020", "6 DEC, 2020", "7 DEC, 2020", "8 DEC, 2020"};
        ll = new JComboBox(arr);
        ll.setBounds(260, 78, 100, 100);
        add(ll);


        l3 = new JLabel("Please Select Time");
        l3.setBounds(60, 148, 200, 100);
        l3.setFont(new Font("Calibri", Font.BOLD, 14));
        l3.setForeground(Color.BLACK);
        add(l3);
        String arr1[] = {"6:00AM", "8:00AM", "10:00AM", "12:00PM", "2:00PM", "6:00PM", "8:00PM", "12:00AM", "3:00AM"};
        lll = new JComboBox(arr1);
        lll.setBounds(260, 151, 100, 100);
        add(lll);

        l1 = new JLabel("Add Companions");
        l1.setBounds(60, 225, 150, 100);
        l1.setFont(new Font("Calibri", Font.BOLD, 14));
        l1.setForeground(Color.BLACK);
        add(l1);

        pos = new JButton("+");
        pos.setBounds(90, 310, 90, 40);
        add(pos);
        //counter
        count = new JTextField( counter);
        count.setBounds(200, 310, 90, 40);
        add(count);
        neg = new JButton("-");
        neg.setBounds(310, 310, 90, 40);
        add(neg);

        pos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == pos)
                count.setText(""+(++counter));
                repaint();
            }
        });

        neg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == neg)
                    if(counter>0)
                 count.setText(""+(--counter));
                repaint();
            }
        });

        ok = new JButton("Book");
        ok.setBounds(150, 370, 130, 40);

        add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            //this methode will show the reservation barcode
            public void actionPerformed(ActionEvent e) {
                FileReader fileR = null;
                JFrame ff = new JFrame();
                ff.pack();
                ff.setSize(500, 500);
                ff.setVisible(true);
                ff.setLocationRelativeTo(null);
                ff.setLayout(new BorderLayout());
                JPanel jp = new JPanel();
                JPanel jp1 = new JPanel();
                ImageIcon ic = new ImageIcon("/Users/ranood/Desktop/k.png");
                JLabel la = new JLabel(ic);
                jp1.add(la);

                // try blocks if the file not available or if the input or output is wrong
                try {
                    fileR = new FileReader("reservation.txt");
                } catch (FileNotFoundException e1) {
                    System.err.println("An error occurred.");
                    e1.printStackTrace();
                    text.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
                    text.setForeground(Color.BLACK);
                }
                BufferedReader buffer = new BufferedReader(fileR);
                String s;
                try {
                    //read from file with buffer reader
                    while ((s = buffer.readLine()) != null) {
                        text.append(s + "\n");
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                jp.add(text);
                //add the panel of the text
                ff.add(jp, BorderLayout.CENTER);
                //add the panel of the picture
                ff.add(jp1, BorderLayout.SOUTH);
            }
        });
        cb.setBounds(150, 420, 130, 40);
        cb.addActionListener(new ButtonListener());
        r = new JButton("Reservation Code");
        r.setBounds(150, 470, 130, 40);
        add(r);
        add(cb);
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("/Users/ranood/Desktop/qr-code.png");
                JLabel label = new JLabel(icon);
                JFrame jf = new JFrame();
                jf.add(label);
                jf.pack();
                jf.setSize(500, 500);
                jf.setVisible(true);
                jf.setLocationRelativeTo(null);
            }
        });
        //AddMay allah accept your umrah and background
        add(l4);
        add(pic);

    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color f = JColorChooser.showDialog(null, "Color Settings", ll.getForeground());
            if (f != null)
            ll.setForeground(f);
            count.setForeground(f);
            cb.setForeground(f);
            l2.setForeground(f);
            lll.setForeground(f);
            text.setForeground(f);
            l.setForeground(f);
            l3.setForeground(f);
            l1.setForeground(f);
            pos.setForeground(f);
            neg.setForeground(f);
            ok.setForeground(f);
            r.setForeground(f);
            l4.setForeground(f);

            Color b = JColorChooser.showDialog(null, "Color Settings", pos.getBackground());
            if (b != null)
            ll.setBackground(b);
            count.setBackground(b);
            lll.setBackground(b);
            text.setBackground(b);



        }

    }

}

