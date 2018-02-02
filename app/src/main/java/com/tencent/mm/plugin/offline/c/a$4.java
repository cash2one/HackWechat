package com.tencent.mm.plugin.offline.c;

import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;

class a$4 implements a {
    a$4() {
    }

    public final void a(e eVar) {
        if (eVar == null || eVar.Kx() == null) {
            x.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
            return;
        }
        byte[] jp = eVar.Kx().jp("offline_token");
        if (jp != null) {
            a.Hf(new String(jp));
        }
        jp = eVar.Kx().jp("offline_token_V2");
        if (jp != null) {
            a.oZl = new String(jp);
        }
        jp = eVar.Kx().jp("offline_key_list");
        if (jp != null) {
            a.oZo = new String(jp);
        }
    }
}
