package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.plugin.readerapp.b.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class g$3 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ a pAG;

    g$3(a aVar, int i) {
        this.pAG = aVar;
        this.iGh = i;
    }

    public final void run() {
        int i = 0;
        ar.Hg();
        File file = new File(c.Fi());
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                g.d(this.pAG);
                return;
            }
            String format = String.format("reader_%d_", new Object[]{Integer.valueOf(this.iGh)});
            String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(this.iGh)});
            while (i < listFiles.length) {
                if (listFiles[i].getName().startsWith(format)) {
                    listFiles[i].delete();
                }
                if (listFiles[i].getName().startsWith(format2)) {
                    listFiles[i].delete();
                }
                i++;
            }
            g.d(this.pAG);
            return;
        }
        g.d(this.pAG);
    }

    public final String toString() {
        return super.toString() + "|deleteAllPic";
    }
}
