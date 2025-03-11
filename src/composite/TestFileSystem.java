package composite;

public class TestFileSystem {
    public static void main(String[] args) {
        // ファイルの作成
        DocumentFile file1 = new DocumentFile("file1.txt");
        DocumentFile file2 = new DocumentFile("file2.txt");

        // フォルダを作成し、ファイルを追加
        Folder folder = new Folder("MyFolder");
        folder.add(file1);
        folder.add(file2);

        // ルートフォルダを作成し、その中にフォルダを追加
        Folder root = new Folder("RootFolder");
        root.add(folder);

        // ルートフォルダのdelete()を呼び出して、すべてのファイル・フォルダを削除
        root.delete();
    }
}
