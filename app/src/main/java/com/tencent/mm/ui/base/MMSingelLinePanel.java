package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.m;
import java.util.LinkedList;

public class MMSingelLinePanel extends MMTagPanel {
    static final /* synthetic */ boolean $assertionsDisabled = (!MMSingelLinePanel.class.desiredAssertionStatus());
    private int xXL;
    private int xXM;
    private LinkedList<Integer> xXN;
    private boolean ydi;
    private TextView ydj;
    private int ydk;
    private int ydl;

    public MMSingelLinePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xXN = new LinkedList();
        this.xXL = 0;
        this.xXM = 0;
        this.ydi = true;
        this.ydk = 0;
        this.ydl = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faf);
        try {
            this.xXL = obtainStyledAttributes.getDimensionPixelSize(m.gYX, 0);
            this.xXM = obtainStyledAttributes.getDimensionPixelSize(m.gYY, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void cpv() {
        super.cpv();
        this.ydj = new TextView(getContext());
        this.ydj.setText("...");
        this.ydj.setTextColor(getResources().getColor(d.bui));
        this.ydj.setLayoutParams(generateDefaultLayoutParams());
        addView(this.ydj);
    }

    public final void cpw() {
        this.ydi = true;
        this.ydj = new TextView(getContext());
        this.ydj.setText("...");
        this.ydj.setLayoutParams(generateDefaultLayoutParams());
        addView(this.ydj);
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
            if (this.ydi && this.ydj != null) {
                this.ydj.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                this.ydk = this.ydj.getMeasuredWidth();
                this.ydl = this.ydj.getMeasuredHeight();
                x.d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", Integer.valueOf(this.ydk));
            }
            if (this.ydi) {
                size -= this.ydk;
            }
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < childCount) {
                int i8;
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i3 = childAt.getMeasuredHeight();
                    if (i6 + measuredWidth > size) {
                        i6 = 0;
                        i5 += this.xXM + i4;
                        this.xXN.add(Integer.valueOf(i4));
                        i4 = 0;
                    }
                    i8 = i3;
                    i3 = i6 + (this.xXL + measuredWidth);
                    i6 = i5;
                    i5 = Math.max(i4, childAt.getMeasuredHeight());
                    i4 = i8;
                } else {
                    i8 = i3;
                    i3 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i8;
                }
                i7++;
                i8 = i4;
                i4 = i5;
                i5 = i6;
                i6 = i3;
                i3 = i8;
            }
            this.xXN.add(Integer.valueOf(i4));
            if (this.ydi) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == 0) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE && i5 + i4 < size2) {
                getPaddingTop();
                getPaddingBottom();
            }
            setMeasuredDimension(MeasureSpec.getSize(i), i3);
            return;
        }
        throw new AssertionError();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.ydi) {
            int childCount = getChildCount();
            i5 = (i3 - i) - this.ydk;
            int paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = paddingLeft;
            while (i9 < childCount) {
                int i11;
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() == 8 || childAt == this.ydj) {
                    i11 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = paddingTop;
                    paddingTop = i10;
                    i10 = i11;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if ((i10 + measuredWidth) + getPaddingRight() > i5) {
                        i10 = i8 + 1;
                        i8 = paddingTop + (((Integer) this.xXN.get(i8)).intValue() + this.xXM);
                        paddingTop = getPaddingLeft();
                    } else {
                        i11 = i8;
                        i8 = paddingTop;
                        paddingTop = i10;
                        i10 = i11;
                    }
                    if (i10 <= 0) {
                        childAt.layout(paddingTop, i8 + 0, paddingTop + measuredWidth, (i8 + 0) + measuredHeight);
                        i7 = (this.xXL + measuredWidth) + paddingTop;
                        i6 = i8;
                        paddingTop = i7;
                    } else {
                        i11 = i7;
                        i7 = i6;
                        i6 = i8;
                        i8 = i11;
                    }
                }
                i9++;
                i11 = i10;
                i10 = paddingTop;
                paddingTop = i6;
                i6 = i7;
                i7 = i8;
                i8 = i11;
            }
            if (this.ydj == null) {
                return;
            }
            if (i8 > 0) {
                this.ydj.layout(i6, i7, this.ydk + i6, this.ydl + i7);
                return;
            } else {
                this.ydj.layout(0, 0, 0, 0);
                return;
            }
        }
        paddingLeft = getChildCount();
        i9 = i3 - i;
        i6 = getPaddingLeft();
        i7 = getPaddingTop();
        i8 = 0;
        i10 = i6;
        for (paddingTop = 0; paddingTop < paddingLeft; paddingTop++) {
            View childAt2 = getChildAt(paddingTop);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.ydj)) {
                i5 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                if ((i10 + i5) + getPaddingRight() > i9) {
                    i6 = getPaddingLeft();
                    i7 += ((Integer) this.xXN.get(i8)).intValue() + this.xXM;
                    i8++;
                } else {
                    i6 = i10;
                }
                i10 = (((Integer) this.xXN.get(i8)).intValue() - measuredHeight2) / 2;
                childAt2.layout(i6, i7 + i10, i6 + i5, (i10 + i7) + measuredHeight2);
                i10 = (this.xXL + i5) + i6;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
