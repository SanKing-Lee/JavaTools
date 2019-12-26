package SQLiteBrowser.view;

import SQLiteBrowser.model.SFileNode;
import SQLiteBrowser.model.SFileTreeRenderer;
import SQLiteBrowser.model.STreeModel;

import javax.swing.*;
import java.io.File;

public class FileNavigator extends JTree {
    public static FileNavigator instance;

    private File[] aFiles;

    private FileNavigator() {
        super();
        SFileTreeRenderer renderer = new SFileTreeRenderer();
        SFileNode root = new SFileNode();
        STreeModel model = new STreeModel(root);
        JTree fileTree = new JTree(model);
        add(fileTree);
    }

    public static FileNavigator getInstance() {
        if (instance == null) {
            instance = new FileNavigator();
        }
        return instance;
    }
}
