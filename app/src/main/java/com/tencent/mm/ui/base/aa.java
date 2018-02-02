package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mm.bv.a;
import com.tencent.mm.cb.a.i;

public final class aa {
    private static DisplayMetrics yho = null;

    public static a a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7 = 0;
        int i8 = 1;
        a aVar = new a();
        if (yho == null) {
            yho = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = yho;
        int fromDPToPix = a.fromDPToPix(context, 95);
        if (i < fromDPToPix) {
            i = fromDPToPix;
        }
        if (i2 < 0) {
            aVar.kbn = 0;
            aVar.kbo = displayMetrics.widthPixels - ((i5 * 2) + i);
            fromDPToPix = 0;
            i6 = 1;
        } else if (displayMetrics.widthPixels - ((i2 + i) + (i5 * 2)) < 0) {
            aVar.kbn = (i2 - i) - i5;
            aVar.kbo = (displayMetrics.widthPixels - i2) - i5;
            fromDPToPix = 1;
            i6 = 0;
        } else {
            aVar.kbn = i2;
            aVar.kbo = displayMetrics.widthPixels - (i2 + i);
            fromDPToPix = 0;
            i6 = 1;
        }
        if (i3 < 0 || i3 > displayMetrics.heightPixels) {
            i3 = (int) (((float) displayMetrics.heightPixels) / 2.0f);
        }
        if (z) {
            if (i3 >= i4 + i5) {
                aVar.rMP = (i3 - i5) - i4;
            }
            aVar.rMP = i3 - i5;
            i8 = 0;
            i7 = 1;
        } else {
            if (displayMetrics.heightPixels - i3 < (i5 * 3) + i4) {
                aVar.rMP = (i3 - i5) - i4;
            }
            aVar.rMP = i3 - i5;
            i8 = 0;
            i7 = 1;
        }
        if (i8 != 0) {
            aVar.rMP -= i5 * 2;
        } else if (i7 != 0) {
            aVar.rMP += i5 * 2;
        }
        if (i6 == 0 || i7 == 0) {
            if (fromDPToPix != 0 && i7 != 0) {
                aVar.yhp = i.eYS;
                return aVar;
            } else if (i6 != 0 && i8 != 0) {
                aVar.yhp = i.eYQ;
                return aVar;
            } else if (!(fromDPToPix == 0 || i8 == 0)) {
                aVar.yhp = i.zzF;
                return aVar;
            }
        }
        aVar.yhp = i.eYR;
        return aVar;
    }
}
