package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;

public final class k {
    public static final String TO() {
        return g.Dj().gQi + "draft/";
    }

    public static final String nk(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return TO() + str;
    }

    public static final String nl(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return TO() + str + ".thumb";
    }
}
