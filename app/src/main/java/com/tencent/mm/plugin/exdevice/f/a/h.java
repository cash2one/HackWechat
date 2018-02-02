package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class h extends a<qc, qd> {
    private final WeakReference<b<h>> lKt;
    String username;

    protected final /* synthetic */ com.tencent.mm.bq.a aDC() {
        return new qc();
    }

    protected final /* synthetic */ com.tencent.mm.bq.a aDD() {
        return new qd();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bq.a aVar) {
        ((qc) aVar).vYN = this.username;
    }

    public h(String str, b<h> bVar) {
        this.username = str;
        this.lKt = new WeakReference(bVar);
    }

    public final int getType() {
        return 1792;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        super.a(i, i2, i3, str, qVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ad.aEm().zb(this.username);
        }
        b bVar = (b) this.lKt.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }
}
