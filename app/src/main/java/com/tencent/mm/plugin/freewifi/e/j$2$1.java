package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a.a$a;
import com.tencent.mm.plugin.freewifi.e.j.2;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

class j$2$1 implements a$a {
    private final int mFA = 3;
    private int mFB = 0;
    private a$a mFC = new 1(this);
    final /* synthetic */ String mFD;
    final /* synthetic */ 2 mFE;
    int mFz = 0;

    j$2$1(2 2, String str) {
        this.mFE = 2;
        this.mFD = str;
    }

    public final void e(HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[]{m.D(this.mFE.mFy.intent), Integer.valueOf(m.E(this.mFE.mFy.intent))});
            j.a(this.mFE.mFy, 0, "");
            m.a(this.mFE.mFy.intent, this.mFE.mFy.fpz, this.mFE.mFy.mFb, this.mFE.mFy.fdS, this.mFE.mFy.mEZ, "MicroMsg.FreeWifi.Protocol32");
        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
            AO(httpURLConnection.getHeaderField("Location"));
        } else {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.D(this.mFE.mFy.intent), Integer.valueOf(m.E(this.mFE.mFy.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFE.mFy.mEZ;
            d dVar = d.mHC;
            a aVar = new a();
            aVar.mHb = m.a(this.mFE.mFy.mFb, b.mCZ, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.b(this.mFE.mFy, 32, "INVALID_HTTP_RESP_CODE");
        }
    }

    public final void h(Exception exception) {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.D(this.mFE.mFy.intent), Integer.valueOf(m.E(this.mFE.mFy.intent)), exception.getMessage(), m.f(exception)});
        if (exception instanceof UnknownHostException) {
            j.b(this.mFE.mFy, 102, m.e(exception));
            x.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.mFz);
            int i = this.mFz + 1;
            this.mFz = i;
            if (i <= 3) {
                try {
                    Thread.sleep(3000);
                    com.tencent.mm.plugin.freewifi.a.a.aLn();
                    com.tencent.mm.plugin.freewifi.a.a.a(this.mFD, this);
                    return;
                } catch (InterruptedException e) {
                    x.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", new Object[]{m.f(exception)});
                    j.b(this.mFE.mFy, 103, m.e(exception));
                    freeWifiFrontPageUI = this.mFE.mFy.mEZ;
                    dVar = d.mHC;
                    aVar = new a();
                    aVar.mHb = m.a(this.mFE.mFy.mFb, b.mCZ, 103);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    return;
                }
            }
            freeWifiFrontPageUI = this.mFE.mFy.mEZ;
            dVar = d.mHC;
            aVar = new a();
            aVar.mHb = m.a(this.mFE.mFy.mFb, b.mCZ, m.g(exception));
            freeWifiFrontPageUI.a(dVar, aVar);
            j.b(this.mFE.mFy, m.g(exception), m.e(exception));
            return;
        }
        freeWifiFrontPageUI = this.mFE.mFy.mEZ;
        dVar = d.mHC;
        aVar = new a();
        aVar.mHb = m.a(this.mFE.mFy.mFb, b.mCZ, m.g(exception));
        freeWifiFrontPageUI.a(dVar, aVar);
        j.b(this.mFE.mFy, m.g(exception), m.e(exception));
    }

    private void AO(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("authUrl");
        String AC = m.AC(parse.getQueryParameter("extend"));
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[]{m.D(this.mFE.mFy.intent), Integer.valueOf(m.E(this.mFE.mFy.intent)), str, queryParameter, AC});
        if (m.AA(queryParameter)) {
            this.mFB++;
            if (this.mFB < 3) {
                com.tencent.mm.plugin.freewifi.a.a.aLn();
                com.tencent.mm.plugin.freewifi.a.a.a(str, this.mFC);
                return;
            }
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.D(this.mFE.mFy.intent), Integer.valueOf(m.E(this.mFE.mFy.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFE.mFy.mEZ;
            d dVar = d.mHC;
            a aVar = new a();
            aVar.mHb = m.a(this.mFE.mFy.mFb, b.mCZ, 36);
            freeWifiFrontPageUI.a(dVar, aVar);
            j.a(this.mFE.mFy, 36, "BLACK_302_TIMES_EXCESS");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(queryParameter);
        if (queryParameter.indexOf("?") != -1) {
            stringBuilder.append("&extend=").append(AC);
        } else {
            stringBuilder.append("?extend=").append(AC);
        }
        stringBuilder.append("&openId=").append(m.AC(this.mFE.mFy.openId)).append("&tid=").append(m.AC(this.mFE.mFy.mFx)).append("&timestamp=").append(this.mFE.mFy.fqD).append("&sign=").append(this.mFE.mFy.sign);
        j.aLR().aLz().post(new j$3(this.mFE.mFy, stringBuilder.toString()));
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", new Object[]{m.D(this.mFE.mFy.intent), Integer.valueOf(m.E(this.mFE.mFy.intent)), stringBuilder.toString()});
    }
}
