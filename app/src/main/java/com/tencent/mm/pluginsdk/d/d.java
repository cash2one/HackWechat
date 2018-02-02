package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.g.a.jd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

public abstract class d implements a {
    public int vcP = 0;

    public abstract b Cc(String str);

    public abstract j aRl();

    public final void aaZ() {
        if (this.vcP == 0) {
            j aRl = aRl();
            if (aRl != null) {
                aRl.c(this);
            }
        }
        this.vcP++;
    }

    public final void unregister() {
        if (this.vcP != 0) {
            this.vcP--;
            if (this.vcP == 0) {
                j aRl = aRl();
                if (aRl != null) {
                    aRl.j(this);
                }
            }
        }
    }

    public final void a(String str, l lVar) {
        b jdVar = new jd();
        jdVar.fzH.fzI = Cc(str);
        com.tencent.mm.sdk.b.a.xef.m(jdVar);
    }
}
