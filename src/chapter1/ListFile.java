package chapter1;

import java.io.File;
import java.io.FileFilter;

public class ListFile {
    public void filterFile(File file) {
        File[] listFiles = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
    }

    public void filterFileWithMethodReference(File file) {
        File[] listFiles = file.listFiles(File::isHidden);
    }
}
