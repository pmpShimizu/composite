package composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // 子要素を追加するメソッド
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void delete() {
        System.out.println("Deleting folder: " + name);
        for (FileSystemComponent child : children) {
            child.delete();
        }
    }
}

