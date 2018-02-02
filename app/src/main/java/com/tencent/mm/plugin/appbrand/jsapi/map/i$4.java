package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.compat.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.i.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONException;
import org.json.JSONObject;

class i$4 implements k {
    final /* synthetic */ p jfB;
    final /* synthetic */ int jhi;
    final /* synthetic */ i jmd;
    boolean jmf = false;
    JSONObject jmg = new JSONObject();
    a jmh = new a();

    i$4(i iVar, int i, p pVar) {
        this.jmd = iVar;
        this.jhi = i;
        this.jfB = pVar;
    }

    public final void abH() {
        try {
            this.jmg.put("mapId", this.jhi);
            this.jmg.put(DownloadSettingTable$Columns.TYPE, "begin");
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
        }
        if (!this.jmf) {
            this.jmf = true;
            f a = this.jmh.a(this.jfB);
            a.mData = this.jmg.toString();
            a.afs();
        }
    }

    public final void abI() {
        try {
            this.jmg.put("mapId", this.jhi);
            this.jmg.put(DownloadSettingTable$Columns.TYPE, "end");
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
        }
        if (this.jmf) {
            this.jmf = false;
            f a = this.jmh.a(this.jfB);
            a.mData = this.jmg.toString();
            a.afs();
        }
    }
}
