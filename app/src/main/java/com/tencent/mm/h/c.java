package com.tencent.mm.h;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public String desc;
    public int fol;
    public int fom;
    public String fon;
    public String gBk;
    public String gBl;
    public int gBm;
    public int showType;
    public String url;

    public static c eC(String str) {
        if (bh.ov(str)) {
            return null;
        }
        c cVar = new c();
        Map y = bi.y(str, "e");
        if (y == null) {
            x.d("MicroMsg.BroadcastEntity", "this is not errmsg");
            return null;
        }
        cVar.desc = (String) y.get(".e.Content");
        cVar.url = (String) y.get(".e.Url");
        cVar.fon = (String) y.get(".e.Title");
        cVar.fom = bh.getInt((String) y.get(".e.Action"), 0);
        cVar.showType = bh.getInt((String) y.get(".e.ShowType"), 0);
        cVar.fol = bh.getInt((String) y.get(".e.DispSec"), 30);
        cVar.gBk = (String) y.get(".e.Ok");
        cVar.gBl = (String) y.get(".e.Cancel");
        cVar.gBm = bh.getInt((String) y.get("e.Countdown"), 0);
        if (fw(cVar.showType)) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) y.get(".e"));
            cVar.desc = jSONObject.getString("Content");
            cVar.url = jSONObject.getString("Url");
            cVar.fon = jSONObject.getString("Title");
            cVar.fom = bh.getInt(jSONObject.getString("Action"), 0);
            cVar.showType = bh.getInt(jSONObject.getString("ShowType"), 0);
            cVar.fol = bh.getInt(jSONObject.getString("DispSec"), 30);
            cVar.gBk = (String) y.get(".e.Ok");
            cVar.gBl = (String) y.get(".e.Cancel");
            cVar.gBm = bh.getInt((String) y.get("e.Countdown"), 0);
            if (fw(cVar.showType)) {
                return cVar;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BroadcastEntity", e, "", new Object[0]);
        }
        return null;
    }

    private static boolean fw(int i) {
        if (i == 4 || i == 1 || i == 5 || i == 3 || i == 8) {
            return true;
        }
        return false;
    }
}
