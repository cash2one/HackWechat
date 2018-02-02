package com.tencent.mm.wallet_core.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends l {
    public b gJQ;
    public e gJT;
    public int sLY = 0;
    public String sLZ = "";
    public int sMa = 0;
    public String sMb = "";
    public int sMc = 0;
    public String zHs = "";
    public String zHt = "";
    public String zHu = "";
    public boolean zHv = false;
    protected String zHw;
    public boolean zHx = false;
    private Map<String, String> zHy = new HashMap();
    public boolean zHz = false;

    public abstract void F(boolean z, boolean z2);

    public abstract String MP(String str);

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract void a(b bVar, bdn com_tencent_mm_protocal_c_bdn);

    public abstract void b(b bVar, bdn com_tencent_mm_protocal_c_bdn);

    public abstract int bKu();

    public abstract m d(b bVar);

    public void a(c cVar, JSONObject jSONObject) {
    }

    public final void aA(Map<String, String> map) {
        if (map == null) {
            map = new HashMap();
        }
        if (map != null) {
            map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (this.zHy == null) {
            this.zHy = new HashMap();
        }
        if (this.zHy != null) {
            this.zHy.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        Object[] toArray = map.keySet().toArray();
        for (Object obj : toArray) {
            String str = (String) map.get(obj);
            if (this.zHy.containsKey(obj)) {
                this.zHy.remove(obj);
            }
            this.zHy.put((String) obj, str);
        }
        D(this.zHy);
    }

    public final void D(Map<String, String> map) {
        if (map == null) {
            map = new HashMap();
        }
        if (map != null) {
            map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (!f.ccT()) {
            map.put("jsapi_reqkey", f.ccU());
        }
        this.zHy = map;
        F(true, true);
        if (map != null) {
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!bh.ov(str)) {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    b(stringBuilder, str);
                    i = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.ceK()) {
                x.v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bKu() + ", req = " + stringBuilder.toString() + " " + toString() + " " + bh.cgy().toString());
            } else {
                x.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bKu() + ", req = " + stringBuilder.toString() + " " + toString());
            }
            String MP = MP(stringBuilder.toString());
            stringBuilder.append(i != 0 ? "&" : "");
            stringBuilder.append("WCPaySign");
            stringBuilder.append("=");
            stringBuilder.append(MP);
            a(this.gJQ, new bdn().bj(stringBuilder.toString().getBytes()));
        }
        x.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[]{Integer.valueOf(bKu()), Integer.valueOf(getType()), toString(), this.gJQ.uri});
    }

    public void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
    }

    public final void aB(Map<String, String> map) {
        F(false, false);
        if (map != null) {
            au bLf = i.bLf();
            if (bLf != null) {
                x.i("MicroMsg.NetScenePayBase", "location found");
                map.put("province", bLf.fWp);
                if (!map.containsKey("city")) {
                    map.put("city", bLf.fWq);
                }
                map.put("location_timestamp", bLf.vFO);
                map.put("encrypt_key", bLf.vFS);
                map.put("encrypt_userinfo", bLf.vFR);
            }
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            boolean z = false;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!bh.ov(str)) {
                    if (z) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    z = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.ceK()) {
                x.d("MicroMsg.NetScenePayBase", "Cmd : " + bKu() + ", wxreq = " + stringBuilder.toString());
            }
            x.d("MicroMsg.NetScenePayBase", "wxreq: " + stringBuilder.toString());
            b(this.gJQ, new bdn().bj(stringBuilder.toString().getBytes()));
        }
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        a(payInfo, map, map2, false);
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (payInfo == null) {
            x.e("MicroMsg.NetScenePayBase", "Cmd : " + bKu() + ", payInfo is null");
            map2.put("devicename", Build.MODEL);
            aB(map2);
            return;
        }
        map.put("req_key", payInfo.fuH);
        map.put("partner_id", payInfo.partnerId);
        map.put("pay_sign", payInfo.fKx);
        if (payInfo.vzC >= 0) {
            map.put("auto_deduct_flag", payInfo.vzC);
        }
        if (payInfo.fCV > 0) {
            map.put("pay_scene", payInfo.fCV);
        }
        if (payInfo.fCW >= 0) {
            map.put("bindbankscene", payInfo.fCW);
        }
        if (!bh.ov(payInfo.vzD)) {
            map.put("deduct_bank_type", payInfo.vzD);
        }
        if (!bh.ov(payInfo.vzE)) {
            map.put("deduct_bind_serial", payInfo.vzE);
        }
        if (z) {
            map.put("use_touch", "0");
        } else {
            map.put("use_touch", payInfo.vzy);
        }
        map.put("fp_identify_num", payInfo.vzz);
        if (!TextUtils.isEmpty(payInfo.fwZ)) {
            map.put("encrypted_pay_info", URLEncoder.encode(payInfo.fwZ));
        }
        if (!TextUtils.isEmpty(payInfo.fxa)) {
            map.put("encrypted_rsa_sign", URLEncoder.encode(payInfo.fxa));
        }
        map2.put("uuid", payInfo.ned);
        map2.put("appid", payInfo.appId);
        map2.put("appsource", payInfo.tan);
        map2.put("channel", payInfo.fCR);
        map2.put("devicename", Build.MODEL);
        map2.put("soter_req", payInfo.fCB);
    }

    public final void e(int i, int i2, String str, q qVar) {
        String str2;
        int i3;
        JSONObject jSONObject;
        String optString;
        JSONObject jSONObject2;
        Exception e;
        c cVar;
        Map y;
        Exception exception;
        if (r.iel && 1686 == bKu()) {
            i = 3;
            i2 = -1;
        }
        x.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[]{Integer.valueOf(getType()), Integer.valueOf(qVar.getType()), qVar.getUri(), Integer.valueOf(bKu()), Integer.valueOf(i), Integer.valueOf(i2), str, toString()});
        m d = d((b) qVar);
        int i4 = d.wry;
        String str3 = d.wrz;
        int i5 = d.zHA;
        String str4 = d.lOs;
        String string = ac.getContext().getString(a.i.uRf);
        JSONObject jSONObject3 = null;
        String b = n.b(d.wrx);
        if (bh.ov(b)) {
            x.w("MicroMsg.NetScenePayBase", "hy: respString is null");
            b = str4;
            str2 = string;
            i3 = -10088;
        } else {
            try {
                jSONObject = new JSONObject(b);
                try {
                    this.zHw = jSONObject.optString("error_detail_url");
                    int i6 = jSONObject.getInt("retcode");
                    optString = jSONObject.optString("retmsg");
                    try {
                        this.zHs = jSONObject.optString("pay_flag");
                        this.zHt = jSONObject.optString("return_url");
                        this.zHu = jSONObject.optString("wappay_jumped_url");
                        this.sLY = jSONObject.optInt("is_gen_cert");
                        this.sLZ = jSONObject.optString("crt_token");
                        this.sMa = jSONObject.optInt("is_hint_crt");
                        JSONObject optJSONObject = jSONObject.optJSONObject("crt_wording");
                        if (optJSONObject != null) {
                            this.sMb = optJSONObject.toString();
                        } else {
                            this.sMb = "";
                        }
                        this.sMc = jSONObject.optInt("is_ignore_crt");
                        if (jSONObject.optInt("del_cert", 0) != 0) {
                            r.cBz();
                            x.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[]{r.cBy()});
                            r.cBz().aaw(string);
                        }
                        this.zHx = true;
                        i3 = i6;
                        b = str4;
                        jSONObject2 = jSONObject;
                        str2 = optString;
                        jSONObject3 = jSONObject2;
                    } catch (Exception e2) {
                        e = e2;
                        x.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                        i3 = -10089;
                        b = ac.getContext().getString(a.i.uSl);
                        jSONObject2 = jSONObject;
                        str2 = optString;
                        jSONObject3 = jSONObject2;
                        x.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bKu()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                        cVar = new c(i, i2, str);
                        if (i == 0) {
                        }
                        x.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                        y = bi.y(str, "e");
                        if (y == null) {
                            if (i2 != -1) {
                            }
                            x.w("MicroMsg.NetScenePayBase", "hy: network error");
                            cVar.fnL = ac.getContext().getString(a.i.uTb);
                        } else {
                            x.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                            cVar.fnL = (String) y.get(".e.Content");
                        }
                        if (jSONObject3 != null) {
                            x.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                        } else {
                            if (cVar.errType == 0) {
                            }
                            x.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                        }
                        a(cVar, jSONObject3);
                        if (this.zHv) {
                            x.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                        } else {
                            this.gJT.a(cVar.errType, cVar.errCode, cVar.fnL, this);
                        }
                    }
                } catch (Exception e3) {
                    exception = e3;
                    optString = string;
                    e = exception;
                    x.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                    i3 = -10089;
                    b = ac.getContext().getString(a.i.uSl);
                    jSONObject2 = jSONObject;
                    str2 = optString;
                    jSONObject3 = jSONObject2;
                    x.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bKu()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                    cVar = new c(i, i2, str);
                    if (i == 0) {
                    }
                    x.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                    y = bi.y(str, "e");
                    if (y == null) {
                        x.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                        cVar.fnL = (String) y.get(".e.Content");
                    } else {
                        if (i2 != -1) {
                        }
                        x.w("MicroMsg.NetScenePayBase", "hy: network error");
                        cVar.fnL = ac.getContext().getString(a.i.uTb);
                    }
                    if (jSONObject3 != null) {
                        if (cVar.errType == 0) {
                        }
                        x.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                    } else {
                        x.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                    }
                    a(cVar, jSONObject3);
                    if (this.zHv) {
                        x.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                    } else {
                        this.gJT.a(cVar.errType, cVar.errCode, cVar.fnL, this);
                    }
                }
            } catch (Exception e4) {
                exception = e4;
                jSONObject = null;
                optString = string;
                e = exception;
                x.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                i3 = -10089;
                b = ac.getContext().getString(a.i.uSl);
                jSONObject2 = jSONObject;
                str2 = optString;
                jSONObject3 = jSONObject2;
                x.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bKu()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                cVar = new c(i, i2, str);
                if (i == 0) {
                }
                x.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                y = bi.y(str, "e");
                if (y == null) {
                    if (i2 != -1) {
                    }
                    x.w("MicroMsg.NetScenePayBase", "hy: network error");
                    cVar.fnL = ac.getContext().getString(a.i.uTb);
                } else {
                    x.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                    cVar.fnL = (String) y.get(".e.Content");
                }
                if (jSONObject3 != null) {
                    x.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                } else {
                    if (cVar.errType == 0) {
                    }
                    x.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                }
                a(cVar, jSONObject3);
                if (this.zHv) {
                    this.gJT.a(cVar.errType, cVar.errCode, cVar.fnL, this);
                } else {
                    x.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                }
            }
        }
        x.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bKu()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
        cVar = new c(i, i2, str);
        if (i == 0 || i2 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
            y = bi.y(str, "e");
            if (y == null) {
                x.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                cVar.fnL = (String) y.get(".e.Content");
            } else if (i2 != -1 || i2 == -500) {
                x.w("MicroMsg.NetScenePayBase", "hy: network error");
                cVar.fnL = ac.getContext().getString(a.i.uTb);
            } else {
                x.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                cVar.fnL = ac.getContext().getString(a.i.uRf);
            }
        } else if (i4 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
            cVar.c(1000, i4, str3, 1);
        } else if (i5 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
            cVar.c(1000, i5, b, 2);
        } else if (i3 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
            if (i3 == -10089 || i3 == -10088) {
                cVar.c(1000, 2, str2, 2);
            } else {
                cVar.c(1000, i3, str2, 2);
            }
        } else {
            x.i("MicroMsg.NetScenePayBase", "hy: all's OK");
        }
        if (jSONObject3 != null) {
            x.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        } else if ((cVar.errType == 0 || cVar.errCode != 0) && !bnA()) {
            x.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        } else {
            a(cVar.errCode, cVar.fnL, jSONObject3);
        }
        a(cVar, jSONObject3);
        if (this.zHv) {
            x.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
        } else {
            this.gJT.a(cVar.errType, cVar.errCode, cVar.fnL, this);
        }
    }

    public String bhV() {
        return null;
    }

    public boolean bnA() {
        return false;
    }

    public boolean bhc() {
        reset();
        return false;
    }

    public final int aXh() {
        return bKu();
    }

    public final String cBp() {
        return this.zHw;
    }

    public boolean bhd() {
        return true;
    }
}
