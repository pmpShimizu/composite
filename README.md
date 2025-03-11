## 概要

**非Composite実装（nocompositeバージョン）**

- **DocumentFile.java**
    - ファイルごとに `deleteFile()` を実装し、名前の取得や削除処理を個別に行います。
- **Folder.java**
    - ファイルとフォルダをそれぞれ別々のリスト（`List<DocumentFile>` と `List<Folder>`）で管理し、`addFile()` や `addFolder()` といったメソッドで追加します。
    - 削除は `deleteFolder()` で実装され、内部でそれぞれのリストをループしてファイルとフォルダの削除処理を別々に行います。
- **TestFileSystem.java**
    - クライアントコード側で、ルートフォルダを作り、その中にサブフォルダやファイルを追加してから、`deleteFolder()` を呼び出すことで、再帰的な削除を実現しています。

**Composite実装（compositeバージョン）**

- **FileSystemComponent.java**
    - ファイルシステム全体の部品（ファイルやフォルダ）を統一して扱うためのインターフェースで、`getName()` と `delete()` を定義しています。
- **DocumentFile.java**
    - このインターフェースを実装し、単体のファイルとして `delete()` を定義します。
- **Folder.java**
    - 同じく FileSystemComponent を実装し、内部で子要素を `List<FileSystemComponent>` として管理します。
    - 子要素を追加するための `add()` メソッドを持ち、`delete()` では自分自身の削除処理とともに、子要素全体の `delete()` を再帰的に呼び出します。
- **TestFileSystem.java**
    - こちらもルートフォルダの下にサブフォルダを追加し、最終的にルートの `delete()` を呼び出すことで、ツリー全体を一括して削除できる構造になっています。
