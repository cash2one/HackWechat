package com.tencent.mm.plugin.search.a;

import com.tencent.mm.a.e;
import com.tencent.mm.az.r;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.search.ui.b.b;
import com.tencent.mm.plugin.search.ui.b.f;
import com.tencent.mm.plugin.search.ui.b.i;
import com.tencent.mm.plugin.search.ui.b.j;
import com.tencent.mm.plugin.search.ui.b.l;
import com.tencent.mm.plugin.search.ui.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.io.File;
import java.util.HashMap;
import junit.framework.Assert;

public class c implements ap {
    private com.tencent.mm.sdk.b.c ikK = new 1(this);
    private com.tencent.mm.sdk.b.c jJc = new 2(this);
    private long qbn;
    private m qbo = new 3(this);
    private com.tencent.mm.sdk.b.c qbp = new 5(this);

    static /* synthetic */ void a(c cVar, boolean z) {
        int i;
        int[] iArr = new int[]{0, 1};
        String[] strArr = new String[2];
        for (i = 0; i < 2; i++) {
            strArr[i] = g.zR(iArr[i]);
        }
        Assert.assertEquals(2, 2);
        for (i = 0; i < 2; i++) {
            File file = new File(strArr[i]);
            x.i("MicroMsg.FTS.SubCoreSearch", "copy to path %s, type %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(iArr[i])});
            int zQ = g.zQ(iArr[i]);
            if (z) {
                x.i("MicroMsg.FTS.SubCoreSearch", "need update assetVersion=%d currentVersion=%d type=%d", new Object[]{Integer.valueOf(g.zL(iArr[i])), Integer.valueOf(zQ), Integer.valueOf(iArr[i])});
                if (zQ < g.zL(iArr[i])) {
                    e.g(file);
                    e(file, iArr[i]);
                }
            } else if (zQ == 1) {
                x.i("MicroMsg.FTS.SubCoreSearch", "need init template");
                e.g(file);
                e(file, iArr[i]);
            } else {
                x.i("MicroMsg.FTS.SubCoreSearch", "currentVersion=%d", new Object[]{Integer.valueOf(zQ)});
            }
        }
        e.g(new File(com.tencent.mm.compatible.util.e.bnF, "fts"));
    }

    static /* synthetic */ void dq(int i, int i2) {
        if (i == 2) {
            com.tencent.mm.bc.g.iq(i2);
        }
    }

    static /* synthetic */ void f(File file, int i) {
        String str = "";
        String str2 = "";
        switch (i) {
            case 1:
                str = g.zR(0);
                str2 = g.zP(0);
                break;
            case 2:
                str = g.zR(1);
                str2 = g.zP(1);
                break;
        }
        if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.FTS.SubCoreSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", new Object[]{Integer.valueOf(i), file.getAbsolutePath()});
            return;
        }
        File file2 = new File(str);
        e.g(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(str2);
        e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        int ft = bh.ft(file3.getAbsolutePath(), file3.getParent());
        if (ft < 0) {
            x.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + ft + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        switch (i) {
            case 1:
                ft = g.zQ(0);
                break;
            case 2:
                ft = g.zQ(1);
                break;
            default:
                ft = 1;
                break;
        }
        a.xef.m(new ms());
        x.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file3.getParent(), Integer.valueOf(ft)});
    }

    private static c bpP() {
        ar.Ha();
        c cVar = (c) bp.hY("plugin.search");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        ar.Ha().a(c.class.getName(), cVar2);
        return cVar2;
    }

    public static com.tencent.mm.plugin.fts.d.g bpQ() {
        return h.aNx();
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        h.a(new k());
        this.qbp.ceO();
        this.ikK.ceO();
        this.jJc.ceO();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.qbo);
        bpS();
        com.tencent.mm.sdk.f.e.post(new a(this, z), "CopySearchTemplateTask");
        h.a(new l());
        h.a(new com.tencent.mm.plugin.search.ui.b.e());
        h.a(new com.tencent.mm.plugin.search.ui.b.c());
        h.a(new com.tencent.mm.plugin.search.ui.b.g());
        h.a(new i());
        h.a(new com.tencent.mm.plugin.search.ui.b.k());
        h.a(new com.tencent.mm.plugin.search.ui.b.d());
        h.a(new b());
        h.a(new com.tencent.mm.plugin.search.ui.b.h());
        h.a(new j());
        h.a(new com.tencent.mm.plugin.search.ui.b.a());
        h.a(new f());
    }

    public final void onAccountRelease() {
        this.qbp.dead();
        this.ikK.dead();
        this.jJc.dead();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.qbo);
        h.aNw();
        com.tencent.mm.bc.d.hKE = null;
    }

    private static void e(File file, int i) {
        String zP = g.zP(i);
        if (bh.ov(zP)) {
            x.w("MicroMsg.FTS.SubCoreSearch", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", new Object[]{Integer.valueOf(i), file.getAbsolutePath()});
            return;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(zP);
        if (g.zO(i)) {
            int ft = bh.ft(file2.getAbsolutePath(), file2.getParent());
            if (ft < 0) {
                x.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + ft + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            ft = g.zQ(i);
            x.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", new Object[]{file2.getParent(), Integer.valueOf(ft)});
            return;
        }
        x.i("MicroMsg.FTS.SubCoreSearch", "copy template file from asset fail %s", new Object[]{file2.getAbsolutePath()});
    }

    public static void bpR() {
        if (r.QH().be(0, 18) != null) {
            if (new File(r.QH().bh(0, 18)).exists()) {
                x.i("MicroMsg.FTS.SubCoreSearch", "Exist Uzip Folder path=%s", new Object[]{r.QH().bh(0, 18)});
            } else {
                x.i("MicroMsg.FTS.SubCoreSearch", "Not Exist Uzip Folder， path=%s", new Object[]{r.QH().bh(0, 18)});
                ar.CG().a(new com.tencent.mm.az.j(0, 18), 0);
                return;
            }
        }
        if (System.currentTimeMillis() - bpP().qbn > 7200000) {
            bpP().qbn = System.currentTimeMillis();
            ar.CG().a(new com.tencent.mm.az.k(18), 0);
        }
    }

    private void bpS() {
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon().a(65536, new 4(this));
    }

    public static boolean bpT() {
        File file = new File(g.zR(1));
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File file2 = new File(file, g.bOR());
        File file3 = new File(file, g.bOS());
        if (file2.exists() && file3.exists()) {
            return true;
        }
        return false;
    }
}
