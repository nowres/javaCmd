package com.inshape;

import java.io.IOException;

public abstract class Command {
    String name;

    public String getName() {
        return name;
    }
    public abstract int execute(String[] args) throws IOException;
}
