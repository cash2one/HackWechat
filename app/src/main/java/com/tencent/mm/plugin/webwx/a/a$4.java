package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements a {
    final /* synthetic */ a tOm;

    a$4(a aVar) {
        this.tOm = aVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        x.i("MicroMsg.MultiTerminalSyncMgr", "download image msgid:%d, [%d,%d]", new Object[]{Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (i3 == 0 && i4 == 0) {
            this.tOm.fn(j2);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
