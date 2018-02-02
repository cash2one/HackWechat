package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import com.tencent.mm.cb.a$j;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.cb.a.f;
import com.tencent.mm.ui.widget.picker.YADatePicker.SavedState;
import com.tencent.mm.ui.widget.picker.YADatePicker.a;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class YADatePicker$c extends a {
    Calendar kcY;
    private String[] kcZ;
    private final EditText zyA;
    private final EditText zyB;
    private final EditText zyC;
    private final CalendarView zyD;
    private final DateFormat zyE = new SimpleDateFormat("MM/dd/yyyy");
    private int zyF;
    private Calendar zyG;
    private Calendar zyH;
    Calendar zyI;
    private boolean zyJ = true;
    private final LinearLayout zyw;
    public final NumberPicker zyx;
    public final NumberPicker zyy;
    public final NumberPicker zyz;

    static /* synthetic */ void a(YADatePicker$c yADatePicker$c) {
        InputMethodManager inputMethodManager = (InputMethodManager) yADatePicker$c.zyt.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        if (inputMethodManager.isActive(yADatePicker$c.zyC)) {
            yADatePicker$c.zyC.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(yADatePicker$c.zyt.getWindowToken(), 0);
        } else if (inputMethodManager.isActive(yADatePicker$c.zyB)) {
            yADatePicker$c.zyB.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(yADatePicker$c.zyt.getWindowToken(), 0);
        } else if (inputMethodManager.isActive(yADatePicker$c.zyA)) {
            yADatePicker$c.zyA.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(yADatePicker$c.zyt.getWindowToken(), 0);
        }
    }

    static /* synthetic */ void b(YADatePicker$c yADatePicker$c) {
        yADatePicker$c.zyt.sendAccessibilityEvent(4);
        if (yADatePicker$c.zyv != null) {
            yADatePicker$c.getYear();
            yADatePicker$c.getMonth();
            yADatePicker$c.getDayOfMonth();
        }
    }

    YADatePicker$c(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i, int i2) {
        super(yADatePicker, context);
        this.zyt = yADatePicker;
        this.mContext = context;
        e(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$j.eZE, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(a$j.zzZ, true);
        boolean z2 = obtainStyledAttributes.getBoolean(a$j.zAa, true);
        int i3 = obtainStyledAttributes.getInt(a$j.zAc, 1900);
        int i4 = obtainStyledAttributes.getInt(a$j.zAd, 2100);
        String string = obtainStyledAttributes.getString(a$j.zzX);
        String string2 = obtainStyledAttributes.getString(a$j.zzY);
        int resourceId = obtainStyledAttributes.getResourceId(a$j.zAb, f.zzq);
        obtainStyledAttributes.recycle();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, this.zyt, true);
        OnValueChangeListener 1 = new 1(this);
        this.zyw = (LinearLayout) this.zyt.findViewById(e.zzp);
        this.zyD = (CalendarView) this.zyt.findViewById(e.zzh);
        this.zyD.setOnDateChangeListener(new OnDateChangeListener(this) {
            final /* synthetic */ YADatePicker$c zyK;

            {
                this.zyK = r1;
            }

            public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                this.zyK.am(i, i2, i3);
                this.zyK.czB();
                YADatePicker$c.b(this.zyK);
            }
        });
        this.zyx = (NumberPicker) this.zyt.findViewById(e.kCC);
        this.zyx.setFormatter(new d());
        this.zyx.setOnLongPressUpdateInterval(100);
        this.zyx.setOnValueChangedListener(1);
        this.zyA = c.b(this.zyx);
        this.zyy = (NumberPicker) this.zyt.findViewById(e.month);
        this.zyy.setMinValue(0);
        this.zyy.setMaxValue(this.zyF - 1);
        this.zyy.setDisplayedValues(this.kcZ);
        this.zyy.setOnLongPressUpdateInterval(200);
        this.zyy.setOnValueChangedListener(1);
        this.zyB = c.b(this.zyy);
        this.zyz = (NumberPicker) this.zyt.findViewById(e.year);
        this.zyz.setOnLongPressUpdateInterval(100);
        this.zyz.setOnValueChangedListener(1);
        this.zyC = c.b(this.zyz);
        if (z || z2) {
            setSpinnersShown(z);
            setCalendarViewShown(z2);
        } else {
            setSpinnersShown(true);
        }
        this.kcY.clear();
        if (TextUtils.isEmpty(string) || !a(string, this.kcY)) {
            this.kcY.set(i3, 0, 1);
        }
        setMinDate(this.kcY.getTimeInMillis());
        this.kcY.clear();
        if (TextUtils.isEmpty(string2) || !a(string2, this.kcY)) {
            this.kcY.set(i4, 11, 31);
        }
        setMaxDate(this.kcY.getTimeInMillis());
        this.zyI.setTimeInMillis(System.currentTimeMillis());
        a(this.zyI.get(1), this.zyI.get(2), this.zyI.get(5), null);
        czA();
        if (this.zyt.getImportantForAccessibility() == 0) {
            this.zyt.setImportantForAccessibility(1);
        }
    }

    public final void a(int i, int i2, int i3, d dVar) {
        am(i, i2, i3);
        czB();
        czC();
        this.zyv = dVar;
    }

    public final int getYear() {
        return this.zyI.get(1);
    }

    public final int getMonth() {
        return this.zyI.get(2);
    }

    public final int getDayOfMonth() {
        return this.zyI.get(5);
    }

    public final void setFirstDayOfWeek(int i) {
        this.zyD.setFirstDayOfWeek(i);
    }

    public final void setMinDate(long j) {
        this.kcY.setTimeInMillis(j);
        if (this.kcY.get(1) != this.zyG.get(1) || this.kcY.get(6) == this.zyG.get(6)) {
            this.zyG.setTimeInMillis(j);
            this.zyD.setMinDate(j);
            if (this.zyI.before(this.zyG)) {
                this.zyI.setTimeInMillis(this.zyG.getTimeInMillis());
                czC();
            }
            czB();
        }
    }

    public final void setMaxDate(long j) {
        this.kcY.setTimeInMillis(j);
        if (this.kcY.get(1) != this.zyH.get(1) || this.kcY.get(6) == this.zyH.get(6)) {
            this.zyH.setTimeInMillis(j);
            this.zyD.setMaxDate(j);
            if (this.zyI.after(this.zyH)) {
                this.zyI.setTimeInMillis(this.zyH.getTimeInMillis());
                czC();
            }
            czB();
        }
    }

    public final void setEnabled(boolean z) {
        this.zyx.setEnabled(z);
        this.zyy.setEnabled(z);
        this.zyz.setEnabled(z);
        this.zyD.setEnabled(z);
        this.zyJ = z;
    }

    public final boolean isEnabled() {
        return this.zyJ;
    }

    public final void setCalendarViewShown(boolean z) {
        this.zyD.setVisibility(z ? 0 : 8);
    }

    public final void setSpinnersShown(boolean z) {
        this.zyw.setVisibility(z ? 0 : 8);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        e(configuration.locale);
    }

    public final Parcelable b(Parcelable parcelable) {
        return new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth(), (byte) 0);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        am(SavedState.a(savedState), SavedState.b(savedState), SavedState.c(savedState));
        czB();
        czC();
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.zyI.getTimeInMillis(), 20));
    }

    protected final void e(Locale locale) {
        super.e(locale);
        this.kcY = a(this.kcY, locale);
        this.zyG = a(this.zyG, locale);
        this.zyH = a(this.zyH, locale);
        this.zyI = a(this.zyI, locale);
        this.zyF = this.kcY.getActualMaximum(2) + 1;
        this.kcZ = new DateFormatSymbols().getShortMonths();
        if (czz()) {
            this.kcZ = new String[this.zyF];
            for (int i = 0; i < this.zyF; i++) {
                this.kcZ[i] = String.format("%d", new Object[]{Integer.valueOf(i + 1)});
            }
        }
    }

    private boolean czz() {
        return Character.isDigit(this.kcZ[0].charAt(0));
    }

    private static Calendar a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar instance = Calendar.getInstance(locale);
        instance.setTimeInMillis(timeInMillis);
        return instance;
    }

    private void czA() {
        char[] cArr;
        this.zyw.removeAllViews();
        if (VERSION.SDK_INT < 17 || this.zyt.getLayoutDirection() == 0) {
            cArr = new char[]{'y', 'M', 'd'};
        } else {
            cArr = android.text.format.DateFormat.getDateFormatOrder(this.zyt.getContext());
        }
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            switch (cArr[i]) {
                case 'M':
                    this.zyw.addView(this.zyy);
                    a(this.zyy, length, i);
                    break;
                case 'd':
                    this.zyw.addView(this.zyx);
                    a(this.zyx, length, i);
                    break;
                case 'y':
                    this.zyw.addView(this.zyz);
                    a(this.zyz, length, i);
                    break;
                default:
                    throw new IllegalArgumentException(Arrays.toString(cArr));
            }
        }
    }

    private boolean a(String str, Calendar calendar) {
        try {
            calendar.setTime(this.zyE.parse(str));
            return true;
        } catch (ParseException e) {
            YADatePicker.tz();
            new StringBuilder("Date: ").append(str).append(" not in format: MM/dd/yyyy");
            return false;
        }
    }

    final void am(int i, int i2, int i3) {
        this.zyI.set(i, i2, i3);
        if (this.zyI.before(this.zyG)) {
            this.zyI.setTimeInMillis(this.zyG.getTimeInMillis());
        } else if (this.zyI.after(this.zyH)) {
            this.zyI.setTimeInMillis(this.zyH.getTimeInMillis());
        }
    }

    final void czB() {
        if (this.zyI.equals(this.zyG)) {
            this.zyx.setMinValue(this.zyI.get(5));
            this.zyx.setMaxValue(this.zyI.getActualMaximum(5));
            this.zyx.setWrapSelectorWheel(false);
            this.zyy.setDisplayedValues(null);
            this.zyy.setMinValue(this.zyI.get(2));
            this.zyy.setMaxValue(this.zyI.getActualMaximum(2));
            this.zyy.setWrapSelectorWheel(false);
        } else if (this.zyI.equals(this.zyH)) {
            this.zyx.setMinValue(this.zyI.getActualMinimum(5));
            this.zyx.setMaxValue(this.zyI.get(5));
            this.zyx.setWrapSelectorWheel(false);
            this.zyy.setDisplayedValues(null);
            this.zyy.setMinValue(this.zyI.getActualMinimum(2));
            this.zyy.setMaxValue(this.zyI.get(2));
            this.zyy.setWrapSelectorWheel(false);
        } else {
            this.zyx.setMinValue(1);
            this.zyx.setMaxValue(this.zyI.getActualMaximum(5));
            this.zyx.setWrapSelectorWheel(true);
            this.zyy.setDisplayedValues(null);
            this.zyy.setMinValue(0);
            this.zyy.setMaxValue(11);
            this.zyy.setWrapSelectorWheel(true);
        }
        this.zyy.setDisplayedValues((String[]) Arrays.copyOfRange(this.kcZ, this.zyy.getMinValue(), this.zyy.getMaxValue() + 1));
        this.zyz.setMinValue(this.zyG.get(1));
        this.zyz.setMaxValue(this.zyH.get(1));
        this.zyz.setWrapSelectorWheel(false);
        this.zyz.setValue(this.zyI.get(1));
        this.zyy.setValue(this.zyI.get(2));
        this.zyx.setValue(this.zyI.get(5));
        if (czz()) {
            this.zyB.setRawInputType(2);
        }
    }

    final void czC() {
        this.zyD.setDate(this.zyI.getTimeInMillis(), false, false);
    }

    private static void a(NumberPicker numberPicker, int i, int i2) {
        int i3;
        if (i2 < i - 1) {
            i3 = 5;
        } else {
            i3 = 6;
        }
        TextView b = c.b(numberPicker);
        if (b != null) {
            b.setImeOptions(i3);
        }
    }
}
