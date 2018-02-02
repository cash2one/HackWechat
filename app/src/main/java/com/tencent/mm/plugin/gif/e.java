package com.tencent.mm.plugin.gif;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public final int[] nyI = new int[6];

    public e(String str) {
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.nyI));
            x.i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.nyI[0]), Integer.valueOf(this.nyI[1]));
        } catch (Throwable e) {
            x.e("MMGIFInfo", bh.i(e));
        }
    }
}
