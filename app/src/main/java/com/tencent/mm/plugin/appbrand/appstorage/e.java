package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.regex.Pattern;

public class e implements l {
    public final String iHK;
    private final b iHL = new 1(this);
    private final b iHM = new 4(this);
    private final b iHN = new 5(this);
    private final b iHO = new 6(this);
    private final a iHP = new 7(this);
    private final a iHQ = new 8(this);
    private final a iHR = new 9(this);
    private final b iHS = new b(this) {
        final /* synthetic */ e iHW;

        {
            this.iHW = r2;
        }

        public final j r(File file) {
            if (file.isDirectory()) {
                return j.iIC;
            }
            if (!file.exists()) {
                return j.iIz;
            }
            int unlink = FileUnlink.unlink(file.getPath());
            if (unlink != 0) {
                x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "unlink err %d, %s", new Object[]{Integer.valueOf(unlink), file.getPath()});
            }
            return unlink == 0 ? j.iIt : j.iIu;
        }
    };
    private final a iHT = new a(this) {
        final /* synthetic */ e iHW;

        {
            this.iHW = r1;
        }

        public final j a(File file, Object... objArr) {
            if (!file.exists()) {
                return j.iIz;
            }
            int stat = FileStat.stat(file.getPath(), (FileStructStat) objArr[0]);
            if (stat != 0) {
                x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "stat err %d, %s", new Object[]{Integer.valueOf(stat), file.getPath()});
            }
            return stat == 0 ? j.iIt : j.iIu;
        }
    };
    private final a iHU = new a(this) {
        final /* synthetic */ e iHW;

        {
            this.iHW = r1;
        }

        public final j a(File file, Object... objArr) {
            File file2 = (File) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (file.isDirectory()) {
                return j.iIy;
            }
            if (k.u(file)) {
                return j.iID;
            }
            return booleanValue ? i.aP(file2.getAbsolutePath(), file.getAbsolutePath()) ? j.iIt : j.iIu : k.q(file2.getAbsolutePath(), file.getAbsolutePath(), false) ? j.iIt : j.iIu;
        }
    };
    private final a iHV = new 3(this);

    public e(String... strArr) {
        this.iHK = m.h(strArr);
    }

    public final boolean bE(String str) {
        return bh.ou(str).startsWith("wxfile://usr");
    }

    public final void initialize() {
    }

    public final void release() {
    }

    private File aaA() {
        if ("[INVALID]".equals(this.iHK)) {
            return null;
        }
        File file = new File(this.iHK);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.mkdirs();
        try {
            new File(file.getPath() + "/.nomedia").createNewFile();
            return file;
        } catch (Exception e) {
            return file;
        }
    }

    private j a(String str, a aVar, Object... objArr) {
        if (bh.ov(str)) {
            return j.iIx;
        }
        String px = a.px(str.replaceFirst(Pattern.quote("wxfile://usr"), ""));
        File aaA = aaA();
        if (aaA == null) {
            return j.iIv;
        }
        px = org.a.a.a.a.gl(aaA.getAbsolutePath(), px);
        if (bh.ov(px)) {
            return j.iIx;
        }
        aaA = new File(px);
        if (!m.c(aaA(), aaA)) {
            return j.iIx;
        }
        if (aaA.getParentFile().exists()) {
            return aVar.a(aaA, objArr);
        }
        return j.iIw;
    }

    public final j pP(String str) {
        return a(str, this.iHL, new Object[0]);
    }

    public final j pU(String str) {
        return a(str, this.iHM, new Object[0]);
    }

    public final j pV(String str) {
        return a(str, this.iHN, new Object[0]);
    }

    public final j pW(String str) {
        return a(str, this.iHO, new Object[0]);
    }

    public final j b(String str, h<List<h>> hVar) {
        return a(str, this.iHP, hVar);
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        return a(str, this.iHQ, hVar);
    }

    public final j d(String str, InputStream inputStream) {
        if (inputStream == null) {
            return j.iIu;
        }
        return a(str, this.iHR, inputStream);
    }

    public final j pX(String str) {
        return a(str, this.iHS, new Object[0]);
    }

    public final j a(String str, FileStructStat fileStructStat) {
        return a(str, this.iHT, fileStructStat);
    }

    public final j a(String str, File file, boolean z) {
        return a(str, this.iHU, file, Boolean.valueOf(z));
    }

    public final File pQ(String str) {
        h hVar = new h();
        a(str, this.iHV, hVar);
        return (File) hVar.jRK;
    }
}
