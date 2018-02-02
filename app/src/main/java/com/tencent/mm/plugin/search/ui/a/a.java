package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.f;

public final class a extends b {
    public CharSequence qdE;
    private b qdF = new b(this);
    private a qdG = new a(this);

    public a(int i) {
        super(10, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        this.qdE = f.a(context.getResources().getString(R.l.ekq), "", com.tencent.mm.plugin.fts.d.b.a.d(this.mMb.mLA, this.mMb.mLA)).mQk;
    }

    public final b.b adp() {
        return this.qdF;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adq() {
        return this.qdG;
    }
}
