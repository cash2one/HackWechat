package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.protocal.c.aee;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private String okL;
    public ArrayList<MallFunction> okM;
    public ArrayList<MallNews> okN;
    public ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> okO;
    public SparseArray<String> okP;
    public int okQ;

    public a(int i, String str) {
        this(i, str, null, null);
    }

    public a(int i, String str, String str2, String str3, String str4) {
        this(i, str, str3, String.format("appid=%s&funcid=%s&url=%s", new Object[]{str2, str3, URLEncoder.encode(str4, "ISO-8859-1").toString()}));
    }

    private a(int i, String str, String str2, String str3) {
        this.okM = null;
        this.okN = null;
        this.okO = null;
        this.okP = null;
        this.okQ = 0;
        this.okQ = i;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new aee();
        aVar.hmk = new aef();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.hmi = 495;
        aVar.hml = GameJsApiGetOpenDeviceId.CTRL_BYTE;
        aVar.hmm = 1000000227;
        this.gJQ = aVar.JZ();
        aee com_tencent_mm_protocal_c_aee = (aee) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aee.wmz = str;
        LinkedList linkedList = new LinkedList();
        List bMf;
        if (bh.ov(str2)) {
            bMf = c.bMe().bMf();
        } else {
            List list;
            MallNews mallNews = (MallNews) c.bMe().sQL.get(str2);
            if (mallNews == null || bh.ov(mallNews.frP)) {
                list = null;
            } else {
                bMf = new ArrayList();
                bMf.add(mallNews.frP);
                list = bMf;
            }
            bMf = list;
        }
        if (r2 != null && r2.size() > 0) {
            String str4 = "";
            for (String str5 : r2) {
                bdo com_tencent_mm_protocal_c_bdo = new bdo();
                com_tencent_mm_protocal_c_bdo.UA(str5);
                linkedList.add(com_tencent_mm_protocal_c_bdo);
                str4 = str4 + "; + " + str5;
            }
            x.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : " + str4);
        }
        com_tencent_mm_protocal_c_aee.wmB = linkedList;
        com_tencent_mm_protocal_c_aee.wmA = linkedList.size();
        if (bh.ov(str3)) {
            com_tencent_mm_protocal_c_aee.nkB = String.format("tpa_country=%s", new Object[]{Integer.valueOf(i)});
        } else {
            com_tencent_mm_protocal_c_aee.nkB = String.format("%s&tpa_country=%s", new Object[]{str3, Integer.valueOf(i)});
        }
        this.okL = str2;
        x.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + com_tencent_mm_protocal_c_aee.nkB);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            aef com_tencent_mm_protocal_c_aef = (aef) ((b) qVar).hmh.hmo;
            x.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.okQ + " " + com_tencent_mm_protocal_c_aef.wmC);
            try {
                if (!bh.ov(com_tencent_mm_protocal_c_aef.wmC)) {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_aef.wmC);
                    String optString = jSONObject.optString("pay_func_list");
                    this.okM = com.tencent.mm.plugin.wallet_core.model.mall.b.y(new JSONArray(optString));
                    o.bLv().b(this.okQ, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"));
                    d.aXX().okT.clear();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e, "", new Object[0]);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 495;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
