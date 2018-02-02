package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.ae;
import android.support.v4.view.o;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.appbrand.GyroView;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView extends ListView implements OnScrollListener, b {
    private int Us = -1;
    private int Ut;
    private int Uu;
    private ValueAnimator fcO;
    private boolean hasInit = false;
    private int iN;
    private boolean isInit = true;
    private View kgl;
    private float lEa;
    private float lEb;
    private Vibrator lmg;
    private OnScrollListener ogO;
    private boolean qct = false;
    private float xVP;
    private LinkedList<FixedViewInfo> yXG = new LinkedList();
    private View yXH;
    View yXI;
    AppBrandRecentView yXJ;
    private boolean yXK = false;
    private Paint yXL;
    private Paint yXM;
    private com.tencent.mm.plugin.appbrand.widget.recentview.b yXN;
    private String yXO;
    private float yXP;
    boolean yXQ = false;
    final c<ie> yXR = new 12(this);
    private View yXS;
    private a yXT = new a(this);
    private int yXU = 0;
    private float yXV;
    private float yXW;
    private float yXX = 0.0f;
    private float yXY = 0.0f;
    private boolean yXZ;
    private boolean yYa = false;
    private boolean yYb;
    private boolean yYc = false;
    private boolean yYd = false;
    private Runnable yYe;
    private Runnable yYf = new 11(this);
    private boolean yYg = false;
    private boolean yYh = false;
    private int yYi;

    public ConversationWithAppBrandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(ListAdapter listAdapter) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
        this.yXR.ceO();
        this.lmg = (Vibrator) getContext().getSystemService("vibrator");
        this.iN = ae.a(ViewConfiguration.get(getContext()));
        this.yXL = new Paint(1);
        this.yXM = new Paint(1);
        this.yXL.setColor(getResources().getColor(R.e.bru));
        this.yXM.setColor(WebView.NIGHT_MODE_COLOR);
        this.yXM.setAlpha(0);
        this.yXM.setTextSize(getResources().getDimension(R.f.bvW));
        nj(false);
        if (g.h(d.class) != null) {
            this.yXN = ((d) g.h(d.class)).amj();
        }
        this.xVP = 100.0f * getResources().getDisplayMetrics().density;
        this.yXO = getResources().getString(R.l.dXD);
        this.yXP = this.yXM.measureText(this.yXO);
        super.setOnScrollListener(this);
        listAdapter.registerDataSetObserver(new 1(this, listAdapter));
        cwv();
        View linearLayout = new LinearLayout(getContext());
        this.yXS = new View(getContext());
        this.yXS.setLayoutParams(new LayoutParams(-1, 0));
        linearLayout.addView(this.yXS);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.e.white));
        addFooterView(linearLayout);
        super.setAdapter(listAdapter);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && nj(true) && this.isInit) {
            ne(true);
            this.isInit = false;
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[]{Integer.valueOf(configuration.orientation)});
        this.yXQ = true;
        ne(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getFirstVisiblePosition() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        switch (d) {
            case 0:
                this.Us = o.c(motionEvent, 0);
                this.Ut = (int) (motionEvent.getX() + 0.5f);
                this.Uu = (int) (motionEvent.getY() + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            case 2:
                d = o.b(motionEvent, this.Us);
                if (d < 0) {
                    return false;
                }
                boolean z;
                e = (int) (o.d(motionEvent, d) + 0.5f);
                e -= this.Ut;
                d = ((int) (o.e(motionEvent, d) + 0.5f)) - this.Uu;
                if (Math.abs(d) <= this.iN || Math.abs(d) < Math.abs(e)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && super.onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            case 5:
                this.Us = o.c(motionEvent, e);
                this.Ut = (int) (o.d(motionEvent, e) + 0.5f);
                this.Uu = (int) (o.e(motionEvent, e) + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.yXG.add(fixedViewInfo);
        if (getAdapter() != null) {
            super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(new 14(this, onItemClickListener));
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        super.setOnItemLongClickListener(new 15(this, onItemLongClickListener));
    }

    public final void clz() {
        if (getFirstVisiblePosition() > cwy() + 16) {
            setSelection(cwy() + 16);
        }
        post(new 16(this));
    }

    public final void z(long j, int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s", new Object[]{Long.valueOf(j)});
        if (nj(true)) {
            if (getFirstVisiblePosition() == 0) {
                if (!(this.yXN == null || this.yXJ == null)) {
                    this.yXN.bY(Math.max(0, this.yXJ.getCount() - 1), i);
                }
                if (j > 0) {
                    postDelayed(new 17(this), j);
                } else {
                    if (this.yXJ != null) {
                        this.yXJ.smoothScrollToPosition(0);
                    }
                    setSelection(0);
                }
                cwx();
            }
        } else if (this.yXI != null) {
            this.yXI.setVisibility(8);
        }
    }

    public final void ms(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[onDone] size:%s isAppBrandHeaderEnable:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.yXK)});
        if (nj(true)) {
            if (i == 1 && this.yXI != null) {
                ng(true);
            } else if (i > 1 && this.yXI != null) {
                ng(false);
            }
            if (this.yXI != null && this.yXI.getVisibility() == 8) {
                this.yXI.setVisibility(0);
                setSelection(getFirstVisiblePosition());
                return;
            }
            return;
        }
        x.w("MicroMsg.ConversationWithAppBrandListView", "[onDone] is disable!");
        if (this.yXI != null) {
            this.yXI.setVisibility(8);
        }
    }

    final void ne(boolean z) {
        if (this.yXS != null && nj(true)) {
            if (z) {
                postDelayed(new 18(this), 60);
            } else {
                cwu();
            }
        }
    }

    private void cwu() {
        boolean z;
        int cwy = cwy();
        LayoutParams layoutParams = (LayoutParams) this.yXS.getLayoutParams();
        int i = layoutParams.height;
        int count = getAdapter() == null ? 0 : getAdapter().getCount();
        x.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + count + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
        float measuredHeight = (float) (getMeasuredHeight() - (((int) getResources().getDimension(R.f.bvI)) * ((count - getHeaderViewsCount()) - getFooterViewsCount())));
        x.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[]{Integer.valueOf(getHeight()), Integer.valueOf((count - getHeaderViewsCount()) - getFooterViewsCount()), Float.valueOf(measuredHeight)});
        if (measuredHeight < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + z);
        if (z) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = (int) measuredHeight;
            if (this.isInit) {
                post(new Runnable(this) {
                    final /* synthetic */ ConversationWithAppBrandListView yYl;

                    {
                        this.yYl = r1;
                    }

                    public final void run() {
                        this.yYl.setSelection(0);
                    }
                });
            }
        }
        if (i != layoutParams.height) {
            this.yXS.setLayoutParams(layoutParams);
            if (!this.isInit) {
                super.setSelection(cwy);
            }
        }
    }

    private void nf(boolean z) {
        if (z) {
            ag.K(this.yXT);
            return;
        }
        ag.K(this.yXT);
        ag.h(this.yXT, 1000);
    }

    private void ng(boolean z) {
        int i = 0;
        x.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[]{Boolean.valueOf(z)});
        if (this.kgl != null) {
            this.kgl.setVisibility(z ? 0 : 8);
        }
        if (this.yXI != null) {
            View findViewById = this.yXI.findViewById(R.h.bKN);
            if (findViewById != null) {
                if (z) {
                    i = 4;
                }
                findViewById.setVisibility(i);
            }
        }
    }

    private void cwv() {
        this.yXH = v.fv(getContext()).inflate(R.i.bKL, null);
        this.yXI = this.yXH.findViewById(R.h.bKM);
        this.yXI.setVisibility(8);
        this.kgl = this.yXI.findViewById(R.h.ceq);
        this.yXH.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        ViewGroup viewGroup = (ViewGroup) this.yXH.findViewById(R.h.bKN);
        if (g.h(d.class) != null) {
            this.yXJ = ((d) g.h(d.class)).y(getContext(), d.b.kfI);
            this.yXU = this.yXJ.getLayoutParams().height;
            this.yXJ.kfc = this;
            this.yXJ.refresh();
            viewGroup.addView(this.yXJ);
            viewGroup.setTranslationY(-(this.xVP - (((float) this.yXU) - getResources().getDimension(R.f.bwc))));
            this.yXJ.fm().a(new 20(this));
            this.yXJ.a(new 2(this));
            this.yXJ.a(new 3(this));
            this.yXG.remove(this.yXH);
            FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
            fixedViewInfo.view = this.yXH;
            fixedViewInfo.data = null;
            fixedViewInfo.isSelectable = true;
            this.yXG.addFirst(fixedViewInfo);
            Iterator it = this.yXG.iterator();
            while (it.hasNext()) {
                fixedViewInfo = (FixedViewInfo) it.next();
                super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
            }
            return;
        }
        this.yXK = false;
        x.e("MicroMsg.ConversationWithAppBrandListView", "MMKernel.service(IAppBrandRecentViewService.class) is null!");
    }

    public void setSelection(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[]{Integer.valueOf(i)});
        if (i == 0 && nj(true)) {
            super.setSelection(cwy());
            if (this.yXN != null) {
                this.yXN.bY(Math.max(0, this.yXJ.getCount() - 1), 7);
                return;
            }
            return;
        }
        super.setSelection(i);
    }

    public void smoothScrollToPosition(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[]{Integer.valueOf(i)});
        if (i == 0 && nj(true)) {
            super.smoothScrollToPosition(cwy());
        } else {
            super.smoothScrollToPosition(i);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && nj(true)) {
            super.smoothScrollToPositionFromTop(cwy(), i2);
        } else {
            super.smoothScrollToPositionFromTop(i, i2);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i == 0 && nj(true)) {
            super.smoothScrollToPositionFromTop(cwy(), i2, i3);
        } else {
            super.smoothScrollToPositionFromTop(i, i2, i3);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.ogO = onScrollListener;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        if (!nj(true) || getFirstVisiblePosition() != 0 || i2 >= 0) {
            return super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        iArr[1] = (int) (((float) i2) / 3.0f);
        super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                this.lEa = x;
                this.yXV = x;
                x = motionEvent.getY();
                this.lEb = x;
                this.yXW = x;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            return dispatchTouchEvent;
        } finally {
            this.lEa = motionEvent.getX();
            this.lEb = motionEvent.getY();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!nj(true)) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            if (getFirstVisiblePosition() != 0) {
                this.yYg = true;
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if (childAt == null) {
                return true;
            }
            if (Math.abs(motionEvent.getX() - this.lEa) < 3.0f && Math.abs(motionEvent.getY() - this.lEb) < 3.0f) {
                super.onTouchEvent(motionEvent);
            }
            if (cww() < 60.0f * getResources().getDisplayMetrics().density) {
                float abs = Math.abs(motionEvent.getX() - this.yXV) - Math.abs(motionEvent.getY() - this.yXW);
                if ((motionEvent.getY() - this.yXW < 0.0f && abs < 0.0f && getFirstVisiblePosition() == 0) || (childAt.getBottom() > 0 && ((float) childAt.getBottom()) < this.xVP)) {
                    Gr(4);
                } else if (((float) childAt.getBottom()) >= this.xVP && motionEvent.getY() - this.yXW > 0.0f) {
                    Gq(250);
                }
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            nf(true);
            this.yXZ = false;
            if (cww() > 0.0f) {
                Gq(250);
            }
        }
        if (!L(motionEvent)) {
            if (this.yXZ && motionEvent.getAction() == 2) {
                motionEvent.setAction(0);
                super.onTouchEvent(motionEvent);
                motionEvent.setAction(2);
                this.yXZ = false;
            }
            return super.onTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 0) {
            super.onTouchEvent(motionEvent);
            return true;
        } else if (motionEvent.getAction() == 2 && !this.yXZ && Math.abs(motionEvent.getY() - this.lEb) > 2.0f) {
            motionEvent.setAction(3);
            super.onTouchEvent(motionEvent);
            this.yXZ = true;
            return true;
        } else if (this.yXZ) {
            return true;
        } else {
            super.onTouchEvent(motionEvent);
            return true;
        }
    }

    private boolean L(MotionEvent motionEvent) {
        int i = 0;
        if (!cwz()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.yXY = motionEvent.getY();
            if (this.fcO != null) {
                this.fcO.cancel();
            }
        } else if (motionEvent.getActionMasked() == 5) {
            this.yXY = motionEvent.getY();
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.yXH.getTop() == 0 && cww() != 0.0f) {
            nh(true);
            this.yYa = false;
            x.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180)});
            if (cwz()) {
                if (this.fcO != null) {
                    this.fcO.cancel();
                }
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{cww() + 0.0f, 0.0f});
                String str = "headerDeltaY";
                float[] fArr = new float[2];
                View childAt = getChildAt(0);
                fArr[0] = (childAt == null ? 0.0f : childAt.getTranslationY()) + 0.0f;
                fArr[1] = 0.0f;
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(str, fArr);
                this.fcO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                this.fcO.setDuration(180);
                this.fcO.addUpdateListener(new 5(this));
                this.fcO.addListener(new AnimatorListener(this) {
                    final /* synthetic */ ConversationWithAppBrandListView yYl;

                    {
                        this.yYl = r1;
                    }

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        this.yYl.cwx();
                    }

                    public final void onAnimationCancel(Animator animator) {
                        this.yYl.cwx();
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                this.fcO.setStartDelay(0);
                this.fcO.start();
            }
        }
        try {
            if (!(motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.lEb) > 2.0f && getFirstVisiblePosition() == 0 && this.yXH.getTop() == 0) && cww() == 0.0f) {
                this.yXY = motionEvent.getY();
                return false;
            }
            nf(true);
            if (((float) ((getHeight() - this.yXU) / 2)) <= this.yXX) {
                nh(false);
            } else {
                nh(true);
            }
            float height = (float) (getHeight() - this.yXU);
            this.yXX = ((motionEvent.getY() - this.yXY) * 0.4f) + this.yXX;
            if (this.yXX < 0.0f) {
                this.yXX = 0.0f;
                cwx();
                invalidate();
                return false;
            }
            if (height < this.yXX) {
                this.yXX = height;
            }
            while (i < getChildCount()) {
                if (i == 0) {
                    getChildAt(i).setTranslationY(this.yXX * 0.5f);
                } else {
                    getChildAt(i).setTranslationY(this.yXX);
                }
                i++;
            }
            invalidate();
            this.yXY = motionEvent.getY();
            return true;
        } finally {
            this.yXY = motionEvent.getY();
        }
    }

    private void Gq(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[openAppBrandRecentView] isOpenAppBrandRecentView:%s isHeadsetPluged:%s", new Object[]{Boolean.valueOf(this.yYb), Boolean.valueOf(ar.Hh().xR())});
        if (!this.yYb) {
            com.tencent.mm.sdk.platformtools.ar.a(getContext(), R.l.dEa, com.tencent.mm.sdk.platformtools.ar.b.xhl, 3, false, null);
            if (!(this.yXN == null || this.yXJ == null)) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.yXN;
                int max = Math.max(0, this.yXJ.getCount() - 1);
                bVar.kfe = System.currentTimeMillis() / 1000;
                bVar.kff = max;
            }
        }
        if (this.yXQ && this.yXJ != null) {
            this.yXJ.fm().UR.notifyChanged();
            this.yXQ = true;
        }
        super.smoothScrollToPositionFromTop(0, 0, i);
        nf(true);
        this.yYb = true;
    }

    private void Gr(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[]{Boolean.valueOf(this.yYb), Integer.valueOf(i)});
        if (!(!this.yYb || getChildAt(0) == null || this.yXN == null || this.yXJ == null)) {
            this.yXN.bY(Math.max(0, this.yXJ.getCount() - 1), i);
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if ((childAt == null ? 0 : childAt.getBottom()) != 0) {
                smoothScrollToPositionFromTop(cwy(), 0, 150);
            }
        }
        cwx();
        nf(true);
        this.yYb = false;
    }

    private float cww() {
        View childAt = getChildAt(1);
        return childAt == null ? 0.0f : childAt.getTranslationY();
    }

    private void cwx() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setTranslationY(0.0f);
        }
        this.yXX = 0.0f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getFirstVisiblePosition() == 0 && this.yXH != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) this.yXH.getBottom()) + this.yXX, this.yXL);
            if (getChildAt(1) != null) {
                int i = (getHeight() == 0 || !this.yYd) ? 0 : 1;
                if (i != 0) {
                    canvas.drawText(this.yXO, (((float) getWidth()) - this.yXP) / 2.0f, (((float) this.yXH.getBottom()) + this.yXX) - getResources().getDimension(R.f.bvy), this.yXM);
                }
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.ogO != null) {
            this.ogO.onScrollStateChanged(absListView, i);
        }
        if (getFirstVisiblePosition() != 0 && i == 2 && !this.yYc) {
            this.qct = true;
        }
    }

    private void nh(boolean z) {
        if (z && this.yYe != null) {
            ag.K(this.yYe);
            this.yYe = null;
            if (this.yYd) {
                ni(false);
            }
        } else if (!z && this.yYe == null) {
            Runnable 7 = new 7(this);
            this.yYe = 7;
            ag.h(7, 3000);
        }
    }

    private void ni(boolean z) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.yYd = true;
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 77});
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.setDuration(200);
            ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ConversationWithAppBrandListView yYl;

                {
                    this.yYl = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.yYl.yXM.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                    this.yYl.invalidate();
                }
            });
            ofPropertyValuesHolder.start();
            if (this.yXN != null) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.yXN;
                bVar.kfk++;
                return;
            }
            return;
        }
        ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{77, 0});
        ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.addUpdateListener(new 9(this));
        ofPropertyValuesHolder.addListener(new 10(this));
        ofPropertyValuesHolder.start();
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ogO != null) {
            this.ogO.onScroll(absListView, i, i2, i3);
        }
        if (nj(true)) {
            float bottom;
            if (i == 0) {
                nf(false);
                View childAt = absListView.getChildAt(0);
                if (childAt != null && childAt.getId() == R.h.bKL) {
                    View findViewById = childAt.findViewById(R.h.bKM);
                    if (findViewById != null && findViewById.getVisibility() != 8) {
                        View findViewById2 = childAt.findViewById(R.h.bKN);
                        GyroView gyroView = (GyroView) childAt.findViewById(R.h.cod);
                        float dimension = this.xVP - (((float) this.yXU) - getResources().getDimension(R.f.bwc));
                        float dimension2 = (this.xVP - (((float) this.yXU) - getResources().getDimension(R.f.bwc))) - getResources().getDimension(R.f.bvt);
                        if (childAt.getBottom() <= 3) {
                            findViewById2.setTranslationY(-dimension);
                            this.kgl.setTranslationY(-dimension2);
                            if (gyroView.getVisibility() == 0) {
                                gyroView.aC(0.0f);
                                gyroView.setVisibility(8);
                            }
                            this.yYh = false;
                        }
                        if (childAt.getBottom() > 3 && ((float) childAt.getBottom()) <= this.xVP && findViewById2.getTranslationY() != 0.0f) {
                            if (gyroView.getVisibility() == 8) {
                                gyroView.setVisibility(0);
                            }
                            gyroView.setAlpha(1.0f);
                            gyroView.setTranslationY((float) (((-childAt.getBottom()) / 2) + (gyroView.getHeight() / 2)));
                            gyroView.aC((float) childAt.getBottom());
                        } else if (((float) childAt.getBottom()) > this.xVP && findViewById2.getTranslationY() != 0.0f) {
                            bottom = (float) ((1.0d * ((double) (((float) childAt.getBottom()) - this.xVP))) / ((double) (((float) this.yXU) - this.xVP)));
                            findViewById2.setTranslationY((-dimension) * (1.0f - bottom));
                            this.kgl.setTranslationY((-dimension2) * (1.0f - bottom));
                            gyroView.setTranslationY((((-this.xVP) / 2.0f) + ((float) (gyroView.getHeight() / 2))) + (((this.xVP / 2.0f) + ((float) gyroView.getHeight())) * bottom));
                            gyroView.setAlpha(1.0f - (2.0f * bottom));
                            if (!(this.yYh || 1.0f == bottom)) {
                                this.lmg.vibrate(10);
                                this.yYh = true;
                            }
                            nf(true);
                        }
                    } else {
                        return;
                    }
                }
            }
            if (this.yXH != null) {
                ViewGroup viewGroup = (ViewGroup) this.yXH.findViewById(R.h.bKN);
                bottom = this.xVP - (((float) this.yXU) - getResources().getDimension(R.f.bwc));
                float dimension3 = (this.xVP - (((float) this.yXU) - getResources().getDimension(R.f.bwc))) - getResources().getDimension(R.f.bvt);
                if (!(viewGroup == null || viewGroup.getTranslationY() == bottom)) {
                    viewGroup.setTranslationY(-bottom);
                }
                this.kgl.setTranslationY(-dimension3);
            }
            if (this.yYi == 0 && i != 0) {
                Gr(4);
                nh(true);
                nf(true);
            }
            this.yYi = i;
            if (this.yYg && this.qct && i == 0) {
                x.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
                smoothScrollBy(0, 0);
                post(new 13(this));
                this.yYg = false;
            }
            ag.K(this.yYf);
            ag.h(this.yYf, 50);
        }
    }

    public final int cwy() {
        Iterator it = this.yXG.iterator();
        int i = 0;
        while (it.hasNext()) {
            FixedViewInfo fixedViewInfo = (FixedViewInfo) it.next();
            if (fixedViewInfo.view == this.yXH) {
                i++;
            } else {
                if (fixedViewInfo.view != null && (fixedViewInfo.view instanceof ViewGroup)) {
                    View childAt = ((ViewGroup) fixedViewInfo.view).getChildAt(0);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        x.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                }
                i++;
            }
        }
        x.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[]{Integer.valueOf(i)});
        return i;
    }

    final boolean nj(boolean z) {
        if (!((this.hasInit && z) || g.h(d.class) == null)) {
            g.h(d.class);
            this.yXK = true;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[]{Boolean.valueOf(this.yXK)});
            this.hasInit = true;
        }
        return this.yXK;
    }

    private boolean cwz() {
        if (this.yXI == null) {
            return false;
        }
        if (nj(true) && this.yXI.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
