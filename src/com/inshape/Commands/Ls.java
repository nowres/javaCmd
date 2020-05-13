package com.inshape.Commands;

import com.inshape.Command;
import com.inshape.CommandRegister;

import java.io.File;
import java.io.IOException;

public class Ls extends Command {
    String name = "ls";

    public int execute(String[] args) throws IOException {
        File wd = new File(CommandRegister.getInstance().getCWD());

        File[] files = wd.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("/");
            }
            System.out.println(file.getName());
        }

        return 0;
    }
}
