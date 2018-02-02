package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.ow;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a extends com.tencent.mm.plugin.exdevice.a.a<ow, ox> {
    String appId;
    String ffq;
    String frg;
    String lKs;
    private WeakReference<b<a>> lKt;

    protected final /* synthetic */ com.tencent.mm.bq.a aDC() {
        return new ow();
    }

    protected final /* synthetic */ com.tencent.mm.bq.a aDD() {
        return new ox();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bq.a aVar) {
        ow owVar = (ow) aVar;
        owVar.vXI = this.ffq;
        owVar.vJA = this.frg;
        owVar.vXJ = this.lKs;
        owVar.ngo = this.appId;
    }

    public a(String str, String str2, String str3, String str4, b<a> bVar) {
        this.ffq = bh.ou(str);
        this.frg = bh.ou(str2);
        this.lKs = bh.ou(str3);
        this.appId = bh.ou(str4);
        this.lKt = new WeakReference(bVar);
    }

    public final int getType() {
        return 1799;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString()});
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lKt.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }
}
