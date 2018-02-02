package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.tencent.mm.cb.a.j;
import java.util.Locale;

public class YADatePicker extends FrameLayout {
    private static final String Ef = YADatePicker.class.getSimpleName();
    public final b zys;

    static abstract class a implements b {
        protected Context mContext;
        protected YADatePicker zyt;
        protected Locale zyu;
        protected d zyv;

        public a(YADatePicker yADatePicker, Context context) {
            this.zyt = yADatePicker;
            this.mContext = context;
            e(Locale.getDefault());
        }

        protected void e(Locale locale) {
            if (!locale.equals(this.zyu)) {
                this.zyu = locale;
            }
        }
    }

    public YADatePicker(Context context) {
        this(context, null);
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mm.cb.a.a.datePickerStyle);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zys = new c(this, context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.eZE, i, 0);
        int i2 = obtainStyledAttributes.getInt(j.zzW, 0);
        obtainStyledAttributes.recycle();
        if (i2 == 0) {
            return;
        }
        if (i2 <= 0 || i2 > 7) {
            throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
        }
        this.zys.setFirstDayOfWeek(i2);
    }

    @Keep
    public b getUIDelegate() {
        return this.zys;
    }

    public void a(int i, int i2, int i3, d dVar) {
        this.zys.a(i, i2, i3, dVar);
    }

    public int getYear() {
        return this.zys.getYear();
    }

    public int getMonth() {
        return this.zys.getMonth();
    }

    public int getDayOfMonth() {
        return this.zys.getDayOfMonth();
    }

    public void setMinDate(long j) {
        this.zys.setMinDate(j);
    }

    public void setMaxDate(long j) {
        this.zys.setMaxDate(j);
    }

    public void setEnabled(boolean z) {
        if (this.zys.isEnabled() != z) {
            super.setEnabled(z);
            this.zys.setEnabled(z);
        }
    }

    public boolean isEnabled() {
        return this.zys.isEnabled();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.zys.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.zys.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public CharSequence getAccessibilityClassName() {
        return YADatePicker.class.getName();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.zys.onConfigurationChanged(configuration);
    }

    public final void czx() {
        this.zys.setCalendarViewShown(false);
    }

    public final void czy() {
        this.zys.setSpinnersShown(true);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected Parcelable onSaveInstanceState() {
        return this.zys.b(super.onSaveInstanceState());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        BaseSavedState baseSavedState = (BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.zys.onRestoreInstanceState(baseSavedState);
    }
}
