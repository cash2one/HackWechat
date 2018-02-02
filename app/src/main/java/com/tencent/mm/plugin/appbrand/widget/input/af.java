package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public enum af {
    ;
    
    static final Class jZJ = null;

    static {
        Class cls = null;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e) {
            x.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[]{e});
        }
        jZJ = cls;
    }

    static Spannable s(CharSequence charSequence) {
        CharSequence charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2 instanceof Spannable) {
            return (Spannable) charSequence2;
        }
        return new SpannableStringBuilder(charSequence2);
    }

    public static boolean t(CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(0, spanned.length(), jZJ);
        if (spans == null || spans.length <= 0) {
            return false;
        }
        return true;
    }

    static boolean bm(Object obj) {
        return jZJ.isInstance(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static InputMethodManager cd(View view) {
        Context context;
        if (view != null) {
            context = view.getContext();
        }
        context = ac.getContext();
        return (InputMethodManager) context.getSystemService("input_method");
    }

    static boolean e(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
