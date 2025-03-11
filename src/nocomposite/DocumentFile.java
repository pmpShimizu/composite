package nocomposite;

public class DocumentFile {
    private String name;

    public DocumentFile(String name) {
        this.name = name;
    }

    public void deleteFile() {
        System.out.println("Deleting file: " + name);
    }
}

