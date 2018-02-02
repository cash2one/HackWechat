package com.tencent.mm.protocal;

public abstract class c$g {
    protected String NAME = "noName";
    protected String vAo = "";
    protected int vAp = -1;
    protected boolean vAq = false;

    public c$g(String str, String str2, int i, boolean z) {
        this.NAME = str;
        this.vAo = str2;
        this.vAp = i;
        this.vAq = z;
    }

    public final String getName() {
        return this.NAME;
    }

    public final String cdr() {
        return this.vAo;
    }

    public final int cds() {
        return this.vAp;
    }

    public final boolean cdt() {
        return this.vAq;
    }
}
