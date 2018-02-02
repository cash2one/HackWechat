package com.tencent.mm.plugin.appbrand.appcache;

import android.os.StatFs;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.pluginsdk.i.a.d.f.b;
import com.tencent.mm.pluginsdk.i.a.d.j;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m.a;
import java.io.File;

final class aa$d extends a<ab> {
    private static final ThreadLocal<aa$a> iFH = new 1();
    String iFI = null;
    final p$a iFJ;

    protected final /* bridge */ /* synthetic */ b aai() {
        return (ab) super.aai();
    }

    aa$d(ab abVar) {
        super(abVar);
        p$a a = p.a(abVar);
        if (a == null) {
            a = e.iDO;
        }
        this.iFJ = a;
    }

    protected final ab aaa() {
        return (ab) super.aai();
    }

    public final String getURL() {
        return this.iFI;
    }

    protected final l a(j jVar) {
        l a;
        ab abVar = (ab) super.aai();
        com.tencent.mm.loader.stub.b.deleteFile(abVar.getFilePath());
        this.iFI = abVar.url;
        p$a com_tencent_mm_plugin_appbrand_appcache_p_a = this.iFJ;
        this.iFI.startsWith("https");
        com_tencent_mm_plugin_appbrand_appcache_p_a.Zz();
        l a2 = ((aa$a) iFH.get()).a(this);
        Object obj = ((a2 == null || a2.status == 3) && this.iFI.startsWith("http://")) ? 1 : null;
        if ((a2 == null || a2.status == 3) && this.iFI.startsWith("https")) {
            Object obj2;
            this.iFJ.ZB();
            if (abVar instanceof aa.b) {
                obj2 = null;
            } else {
                int i = 1;
            }
            if (obj2 != null) {
                this.iFI = this.iFI.replaceFirst("https", "http");
                a = super.a(jVar);
            }
            a = a2;
        } else {
            if (a2 == null || obj != null) {
                a = super.a(jVar);
            }
            a = a2;
        }
        this.iFJ.a(a);
        if (a == null) {
            return new l(this, null, -1, 3);
        }
        return a;
    }

    public final boolean bD(long j) {
        StatFs statFs = new StatFs(new File(getFilePath()).getParentFile().getAbsolutePath());
        long availableBlocks = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
        return availableBlocks < 0 || availableBlocks > j;
    }

    public final String aab() {
        return "AppBrandWxaPkgDownloader";
    }

    public final boolean aac() {
        return true;
    }

    public final boolean aad() {
        return false;
    }

    public final boolean aae() {
        return true;
    }

    protected final boolean aaf() {
        return false;
    }

    public final boolean aag() {
        return true;
    }

    public final boolean aah() {
        switch (w.yV()) {
            case 1:
                return super.aah();
            default:
                return false;
        }
    }
}
