package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.b.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$2 extends c<bc> {
    final /* synthetic */ b mNv;

    b$2(b bVar) {
        this.mNv = bVar;
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.fpl.fpm == 35 && bcVar.fpl.fpn == 1) {
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", new Object[]{bcVar.fpl.filePath});
            b bVar2 = this.mNv;
            String str = bcVar.fpl.filePath;
            File file = new File(b.aNa(), "temp");
            if (file.exists()) {
                FileOp.G(file.getAbsolutePath(), false);
            }
            file.mkdirs();
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", new Object[]{str, Integer.valueOf(bh.ft(str, file.getAbsolutePath()))});
            if (bh.ft(str, file.getAbsolutePath()) >= 0) {
                File aNb = b.aNb();
                File file2 = new File(file, "fts_feature");
                x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", new Object[]{Integer.valueOf(b.D(file2)), Integer.valueOf(b.D(aNb))});
                if (b.D(file2) > b.D(aNb)) {
                    FileOp.G(aNb.getAbsolutePath(), false);
                    file2.renameTo(aNb);
                    bVar2.gJk.a(65596, new d(bVar2, aNb.getAbsolutePath()));
                }
            }
        }
        return true;
    }
}
