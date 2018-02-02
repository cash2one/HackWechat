package com.tencent.mm.ui.a;

import android.content.Context;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.w.a.i;
import java.util.Locale;

public final class a {
    private AccessibilityManager ju;
    Vibrator kEd;
    public Context tI;
    TextToSpeech xNg = null;

    class AnonymousClass1 implements OnInitListener {
        final /* synthetic */ String hMZ;
        final /* synthetic */ a xNh;

        AnonymousClass1(a aVar, String str) {
            this.xNh = aVar;
            this.hMZ = str;
        }

        public final void onInit(int i) {
            if (this.xNh.xNg != null) {
                this.xNh.xNg.setLanguage(w.cfe() ? Locale.CHINESE : Locale.ENGLISH);
                this.xNh.xNg.speak(this.hMZ, 0, null);
            }
        }
    }

    private static class a {
        private static final a xNi = new a(ac.getContext());
    }

    public a(Context context) {
        this.tI = context;
        this.ju = (AccessibilityManager) this.tI.getSystemService("accessibility");
    }

    public final boolean cnH() {
        return this.ju.isEnabled() && this.ju.isTouchExplorationEnabled();
    }

    public final void a(View view, String str, int i, String str2, String str3) {
        if (cnH() && this.tI != null && view != null && str != null && str2 != null && str3 != null) {
            b bVar = new b();
            bVar.Ys(str);
            if (i > 0) {
                bVar.Ys(this.tI.getResources().getQuantityString(i.gYk, 1, new Object[]{Integer.valueOf(i)}));
            }
            bVar.Ys(str2).Ys(str3);
            bVar.dg(view);
        }
    }

    public final void H(View view, int i) {
        if (cnH() && this.tI != null && view != null) {
            int max = Math.max(i, 1);
            b bVar = new b();
            bVar.Ys(this.tI.getResources().getQuantityString(i.gYj, max, new Object[]{Integer.valueOf(max)}));
            bVar.dg(view);
        }
    }
}
