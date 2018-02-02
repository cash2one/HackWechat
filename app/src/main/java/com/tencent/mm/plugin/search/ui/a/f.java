package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.r;

public final class f extends k {
    private a qec = new a(this);
    CharSequence qed;

    public f(int i) {
        super(i);
    }

    public final b adp() {
        return this.qec;
    }

    public final void a(Context context, a aVar, Object... objArr) {
        super.a(context, aVar, objArr);
        CharSequence gu = r.gu(this.iVU.talker);
        if (bh.ov(gu)) {
            gu = r.gu(this.iVU.mLs);
        }
        this.qed = i.d(context, gu, (float) d.b.mOI);
    }
}
