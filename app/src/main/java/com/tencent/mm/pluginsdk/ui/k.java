package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;

public final class k {
    public static boolean eo(Context context) {
        if (!ae.Vc("network_doctor_shown")) {
            return false;
        }
        h.a(context, R.l.exL, R.l.dGO, new 1(context), null);
        return true;
    }
}
