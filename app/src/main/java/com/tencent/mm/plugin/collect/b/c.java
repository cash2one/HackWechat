package com.tencent.mm.plugin.collect.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements i {
    private b lif = new 1(this);
    private String url;

    public c(String str) {
        this.url = str;
    }

    public final String Wf() {
        return com.tencent.mm.plugin.wallet_core.d.b.Hu(this.url);
    }

    public final String Wg() {
        return this.url;
    }

    public final String Wh() {
        return this.url;
    }

    public final String Wi() {
        return this.url;
    }

    public final boolean Wj() {
        return true;
    }

    public final boolean Wk() {
        return false;
    }

    public final Bitmap Wl() {
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.ice == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.plugin.wallet_core.d.b.Hu(this.url), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e, "", new Object[0]);
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

    public final b We() {
        return this.lif;
    }
}
