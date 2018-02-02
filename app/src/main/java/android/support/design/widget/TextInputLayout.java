package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.design.a$c;
import android.support.design.a.g;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.u.c;
import android.support.v4.content.a;
import android.support.v4.view.z;
import android.support.v4.widget.Space;
import android.support.v7.widget.w;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {
    private u eR;
    private final f gP;
    private EditText kT;
    boolean kU;
    CharSequence kV;
    private Paint kW;
    private LinearLayout kX;
    private int kY;
    private boolean kZ;
    private TextView la;
    private int lb;
    private boolean lc;
    private CharSequence ld;
    private boolean le;
    private TextView lf;
    private int lg;
    private int lh;
    private int li;
    private boolean lj;
    private ColorStateList lk;
    private ColorStateList ll;
    private boolean lm;
    private boolean ln;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.gP = new f(this);
        t.e(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.gP.a(a.eB);
        f fVar = this.gP;
        fVar.gv = new AccelerateInterpolator();
        fVar.P();
        this.gP.x(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.dF, i, h.bN);
        this.kU = obtainStyledAttributes.getBoolean(i.dJ, true);
        setHint(obtainStyledAttributes.getText(i.dH));
        this.lm = obtainStyledAttributes.getBoolean(i.dQ, true);
        if (obtainStyledAttributes.hasValue(i.dG)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i.dG);
            this.ll = colorStateList;
            this.lk = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(i.dI, -1) != -1) {
            this.gP.y(obtainStyledAttributes.getResourceId(i.dI, 0));
            this.ll = ColorStateList.valueOf(this.gP.ga);
            if (this.kT != null) {
                k(false);
                this.kT.setLayoutParams(b(this.kT.getLayoutParams()));
                this.kT.requestLayout();
            }
        }
        this.lb = obtainStyledAttributes.getResourceId(i.dL, 0);
        boolean z = obtainStyledAttributes.getBoolean(i.dK, false);
        boolean z2 = obtainStyledAttributes.getBoolean(i.dM, false);
        int i2 = obtainStyledAttributes.getInt(i.dN, -1);
        if (this.lg != i2) {
            if (i2 > 0) {
                this.lg = i2;
            } else {
                this.lg = -1;
            }
            if (this.le) {
                L(this.kT == null ? 0 : this.kT.getText().length());
            }
        }
        this.lh = obtainStyledAttributes.getResourceId(i.dO, 0);
        this.li = obtainStyledAttributes.getResourceId(i.dP, 0);
        obtainStyledAttributes.recycle();
        l(z);
        if (this.le != z2) {
            if (z2) {
                this.lf = new TextView(getContext());
                this.lf.setMaxLines(1);
                try {
                    this.lf.setTextAppearance(getContext(), this.lh);
                } catch (Exception e) {
                    this.lf.setTextAppearance(getContext(), h.TextAppearance_AppCompat_Caption);
                    this.lf.setTextColor(a.c(getContext(), a$c.ba));
                }
                a(this.lf, -1);
                if (this.kT == null) {
                    L(0);
                } else {
                    L(this.kT.getText().length());
                }
            } else {
                a(this.lf);
                this.lf = null;
            }
            this.le = z2;
        }
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        z.a(this, new a(this, (byte) 0));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (this.kT != null) {
                throw new IllegalArgumentException("We already have an EditText, can only have one");
            }
            this.kT = editText;
            f fVar = this.gP;
            Typeface typeface = this.kT.getTypeface();
            fVar.gi = typeface;
            fVar.gh = typeface;
            fVar.P();
            fVar = this.gP;
            float textSize = this.kT.getTextSize();
            if (fVar.fX != textSize) {
                fVar.fX = textSize;
                fVar.P();
            }
            int gravity = this.kT.getGravity();
            this.gP.x((8388615 & gravity) | 48);
            this.gP.w(gravity);
            this.kT.addTextChangedListener(new 1(this));
            if (this.lk == null) {
                this.lk = this.kT.getHintTextColors();
            }
            if (this.kU && TextUtils.isEmpty(this.kV)) {
                setHint(this.kT.getHint());
                this.kT.setHint(null);
            }
            if (this.lf != null) {
                L(this.kT.getText().length());
            }
            if (this.kX != null) {
                av();
            }
            k(false);
            super.addView(view, 0, b(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private LinearLayout.LayoutParams b(LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.kU) {
            if (this.kW == null) {
                this.kW = new Paint();
            }
            Paint paint = this.kW;
            f fVar = this.gP;
            paint.setTypeface(fVar.gh != null ? fVar.gh : Typeface.DEFAULT);
            this.kW.setTextSize(this.gP.fY);
            layoutParams.topMargin = (int) (-this.kW.ascent());
        } else {
            layoutParams.topMargin = 0;
        }
        return layoutParams;
    }

    private void k(boolean z) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = (this.kT == null || TextUtils.isEmpty(this.kT.getText())) ? null : 1;
        for (int i : getDrawableState()) {
            if (i == 16842908) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (TextUtils.isEmpty(getError())) {
            obj2 = null;
        }
        if (this.lk != null) {
            f fVar = this.gP;
            int defaultColor = this.lk.getDefaultColor();
            if (fVar.fZ != defaultColor) {
                fVar.fZ = defaultColor;
                fVar.P();
            }
        }
        if (this.lj && this.lf != null) {
            this.gP.v(this.lf.getCurrentTextColor());
        } else if (obj != null && this.ll != null) {
            this.gP.v(this.ll.getDefaultColor());
        } else if (this.lk != null) {
            this.gP.v(this.lk.getDefaultColor());
        }
        if (obj3 == null && obj == null && r1 == null) {
            if (this.eR != null && this.eR.ls.isRunning()) {
                this.eR.ls.cancel();
            }
            if (z && this.lm) {
                n(0.0f);
                return;
            } else {
                this.gP.f(0.0f);
                return;
            }
        }
        if (this.eR != null && this.eR.ls.isRunning()) {
            this.eR.ls.cancel();
        }
        if (z && this.lm) {
            n(1.0f);
        } else {
            this.gP.f(1.0f);
        }
    }

    private void setHint(CharSequence charSequence) {
        if (this.kU) {
            this.kV = charSequence;
            this.gP.setText(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void a(TextView textView, int i) {
        if (this.kX == null) {
            this.kX = new LinearLayout(getContext());
            this.kX.setOrientation(0);
            addView(this.kX, -1, -2);
            this.kX.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.kT != null) {
                av();
            }
        }
        this.kX.setVisibility(0);
        this.kX.addView(textView, i);
        this.kY++;
    }

    private void av() {
        z.c(this.kX, z.O(this.kT), 0, z.P(this.kT), this.kT.getPaddingBottom());
    }

    private void a(TextView textView) {
        if (this.kX != null) {
            this.kX.removeView(textView);
            int i = this.kY - 1;
            this.kY = i;
            if (i == 0) {
                this.kX.setVisibility(8);
            }
        }
    }

    private void l(boolean z) {
        if (this.kZ != z) {
            if (this.la != null) {
                z.U(this.la).cancel();
            }
            if (z) {
                this.la = new TextView(getContext());
                try {
                    this.la.setTextAppearance(getContext(), this.lb);
                } catch (Exception e) {
                    this.la.setTextAppearance(getContext(), h.TextAppearance_AppCompat_Caption);
                    this.la.setTextColor(a.c(getContext(), a$c.ba));
                }
                this.la.setVisibility(4);
                z.N(this.la);
                a(this.la, 0);
            } else {
                this.lc = false;
                aw();
                a(this.la);
                this.la = null;
            }
            this.kZ = z;
        }
    }

    private void L(int i) {
        boolean z = this.lj;
        if (this.lg == -1) {
            this.lf.setText(String.valueOf(i));
            this.lj = false;
        } else {
            this.lj = i > this.lg;
            if (z != this.lj) {
                this.lf.setTextAppearance(getContext(), this.lj ? this.li : this.lh);
            }
            this.lf.setText(getContext().getString(g.bC, new Object[]{Integer.valueOf(i), Integer.valueOf(this.lg)}));
        }
        if (this.kT != null && z != this.lj) {
            k(false);
            aw();
        }
    }

    private void aw() {
        Drawable background;
        int i = VERSION.SDK_INT;
        if (i == 21 && i == 22) {
            background = this.kT.getBackground();
            if (!(background == null || this.ln)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    DrawableContainer drawableContainer = (DrawableContainer) background;
                    ConstantState constantState = newDrawable.getConstantState();
                    this.ln = VERSION.SDK_INT >= 9 ? i.a(drawableContainer, constantState) : i.b(drawableContainer, constantState);
                }
                if (!this.ln) {
                    this.kT.setBackgroundDrawable(newDrawable);
                    this.ln = true;
                }
            }
        }
        background = this.kT.getBackground();
        if (background != null) {
            if (w.p(background)) {
                background = background.mutate();
            }
            if (this.lc && this.la != null) {
                background.setColorFilter(android.support.v7.widget.h.a(this.la.getCurrentTextColor(), Mode.SRC_IN));
            } else if (!this.lj || this.lf == null) {
                background.clearColorFilter();
                this.kT.refreshDrawableState();
            } else {
                background.setColorFilter(android.support.v7.widget.h.a(this.lf.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.lc) {
            savedState.lq = getError();
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            CharSequence charSequence = savedState.lq;
            if (!TextUtils.equals(this.ld, charSequence)) {
                boolean z;
                this.ld = charSequence;
                if (!this.kZ) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        l(true);
                    }
                }
                boolean ai = z.ai(this);
                if (TextUtils.isEmpty(charSequence)) {
                    z = false;
                } else {
                    z = true;
                }
                this.lc = z;
                if (this.lc) {
                    this.la.setText(charSequence);
                    this.la.setVisibility(0);
                    if (ai) {
                        if (z.G(this.la) == 1.0f) {
                            z.d(this.la, 0.0f);
                        }
                        z.U(this.la).q(1.0f).d(200).b(a.eD).a(new 2(this)).start();
                    }
                } else if (this.la.getVisibility() == 0) {
                    if (ai) {
                        z.U(this.la).q(0.0f).d(200).b(a.eC).a(new 3(this, charSequence)).start();
                    } else {
                        this.la.setVisibility(4);
                    }
                }
                aw();
                k(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private CharSequence getError() {
        return this.kZ ? this.ld : null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.kU) {
            this.gP.draw(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.kU && this.kT != null) {
            int left = this.kT.getLeft() + this.kT.getCompoundPaddingLeft();
            int right = this.kT.getRight() - this.kT.getCompoundPaddingRight();
            this.gP.b(left, this.kT.getTop() + this.kT.getCompoundPaddingTop(), right, this.kT.getBottom() - this.kT.getCompoundPaddingBottom());
            this.gP.c(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.gP.P();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        k(z.ai(this));
    }

    private void n(float f) {
        if (this.gP.fR != f) {
            if (this.eR == null) {
                this.eR = aa.ay();
                this.eR.setInterpolator(a.eA);
                this.eR.setDuration(200);
                this.eR.a(new c(this) {
                    final /* synthetic */ TextInputLayout lo;

                    {
                        this.lo = r1;
                    }

                    public final void a(u uVar) {
                        this.lo.gP.f(uVar.ls.aA());
                    }
                });
            }
            this.eR.e(this.gP.fR, f);
            this.eR.ls.start();
        }
    }
}
