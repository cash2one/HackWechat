package com.tencent.mm.plugin.offline.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends i {
    public static String oWH = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    public String oWC = "";
    public String oWD = "";
    public String oWE = "";
    public String oWF = "";
    public String oWG = "";
    public String oWI = "";
    public int oWJ = 0;
    public String oWK = "";
    public String oWL = "";
    public String oWM = "";
    public int oWN = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    public String token = "";

    public k(Bankcard bankcard, String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", q.yF());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.vAz));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.oWN = i;
        String UZ = ab.UZ(ab.UZ(e.getUsername()) + ab.UZ(q.yF()));
        hashMap.put("user_id", UZ);
        a cBn = a.cBn();
        b.cBf();
        String dB = cBn.dB(UZ, b.cBh() ? 1 : 0);
        Object[] objArr = new Object[2];
        objArr[0] = dB;
        b.cBf();
        objArr[1] = Boolean.valueOf(b.cBh());
        x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", objArr);
        hashMap.put("crt_csr", dB);
        hashMap.put(DownloadSettingTable$Columns.TYPE, oWH);
        hashMap.put("version_number", oWH);
        D(hashMap);
    }

    public final int ayQ() {
        return 46;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.oWD = jSONObject.optString("crt_crt");
            this.oWC = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.oWE = jSONObject.optString("valid_end");
            this.oWF = jSONObject.optString("encrypt_str");
            this.oWG = jSONObject.optString("deviceid");
            if (a.cBn().importCert(this.oWC, this.oWD)) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.oWI = jSONObject.optString("token_v2");
            this.oWJ = jSONObject.optInt("algorithm_type");
            this.oWK = jSONObject.optString("card_list");
            this.oWL = jSONObject.optString("key_list");
            this.oWM = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            String optString3 = jSONObject.optString("code_ver");
            int optInt2 = jSONObject.optInt("cipher_type", 0);
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196617, this.oWC);
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196626, this.oWE);
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196627, this.oWF);
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196628, this.oWG);
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196630, "1");
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196632, (System.currentTimeMillis() / 1000));
            com.tencent.mm.plugin.offline.c.a.k(this.token, this.oWI, this.oWK, this.oWL);
            com.tencent.mm.plugin.offline.c.a.ut(this.oWJ);
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196647, this.oWM);
            com.tencent.mm.plugin.offline.c.a.GX(optString);
            com.tencent.mm.plugin.offline.k.bgX();
            optString = com.tencent.mm.plugin.offline.k.un(196617);
            a.cBn();
            a.clearToken(optString);
            a.cBn();
            x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", new Object[]{Boolean.valueOf(a.t(this.oWC, optString2, optInt2 == 1)), this.oWC});
            if (a.t(this.oWC, optString2, optInt2 == 1)) {
                x.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                a.cBn();
                x.e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(a.getLastError()).toString());
            }
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196649, String.valueOf(optInt));
            g.Dk();
            g.Dj().CU().a(w.a.xmO, q.yE());
            g.Dk();
            g.Dj().CU().a(w.a.xmP, optString3);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.offline.k.bgX();
            com.tencent.mm.plugin.offline.k.au(196630, "0");
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cBn().cBo();
    }

    public final int Hr() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
