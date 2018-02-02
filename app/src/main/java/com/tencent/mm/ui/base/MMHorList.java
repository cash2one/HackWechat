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
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList extends AdapterView<ListAdapter> {
    public boolean oNe = false;
    private int offset;
    private Queue<View> ybA = new LinkedList();
    private boolean ybB = false;
    private boolean ybC = false;
    protected Scroller ybD;
    private GestureDetector ybE;
    private OnItemSelectedListener ybF;
    private OnItemClickListener ybG;
    private ListAdapter ybH;
    private Runnable ybI = new 1(this);
    public boolean ybJ = false;
    public boolean ybK = false;
    public int ybL = 0;
    private int ybM = 0;
    private boolean ybN = false;
    private DataSetObserver ybO = new 2(this);
    private OnGestureListener ybP = new 3(this);
    public a ybu;
    private int ybv;
    private int ybw;
    public int ybx;
    private int yby;
    private int ybz = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;

    public interface a {
        void aXw();

        void bFa();

        void bFb();
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.ybH;
    }

    private void init() {
        this.ybD = new Scroller(getContext());
        this.ybv = -1;
        this.ybw = 0;
        this.offset = 0;
        this.ybx = 0;
        this.yby = 0;
        this.ybB = false;
        this.ybz = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
        this.ybE = new GestureDetector(getContext(), this.ybP);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.ybF = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.ybG = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.ybH == null) {
            listAdapter.registerDataSetObserver(this.ybO);
        }
        this.ybH = listAdapter;
        reset();
    }

    private int cpm() {
        return this.ybH.getCount() * this.ybL;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ybH != null) {
            int i5;
            this.ybC = true;
            if (this.ybB) {
                i5 = this.ybx;
                init();
                removeAllViewsInLayout();
                this.yby = i5;
                if (this.ybJ) {
                    this.ybM = Math.max(0, (getWidth() - cpm()) / 2);
                    this.offset = this.ybM;
                }
                this.ybB = false;
            }
            if (this.ybD.computeScrollOffset()) {
                this.yby = this.ybD.getCurrX();
            }
            if (!this.ybK) {
                if (this.yby < 0) {
                    this.yby = 0;
                    this.ybD.forceFinished(true);
                }
                if (this.yby > this.ybz) {
                    this.yby = this.ybz;
                    this.ybD.forceFinished(true);
                }
            } else if (cpm() > getWidth()) {
                if (this.yby < getWidth() * -1) {
                    this.yby = (getWidth() * -1) + 1;
                    this.ybD.forceFinished(true);
                }
                if (this.yby > this.ybz + getWidth()) {
                    this.yby = (this.ybz + getWidth()) - 1;
                    this.ybD.forceFinished(true);
                }
            } else {
                if (this.yby < (getWidth() * -1) + this.ybM) {
                    this.yby = ((getWidth() * -1) + this.ybM) + 1;
                    this.ybD.forceFinished(true);
                }
                if (this.yby > getWidth() - this.ybM) {
                    this.yby = (getWidth() - this.ybM) - 1;
                    this.ybD.forceFinished(true);
                }
            }
            int i6 = this.ybx - this.yby;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i6 <= 0) {
                this.offset += childAt.getMeasuredWidth();
                this.ybA.offer(childAt);
                removeViewInLayout(childAt);
                this.ybv++;
                childAt = getChildAt(0);
                this.ybC = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            while (childAt != null && childAt.getLeft() + i6 >= getWidth()) {
                this.ybA.offer(childAt);
                removeViewInLayout(childAt);
                this.ybw--;
                childAt = getChildAt(getChildCount() - 1);
                this.ybC = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            if (childAt != null) {
                i5 = childAt.getRight();
            } else {
                i5 = 0;
            }
            int i7 = i5;
            while (i7 + i6 < getWidth() && this.ybw < this.ybH.getCount()) {
                childAt = this.ybH.getView(this.ybw, (View) this.ybA.poll(), this);
                I(childAt, -1);
                i5 = childAt.getMeasuredWidth() + i7;
                if (this.ybw == this.ybH.getCount() - 1) {
                    this.ybz = (this.ybx + i5) - getWidth();
                }
                this.ybw++;
                i7 = i5;
            }
            childAt = getChildAt(0);
            if (childAt != null) {
                i5 = childAt.getLeft();
            } else {
                i5 = 0;
            }
            i7 = i5;
            while (i7 + i6 > 0 && this.ybv >= 0) {
                View view = this.ybH.getView(this.ybv, (View) this.ybA.poll(), this);
                I(view, 0);
                i5 = i7 - view.getMeasuredWidth();
                this.ybv--;
                this.offset -= view.getMeasuredWidth();
                i7 = i5;
            }
            if (getChildCount() > 0 && this.ybC) {
                this.offset += i6;
                i7 = this.offset;
                for (i5 = 0; i5 < getChildCount(); i5++) {
                    View childAt2 = getChildAt(i5);
                    int measuredWidth = childAt2.getMeasuredWidth();
                    childAt2.layout(i7, 0, i7 + measuredWidth, childAt2.getMeasuredHeight());
                    i7 += measuredWidth;
                }
            }
            this.ybx = this.yby;
            if (!this.ybD.isFinished()) {
                post(this.ybI);
            } else if (this.ybu != null && this.ybN) {
                this.ybu.aXw();
                this.ybN = false;
            }
        }
    }

    private void I(View view, int i) {
        this.ybC = true;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i) {
    }

    protected void onMeasure(int i, int i2) {
        if (this.ybH != null && this.ybH.getCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ybE.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.oNe = true;
            if (this.ybu != null) {
                this.ybu.bFa();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.ybK) {
                if (cpm() > getWidth()) {
                    if (this.ybx < 0) {
                        this.ybD.forceFinished(true);
                        this.ybD.startScroll(this.ybx, 0, 0 - this.ybx, 0);
                        requestLayout();
                    } else if (this.ybx > this.ybz) {
                        this.ybD.forceFinished(true);
                        this.ybD.startScroll(this.ybx, 0, this.ybz - this.ybx, 0);
                        requestLayout();
                    }
                } else if (this.ybx != this.ybM * -1) {
                    this.ybD.forceFinished(true);
                    this.ybD.startScroll(this.ybx, 0, 0 - this.ybx, 0);
                    requestLayout();
                }
            }
            this.oNe = false;
            if (this.ybu != null) {
                this.ybu.bFb();
            }
        }
        return onTouchEvent;
    }

    protected final boolean coL() {
        this.ybD.forceFinished(true);
        return true;
    }

    public final void EN(int i) {
        this.ybD.forceFinished(true);
        this.ybD.startScroll(this.ybx, 0, i - this.ybx, 0);
        this.ybN = true;
        requestLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    protected final boolean aD(float f) {
        this.ybD.fling(this.yby, 0, (int) (-f), 0, 0, this.ybz, 0, 0);
        requestLayout();
        return true;
    }

    private void reset() {
        init();
        removeAllViewsInLayout();
        requestLayout();
    }
}
