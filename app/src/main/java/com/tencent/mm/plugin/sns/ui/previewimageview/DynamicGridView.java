package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.mm.plugin.sns.i$d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView extends WrappingGridView {
    private int fu = -1;
    private List<Long> idList = new ArrayList();
    boolean lUO = false;
    private BitmapDrawable rQB;
    private Rect rQC;
    private Rect rQD;
    private Rect rQE;
    private int rQF = 0;
    private int rQG = 0;
    private int rQH = -1;
    private int rQI = -1;
    private int rQJ = -1;
    private int rQK = -1;
    private int rQL;
    private long rQM = -1;
    private boolean rQN = false;
    private boolean rQO;
    private int rQP = 0;
    private boolean rQQ = false;
    private List<ObjectAnimator> rQR = new LinkedList();
    boolean rQS;
    boolean rQT;
    boolean rQU = true;
    private boolean rQV = true;
    private OnScrollListener rQW;
    f rQX;
    e rQY;
    private OnItemClickListener rQZ;
    private OnItemClickListener rRa = new 1(this);
    private boolean rRb;
    private Stack<a> rRc;
    private a rRd;
    private View rRe;
    d rRf = new d(this, (byte) 0);
    int rRg = -1;
    float rRh;
    float rRi;
    private float rRj;
    private float rRk;
    private OnScrollListener rRl = new 2(this);
    private int yi = 0;

    private static class a {
        List<Pair<Integer, Integer>> rRs = new Stack();

        a() {
        }

        public final void dJ(int i, int i2) {
            this.rRs.add(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public interface f {
        void bCt();
    }

    private interface h {
        void dK(int i, int i2);
    }

    private class c implements h {
        int Be;
        int Bf;
        final /* synthetic */ DynamicGridView rRm;

        private class a implements OnPreDrawListener {
            static final /* synthetic */ boolean $assertionsDisabled = (!DynamicGridView.class.desiredAssertionStatus());
            private final int Vv;
            private final int rRu;
            final /* synthetic */ c rRw;

            a(c cVar, int i, int i2) {
                this.rRw = cVar;
                this.rRu = i;
                this.Vv = i2;
            }

            public final boolean onPreDraw() {
                this.rRw.rRm.getViewTreeObserver().removeOnPreDrawListener(this);
                this.rRw.rRm.rQF = this.rRw.rRm.rQF + this.rRw.Bf;
                this.rRw.rRm.rQG = this.rRw.rRm.rQG + this.rRw.Be;
                DynamicGridView.a(this.rRw.rRm, this.rRu, this.Vv);
                new StringBuilder("id ").append(this.rRw.rRm.eZ(this.rRw.rRm.rQM));
                if (!(this.rRw.rRm.rRe == null || this.rRw.rRm.rRe == null)) {
                    if ($assertionsDisabled || this.rRw.rRm.rRe != null) {
                        this.rRw.rRm.rRe.setVisibility(0);
                        this.rRw.rRm.rRe = this.rRw.rRm.fa(this.rRw.rRm.rQM);
                        if (this.rRw.rRm.rRe != null) {
                            if ($assertionsDisabled || this.rRw.rRm.rRe != null) {
                                this.rRw.rRm.rRe.setVisibility(4);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                    throw new AssertionError();
                }
                return true;
            }
        }

        public c(DynamicGridView dynamicGridView, int i, int i2) {
            this.rRm = dynamicGridView;
            this.Be = i;
            this.Bf = i2;
        }

        public final void dK(int i, int i2) {
            this.rRm.getViewTreeObserver().addOnPreDrawListener(new a(this, i, i2));
        }
    }

    static /* synthetic */ void a(DynamicGridView dynamicGridView, int i, int i2) {
        Object obj = i2 > i ? 1 : null;
        Collection linkedList = new LinkedList();
        int min;
        View fa;
        if (obj != null) {
            for (min = Math.min(i, i2); min < Math.max(i, i2); min++) {
                fa = dynamicGridView.fa(dynamicGridView.xX(min));
                if ((min + 1) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(fa, (float) ((-fa.getWidth()) * (dynamicGridView.getColumnCount() - 1)), (float) fa.getHeight()));
                } else {
                    linkedList.add(d(fa, (float) fa.getWidth(), 0.0f));
                }
            }
        } else {
            for (min = Math.max(i, i2); min > Math.min(i, i2); min--) {
                fa = dynamicGridView.fa(dynamicGridView.xX(min));
                if ((dynamicGridView.getColumnCount() + min) % dynamicGridView.getColumnCount() == 0) {
                    linkedList.add(d(fa, (float) (fa.getWidth() * (dynamicGridView.getColumnCount() - 1)), (float) (-fa.getHeight())));
                } else {
                    linkedList.add(d(fa, (float) (-fa.getWidth()), 0.0f));
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new 10(dynamicGridView));
        animatorSet.start();
    }

    static /* synthetic */ void b(DynamicGridView dynamicGridView) {
        boolean z = (dynamicGridView.rQS || dynamicGridView.rQT) ? false : true;
        dynamicGridView.setEnabled(z);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rQW = onScrollListener;
    }

    public final void xV(int i) {
        if (this.rQV) {
            requestDisallowInterceptTouchEvent(true);
            if (bCy() && this.rQU) {
                bCu();
            }
            if (i != -1) {
                this.lUO = xW(i);
                if (this.lUO) {
                    this.rQN = true;
                }
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.rQZ = onItemClickListener;
        super.setOnItemClickListener(this.rRa);
    }

    @TargetApi(11)
    private void bCu() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || Boolean.TRUE == childAt.getTag(com.tencent.mm.plugin.sns.i.f.qBX))) {
                if (i % 2 == 0) {
                    cO(childAt);
                } else {
                    cP(childAt);
                }
                childAt.setTag(com.tencent.mm.plugin.sns.i.f.qBX, Boolean.valueOf(true));
            }
        }
    }

    @TargetApi(11)
    final void iP(boolean z) {
        for (Animator cancel : this.rQR) {
            cancel.cancel();
        }
        this.rQR.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                if (z) {
                    childAt.setRotation(0.0f);
                }
                childAt.setTag(com.tencent.mm.plugin.sns.i.f.qBX, Boolean.valueOf(false));
            }
        }
    }

    private void init(Context context) {
        super.setOnScrollListener(this.rRl);
        this.rQP = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.rQL = getResources().getDimensionPixelSize(i$d.qyK);
    }

    @TargetApi(11)
    private void cO(View view) {
        ObjectAnimator cQ = cQ(view);
        cQ.setFloatValues(new float[]{-2.0f, 2.0f});
        cQ.start();
        this.rQR.add(cQ);
    }

    @TargetApi(11)
    private void cP(View view) {
        ObjectAnimator cQ = cQ(view);
        cQ.setFloatValues(new float[]{2.0f, -2.0f});
        cQ.start();
        this.rQR.add(cQ);
    }

    @TargetApi(11)
    private ObjectAnimator cQ(View view) {
        if (!bCz()) {
            view.setLayerType(1, null);
        }
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setDuration(180);
        objectAnimator.setRepeatMode(2);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setPropertyName("rotation");
        objectAnimator.setTarget(view);
        objectAnimator.addListener(new 3(this, view));
        return objectAnimator;
    }

    private void dI(int i, int i2) {
        ((d) getAdapter()).dH(i, i2);
    }

    private int getColumnCount() {
        return ((d) getAdapter()).getColumnCount();
    }

    private void eY(long j) {
        this.idList.clear();
        int eZ = eZ(j);
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (eZ != firstVisiblePosition && ((d) getAdapter()).xS(firstVisiblePosition)) {
                this.idList.add(Long.valueOf(xX(firstVisiblePosition)));
            }
            firstVisiblePosition++;
        }
    }

    public final int eZ(long j) {
        View fa = fa(j);
        if (fa == null) {
            return -1;
        }
        return getPositionForView(fa);
    }

    public final View fa(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (adapter.getItemId(firstVisiblePosition + i) == j) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        new StringBuilder("onInterceptTouchEvent ").append(motionEvent.getAction()).append(" ").append(onInterceptTouchEvent);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.fu);
        new StringBuilder("onTouchEvent ").append(motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.rRh = motionEvent.getX();
                this.rRi = motionEvent.getY();
                this.rRg = f.a(this, motionEvent.getX(), motionEvent.getY());
                new StringBuilder("onTouchEvent ").append(motionEvent.getAction()).append(",downPos ").append(this.rRg);
                if (!this.rQS && this.rRg >= 0) {
                    d dVar = this.rRf;
                    dVar.removeMessages(1);
                    dVar.sendEmptyMessageDelayed(1, 300);
                }
                this.rQJ = -1;
                this.rQK = -1;
                this.rQH = (int) motionEvent.getX();
                this.rQI = (int) motionEvent.getY();
                this.fu = motionEvent.getPointerId(0);
                if (this.lUO && isEnabled()) {
                    layoutChildren();
                    xW(pointToPosition(this.rQH, this.rQI));
                    break;
                } else if (!isEnabled()) {
                    return false;
                }
                break;
            case 1:
                bCx();
                if (this.rRb && this.rRd != null) {
                    a aVar = this.rRd;
                    Collections.reverse(aVar.rRs);
                    if (!aVar.rRs.isEmpty()) {
                        this.rRc.push(this.rRd);
                        this.rRd = new a();
                        break;
                    }
                }
                break;
            case 2:
                this.rRh = motionEvent.getX();
                this.rRi = motionEvent.getY();
                if (this.rQN && this.fu != -1) {
                    if (this.rQK == -1 && this.rQJ == -1) {
                        this.rQJ = (int) motionEvent.getY(findPointerIndex);
                        this.rQK = (int) motionEvent.getX(findPointerIndex);
                        this.rQH = this.rQK;
                        this.rQI = this.rQJ;
                        break;
                    }
                    this.rRj = motionEvent.getRawX();
                    this.rRk = motionEvent.getRawY();
                    this.rQJ = (int) motionEvent.getY(findPointerIndex);
                    this.rQK = (int) motionEvent.getX(findPointerIndex);
                    int i = this.rQK - this.rQH;
                    this.rQC.offsetTo((i + this.rQE.left) + this.rQG, ((this.rQJ - this.rQI) + this.rQE.top) + this.rQF);
                    if (this.rQB != null) {
                        this.rQB.setBounds(this.rQC);
                    }
                    invalidate();
                    bCB();
                    this.rQO = false;
                    bCw();
                    if (this.rQY == null) {
                        return false;
                    }
                    Rect rect = new Rect(this.rQC);
                    rect.offset(0, this.rQC.height() >>> 1);
                    this.rQY.j(rect);
                    return false;
                }
                break;
            case 3:
                bCA();
                bCx();
                break;
            case 6:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.fu) {
                    bCx();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean bCv() {
        int eZ = eZ(this.rQM);
        if (eZ == -1) {
            return false;
        }
        this.rQY.xU(eZ);
        if (this.rRe == null) {
            return false;
        }
        h bVar;
        int positionForView = getPositionForView(this.rRe);
        int childCount = getChildCount() - 1;
        new StringBuilder("switch ").append(positionForView).append(",").append(childCount);
        dI(positionForView, childCount);
        if (this.rRb) {
            this.rRd.dJ(positionForView, childCount);
        }
        this.rQI = this.rQJ;
        this.rQH = this.rQK;
        if (bCy() && bCz()) {
            bVar = new b(this, 0, 0);
        } else if (bCz()) {
            bVar = new g(this, 0, 0);
        } else {
            bVar = new c(this, 0, 0);
        }
        eY(this.rQM);
        bVar.dK(positionForView, childCount);
        return true;
    }

    private boolean xW(int i) {
        if (!((d) getAdapter()).xR(i)) {
            return false;
        }
        this.rQF = 0;
        this.rQG = 0;
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt == null) {
            return false;
        }
        this.rQM = getAdapter().getItemId(i);
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        int top = childAt.getTop();
        int left = childAt.getLeft();
        Bitmap createBitmap = Bitmap.createBitmap(childAt.getWidth(), childAt.getHeight(), Config.ARGB_8888);
        childAt.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
        this.rQD = new Rect(left, top, left + width, top + height);
        this.rQC = new Rect(this.rQD.left - ((int) (((float) width) * 0.05f)), this.rQD.top - ((int) (((float) height) * 0.05f)), ((int) (((float) width) * 0.05f)) + this.rQD.right, ((int) (((float) height) * 0.05f)) + this.rQD.bottom);
        this.rQE = new Rect(this.rQC);
        bitmapDrawable.setBounds(this.rQD);
        this.rQB = bitmapDrawable;
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rQB, "bounds", new 4(this), new Object[]{this.rQC});
        ofObject.addUpdateListener(new 5(this));
        ofObject.addListener(new 6(this));
        ofObject.setDuration(10);
        ofObject.start();
        if (bCy()) {
            childAt.setVisibility(4);
        }
        eY(this.rQM);
        if (this.rQY != null) {
            this.rQY.xT(i);
        }
        return true;
    }

    private void bCw() {
        boolean z = true;
        Rect rect = this.rQC;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-this.rQP, 0);
        } else if (height2 + i < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            z = false;
        } else {
            smoothScrollBy(this.rQP, 0);
        }
        this.rQO = z;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    private void bCx() {
        this.rRf.removeMessages(1);
        final View fa = fa(this.rQM);
        Rect rect;
        if (this.rQC != null) {
            rect = new Rect(this.rQC);
            rect.offset(0, this.rQC.height() >>> 1);
        } else {
            rect = null;
        }
        if (this.rQY != null && this.rQY.k(r0) && bCv()) {
            this.rQB = null;
            bCA();
            if (this.rQX != null) {
                this.rQX.bCt();
            }
        } else if (fa == null || !(this.rQN || this.rQQ)) {
            bCA();
        } else {
            this.rQN = false;
            this.rQQ = false;
            this.rQO = false;
            this.fu = -1;
            this.rQC.set(fa.getLeft(), fa.getTop(), fa.getRight(), fa.getBottom());
            new StringBuilder("animating to  ").append(this.rQC);
            if (VERSION.SDK_INT > 11) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.rQB, "bounds", new 7(this), new Object[]{this.rQC});
                ofObject.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ DynamicGridView rRm;

                    {
                        this.rRm = r1;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.rRm.invalidate();
                    }
                });
                ofObject.addListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ DynamicGridView rRm;

                    public final void onAnimationStart(Animator animator) {
                        this.rRm.rQS = true;
                        DynamicGridView.b(this.rRm);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        this.rRm.rQS = false;
                        DynamicGridView.b(this.rRm);
                        if (!(this.rRm.rQB == null || this.rRm.rQX == null)) {
                            this.rRm.rQX.bCt();
                        }
                        this.rRm.cR(fa);
                    }
                });
                ofObject.setDuration(200);
                ofObject.start();
            } else {
                this.rQB.setBounds(this.rQC);
                invalidate();
                cR(fa);
            }
        }
        if (this.rQY != null) {
            this.rQY.bCs();
        }
    }

    private void cR(View view) {
        this.idList.clear();
        this.rQM = -1;
        view.setVisibility(0);
        this.rQB = null;
        if (bCy() && this.rQU) {
            if (this.lUO) {
                iP(false);
                bCu();
            } else {
                iP(true);
            }
        }
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
    }

    static boolean bCy() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean bCz() {
        return VERSION.SDK_INT < 21;
    }

    private void bCA() {
        View fa = fa(this.rQM);
        if (fa != null) {
            if (this.rQN) {
                cR(fa);
            }
            this.rQN = false;
            this.rQO = false;
            this.fu = -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bCB() {
        int i = this.rQJ - this.rQI;
        int i2 = this.rQK - this.rQH;
        int centerY = (this.rQD.centerY() + this.rQF) + i;
        int centerX = (this.rQD.centerX() + this.rQG) + i2;
        this.rRe = fa(this.rQM);
        if (this.rRe != null) {
            View view = null;
            float f = 0.0f;
            float f2 = 0.0f;
            Point cS = cS(this.rRe);
            for (Long longValue : this.idList) {
                float abs;
                View view2;
                View fa = fa(longValue.longValue());
                if (fa != null) {
                    Point cS2 = cS(fa);
                    Object obj = (cS2.y >= cS.y || cS2.x <= cS.x) ? null : 1;
                    if (obj == null || centerY >= fa.getBottom() || centerX <= fa.getLeft()) {
                        obj = (cS2.y >= cS.y || cS2.x >= cS.x) ? null : 1;
                        if (obj == null || centerY >= fa.getBottom() || centerX >= fa.getRight()) {
                            obj = (cS2.y <= cS.y || cS2.x <= cS.x) ? null : 1;
                            if (obj == null || centerY <= fa.getTop() || centerX <= fa.getLeft()) {
                                obj = (cS2.y <= cS.y || cS2.x >= cS.x) ? null : 1;
                                if (obj == null || centerY <= fa.getTop() || centerX >= fa.getRight()) {
                                    obj = (cS2.y >= cS.y || cS2.x != cS.x) ? null : 1;
                                    if (obj == null || centerY >= fa.getBottom() - this.rQL) {
                                        obj = (cS2.y <= cS.y || cS2.x != cS.x) ? null : 1;
                                        if (obj == null || centerY <= fa.getTop() + this.rQL) {
                                            obj = (cS2.y != cS.y || cS2.x <= cS.x) ? null : 1;
                                            if (obj == null || centerX <= fa.getLeft() + this.rQL) {
                                                obj = (cS2.y != cS.y || cS2.x >= cS.x) ? null : 1;
                                                if (obj != null) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    float abs2 = Math.abs(f.cM(fa) - f.cM(this.rRe));
                    abs = Math.abs(f.cN(fa) - f.cN(this.rRe));
                    if (abs2 >= f && abs >= f2) {
                        f2 = abs2;
                        view2 = fa;
                        view = view2;
                        f = f2;
                        f2 = abs;
                    }
                }
                abs = f2;
                f2 = f;
                view2 = view;
                view = view2;
                f = f2;
                f2 = abs;
            }
            if (view != null) {
                int positionForView = getPositionForView(this.rRe);
                int positionForView2 = getPositionForView(view);
                new StringBuilder("switch ").append(positionForView).append(",").append(positionForView2);
                d dVar = (d) getAdapter();
                if (positionForView2 != -1 && dVar.xS(positionForView) && dVar.xS(positionForView2)) {
                    h bVar;
                    dI(positionForView, positionForView2);
                    if (this.rRb) {
                        this.rRd.dJ(positionForView, positionForView2);
                    }
                    this.rQI = this.rQJ;
                    this.rQH = this.rQK;
                    if (bCy() && bCz()) {
                        bVar = new b(this, i2, i);
                    } else if (bCz()) {
                        bVar = new g(this, i2, i);
                    } else {
                        bVar = new c(this, i2, i);
                    }
                    eY(this.rQM);
                    bVar.dK(positionForView, positionForView2);
                    return;
                }
                eY(this.rQM);
            }
        }
    }

    private Point cS(View view) {
        int positionForView = getPositionForView(view);
        int columnCount = getColumnCount();
        return new Point(positionForView % columnCount, positionForView / columnCount);
    }

    private long xX(int i) {
        return getAdapter().getItemId(i);
    }

    @TargetApi(11)
    private static AnimatorSet d(View view, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.rQB != null) {
            this.rQB.draw(canvas);
        }
    }
}
