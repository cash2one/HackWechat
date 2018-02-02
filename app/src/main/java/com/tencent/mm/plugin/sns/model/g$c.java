package com.tencent.mm.plugin.sns.model;

class g$c {
    public int code;
    public String id;
    public int qTx;
    public boolean qTy;

    public g$c(String str, int i, int i2, boolean z) {
        this.id = str;
        this.code = i;
        this.qTx = i2;
        this.qTy = z;
    }

    public final int hashCode() {
        return this.code;
    }

    public final boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.code;
    }
}
