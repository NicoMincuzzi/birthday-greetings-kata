package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class File {
    private final String filename;

    public File(String filename) {
        this.filename = filename;
    }

    public List<String> read() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            removeHeader(in);
            return in.lines().collect(toList());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void removeHeader(BufferedReader in) throws IOException {
        in.readLine();
    }
}
