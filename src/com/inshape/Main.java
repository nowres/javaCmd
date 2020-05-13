package com.inshape;

import com.inshape.Exceptions.CommandNotFoundException;

import java.io.IOException;

public class Main {
    private static int EXIT = -27;

    public static void main(String[] args) throws IOException {
        int c;
        int ret = 0;
        String cwd = new java.io.File( "." ).getCanonicalPath();
        CommandRegister register = new CommandRegister();
        register.load();

        do {
            String cmdName = "";
            try {
                System.out.print(cwd + "> ");

                while ((c = System.in.read()) != '\n') {
                    cmdName += (char) c;
                }

                if (cmdName != "") {
                    try {
                        Command cmd = register.getCommand(cmdName);
                        ret = cmd.execute(args);
                    } catch (CommandNotFoundException e) {
                        System.out.println("ERROR: Command not found");
                    } catch (Exception e) {
                        System.out.println("ERROR: Command " + cmdName + "crashed abruptly");
                    }
                }
            } catch (Exception e) {

            }
        } while (ret != EXIT);
    }
}
