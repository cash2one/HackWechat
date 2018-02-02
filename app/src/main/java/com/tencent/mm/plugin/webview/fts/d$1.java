package com.tencent.mm.plugin.webview.fts;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class d$1 extends c<fp> {
    final /* synthetic */ d tmh;

    d$1(d dVar) {
        this.tmh = dVar;
        this.xen = fp.class.getName().hashCode();
    }

    private boolean a(fp fpVar) {
        if (fpVar.fuV.fpr == 2) {
            x.i("MicroMsg.FTS.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[]{fpVar.fuV.fqR});
            if (this.tmh.tmc.containsKey(fpVar.fuV.fqR)) {
                synchronized (this.tmh.tmc) {
                    int intValue = ((Integer) this.tmh.tmf.get(fpVar.fuV.fqR)).intValue();
                    HashSet hashSet = (HashSet) this.tmh.tmc.get(fpVar.fuV.fqR);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        String str2 = "weixin://fts/emoji?path=" + fpVar.fuW.path;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, str);
                            jSONObject.put("src", str2);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.Be(intValue).aO(0, jSONArray.toString());
                    this.tmh.tmc.remove(fpVar.fuV.fqR);
                    this.tmh.tmf.remove(fpVar.fuV.fqR);
                }
            }
        }
        return false;
    }
}
