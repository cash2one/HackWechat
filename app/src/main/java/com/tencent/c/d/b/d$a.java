package com.tencent.c.d.b;

public class d$a {
    public String name = "";
    public int pid;
    public int uid;
    public int zTy;
    public String zTz;

    d$a(int i, int i2, String str, int i3, String str2) {
        this.pid = i;
        this.zTy = i2;
        this.name = str;
        this.uid = i3;
        this.zTz = str2;
    }

    public final String toString() {
        return "PID=" + this.pid + " PPID=" + this.zTy + " NAME=" + this.name + " UID=" + this.uid + " CONTEXT=" + this.zTz;
    }
}
