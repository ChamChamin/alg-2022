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

   



    class Tree{
        File value = null;
        Tree brother = null;
        Tree son = null;
        public Tree(File file){
            this.value = file;
        }
    }



}
