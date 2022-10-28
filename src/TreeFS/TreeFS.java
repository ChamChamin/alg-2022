package TreeFS;

import java.io.File;

public class TreeFS {

    Tree root = null;

    public TreeFS( String pathDirectory ){

        this.root = this.createTree(new File(pathDirectory));
    }


    private Tree createTree(File file) {

        Tree tree = new Tree(file);

        if (file.isDirectory()) {
            File files[] = file.listFiles();

            Tree brother = null;

            for (int i = 0; i < files.length; i++) {

                if (i == 0) {
                    tree.son = createTree(files[i]);
                } else {

                    if( brother == null){
                        brother = createTree(files[i]);
                        tree.son.brother = brother;
                    }else{
                        brother.brother = createTree(files[i]);
                        brother = brother.brother;
                    }

                }

            }


        }

        return tree;

    }

    public String createXMLCode(){

        return createXMLCode( this.root, "" );

    }

    private String createXMLCode(Tree tree, String space){

        if(tree == null) return "";

        String tag = tree.value.getName();

        if(tree.son != null) {
            return "\n"+space + "<" + tag + ">" + createXMLCode(tree.son, space + "  ")+ "\n" + space + "<" + tag + "/>" + createXMLCode(tree.brother, space);
        }else{
            return "\n" + space +  "<" + tag + "/>" + createXMLCode(tree.brother, space);
        }

    }



    class Tree{
        File value = null;
        Tree brother = null;
        Tree son = null;
        public Tree(File file){
            this.value = file;
        }
    }



}
