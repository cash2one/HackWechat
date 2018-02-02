package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class i implements a {
    LinkedList<au> hUB = new LinkedList();
    long hUC = 0;
    private int hUD = 0;
    private int hUE = 0;
    public boolean hUF = false;
    public boolean hUG = false;
    private boolean hUH = false;
    private boolean hUI = false;
    f hUJ = null;
    long hUK = 0;

    static /* synthetic */ boolean a(i iVar) {
        long Wq = bh.Wq();
        x.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", new Object[]{Integer.valueOf(iVar.hashCode()), Integer.valueOf(1), Integer.valueOf(111), Long.valueOf(bh.Wo() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("PreLoadVideoExpiredTime", 1)) * 86400)), Boolean.valueOf(true)});
        List<r> a = o.TU().a(111, 1, r0);
        if (a == null || a.isEmpty()) {
            return false;
        }
        int i = 0;
        for (r rVar : a) {
            if (rVar != null) {
                int i2;
                o.TU();
                String nt = s.nt(rVar.getFileName());
                if (!bh.ov(nt)) {
                    File file = new File(nt);
                    if (file.exists()) {
                        long length = file.length();
                        x.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[]{rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.fzU), Long.valueOf(rVar.hVF), nt});
                        if (length > 0 && length <= ((long) rVar.fzU)) {
                            file.delete();
                            i2 = i + 1;
                            rVar.fzU = 0;
                            rVar.fDt = 1;
                            t.e(rVar);
                            i = i2;
                        }
                    }
                }
                i2 = i;
                rVar.fzU = 0;
                rVar.fDt = 1;
                t.e(rVar);
                i = i2;
            }
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(354, 144, (long) i, false);
        x.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[]{Integer.valueOf(iVar.hashCode()), Integer.valueOf(a.size()), Integer.valueOf(i), Long.valueOf(bh.bA(Wq))});
        return false;
    }

    public final void stopDownload() {
        x.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[]{Integer.valueOf(hashCode())});
        g.Dm().F(new 1(this));
    }

    public final void TN() {
        g.Dm().F(new 2(this));
    }

    public final void a(f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            x.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.hUJ != fVar) {
            x.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[]{Integer.valueOf(hashCode())});
        }
        x.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[]{Integer.valueOf(hashCode()), fVar.TM(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        g.Dm().F(new 3(this, fVar));
    }

    public final void bY(boolean z) {
        if (z) {
            this.hUD = ((Integer) g.Dj().CU().get(w.a.xvx, Integer.valueOf(0))).intValue();
            this.hUD++;
            g.Dj().CU().a(w.a.xvx, Integer.valueOf(this.hUD));
            return;
        }
        this.hUE = ((Integer) g.Dj().CU().get(w.a.xvy, Integer.valueOf(0))).intValue();
        this.hUE++;
        g.Dj().CU().a(w.a.xvy, Integer.valueOf(this.hUE));
    }

    public final boolean bZ(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = 100;
        this.hUC = ((Long) g.Dj().CU().get(w.a.xvw, Long.valueOf(-1))).longValue();
        if (bh.bz(this.hUC) >= 86400000) {
            this.hUC = bh.Wp();
            g.Dj().CU().a(w.a.xvw, Long.valueOf(this.hUC));
            g.Dj().CU().a(w.a.xvx, Integer.valueOf(0));
            g.Dj().CU().a(w.a.xvy, Integer.valueOf(0));
            this.hUI = false;
            this.hUH = false;
        }
        this.hUD = ((Integer) g.Dj().CU().get(w.a.xvx, Integer.valueOf(0))).intValue();
        this.hUE = ((Integer) g.Dj().CU().get(w.a.xvy, Integer.valueOf(0))).intValue();
        if (z) {
            i = this.hUD;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i = this.hUE;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("SnsMaxPreloadVideo", 100);
        }
        if (i2 > 0) {
            i3 = i2;
        }
        if (i >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.hUD), Integer.valueOf(this.hUE)});
        if (z2) {
            if (z) {
                if (!this.hUH) {
                    this.hUH = true;
                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 127, 1, false);
                }
            } else if (!this.hUI) {
                this.hUI = true;
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 128, 1, false);
            }
        }
        return z2;
    }

    public final void a(String str, int i, long j, String str2, String str3, int i2, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bh.Wo()).append(",");
        stringBuffer.append(bh.Wo()).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(",");
        stringBuffer.append(str2).append(",");
        stringBuffer.append(str3).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(str4).append(",");
        stringBuffer.append(str5).append(",");
        stringBuffer.append(str6);
        x.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[]{Integer.valueOf(hashCode()), stringBuffer.toString()});
        com.tencent.mm.plugin.report.service.g.pQN.k(14499, r2);
    }
}
