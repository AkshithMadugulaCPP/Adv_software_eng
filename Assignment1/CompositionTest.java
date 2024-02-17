package Assignment1;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("File: " + name);
    }
}

class Folder {
    private String name;
    private List<File> subFiles;
    private List<Folder> subFolders;

    public Folder(String name, List<File> files, List<Folder> folders) {
        this.name = name;
        this.subFiles = files;
        this.subFolders = folders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Folder> getSubFolders(){
        return this.subFolders;
    }

    public List<File> getSubFiles(){
        return this.subFiles;
    }

    /**
     * Folder path will be received as folder/folder2/folder3 -> folder3 will be deleted
     */
    public void deleteFolder(String folderPath){

        if (subFolders.isEmpty()) {
            return;
        }

        String[] path = folderPath.split("/");
        deleteFolderHelper(path, 1, this.getSubFolders());
    }

    private void deleteFolderHelper(String[] path, int index, List<Folder> subFolders){

        if (subFolders.isEmpty()){
            return;
        }

        if (index > path.length){
            return;
        }

        String currentFolderName = path[index];
        // reached the terminal folder
        if(index == path.length - 1){
            // check if the folder exists in the folders array
            // if exists then delete it
            Iterator<Folder> iterator = subFolders.iterator();
            while(iterator.hasNext()){
                Folder currentFolder = iterator.next();
                if (currentFolder.getName().equalsIgnoreCase(currentFolderName)){
                    iterator.remove();
                    return;
                }
            }
        }

        // traverse the subFolders, then recurse
        subFolders.stream().filter(folder -> folder != null
                        && folder.getName().equalsIgnoreCase(currentFolderName))
                .findFirst()
                .ifPresent(folder -> deleteFolderHelper(path, index + 1, folder.getSubFolders()));
    }

    public void print(){
        printHelper(this.name, this);
    }

    private void printHelper(String parentPath, Folder folder){
        if (folder == null){
            return;
        }
        // print current folder
        System.out.println(parentPath);
        // print all the files in the folder
        folder.getSubFiles().forEach(file -> System.out.println(parentPath + "/" + file.getName()));
        // traverse the folder list and recurse the sub folders
        folder.getSubFolders().forEach(folder1 -> printHelper(parentPath +"/" + folder1.getName(), folder1));
    }
}

public class CompositionTest {
    public static void main(String[] args) {

        String[] appSubFolderNames = new String[]{"config", "controllers", "library", "migrations", "models", "views"};
        List<Folder> appSubFolders = new ArrayList<>();

        // initialize folder sub folder objects
        Arrays.stream(appSubFolderNames).forEach(folderName -> appSubFolders.add(new Folder(folderName, new ArrayList<>(), new ArrayList<>())));

        // create app folder and add the sub folders
        Folder app = new Folder("app", new ArrayList<>(), appSubFolders);
        // create .phalcon folder
        Folder phalcon = new Folder(".phalcon", new ArrayList<>(), new ArrayList<>());
        // create cache folder
        Folder cache = new Folder("cache", new ArrayList<>(), new ArrayList<>());
        // create public folder
        Folder publicFolder = new Folder("public", new ArrayList<>(), new ArrayList<>());
        // creates sub folder for source files
        List<Folder> sourceFileSubFolders = new ArrayList<>();
        sourceFileSubFolders.add(phalcon);
        sourceFileSubFolders.add(app);
        sourceFileSubFolders.add(cache);
        sourceFileSubFolders.add(publicFolder);

        // source file subfiles
        List<File> sourceFileSubFiles = new ArrayList<>();
        sourceFileSubFiles.add(new File(".htaccess"));
        sourceFileSubFiles.add(new File(".htrouter.php"));
        sourceFileSubFiles.add(new File("index.html"));


        /**
         * following section creates sub folders for php_demo1
         */

        // creates Source Files
        Folder sourceFiles = new Folder("Source Files", sourceFileSubFiles, sourceFileSubFolders);

        // create Include path
        Folder includePath = new Folder("Include Path" ,new ArrayList<>(), new ArrayList<>());

        // create remote files
        Folder remoteFiles = new Folder("Remote Files", new ArrayList<>(), new ArrayList<>());

        // sub folder array list
        List<Folder> php_subFiles = new ArrayList<>();
        php_subFiles.add(sourceFiles);
        php_subFiles.add(includePath);
        php_subFiles.add(remoteFiles);


        // create php_demo1
        Folder php_demo1 = new Folder("php_demo1", new ArrayList<>(), php_subFiles);

        // before delete operation
        System.out.println("----------------------------------");
        System.out.println("Before delete operation..");
        php_demo1.print();

        // deleting the app folder
        System.out.println("----------------------------------");
        php_demo1.deleteFolder("php_demo1/Source Files/app");
        System.out.println("After deleting the app folder.. (php_demo1/Source Files/app) ");
        php_demo1.print();


        // deleting the public folder
        System.out.println("----------------------------------");
        php_demo1.deleteFolder("php_demo1/Source Files/public");
        System.out.println("After deleting the public folder.. (php_demo1/Source Files/public) ");
        php_demo1.print();
    }

}

