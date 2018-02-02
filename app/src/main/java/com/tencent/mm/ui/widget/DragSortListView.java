package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.cb.a$j;
import com.tencent.smtt.sdk.WebView;

public class DragSortListView extends ListView {
    private int EV = 0;
    private int iKu;
    private int iKv;
    private int jED;
    private int jEE;
    private int kfL;
    private DataSetObserver mObserver;
    private b zrA;
    public g zrB;
    public l zrC;
    boolean zrD = true;
    private int zrE = 1;
    private int zrF;
    private int zrG;
    private int zrH = 0;
    private View[] zrI = new View[1];
    private d zrJ;
    private float zrK = 0.33333334f;
    private float zrL = 0.33333334f;
    private int zrM;
    private int zrN;
    private float zrO;
    private float zrP;
    private float zrQ;
    private float zrR;
    private float zrS = 0.5f;
    private c zrT = new 1(this);
    private int zrU;
    private int zrV = 0;
    private boolean zrW = false;
    boolean zrX = false;
    h zrY = null;
    private MotionEvent zrZ;
    private View zrl;
    private Point zrm = new Point();
    private Point zrn = new Point();
    private int zro;
    private boolean zrp = false;
    private float zrq = 1.0f;
    private float zrr = 1.0f;
    private int zrs;
    private int zrt;
    private int zru;
    private boolean zrv = false;
    private int zrw;
    private int zrx;
    private int zry;
    private int zrz;
    private int zsa = 0;
    private float zsb = 0.25f;
    private float zsc = 0.0f;
    private a zsd;
    private boolean zse = false;
    private e zsf;
    private boolean zsg = false;
    private boolean zsh = false;
    private i zsi = new i(this);
    private k zsj;
    private j zsk;
    private f zsl;
    boolean zsm;
    private float zsn = 0.0f;
    boolean zso = false;
    private boolean zsp = false;

    private class m implements Runnable {
        boolean Mu;
        private float mAlpha = 0.5f;
        protected long mStartTime;
        private float zsT;
        private float zsU;
        private float zsV;
        private float zsW;
        private float zsX;
        final /* synthetic */ DragSortListView zsq;

        public m(DragSortListView dragSortListView, float f, int i) {
            this.zsq = dragSortListView;
            this.zsT = (float) i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.zsX = f2;
            this.zsU = f2;
            this.zsV = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.zsW = 1.0f / (1.0f - this.mAlpha);
        }

        public final void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.Mu = false;
            onStart();
            this.zsq.post(this);
        }

        public void onStart() {
        }

        public void aH(float f) {
        }

        public void onStop() {
        }

        public void run() {
            if (!this.Mu) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.zsT;
                if (uptimeMillis >= 1.0f) {
                    aH(1.0f);
                    onStop();
                    return;
                }
                if (uptimeMillis < this.mAlpha) {
                    uptimeMillis *= this.zsU * uptimeMillis;
                } else if (uptimeMillis < 1.0f - this.mAlpha) {
                    uptimeMillis = (uptimeMillis * this.zsW) + this.zsV;
                } else {
                    uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.zsX * (uptimeMillis - 1.0f)));
                }
                aH(uptimeMillis);
                this.zsq.post(this);
            }
        }
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 150;
        int i2 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a$j.fac, 0, 0);
            this.zrE = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(a$j.zAe, 1));
            this.zse = obtainStyledAttributes.getBoolean(a$j.zAj, false);
            if (this.zse) {
                this.zsf = new e(this);
            }
            this.zrq = obtainStyledAttributes.getFloat(a$j.zAk, this.zrq);
            this.zrr = this.zrq;
            this.zrD = obtainStyledAttributes.getBoolean(a$j.zAo, this.zrD);
            this.zsb = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(a$j.zAl, 0.75f)));
            this.zrv = this.zsb > 0.0f;
            float f = obtainStyledAttributes.getFloat(a$j.zAf, this.zrK);
            if (f > 0.5f) {
                this.zrL = 0.5f;
            } else {
                this.zrL = f;
            }
            if (f > 0.5f) {
                this.zrK = 0.5f;
            } else {
                this.zrK = f;
            }
            if (getHeight() != 0) {
                cyE();
            }
            this.zrS = obtainStyledAttributes.getFloat(a$j.zAg, this.zrS);
            int i3 = obtainStyledAttributes.getInt(a$j.zAm, 150);
            int i4 = obtainStyledAttributes.getInt(a$j.zAn, 150);
            if (obtainStyledAttributes.getBoolean(a$j.zAv, true)) {
                boolean z = obtainStyledAttributes.getBoolean(a$j.zAq, false);
                int i5 = obtainStyledAttributes.getInt(a$j.zAi, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(a$j.zAp, true);
                int i6 = obtainStyledAttributes.getInt(a$j.zAr, 0);
                int resourceId = obtainStyledAttributes.getResourceId(a$j.zAs, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(a$j.zAt, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(a$j.zAu, 0);
                int color = obtainStyledAttributes.getColor(a$j.zAh, WebView.NIGHT_MODE_COLOR);
                Object bVar = new b(this, resourceId, i6, i5, resourceId3, resourceId2);
                bVar.zqS = z;
                bVar.zqR = z2;
                bVar.zwm = color;
                this.zrY = bVar;
                setOnTouchListener(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.zrJ = new d(this);
        if (i > 0) {
            this.zsj = new k(this, i);
        }
        if (i2 > 0) {
            this.zsl = new f(this, i2);
        }
        this.zrZ = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver(this) {
            final /* synthetic */ DragSortListView zsq;

            {
                this.zsq = r1;
            }

            private void cancel() {
                if (this.zsq.EV == 4) {
                    this.zsq.cyz();
                }
            }

            public final void onChanged() {
                cancel();
            }

            public final void onInvalidated() {
                cancel();
            }
        };
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.zsd = new a(this, listAdapter);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof g) {
                this.zrB = (g) listAdapter;
            }
            if (listAdapter instanceof b) {
                this.zrA = (b) listAdapter;
            }
            if (listAdapter instanceof l) {
                this.zrC = (l) listAdapter;
            }
        } else {
            this.zsd = null;
        }
        super.setAdapter(this.zsd);
    }

    private void a(int i, Canvas canvas) {
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.zrw) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.EV != 0) {
            if (this.zrt != this.zrw) {
                a(this.zrt, canvas);
            }
            if (!(this.zru == this.zrt || this.zru == this.zrw)) {
                a(this.zru, canvas);
            }
        }
        if (this.zrl != null) {
            float f;
            int width = this.zrl.getWidth();
            int height = this.zrl.getHeight();
            int i = this.zrm.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.zrr));
            canvas.save();
            canvas.translate((float) this.zrm.x, (float) this.zrm.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.zrl.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private int GR(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return fk(i, GT(i));
    }

    private int fj(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.zrF - this.zrE;
        int GT = GT(i);
        int GR = GR(i);
        if (this.zru <= this.zrw) {
            if (i != this.zru || this.zrt == this.zru) {
                if (i > this.zru && i <= this.zrw) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.zrw) {
                i2 = (i2 + GR) - this.zrF;
            } else {
                i2 = ((GR - GT) + i2) - footerViewsCount;
            }
        } else if (i > this.zrw && i <= this.zrt) {
            i2 += footerViewsCount;
        } else if (i == this.zru && this.zrt != this.zru) {
            i2 += GR - GT;
        }
        if (i <= this.zrw) {
            return (((this.zrF - headerViewsCount) - GT(i - 1)) / 2) + i2;
        }
        return (((GT - headerViewsCount) - this.zrF) / 2) + i2;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.zse) {
            e eVar = this.zsf;
            if (eVar.zsE) {
                int i;
                eVar.mBuilder.append("<DSLVState>\n");
                int childCount = eVar.zsq.getChildCount();
                int firstVisiblePosition = eVar.zsq.getFirstVisiblePosition();
                eVar.mBuilder.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                eVar.mBuilder.append("</Positions>\n");
                eVar.mBuilder.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.zsq.getChildAt(i).getTop()).append(",");
                }
                eVar.mBuilder.append("</Tops>\n");
                eVar.mBuilder.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.zsq.getChildAt(i).getBottom()).append(",");
                }
                eVar.mBuilder.append("</Bottoms>\n");
                eVar.mBuilder.append("    <FirstExpPos>").append(eVar.zsq.zrt).append("</FirstExpPos>\n");
                eVar.mBuilder.append("    <FirstExpBlankHeight>").append(eVar.zsq.GR(eVar.zsq.zrt) - eVar.zsq.GT(eVar.zsq.zrt)).append("</FirstExpBlankHeight>\n");
                eVar.mBuilder.append("    <SecondExpPos>").append(eVar.zsq.zru).append("</SecondExpPos>\n");
                eVar.mBuilder.append("    <SecondExpBlankHeight>").append(eVar.zsq.GR(eVar.zsq.zru) - eVar.zsq.GT(eVar.zsq.zru)).append("</SecondExpBlankHeight>\n");
                eVar.mBuilder.append("    <SrcPos>").append(eVar.zsq.zrw).append("</SrcPos>\n");
                eVar.mBuilder.append("    <SrcHeight>").append(eVar.zsq.zrF + eVar.zsq.getDividerHeight()).append("</SrcHeight>\n");
                eVar.mBuilder.append("    <ViewHeight>").append(eVar.zsq.getHeight()).append("</ViewHeight>\n");
                eVar.mBuilder.append("    <LastY>").append(eVar.zsq.jEE).append("</LastY>\n");
                eVar.mBuilder.append("    <FloatY>").append(eVar.zsq.zro).append("</FloatY>\n");
                eVar.mBuilder.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.zsq.fj(firstVisiblePosition + i, eVar.zsq.getChildAt(i).getTop())).append(",");
                }
                eVar.mBuilder.append("</ShuffleEdges>\n");
                eVar.mBuilder.append("</DSLVState>\n");
                eVar.zsC++;
                if (eVar.zsC > 1000) {
                    eVar.flush();
                    eVar.zsC = 0;
                }
            }
        }
    }

    public final void k(int i, float f) {
        if (this.EV == 0 || this.EV == 4) {
            if (this.EV == 0) {
                this.zrw = getHeaderViewsCount() + i;
                this.zrt = this.zrw;
                this.zru = this.zrw;
                this.zrs = this.zrw;
                View childAt = getChildAt(this.zrw - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.EV = 1;
            this.zsn = f;
            if (this.zrX) {
                switch (this.zsa) {
                    case 1:
                        super.onTouchEvent(this.zrZ);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.zrZ);
                        break;
                }
            }
            if (this.zsj != null) {
                this.zsj.start();
            } else {
                GS(i);
            }
        }
    }

    public final void cyz() {
        if (this.EV == 4) {
            this.zrJ.cyI();
            cyH();
            cyA();
            cyF();
            if (this.zrX) {
                this.EV = 3;
            } else {
                this.EV = 0;
            }
        }
    }

    private void cyA() {
        this.zrw = -1;
        this.zrt = -1;
        this.zru = -1;
        this.zrs = -1;
    }

    private void cyB() {
        this.EV = 2;
        if (this.zrB != null && this.zrs >= 0 && this.zrs < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.zrB.cq(this.zrw - headerViewsCount, this.zrs - headerViewsCount);
        }
        cyH();
        cyC();
        cyA();
        cyF();
        if (this.zrX) {
            this.EV = 3;
        } else {
            this.EV = 0;
        }
    }

    private void GS(int i) {
        this.EV = 1;
        if (this.zrC != null) {
            this.zrC.remove(i);
        }
        cyH();
        cyC();
        cyA();
        if (this.zrX) {
            this.EV = 3;
        } else {
            this.EV = 0;
        }
    }

    private void cyC() {
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.zrw < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
    }

    public final boolean aF(float f) {
        this.zsm = true;
        return b(true, f);
    }

    private boolean b(boolean z, float f) {
        if (this.zrl == null) {
            return false;
        }
        this.zrJ.cyI();
        if (z) {
            k(this.zrw - getHeaderViewsCount(), f);
        } else if (this.zsl != null) {
            this.zsl.start();
        } else {
            cyB();
        }
        if (this.zse) {
            e eVar = this.zsf;
            if (eVar.zsE) {
                eVar.mBuilder.append("</DSLVStates>\n");
                eVar.flush();
                eVar.zsE = false;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zsh) {
            this.zsh = false;
            return false;
        } else if (!this.zrD) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z = this.zrW;
            this.zrW = false;
            if (!z) {
                N(motionEvent);
            }
            if (this.EV != 4) {
                if (this.EV == 0 && super.onTouchEvent(motionEvent)) {
                    z = true;
                } else {
                    z = false;
                }
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        cyD();
                        break;
                    default:
                        if (z) {
                            this.zsa = 1;
                            break;
                        }
                        break;
                }
            }
            motionEvent.getAction();
            switch (motionEvent.getAction() & 255) {
                case 1:
                    if (this.EV == 4) {
                        this.zsm = false;
                        b(false, 0.0f);
                    }
                    cyD();
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    this.zrm.x = ((int) motionEvent.getX()) - this.zrx;
                    this.zrm.y = y - this.zry;
                    nA(true);
                    int min = Math.min(y, this.zro + this.zrG);
                    y = Math.max(y, this.zro - this.zrG);
                    d dVar = this.zrJ;
                    int i = dVar.zsB ? dVar.zsz : -1;
                    if (min <= this.jEE || min <= this.zrN || i == 1) {
                        if (y >= this.jEE || y >= this.zrM || i == 0) {
                            if (y >= this.zrM && min <= this.zrN && this.zrJ.zsB) {
                                this.zrJ.cyI();
                                break;
                            }
                        }
                        if (i != -1) {
                            this.zrJ.cyI();
                        }
                        this.zrJ.GU(0);
                        break;
                    }
                    if (i != -1) {
                        this.zrJ.cyI();
                    }
                    this.zrJ.GU(1);
                    break;
                    break;
                case 3:
                    if (this.EV == 4) {
                        cyz();
                    }
                    cyD();
                    break;
            }
            z = true;
            return z;
        }
    }

    private void cyD() {
        this.zsa = 0;
        this.zrX = false;
        if (this.EV == 3) {
            this.EV = 0;
        }
        this.zrr = this.zrq;
        this.zso = false;
        i iVar = this.zsi;
        iVar.zsJ.clear();
        iVar.zsK.clear();
    }

    private void N(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.jED = this.iKu;
            this.jEE = this.iKv;
        }
        this.iKu = (int) motionEvent.getX();
        this.iKv = (int) motionEvent.getY();
        if (action == 0) {
            this.jED = this.iKu;
            this.jEE = this.iKv;
        }
        this.kfL = ((int) motionEvent.getRawX()) - this.iKu;
        this.zrz = ((int) motionEvent.getRawY()) - this.iKv;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.zrD) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z;
        N(motionEvent);
        this.zrW = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.EV != 0) {
                this.zsh = true;
                return true;
            }
            this.zrX = true;
        }
        if (this.zrl == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.zso = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    cyD();
                    break;
                default:
                    if (!z) {
                        this.zsa = 2;
                        break;
                    }
                    this.zsa = 1;
                    break;
            }
        }
        z = true;
        if (action == 1 || action == 3) {
            this.zrX = false;
        }
        return z;
    }

    private void cyE() {
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.zrP = ((float) paddingTop) + (this.zrK * f);
        this.zrO = (f * (1.0f - this.zrL)) + ((float) paddingTop);
        this.zrM = (int) this.zrP;
        this.zrN = (int) this.zrO;
        this.zrQ = this.zrP - ((float) paddingTop);
        this.zrR = ((float) (paddingTop + height)) - this.zrO;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cyE();
    }

    private void cyF() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void a(int i, View view, boolean z) {
        int fk;
        LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.zrw || i == this.zrt || i == this.zru) {
            fk = fk(i, b(i, view, z));
        } else {
            fk = -2;
        }
        if (fk != layoutParams.height) {
            layoutParams.height = fk;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.zrt || i == this.zru) {
            if (i < this.zrw) {
                ((c) view).ug = 80;
            } else if (i > this.zrw) {
                ((c) view).ug = 48;
            }
        }
        int visibility = view.getVisibility();
        fk = 0;
        if (i == this.zrw && this.zrl != null) {
            fk = 4;
        }
        if (fk != visibility) {
            view.setVisibility(fk);
        }
    }

    private int GT(int i) {
        if (i == this.zrw) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i, childAt, false);
        }
        int i2 = this.zsi.zsJ.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.zrI.length) {
            this.zrI = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            childAt = adapter.getView(i, null, this);
        } else if (this.zrI[itemViewType] == null) {
            childAt = adapter.getView(i, null, this);
            this.zrI[itemViewType] = childAt;
        } else {
            childAt = adapter.getView(i, this.zrI[itemViewType], this);
        }
        itemViewType = b(i, childAt, true);
        i iVar = this.zsi;
        i2 = iVar.zsJ.get(i, -1);
        if (i2 != itemViewType) {
            if (i2 != -1) {
                iVar.zsK.remove(Integer.valueOf(i));
            } else if (iVar.zsJ.size() == iVar.xjb) {
                iVar.zsJ.delete(((Integer) iVar.zsK.remove(0)).intValue());
            }
            iVar.zsJ.put(i, itemViewType);
            iVar.zsK.add(Integer.valueOf(i));
        }
        return itemViewType;
    }

    private int b(int i, View view, boolean z) {
        if (i == this.zrw) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height != 0 && !z) {
            return height;
        }
        dM(view);
        return view.getMeasuredHeight();
    }

    private int fk(int i, int i2) {
        getDividerHeight();
        Object obj = (!this.zrv || this.zrt == this.zru) ? null : 1;
        int i3 = this.zrF - this.zrE;
        int i4 = (int) (this.zsc * ((float) i3));
        if (i == this.zrw) {
            if (this.zrw == this.zrt) {
                if (obj != null) {
                    return i4 + this.zrE;
                }
                return this.zrF;
            } else if (this.zrw == this.zru) {
                return this.zrF - i4;
            } else {
                return this.zrE;
            }
        } else if (i == this.zrt) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.zru) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        if (!this.zsg) {
            super.requestLayout();
        }
    }

    private void dM(View view) {
        int makeMeasureSpec;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.zrH, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void cyG() {
        if (this.zrl != null) {
            dM(this.zrl);
            this.zrF = this.zrl.getMeasuredHeight();
            this.zrG = this.zrF / 2;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.zrl != null) {
            if (this.zrl.isLayoutRequested()) {
                cyG();
            }
            this.zrp = true;
        }
        this.zrH = i;
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.zrl != null) {
            if (this.zrl.isLayoutRequested() && !this.zrp) {
                cyG();
            }
            this.zrl.layout(0, 0, this.zrl.getMeasuredWidth(), this.zrl.getMeasuredHeight());
            this.zrp = false;
        }
    }

    public final boolean a(int i, View view, int i2, int i3, int i4) {
        if (this.EV != 0 || !this.zrX || this.zrl != null || view == null || !this.zrD) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        this.zrt = headerViewsCount;
        this.zru = headerViewsCount;
        this.zrw = headerViewsCount;
        this.zrs = headerViewsCount;
        this.EV = 4;
        this.zrV = 0;
        this.zrV |= i2;
        this.zrl = view;
        cyG();
        this.zrx = i3;
        this.zry = i4;
        this.zrU = this.iKv;
        this.zrm.x = this.iKu - this.zrx;
        this.zrm.y = this.iKv - this.zry;
        View childAt = getChildAt(this.zrw - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.zse) {
            e eVar = this.zsf;
            eVar.mBuilder.append("<DSLVStates>\n");
            eVar.zsD = 0;
            eVar.zsE = true;
        }
        switch (this.zsa) {
            case 1:
                super.onTouchEvent(this.zrZ);
                break;
            case 2:
                super.onInterceptTouchEvent(this.zrZ);
                break;
        }
        requestLayout();
        if (this.zsk == null) {
            return true;
        }
        this.zsk.start();
        return true;
    }

    private void nA(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            c(firstVisiblePosition, childAt, true);
        }
    }

    private void c(int i, View view, boolean z) {
        int count;
        Object obj;
        Object obj2;
        this.zsg = true;
        if (this.zrY != null) {
            this.zrn.set(this.iKu, this.iKv);
            this.zrY.g(this.zrm);
        }
        int i2 = this.zrm.x;
        int i3 = this.zrm.y;
        int paddingLeft = getPaddingLeft();
        if ((this.zrV & 1) == 0 && i2 > paddingLeft) {
            this.zrm.x = paddingLeft;
        } else if ((this.zrV & 2) == 0 && i2 < paddingLeft) {
            this.zrm.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i2 = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i2 = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.zrV & 8) == 0 && firstVisiblePosition <= this.zrw) {
            i2 = Math.max(getChildAt(this.zrw - firstVisiblePosition).getTop(), i2);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.zrV & 4) == 0 && lastVisiblePosition >= this.zrw) {
            paddingLeft = Math.min(getChildAt(this.zrw - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i3 < i2) {
            this.zrm.y = i2;
        } else if (this.zrF + i3 > paddingLeft) {
            this.zrm.y = paddingLeft - this.zrF;
        }
        this.zro = this.zrm.y + this.zrG;
        int i4 = this.zrt;
        int i5 = this.zru;
        i3 = getFirstVisiblePosition();
        paddingLeft = this.zrt;
        View childAt = getChildAt(paddingLeft - i3);
        if (childAt == null) {
            paddingLeft = i3 + (getChildCount() / 2);
            childAt = getChildAt(paddingLeft - i3);
        }
        footerViewsCount = childAt.getTop();
        i2 = childAt.getHeight();
        i3 = fj(paddingLeft, footerViewsCount);
        lastVisiblePosition = getDividerHeight();
        if (this.zro >= i3) {
            count = getCount();
            firstVisiblePosition = footerViewsCount;
            footerViewsCount = i2;
            i2 = paddingLeft;
            paddingLeft = i3;
            while (i2 < count) {
                if (i2 != count - 1) {
                    firstVisiblePosition += lastVisiblePosition + footerViewsCount;
                    footerViewsCount = GR(i2 + 1);
                    i3 = fj(i2 + 1, firstVisiblePosition);
                    if (this.zro < i3) {
                        break;
                    }
                    i2++;
                    paddingLeft = i3;
                } else {
                    i3 = (firstVisiblePosition + lastVisiblePosition) + footerViewsCount;
                    break;
                }
            }
        }
        i2 = paddingLeft;
        paddingLeft = i3;
        while (i2 >= 0) {
            i2--;
            i3 = GR(i2);
            if (i2 != 0) {
                footerViewsCount -= i3 + lastVisiblePosition;
                i3 = fj(i2, footerViewsCount);
                if (this.zro >= i3) {
                    break;
                }
                paddingLeft = i3;
            } else {
                i3 = (footerViewsCount - lastVisiblePosition) - i3;
                break;
            }
        }
        footerViewsCount = getHeaderViewsCount();
        lastVisiblePosition = getFooterViewsCount();
        count = this.zrt;
        int i6 = this.zru;
        float f = this.zsc;
        if (this.zrv) {
            int abs = Math.abs(i3 - paddingLeft);
            if (this.zro >= i3) {
                int i7 = paddingLeft;
                paddingLeft = i3;
                i3 = i7;
            }
            abs = (int) (((float) abs) * (0.5f * this.zsb));
            float f2 = (float) abs;
            paddingLeft += abs;
            abs = i3 - abs;
            if (this.zro < paddingLeft) {
                this.zrt = i2 - 1;
                this.zru = i2;
                this.zsc = (((float) (paddingLeft - this.zro)) * 0.5f) / f2;
            } else if (this.zro >= abs) {
                this.zrt = i2;
                this.zru = i2 + 1;
                this.zsc = 0.5f * ((((float) (i3 - this.zro)) / f2) + 1.0f);
            }
            if (this.zrt < footerViewsCount) {
                this.zrt = footerViewsCount;
                this.zru = footerViewsCount;
                i2 = footerViewsCount;
            } else if (this.zru >= getCount() - lastVisiblePosition) {
                i2 = (getCount() - lastVisiblePosition) - 1;
                this.zrt = i2;
                this.zru = i2;
            }
            if (this.zrt != count && this.zru == i6 && this.zsc == f) {
                obj = null;
            } else {
                obj = 1;
            }
            if (i2 == this.zrs) {
                this.zrs = i2;
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            if (obj2 != null) {
                cyF();
                i3 = GT(i);
                paddingLeft = view.getHeight();
                footerViewsCount = fk(i, i3);
                if (i == this.zrw) {
                    i2 = paddingLeft - i3;
                    i3 = footerViewsCount - i3;
                } else {
                    i2 = paddingLeft;
                    i3 = footerViewsCount;
                }
                lastVisiblePosition = this.zrF;
                if (!(this.zrw == this.zrt || this.zrw == this.zru)) {
                    lastVisiblePosition -= this.zrE;
                }
                if (i <= i4) {
                    if (i > this.zrt) {
                        i2 = (lastVisiblePosition - i3) + 0;
                    }
                    i2 = 0;
                } else if (i != i5) {
                    i2 = i > this.zrt ? (i2 - lastVisiblePosition) + 0 : i != this.zru ? (paddingLeft - footerViewsCount) + 0 : i2 + 0;
                } else if (i > this.zrt) {
                    i2 = 0 - lastVisiblePosition;
                } else {
                    if (i == this.zru) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                }
                setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
                layoutChildren();
            }
            if (obj2 != null || z) {
                invalidate();
            }
            this.zsg = false;
        }
        this.zrt = i2;
        this.zru = i2;
        if (this.zrt < footerViewsCount) {
            this.zrt = footerViewsCount;
            this.zru = footerViewsCount;
            i2 = footerViewsCount;
        } else if (this.zru >= getCount() - lastVisiblePosition) {
            i2 = (getCount() - lastVisiblePosition) - 1;
            this.zrt = i2;
            this.zru = i2;
        }
        if (this.zrt != count) {
        }
        obj = 1;
        if (i2 == this.zrs) {
            obj2 = obj;
        } else {
            this.zrs = i2;
            obj2 = 1;
        }
        if (obj2 != null) {
            cyF();
            i3 = GT(i);
            paddingLeft = view.getHeight();
            footerViewsCount = fk(i, i3);
            if (i == this.zrw) {
                i2 = paddingLeft;
                i3 = footerViewsCount;
            } else {
                i2 = paddingLeft - i3;
                i3 = footerViewsCount - i3;
            }
            lastVisiblePosition = this.zrF;
            lastVisiblePosition -= this.zrE;
            if (i <= i4) {
                if (i > this.zrt) {
                    i2 = (lastVisiblePosition - i3) + 0;
                }
                i2 = 0;
            } else if (i != i5) {
                if (i > this.zrt) {
                    if (i == this.zru) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                } else {
                    i2 = 0 - lastVisiblePosition;
                }
            } else if (i > this.zrt) {
                if (i != this.zru) {
                }
            }
            setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        invalidate();
        this.zsg = false;
    }

    private void cyH() {
        if (this.zrl != null) {
            this.zrl.setVisibility(8);
            if (this.zrY != null) {
                this.zrY.dN(this.zrl);
            }
            this.zrl = null;
            invalidate();
        }
    }
}
