package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;

public class EnterpriseFullHeightListView extends ListView {
    private int kVD = 0;
    public boolean yZk = true;
    private View yZl;

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.yZk) {
            if (!this.yZk) {
                int i5;
                int headerViewsCount = getHeaderViewsCount();
                int count = getAdapter().getCount();
                int i6;
                if (this.yZl != null) {
                    i6 = count - 1;
                    count = 0;
                    i5 = headerViewsCount;
                    headerViewsCount = i6;
                } else {
                    i6 = count;
                    count = 0;
                    i5 = headerViewsCount;
                    headerViewsCount = i6;
                }
                while (i5 < headerViewsCount) {
                    if (this.kVD <= 0) {
                        try {
                            View view = getAdapter().getView(i5, null, this);
                            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                            this.kVD = view.getMeasuredHeight();
                        } catch (Exception e) {
                        }
                    }
                    try {
                        count += this.kVD;
                        if (count <= i2) {
                            i5++;
                        } else if (this.yZl != null) {
                            removeFooterView(this.yZl);
                            this.yZl = null;
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e2) {
                        return;
                    }
                }
                if (count < i2) {
                    if (this.yZl == null) {
                        this.yZl = new View(getContext());
                    }
                    removeFooterView(this.yZl);
                    this.yZl.setLayoutParams(new LayoutParams(-1, i2 - count));
                    addFooterView(this.yZl, null, false);
                }
            }
        }
    }
}
