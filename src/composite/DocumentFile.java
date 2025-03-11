package composite;

public class DocumentFile implements FileSystemComponent {
    private String name;

    public DocumentFile(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void delete() {
        System.out.println("Deleting file: " + name);
    }
}

