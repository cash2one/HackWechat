package com.tencent.d.b.a;

import com.tencent.d.a.c.f;

public abstract class e<T> extends com.tencent.d.a.c.e {
    public T AcB;

    e() {
        super(-1);
        this.AcB = null;
    }

    protected e(int i, String str) {
        this(i, str, null);
    }

    protected e(int i, String str, T t) {
        super(i, str);
        this.AcB = null;
        switch (i) {
            case 8:
                this.fnL = "get support soter failed remotely";
                break;
            case 9:
                this.fnL = "upload app secure key";
                break;
            case 10:
                this.fnL = "upload auth key failed";
                break;
            case 14:
                this.fnL = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
                break;
            case 17:
                this.fnL = "context instance already released. should not happen normally, you can try to call again";
                break;
            case 18:
                this.fnL = "there must be at least 1 fingerprint enrolled in system to complete this process. please check it previously";
                break;
            case 19:
                this.fnL = "get challenge failed";
                break;
            case 23:
                this.fnL = "upload or verify signature in server side failed";
                break;
        }
        if (!f.ov(str)) {
            this.fnL = str;
        }
        this.AcB = t;
    }

    protected e(int i) {
        this(i, "", null);
    }

    protected e(int i, T t) {
        this(0, "", t);
    }

    public String toString() {
        if (this.AcB == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", new Object[]{super.toString(), this.AcB.toString()});
    }
}
