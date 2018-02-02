package com.tencent.mm.z;

import android.content.Context;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class d {
    private b flu;
    private a heL;
    a heM;
    private boolean heN = false;
    private Context tI = ac.getContext();

    public final boolean a(a aVar) {
        this.heM = aVar;
        a bVar = new b(this, (byte) 0);
        if (this.flu == null) {
            this.flu = new b(this.tI);
        }
        if (this.heL != bVar) {
            this.heL = bVar;
        }
        this.flu.a(this.heL);
        if (this.flu == null || this.heN) {
            return false;
        }
        this.flu.requestFocus();
        this.heN = true;
        return this.heN;
    }

    public final boolean bx(boolean z) {
        boolean zd;
        if (this.flu != null) {
            zd = this.flu.zd();
        } else {
            zd = false;
        }
        this.heN = false;
        if (z) {
            this.flu = null;
            this.heL = null;
            this.heM = null;
        }
        return zd;
    }
}
