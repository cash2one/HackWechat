package com.tencent.mm.plugin.webview.fts;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONArray;
import org.json.JSONObject;

class c$2 implements k {
    final /* synthetic */ c tlU;

    c$2(c cVar) {
        this.tlU = cVar;
    }

    public final void b(h hVar) {
        switch (hVar.bjW) {
            case -3:
            case -2:
            case -1:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Be(((Integer) this.tlU.mMa.mLn).intValue()).PD("");
                return;
            case 0:
                if (hVar.mMc == null || hVar.mMc.size() == 0) {
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "local contact search size 0");
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Be(((Integer) this.tlU.mMa.mLn).intValue()).PD("");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    for (j jVar : hVar.mMc) {
                        if (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                            jSONArray2.put(f.a(jVar, hVar.mJc.fDj, bh.F(hVar.mMb.mLC)));
                        }
                    }
                    jSONObject2.put("items", jSONArray2);
                    jSONObject2.put("title", ac.getContext().getString(R.l.ekI));
                    jSONObject2.put("count", jSONArray2.length());
                    jSONObject2.put(DownloadSettingTable$Columns.TYPE, 3);
                    jSONArray.put(jSONObject2);
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                    jSONObject.put("ret", 0);
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Be(((Integer) this.tlU.mMa.mLn).intValue()).PD(jSONObject.toString());
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "onSearchDone", new Object[0]);
                    return;
                }
            default:
                return;
        }
    }
}
