package com.tencent.mm.am;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public static String s(Context context, int i) {
        int i2 = i / 1000;
        if (i2 <= 0) {
            return context.getString(R.l.egU, new Object[]{Integer.valueOf(0)});
        }
        int i3 = i2 / 60;
        i2 %= 60;
        if (i3 == 0) {
            return context.getString(R.l.egU, new Object[]{Integer.valueOf(i2)});
        }
        return context.getString(R.l.egT, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    public static boolean kO(String str) {
        if (bh.ov(str) || str.equals(ac.getContext().getResources().getString(R.l.eth))) {
            return false;
        }
        return true;
    }

    public static String t(Context context, int i) {
        return "[" + context.getResources().getString(i) + "]";
    }
}
