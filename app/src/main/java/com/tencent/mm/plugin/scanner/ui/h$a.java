package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

final class h$a implements i {
    private String mPicUrl = null;

    public h$a(String str) {
        this.mPicUrl = str;
    }

    public final String Wf() {
        return c.boA().dS(this.mPicUrl, "@S");
    }

    public final String Wg() {
        return this.mPicUrl;
    }

    public final String Wh() {
        return this.mPicUrl;
    }

    public final String Wi() {
        return this.mPicUrl;
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
                x.printErrStackTrace("MicroMsg.ProductGridPreference", e, "", new Object[0]);
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
