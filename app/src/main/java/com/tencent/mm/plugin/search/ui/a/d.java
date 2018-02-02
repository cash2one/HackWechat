package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.plugin.fts.d.d.b;
import com.tencent.mm.z.r;

public final class d extends c {
    public int count;
    private a qdN = new a(this);
    b qdO = new b(this);
    public String talker;

    public d(int i) {
        super(i);
    }

    public final void a(Context context, a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(r.gu(this.talker), b.mOJ, 500.0f, TruncateAt.MIDDLE);
        this.mPH = context.getString(R.l.eIY, new Object[]{ellipsize});
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adp() {
        return this.qdN;
    }

    protected final a adq() {
        return this.qdO;
    }
}
