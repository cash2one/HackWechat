package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af extends aa {
    public String fLC;
    public int fLD;
    public int fLE;
    public int fdS;
    long fqm;
    public int msgType = 1;
    public String nZa;
    public String nZi;
    public int obK;
    public String obL;
    public String obN;
    public String obP;
    public int obX;
    public int ocV = 1;
    public String ocW = null;
    public String ocX = null;
    public String ocY = null;
    public String ocZ = null;
    public ah ocd;
    public String oce;
    public String ocj;
    public String odA;
    public long odB;
    public long odC;
    public int odD;
    public String odE;
    public String oda = null;
    public long odb = 0;
    public int odl = 0;
    String talker;

    public af(int i, String str, String str2, int i2, String str3) {
        this.fdS = i;
        this.nZa = str;
        this.fLC = str2;
        Map hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", "0");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                g.Dk();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) g.Dj().CU().get(a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(1))).toString());
            }
        }
        if (!bh.ov(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        D(hashMap);
    }

    public final int getType() {
        return 1581;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.odA = jSONObject.optString("sendNick");
        this.obP = jSONObject.optString("sendHeadImg");
        this.fLD = jSONObject.optInt("hbStatus");
        this.fLE = jSONObject.optInt("receiveStatus");
        this.obL = jSONObject.optString("statusMess");
        this.obN = jSONObject.optString("wishing");
        this.obX = jSONObject.optInt("isSender");
        this.odB = jSONObject.optLong("sceneAmount");
        this.odC = jSONObject.optLong("sceneRecTimeStamp");
        this.obK = jSONObject.optInt("hbType");
        this.oce = jSONObject.optString("watermark");
        this.nZi = jSONObject.optString("externMess");
        this.ocj = jSONObject.optString("sendUserName");
        if (!bh.ov(this.ocj) && bh.ov(this.odA)) {
            this.odA = ((b) g.h(b.class)).gu(this.ocj);
        }
        this.ocd = l.J(jSONObject.optJSONObject("operationTail"));
        this.odl = jSONObject.optInt("scenePicSwitch");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.ocW = optJSONObject.optString("agreed_flag", "-1");
            this.ocX = optJSONObject.optString("title", "");
            this.ocY = optJSONObject.optString("service_protocol_wording", "");
            this.ocZ = optJSONObject.optString("service_protocol_url", "");
            this.oda = optJSONObject.optString("button_wording", "");
            this.odb = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.odb > 0) {
            g.Dk();
            g.Dj().CU().a(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.odb * 1000)));
        }
        x.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.odl);
        this.odD = jSONObject.optInt("preStrainFlag", 1);
        x.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.odD);
        g.Dk();
        g.Dj().CU().a(a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(this.odD));
        this.odE = jSONObject.optString("timingIdentifier");
    }

    public final boolean aXj() {
        return this.obX == 1;
    }
}
