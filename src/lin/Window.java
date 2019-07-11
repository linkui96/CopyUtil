package lin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    public Window(){
        setTitle("CopyEasy");
        setSize(600,300);

        int x = (this.getToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (this.getToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x,y);


        JLabel text = new JLabel("Delete Enter");
        text.setForeground(Color.ORANGE);
        text.setFont(new Font("宋体",Font.BOLD,40));

        Button button = new Button("Click");
        button.setPreferredSize(new Dimension(250,100));
        button.setFont(new Font("宋体",Font.BOLD,40));

        JPanel textArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttonArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textArea.add(text);
        buttonArea.add(button);

        Box box = Box.createVerticalBox();
        box.add(textArea);
        box.add(buttonArea);

        this.setContentPane(box);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        button.addActionListener(e -> {

            String content = GetClipboard.getClipboard();
            content = RemoveEnter.removeEnter(content);

            if(SetClipboard.setClipboard(content)){
                button.setLabel("ok");
            }else {
                button.setLabel("failed");
            }
        });

        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {}

            @Override
            public void windowLostFocus(WindowEvent e) {
                button.setLabel("Click");
            }
        });
    }

    public static void main(String[] args) {
        new Window();
    }
}
