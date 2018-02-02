package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class i {
    static LinkedList<f> vuF = new LinkedList();
    private static boolean vuG = bh.PT();

    public static void a(f fVar) {
        vuF.add(fVar);
    }

    public static void b(f fVar) {
        vuF.remove(fVar);
    }

    public static SpannableString a(TextView textView, Object obj) {
        return a(textView, 1, true, obj);
    }

    public static SpannableString a(TextView textView, int i, boolean z, Object obj) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        o oVar = new o(textView.getContext());
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvs = true;
        oVar.vvu = true;
        oVar.vvw = 1;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        o j = oVar.j(textView);
        j.vvp = true;
        j.vvr = true;
        if (obj != null) {
            j.vvz = obj;
        }
        return j.a(textView.getText(), textSize, z);
    }

    public static SpannableString f(TextView textView, int i) {
        if (textView != null) {
            return a(textView.getContext(), textView, (int) textView.getTextSize(), true, i);
        }
        x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
        return new SpannableString("");
    }

    public static SpannableString b(TextView textView, Object obj) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        o oVar = new o(textView.getContext());
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvw = 1;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        o j = oVar.j(textView);
        j.vvz = obj;
        j.iKB = null;
        j.vvp = true;
        j.vvr = true;
        return j.a(textView.getText(), textSize, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj, String str) {
        o oVar = new o(context);
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvw = 1;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        oVar = oVar.j(null);
        oVar.vvz = obj;
        oVar.iKB = str;
        oVar.vvp = true;
        oVar.vvr = true;
        return oVar.a(charSequence, i, true);
    }

    private static SpannableString a(Context context, TextView textView, int i, boolean z, int i2) {
        o oVar = new o(context);
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvw = i2;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        oVar = oVar.j(textView);
        if (i2 == 1) {
            oVar.vvp = true;
            oVar.vvr = true;
        } else if (i2 == 2) {
            oVar.vvp = false;
            oVar.vvr = false;
        }
        return oVar.a(textView.getText(), i, z);
    }

    public static SpannableString c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, true);
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, true);
    }

    public static SpannableString d(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, false);
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i) {
        o oVar = new o(context);
        oVar.vvo = false;
        oVar.vvp = false;
        oVar.vvl = false;
        oVar.vvq = false;
        oVar.vvw = i;
        oVar.vvn = false;
        oVar.vvy = false;
        CharSequence a = oVar.a(charSequence, 0, true);
        d(a);
        return a;
    }

    private static void d(Spannable spannable) {
        int i = 0;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
    }

    public static SpannableString a(Context context, CharSequence charSequence) {
        return a(context, charSequence, 0, true);
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i, boolean z) {
        o oVar = new o(context);
        oVar.vvo = false;
        oVar.vvp = false;
        oVar.vvl = false;
        oVar.vvq = false;
        oVar.vvn = false;
        oVar.vvy = false;
        CharSequence a = oVar.a(charSequence, i, z);
        d(a);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2) {
        o oVar = new o(context);
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvw = i2;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        if (i2 == 1) {
            oVar.vvp = true;
            oVar.vvr = true;
        } else if (i2 == 2) {
            oVar.vvp = false;
            oVar.vvr = false;
        }
        return oVar.a(charSequence, i, true);
    }

    public static SpannableString e(Context context, CharSequence charSequence, int i) {
        o oVar = new o(context);
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvu = true;
        oVar.vvw = 1;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        oVar.vvz = null;
        oVar.vvp = true;
        oVar.vvr = true;
        return oVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, String str, Object obj) {
        o oVar = new o(context);
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvu = true;
        oVar.vvw = 1;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        oVar.vvz = obj;
        oVar.iKB = str;
        oVar.vvp = true;
        oVar.vvr = true;
        return oVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj) {
        o oVar = new o(context);
        oVar.vvn = true;
        oVar.vvl = true;
        oVar.vvm = vuG;
        oVar.vvu = true;
        oVar.vvw = 1;
        oVar.vvo = true;
        oVar.vvq = false;
        oVar.vvy = true;
        oVar.vvz = obj;
        oVar.vvp = true;
        oVar.vvr = true;
        return oVar.a(charSequence, i, false);
    }

    public static SpannableString f(Context context, CharSequence charSequence, int i) {
        return b(context, charSequence, i, true);
    }

    public static SpannableString e(Context context, CharSequence charSequence, float f) {
        return b(context, charSequence, (int) f, false);
    }

    private static SpannableString b(Context context, CharSequence charSequence, int i, boolean z) {
        o oVar = new o(context);
        oVar.vvn = false;
        oVar.vvl = true;
        oVar.vvs = true;
        oVar.vvt = z;
        oVar.vvu = true;
        oVar.vvw = 1;
        oVar.vvo = false;
        oVar.vvq = false;
        oVar.vvp = false;
        oVar.vvr = false;
        oVar.vvy = false;
        return oVar.a(charSequence, i, true);
    }

    public static String SH(String str) {
        if (bh.ov(str)) {
            return str;
        }
        o oVar = new o(ac.getContext());
        oVar.vvn = false;
        oVar.vvl = true;
        oVar.vvs = true;
        oVar.vvt = true;
        oVar.vvu = true;
        oVar.vvw = 1;
        oVar.vvo = false;
        oVar.vvq = false;
        oVar.vvp = false;
        oVar.vvr = false;
        oVar.vvv = false;
        oVar.vvy = false;
        return oVar.a(str, 0, false).toString();
    }

    public static void clearCache() {
        x.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        o.clearCache();
    }

    public static SpannableString i(TextView textView) {
        if (textView != null) {
            return a(textView.getContext(), textView, (int) textView.getTextSize(), false, 1);
        }
        x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
        return new SpannableString("");
    }
}
