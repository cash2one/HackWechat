package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;

public final class f extends a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    final boolean l(Context context, String str, String str2) {
        String on = d.on("mp4");
        if (!k.fp(str, on)) {
            on = null;
        }
        if (bh.ov(on)) {
            return false;
        }
        Toast.makeText(context, c.getMMString(j.eTe, new Object[]{on}), 1).show();
        com.tencent.mm.pluginsdk.ui.tools.k.b(on, context);
        return true;
    }

    final boolean su(String str) {
        return bh.ou(str).toLowerCase().contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
    }
}
