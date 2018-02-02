package com.tencent.mm.z;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;

public class bh {
    private static bh hhq;
    private final SharedPreferences gZO = ac.getContext().getSharedPreferences(ac.cfs(), 0);

    private bh() {
    }

    public static bh HO() {
        synchronized (bh.class) {
            if (hhq == null) {
                hhq = new bh();
            }
        }
        return hhq;
    }

    public final int HP() {
        return this.gZO.getInt("MicroMsg.RegStyleStoragenew_flow", 1);
    }
}
