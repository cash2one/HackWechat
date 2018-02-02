package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.gridviewheaders.c.b;
import com.tencent.mm.ui.gridviewheaders.c.d;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private DataSetObserver BD;
    private OnItemSelectedListener Gu;
    private OnItemClickListener XC;
    protected int YQ;
    private int iN;
    private af mHandler;
    private int mNumColumns;
    private OnScrollListener rRl;
    private int xXL;
    private int xXM;
    protected boolean xYe;
    private Runnable ydo;
    private int yi;
    private OnItemLongClickListener yka;
    public a zeL;
    public b zeM;
    private boolean zeN;
    private final Rect zeO;
    private boolean zeP;
    private boolean zeQ;
    private int zeR;
    private long zeS;
    private int zeT;
    private float zeU;
    private boolean zeV;
    private int zeW;
    public c zeX;
    d zeY;
    private e zeZ;
    private View zfa;
    protected c zfb;
    protected int zfc;
    private boolean zfd;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new 1();
        boolean zfi;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.zfi = parcel.readByte() != (byte) 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.zfi + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.zfi ? 1 : 0));
        }
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i) {
        return i == -2 ? gridHeadersGridView.zeS : gridHeadersGridView.zfb.om(gridHeadersGridView.getFirstVisiblePosition() + i);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new af();
        this.zeN = true;
        this.zeO = new Rect();
        this.zeS = -1;
        this.BD = new 1(this);
        this.zeW = 1;
        this.yi = 0;
        this.zfd = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.zeV) {
            this.mNumColumns = -1;
        }
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final View GD(int i) {
        if (i == -2) {
            return this.zfa;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.XC.onItemClick(adapterView, view, this.zfb.GC(i).mPosition, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.yka.onItemLongClick(adapterView, view, this.zfb.GC(i).mPosition, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.Gu.onItemSelected(adapterView, view, this.zfb.GC(i).mPosition, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.Gu.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.zeN = savedState.zfi;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.zfi = this.zeN;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.rRl != null) {
            this.rRl.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            GE(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.rRl != null) {
            this.rRl.onScrollStateChanged(absListView, i);
        }
        this.yi = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i = -2;
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.zeM == null) {
                    this.zeM = new b(this);
                }
                this.mHandler.postDelayed(this.zeL, (long) ViewConfiguration.getTapTimeout());
                int y = (int) motionEvent.getY();
                this.zeU = (float) y;
                float f = (float) y;
                if (this.zfa == null || f > ((float) this.zfa.getBottom())) {
                    y = getFirstVisiblePosition();
                    i = 0;
                    while (y <= getLastVisiblePosition()) {
                        if (getItemIdAtPosition(y) == -1) {
                            View childAt = getChildAt(i);
                            int bottom = childAt.getBottom();
                            int top = childAt.getTop();
                            if (f <= ((float) bottom) && f >= ((float) top)) {
                            }
                        }
                        y += this.zeW;
                        i += this.zeW;
                    }
                    i = -1;
                }
                this.zfc = i;
                if (!(this.zfc == -1 || this.yi == 2)) {
                    this.YQ = 0;
                }
            case 1:
                if (!(this.YQ == -2 || this.YQ == -1 || this.zfc == -1)) {
                    View GD = GD(this.zfc);
                    if (!(GD == null || GD.hasFocusable())) {
                        if (this.YQ != 0) {
                            GD.setPressed(false);
                        }
                        if (this.zeZ == null) {
                            this.zeZ = new e(this, (byte) 0);
                        }
                        e eVar = this.zeZ;
                        eVar.zfh = this.zfc;
                        eVar.cxp();
                        if (this.YQ == 0 && this.YQ == 1) {
                            if (!this.xYe) {
                                eVar.run();
                                z = true;
                                break;
                            }
                        }
                        this.mHandler.removeCallbacks(this.YQ == 0 ? this.zeM : this.zeL);
                        if (!this.xYe) {
                            this.YQ = 1;
                            GD.setPressed(true);
                            setPressed(true);
                            if (this.ydo != null) {
                                removeCallbacks(this.ydo);
                            }
                            this.ydo = new 2(this, GD, eVar);
                            this.mHandler.postDelayed(this.ydo, (long) ViewConfiguration.getPressedStateDuration());
                            z = true;
                            break;
                        }
                        this.YQ = -1;
                    }
                    this.YQ = -1;
                }
                break;
            case 2:
                if (this.zfc != -1 && Math.abs(motionEvent.getY() - this.zeU) > ((float) this.iN)) {
                    this.YQ = -1;
                    View GD2 = GD(this.zfc);
                    if (GD2 != null) {
                        GD2.setPressed(false);
                    }
                    if (this.zeL != null) {
                        this.mHandler.removeCallbacks(this.zeL);
                    }
                    this.zfc = -1;
                }
                z = false;
                break;
        }
        z = false;
        if (z) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (!(this.zfb == null || this.BD == null)) {
            this.zfb.unregisterDataSetObserver(this.BD);
        }
        if (!this.zeQ) {
            this.zeP = true;
        }
        if (listAdapter instanceof b) {
            listAdapter = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            r3 = new f((e) listAdapter);
        } else {
            r3 = new d(listAdapter);
        }
        this.zfb = new c(getContext(), this, listAdapter);
        this.zfb.registerDataSetObserver(this.BD);
        reset();
        super.setAdapter(this.zfb);
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.zeP = z;
        this.zeQ = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.zeR = i;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.xXL = i;
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.zeV = true;
        this.mNumColumns = i;
        if (i != -1 && this.zfb != null) {
            this.zfb.setNumColumns(i);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.XC = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.yka = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Gu = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rRl = onScrollListener;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.xXM = i;
    }

    private int cxm() {
        if (this.zfa != null) {
            return this.zfa.getMeasuredHeight();
        }
        return 0;
    }

    private void cxn() {
        if (this.zfa != null) {
            int makeMeasureSpec;
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            LayoutParams layoutParams = this.zfa.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.zfa.measure(makeMeasureSpec2, makeMeasureSpec);
            this.zfa.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.zfa.getMeasuredHeight());
        }
    }

    private void reset() {
        this.zeT = 0;
        this.zfa = null;
        this.zeS = Long.MIN_VALUE;
    }

    private void GE(int i) {
        if (this.zfb != null && this.zfb.getCount() != 0 && this.zeN && ((d) getChildAt(0)) != null) {
            int i2;
            long om;
            int childCount;
            View view;
            int i3;
            View view2;
            View view3;
            int i4 = i - this.zeW;
            if (i4 < 0) {
                i4 = i;
            }
            int i5 = this.zeW + i;
            if (i5 >= this.zfb.getCount()) {
                i5 = i;
            }
            if (this.xXM != 0) {
                if (this.xXM < 0) {
                    this.zfb.om(i);
                    if (getChildAt(this.zeW).getTop() <= 0) {
                        i2 = i5;
                        om = this.zfb.om(i5);
                    } else {
                        om = this.zfb.om(i);
                        i2 = i;
                    }
                } else {
                    i5 = getChildAt(0).getTop();
                    if (i5 > 0 && i5 < this.xXM) {
                        i2 = i4;
                        om = this.zfb.om(i4);
                    }
                }
                if (this.zeS != om) {
                    this.zfa = this.zfb.a(i2, this.zfa, this);
                    cxn();
                    this.zeS = om;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    view = null;
                    i2 = 99999;
                    i3 = 0;
                    while (i3 < childCount) {
                        view2 = (d) super.getChildAt(i3);
                        if (this.zeP) {
                            i5 = view2.getTop();
                        } else {
                            i5 = view2.getTop() - getPaddingTop();
                        }
                        if (i5 >= 0 || !(view2.getChildAt(0) instanceof b) || i5 >= i2) {
                            i4 = i2;
                            view3 = view;
                        } else {
                            int i6 = i5;
                            view3 = view2;
                            i4 = i6;
                        }
                        i3 = this.zeW + i3;
                        view = view3;
                        i2 = i4;
                    }
                    i4 = cxm();
                    if (view != null) {
                        this.zeT = i4;
                        if (this.zeP) {
                            this.zeT += getPaddingTop();
                            return;
                        }
                        return;
                    } else if (i != 0 && super.getChildAt(0).getTop() > 0 && !this.zeP) {
                        this.zeT = 0;
                        return;
                    } else if (this.zeP) {
                        this.zeT = Math.min(view.getTop(), i4);
                        if (this.zeT >= 0) {
                            i4 = this.zeT;
                        }
                        this.zeT = i4;
                        return;
                    } else {
                        this.zeT = Math.min(view.getTop(), getPaddingTop() + i4);
                        this.zeT = this.zeT >= getPaddingTop() ? i4 + getPaddingTop() : this.zeT;
                    }
                }
            }
            om = this.zfb.om(i);
            i2 = i;
            if (this.zeS != om) {
                this.zfa = this.zfb.a(i2, this.zfa, this);
                cxn();
                this.zeS = om;
            }
            childCount = getChildCount();
            if (childCount != 0) {
                view = null;
                i2 = 99999;
                i3 = 0;
                while (i3 < childCount) {
                    view2 = (d) super.getChildAt(i3);
                    if (this.zeP) {
                        i5 = view2.getTop();
                    } else {
                        i5 = view2.getTop() - getPaddingTop();
                    }
                    if (i5 >= 0) {
                    }
                    i4 = i2;
                    view3 = view;
                    i3 = this.zeW + i3;
                    view = view3;
                    i2 = i4;
                }
                i4 = cxm();
                if (view != null) {
                    this.zeT = i4;
                    if (this.zeP) {
                        this.zeT += getPaddingTop();
                        return;
                    }
                    return;
                }
                if (i != 0) {
                }
                if (this.zeP) {
                    this.zeT = Math.min(view.getTop(), i4);
                    if (this.zeT >= 0) {
                        i4 = this.zeT;
                    }
                    this.zeT = i4;
                    return;
                }
                this.zeT = Math.min(view.getTop(), getPaddingTop() + i4);
                if (this.zeT >= getPaddingTop()) {
                }
                this.zeT = this.zeT >= getPaddingTop() ? i4 + getPaddingTop() : this.zeT;
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Object obj;
        if (VERSION.SDK_INT < 8) {
            GE(getFirstVisiblePosition());
        }
        if (this.zfa != null && this.zeN && this.zfa.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int cxm = cxm();
        int i = this.zeT - cxm;
        if (obj != null && this.zfd) {
            this.zeO.left = getPaddingLeft();
            this.zeO.right = getWidth() - getPaddingRight();
            this.zeO.top = this.zeT;
            this.zeO.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.zeO);
        }
        super.dispatchDraw(canvas);
        List arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.zeW;
            i2 += this.zeW;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            d dVar = (d) getChildAt(((Integer) arrayList.get(i3)).intValue());
            try {
                View view = (View) dVar.getTag();
                Object obj2 = (((long) ((b) dVar.getChildAt(0)).zeH) == this.zeS && dVar.getTop() < 0 && this.zeN) ? 1 : null;
                if (view.getVisibility() == 0 && obj2 == null) {
                    view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                    this.zeO.left = getPaddingLeft();
                    this.zeO.right = getWidth() - getPaddingRight();
                    this.zeO.bottom = dVar.getBottom();
                    this.zeO.top = dVar.getTop();
                    canvas.save();
                    canvas.clipRect(this.zeO);
                    canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                i3++;
            } catch (Exception e) {
                return;
            }
        }
        if (obj != null && this.zfd) {
            canvas.restore();
        } else if (obj == null) {
            return;
        }
        if (this.zfa.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
            this.zfa.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
            this.zfa.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.zfa.getHeight());
        }
        this.zeO.left = getPaddingLeft();
        this.zeO.right = getWidth() - getPaddingRight();
        this.zeO.bottom = i + cxm;
        if (this.zeP) {
            this.zeO.top = getPaddingTop();
        } else {
            this.zeO.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.zeO);
        canvas.translate((float) getPaddingLeft(), (float) i);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.zeT)) / ((float) cxm)), 4);
        this.zfa.draw(canvas);
        canvas.restore();
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        if (this.mNumColumns == -1) {
            if (this.zeR > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.zeR;
                if (i4 > 0) {
                    while (i4 != 1 && (this.zeR * i4) + ((i4 - 1) * this.xXL) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.zeW = i3;
        } else {
            this.zeW = this.mNumColumns;
        }
        if (this.zfb != null) {
            this.zfb.setNumColumns(this.zeW);
        }
        cxn();
        super.onMeasure(i, i2);
    }
}
