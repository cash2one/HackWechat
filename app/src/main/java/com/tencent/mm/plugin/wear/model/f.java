package com.tencent.mm.plugin.wear.model;

public final class f {
    public String fqR = "";
    public int id = 0;
    public String talker = "";
    public int tis = 0;
    a tit;

    protected final Object clone() {
        f fVar = new f();
        fVar.id = this.id;
        fVar.talker = this.talker;
        fVar.fqR = this.fqR;
        fVar.tis = this.tis;
        fVar.tit = this.tit;
        return fVar;
    }

    public final String toString() {
        return "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.fqR + ", ignoreInWatch=" + this.tis + ", status=" + this.tit + "]";
    }
}
