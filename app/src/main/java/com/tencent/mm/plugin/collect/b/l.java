package com.tencent.mm.plugin.collect.b;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private b gJQ;
    private e gJT;
    public la liG;

    public l() {
        a aVar = new a();
        aVar.hmj = new kz();
        aVar.hmk = new la();
        aVar.hmi = 1588;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 1588;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.liG = (la) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        x.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[]{this.liG.url, this.liG.sKt, this.liG.vTN});
        if (!bh.ov(this.liG.url)) {
            g.Dk();
            g.Dj().CU().a(w.a.xwq, this.liG.url);
        }
        if (!bh.ov(this.liG.sKt)) {
            g.Dk();
            g.Dj().CU().a(w.a.xwr, this.liG.sKt);
        }
        g.Dk();
        g.Dj().CU().a(w.a.xwt, this.liG.vTN);
        JSONObject a = a(this.liG.vTM);
        JSONArray aw = aw(this.liG.vTL);
        if (a != null) {
            x.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[]{a.toString()});
            g.Dk();
            g.Dj().CU().a(w.a.xws, a.toString());
        }
        if (aw != null) {
            x.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[]{aw.toString()});
            g.Dk();
            g.Dj().CU().a(w.a.xwu, aw.toString());
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    private JSONArray aw(List<aqz> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                JSONObject a = a((aqz) list.get(i));
                if (a != null) {
                    jSONArray.put(i, a);
                }
                i++;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
                return null;
            }
        }
        return jSONArray;
    }

    private static JSONObject a(aqz com_tencent_mm_protocal_c_aqz) {
        int i = (com_tencent_mm_protocal_c_aqz == null || bh.ov(com_tencent_mm_protocal_c_aqz.fyY)) ? 0 : 1;
        if (i == 0) {
            x.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadSettingTable$Columns.TYPE, com_tencent_mm_protocal_c_aqz.type);
            jSONObject.put("wording", com_tencent_mm_protocal_c_aqz.fyY);
            jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com_tencent_mm_protocal_c_aqz.url);
            jSONObject.put("waapp_username", com_tencent_mm_protocal_c_aqz.wyQ);
            jSONObject.put("waapp_path", com_tencent_mm_protocal_c_aqz.wyR);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
            return null;
        }
    }
}
