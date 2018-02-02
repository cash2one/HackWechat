package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.hv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;

public final class g extends c<hv> {
    public g() {
        this.xen = hv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hv hvVar = (hv) bVar;
        if (hvVar != null) {
            hvVar.fyl.fyn = TenpayUtil.signWith3Des("passwd=" + hvVar.fyk.fym);
            x.v("MicroMsg.GetWcPaySignEventListener", "alvinluo wcpaysign: %s", new Object[]{hvVar.fyl.fyn});
        }
        return false;
    }
}
