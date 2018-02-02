package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g extends e implements a {
    private a mFg;
    private int mFh = 5;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ g mFi;
        final /* synthetic */ String mFj;
        final /* synthetic */ ei mFk;

        AnonymousClass4(g gVar, String str, ei eiVar) {
            this.mFi = gVar;
            this.mFj = str;
            this.mFk = eiVar;
        }

        public final void run() {
            String AN = g.AN(this.mFj);
            x.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", new Object[]{AN, this.mFj});
            if (!bh.ov(AN)) {
                String cC = g.cC(AN, "res=");
                x.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", new Object[]{cC, AN});
                if (!bh.ov(cC) && (cC.startsWith("success") || cC.startsWith("already"))) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.mFi.mEZ;
                    d dVar = d.mHD;
                    b bVar = new b();
                    bVar.mHz = this.mFk;
                    freeWifiFrontPageUI.a(dVar, bVar);
                    return;
                }
            }
            this.mFi.aMn();
        }
    }

    static /* synthetic */ void a(g gVar) {
        gVar.mFg = new a(gVar.ssid, gVar.mEZ);
        gVar.mFg.a(new a.a(gVar) {
            final /* synthetic */ g mFi;

            {
                this.mFi = r1;
            }

            public final void onSuccess() {
                x.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", new Object[]{m.D(this.mFi.intent), Integer.valueOf(m.E(this.mFi.intent))});
                g.b(this.mFi);
            }

            public final void pQ(int i) {
                this.mFi.aMn();
            }
        });
    }

    static /* synthetic */ void b(g gVar) {
        String AN;
        int i = gVar.mFh;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            x.i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", new Object[]{Integer.valueOf(i2)});
            String zL = com.tencent.mm.k.g.zZ().zL();
            x.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", new Object[]{zL});
            if (bh.ov(zL)) {
                x.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", new Object[]{"http://10.1.0.6/redirect"});
                zL = "http://10.1.0.6/redirect";
            }
            AN = AN(zL);
            x.i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", new Object[]{zL, AN});
            if (!bh.ov(AN)) {
                break;
            }
            x.e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", new Object[]{zL, AN});
            try {
                Thread.sleep(500);
                i = i2;
            } catch (Exception e) {
                i = i2;
            }
        }
        String cC = cC(AN, "auth=");
        x.i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", new Object[]{cC, AN});
        if (bh.ov(cC)) {
            x.e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", new Object[]{AN});
            gVar.aMn();
            return;
        }
        x.i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", new Object[]{cC, gVar.mFa, com.tencent.mm.plugin.freewifi.model.d.aLB()});
        if (bh.ov(cC)) {
            gVar.aMn();
        } else {
            new com.tencent.mm.plugin.freewifi.d.a(gVar.mFa, gVar.ssid, r3, "", cC, "", gVar.fdS, m.D(gVar.intent)).b(new 3(gVar));
        }
    }

    public g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    public final void connect() {
        j.aLR().aLz().post(new 1(this));
    }

    private void aMn() {
        this.mEZ.a(d.mHC, FreeWifiFrontPageUI$a.mHy);
    }

    static String cC(String str, String str2) {
        if (bh.ov(str)) {
            x.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            return null;
        }
        String[] split;
        String[] split2 = str.split("\\?");
        if (str2.length() > 0) {
            split = split2[1].split("&");
        } else {
            split = split2;
        }
        if (split == null || split.length <= 0) {
            return null;
        }
        for (String str3 : split) {
            if (str3.startsWith(str2)) {
                return str3.substring(str2.length());
            }
        }
        return null;
    }

    static String AN(String str) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.ProtocolOne", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        x.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{exception.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return null;
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            x.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{exception.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
