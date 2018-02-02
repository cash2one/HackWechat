package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.webview.fts.e.1;
import com.tencent.mm.plugin.webview.fts.e.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class e$1$1 implements Runnable {
    final /* synthetic */ h mJd;
    final /* synthetic */ f tmt;
    final /* synthetic */ ArrayList tmu;
    final /* synthetic */ 1 tmv;

    e$1$1(1 1, f fVar, h hVar, ArrayList arrayList) {
        this.tmv = 1;
        this.tmt = fVar;
        this.mJd = hVar;
        this.tmu = arrayList;
    }

    public final void run() {
        if (this.tmt.tmK != 0) {
            x.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener callback， id %d", new Object[]{Integer.valueOf(this.tmt.tmK)});
            g Be = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Be(this.tmt.tmK);
            String str = this.mJd.mJc.fDj;
            try {
                x.i("MicroMsg.MsgHandler", "onGetSearchHistory %s", new Object[]{this.tmu.toString()});
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", 0);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator it = r0.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("word", str);
                    jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, System.currentTimeMillis());
                    jSONObject2.put("timeStamp", System.currentTimeMillis());
                    jSONArray2.put(jSONObject2);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("items", jSONArray2);
                jSONArray.put(jSONObject3);
                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, jSONObject.toString());
                try {
                    if (Be.fBH != null) {
                        Be.fBH.n(143, bundle);
                    } else {
                        x.i("MicroMsg.MsgHandler", "callbacker is null");
                    }
                } catch (RemoteException e) {
                    x.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + e.getMessage());
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
        }
    }
}
