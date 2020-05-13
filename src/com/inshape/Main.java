package com.inshape;

import com.inshape.Exceptions.CommandNotFoundException;

public class Main {
    private static int EXIT = -27;

    public static void main(String[] args) {
        int c;
        int ret = 0;
        CommandRegister commandRegister = CommandRegister.getInstance();
        commandRegister.load();

        do {
            String cwd = commandRegister.getCWD();
            String cmdLine = "";
            try {
                System.out.print(cwd + "> ");

                while ((c = System.in.read()) != '\n') {
                    cmdLine += (char) c;
                }

                if (cmdLine != "") {
                    String[] cmdArgs = cmdLine.split(" ");
                    String cmdName = cmdArgs[0];

                    try {
                        Command cmd = commandRegister.getCommand(cmdName);
                        ret = cmd.execute(cmdArgs);
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
