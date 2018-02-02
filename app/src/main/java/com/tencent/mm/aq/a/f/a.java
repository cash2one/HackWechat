package com.tencent.mm.aq.a.f;

import com.tencent.mm.aq.a.a.b;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements Runnable {
    private final b hCV = this.hEi.hCV;
    private final c hDn;
    private final com.tencent.mm.aq.a.c.a hDp;
    private final com.tencent.mm.aq.a.c.b hDq;
    private final com.tencent.mm.aq.a.b hEi;
    private final com.tencent.mm.aq.a.c.c hEj;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.aq.a.b bVar, com.tencent.mm.aq.a.c.c cVar2) {
        this.url = str;
        this.hEi = bVar;
        if (cVar == null) {
            this.hDn = this.hCV.hDn;
        } else {
            this.hDn = cVar;
        }
        this.hEj = cVar2;
        if (this.hDn.hDq != null) {
            this.hDq = this.hDn.hDq;
        } else {
            this.hDq = this.hCV.hDq;
        }
        this.hDp = this.hCV.hDp;
    }

    public final void run() {
        com.tencent.mm.aq.a.d.b bVar = new com.tencent.mm.aq.a.d.b();
        bVar = this.hDq.lA(this.url);
        if (bVar == null) {
            this.hEj.a(false, this.hDn.hEd);
        } else if (!(d.decodeByteArray(bVar.data, 10, 10) == null && this.hDn.hEb) && this.hDp.a(this.url, bVar.data, this.hDn)) {
            if (this.hEj != null) {
                this.hEj.a(true, this.hDn.hEd);
            }
        } else if (this.hEj != null) {
            this.hEj.a(false, this.hDn.hEd);
        }
    }
}
