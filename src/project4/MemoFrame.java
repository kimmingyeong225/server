package project4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

// 저장 기능 안됨 이거 나중에 다시 확인

public class MemoFrame extends JFrame{
    private JTextArea memoArea;
    private JButton saveButton;

    public MemoFrame() {
        setTitle("메모");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initLayout();
        addEventListeners();
    }

    private void initLayout() {
        memoArea = new JTextArea();
        saveButton = new JButton("저장");

        setLayout(new BorderLayout());
        add(new JScrollPane(memoArea), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    private void addEventListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMemo();
            }
        });
    }

    private void saveMemo() {
        String memoText = memoArea.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("memo.txt", true))) {
            writer.write(memoText);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "메모가 저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "메모 저장 중 오류가 발생했습니다.", "저장 실패", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MemoFrame().setVisible(true);
            }
        });
    }

}
