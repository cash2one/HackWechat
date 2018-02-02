package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

public final class h {
    private static final int saG = a.saG;

    public static String aA(Context context, String str) {
        if (bh.ov(str)) {
            return null;
        }
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO == null) {
            return null;
        }
        if (!s.eV(str)) {
            return r.gu(str);
        }
        if (bh.ov(WO.field_nickname)) {
            return context.getString(R.l.eQP);
        }
        return WO.AP();
    }
}
