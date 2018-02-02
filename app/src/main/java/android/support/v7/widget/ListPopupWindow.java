package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ai;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.k;
import android.support.v4.widget.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow {
    private static Method SI;
    private static Method SJ;
    private ListAdapter FP;
    public int Mh;
    public int PV;
    private int RL;
    public PopupWindow SK;
    public a SL;
    public int SM;
    int SN;
    int SO;
    private int SP;
    boolean SQ;
    private boolean SR;
    private boolean SS;
    int ST;
    private View SU;
    int SV;
    public View SW;
    private Drawable SX;
    public OnItemClickListener SY;
    private OnItemSelectedListener SZ;
    private final g Ta;
    private final f Tb;
    private final e Tc;
    private final c Td;
    private Runnable Te;
    private boolean Tf;
    private Rect ey;
    private Context mContext;
    private final Handler mHandler;
    private DataSetObserver mObserver;

    public static abstract class b implements OnTouchListener {
        private final float Tm;
        private final int Tn;
        private final int To;
        private final View Tp;
        private Runnable Tq;
        private Runnable Tr;
        private boolean Ts;
        private boolean Tt;
        private final int[] Tu = new int[2];
        private int fu;

        private class a implements Runnable {
            final /* synthetic */ b Tv;

            private a(b bVar) {
                this.Tv = bVar;
            }

            public final void run() {
                this.Tv.Tp.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class b implements Runnable {
            final /* synthetic */ b Tv;

            private b(b bVar) {
                this.Tv = bVar;
            }

            public final void run() {
                b.b(this.Tv);
            }
        }

        public abstract ListPopupWindow dp();

        static /* synthetic */ void b(b bVar) {
            bVar.fg();
            View view = bVar.Tp;
            if (view.isEnabled() && !view.isLongClickable() && bVar.dq()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                bVar.Ts = true;
                bVar.Tt = true;
            }
        }

        public b(View view) {
            this.Tp = view;
            this.Tm = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.Tn = ViewConfiguration.getTapTimeout();
            this.To = (this.Tn + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean l;
            boolean z = this.Ts;
            if (z) {
                l = this.Tt ? l(motionEvent) : l(motionEvent) || !eb();
            } else {
                View view2 = this.Tp;
                if (view2.isEnabled()) {
                    switch (o.d(motionEvent)) {
                        case 0:
                            this.fu = motionEvent.getPointerId(0);
                            this.Tt = false;
                            if (this.Tq == null) {
                                this.Tq = new a();
                            }
                            view2.postDelayed(this.Tq, (long) this.Tn);
                            if (this.Tr == null) {
                                this.Tr = new b();
                            }
                            view2.postDelayed(this.Tr, (long) this.To);
                        case 1:
                        case 3:
                            fg();
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.fu);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f = this.Tm;
                                l = x >= (-f) && y >= (-f) && x < ((float) (view2.getRight() - view2.getLeft())) + f && y < ((float) (view2.getBottom() - view2.getTop())) + f;
                                if (!l) {
                                    fg();
                                    view2.getParent().requestDisallowInterceptTouchEvent(true);
                                    l = true;
                                    break;
                                }
                            }
                            break;
                    }
                }
                l = false;
                boolean z2 = l && dq();
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.Tp.onTouchEvent(obtain);
                    obtain.recycle();
                }
                l = z2;
            }
            this.Ts = l;
            if (l || z) {
                return true;
            }
            return false;
        }

        public boolean dq() {
            ListPopupWindow dp = dp();
            if (!(dp == null || dp.SK.isShowing())) {
                dp.show();
            }
            return true;
        }

        protected boolean eb() {
            ListPopupWindow dp = dp();
            if (dp != null && dp.SK.isShowing()) {
                dp.dismiss();
            }
            return true;
        }

        private void fg() {
            if (this.Tr != null) {
                this.Tp.removeCallbacks(this.Tr);
            }
            if (this.Tq != null) {
                this.Tp.removeCallbacks(this.Tq);
            }
        }

        private boolean l(MotionEvent motionEvent) {
            View view = this.Tp;
            ListPopupWindow dp = dp();
            if (dp == null || !dp.SK.isShowing()) {
                return false;
            }
            View a = dp.SL;
            if (a == null || !a.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            int[] iArr = this.Tu;
            view.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
            int[] iArr2 = this.Tu;
            a.getLocationOnScreen(iArr2);
            obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
            boolean h = a.h(obtainNoHistory, this.fu);
            obtainNoHistory.recycle();
            int d = o.d(motionEvent);
            boolean z;
            if (d == 1 || d == 3) {
                z = false;
            } else {
                z = true;
            }
            if (h && r2) {
                return true;
            }
            return false;
        }
    }

    private class c implements Runnable {
        final /* synthetic */ ListPopupWindow Tg;

        private c(ListPopupWindow listPopupWindow) {
            this.Tg = listPopupWindow;
        }

        public final void run() {
            this.Tg.clearListSelection();
        }
    }

    private class d extends DataSetObserver {
        final /* synthetic */ ListPopupWindow Tg;

        private d(ListPopupWindow listPopupWindow) {
            this.Tg = listPopupWindow;
        }

        public final void onChanged() {
            if (this.Tg.SK.isShowing()) {
                this.Tg.show();
            }
        }

        public final void onInvalidated() {
            this.Tg.dismiss();
        }
    }

    private class e implements OnScrollListener {
        final /* synthetic */ ListPopupWindow Tg;

        private e(ListPopupWindow listPopupWindow) {
            this.Tg = listPopupWindow;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.Tg.isInputMethodNotNeeded() && this.Tg.SK.getContentView() != null) {
                this.Tg.mHandler.removeCallbacks(this.Tg.Ta);
                this.Tg.Ta.run();
            }
        }
    }

    private class f implements OnTouchListener {
        final /* synthetic */ ListPopupWindow Tg;

        private f(ListPopupWindow listPopupWindow) {
            this.Tg = listPopupWindow;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.Tg.SK != null && this.Tg.SK.isShowing() && x >= 0 && x < this.Tg.SK.getWidth() && y >= 0 && y < this.Tg.SK.getHeight()) {
                this.Tg.mHandler.postDelayed(this.Tg.Ta, 250);
            } else if (action == 1) {
                this.Tg.mHandler.removeCallbacks(this.Tg.Ta);
            }
            return false;
        }
    }

    private class g implements Runnable {
        final /* synthetic */ ListPopupWindow Tg;

        private g(ListPopupWindow listPopupWindow) {
            this.Tg = listPopupWindow;
        }

        public final void run() {
            if (this.Tg.SL != null && z.ak(this.Tg.SL) && this.Tg.SL.getCount() > this.Tg.SL.getChildCount() && this.Tg.SL.getChildCount() <= this.Tg.ST) {
                this.Tg.SK.setInputMethodMode(2);
                this.Tg.show();
            }
        }
    }

    private static class a extends ListViewCompat {
        private boolean Th;
        private boolean Ti;
        private boolean Tj;
        private ai Tk;
        private k Tl;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
            this.Ti = z;
            setCacheColorHint(0);
        }

        public final boolean h(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            View childAt;
            int d = o.d(motionEvent);
            switch (d) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                    float f = (float) x;
                    float f2 = (float) findPointerIndex;
                    this.Tj = true;
                    if (VERSION.SDK_INT >= 21) {
                        drawableHotspotChanged(f, f2);
                    }
                    if (!isPressed()) {
                        setPressed(true);
                    }
                    layoutChildren();
                    if (this.TC != -1) {
                        childAt = getChildAt(this.TC - getFirstVisiblePosition());
                        if (!(childAt == null || childAt == childAt2 || !childAt.isPressed())) {
                            childAt.setPressed(false);
                        }
                    }
                    this.TC = pointToPosition;
                    float left = f - ((float) childAt2.getLeft());
                    float top = f2 - ((float) childAt2.getTop());
                    if (VERSION.SDK_INT >= 21) {
                        childAt2.drawableHotspotChanged(left, top);
                    }
                    if (!childAt2.isPressed()) {
                        childAt2.setPressed(true);
                    }
                    Drawable selector = getSelector();
                    if (selector == null || pointToPosition == -1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        selector.setVisible(false, false);
                    }
                    super.a(pointToPosition, childAt2);
                    if (z) {
                        Rect rect = this.Tx;
                        float exactCenterX = rect.exactCenterX();
                        float exactCenterY = rect.exactCenterY();
                        if (getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        selector.setVisible(z, false);
                        android.support.v4.b.a.a.a(selector, exactCenterX, exactCenterY);
                    }
                    Drawable selector2 = getSelector();
                    if (!(selector2 == null || pointToPosition == -1)) {
                        android.support.v4.b.a.a.a(selector2, f, f2);
                    }
                    P(false);
                    refreshDrawableState();
                    if (d == 1) {
                        performItemClick(childAt2, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                this.Tj = false;
                setPressed(false);
                drawableStateChanged();
                childAt = getChildAt(this.TC - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                if (this.Tk != null) {
                    this.Tk.cancel();
                    this.Tk = null;
                }
            }
            if (z2) {
                if (this.Tl == null) {
                    this.Tl = new k(this);
                }
                this.Tl.r(true);
                this.Tl.onTouch(this, motionEvent);
            } else if (this.Tl != null) {
                this.Tl.r(false);
            }
            return z2;
        }

        protected final boolean ff() {
            return this.Tj || super.ff();
        }

        public final boolean isInTouchMode() {
            return (this.Ti && this.Th) || super.isInTouchMode();
        }

        public final boolean hasWindowFocus() {
            return this.Ti || super.hasWindowFocus();
        }

        public final boolean isFocused() {
            return this.Ti || super.isFocused();
        }

        public final boolean hasFocus() {
            return this.Ti || super.hasFocus();
        }
    }

    static {
        try {
            SI = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            SJ = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.SM = -2;
        this.PV = -2;
        this.SP = 1002;
        this.Mh = 0;
        this.SR = false;
        this.SS = false;
        this.ST = Integer.MAX_VALUE;
        this.SV = 0;
        this.Ta = new g();
        this.Tb = new f();
        this.Tc = new e();
        this.Td = new c();
        this.ey = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.k.ListPopupWindow, i, i2);
        this.SN = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.SO = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.SO != 0) {
            this.SQ = true;
        }
        obtainStyledAttributes.recycle();
        this.SK = new AppCompatPopupWindow(context, attributeSet, i);
        this.SK.setInputMethodMode(1);
        this.RL = android.support.v4.d.f.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new d();
        } else if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.mObserver);
        }
        this.FP = listAdapter;
        if (this.FP != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.SL != null) {
            this.SL.setAdapter(this.FP);
        }
    }

    public final void setModal(boolean z) {
        this.Tf = z;
        this.SK.setFocusable(z);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.SK.setBackgroundDrawable(drawable);
    }

    public final void setVerticalOffset(int i) {
        this.SO = i;
        this.SQ = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.SK.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            this.PV = (this.ey.left + this.ey.right) + i;
            return;
        }
        this.PV = i;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        LayoutParams layoutParams;
        View view;
        if (this.SL == null) {
            Context context = this.mContext;
            this.Te = new Runnable(this) {
                final /* synthetic */ ListPopupWindow Tg;

                {
                    this.Tg = r1;
                }

                public final void run() {
                    View view = this.Tg.SW;
                    if (view != null && view.getWindowToken() != null) {
                        this.Tg.show();
                    }
                }
            };
            this.SL = new a(context, !this.Tf);
            if (this.SX != null) {
                this.SL.setSelector(this.SX);
            }
            this.SL.setAdapter(this.FP);
            this.SL.setOnItemClickListener(this.SY);
            this.SL.setFocusable(true);
            this.SL.setFocusableInTouchMode(true);
            this.SL.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ ListPopupWindow Tg;

                {
                    this.Tg = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = this.Tg.SL;
                        if (a != null) {
                            a.Th = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.SL.setOnScrollListener(this.Tc);
            if (this.SZ != null) {
                this.SL.setOnItemSelectedListener(this.SZ);
            }
            View view2 = this.SL;
            View view3 = this.SU;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.SV) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.SV);
                        break;
                }
                if (this.PV >= 0) {
                    i = this.PV;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.SK.setContentView(view);
        } else {
            this.SK.getContentView();
            view = this.SU;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.SK.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            i = this.ey.top + this.ey.bottom;
            if (!this.SQ) {
                this.SO = -this.ey.top;
            }
        } else {
            this.ey.setEmpty();
            i = 0;
        }
        if (this.SK.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int b = b(this.SW, this.SO, z);
        if (this.SR || this.SM == -1) {
            i2 = b + i;
        } else {
            switch (this.PV) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ey.left + this.ey.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ey.left + this.ey.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.PV, 1073741824);
                    break;
            }
            makeMeasureSpec = this.SL.P(makeMeasureSpec, b - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i2 += makeMeasureSpec;
        }
        z = isInputMethodNotNeeded();
        m.a(this.SK, this.SP);
        if (this.SK.isShowing()) {
            if (this.PV == -1) {
                i = -1;
            } else if (this.PV == -2) {
                i = this.SW.getWidth();
            } else {
                i = this.PV;
            }
            if (this.SM == -1) {
                if (z) {
                    makeMeasureSpec = i2;
                } else {
                    makeMeasureSpec = -1;
                }
                PopupWindow popupWindow;
                if (z) {
                    popupWindow = this.SK;
                    if (this.PV == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.SK.setHeight(0);
                    b = makeMeasureSpec;
                } else {
                    popupWindow = this.SK;
                    if (this.PV == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.SK.setHeight(-1);
                    b = makeMeasureSpec;
                }
            } else if (this.SM == -2) {
                b = i2;
            } else {
                b = this.SM;
            }
            PopupWindow popupWindow2 = this.SK;
            if (this.SS || this.SR) {
                z2 = false;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.SK;
            View view4 = this.SW;
            int i3 = this.SN;
            makeMeasureSpec = this.SO;
            if (i < 0) {
                i = -1;
            }
            if (b < 0) {
                b = -1;
            }
            popupWindow2.update(view4, i3, makeMeasureSpec, i, b);
            return;
        }
        if (this.PV == -1) {
            makeMeasureSpec = -1;
        } else if (this.PV == -2) {
            makeMeasureSpec = this.SW.getWidth();
        } else {
            makeMeasureSpec = this.PV;
        }
        if (this.SM == -1) {
            i2 = -1;
        } else if (this.SM != -2) {
            i2 = this.SM;
        }
        this.SK.setWidth(makeMeasureSpec);
        this.SK.setHeight(i2);
        if (SI != null) {
            try {
                SI.invoke(this.SK, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
        popupWindow2 = this.SK;
        if (this.SS || this.SR) {
            z2 = false;
        }
        popupWindow2.setOutsideTouchable(z2);
        this.SK.setTouchInterceptor(this.Tb);
        m.a(this.SK, this.SW, this.SN, this.SO, this.Mh);
        this.SL.setSelection(-1);
        if (!this.Tf || this.SL.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Tf) {
            this.mHandler.post(this.Td);
        }
    }

    public final void dismiss() {
        this.SK.dismiss();
        if (this.SU != null) {
            ViewParent parent = this.SU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.SU);
            }
        }
        this.SK.setContentView(null);
        this.SL = null;
        this.mHandler.removeCallbacks(this.Ta);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.SK.setOnDismissListener(onDismissListener);
    }

    public final void fe() {
        this.SK.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.SL;
        if (aVar != null) {
            aVar.Th = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.SK.getInputMethodMode() == 2;
    }

    private int b(View view, int i, boolean z) {
        if (SJ != null) {
            try {
                return ((Integer) SJ.invoke(this.SK, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.SK.getMaxAvailableHeight(view, i);
    }
}
