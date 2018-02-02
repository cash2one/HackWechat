package com.tencent.mm.ui.chatting.f.a;

import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.au;

public class a {
    private static volatile a yHR = null;
    private static final ag yHS = new ag();

    private a() {
    }

    public static a cvt() {
        if (yHR != null) {
            return yHR;
        }
        a aVar;
        synchronized (a.class) {
            if (yHR == null) {
                yHR = new a();
            }
            aVar = yHR;
        }
        return aVar;
    }

    public static com.tencent.mm.ui.widget.MMTextView.a cvu() {
        return a.yHT;
    }

    private static void a(CharSequence charSequence, au auVar, int i) {
        if (charSequence instanceof Spannable) {
            yHS.F(new b(charSequence, auVar, i));
        }
    }

    public static void a(CharSequence charSequence, au auVar) {
        a(charSequence, auVar, 1);
    }
}
