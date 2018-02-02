package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.fts.d.j.b;
import com.tencent.mm.sdk.platformtools.ac;

public class f$a {
    public static int mON;

    static {
        mON = 0;
        Context context = ac.getContext();
        mON = ((a.eA(context) - (a.aa(context, b.mOZ) * 2)) - a.aa(context, b.bvD)) - a.aa(context, b.mOZ);
    }
}
