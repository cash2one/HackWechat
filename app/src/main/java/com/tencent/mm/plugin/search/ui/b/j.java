package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.search.ui.c.k;

public final class j extends a {
    public final i a(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        return new k(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    public final int getType() {
        return 4160;
    }

    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
