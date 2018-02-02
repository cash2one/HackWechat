package com.tencent.mm.plugin.ac.a;

public final class d {
    public int fqb = 0;
    public int fqc = 0;
    public String result = "";

    public final String toString() {
        return String.format("result: %s, codeType: %s, codeVersion: %s", new Object[]{this.result, Integer.valueOf(this.fqb), Integer.valueOf(this.fqc)});
    }
}
