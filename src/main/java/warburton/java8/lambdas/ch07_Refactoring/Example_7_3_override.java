package warburton.java8.lambdas.ch07_Refactoring;

import warburton.java8.lambdas.ch01_domain.Album;

public class Example_7_3_override {

    private Database database;


    private ThreadLocal<Album> thisAlbum1 = new ThreadLocal<>() {
        @Override
        protected Album initialValue() {
            return database.lookupCurrentAlbum();
        }
    };

    private ThreadLocal<Album> thisAlbum2 = ThreadLocal.withInitial(() -> database.lookupCurrentAlbum());
}

interface Database {
    Album lookupCurrentAlbum();
}
