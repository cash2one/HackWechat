package com.tencent.mm.plugin.shake.c.b;

import com.tencent.mm.g.a.pa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<pa> {
    final /* synthetic */ a qpf;

    a$1(a aVar) {
        this.qpf = aVar;
        this.xen = pa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        this.qpf.dismiss();
        if (a.a(this.qpf) != null) {
            a.a(this.qpf).brR();
        }
        x.i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
        return false;
    }
}
