package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;

public final class g extends a {
    public final i a(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        return new h(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    public final int getType() {
        return e.CTRL_INDEX;
    }

    public final int getPriority() {
        return 89;
    }
}
