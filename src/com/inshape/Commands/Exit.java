package com.inshape.Commands;

import com.inshape.Command;

public class Exit extends Command {
    String name = "exit";

    public int execute(String[] args) {
        return -27;
    }
}
