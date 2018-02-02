package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a.b;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.v4.widget.r;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements a {
    private static final int[] dX = new int[]{16842912};
    private final int dY;
    final CheckedTextView dZ;
    FrameLayout ea;
    h eb;
    ColorStateList ec;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(f.bB, this, true);
        this.dY = context.getResources().getDimensionPixelSize(d.be);
        this.dZ = (CheckedTextView) findViewById(e.bm);
        this.dZ.setDuplicateParentStateEnabled(true);
    }

    public final void a(h hVar) {
        this.eb = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            Drawable stateListDrawable;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(b.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(dX, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackgroundDrawable(stateListDrawable);
        }
        hVar.isCheckable();
        refreshDrawableState();
        boolean isChecked = hVar.isChecked();
        refreshDrawableState();
        this.dZ.setChecked(isChecked);
        setEnabled(hVar.isEnabled());
        this.dZ.setText(hVar.getTitle());
        setIcon(hVar.getIcon());
        View actionView = hVar.getActionView();
        if (this.ea == null) {
            this.ea = (FrameLayout) ((ViewStub) findViewById(e.bl)).inflate();
        }
        this.ea.removeAllViews();
        if (actionView != null) {
            this.ea.addView(actionView);
        }
    }

    public final h B() {
        return this.eb;
    }

    public final void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = android.support.v4.b.a.a.h(drawable).mutate();
            drawable.setBounds(0, 0, this.dY, this.dY);
            android.support.v4.b.a.a.a(drawable, this.ec);
        }
        r.a(this.dZ, drawable);
    }

    public final boolean C() {
        return false;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.eb != null && this.eb.isCheckable() && this.eb.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, dX);
        }
        return onCreateDrawableState;
    }
}
