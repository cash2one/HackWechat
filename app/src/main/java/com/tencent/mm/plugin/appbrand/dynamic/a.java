package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public String gOP;
    public String iRw;
    h iRx;

    class AnonymousClass2 implements c {
        final /* synthetic */ a iRA;
        final /* synthetic */ String uR;

        public AnonymousClass2(a aVar, String str) {
            this.iRA = aVar;
            this.uR = str;
        }

        public final void i(Bundle bundle) {
            i.rp(this.uR);
        }
    }

    private static class b implements com.tencent.mm.ipcinvoker.a {
        private b() {
        }

        public final void a(Bundle bundle, c cVar) {
            c cVar2 = null;
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            d acE = d.acE();
            if (bh.ov(string)) {
                x.w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                c cVar3 = (c) acE.iRX.remove(string);
                String str = "MicroMsg.DynamicPageViewIPCProxyManager";
                String str2 = "remove IPCProxy success.(key : %s, ref : %s)";
                Object[] objArr = new Object[2];
                objArr[0] = string;
                objArr[1] = cVar3 != null ? Integer.valueOf(cVar3.hashCode()) : null;
                x.d(str, str2, objArr);
                if (cVar3 != null) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                x.e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
            } else {
                b.n(new 1(this, cVar2, string, cVar));
            }
        }
    }

    public a(h hVar) {
        this.iRx = hVar;
    }
}
