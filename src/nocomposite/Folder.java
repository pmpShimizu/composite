package nocomposite;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<DocumentFile> files = new ArrayList<>();
    private List<Folder> folders = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    // ファイルを追加するためのメソッド
    public void addFile(DocumentFile file) {
        files.add(file);
    }

    // フォルダを追加するためのメソッド
    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public void deleteFolder() {
        System.out.println("Deleting folder: " + name);
        for (DocumentFile file : files) {
            file.deleteFile();
        }
        for (Folder folder : folders) {
            folder.deleteFolder();
        }
    }
}

