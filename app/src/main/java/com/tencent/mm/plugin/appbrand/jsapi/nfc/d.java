package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.a;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";
    Timer bnp;
    j iqB = null;
    MMActivity iqt = null;
    private int jcs = -1;
    private JSONObject jhQ;
    boolean joQ = false;
    final Object mLock = new Object();
    long mStartTime = -1;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[]{jSONObject.toString()});
        this.iqB = jVar;
        this.jcs = i;
        this.jhQ = jSONObject;
        this.joQ = false;
        a(new 1(this));
    }

    final void sj(String str) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[]{str});
        if (this.iqB != null) {
            this.iqB.E(this.jcs, str);
        }
    }

    final void onSuccess() {
        Map hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.jhQ.getJSONArray("aid_list");
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[]{this.jhQ.toString(), jSONArray.toString(), Integer.valueOf(jSONArray.length())});
            for (int i = 0; i < r4; i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            a.agD();
            Intent intent = new Intent(this.iqt, HCEService.class);
            intent.putExtra("key_appid", this.iqB.mAppId);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            HCEEventLogic.a(new 3(this));
            this.iqt.startService(intent);
            this.mStartTime = System.currentTimeMillis();
            TimerTask 4 = new 4(this);
            this.bnp = new Timer();
            this.bnp.schedule(4, 10000);
        } catch (Exception e) {
            hashMap.put("errCode", Integer.valueOf(13003));
            sj(e("fail: aid_list invalid", hashMap));
            c.N(this.iqB.mAppId, 13003, -1);
        }
    }
}
