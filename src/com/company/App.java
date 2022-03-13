package com.company;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        List<Mangaka> author = new ArrayList<>();
        author.add(new Mangaka("Akira Toriyama", 1955, 66));
        author.add(new Mangaka("Rifujin na Magonote", 0, 0));
        author.add(new Mangaka("Hiro Mashima", 1977, 44));
        author.add(new Mangaka("Sui Ishida", 1986, 35));
        author.add(new Mangaka("Koyoharu Gotouge", 1989, 32));
        author.add(new Mangaka("Hajime Isayam", 1986, 35));
        author.add(new Mangaka("Tite Kubo", 1977, 44));
        author.add(new Mangaka("Takahiro", 1981, 40));
        author.add(new Mangaka("Yuuichirou Higashide", 1978, 43));
        author.add(new Mangaka("Tatsuya Endou", 1980, 41));
    }
}
