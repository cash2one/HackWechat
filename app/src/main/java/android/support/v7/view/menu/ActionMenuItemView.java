package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements android.support.v7.view.menu.m.a, android.support.v7.widget.ActionMenuView.a, OnClickListener, OnLongClickListener {
    public b KA;
    private boolean KB;
    private boolean KC;
    private int KD;
    private int KE;
    private int KF;
    public android.support.v7.view.menu.f.b Ky;
    private android.support.v7.widget.ListPopupWindow.b Kz;
    private h eb;
    private Drawable jY;
    private CharSequence uU;

    public static abstract class b {
        public abstract ListPopupWindow dp();
    }

    private class a extends android.support.v7.widget.ListPopupWindow.b {
        final /* synthetic */ ActionMenuItemView KG;

        public a(ActionMenuItemView actionMenuItemView) {
            this.KG = actionMenuItemView;
            super(actionMenuItemView);
        }

        public final ListPopupWindow dp() {
            if (this.KG.KA != null) {
                return this.KG.KA.dp();
            }
            return null;
        }

        protected final boolean dq() {
            if (this.KG.Ky == null || !this.KG.Ky.f(this.KG.eb)) {
                return false;
            }
            ListPopupWindow dp = dp();
            if (dp == null || !dp.SK.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.KB = resources.getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionMenuItemView, i, 0);
        this.KD = obtainStyledAttributes.getDimensionPixelSize(k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.KF = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.KE = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.KB = getContext().getResources().getBoolean(android.support.v7.a.a.b.abc_config_allowActionMenuItemTextWithIcon);
        dm();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.KE = i;
        super.setPadding(i, i2, i3, i4);
    }

    public final h B() {
        return this.eb;
    }

    public final void a(h hVar) {
        this.eb = hVar;
        Drawable icon = hVar.getIcon();
        this.jY = icon;
        if (icon != null) {
            float f;
            int intrinsicWidth = icon.getIntrinsicWidth();
            int intrinsicHeight = icon.getIntrinsicHeight();
            if (intrinsicWidth > this.KF) {
                f = ((float) this.KF) / ((float) intrinsicWidth);
                intrinsicWidth = this.KF;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.KF) {
                f = ((float) this.KF) / ((float) intrinsicHeight);
                intrinsicHeight = this.KF;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            icon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(icon, null, null, null);
        dm();
        this.uU = hVar.a((android.support.v7.view.menu.m.a) this);
        setContentDescription(this.uU);
        dm();
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.Kz == null) {
            this.Kz = new a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eb.hasSubMenu() && this.Kz != null && this.Kz.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.Ky != null) {
            this.Ky.f(this.eb);
        }
    }

    public final boolean C() {
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dm() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.uU) ? 1 : 0;
        if (this.jY != null) {
            int i3;
            if ((this.eb.LF & 4) == 4) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                if (!this.KB) {
                }
            }
            setText((i2 & i) == 0 ? this.uU : null);
        }
        i = 1;
        if ((i2 & i) == 0) {
        }
        setText((i2 & i) == 0 ? this.uU : null);
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean dn() {
        return hasText() && this.eb.getIcon() == null;
    }

    public final boolean do() {
        return hasText();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (z.I(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.eb.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.KE >= 0) {
            super.setPadding(this.KE, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.KD) : this.KD;
        if (mode != 1073741824 && this.KD > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!hasText && this.jY != null) {
            super.setPadding((getMeasuredWidth() - this.jY.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
