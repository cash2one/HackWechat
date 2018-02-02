package com.tencent.mm.pluginsdk.ui.d;

import android.text.GetChars;
import android.text.Spannable;
import android.text.SpannableString;

public final class j implements GetChars, Spannable, CharSequence {
    private SpannableString vuH;

    public j() {
        this.vuH = null;
        this.vuH = new SpannableString("");
    }

    public j(CharSequence charSequence) {
        this.vuH = null;
        this.vuH = new SpannableString(charSequence);
    }

    public j(String str) {
        this.vuH = null;
        this.vuH = new SpannableString(str);
    }

    public j(SpannableString spannableString) {
        this.vuH = null;
        this.vuH = spannableString;
    }

    public final void a(Object obj, CharSequence charSequence, int i, int i2) {
        a(obj, i, charSequence.length() + i, 33);
    }

    public final void f(Object obj, CharSequence charSequence) {
        a(obj, charSequence, 0, 33);
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        a(obj, i, i2, i3);
    }

    private void a(Object obj, int i, int i2, int i3) {
        if (i >= 0 && i2 <= this.vuH.length()) {
            this.vuH.setSpan(obj, i, i2, i3);
        }
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.vuH.getSpans(i, i2, cls);
    }

    public final int getSpanStart(Object obj) {
        return this.vuH.getSpanStart(obj);
    }

    public final int getSpanEnd(Object obj) {
        return this.vuH.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.vuH.getSpanFlags(obj);
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.vuH.nextSpanTransition(i, i2, cls);
    }

    public final int length() {
        return this.vuH.length();
    }

    public final char charAt(int i) {
        return this.vuH.charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.vuH.subSequence(i, i2);
    }

    public final void removeSpan(Object obj) {
        this.vuH.removeSpan(obj);
    }

    public final void getChars(int i, int i2, char[] cArr, int i3) {
        this.vuH.getChars(i, i2, cArr, i3);
    }

    public final String toString() {
        return this.vuH.toString();
    }
}
