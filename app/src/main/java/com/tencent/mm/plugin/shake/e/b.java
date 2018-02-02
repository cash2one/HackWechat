package com.tencent.mm.plugin.shake.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements i {
    private c$a qsP = null;
    private String thumburl = "";

    public b(c$a com_tencent_mm_plugin_shake_e_c_a) {
        this.qsP = com_tencent_mm_plugin_shake_e_c_a;
    }

    public b(String str) {
        this.thumburl = str;
    }

    public final String Wf() {
        if (this.qsP != null && this.qsP.field_thumburl != null) {
            return m.dS(this.qsP.field_thumburl, "@S");
        }
        if (this.thumburl != null) {
            return m.dS(this.thumburl, "@S");
        }
        return "";
    }

    public final String Wg() {
        if (this.qsP == null || this.qsP.field_thumburl == null) {
            return this.thumburl;
        }
        return this.qsP.field_thumburl;
    }

    public final String Wh() {
        return Wg() + "_tv";
    }

    public final String Wi() {
        return Wg() + "_tv";
    }

    public final boolean Wj() {
        return false;
    }

    public final boolean Wk() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ice == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Wf(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TVImgGetStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Wm() {
    }

    public final void N(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final Bitmap Wl() {
        if (ac.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
    }

    public final com.tencent.mm.platformtools.i.b We() {
        return null;
    }
}
