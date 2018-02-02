package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends h {
    public String oWE;
    public String oWF;
    public String oWG;
    public String oWI;
    public int oWJ;
    public String oWK;
    public String oWL;
    public String oWM;
    private String oWO;
    private int oWP;
    public String oWQ;
    public int oWR;
    int oWS;
    public String token;

    public m(String str, int i) {
        this(str, i, i);
    }

    public m(String str, int i, int i2) {
        int i3;
        CharSequence genUserSig;
        this.token = "";
        this.oWE = "";
        this.oWF = "";
        this.oWG = "";
        this.oWI = "";
        this.oWJ = 0;
        this.oWK = "";
        this.oWL = "";
        this.oWM = "";
        this.oWR = 0;
        this.oWS = 0;
        x.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", new Object[]{Integer.valueOf(i), bh.cgy().toString()});
        Object bhV = a.bhV();
        k.bgX();
        String un = k.un(196628);
        if (TextUtils.isEmpty(un)) {
            un = q.yF();
        }
        if (TextUtils.isEmpty(bhV)) {
            un = un + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + Constants.MAX_BUFFER_SIZE);
        } else {
            un = un + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + Constants.MAX_BUFFER_SIZE) + "&" + bhV;
        }
        Map hashMap = new HashMap();
        hashMap.put("token_src", un);
        String str2 = "";
        k.bgX();
        String un2 = k.un(196617);
        switch (i2) {
            case 0:
                i3 = 12;
                break;
            case 1:
                i3 = 13;
                break;
            case 2:
                i3 = 14;
                break;
            case 3:
                i3 = 15;
                break;
            case 4:
                i3 = 16;
                break;
            case 5:
                i3 = 17;
                break;
            case 6:
                i3 = 18;
                break;
            case 7:
                i3 = 19;
                break;
            case 8:
                i3 = 20;
                break;
            case 9:
                i3 = 24;
                break;
            case 10:
                i3 = 72;
                break;
            default:
                i3 = 12;
                break;
        }
        g.pQN.a(135, (long) i3, 1, true);
        com.tencent.mm.wallet_core.c.a.cBn();
        if (com.tencent.mm.wallet_core.c.a.isCertExist(un2)) {
            com.tencent.mm.wallet_core.c.a.cBn();
            genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(un2, un);
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cBn();
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
            g.pQN.a(135, 6, 1, true);
            com.tencent.mm.kernel.g.Dk();
            un = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xmO, "");
            if (un == null || !un.equals(q.yE())) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                g.pQN.a(135, 5, 1, true);
            } else {
                x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
            }
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: " + un2);
            Object obj = str2;
        }
        if (TextUtils.isEmpty(genUserSig)) {
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            g.pQN.a(135, 4, 1, true);
        } else {
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig);
        hashMap.put("cert_no", un2);
        hashMap.put(DownloadSettingTable$Columns.TYPE, k.oWH);
        hashMap.put("version_number", k.oWH);
        if (a.bhU() == 2) {
            hashMap.put("last_token", a.bhW());
        } else {
            hashMap.put("last_token", a.bhV());
        }
        hashMap.put("scene", String.valueOf(i));
        x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", new Object[]{Boolean.valueOf(k.oWd)});
        if (k.oWd) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", "0");
        }
        D(hashMap);
    }

    public final int ayQ() {
        if (k.oWd) {
            return 52;
        }
        return 1725;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.oWE = jSONObject.optString("valid_end");
            this.oWF = jSONObject.optString("encrypt_str");
            this.oWG = jSONObject.optString("deviceid");
            this.oWI = jSONObject.optString("token_v2");
            this.oWJ = jSONObject.optInt("algorithm_type");
            this.oWK = jSONObject.optString("card_list");
            this.oWL = jSONObject.optString("key_list");
            this.oWM = jSONObject.optString("token_pin");
            this.oWO = jSONObject.optString("auth_codes");
            this.oWP = jSONObject.optInt("update_interval");
            this.oWQ = jSONObject.optString("code_ver");
            this.oWR = jSONObject.optInt("reget_token_num", 0);
            this.oWS = jSONObject.optInt("cipher_type", 0);
            if (this.oWR > 0) {
                k.oWe = this.oWR;
            } else {
                k.oWe = 10;
            }
            x.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", new Object[]{jSONObject.toString()});
        }
    }

    public final boolean bhe() {
        boolean z = true;
        x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        k.bgX();
        k.au(196626, this.oWE);
        k.bgX();
        k.au(196627, this.oWF);
        k.bgX();
        k.au(196628, this.oWG);
        k.bgX();
        k.au(196632, (System.currentTimeMillis() / 1000));
        a.k(this.token, this.oWI, this.oWK, this.oWL);
        a.ut(this.oWJ);
        k.bgX();
        k.au(196647, this.oWM);
        k.bgX();
        String un = k.un(196617);
        com.tencent.mm.wallet_core.c.a.cBn();
        com.tencent.mm.wallet_core.c.a.clearToken(un);
        com.tencent.mm.wallet_core.c.a.cBn();
        String str = this.oWO;
        if (this.oWS != 1) {
            z = false;
        }
        z = com.tencent.mm.wallet_core.c.a.t(un, str, z);
        if (z) {
            x.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            com.tencent.mm.wallet_core.c.a.cBn();
            x.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(com.tencent.mm.wallet_core.c.a.getLastError()).toString());
        }
        k.bgX();
        k.au(196649, this.oWP);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xmP, this.oWQ);
        return z;
    }

    public final int Hr() {
        if (k.oWd) {
            return 571;
        }
        return 1725;
    }

    public final String getUri() {
        if (k.oWd) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
        }
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
    }
}
