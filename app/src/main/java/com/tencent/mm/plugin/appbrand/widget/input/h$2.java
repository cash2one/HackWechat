package com.tencent.mm.plugin.appbrand.widget.input;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.e.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.ab.a;
import com.tencent.mm.plugin.appbrand.widget.input.h.4;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class h$2 implements ab {
    final /* synthetic */ h jXi;
    final /* synthetic */ String jXk;
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ int jjZ;

    public h$2(h hVar, WeakReference weakReference, int i, String str) {
        this.jXi = hVar;
        this.jjX = weakReference;
        this.jjZ = i;
        this.jXk = str;
    }

    public final void a(String str, int i, a aVar) {
        try {
            p pVar = (p) this.jjX.get();
            if (pVar != null) {
                JSONObject put = new JSONObject().put(DownloadSettingTable$Columns.VALUE, str).put("inputId", this.jjZ).put("cursor", i);
                if (a.jZm.equals(aVar)) {
                    f bVar = new b();
                    bVar.az(pVar.mAppId, pVar.hashCode());
                    bVar.mData = put.put(SlookAirButtonFrequentContactAdapter.DATA, this.jXk).toString();
                    bVar.afs();
                    return;
                }
                String str2;
                switch (4.jXl[aVar.ordinal()]) {
                    case 1:
                        str2 = "onKeyboardComplete";
                        break;
                    case 2:
                        str2 = "onKeyboardConfirm";
                        break;
                    default:
                        str2 = null;
                        break;
                }
                if (!bh.ov(str2)) {
                    pVar.h(str2, put.toString(), 0);
                }
            }
        } catch (Exception e) {
        }
    }
}
