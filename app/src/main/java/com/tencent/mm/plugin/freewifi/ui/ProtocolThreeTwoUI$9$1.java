package com.tencent.mm.plugin.freewifi.ui;

import android.net.Uri;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.9;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

class ProtocolThreeTwoUI$9$1 implements a {
    private final int mFA = 3;
    private int mFB = 0;
    private a mFC = new 1(this);
    final /* synthetic */ String mFD;
    int mFz = 0;
    final /* synthetic */ 9 mIY;

    ProtocolThreeTwoUI$9$1(9 9, String str) {
        this.mIY = 9;
        this.mFD = str;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.D(this.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIY.mIW.getIntent())));
            ProtocolThreeTwoUI.f(this.mIY.mIW);
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            AO(httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(this.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIY.mIW.getIntent())));
            d.a(this.mIY.mIW.ssid, 3, this.mIY.mIW.getIntent());
            ProtocolThreeTwoUI.a(this.mIY.mIW, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.D(this.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIY.mIW.getIntent())), exception.getMessage());
        if (exception instanceof UnknownHostException) {
            ProtocolThreeTwoUI.a(this.mIY.mIW, 102, m.e(exception));
            int i = this.mFz + 1;
            this.mFz = i;
            if (i <= 3) {
                try {
                    Thread.sleep(3000);
                    com.tencent.mm.plugin.freewifi.a.a.aLn();
                    com.tencent.mm.plugin.freewifi.a.a.a(this.mFD, this);
                    return;
                } catch (InterruptedException e) {
                    return;
                }
            }
            d.a(this.mIY.mIW.ssid, 3, this.mIY.mIW.getIntent());
            ProtocolThreeTwoUI.a(this.mIY.mIW, 101, m.e(exception));
            return;
        }
        d.a(this.mIY.mIW.ssid, 3, this.mIY.mIW.getIntent());
        ProtocolThreeTwoUI.a(this.mIY.mIW, 101, m.e(exception));
    }

    private void AO(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("authUrl");
        String AC = m.AC(parse.getQueryParameter("extend"));
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.D(this.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIY.mIW.getIntent())), str, queryParameter, AC);
        if (m.AA(queryParameter)) {
            this.mFB++;
            if (this.mFB < 3) {
                com.tencent.mm.plugin.freewifi.a.a.aLn();
                com.tencent.mm.plugin.freewifi.a.a.a(str, this.mFC);
                return;
            }
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.D(this.mIY.mIW.getIntent()), Integer.valueOf(m.E(this.mIY.mIW.getIntent())));
            d.a(this.mIY.mIW.ssid, 3, this.mIY.mIW.getIntent());
            ProtocolThreeTwoUI.a(this.mIY.mIW, 36, "BLACK_302_TIMES_EXCESS");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(queryParameter);
        if (queryParameter.indexOf("?") != -1) {
            stringBuilder.append("&extend=").append(AC);
        } else {
            stringBuilder.append("?extend=").append(AC);
        }
        stringBuilder.append("&openId=").append(m.AC(ProtocolThreeTwoUI.j(this.mIY.mIW))).append("&tid=").append(m.AC(ProtocolThreeTwoUI.i(this.mIY.mIW))).append("&timestamp=").append(ProtocolThreeTwoUI.h(this.mIY.mIW)).append("&sign=").append(ProtocolThreeTwoUI.g(this.mIY.mIW));
        ProtocolThreeTwoUI.a(this.mIY.mIW, stringBuilder.toString());
    }
}
