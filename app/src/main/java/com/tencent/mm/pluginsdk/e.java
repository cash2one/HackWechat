package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.w.a.c;

public final class e {
    public static int ea(Context context) {
        int i = 0;
        if (context instanceof MMActivity) {
            i = ((MMActivity) context).mController.getTitleLocation();
        }
        if (i <= 0) {
            return context.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buG);
        }
        return i;
    }

    public static void O(Activity activity) {
        if (VERSION.SDK_INT < 16) {
            return;
        }
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).supportRequestWindowFeature(109);
        } else {
            activity.requestWindowFeature(9);
        }
    }

    public static void h(MMActivity mMActivity) {
        if (VERSION.SDK_INT >= 16) {
            mMActivity.supportRequestWindowFeature(109);
        }
    }

    public static void i(MMActivity mMActivity) {
        if (VERSION.SDK_INT >= 16) {
            mMActivity.getWindow().getDecorView().post(new 1(mMActivity));
        }
    }

    public static void a(MMFragmentActivity mMFragmentActivity, View view) {
        if (mMFragmentActivity != null && VERSION.SDK_INT >= 16 && mMFragmentActivity.getWindow() != null && mMFragmentActivity.getWindow().getDecorView() != null) {
            mMFragmentActivity.getWindow().getDecorView().post(new 2(mMFragmentActivity, view));
        }
    }

    public static int ci(Context context) {
        int i = 0;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(c.actionBarSize, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i > 0) {
            return i;
        }
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buF);
        }
        return context.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buG);
    }

    public static int eb(Context context) {
        int ai = u.ai(context, -1);
        Rect rect;
        if (ai > 0) {
            rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top > ai ? 0 : ai;
        } else if (!(context instanceof Activity)) {
            return a.fromDPToPix(context, 20);
        } else {
            rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            ai = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (ai - rect.height() < 0 || iArr[1] <= 200) {
                return rect.top;
            }
            return ai - rect.height();
        }
    }
}
