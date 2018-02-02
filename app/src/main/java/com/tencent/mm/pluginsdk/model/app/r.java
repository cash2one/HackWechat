package com.tencent.mm.pluginsdk.model.app;

final class r {
    public String appId;
    public int hNr;

    public r(String str, int i) {
        this.appId = str;
        this.hNr = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (rVar.appId.equals(this.appId) && rVar.hNr == this.hNr) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.appId + this.hNr;
    }
}
