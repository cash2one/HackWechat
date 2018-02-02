package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.aj$a;
import com.tencent.mm.plugin.appbrand.appcache.aj$a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

class a$d implements h<Bundle, Bundle> {
    private a$d() {
    }

    public final /* synthetic */ void a(Object obj, final i iVar) {
        Bundle bundle = (Bundle) obj;
        final String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        String string2 = bundle.getString("appId");
        int i = bundle.getInt("debugType");
        ae a = ((a) g.h(a.class)).YW().a(string2, i, "downloadURL");
        String str = a != null ? a.field_downloadURL : null;
        if (a == null) {
            x.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string2, Integer.valueOf(i)});
            Bundle bundle2 = new Bundle();
            bundle2.putString("appId", string2);
            bundle2.putBoolean("result", false);
            iVar.as(bundle2);
        } else if (!bh.ov(str)) {
            aj.a(string2, i, str, new aj$a(this) {
                final /* synthetic */ a$d iUQ;

                public final void a(String str, b bVar, aj$a.a aVar) {
                    if (!b.iGB.equals(bVar)) {
                        Bundle bundle = new Bundle();
                        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, string);
                        bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
                        f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                    }
                    if (iVar != null) {
                        bundle = new Bundle();
                        bundle.putString("appId", str);
                        bundle.putBoolean("result", b.iGB.equals(bVar));
                        iVar.as(bundle);
                    }
                }
            });
        }
    }
}
