package com.tencent.mm.plugin.aj.a;

import com.tencent.mm.loader.stub.a;
import java.io.File;

public final class k {
    String tkA;
    private int tkw = 1;
    private long tkx;
    private String tky;
    String tkz;

    public k(String str, String str2, String str3) {
        this.tky = str;
        this.tkz = str2;
        this.tkA = str3;
    }

    public final int Nj() {
        if (this.tkw <= 1 || bOY().lastModified() > this.tkx) {
            bOX();
        }
        return this.tkw;
    }

    public final int bOX() {
        this.tkw = Integer.valueOf(g.o(bOY()).getProperty("version", "1")).intValue();
        this.tkx = System.currentTimeMillis();
        return this.tkw;
    }

    private File bOY() {
        return new File(Rh(), "config.conf");
    }

    public final String Rh() {
        File file = new File(a.gZL.replace("/data/user/0", "/data/data"), this.tky);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public final String bOZ() {
        return new File(Rh(), this.tkz).getAbsolutePath();
    }
}
