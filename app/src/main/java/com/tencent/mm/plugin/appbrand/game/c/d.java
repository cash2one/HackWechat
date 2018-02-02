package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private static volatile d iYC;
    public c iYA;
    public b iYB;
    private c iYD = new c((byte) 0);
    public Context mContext;
    public volatile int mState = 0;

    public static d aee() {
        if (iYC == null) {
            synchronized (d.class) {
                if (iYC == null) {
                    iYC = new d();
                }
            }
        }
        return iYC;
    }

    public static void release() {
        if (iYC != null) {
            synchronized (d.class) {
                if (iYC != null) {
                    iYC.mState = 2;
                    iYC.iYD.jas.clear();
                    iYC = null;
                }
            }
        }
    }

    private d() {
    }

    public final void rN(String str) {
        if (this.mState == 1 && this.iYB != null) {
            this.iYB.post(new 1(this, str));
        }
    }

    public final void G(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("wxClient: " + str);
            jSONObject.put("logs", jSONArray);
            rN(jSONObject.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameInspector", e, "hy: vConsole json error", new Object[0]);
        }
    }
}
