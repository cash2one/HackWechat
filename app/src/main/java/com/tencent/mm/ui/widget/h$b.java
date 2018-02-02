package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;

class h$b {
    final /* synthetic */ h ztK;

    h$b(h hVar) {
        this.ztK = hVar;
    }

    public final View f(ViewGroup viewGroup, int i) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = viewGroup.getChildAt(i2);
                Class cls = childAt.getClass();
                x.d("MicroMsg.MMDatePickerDialog", "NAME = " + cls.getName());
                x.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + cls.getSimpleName());
                if ("NumberPicker".equals(cls.getSimpleName()) && i2 == i) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    childAt = f((ViewGroup) childAt, i);
                    if (childAt != null) {
                        return childAt;
                    }
                }
                i2++;
            }
        }
        return null;
    }
}
