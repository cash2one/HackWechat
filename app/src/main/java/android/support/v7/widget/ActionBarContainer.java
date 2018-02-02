package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable KT;
    private View MA;
    private View MB;
    Drawable MC;
    Drawable MD;
    boolean ME;
    boolean MF;
    private boolean My;
    View Mz;
    private int mHeight;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable cVar;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            cVar = new c(this);
        } else {
            cVar = new b(this);
        }
        setBackgroundDrawable(cVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionBar);
        this.KT = obtainStyledAttributes.getDrawable(k.ActionBar_background);
        this.MC = obtainStyledAttributes.getDrawable(k.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(k.ActionBar_height, -1);
        if (getId() == f.split_action_bar) {
            this.ME = true;
            this.MD = obtainStyledAttributes.getDrawable(k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.ME ? this.MD == null : this.KT == null && this.MC == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.MA = findViewById(f.action_bar);
        this.MB = findViewById(f.action_context_bar);
    }

    public final void m(Drawable drawable) {
        boolean z = true;
        if (this.KT != null) {
            this.KT.setCallback(null);
            unscheduleDrawable(this.KT);
        }
        this.KT = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.MA != null) {
                this.KT.setBounds(this.MA.getLeft(), this.MA.getTop(), this.MA.getRight(), this.MA.getBottom());
            }
        }
        if (this.ME) {
            if (this.MD != null) {
                z = false;
            }
        } else if (!(this.KT == null && this.MC == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.KT != null) {
            this.KT.setVisible(z, false);
        }
        if (this.MC != null) {
            this.MC.setVisible(z, false);
        }
        if (this.MD != null) {
            this.MD.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.KT && !this.ME) || ((drawable == this.MC && this.MF) || ((drawable == this.MD && this.ME) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.KT != null && this.KT.isStateful()) {
            this.KT.setState(getDrawableState());
        }
        if (this.MC != null && this.MC.isStateful()) {
            this.MC.setState(getDrawableState());
        }
        if (this.MD != null && this.MD.isStateful()) {
            this.MD.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.KT != null) {
                this.KT.jumpToCurrentState();
            }
            if (this.MC != null) {
                this.MC.jumpToCurrentState();
            }
            if (this.MD != null) {
                this.MD.jumpToCurrentState();
            }
        }
    }

    public final void I(boolean z) {
        this.My = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.My || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void a(ai aiVar) {
        if (this.Mz != null) {
            removeView(this.Mz);
        }
        this.Mz = aiVar;
        if (aiVar != null) {
            addView(aiVar);
            LayoutParams layoutParams = aiVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            aiVar.WD = false;
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private static boolean aK(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int aL(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.MA == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.MA != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.Mz != null && this.Mz.getVisibility() != 8 && mode != 1073741824) {
                int aL;
                if (!aK(this.MA)) {
                    aL = aL(this.MA);
                } else if (aK(this.MB)) {
                    aL = 0;
                } else {
                    aL = aL(this.MB);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(aL + aL(this.Mz), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.Mz;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.ME) {
            int i6;
            if (this.KT != null) {
                if (this.MA.getVisibility() == 0) {
                    this.KT.setBounds(this.MA.getLeft(), this.MA.getTop(), this.MA.getRight(), this.MA.getBottom());
                } else if (this.MB == null || this.MB.getVisibility() != 0) {
                    this.KT.setBounds(0, 0, 0, 0);
                } else {
                    this.KT.setBounds(this.MB.getLeft(), this.MB.getTop(), this.MB.getRight(), this.MB.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.MF = z2;
            if (!z2 || this.MC == null) {
                i5 = i6;
            } else {
                this.MC.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.MD != null) {
            this.MD.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
