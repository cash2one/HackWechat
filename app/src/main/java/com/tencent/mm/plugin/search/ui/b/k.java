package com.tencent.mm.plugin.search.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.search.ui.c.l;

public final class k extends a {
    public final i a(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        return new l(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }

    public final int getPriority() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }
}
