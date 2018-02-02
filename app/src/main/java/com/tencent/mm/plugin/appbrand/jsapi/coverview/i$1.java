package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.z.u.b;
import java.util.HashMap;
import java.util.Map;

class i$1 implements l {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ i jjl;

    i$1(i iVar, p pVar, int i) {
        this.jjl = iVar;
        this.jdJ = pVar;
        this.jhi = i;
    }

    public final void h(View view, int i, int i2) {
        if (view instanceof WxaScrollView) {
            b y = this.jdJ.aeF().y(this.jhi, false);
            if (y != null) {
                String string = y.getString(SlookAirButtonFrequentContactAdapter.DATA, null);
                if (string != null) {
                    View view2 = ((WxaScrollView) view).jjm;
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, string);
                    hashMap.put("scrollLeft", Integer.valueOf(f.lH(i)));
                    hashMap.put("scrollTop", Integer.valueOf(f.lH(i2)));
                    hashMap.put("scrollWidth", Integer.valueOf(f.lH(view2.getWidth())));
                    hashMap.put("scrollHeight", Integer.valueOf(f.lH(view2.getHeight())));
                    new k().a(this.jdJ).v(hashMap).afs();
                }
            }
        }
    }
}
