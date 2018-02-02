package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class i {

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a vxY;

        AnonymousClass2(a aVar) {
            this.vxY = aVar;
        }

        public final void run() {
            this.vxY.bkx();
        }
    }

    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ a vxY;

        AnonymousClass4(a aVar) {
            this.vxY = aVar;
        }

        public final void run() {
            this.vxY.bkx();
        }
    }

    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ a vxY;
        final /* synthetic */ int vxZ;

        AnonymousClass5(a aVar, int i) {
            this.vxY = aVar;
            this.vxZ = i;
        }

        public final void run() {
            this.vxY.vb(this.vxZ);
        }
    }

    public static void a(final a aVar) {
        ar.Dm().F(new Runnable() {
            public final void run() {
                try {
                    a aVar = aVar;
                    x.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
                    ar.Hg();
                    String str = (String) c.CU().get(-1535680990, (Object) "");
                    ar.Hg();
                    long longValue = new o(bh.e((Integer) c.CU().get(9, null))).longValue();
                    if (bh.ov(str) || longValue == 0) {
                        ar.Hg();
                        c.CU().a(a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
                        x.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
                        ag.y(new AnonymousClass2(aVar));
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                    httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
                    if (httpURLConnection.getResponseCode() >= 300) {
                        httpURLConnection.disconnect();
                        x.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
                        ag.y(new 3(aVar));
                        return;
                    }
                    Map y = bi.y(bh.convertStreamToString(httpURLConnection.getInputStream()), "Response");
                    int i = (y == null || bh.getInt((String) y.get(".Response.error.code"), -1) != 0) ? -1 : bh.getInt((String) y.get(".Response.result.UnreadCount"), -1);
                    if (i < 0) {
                        ag.y(new AnonymousClass4(aVar));
                        return;
                    }
                    ar.Hg();
                    c.CU().a(a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i));
                    ag.y(new AnonymousClass5(aVar, i));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e, "", new Object[0]);
                    x.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                }
            }
        });
    }
}
