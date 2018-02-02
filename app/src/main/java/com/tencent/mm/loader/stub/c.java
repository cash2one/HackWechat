package com.tencent.mm.loader.stub;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;

public class c {
    public static c gZN = new c(null);
    public final SharedPreferences gZO;

    public c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.gZO = ac.getContext().getSharedPreferences(ac.cfs(), 0);
        } else {
            this.gZO = sharedPreferences;
        }
    }

    public final String H(String str, String str2) {
        return this.gZO.getString(str, str2);
    }
}
