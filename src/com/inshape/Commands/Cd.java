package com.inshape.Commands;

import com.inshape.Command;
import com.inshape.CommandRegister;

import java.io.File;

public class Cd extends Command {
    String name = "cd";

    public int execute(String[] args) {
        if (args.length > 1) {
            String targetPath = args[1];
            File file = new File(targetPath);
            if (file.exists() && file.isDirectory()) {
                System.out.println("switching to " + targetPath);
                CommandRegister.getInstance().setCWD(targetPath);
            }
        } else {
            try {
                String wd = new java.io.File( "." ).getCanonicalPath();
                CommandRegister.getInstance().setCWD(wd);
            } catch (Exception e) {

            }
        }

        return 0;
    }
}
