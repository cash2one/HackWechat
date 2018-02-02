package com.tencent.d.a.c;

public class e {
    public int errCode;
    public String fnL;

    public e(int i, String str) {
        this(i);
        if (!f.ov(str)) {
            this.fnL = str;
        }
    }

    public e(int i) {
        this.errCode = i;
        switch (this.errCode) {
            case 0:
                this.fnL = "ok";
                return;
            case 2:
                this.fnL = "device not support soter";
                return;
            default:
                this.fnL = "errmsg not specified";
                return;
        }
    }

    public final boolean isSuccess() {
        return this.errCode == 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).errCode == this.errCode;
    }

    public String toString() {
        return "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.fnL + '\'' + '}';
    }
}
