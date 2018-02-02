package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.j$g;
import com.tencent.mm.sdk.platformtools.x;

public class e extends b {
    public String mPR;
    private b mPS = new b(this);
    private a mPT = new a(this);

    public e(int i) {
        super(12, i);
    }

    public final void a(Context context, a aVar, Object... objArr) {
        if (com.tencent.mm.plugin.fts.d.e.qg(this.mPx) == null) {
            this.mPR = "";
        } else {
            this.mPR = context.getResources().getString(j$g.mPl, new Object[]{r0});
        }
        x.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[]{this.mPR});
    }

    public b$b adp() {
        return this.mPS;
    }

    public a adq() {
        return this.mPT;
    }
}
