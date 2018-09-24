package chapter2;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Predicate;

public class FunctionalInterface {
    Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();

    FileFilter fileFilter = File::isDirectory;
    public static void main(String[] args) {

    }
}
