package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$a;
import com.tencent.mm.plugin.fts.d.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;

public final class j extends b {
    public com.tencent.mm.plugin.fts.a.a.j iVU;
    public String jiK;
    public String moS;
    public f nlG;
    public CharSequence qeu;
    public String qev;
    private b qew = new b(this);
    a qex = new a(this);

    public j(int i) {
        super(5, i);
    }

    public final void a(Context context, b$a com_tencent_mm_plugin_fts_d_a_b_a, Object... objArr) {
        this.nlG = an.bin().RF(this.iVU.mLs);
        this.qeu = com.tencent.mm.plugin.fts.d.f.a(a.a(this.nlG.field_appName, this.mMb)).mQk;
        this.qev = this.nlG.fQH;
        an.bin();
        this.moS = i.cR(this.nlG.field_appId, 1);
        this.jiK = this.nlG.field_appIconUrl;
    }

    public final b.b adp() {
        return this.qew;
    }

    protected final b$a adq() {
        return this.qex;
    }

    public final String adr() {
        return this.nlG.field_appName;
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
