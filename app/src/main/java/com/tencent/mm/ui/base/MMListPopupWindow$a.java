package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.cb.a.a;

class MMListPopupWindow$a extends ListView {
    private boolean Th;
    private boolean Ti;

    public MMListPopupWindow$a(Context context, boolean z) {
        super(context, null, a.dropDownListViewStyle);
        this.Ti = z;
        setCacheColorHint(0);
    }

    public final boolean isInTouchMode() {
        return (this.Ti && this.Th) || super.isInTouchMode();
    }

    public final boolean hasWindowFocus() {
        return this.Ti || super.hasWindowFocus();
    }

    public final boolean isFocused() {
        return this.Ti || super.isFocused();
    }

    public final boolean hasFocus() {
        return this.Ti || super.hasFocus();
    }

    final int P(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i4);
            if (listPaddingTop != i3) {
                i3 = listPaddingTop;
                view2 = null;
            } else {
                view2 = view;
            }
            view = adapter.getView(i4, view2, this);
            listPaddingTop = view.getLayoutParams().height;
            if (listPaddingTop > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            if (i4 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
            if (listPaddingBottom >= i2) {
                return i2;
            }
        }
        return listPaddingBottom;
    }
}
