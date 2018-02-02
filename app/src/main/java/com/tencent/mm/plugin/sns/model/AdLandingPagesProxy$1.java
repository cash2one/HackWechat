package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AdLandingPagesProxy$1 implements e {
    final /* synthetic */ AdLandingPagesProxy qSq;

    AdLandingPagesProxy$1(AdLandingPagesProxy adLandingPagesProxy) {
        this.qSq = adLandingPagesProxy;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("AdLandingPagesProxy", "errType %d,errCode %d,errMsg %s,scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString()});
        long longValue;
        if (kVar instanceof c) {
            Object obj;
            String str2 = "";
            if (i == 0 && i2 == 0) {
                str2 = ((c) kVar).fBZ;
                x.i("AdLandingPagesProxy", "the dynamic string is " + str2 + ", sceneType is " + kVar.getType());
                obj = str2;
            } else {
                x.e("AdLandingPagesProxy", "the netscene is error ,error type is " + i + " error msg is " + str + " sceneType is " + kVar.getType());
                String str3 = str2;
            }
            if (AdLandingPagesProxy.a(this.qSq).containsKey(kVar)) {
                longValue = ((Long) AdLandingPagesProxy.a(this.qSq).remove(kVar)).longValue();
                this.qSq.CLIENT_CALL("onDynamicUpdateEnd", new Object[]{Long.valueOf(longValue), obj});
            }
        } else if (kVar instanceof a) {
            if (AdLandingPagesProxy.a(this.qSq).containsKey(kVar)) {
                byte[] toByteArray;
                longValue = ((Long) AdLandingPagesProxy.a(this.qSq).remove(kVar)).longValue();
                mc mcVar = (mc) ((b) kVar.hmG).hmh.hmo;
                if (i == 0 && i2 == 0 && mcVar != null) {
                    try {
                        toByteArray = mcVar.toByteArray();
                    } catch (Throwable e) {
                        x.e("AdLandingPagesProxy", bh.i(e));
                        return;
                    }
                }
                toByteArray = null;
                this.qSq.CLIENT_CALL("onAdChannelEnd", new Object[]{Long.valueOf(longValue), Integer.valueOf(i), Integer.valueOf(i2), toByteArray});
            }
        } else if (kVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) {
            if (AdLandingPagesProxy.a(this.qSq).containsKey(kVar)) {
                long longValue2 = ((Long) AdLandingPagesProxy.a(this.qSq).remove(kVar)).longValue();
                AdLandingPagesProxy adLandingPagesProxy = this.qSq;
                String str4 = "onFavOfficialItemEnd";
                Object[] objArr = new Object[4];
                objArr[0] = Long.valueOf(longValue2);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.b) kVar;
                objArr[1] = bVar.rnt != null ? bVar.rnt : "";
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(i2);
                adLandingPagesProxy.CLIENT_CALL(str4, objArr);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.sns.a.b.e) {
            x.i("AdLandingPagesProxy", "real time report done.");
        }
    }
}
