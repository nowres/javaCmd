package com.inshape.Commands;

import com.inshape.Command;
import com.inshape.CommandRegister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Cat extends Command {

    public int execute(String[] args) {

        if (args.length > 1) {
            File file = new File(args[1]);

            if (!file.isFile()) {
                file = new File(CommandRegister.getInstance().getCWD(), args[1]);

                if (!file.isFile()) {
                    return 0;
                }
            }

            try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {
                stream.forEach(System.out::println);
            } catch (IOException e) {}
        }

        return 0;
    }
}
