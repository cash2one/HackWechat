package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g {
    public String gOs;
    public a gQb = new a();
    public Application gSI;
    private Boolean gSJ;

    public abstract String getPackageName();

    public g(String str, Application application) {
        this.gOs = str;
        this.gSI = application;
    }

    public String toString() {
        return this.gOs != null ? this.gOs : super.toString();
    }

    public final boolean DS() {
        if (this.gSJ == null) {
            this.gSJ = Boolean.valueOf(fR(""));
        }
        return this.gSJ.booleanValue();
    }

    public final boolean fR(String str) {
        return this.gOs != null && this.gOs.equals(getPackageName() + str);
    }
}
