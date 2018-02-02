package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter FP;
    public a vrO;
    public boolean xXT = true;
    private int xXU = -1;
    private int xXV = 0;
    protected int xXW;
    protected int xXX;
    private int xXY = Integer.MAX_VALUE;
    private int xXZ = 0;
    private GestureDetector xYa;
    private Queue<View> xYb = new LinkedList();
    private OnItemSelectedListener xYc;
    private OnItemClickListener xYd;
    private boolean xYe = false;
    private DataSetObserver xYf = new 1(this);
    private OnGestureListener xYg = new 3(this);
    protected Scroller yJ;

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.FP;
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private synchronized void initView() {
        this.xXU = -1;
        this.xXV = 0;
        this.xXZ = 0;
        this.xXW = 0;
        this.xXX = 0;
        this.xXY = Integer.MAX_VALUE;
        this.yJ = new Scroller(getContext());
        this.xYa = new GestureDetector(getContext(), this.xYg);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.xYc = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.xYd = onItemClickListener;
    }

    public View getSelectedView() {
        return null;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.xYf);
        }
        this.FP = listAdapter;
        this.FP.registerDataSetObserver(this.xYf);
        reset();
    }

    private synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
    }

    private void I(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        synchronized (this) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.FP != null) {
                int i6;
                if (this.xYe) {
                    i6 = this.xXW;
                    initView();
                    removeAllViewsInLayout();
                    this.xXX = i6;
                    this.xYe = false;
                }
                if (this.yJ.computeScrollOffset()) {
                    this.xXX = this.yJ.getCurrX();
                }
                if (this.xXX <= 0) {
                    this.xXX = 0;
                    this.yJ.forceFinished(true);
                }
                if (this.xXX >= this.xXY) {
                    this.xXX = this.xXY;
                    this.yJ.forceFinished(true);
                }
                int i7 = this.xXW - this.xXX;
                View childAt = getChildAt(0);
                while (childAt != null && childAt.getRight() + i7 <= 0) {
                    this.xXZ += childAt.getMeasuredWidth();
                    this.xYb.offer(childAt);
                    removeViewInLayout(childAt);
                    this.xXU++;
                    childAt = getChildAt(0);
                }
                while (true) {
                    childAt = getChildAt(getChildCount() - 1);
                    if (childAt == null || childAt.getLeft() + i7 < getWidth()) {
                        break;
                    }
                    this.xYb.offer(childAt);
                    removeViewInLayout(childAt);
                    this.xXV--;
                }
                childAt = getChildAt(getChildCount() - 1);
                if (childAt != null) {
                    i6 = childAt.getRight();
                } else {
                    i6 = 0;
                }
                int i8 = i6;
                while (i8 + i7 < getWidth() && this.xXV < this.FP.getCount()) {
                    childAt = this.FP.getView(this.xXV, (View) this.xYb.poll(), this);
                    I(childAt, -1);
                    i6 = childAt.getMeasuredWidth() + i8;
                    if (this.xXV == this.FP.getCount() - 1) {
                        this.xXY = (this.xXW + i6) - getWidth();
                    }
                    if (this.xXY < 0) {
                        this.xXY = 0;
                    }
                    this.xXV++;
                    i8 = i6;
                }
                childAt = getChildAt(0);
                if (childAt != null) {
                    i6 = childAt.getLeft();
                } else {
                    i6 = 0;
                }
                i8 = i6;
                while (i8 + i7 > 0 && this.xXU >= 0) {
                    View view = this.FP.getView(this.xXU, (View) this.xYb.poll(), this);
                    I(view, 0);
                    i6 = i8 - view.getMeasuredWidth();
                    this.xXU--;
                    this.xXZ -= view.getMeasuredWidth();
                    i8 = i6;
                }
                if (getChildCount() > 0) {
                    this.xXZ += i7;
                    i6 = this.xXZ;
                    while (i5 < getChildCount()) {
                        View childAt2 = getChildAt(i5);
                        i7 = childAt2.getMeasuredWidth();
                        childAt2.layout(i6, 0, i6 + i7, childAt2.getMeasuredHeight());
                        i6 += i7;
                        i5++;
                    }
                }
                this.xXW = this.xXX;
                if (!this.yJ.isFinished()) {
                    post(new 2(this));
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.vrO != null) {
            this.vrO.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent) | this.xYa.onTouchEvent(motionEvent);
    }

    protected final boolean aD(float f) {
        synchronized (this) {
            this.yJ.fling(this.xXX, 0, (int) (-f), 0, 0, this.xXY, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected final boolean coL() {
        this.yJ.forceFinished(true);
        return true;
    }
}
