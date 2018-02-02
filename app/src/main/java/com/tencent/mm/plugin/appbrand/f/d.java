package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$a;
import com.tencent.mm.plugin.fts.d.b.a;
import com.tencent.mm.plugin.fts.d.f;

public final class d extends b {
    public j iVU;
    public i iVV;
    public CharSequence iVW;
    private b iVX = new b(this);
    a iVY = new a(this);

    public d(int i) {
        super(16, i);
    }

    public final void a(Context context, b$a com_tencent_mm_plugin_fts_d_a_b_a, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        this.iVV = i.rD(this.iVU.mLs);
        if (this.iVV != null) {
            switch (this.iVU.mLr) {
                case 2:
                    break;
                case 3:
                    z2 = true;
                    break;
                default:
                    z = false;
                    break;
            }
            this.iVW = f.a(a.a(this.iVV.appName, this.mMb, z, z2)).mQk;
            this.info = this.iVV.fnl;
        }
    }

    public final b.b adp() {
        return this.iVX;
    }

    protected final b$a adq() {
        return this.iVY;
    }

    public final String adr() {
        return this.iVV.appName;
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
