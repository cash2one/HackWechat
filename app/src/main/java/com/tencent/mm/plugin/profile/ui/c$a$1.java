package com.tencent.mm.plugin.profile.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.profile.ui.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$a$1 implements i {
    final /* synthetic */ a pjc;

    c$a$1(a aVar) {
        this.pjc = aVar;
    }

    public final boolean Wk() {
        return false;
    }

    public final boolean Wj() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, i.a aVar, String str) {
        if (i.a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Wf(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactWidgetBizInfo", e, "", new Object[0]);
                x.w("MicroMsg.ContactWidgetBizInfo", "save bitmap fail");
            }
        }
        x.d("MicroMsg.ContactWidgetBizInfo", "get bitmap, from %s", aVar.toString());
        return bitmap;
    }

    public final void Wm() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(i.a aVar, String str) {
    }

    public final b We() {
        return null;
    }

    public final String Wf() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.Fv()).append(ab.UZ(a.a(this.pjc))).toString();
    }

    public final String Wh() {
        return a.a(this.pjc);
    }

    public final Bitmap Wl() {
        return null;
    }

    public final String Wg() {
        return a.a(this.pjc);
    }

    public final String Wi() {
        return a.a(this.pjc);
    }
}
