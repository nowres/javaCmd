package com.inshape;

import com.inshape.Commands.*;
import com.inshape.Exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {
    private Map<String, Command> register;

    public int load() {
        try {
            register = new HashMap();
            register.put("ls", new Ls());
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
