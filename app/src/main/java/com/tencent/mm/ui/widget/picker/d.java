package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker.Formatter;
import java.util.Locale;

final class d implements Formatter {
    final StringBuilder mBuilder = new StringBuilder();
    char zyp;
    java.util.Formatter zyq;
    final Object[] zyr = new Object[1];

    d() {
        d(Locale.getDefault());
    }

    private void d(Locale locale) {
        this.zyq = new java.util.Formatter(this.mBuilder, locale);
        this.zyp = '0';
    }

    public final String format(int i) {
        Locale locale = Locale.getDefault();
        if (this.zyp != '0') {
            d(locale);
        }
        this.zyr[0] = Integer.valueOf(i);
        this.mBuilder.delete(0, this.mBuilder.length());
        this.zyq.format("%02d", this.zyr);
        return this.zyq.toString();
    }
}
