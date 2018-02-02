package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public final class a {
    public volatile boolean kpn = false;
    public SoundPool nYQ = new SoundPool(2, 3, 0);
    Hashtable<String, Integer> nYR = new Hashtable();
    Map<Integer, Boolean> nYS = new HashMap();

    public final void ew(String str) {
        if (this.nYR.containsKey(str)) {
            int intValue = ((Integer) this.nYR.get(str)).intValue();
            if (intValue >= 0 && this.nYS.containsKey(Integer.valueOf(intValue)) && ((Boolean) this.nYS.get(Integer.valueOf(intValue))).booleanValue()) {
                this.nYQ.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }
}
