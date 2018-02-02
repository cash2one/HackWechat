package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;

public final class e extends a {
    public static final int CTRL_INDEX = 217;
    public static final String NAME = "saveImageToPhotosAlbum";

    final boolean l(Context context, String str, String str2) {
        if (bh.ov(str)) {
            return false;
        }
        String Sd = s.Sd(str2);
        if (bh.ov(Sd)) {
            Sd = "jpg";
        }
        String on = d.on(Sd);
        boolean q = k.q(str, on, false);
        if (!q) {
            return q;
        }
        d.b(on, context);
        ag.y(new 1(this, context));
        return q;
    }

    final boolean su(String str) {
        return bh.ou(str).toLowerCase().contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
    }
}
