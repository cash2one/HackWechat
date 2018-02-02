package com.tencent.mm.plugin.appbrand.l;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c {
    b jIZ;
    public com.tencent.mm.sdk.b.c jJa;
    public com.tencent.mm.sdk.b.c jJb;
    public com.tencent.mm.sdk.b.c jJc;

    private c() {
        this.jJc = new 3(this);
        this.jIZ = new b();
        this.jJa = new 1(this);
        this.jJb = new 2(this);
    }

    public final void prepare() {
        a.xef.b(this.jJa);
        a.xef.b(this.jJb);
        this.jJc.ceO();
        refresh();
        File file = new File(this.jIZ.iHK);
        x.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", new Object[]{Integer.valueOf(this.jIZ.aIt), Integer.valueOf(65900180)});
        if (this.jIZ.aIt < 65900180 && c(file, "wxa_fts_template.zip")) {
            refresh();
        }
    }

    void refresh() {
        this.jIZ.aIt = ((f) g.h(f.class)).Ri();
        this.jIZ.iHK = ((f) g.h(f.class)).Rh();
    }

    private static boolean c(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        boolean aU = ((f) g.h(f.class)).aU(absolutePath, str);
        if (aU) {
            if (bh.ft(absolutePath, file3.getParent()) < 0) {
                x.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", new Object[]{Integer.valueOf(bh.ft(absolutePath, file3.getParent())), absolutePath, file3.getParent()});
                return false;
            }
            x.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", new Object[]{file3.getAbsolutePath()});
            return aU;
        }
        x.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", new Object[]{file3.getAbsolutePath()});
        return aU;
    }

    static boolean d(File file, File file2) {
        e.g(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (bh.ft(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            x.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", new Object[]{Integer.valueOf(bh.ft(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath()});
            return false;
        }
        x.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", new Object[]{file2.getAbsolutePath()});
        return true;
    }
}
