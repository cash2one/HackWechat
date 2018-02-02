package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter FP;
    private Drawable RZ = null;
    private int Sa = 0;
    private Rect fD = new Rect();
    private GestureDetector jtw;
    private OnClickListener mOnClickListener;
    protected int xXW;
    protected int xXX;
    private int xXY = Integer.MAX_VALUE;
    private int xXZ;
    private DataSetObserver xYA = new 2(this);
    private Runnable xYB = new 3(this);
    private boolean xYe = false;
    protected Scroller xYi = new Scroller(getContext());
    private final a xYj = new a(this, (byte) 0);
    private List<Queue<View>> xYk = new ArrayList();
    private View xYl = null;
    private Integer xYm = null;
    private int xYn;
    private int xYo;
    private int xYp;
    private e xYq = null;
    private int xYr = 0;
    private boolean xYs = false;
    public d xYt = null;
    private int xYu = a.xYD;
    private i xYv;
    private i xYw;
    private int xYx;
    private boolean xYy = false;
    private boolean xYz = false;

    @TargetApi(11)
    private static final class b {
        static {
            if (VERSION.SDK_INT < 11) {
                throw new RuntimeException("sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller) {
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
        }
    }

    static /* synthetic */ void b(HorizontalListViewV2 horizontalListViewV2, int i) {
        if (horizontalListViewV2.xYv != null && horizontalListViewV2.xYw != null) {
            int i2 = horizontalListViewV2.xXW + i;
            if (horizontalListViewV2.xYi != null && !horizontalListViewV2.xYi.isFinished()) {
                return;
            }
            if (i2 < 0) {
                horizontalListViewV2.xYv.x(((float) Math.abs(i)) / ((float) horizontalListViewV2.coO()));
                if (!horizontalListViewV2.xYw.isFinished()) {
                    horizontalListViewV2.xYw.cv();
                }
            } else if (i2 > horizontalListViewV2.xXY) {
                horizontalListViewV2.xYw.x(((float) Math.abs(i)) / ((float) horizontalListViewV2.coO()));
                if (!horizontalListViewV2.xYv.isFinished()) {
                    horizontalListViewV2.xYv.cv();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.FP;
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xYv = new i(context);
        this.xYw = new i(context);
        this.jtw = new GestureDetector(context, this.xYj);
        setOnTouchListener(new 1(this));
        initView();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            b.a(this.xYi);
        }
    }

    private void h(Boolean bool) {
        if (this.xYz != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.xYz = bool.booleanValue();
                    return;
                }
                view = (View) view.getParent();
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.xXW);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.xYm = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    private void initView() {
        this.xYn = -1;
        this.xYo = -1;
        this.xXZ = 0;
        this.xXW = 0;
        this.xXX = 0;
        this.xXY = Integer.MAX_VALUE;
        Et(a.xYD);
    }

    private void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
        this.xYp = i;
    }

    public View getSelectedView() {
        int i = this.xYp;
        return (i < this.xYn || i > this.xYo) ? null : getChildAt(i - this.xYn);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.xYA);
        }
        if (listAdapter != null) {
            this.xYs = false;
            this.FP = listAdapter;
            this.FP.registerDataSetObserver(this.xYA);
        }
        if (this.FP != null) {
            int viewTypeCount = this.FP.getViewTypeCount();
            this.xYk.clear();
            while (i < viewTypeCount) {
                this.xYk.add(new LinkedList());
                i++;
            }
        }
        reset();
    }

    private View Ep(int i) {
        int itemViewType = this.FP.getItemViewType(i);
        if (Eq(itemViewType)) {
            return (View) ((Queue) this.xYk.get(itemViewType)).poll();
        }
        return null;
    }

    private void j(int i, View view) {
        int itemViewType = this.FP.getItemViewType(i);
        if (Eq(itemViewType)) {
            ((Queue) this.xYk.get(itemViewType)).offer(view);
        }
    }

    private boolean Eq(int i) {
        return i < this.xYk.size();
    }

    private void I(View view, int i) {
        addViewInLayout(view, i, dj(view), true);
        LayoutParams dj = dj(view);
        view.measure(dj.width > 0 ? MeasureSpec.makeMeasureSpec(dj.width, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.xYx, getPaddingTop() + getPaddingBottom(), dj.height));
    }

    private static LayoutParams dj(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        super.onLayout(z, i, i2, i3, i4);
        if (this.FP != null) {
            int i5;
            int i6;
            View coN;
            View view;
            int i7;
            invalidate();
            if (this.xYe) {
                i5 = this.xXW;
                initView();
                removeAllViewsInLayout();
                this.xXX = i5;
                this.xYe = false;
            }
            if (this.xYm != null) {
                this.xXX = this.xYm.intValue();
                this.xYm = null;
            }
            if (this.xYi.computeScrollOffset()) {
                this.xXX = this.xYi.getCurrX();
            }
            if (this.xXX < 0) {
                this.xXX = 0;
                if (this.xYv.isFinished()) {
                    this.xYv.ap((int) coM());
                }
                this.xYi.forceFinished(true);
                Et(a.xYD);
            } else if (this.xXX > this.xXY) {
                this.xXX = this.xXY;
                if (this.xYw.isFinished()) {
                    this.xYw.ap((int) coM());
                }
                this.xYi.forceFinished(true);
                Et(a.xYD);
            }
            int i8 = this.xXW - this.xXX;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i8 <= 0) {
                i6 = this.xXZ;
                if (Er(this.xYn)) {
                    i5 = childAt.getMeasuredWidth();
                } else {
                    i5 = this.Sa + childAt.getMeasuredWidth();
                }
                this.xXZ = i5 + i6;
                j(this.xYn, childAt);
                removeViewInLayout(childAt);
                this.xYn++;
                childAt = getChildAt(0);
            }
            while (true) {
                coN = coN();
                if (coN == null || coN.getLeft() + i8 < getWidth()) {
                    coN = coN();
                } else {
                    j(this.xYo, coN);
                    removeViewInLayout(coN);
                    this.xYo--;
                }
            }
            coN = coN();
            i5 = coN != null ? coN.getRight() : 0;
            while ((i5 + i8) + this.Sa < getWidth() && this.xYo + 1 < this.FP.getCount()) {
                this.xYo++;
                if (this.xYn < 0) {
                    this.xYn = this.xYo;
                }
                view = this.FP.getView(this.xYo, Ep(this.xYo), this);
                I(view, -1);
                i5 += (this.xYo == 0 ? 0 : this.Sa) + view.getMeasuredWidth();
                if (!(this.xYq == null || this.FP == null || this.FP.getCount() - (this.xYo + 1) >= this.xYr || this.xYs)) {
                    this.xYs = true;
                }
            }
            coN = getChildAt(0);
            i5 = coN != null ? coN.getLeft() : 0;
            while ((i5 + i8) - this.Sa > 0 && this.xYn > 0) {
                this.xYn--;
                view = this.FP.getView(this.xYn, Ep(this.xYn), this);
                I(view, 0);
                i5 -= this.xYn == 0 ? view.getMeasuredWidth() : this.Sa + view.getMeasuredWidth();
                this.xXZ -= i5 + i8 == 0 ? view.getMeasuredWidth() : this.Sa + view.getMeasuredWidth();
            }
            i6 = getChildCount();
            if (i6 > 0) {
                this.xXZ += i8;
                i7 = this.xXZ;
                for (i5 = 0; i5 < i6; i5++) {
                    View childAt2 = getChildAt(i5);
                    int paddingLeft = getPaddingLeft() + i7;
                    int paddingTop = getPaddingTop();
                    childAt2.layout(paddingLeft, paddingTop, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + paddingTop);
                    i7 += childAt2.getMeasuredWidth() + this.Sa;
                }
            }
            this.xXW = this.xXX;
            if (Er(this.xYo)) {
                coN = coN();
                if (coN != null) {
                    i7 = this.xXY;
                    this.xXY = ((coN.getRight() - getPaddingLeft()) + this.xXW) - coO();
                    if (this.xXY < 0) {
                        this.xXY = 0;
                    }
                    if (this.xXY != i7) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                onLayout(z, i, i2, i3, i4);
            } else if (!this.xYi.isFinished()) {
                z.a(this, this.xYB);
            } else if (this.xYu == a.xYF) {
                Et(a.xYD);
            }
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.xXW == 0) {
            return 0.0f;
        }
        if (this.xXW < horizontalFadingEdgeLength) {
            return ((float) this.xXW) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.xXW == this.xXY) {
            return 0.0f;
        }
        if (this.xXY - this.xXW < horizontalFadingEdgeLength) {
            return ((float) (this.xXY - this.xXW)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float coM() {
        if (VERSION.SDK_INT >= 14) {
            return c.b(this.xYi);
        }
        return 30.0f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.xYx = i2;
    }

    private View coN() {
        return getChildAt(getChildCount() - 1);
    }

    private int eO(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.fD);
            if (this.fD.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private boolean Er(int i) {
        return i == this.FP.getCount() + -1;
    }

    private int coO() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void Es(int i) {
        this.xYi.startScroll(this.xXX, 0, i - this.xXX, 0);
        Et(a.xYF);
        requestLayout();
    }

    public int getFirstVisiblePosition() {
        return this.xYn;
    }

    public int getLastVisiblePosition() {
        return this.xYo;
    }

    private void a(Canvas canvas, Rect rect) {
        if (this.RZ != null) {
            this.RZ.setBounds(rect);
            this.RZ.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.fD;
        this.fD.top = getPaddingTop();
        this.fD.bottom = this.fD.top + ((getHeight() - getPaddingTop()) - getPaddingBottom());
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !Er(this.xYo)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.Sa;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected final boolean aD(float f) {
        this.xYi.fling(this.xXX, 0, (int) (-f), 0, 0, this.xXY, 0, 0);
        Et(a.xYF);
        requestLayout();
        return true;
    }

    protected final boolean onDown(MotionEvent motionEvent) {
        this.xYy = !this.xYi.isFinished();
        this.xYi.forceFinished(true);
        Et(a.xYD);
        coP();
        if (!this.xYy) {
            int eO = eO((int) motionEvent.getX(), (int) motionEvent.getY());
            if (eO >= 0) {
                this.xYl = getChildAt(eO);
                if (this.xYl != null) {
                    this.xYl.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    private void coP() {
        if (this.xYl != null) {
            this.xYl.setPressed(false);
            refreshDrawableState();
            this.xYl = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.xYi == null || this.xYi.isFinished()) {
                Et(a.xYD);
            }
            h(Boolean.valueOf(false));
            coQ();
        } else if (motionEvent.getAction() == 3) {
            coP();
            coQ();
            h(Boolean.valueOf(false));
        }
        return super.onTouchEvent(motionEvent);
    }

    private void coQ() {
        if (this.xYv != null) {
            this.xYv.cv();
        }
        if (this.xYw != null) {
            this.xYw.cv();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    private void Et(int i) {
        if (!(this.xYu == i || this.xYt == null)) {
            this.xYt.rU(i);
        }
        this.xYu = i;
    }
}
