package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract int ayQ();

    public final void D(Map<String, String> map) {
        int Hr;
        int i = 0;
        if (!f.ccT()) {
            map.put("jsapi_reqkey", f.ccU());
        }
        if (this.gJQ == null) {
            a aVar = new a();
            aVar.hmj = new bnl();
            aVar.hmk = new bnm();
            String uri = getUri();
            Hr = Hr();
            aVar.uri = uri;
            aVar.hmi = Hr;
            aVar.hml = 185;
            aVar.hmm = 1000000185;
            this.gJQ = aVar.JZ();
        }
        bnl com_tencent_mm_protocal_c_bnl = (bnl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bnl.wru = ayQ();
        com_tencent_mm_protocal_c_bnl.wrv = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        for (Object obj : toArray) {
            Object obj2;
            uri = (String) map.get(obj2);
            if (!bh.ov(uri)) {
                if (i2 != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj2);
                stringBuilder.append("=");
                stringBuilder.append(uri);
                i2 = 1;
            }
        }
        String signWith3Des = TenpayUtil.signWith3Des(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        Hr = 0;
        while (i < toArray.length) {
            int i3;
            obj2 = toArray[i];
            uri = (String) map.get(obj2);
            if (bh.ov(uri)) {
                i3 = Hr;
            } else {
                if (Hr != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj2);
                stringBuilder.append("=");
                stringBuilder.append(p.encode(uri));
                i3 = 1;
            }
            i++;
            Hr = i3;
        }
        stringBuilder.append(Hr != 0 ? "&" : "");
        stringBuilder.append("WCPaySign");
        stringBuilder.append("=");
        stringBuilder.append(signWith3Des);
        com_tencent_mm_protocal_c_bnl.wrw = new bdn().bj(stringBuilder.toString().getBytes());
    }

    public final int getType() {
        return 385;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + ayQ() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        bnm com_tencent_mm_protocal_c_bnm = (bnm) ((b) qVar).hmh.hmo;
        if (i2 != 0 || i3 != 0) {
            Map y = bi.y(str, "e");
            if (y != null) {
                x.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = (String) y.get(".e.Content");
            }
        } else if (com_tencent_mm_protocal_c_bnm.wry == 0) {
            try {
                JSONObject jSONObject = new JSONObject(n.b(com_tencent_mm_protocal_c_bnm.wrx));
                int i4 = jSONObject.getInt("retcode");
                String str2 = com_tencent_mm_protocal_c_bnm.wEl;
                if (bh.ov(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i5 = com_tencent_mm_protocal_c_bnm.wEk;
                if (i4 == 0 && i5 == 0) {
                    a(i4, str2, jSONObject);
                } else {
                    x.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : " + i5);
                    if (i5 == 0) {
                        i3 = DownloadResult.CODE_UNDEFINED;
                    } else {
                        i3 = i5;
                    }
                    x.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : " + str2);
                    str = str2;
                    i2 = 1000;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", e, "", new Object[0]);
                str = ac.getContext().getString(i.uRf);
                i3 = 2;
                i2 = 1000;
            }
        } else {
            str = com_tencent_mm_protocal_c_bnm.wrz;
            i3 = 2;
            i2 = 1000;
        }
        if (i2 != 0) {
            x.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + ayQ() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        }
        this.gJT.a(i2, i3, str, this);
        x.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + ayQ() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int Hr() {
        return 385;
    }
}
