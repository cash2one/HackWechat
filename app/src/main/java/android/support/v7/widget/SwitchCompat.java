package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.tencent.mm.plugin.gif.MMGIFException;

public class SwitchCompat extends CompoundButton {
    private static final int[] dX = new int[]{16842912};
    private final h Pc;
    private int Ux;
    private Drawable YH;
    private Drawable YI;
    private int YJ;
    private int YK;
    private int YL;
    private boolean YM;
    private CharSequence YN;
    private CharSequence YO;
    private boolean YP;
    private int YQ;
    private float YR;
    private float YS;
    private float YT;
    private int YU;
    private int YV;
    private int YW;
    private int YX;
    private int YY;
    private int YZ;
    private int Za;
    private ColorStateList Zb;
    private Layout Zc;
    private Layout Zd;
    private TransformationMethod Ze;
    private a Zf;
    private final Rect ey;
    private VelocityTracker ft;
    private TextPaint gu;
    private int iN;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ft = VelocityTracker.obtain();
        this.ey = new Rect();
        this.gu = new TextPaint(1);
        this.gu.density = getResources().getDisplayMetrics().density;
        ap a = ap.a(context, attributeSet, k.SwitchCompat, i);
        this.YH = a.getDrawable(k.SwitchCompat_android_thumb);
        if (this.YH != null) {
            this.YH.setCallback(this);
        }
        this.YI = a.getDrawable(k.SwitchCompat_track);
        if (this.YI != null) {
            this.YI.setCallback(this);
        }
        this.YN = a.getText(k.SwitchCompat_android_textOn);
        this.YO = a.getText(k.SwitchCompat_android_textOff);
        this.YP = a.getBoolean(k.SwitchCompat_showText, true);
        this.YJ = a.getDimensionPixelSize(k.SwitchCompat_thumbTextPadding, 0);
        this.YK = a.getDimensionPixelSize(k.SwitchCompat_switchMinWidth, 0);
        this.YL = a.getDimensionPixelSize(k.SwitchCompat_switchPadding, 0);
        this.YM = a.getBoolean(k.SwitchCompat_splitTrack, false);
        int resourceId = a.getResourceId(k.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            Typeface typeface;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, k.TextAppearance);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(k.TextAppearance_android_textColor);
            if (colorStateList != null) {
                this.Zb = colorStateList;
            } else {
                this.Zb = getTextColors();
            }
            resourceId = obtainStyledAttributes.getDimensionPixelSize(k.TextAppearance_android_textSize, 0);
            if (!(resourceId == 0 || ((float) resourceId) == this.gu.getTextSize())) {
                this.gu.setTextSize((float) resourceId);
                requestLayout();
            }
            resourceId = obtainStyledAttributes.getInt(k.TextAppearance_android_typeface, -1);
            int i2 = obtainStyledAttributes.getInt(k.TextAppearance_android_textStyle, -1);
            switch (resourceId) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                setSwitchTypeface(typeface);
                i2 &= (typeface != null ? typeface.getStyle() : 0) ^ -1;
                this.gu.setFakeBoldText((i2 & 1) != 0);
                this.gu.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                this.gu.setFakeBoldText(false);
                this.gu.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(k.TextAppearance_textAllCaps, false)) {
                this.Ze = new android.support.v7.e.a(getContext());
            } else {
                this.Ze = null;
            }
            obtainStyledAttributes.recycle();
        }
        this.Pc = h.ey();
        a.Zu.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.iN = viewConfiguration.getScaledTouchSlop();
        this.Ux = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void setSwitchTypeface(Typeface typeface) {
        if (this.gu.getTypeface() != typeface) {
            this.gu.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.YP) {
            if (this.Zc == null) {
                this.Zc = i(this.YN);
            }
            if (this.Zd == null) {
                this.Zd = i(this.YO);
            }
        }
        Rect rect = this.ey;
        if (this.YH != null) {
            this.YH.getPadding(rect);
            intrinsicWidth = (this.YH.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.YH.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.YP) {
            max = Math.max(this.Zc.getWidth(), this.Zd.getWidth()) + (this.YJ * 2);
        } else {
            max = 0;
        }
        this.YW = Math.max(max, intrinsicWidth);
        if (this.YI != null) {
            this.YI.getPadding(rect);
            i3 = this.YI.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        max = rect.right;
        if (this.YH != null) {
            rect = w.n(this.YH);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            max = Math.max(max, rect.right);
        }
        intrinsicWidth = Math.max(this.YK, (intrinsicWidth + (this.YW * 2)) + max);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.YU = intrinsicWidth;
        this.YV = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(z.L(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.YN : this.YO;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout i(CharSequence charSequence) {
        CharSequence transformation;
        if (this.Ze != null) {
            transformation = this.Ze.getTransformation(charSequence, this);
        } else {
            transformation = charSequence;
        }
        return new StaticLayout(transformation, this.gu, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.gu)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 1.0f;
        int i = 0;
        this.ft.addMovement(motionEvent);
        float x;
        switch (o.d(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.YH != null) {
                        int thumbOffset = getThumbOffset();
                        this.YH.getPadding(this.ey);
                        int i2 = this.YY - this.iN;
                        thumbOffset = (thumbOffset + this.YX) - this.iN;
                        int i3 = (((this.YW + thumbOffset) + this.ey.left) + this.ey.right) + this.iN;
                        int i4 = this.Za + this.iN;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.YQ = 1;
                        this.YR = x;
                        this.YS = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.YQ != 2) {
                    this.YQ = 0;
                    this.ft.clear();
                    break;
                }
                boolean z;
                this.YQ = 0;
                if (motionEvent.getAction() == 1 && isEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                boolean isChecked = isChecked();
                if (z) {
                    this.ft.computeCurrentVelocity(1000);
                    x = this.ft.getXVelocity();
                    z = Math.abs(x) > ((float) this.Ux) ? at.bv(this) ? x < 0.0f : x > 0.0f : gS();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.YQ) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.YR) > ((float) this.iN) || Math.abs(f - this.YS) > ((float) this.iN)) {
                            this.YQ = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.YR = x;
                            this.YS = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int gT = gT();
                        float f2 = x2 - this.YR;
                        x = gT != 0 ? f2 / ((float) gT) : f2 > 0.0f ? 1.0f : -1.0f;
                        if (at.bv(this)) {
                            x = -x;
                        }
                        x += this.YT;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= 1.0f) {
                            f = x;
                        }
                        if (f == this.YT) {
                            return true;
                        }
                        this.YR = x2;
                        H(f);
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void gR() {
        if (this.Zf != null) {
            clearAnimation();
            this.Zf = null;
        }
    }

    private boolean gS() {
        return this.YT > 0.5f;
    }

    private void H(float f) {
        this.YT = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f = 1.0f;
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && z.ai(this) && isShown()) {
            if (this.Zf != null) {
                gR();
            }
            float f2 = this.YT;
            if (!isChecked) {
                f = 0.0f;
            }
            this.Zf = new a(this, f2, f, (byte) 0);
            this.Zf.setDuration(250);
            this.Zf.setAnimationListener(new 1(this, isChecked));
            startAnimation(this.Zf);
            return;
        }
        gR();
        if (!isChecked) {
            f = 0.0f;
        }
        H(f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.YH != null) {
            Rect rect = this.ey;
            if (this.YI != null) {
                this.YI.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect n = w.n(this.YH);
            max = Math.max(0, n.left - rect.left);
            i5 = Math.max(0, n.right - rect.right);
        } else {
            max = 0;
        }
        if (at.bv(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.YU + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.YU);
            max = paddingLeft;
        }
        switch (getGravity() & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.YV / 2);
                paddingLeft = this.YV + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.YV;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.YV + paddingTop;
                break;
        }
        this.YX = i5;
        this.YY = paddingTop;
        this.Za = paddingLeft;
        this.YZ = max;
    }

    public void draw(Canvas canvas) {
        Rect n;
        int i;
        Rect rect = this.ey;
        int i2 = this.YX;
        int i3 = this.YY;
        int i4 = this.YZ;
        int i5 = this.Za;
        int thumbOffset = i2 + getThumbOffset();
        if (this.YH != null) {
            n = w.n(this.YH);
        } else {
            n = w.Rs;
        }
        if (this.YI != null) {
            this.YI.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (n != null) {
                if (n.left > rect.left) {
                    i2 += n.left - rect.left;
                }
                if (n.top > rect.top) {
                    thumbOffset = (n.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (n.right > rect.right) {
                    i4 -= n.right - rect.right;
                }
                i = n.bottom > rect.bottom ? i5 - (n.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.YI.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.YH != null) {
            this.YH.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.YW) + rect.right;
            this.YH.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.b.a.a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.ey;
        Drawable drawable = this.YI;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.YY + rect.top;
        int i2 = this.Za - rect.bottom;
        Drawable drawable2 = this.YH;
        if (drawable != null) {
            if (!this.YM || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect n = w.n(drawable2);
                drawable2.copyBounds(rect);
                rect.left += n.left;
                rect.right -= n.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = gS() ? this.Zc : this.Zd;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.Zb != null) {
                this.gu.setColor(this.Zb.getColorForState(drawableState, 0));
            }
            this.gu.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!at.bv(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.YU;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.YL;
    }

    public int getCompoundPaddingRight() {
        if (at.bv(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.YU;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.YL;
    }

    private int getThumbOffset() {
        float f;
        if (at.bv(this)) {
            f = 1.0f - this.YT;
        } else {
            f = this.YT;
        }
        return (int) ((f * ((float) gT())) + 0.5f);
    }

    private int gT() {
        if (this.YI == null) {
            return 0;
        }
        Rect n;
        Rect rect = this.ey;
        this.YI.getPadding(rect);
        if (this.YH != null) {
            n = w.n(this.YH);
        } else {
            n = w.Rs;
        }
        return ((((this.YU - this.YW) - rect.left) - rect.right) - n.left) - n.right;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, dX);
        }
        return onCreateDrawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.YH != null) {
            this.YH.setState(drawableState);
        }
        if (this.YI != null) {
            this.YI.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.YH != null) {
            android.support.v4.b.a.a.a(this.YH, f, f2);
        }
        if (this.YI != null) {
            android.support.v4.b.a.a.a(this.YI, f, f2);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.YH || drawable == this.YI;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.YH != null) {
                this.YH.jumpToCurrentState();
            }
            if (this.YI != null) {
                this.YI.jumpToCurrentState();
            }
            gR();
            H(isChecked() ? 1.0f : 0.0f);
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.YN : this.YO;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }
}
