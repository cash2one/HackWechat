package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    private static int gHN = -1;
    private static int gHO = -1;
    private static boolean gHP = false;
    private static int gHQ = -1;
    private static int gHR = -1;

    public static void zk() {
        gHP = false;
    }

    public static final int aN(Context context) {
        if (gHP) {
            return aP(context);
        }
        if (!aR(context)) {
            return ac.cft().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        }
        int i = ac.cft().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(context, bs.CTRL_INDEX));
        gHN = i;
        return i;
    }

    public static final int c(Context context, boolean z) {
        if (gHP) {
            return aP(context);
        }
        if (gHN <= 0 || !z) {
            return aN(context);
        }
        return gHN;
    }

    @TargetApi(11)
    public static final void h(Activity activity) {
        if (activity != null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            gHO = (activity.getResources().getDisplayMetrics().heightPixels - a.f(activity)) - rect.top;
        }
    }

    public static final int zl() {
        return gHO;
    }

    public static final boolean p(Context context, int i) {
        if (gHN == i) {
            return true;
        }
        if (!aR(context)) {
            return false;
        }
        if (i < 0) {
            return false;
        }
        gHN = i;
        x.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[]{Integer.valueOf(i)});
        return ac.cft().edit().putInt("com.tencent.mm.compatible.util.keybord.height", i).commit();
    }

    public static final int aO(Context context) {
        if (gHP) {
            return aP(context);
        }
        if (gHQ > 0) {
            return gHQ;
        }
        if (!aR(context)) {
            return 1140;
        }
        int fromDPToPix = a.fromDPToPix(context, 380);
        gHQ = fromDPToPix;
        return fromDPToPix;
    }

    public static final int aP(Context context) {
        if (gHR > 0) {
            return gHR;
        }
        if (!aR(context)) {
            return gHR * 3;
        }
        int fromDPToPix = a.fromDPToPix(context, bs.CTRL_INDEX);
        gHR = fromDPToPix;
        return fromDPToPix;
    }

    public static final int q(Context context, int i) {
        int aP = aP(context);
        int aO;
        if (aS(context)) {
            if (i <= 0) {
                i = c(context, true);
            }
            aO = aO(context);
            if (i > aO) {
                return aO;
            }
            if (i < aP) {
                return aP;
            }
            return i;
        }
        aO = (int) (((double) aP) / 1.5d);
        aP = aT(context)[0];
        if (aO > aP / 2) {
            return aP / 2;
        }
        return aO;
    }

    public static final int aQ(Context context) {
        return q(context, -1);
    }

    private static final boolean aR(Context context) {
        if (context == null) {
            context = ac.getContext();
        }
        return context != null;
    }

    public static boolean aS(Context context) {
        int[] aT = aT(context);
        return aT[0] < aT[1] ? true : true;
    }

    public static int[] aT(Context context) {
        Context context2;
        if (context == null) {
            context2 = ac.getContext();
        } else {
            context2 = context;
        }
        int[] iArr = new int[2];
        if (context2 instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public static int i(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }
}
