package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.c.j;

public final class i extends a {
    public final com.tencent.mm.plugin.fts.d.i a(Context context, b bVar, int i) {
        return new j(context, bVar, i);
    }

    public final int getType() {
        return 80;
    }

    public final int getPriority() {
        return 80;
    }
}
