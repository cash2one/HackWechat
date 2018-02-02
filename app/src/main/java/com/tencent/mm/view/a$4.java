package com.tencent.mm.view;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.bj.a.c;
import com.tencent.mm.compatible.util.j;

class a$4 implements Runnable {
    final /* synthetic */ a zDj;

    a$4(a aVar) {
        this.zDj = aVar;
    }

    public final void run() {
        int c;
        Rect rect = new Rect();
        this.zDj.getWindowVisibleDisplayFrame(rect);
        boolean z = this.zDj.getBottom() - rect.bottom >= 300;
        DisplayMetrics displayMetrics = this.zDj.getResources().getDisplayMetrics();
        if (z) {
            c = (displayMetrics.heightPixels - j.c(this.zDj.getContext(), false)) - ((int) this.zDj.getResources().getDimension(c.vaZ));
        } else {
            c = displayMetrics.heightPixels - ((int) this.zDj.getResources().getDimension(c.vaZ));
        }
        if (a.b(this.zDj).getHeight() != c) {
            a.b(this.zDj).setHeight(c);
        }
        this.zDj.getViewTreeObserver().removeOnGlobalLayoutListener(this.zDj);
        this.zDj.getViewTreeObserver().addOnGlobalLayoutListener(this.zDj);
    }
}
