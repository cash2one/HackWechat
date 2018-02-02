package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.plugin.fts.a.a.j;
import java.util.List;

public abstract class a<T> {
    protected String fDj;
    protected int tnf;

    public abstract void ck(List<j> list);

    public a(String str, int i) {
        this.fDj = str;
        this.tnf = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean z;
        if (this.fDj == aVar.fDj || (this.fDj != null && this.fDj.equalsIgnoreCase(aVar.fDj))) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.tnf == this.tnf && r0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
