package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

class h$a {
    final /* synthetic */ h ztK;

    h$a(h hVar) {
        this.ztK = hVar;
    }

    @TargetApi(11)
    public final NumberPicker n(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                NumberPicker numberPicker;
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof NumberPicker) {
                    numberPicker = (NumberPicker) childAt;
                    if (numberPicker.getMaxValue() >= 28 && numberPicker.getMaxValue() <= 31) {
                        return numberPicker;
                    }
                }
                if (childAt instanceof ViewGroup) {
                    numberPicker = n((ViewGroup) childAt);
                    if (numberPicker != null) {
                        return numberPicker;
                    }
                }
            }
        }
        return null;
    }
}
