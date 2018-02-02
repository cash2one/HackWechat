package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.w.a.m;
import java.util.LinkedList;

public class FlowLayout extends ViewGroup {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlowLayout.class.desiredAssertionStatus());
    private int xXL = 0;
    private int xXM = 0;
    public LinkedList<Integer> xXN = new LinkedList();

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faf);
        try {
            this.xXL = obtainStyledAttributes.getDimensionPixelSize(m.gYX, 0);
            this.xXM = obtainStyledAttributes.getDimensionPixelSize(m.gYY, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int Eo(int i) {
        int max = Math.max(0, Math.min(this.xXN.size(), i));
        int paddingTop = getPaddingTop();
        for (int i2 = 0; i2 < max - 1; i2++) {
            paddingTop += ((Integer) this.xXN.get(i2)).intValue() + this.xXM;
        }
        return (((Integer) this.xXN.get(max - 1)).intValue() + paddingTop) + getPaddingBottom();
    }

    protected void onMeasure(int i, int i2) {
        if ($assertionsDisabled || MeasureSpec.getMode(i) != 0) {
            int makeMeasureSpec;
            int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            this.xXN.clear();
            if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            }
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (i5 + measuredWidth > size) {
                        i4 += this.xXM + i3;
                        this.xXN.add(Integer.valueOf(i3));
                        i3 = 0;
                        i5 = 0;
                    }
                    i3 = Math.max(i3, childAt.getMeasuredHeight());
                    i5 += this.xXL + measuredWidth;
                }
            }
            this.xXN.add(Integer.valueOf(i3));
            makeMeasureSpec = MeasureSpec.getMode(i2) == 0 ? ((i4 + i3) + getPaddingTop()) + getPaddingBottom() : (MeasureSpec.getMode(i2) != Integer.MIN_VALUE || i4 + i3 >= size2) ? size2 : ((i4 + i3) + getPaddingTop()) + getPaddingBottom();
            setMeasuredDimension(MeasureSpec.getSize(i), makeMeasureSpec);
            return;
        }
        throw new AssertionError();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int i7 = paddingLeft;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if ((i7 + measuredWidth) + getPaddingRight() > i5) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += ((Integer) this.xXN.get(i6)).intValue() + this.xXM;
                    i6++;
                } else {
                    paddingLeft = i7;
                }
                i7 = (((Integer) this.xXN.get(i6)).intValue() - measuredHeight) / 2;
                childAt.layout(paddingLeft, paddingTop + i7, paddingLeft + measuredWidth, (i7 + paddingTop) + measuredHeight);
                i7 = (this.xXL + measuredWidth) + paddingLeft;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new LayoutParams(layoutParams.width, layoutParams.height);
    }
}
