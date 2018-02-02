package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.b;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.xwalk.core.R$styleable;

public class ViewPager extends ViewGroup {
    private static final Comparator<b> yB = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).position - ((b) obj2).position;
        }
    };
    private static final Interpolator yC = new 2();
    private static final int[] yz = new int[]{16842931};
    private static final i zv = new i();
    private final ArrayList<b> ep = new ArrayList();
    private final Rect ey = new Rect();
    private VelocityTracker ft;
    private int fu = -1;
    private boolean iL;
    private int iN;
    private boolean mInLayout;
    private float xP;
    private float xQ;
    private int yA;
    private final b yD = new b();
    public u yE;
    public int yF;
    private int yG = -1;
    private Parcelable yH = null;
    private ClassLoader yI = null;
    private Scroller yJ;
    private boolean yK;
    private g yL;
    private int yM;
    private Drawable yN;
    private int yO;
    private int yP;
    private float yQ = -3.4028235E38f;
    private float yR = Float.MAX_VALUE;
    private int yS;
    private int yT;
    private boolean yU;
    private boolean yV;
    public int yW = 1;
    private boolean yX;
    private int yY;
    private int yZ;
    private int yi = 0;
    private float za;
    private float zb;
    private int zc;
    private int zd;
    private int ze;
    private int zf;
    private boolean zg;
    private i zh;
    private i zi;
    private boolean zj = true;
    private boolean zk = false;
    private boolean zl;
    private int zm;
    public List<e> zn;
    public e zo;
    private e zp;
    d zq;
    private f zr;
    private int zt;
    private ArrayList<View> zu;
    private final Runnable zw = new Runnable(this) {
        final /* synthetic */ ViewPager zx;

        {
            this.zx = r1;
        }

        public final void run() {
            this.zx.ag(0);
            this.zx.populate();
        }
    };

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = b.a(new 1());
        int position;
        Parcelable zE;
        ClassLoader zF;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.zE, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.zE = parcel.readParcelable(classLoader);
            this.zF = classLoader;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.yJ = new Scroller(context2, yC);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.iN = ae.a(viewConfiguration);
        this.zc = (int) (400.0f * f);
        this.zd = viewConfiguration.getScaledMaximumFlingVelocity();
        this.zh = new i(context2);
        this.zi = new i(context2);
        this.ze = (int) (25.0f * f);
        this.zf = (int) (2.0f * f);
        this.yY = (int) (16.0f * f);
        z.a(this, new c(this));
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        z.b(this, new 4(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.zw);
        if (!(this.yJ == null || this.yJ.isFinished())) {
            this.yJ.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void ag(int i) {
        int i2 = 0;
        if (this.yi != i) {
            this.yi = i;
            if (this.zr != null) {
                int i3 = i != 0 ? 1 : 0;
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    z.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.zo != null) {
                this.zo.af(i);
            }
            if (this.zn != null) {
                int size = this.zn.size();
                while (i2 < size) {
                    e eVar = (e) this.zn.get(i2);
                    if (eVar != null) {
                        eVar.af(i);
                    }
                    i2++;
                }
            }
            if (this.zp != null) {
                this.zp.af(i);
            }
        }
    }

    public final void a(u uVar) {
        if (this.yE != null) {
            int i;
            this.yE.a(null);
            for (i = 0; i < this.ep.size(); i++) {
                b bVar = (b) this.ep.get(i);
                this.yE.a(this, bVar.position, bVar.object);
            }
            this.yE.aX();
            this.ep.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).zB) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.yF = 0;
            scrollTo(0, 0);
        }
        u uVar2 = this.yE;
        this.yE = uVar;
        this.yA = 0;
        if (this.yE != null) {
            if (this.yL == null) {
                this.yL = new g(this, (byte) 0);
            }
            this.yE.a(this.yL);
            this.yV = false;
            boolean z = this.zj;
            this.zj = true;
            this.yA = this.yE.getCount();
            if (this.yG >= 0) {
                this.yE.a(this.yH, this.yI);
                a(this.yG, false, true);
                this.yG = -1;
                this.yH = null;
                this.yI = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.zq != null && uVar2 != uVar) {
            this.zq.b(uVar2, uVar);
        }
    }

    private int bQ() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void ah(int i) {
        boolean z;
        this.yV = false;
        if (this.zj) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void d(int i, boolean z) {
        this.yV = false;
        a(i, z, false);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    private void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.yE == null || this.yE.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.yF != i || this.ep.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.yE.getCount()) {
                i = this.yE.getCount() - 1;
            }
            int i3 = this.yW;
            if (i > this.yF + i3 || i < this.yF - i3) {
                for (int i4 = 0; i4 < this.ep.size(); i4++) {
                    ((b) this.ep.get(i4)).zy = true;
                }
            }
            if (this.yF != i) {
                z3 = true;
            }
            if (this.zj) {
                this.yF = i;
                if (z3) {
                    al(i);
                }
                requestLayout();
                return;
            }
            ai(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int bQ;
        b aj = aj(i);
        if (aj != null) {
            bQ = (int) (((float) bQ()) * Math.max(this.yQ, Math.min(aj.zA, this.yR)));
        } else {
            bQ = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.yJ == null || this.yJ.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.yK ? this.yJ.getCurrX() : this.yJ.getStartX();
                    this.yJ.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                bQ -= i3;
                int i4 = 0 - scrollY;
                if (bQ == 0 && i4 == 0) {
                    q(false);
                    populate();
                    ag(0);
                } else {
                    setScrollingCacheEnabled(true);
                    ag(2);
                    currX = bQ();
                    int i5 = currX / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(bQ))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    i5 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(bQ)) / ((((float) currX) * 1.0f) + ((float) this.yM))) + 1.0f) * 100.0f), 600);
                    this.yK = false;
                    this.yJ.startScroll(i3, scrollY, bQ, i4, i5);
                    z.E(this);
                }
            }
            if (z2) {
                al(i);
                return;
            }
            return;
        }
        if (z2) {
            al(i);
        }
        q(false);
        scrollTo(bQ, 0);
        ak(bQ);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.zt == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.zu.get(i2)).getLayoutParams()).zD;
    }

    final e a(e eVar) {
        e eVar2 = this.zp;
        this.zp = eVar;
        return eVar2;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.yN;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.yN;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private b o(int i, int i2) {
        b bVar = new b();
        bVar.position = i;
        bVar.object = this.yE.b(this, i);
        bVar.zz = 1.0f;
        if (i2 < 0 || i2 >= this.ep.size()) {
            this.ep.add(bVar);
        } else {
            this.ep.add(i2, bVar);
        }
        return bVar;
    }

    final void bR() {
        int count = this.yE.getCount();
        this.yA = count;
        boolean z = this.ep.size() < (this.yW * 2) + 1 && this.ep.size() < count;
        boolean z2 = false;
        int i = this.yF;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.ep.size()) {
            int i3;
            boolean z4;
            int max;
            boolean z5;
            b bVar = (b) this.ep.get(i2);
            int k = this.yE.k(bVar.object);
            if (k != -1) {
                if (k == -2) {
                    this.ep.remove(i2);
                    i2--;
                    if (!z2) {
                        z2 = true;
                    }
                    this.yE.a(this, bVar.position, bVar.object);
                    if (this.yF == bVar.position) {
                        i3 = i2;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.yF, count - 1));
                        z5 = true;
                    } else {
                        i3 = i2;
                        z4 = z2;
                        max = i;
                        z5 = true;
                    }
                } else if (bVar.position != k) {
                    if (bVar.position == this.yF) {
                        i = k;
                    }
                    bVar.position = k;
                    i3 = i2;
                    z4 = z2;
                    max = i;
                    z5 = true;
                }
                z3 = z5;
                i = max;
                z2 = z4;
                i2 = i3 + 1;
            }
            i3 = i2;
            z4 = z2;
            max = i;
            z5 = z3;
            z3 = z5;
            i = max;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.yE.aX();
        }
        Collections.sort(this.ep, yB);
        if (z3) {
            max = getChildCount();
            for (i2 = 0; i2 < max; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.zB) {
                    layoutParams.zz = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    public final void populate() {
        ai(this.yF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ai(int i) {
        b bVar;
        if (this.yF != i) {
            b aj = aj(this.yF);
            this.yF = i;
            bVar = aj;
        } else {
            bVar = null;
        }
        if (this.yE == null) {
            bS();
        } else if (this.yV) {
            bS();
        } else if (getWindowToken() != null) {
            int i2 = this.yW;
            int max = Math.max(0, this.yF - i2);
            int count = this.yE.getCount();
            int min = Math.min(count - 1, i2 + this.yF);
            if (count != this.yA) {
                String resourceName;
                try {
                    resourceName = getResources().getResourceName(getId());
                } catch (NotFoundException e) {
                    resourceName = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.yA + ", found: " + count + " Pager id: " + resourceName + " Pager class: " + getClass() + " Problematic adapter: " + this.yE.getClass());
            }
            b bVar2;
            b bVar3;
            int i3 = 0;
            while (i3 < this.ep.size()) {
                aj = (b) this.ep.get(i3);
                if (aj.position < this.yF) {
                    i3++;
                }
            }
            aj = null;
            if (aj != null || count <= 0) {
                bVar2 = aj;
            } else {
                bVar2 = o(this.yF, i3);
            }
            if (bVar2 != null) {
                float f;
                int i4 = i3 - 1;
                aj = i4 >= 0 ? (b) this.ep.get(i4) : null;
                int bQ = bQ();
                if (bQ <= 0) {
                    f = 0.0f;
                } else {
                    f = (2.0f - bVar2.zz) + (((float) getPaddingLeft()) / ((float) bQ));
                }
                float f2 = 0.0f;
                int i5 = this.yF - 1;
                int i6 = i4;
                i4 = i3;
                i3 = i6;
                while (i5 >= 0) {
                    if (f2 >= f && i5 < max) {
                        if (aj == null) {
                            break;
                        } else if (i5 == aj.position && !aj.zy) {
                            this.ep.remove(i3);
                            this.yE.a(this, i5, aj.object);
                            i3--;
                            i4--;
                            aj = i3 >= 0 ? (b) this.ep.get(i3) : null;
                        }
                    } else if (aj == null || i5 != aj.position) {
                        f2 += o(i5, i3 + 1).zz;
                        i4++;
                        aj = i3 >= 0 ? (b) this.ep.get(i3) : null;
                    } else {
                        f2 += aj.zz;
                        i3--;
                        aj = i3 >= 0 ? (b) this.ep.get(i3) : null;
                    }
                    i5--;
                }
                f = bVar2.zz;
                i5 = i4 + 1;
                if (f < 2.0f) {
                    float f3;
                    b bVar4 = i5 < this.ep.size() ? (b) this.ep.get(i5) : null;
                    if (bQ <= 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = (((float) getPaddingRight()) / ((float) bQ)) + 2.0f;
                    }
                    b bVar5 = bVar4;
                    int i7 = i5;
                    i5 = this.yF + 1;
                    aj = bVar5;
                    while (i5 < count) {
                        float f4;
                        float f5;
                        if (f >= f3 && i5 > min) {
                            if (aj == null) {
                                break;
                            } else if (i5 != aj.position || aj.zy) {
                                f4 = f;
                                bVar3 = aj;
                                f5 = f4;
                            } else {
                                this.ep.remove(i7);
                                this.yE.a(this, i5, aj.object);
                                if (i7 < this.ep.size()) {
                                    aj = (b) this.ep.get(i7);
                                } else {
                                    aj = null;
                                }
                                f4 = f;
                                bVar3 = aj;
                                f5 = f4;
                            }
                        } else if (aj == null || i5 != aj.position) {
                            aj = o(i5, i7);
                            i7++;
                            f4 = f + aj.zz;
                            bVar3 = i7 < this.ep.size() ? (b) this.ep.get(i7) : null;
                            f5 = f4;
                        } else {
                            i7++;
                            f4 = f + aj.zz;
                            bVar3 = i7 < this.ep.size() ? (b) this.ep.get(i7) : null;
                            f5 = f4;
                        }
                        i5++;
                        f4 = f5;
                        aj = bVar3;
                        f = f4;
                    }
                }
                a(bVar2, i4, bVar);
            }
            this.yE.e(bVar2 != null ? bVar2.object : null);
            this.yE.aX();
            i3 = getChildCount();
            for (int i8 = 0; i8 < i3; i8++) {
                View childAt = getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.zD = i8;
                if (!layoutParams.zB && layoutParams.zz == 0.0f) {
                    bVar3 = ao(childAt);
                    if (bVar3 != null) {
                        layoutParams.zz = bVar3.zz;
                        layoutParams.position = bVar3.position;
                    }
                }
            }
            bS();
            if (hasFocus()) {
                View findFocus = findFocus();
                aj = findFocus != null ? ap(findFocus) : null;
                if (aj == null || aj.position != this.yF) {
                    i2 = 0;
                    while (i2 < getChildCount()) {
                        View childAt2 = getChildAt(i2);
                        b ao = ao(childAt2);
                        if (ao == null || ao.position != this.yF || !childAt2.requestFocus(2)) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void bS() {
        if (this.zt != 0) {
            if (this.zu == null) {
                this.zu = new ArrayList();
            } else {
                this.zu.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.zu.add(getChildAt(i));
            }
            Collections.sort(this.zu, zv);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        float f;
        int i2;
        b bVar3;
        float f2;
        int i3;
        int count = this.yE.getCount();
        int bQ = bQ();
        if (bQ > 0) {
            f = ((float) this.yM) / ((float) bQ);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            bQ = bVar2.position;
            float f3;
            int i4;
            int i5;
            if (bQ < bVar.position) {
                f3 = (bVar2.zA + bVar2.zz) + f;
                i2 = 0;
                i4 = bQ + 1;
                while (i4 <= bVar.position && i2 < this.ep.size()) {
                    bVar3 = (b) this.ep.get(i2);
                    while (i4 > bVar3.position && i2 < this.ep.size() - 1) {
                        i2++;
                        bVar3 = (b) this.ep.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < bVar3.position) {
                        i3++;
                        f2 = (1.0f + f) + f2;
                    }
                    bVar3.zA = f2;
                    f2 += bVar3.zz + f;
                    bQ = i3 + 1;
                    f3 = f2;
                    i4 = bQ;
                }
            } else if (bQ > bVar.position) {
                i2 = this.ep.size() - 1;
                f3 = bVar2.zA;
                i4 = bQ - 1;
                while (i4 >= bVar.position && i2 >= 0) {
                    bVar3 = (b) this.ep.get(i2);
                    while (i4 < bVar3.position && i2 > 0) {
                        i2--;
                        bVar3 = (b) this.ep.get(i2);
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > bVar3.position) {
                        i3--;
                        f2 -= 1.0f + f;
                    }
                    f2 -= bVar3.zz + f;
                    bVar3.zA = f2;
                    bQ = i3 - 1;
                    f3 = f2;
                    i4 = bQ;
                }
            }
        }
        int size = this.ep.size();
        f2 = bVar.zA;
        i3 = bVar.position - 1;
        this.yQ = bVar.position == 0 ? bVar.zA : -3.4028235E38f;
        this.yR = bVar.position == count + -1 ? (bVar.zA + bVar.zz) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bVar3 = (b) this.ep.get(i2);
            while (i3 > bVar3.position) {
                i3--;
                f2 -= 1.0f + f;
            }
            f2 -= bVar3.zz + f;
            bVar3.zA = f2;
            if (bVar3.position == 0) {
                this.yQ = f2;
            }
            i3--;
        }
        f2 = (bVar.zA + bVar.zz) + f;
        i3 = bVar.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bVar3 = (b) this.ep.get(i2);
            while (i3 < bVar3.position) {
                i3++;
                f2 += 1.0f + f;
            }
            if (bVar3.position == count - 1) {
                this.yR = (bVar3.zz + f2) - 1.0f;
            }
            bVar3.zA = f2;
            f2 += bVar3.zz + f;
            i3++;
        }
        this.zk = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.yF;
        if (this.yE != null) {
            savedState.zE = this.yE.aY();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.yE != null) {
                this.yE.a(savedState.zE, savedState.zF);
                a(savedState.position, false, true);
                return;
            }
            this.yG = savedState.position;
            this.yH = savedState.zE;
            this.yI = savedState.zF;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.zB |= view instanceof a;
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.zB) {
            layoutParams3.zC = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private b ao(View view) {
        for (int i = 0; i < this.ep.size(); i++) {
            b bVar = (b) this.ep.get(i);
            if (this.yE.a(view, bVar.object)) {
                return bVar;
            }
        }
        return null;
    }

    private b ap(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return ao(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b aj(int i) {
        for (int i2 = 0; i2 < this.ep.size(); i2++) {
            b bVar = (b) this.ep.get(i2);
            if (bVar.position == i) {
                return bVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zj = true;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.yZ = Math.min(measuredWidth / 10, this.yY);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            LayoutParams layoutParams;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.zB) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i4 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.yS = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.yT = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.zB) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.zz * ((float) paddingLeft)), 1073741824), this.yT);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.yM;
            int i6 = this.yM;
            if (i3 <= 0 || this.ep.isEmpty()) {
                b aj = aj(this.yF);
                i5 = (int) ((aj != null ? Math.min(aj.zA, this.yR) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
                if (i5 != getScrollX()) {
                    q(false);
                    scrollTo(i5, getScrollY());
                }
            } else if (this.yJ.isFinished()) {
                scrollTo((int) (((float) (i5 + ((i - getPaddingLeft()) - getPaddingRight()))) * (((float) getScrollX()) / ((float) (i6 + ((i3 - getPaddingLeft()) - getPaddingRight()))))), getScrollY());
            } else {
                this.yJ.setFinalX(this.yF * bQ());
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.zB) {
                    int i9 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.zB) {
                    b ao = ao(childAt2);
                    if (ao != null) {
                        i5 = ((int) (ao.zA * ((float) max))) + paddingLeft;
                        if (layoutParams.zC) {
                            layoutParams.zC = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.zz * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.yO = paddingTop;
        this.yP = i6 - paddingBottom;
        this.zm = i7;
        if (this.zj) {
            a(this.yF, false, 0, false);
        }
        this.zj = false;
    }

    public void computeScroll() {
        this.yK = true;
        if (this.yJ.isFinished() || !this.yJ.computeScrollOffset()) {
            q(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.yJ.getCurrX();
        int currY = this.yJ.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!ak(currX)) {
                this.yJ.abortAnimation();
                scrollTo(0, currY);
            }
        }
        z.E(this);
    }

    private boolean ak(int i) {
        if (this.ep.size() != 0) {
            b bV = bV();
            int bQ = bQ();
            int i2 = this.yM + bQ;
            float f = ((float) this.yM) / ((float) bQ);
            int i3 = bV.position;
            float f2 = ((((float) i) / ((float) bQ)) - bV.zA) / (bV.zz + f);
            bQ = (int) (((float) i2) * f2);
            this.zl = false;
            a(i3, f2, bQ);
            if (this.zl) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.zj) {
            return false;
        } else {
            this.zl = false;
            a(0, 0.0f, 0);
            if (this.zl) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.zm > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.zB) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.zo != null) {
            this.zo.a(i, f, i2);
        }
        if (this.zn != null) {
            paddingRight = this.zn.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                e eVar = (e) this.zn.get(paddingLeft);
                if (eVar != null) {
                    eVar.a(i, f, i2);
                }
            }
        }
        if (this.zp != null) {
            this.zp.a(i, f, i2);
        }
        if (this.zr != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).zB) {
                    this.zr.h(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) bQ()));
                }
            }
        }
        this.zl = true;
    }

    private void al(int i) {
        if (this.zo != null) {
            this.zo.ae(i);
        }
        if (this.zn != null) {
            int size = this.zn.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.zn.get(i2);
                if (eVar != null) {
                    eVar.ae(i);
                }
            }
        }
        if (this.zp != null) {
            this.zp.ae(i);
        }
    }

    private void q(boolean z) {
        int scrollX;
        boolean z2 = this.yi == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.yJ.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.yJ.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.yJ.getCurrX();
                int currY = this.yJ.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        ak(currX);
                    }
                }
            }
        }
        this.yV = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.ep.size(); scrollX++) {
            b bVar = (b) this.ep.get(scrollX);
            if (bVar.zy) {
                bVar.zy = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            z.a(this, this.zw);
        } else {
            this.zw.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            bT();
            return false;
        }
        if (action != 0) {
            if (this.iL) {
                return true;
            }
            if (this.yX) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.xP = x;
                this.za = x;
                x = motionEvent.getY();
                this.xQ = x;
                this.zb = x;
                this.fu = o.c(motionEvent, 0);
                this.yX = false;
                this.yK = true;
                this.yJ.computeScrollOffset();
                if (this.yi == 2 && Math.abs(this.yJ.getFinalX() - this.yJ.getCurrX()) > this.zf) {
                    this.yJ.abortAnimation();
                    this.yV = false;
                    populate();
                    this.iL = true;
                    bU();
                    ag(1);
                    break;
                }
                q(false);
                this.iL = false;
                break;
                break;
            case 2:
                action = this.fu;
                if (action != -1) {
                    action = o.b(motionEvent, action);
                    float d = o.d(motionEvent, action);
                    float f = d - this.za;
                    float abs = Math.abs(f);
                    float e = o.e(motionEvent, action);
                    float abs2 = Math.abs(e - this.xQ);
                    if (f != 0.0f) {
                        x = this.za;
                        boolean z = (x < ((float) this.yZ) && f > 0.0f) || (x > ((float) (getWidth() - this.yZ)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) d, (int) e)) {
                            this.za = d;
                            this.zb = e;
                            this.yX = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.iN) && 0.5f * abs > abs2) {
                        this.iL = true;
                        bU();
                        ag(1);
                        this.za = f > 0.0f ? this.xP + ((float) this.iN) : this.xP - ((float) this.iN);
                        this.zb = e;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.iN)) {
                        this.yX = true;
                    }
                    if (this.iL && p(d)) {
                        z.E(this);
                        break;
                    }
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        return this.iL;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zg) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.yE == null || this.yE.getCount() == 0) {
            return false;
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.yJ.abortAnimation();
                this.yV = false;
                populate();
                x = motionEvent.getX();
                this.xP = x;
                this.za = x;
                x = motionEvent.getY();
                this.xQ = x;
                this.zb = x;
                this.fu = o.c(motionEvent, 0);
                break;
            case 1:
                if (this.iL) {
                    VelocityTracker velocityTracker = this.ft;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.zd);
                    int a = (int) y.a(velocityTracker, this.fu);
                    this.yV = true;
                    int bQ = bQ();
                    int scrollX = getScrollX();
                    b bV = bV();
                    float f2 = ((float) this.yM) / ((float) bQ);
                    i = bV.position;
                    f = ((((float) scrollX) / ((float) bQ)) - bV.zA) / (bV.zz + f2);
                    if (Math.abs((int) (o.d(motionEvent, o.b(motionEvent, this.fu)) - this.xP)) <= this.ze || Math.abs(a) <= this.zc) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.yF ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.ep.size() > 0) {
                        scrollX = Math.max(((b) this.ep.get(0)).position, Math.min(scrollX, ((b) this.ep.get(this.ep.size() - 1)).position));
                    }
                    a(scrollX, true, true, a);
                    z = bT();
                    break;
                }
                break;
            case 2:
                if (!this.iL) {
                    i = o.b(motionEvent, this.fu);
                    if (i == -1) {
                        z = bT();
                        break;
                    }
                    float d = o.d(motionEvent, i);
                    f = Math.abs(d - this.za);
                    float e = o.e(motionEvent, i);
                    x = Math.abs(e - this.zb);
                    if (f > ((float) this.iN) && f > x) {
                        this.iL = true;
                        bU();
                        if (d - this.xP > 0.0f) {
                            x = this.xP + ((float) this.iN);
                        } else {
                            x = this.xP - ((float) this.iN);
                        }
                        this.za = x;
                        this.zb = e;
                        ag(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.iL) {
                    z = p(o.d(motionEvent, o.b(motionEvent, this.fu))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.iL) {
                    a(this.yF, true, 0, false);
                    z = bT();
                    break;
                }
                break;
            case 5:
                i = o.e(motionEvent);
                this.za = o.d(motionEvent, i);
                this.fu = o.c(motionEvent, i);
                break;
            case 6:
                h(motionEvent);
                this.za = o.d(motionEvent, o.b(motionEvent, this.fu));
                break;
        }
        if (z) {
            z.E(this);
        }
        return true;
    }

    private boolean bT() {
        this.fu = -1;
        this.iL = false;
        this.yX = false;
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
        return this.zh.cv() | this.zi.cv();
    }

    private void bU() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean p(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.za - f;
        this.za = f;
        float scrollX = ((float) getScrollX()) + f3;
        int bQ = bQ();
        float f4 = ((float) bQ) * this.yQ;
        float f5 = ((float) bQ) * this.yR;
        b bVar = (b) this.ep.get(0);
        b bVar2 = (b) this.ep.get(this.ep.size() - 1);
        if (bVar.position != 0) {
            f4 = bVar.zA * ((float) bQ);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.yE.getCount() - 1) {
            f2 = bVar2.zA * ((float) bQ);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.zh.x(Math.abs(f4 - scrollX) / ((float) bQ));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.zi.x(Math.abs(scrollX - f2) / ((float) bQ));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.za += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        ak((int) f4);
        return z3;
    }

    private b bV() {
        float f;
        int bQ = bQ();
        float scrollX = bQ > 0 ? ((float) getScrollX()) / ((float) bQ) : 0.0f;
        if (bQ > 0) {
            f = ((float) this.yM) / ((float) bQ);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        b bVar = null;
        while (i2 < this.ep.size()) {
            int i3;
            b bVar2;
            b bVar3 = (b) this.ep.get(i2);
            b bVar4;
            if (obj != null || bVar3.position == i + 1) {
                bVar4 = bVar3;
                i3 = i2;
                bVar2 = bVar4;
            } else {
                bVar3 = this.yD;
                bVar3.zA = (f2 + f3) + f;
                bVar3.position = i + 1;
                bVar3.zz = 1.0f;
                bVar4 = bVar3;
                i3 = i2 - 1;
                bVar2 = bVar4;
            }
            f2 = bVar2.zA;
            f3 = (bVar2.zz + f2) + f;
            if (obj == null && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f3 || i3 == this.ep.size() - 1) {
                return bVar2;
            }
            f3 = f2;
            i = bVar2.position;
            obj = null;
            f2 = bVar2.zz;
            bVar = bVar2;
            i2 = i3 + 1;
        }
        return bVar;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int B = z.B(this);
        if (B == 0 || (B == 1 && this.yE != null && this.yE.getCount() > 1)) {
            int width;
            if (!this.zh.isFinished()) {
                B = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.yQ * ((float) width));
                this.zh.setSize(i, width);
                i = this.zh.draw(canvas) | 0;
                canvas.restoreToCount(B);
            }
            if (!this.zi.isFinished()) {
                B = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.yR + 1.0f)) * ((float) width));
                this.zi.setSize(height, width);
                i |= this.zi.draw(canvas);
                canvas.restoreToCount(B);
            }
        } else {
            this.zh.finish();
            this.zi.finish();
        }
        if (i != 0) {
            z.E(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.yM > 0 && this.yN != null && this.ep.size() > 0 && this.yE != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.yM) / ((float) width);
            b bVar = (b) this.ep.get(0);
            float f2 = bVar.zA;
            int size = this.ep.size();
            int i = bVar.position;
            int i2 = ((b) this.ep.get(size - 1)).position;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bVar.position && i3 < size) {
                    i3++;
                    bVar = (b) this.ep.get(i3);
                }
                if (i4 == bVar.position) {
                    f3 = (bVar.zA + bVar.zz) * ((float) width);
                    f2 = (bVar.zA + bVar.zz) + f;
                } else {
                    f3 = (1.0f + f2) * ((float) width);
                    f2 += 1.0f + f;
                }
                if (((float) this.yM) + f3 > ((float) scrollX)) {
                    this.yN.setBounds(Math.round(f3), this.yO, Math.round(((float) this.yM) + f3), this.yP);
                    this.yN.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.fu) {
            e = e == 0 ? 1 : 0;
            this.za = o.d(motionEvent, e);
            this.fu = o.c(motionEvent, e);
            if (this.ft != null) {
                this.ft.clear();
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.yU != z) {
            this.yU = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.yE == null) {
            return false;
        }
        int bQ = bQ();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) bQ) * this.yQ))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) bQ) * this.yR))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && z.g(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            boolean arrowScroll;
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 21:
                        arrowScroll = arrowScroll(17);
                        break;
                    case 22:
                        arrowScroll = arrowScroll(66);
                        break;
                    case 61:
                        if (VERSION.SDK_INT >= 11) {
                            if (!g.a(keyEvent)) {
                                if (g.a(keyEvent, 1)) {
                                    arrowScroll = arrowScroll(1);
                                    break;
                                }
                            }
                            arrowScroll = arrowScroll(2);
                            break;
                        }
                }
            }
            arrowScroll = false;
            if (!arrowScroll) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int i) {
        View view;
        boolean bW;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                bW = bW();
            } else {
                if (i != 66) {
                }
                bW = bX();
            }
        } else if (i == 17) {
            bW = (view == null || a(this.ey, findNextFocus).left < a(this.ey, view).left) ? findNextFocus.requestFocus() : bW();
        } else {
            if (i == 66) {
                int i2 = a(this.ey, findNextFocus).left;
                int i3 = a(this.ey, view).left;
                if (view == null || i2 > i3) {
                    bW = findNextFocus.requestFocus();
                }
                bW = bX();
            }
            bW = false;
        }
        if (bW) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return bW;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean bW() {
        if (this.yF <= 0) {
            return false;
        }
        d(this.yF - 1, true);
        return true;
    }

    private boolean bX() {
        if (this.yE == null || this.yF >= this.yE.getCount() - 1) {
            return false;
        }
        d(this.yF + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b ao = ao(childAt);
                    if (ao != null && ao.position == this.yF) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.yF) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.yF && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.yF && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
