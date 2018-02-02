package com.tencent.mm.ui.widget.picker;

import android.content.res.Configuration;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;

public interface YADatePicker$b {
    void a(int i, int i2, int i3, d dVar);

    Parcelable b(Parcelable parcelable);

    boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    int getDayOfMonth();

    int getMonth();

    int getYear();

    boolean isEnabled();

    void onConfigurationChanged(Configuration configuration);

    void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    void onRestoreInstanceState(Parcelable parcelable);

    void setCalendarViewShown(boolean z);

    void setEnabled(boolean z);

    void setFirstDayOfWeek(int i);

    void setMaxDate(long j);

    void setMinDate(long j);

    void setSpinnersShown(boolean z);
}
