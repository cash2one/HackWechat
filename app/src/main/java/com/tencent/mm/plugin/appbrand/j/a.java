package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

public final class a {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public int jBf;
    public String jBg = (e.gHs + "appbrand/");
    public SSLContext jBh;
    public final String jBi;
    protected final ArrayList<String> jBj = new ArrayList();
    public final ArrayList<b> jBk = new ArrayList();
    public String mAppId;

    class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.j.a.a {
        final /* synthetic */ a jBl;
        final /* synthetic */ a jBm;
        final /* synthetic */ String jbj;

        public AnonymousClass1(a aVar, String str, a aVar2) {
            this.jBm = aVar;
            this.jbj = str;
            this.jBl = aVar2;
        }

        public final void a(String str, String str2, String str3, int i) {
            this.jBm.tm(this.jbj);
            this.jBl.c(a.SUCCESS, str2, str, i);
            x.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[]{str, str3});
        }

        public final void g(int i, long j, long j2) {
            this.jBl.f(i, j, j2);
        }

        public final void C(String str, String str2, String str3) {
            x.e("MicroMsg.AppBrandNetworkDownload", "download error! filename %s, url %s", new Object[]{str, str2});
            this.jBl.sB(str3);
            this.jBm.tm(this.jbj);
        }

        public final void bv(String str, String str2) {
            x.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[]{str, str2});
        }

        public final void tp(String str) {
            this.jBm.jBj.remove(str);
        }
    }

    public interface a {
        void c(int i, String str, String str2, int i2);

        void f(int i, long j, long j2);

        void sB(String str);
    }

    public a(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.jBf = appBrandSysConfig.iOs;
        this.jBh = i.tx(this.mAppId);
        this.jBi = str2;
    }

    private void tm(String str) {
        if (str != null) {
            synchronized (this.jBk) {
                Iterator it = this.jBk.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (str.equals(bVar.jbo)) {
                        this.jBk.remove(bVar);
                        break;
                    }
                }
            }
        }
    }

    public final b tn(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jBk) {
            Iterator it = this.jBk.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (str.equals(bVar.jbo)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.jBj.add(bVar.jbo);
            tm(bVar.jbo);
            bVar.aiI();
        }
    }

    public final boolean to(String str) {
        return this.jBj.contains(str);
    }
}
