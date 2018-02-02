package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.f.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> mCq = new 1();
    private String bssid;
    private int fCR;
    private String fpA;
    private String fpz;
    private String kZo;
    private int mCr;
    private String mCs;
    private String mCt;
    private String mCu;
    private int mCv;
    private long mCw;
    private String mCx;
    private String mCy;
    private long mCz;
    private int result;
    private String ssid;

    public static String Az(String str) {
        return m.AC((String) mCq.get(str));
    }

    private k() {
    }

    public static a aLe() {
        return new a((byte) 0);
    }

    public final k aLf() {
        g.pQN.h(12804, new Object[]{m.AC(this.ssid), m.AC(this.bssid), m.AC(this.fpA), m.AC(this.fpz), Integer.valueOf(this.mCr), m.AC(this.mCs), m.AC(this.mCt), m.AC(this.mCu), Integer.valueOf(this.mCv), Long.valueOf(this.mCw), m.AC(this.mCx), Integer.valueOf(this.result), Integer.valueOf(this.fCR), m.AC(this.mCy), Long.valueOf(this.mCz), m.AC(this.kZo)});
        return this;
    }

    public final k b(Intent intent, boolean z) {
        try {
            final int F = m.F(intent);
            if (F == 31) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ssid", this.ssid);
                    jSONObject.put("bssid", this.bssid);
                    jSONObject.put("clientMac", this.fpA);
                    jSONObject.put("apKey", this.fpz);
                    jSONObject.put("qrtype", this.mCr);
                    jSONObject.put("mpShopId", this.mCs);
                    jSONObject.put("mpAppId", this.mCt);
                    jSONObject.put("sessionKey", this.mCu);
                    jSONObject.put("protocolType", this.mCv);
                    jSONObject.put("stageCode", this.mCw);
                    jSONObject.put("stageName", this.mCx);
                    jSONObject.put("result", this.result);
                    jSONObject.put("channel", this.fCR);
                    jSONObject.put("mpUserName", this.mCy);
                    jSONObject.put("timeCost", this.mCz);
                    jSONObject.put("resultMsg", this.kZo);
                    jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
                } catch (Exception e) {
                    x.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.f(e));
                }
                String jSONObject2 = jSONObject.toString();
                String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (m.AA(stringExtra)) {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
                } else {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
                final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (z) {
                    j.aLS().aLz().post(new Runnable(this) {
                        final /* synthetic */ k mCD;

                        public final void run() {
                            j.aLQ().a(stringExtra2, F, stringExtra3, currentTimeMillis);
                            if (m.aLl()) {
                                b.pY(1);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.f(e2));
        }
        return this;
    }
}
