package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;

public final class e extends h implements c {
    public e(Context context, a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        this.pGa = aVar;
        this.pFF.clear();
        this.pFF.addAll(aVar.pFF);
        notifyDataSetChanged();
    }

    public final void d(b bVar) {
        bVar.bjS = 0;
        bVar.fqm = ((f) this.pGa).fqm;
        bVar.fEG = ((f) this.pGa).fEG;
    }

    public final void a(int i, f fVar) {
        bne();
    }
}
