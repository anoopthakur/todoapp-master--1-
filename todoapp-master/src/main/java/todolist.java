import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.todoapp.DB.db;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class todolist extends JLabel {
    List<JLabel> list = new ArrayList<>();
    List<JButton> btnlist = new ArrayList<>();

    JButton btn = null;

    public todolist(String[] arr) {
        this.setBounds(50, 250, 600, 200);
        int labelX = 0;
        int labelY = 0;

        int counter = 1;
        List<JLabel> list = new ArrayList<>();
        for (String s : arr) {
            if (s != null) {
                JLabel label = new JLabel("   "+counter+".  "+s);
                btn = new JButton();
                btn.setBounds(550, 0, 50, 50);
                btn.setText("X");
                btn.setBackground(Color.red);
                btn.setFocusable(false);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        get();
                    }
                });
                JLabel label = new JLabel("   " + s);
                label.setBounds(labelX, labelY, 600, 50);
                label.setBackground(Color.gray);
                label.setOpaque(true);
                label.setForeground(Color.white);
                label.setFont(new Font("Comic Sans", Font.PLAIN, 22));
                label.add(btn);
                label.setLayout(null);

                list.add(label);
                btnlist.add(btn);
                labelY += 60;
                counter++;
            }
        }

        this.setBackground(Color.white);
        //this.setFocusable(true);
        this.setOpaque(true);
        this.setLayout(null);
        for (JLabel label : list) {
            this.add(label);
        }
    }

    public void get(){
        int index = btnlist.indexOf(btn);
        String s = list.get(index).getText().trim();
        System.out.println(s);
        new db().delete(s);
    }
}