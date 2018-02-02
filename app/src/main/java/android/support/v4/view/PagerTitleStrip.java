package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.d;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements android.support.v4.view.ViewPager.a {
    private static final int[] yd = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] ye = new int[]{16843660};
    private static final b yh;
    private int ug;
    ViewPager xS;
    TextView xT;
    TextView xU;
    TextView xV;
    private int xW = -1;
    private float xX = -1.0f;
    int xY;
    private boolean xZ;
    private boolean ya;
    private final a yb = new a();
    private WeakReference<u> yc;
    private int yf;
    int yg;

    private class a extends DataSetObserver implements d, e {
        private int yi;
        final /* synthetic */ PagerTitleStrip yj;

        private a(PagerTitleStrip pagerTitleStrip) {
            this.yj = pagerTitleStrip;
        }

        public final void a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.yj.a(i, f, false);
        }

        public final void ae(int i) {
            float f = 0.0f;
            if (this.yi == 0) {
                this.yj.a(this.yj.xS.yF, this.yj.xS.yE);
                if (this.yj.xX >= 0.0f) {
                    f = this.yj.xX;
                }
                this.yj.a(this.yj.xS.yF, f, true);
            }
        }

        public final void af(int i) {
            this.yi = i;
        }

        public final void b(u uVar, u uVar2) {
            this.yj.a(uVar, uVar2);
        }

        public final void onChanged() {
            float f = 0.0f;
            this.yj.a(this.yj.xS.yF, this.yj.xS.yE);
            if (this.yj.xX >= 0.0f) {
                f = this.yj.xX;
            }
            this.yj.a(this.yj.xS.yF, f, true);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            yh = new d();
        } else {
            yh = new c();
        }
    }

    private static void b(TextView textView) {
        yh.b(textView);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        View textView = new TextView(context);
        this.xT = textView;
        addView(textView);
        textView = new TextView(context);
        this.xU = textView;
        addView(textView);
        textView = new TextView(context);
        this.xV = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, yd);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.xT.setTextAppearance(context, resourceId);
            this.xU.setTextAppearance(context, resourceId);
            this.xV.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.xT.setTextSize(0, f);
            this.xU.setTextSize(0, f);
            this.xV.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.xT.setTextColor(dimensionPixelSize);
            this.xU.setTextColor(dimensionPixelSize);
            this.xV.setTextColor(dimensionPixelSize);
        }
        this.ug = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.yg = this.xU.getTextColors().getDefaultColor();
        this.yf = 153;
        int i = (this.yf << 24) | (this.yg & 16777215);
        this.xT.setTextColor(i);
        this.xV.setTextColor(i);
        this.xT.setEllipsize(TruncateAt.END);
        this.xU.setEllipsize(TruncateAt.END);
        this.xV.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, ye);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            b(this.xT);
            b(this.xU);
            b(this.xV);
        } else {
            this.xT.setSingleLine();
            this.xU.setSingleLine();
            this.xV.setSingleLine();
        }
        this.xY = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void ad(int i) {
        this.xY = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            u uVar = viewPager.yE;
            viewPager.a(this.yb);
            viewPager.zq = this.yb;
            this.xS = viewPager;
            a(this.yc != null ? (u) this.yc.get() : null, uVar);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.xS != null) {
            a(this.xS.yE, null);
            this.xS.a(null);
            this.xS.zq = null;
            this.xS = null;
        }
    }

    final void a(int i, u uVar) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = uVar != null ? uVar.getCount() : 0;
        this.xZ = true;
        if (i <= 0 || uVar == null) {
            charSequence = null;
        } else {
            charSequence = uVar.bL();
        }
        this.xT.setText(charSequence);
        TextView textView = this.xU;
        if (uVar == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = uVar.bL();
        }
        textView.setText(charSequence);
        if (i + 1 < count && uVar != null) {
            charSequence2 = uVar.bL();
        }
        this.xV.setText(charSequence2);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.xT.measure(count, makeMeasureSpec);
        this.xU.measure(count, makeMeasureSpec);
        this.xV.measure(count, makeMeasureSpec);
        this.xW = i;
        if (!this.ya) {
            a(i, this.xX, false);
        }
        this.xZ = false;
    }

    public void requestLayout() {
        if (!this.xZ) {
            super.requestLayout();
        }
    }

    final void a(u uVar, u uVar2) {
        if (uVar != null) {
            uVar.unregisterDataSetObserver(this.yb);
            this.yc = null;
        }
        if (uVar2 != null) {
            uVar2.registerDataSetObserver(this.yb);
            this.yc = new WeakReference(uVar2);
        }
        if (this.xS != null) {
            this.xW = -1;
            this.xX = -1.0f;
            a(this.xS.yF, uVar2);
            requestLayout();
        }
    }

    void a(int i, float f, boolean z) {
        if (i != this.xW) {
            a(i, this.xS.yE);
        } else if (!z && f == this.xX) {
            return;
        }
        this.ya = true;
        int measuredWidth = this.xT.getMeasuredWidth();
        int measuredWidth2 = this.xU.getMeasuredWidth();
        int measuredWidth3 = this.xV.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.xT.getBaseline();
        measuredWidth2 = this.xU.getBaseline();
        i2 = this.xV.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.xV.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.xT.getMeasuredHeight() + baseline, this.xU.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            case 80:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                baseline = paddingTop + measuredWidth2;
                measuredWidth2 = paddingTop + max;
                break;
        }
        this.xU.layout(i3, baseline, i4, this.xU.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.xY) - measuredWidth);
        this.xT.layout(baseline, i2, measuredWidth + baseline, this.xT.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.xY + i4);
        this.xV.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.xV.getMeasuredHeight() + measuredWidth2);
        this.xX = f;
        this.ya = false;
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.xT.measure(childMeasureSpec2, childMeasureSpec);
        this.xU.measure(childMeasureSpec2, childMeasureSpec);
        this.xV.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.xU.getMeasuredHeight());
        }
        setMeasuredDimension(size, z.resolveSizeAndState(paddingTop, i2, z.M(this.xU) << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.xS != null) {
            if (this.xX >= 0.0f) {
                f = this.xX;
            }
            a(this.xW, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
