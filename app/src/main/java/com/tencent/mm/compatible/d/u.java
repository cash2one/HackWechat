package com.tencent.mm.compatible.d;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class u {
    public static boolean gGu = false;
    public String gGv = "";
    Map<String, String> gGw = null;
    public int gGx = 0;

    public final void fK(int i) {
        this.gGx = i;
        gGu = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        x.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.gGx));
    }

    public static boolean yU() {
        if (!gGu) {
            return false;
        }
        gGu = false;
        return true;
    }

    public final void eJ(String str) {
        this.gGv = str;
    }

    public final void i(Map<String, String> map) {
        this.gGw = map;
    }
}
