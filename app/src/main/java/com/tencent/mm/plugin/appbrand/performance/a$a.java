package com.tencent.mm.plugin.appbrand.performance;

public class a$a {
    String appId;
    String category;
    String jFW;
    long jFX;
    String jFY;
    String name;
    long start;

    public final String toString() {
        return this.name + "," + this.category + "," + this.jFW + "," + (this.start - a.ajt()) + "," + (this.jFX - a.ajt()) + "," + this.jFY;
    }
}
