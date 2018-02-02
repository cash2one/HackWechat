package com.tencent.mm.plugin.appbrand.game.e;

public abstract class c implements Runnable {
    e<c> jar;

    public abstract void execute();

    public void run() {
        execute();
        if (this.jar != null) {
            this.jar.j(this);
        }
    }
}
