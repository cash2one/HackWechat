package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;
import com.tencent.mm.ag.d;
import com.tencent.mm.bc.b;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

public final class a {
    private static af haq = new af(Looper.getMainLooper());

    public static d a(d dVar, pr prVar) {
        if (prVar != null) {
            dVar.field_brandFlag = prVar.hvH;
            dVar.field_brandIconURL = prVar.hvK;
            dVar.field_brandInfo = prVar.hvJ;
            dVar.field_extInfo = prVar.hvI;
        }
        return dVar;
    }

    public static Spanned b(Context context, String str, List<String> list) {
        if (bh.ov(str)) {
            return null;
        }
        if (context == null || list == null) {
            return new SpannableString(str);
        }
        return b.a((CharSequence) str, (List) list);
    }

    public static boolean b(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return false;
        }
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
        return true;
    }
}
