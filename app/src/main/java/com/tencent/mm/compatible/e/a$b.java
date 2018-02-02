package com.tencent.mm.compatible.e;

import android.util.SparseArray;
import java.util.Locale;

class a$b {
    public int gHb;
    public SparseArray<String> gHc;
    public String gHd;
    public String model;
    public String version;

    private a$b() {
    }

    public final String toString() {
        return String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.gHd, this.model, this.version, this.gHc, Integer.valueOf(this.gHb)});
    }
}
