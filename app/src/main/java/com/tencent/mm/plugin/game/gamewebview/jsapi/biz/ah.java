package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ae.u;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.protocal.c.bxf;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ah extends a {
    public static final int CTRL_BYTE = 10000;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "openWeAppPage";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiOpenWeAppPage", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiOpenWeAppPage", "data is null");
            aVar.sj(a.e("openWeAppPage:fail_null_data", null));
            return;
        }
        String optString = sc.optString("userName");
        String optString2 = sc.optString("relativeURL");
        int optInt = sc.optInt("appVersion", 0);
        String optString3 = sc.optString("searchId");
        String optString4 = sc.optString("docId");
        int optInt2 = sc.optInt("position", 1);
        int optInt3 = sc.optInt("scene", 1000);
        b qpVar = new qp();
        if (optInt3 == 201) {
            qpVar.fIi.scene = 1006;
        } else if (optInt3 == 3) {
            qpVar.fIi.scene = 1005;
        } else if (optInt3 == 16) {
            qpVar.fIi.scene = 1042;
        } else {
            qpVar.fIi.scene = 1000;
        }
        qpVar.fIi.userName = optString;
        qpVar.fIi.fIk = optString2;
        qpVar.fIi.fIm = optInt;
        qpVar.fIi.fIp = false;
        optString = sc.optString("statSessionId");
        optString2 = sc.optString("statKeywordId");
        String optString5 = sc.optString("subScene");
        qpVar.fIi.fnp = optString + ":" + optString2 + ":" + optString3 + ":" + optString4 + ":" + optInt2 + ":" + optString5;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmj = new bxf();
        aVar2.hmk = new bxg();
        aVar2.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar2.hmi = 1873;
        com.tencent.mm.ae.b JZ = aVar2.JZ();
        bxf com_tencent_mm_protocal_c_bxf = (bxf) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bxf.wXU = sc.optString("statSessionId");
        com_tencent_mm_protocal_c_bxf.wXV = sc.optString("statKeywordId");
        com_tencent_mm_protocal_c_bxf.wwM = sc.optString("searchId");
        com_tencent_mm_protocal_c_bxf.wII = sc.optString("docId");
        com_tencent_mm_protocal_c_bxf.wXW = sc.optInt("position", 1);
        com_tencent_mm_protocal_c_bxf.pbI = sc.optString("userName");
        com_tencent_mm_protocal_c_bxf.wXX = sc.optInt("appVersion", 0);
        com_tencent_mm_protocal_c_bxf.wXY = sc.optString("adBuffer");
        com_tencent_mm_protocal_c_bxf.wXZ = sc.optString("clickExtInfo");
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.q("20StatSessionId", com_tencent_mm_protocal_c_bxf.wXU + ",");
        dVar.q("21KeywordId", com_tencent_mm_protocal_c_bxf.wXV + ",");
        dVar.q("22SearchId", com_tencent_mm_protocal_c_bxf.wwM + ",");
        dVar.q("23DocId", com_tencent_mm_protocal_c_bxf.wII + ",");
        dVar.q("24Pos", com_tencent_mm_protocal_c_bxf.wXW + ",");
        dVar.q("25AppUserName", com_tencent_mm_protocal_c_bxf.pbI + ",");
        dVar.q("26AppVersion", com_tencent_mm_protocal_c_bxf.wXX + ",");
        dVar.q("27AdBuffer", com_tencent_mm_protocal_c_bxf.wXY + ",");
        dVar.q("28AdClickBuffer", com_tencent_mm_protocal_c_bxf.wXZ + ",");
        dVar.q("29scene", optInt3 + ",");
        x.i("MicroMsg.GameJsApiOpenWeAppPage", "doClickReportScene oreh" + dVar.Sz());
        u.a(JZ, new 1(this, dVar));
        if (qpVar.fIj.fIu) {
            aVar.sj(a.e("openWeAppPage:ok", null));
        } else {
            aVar.sj(a.e("openWeAppPage:fail:" + bh.ou(qpVar.fIj.fIv), null));
        }
    }
}
