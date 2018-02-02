package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public v2protocal nEG = new v2protocal(this.nEH);
    private af nEH = new 1(this, Looper.getMainLooper());
    public boolean nEI = false;
    public boolean nEJ = false;
    public a sxE = null;

    public interface a {
        void aSV();

        void bJi();
    }

    public static int ML(String str) {
        String[] split = str.split("\\.");
        return bh.getInt(split[3], 0) + (((bh.getInt(split[0], 0) << 24) + (bh.getInt(split[1], 0) << 16)) + (bh.getInt(split[2], 0) << 8));
    }
}
