package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import com.tencent.mm.w.a.k;

public final class h extends DatePickerDialog {
    private boolean ztH;
    private long ztI;
    private int ztJ;

    public h(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.ztH = true;
        this.ztH = true;
        this.ztI = j;
        this.ztJ = 1;
    }

    public h(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, int i4) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.ztH = true;
        this.ztH = true;
        this.ztI = j;
        this.ztJ = i4;
    }

    public h(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, String str) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.ztH = true;
        this.ztH = true;
        this.ztI = j;
        if (str != null) {
            if (str.equals("month")) {
                this.ztJ = 2;
                return;
            }
        }
        this.ztJ = 1;
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        int i = 1;
        super.show();
        if (this.ztH) {
            View n;
            if (VERSION.SDK_INT >= 11) {
                n = new a(this).n((ViewGroup) getWindow().getDecorView());
                if (n != null && this.ztJ > 1) {
                    n.setVisibility(8);
                }
            } else {
                Object string = System.getString(getContext().getContentResolver(), "date_format");
                if (string != null) {
                    string = string.toLowerCase();
                }
                if ("dd/mm/yyyy".equals(string) || "dd-mm-yyyy".equals(string)) {
                    i = 0;
                } else if (!("mm/dd/yyyy".equals(string) || "mm-dd-yyyy".equals(string))) {
                    i = ("yyyy/mm/dd".equals(string) || "yyyy-mm-dd".equals(string)) ? 2 : -1;
                }
                if (i != -1) {
                    n = new b(this).f((ViewGroup) getWindow().getDecorView(), i);
                    if (n != null) {
                        n.setVisibility(8);
                    }
                }
            }
            int year = getDatePicker().getYear();
            i = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            fl(year, i);
        }
        this.ztH = false;
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        super.onDateChanged(datePicker, i, i2, i3);
        fl(i, i2);
    }

    private void fl(int i, int i2) {
        if (this.ztJ > 1) {
            setTitle(getContext().getString(k.gYA, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1)}));
        }
    }
}
