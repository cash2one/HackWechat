package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends a {
    private TextView FN;
    private View MG;
    private LinearLayout MH;
    private TextView MI;
    private int MJ;
    private int MK;
    public boolean ML;
    private int MM;
    private View kK;
    public CharSequence uU;
    public CharSequence uV;

    public final /* bridge */ /* synthetic */ ai c(int i, long j) {
        return super.c(i, j);
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ap a = ap.a(context, attributeSet, k.ActionMode, i);
        setBackgroundDrawable(a.getDrawable(k.ActionMode_background));
        this.MJ = a.getResourceId(k.ActionMode_titleTextStyle, 0);
        this.MK = a.getResourceId(k.ActionMode_subtitleTextStyle, 0);
        this.Mq = a.getLayoutDimension(k.ActionMode_height, 0);
        this.MM = a.getResourceId(k.ActionMode_closeItemLayout, h.abc_action_mode_close_item_material);
        a.Zu.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Mp != null) {
            this.Mp.hideOverflowMenu();
            this.Mp.ea();
        }
    }

    public final void aF(int i) {
        this.Mq = i;
    }

    public final void setCustomView(View view) {
        if (this.kK != null) {
            removeView(this.kK);
        }
        this.kK = view;
        if (!(view == null || this.MH == null)) {
            removeView(this.MH);
            this.MH = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public final void setTitle(CharSequence charSequence) {
        this.uU = charSequence;
        dN();
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.uV = charSequence;
        dN();
    }

    private void dN() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.MH == null) {
            LayoutInflater.from(getContext()).inflate(h.abc_action_bar_title_item, this);
            this.MH = (LinearLayout) getChildAt(getChildCount() - 1);
            this.FN = (TextView) this.MH.findViewById(f.action_bar_title);
            this.MI = (TextView) this.MH.findViewById(f.action_bar_subtitle);
            if (this.MJ != 0) {
                this.FN.setTextAppearance(getContext(), this.MJ);
            }
            if (this.MK != 0) {
                this.MI.setTextAppearance(getContext(), this.MK);
            }
        }
        this.FN.setText(this.uU);
        this.MI.setText(this.uV);
        Object obj2 = !TextUtils.isEmpty(this.uU) ? 1 : null;
        if (TextUtils.isEmpty(this.uV)) {
            obj = null;
        }
        TextView textView = this.MI;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.MH;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.MH.getParent() == null) {
            addView(this.MH);
        }
    }

    public final void c(final b bVar) {
        if (this.MG == null) {
            this.MG = LayoutInflater.from(getContext()).inflate(this.MM, this, false);
            addView(this.MG);
        } else if (this.MG.getParent() == null) {
            addView(this.MG);
        }
        this.MG.findViewById(f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView MO;

            public final void onClick(View view) {
                bVar.finish();
            }
        });
        android.support.v7.view.menu.f fVar = (android.support.v7.view.menu.f) bVar.getMenu();
        if (this.Mp != null) {
            this.Mp.dZ();
        }
        this.Mp = new ActionMenuPresenter(getContext());
        this.Mp.dY();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        fVar.a(this.Mp, this.Mn);
        this.Mo = (ActionMenuView) this.Mp.c(this);
        this.Mo.setBackgroundDrawable(null);
        addView(this.Mo, layoutParams);
    }

    public final void dO() {
        if (this.MG == null) {
            dP();
        }
    }

    public final void dP() {
        removeAllViews();
        this.kK = null;
        this.Mo = null;
    }

    public final boolean showOverflowMenu() {
        if (this.Mp != null) {
            return this.Mp.showOverflowMenu();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int g;
            int size = MeasureSpec.getSize(i);
            int size2 = this.Mq > 0 ? this.Mq : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.MG != null) {
                g = a.g(this.MG, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.MG.getLayoutParams();
                paddingLeft = g - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.Mo != null && this.Mo.getParent() == this) {
                paddingLeft = a.g(this.Mo, paddingLeft, makeMeasureSpec);
            }
            if (this.MH != null && this.kK == null) {
                if (this.ML) {
                    this.MH.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    g = this.MH.getMeasuredWidth();
                    makeMeasureSpec = g <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= g;
                    }
                    this.MH.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a.g(this.MH, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.kK != null) {
                int min;
                LayoutParams layoutParams = this.kK.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.kK.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.Mq <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean bv = at.bv(this);
        int paddingRight = bv ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.MG == null || this.MG.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.MG.getLayoutParams();
            int i6 = bv ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = bv ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = a.b(paddingRight, i6, bv);
            paddingRight = a.b(paddingRight + a.a(this.MG, paddingRight, paddingTop, paddingTop2, bv), i5, bv);
        }
        if (!(this.MH == null || this.kK != null || this.MH.getVisibility() == 8)) {
            paddingRight += a.a(this.MH, paddingRight, paddingTop, paddingTop2, bv);
        }
        if (this.kK != null) {
            a.a(this.kK, paddingRight, paddingTop, paddingTop2, bv);
        }
        i5 = bv ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.Mo != null) {
            a.a(this.Mo, i5, paddingTop, paddingTop2, !bv);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.uU);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public final void J(boolean z) {
        if (z != this.ML) {
            requestLayout();
        }
        this.ML = z;
    }
}
