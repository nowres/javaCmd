package com.inshape;

import com.inshape.Commands.*;
import com.inshape.Exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {
    private Map<String, Command> register;
    private String cwd;
    private static CommandRegister commandRegister = new CommandRegister();

    private CommandRegister() {
        try {
            setCWD(new java.io.File( "." ).getCanonicalPath());
        } catch (Exception e) {}
    }

    public static CommandRegister getInstance() {
        return commandRegister;
    }

    public String getCWD() {
        return cwd;
    }

    public void setCWD(String dir) {
        cwd = dir;
    }

    public int load() {
        try {
            register = new HashMap();
            register.put("ls", new Ls());
            register.put("cd", new Cd());
            register.put("cat", new Cat());
            register.put("exit", new Exit());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Command getCommand(String name) throws Exception {
        if (register.containsKey(name)) {
            return register.get(name);
        } else {
            throw new CommandNotFoundException();
        }
    }
}
