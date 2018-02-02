package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.apx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class e$b {
    String fwM;
    boolean hMl;
    String lEK;
    int scene;
    long tmB;
    long tmC;
    private String tmD;
    final /* synthetic */ e tms;
    int type;

    private e$b(e eVar) {
        this.tms = eVar;
        this.hMl = false;
        this.tmD = null;
    }

    final boolean isAvailable() {
        if (this.hMl || bh.ov(this.fwM) || (System.currentTimeMillis() / 1000) - this.tmC > this.tmB) {
            return false;
        }
        return true;
    }

    final String bPh() {
        if (this.tmD == null) {
            this.tmD = "";
            try {
                JSONArray optJSONArray = new JSONObject(this.fwM).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject("hotwords").optJSONArray("items");
                Iterable arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(Uri.encode(optJSONArray.optJSONObject(i).optString("hotword")));
                }
                this.tmD = TextUtils.join("|", arrayList);
            } catch (Exception e) {
            }
        }
        return this.tmD;
    }

    final void eg(int i, int i2) {
        apx com_tencent_mm_protocal_c_apx = new apx();
        ar.Hg();
        String Fn = c.Fn();
        String n = e.n(i, i2, false);
        if (!n.equals(e.n(i, i2, true))) {
            this.hMl = true;
        }
        File file = new File(Fn, n);
        byte[] d = e.d(file.getAbsolutePath(), 0, (int) file.length());
        if (d != null) {
            try {
                com_tencent_mm_protocal_c_apx.aF(d);
                this.scene = com_tencent_mm_protocal_c_apx.scene;
                this.fwM = com_tencent_mm_protocal_c_apx.vOe;
                this.tmB = com_tencent_mm_protocal_c_apx.wwE;
                this.tmC = com_tencent_mm_protocal_c_apx.wwF;
                this.lEK = com_tencent_mm_protocal_c_apx.vPs;
                this.type = com_tencent_mm_protocal_c_apx.ktN;
                x.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(d.length)});
            } catch (IOException e) {
            }
        }
    }
}
