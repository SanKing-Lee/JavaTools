package SQLiteBrowser.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
public class FileChooserPane extends JPanel {

    private JTextArea taFilePath;
    private JButton btnChooseFile, btnAddFile;
    private JFileChooser fcChooser;
    private File selectedFile;

    public FileChooserPane() {
        super();

        fcChooser = new JFileChooser(new File("."));
        fcChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        taFilePath = new JTextArea(1, 20);

        btnChooseFile = new JButton("...");
        btnChooseFile.addActionListener(e -> {
            int status = fcChooser.showOpenDialog(this);
            if (status != JFileChooser.APPROVE_OPTION) {
                taFilePath.setText("");

            } else {
                selectedFile = fcChooser.getSelectedFile();
                taFilePath.setText(selectedFile.toString());
                System.out.println("selected file: " + selectedFile.toString());
            }
        });

        btnAddFile = new JButton("Add");


        setLayout(new FlowLayout());
        add(taFilePath);
        add(btnChooseFile);
    }
}
