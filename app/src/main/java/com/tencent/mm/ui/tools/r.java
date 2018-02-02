package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mm.bv.a;
import com.tencent.mm.w.a.d;
import junit.framework.Assert;

public final class r {
    private static r znm = null;
    private ColorStateList[] ynr = new ColorStateList[2];
    private boolean znn = false;

    private r(Context context) {
        this.ynr[0] = a.Z(context, d.gUz);
        this.ynr[1] = a.Z(context, d.gUA);
    }

    private static r ga(Context context) {
        Assert.assertTrue(context != null);
        if (znm == null || !znm.znn) {
            znm = new r(context);
        }
        return znm;
    }

    public static ColorStateList gb(Context context) {
        return ga(context).ynr[0];
    }

    public static ColorStateList gc(Context context) {
        return ga(context).ynr[1];
    }
}
