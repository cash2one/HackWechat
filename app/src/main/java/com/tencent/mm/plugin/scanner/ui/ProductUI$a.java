package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.util.n$a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class ProductUI$a implements i {
    private n$a pVZ;

    public ProductUI$a(n$a com_tencent_mm_plugin_scanner_util_n_a) {
        this.pVZ = com_tencent_mm_plugin_scanner_util_n_a;
    }

    public final String Wf() {
        return c.boA().dS(this.pVZ.field_thumburl, "@S");
    }

    public final String Wg() {
        if (this.pVZ == null) {
            return "";
        }
        return this.pVZ.field_thumburl;
    }

    public final String Wh() {
        if (this.pVZ == null) {
            return "";
        }
        return this.pVZ.field_thumburl;
    }

    public final String Wi() {
        if (this.pVZ == null) {
            return "";
        }
        return this.pVZ.field_thumburl;
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
                x.printErrStackTrace("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
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

    public final b We() {
        return null;
    }
}
