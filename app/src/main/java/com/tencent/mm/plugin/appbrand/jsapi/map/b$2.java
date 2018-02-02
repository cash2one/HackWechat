package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class b$2 implements OnClickListener {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ b jlU;
    final /* synthetic */ String jlV;

    b$2(b bVar, int i, String str, p pVar) {
        this.jlU = bVar;
        this.jhi = i;
        this.jlV = str;
        this.jdJ = pVar;
    }

    public final void onClick(View view) {
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.jhi);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.jlV);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", new Object[]{e});
        }
        f a = aVar.a(this.jdJ);
        a.mData = jSONObject.toString();
        a.afs();
    }
}
