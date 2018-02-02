package com.tencent.mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class ar implements i {
    protected String mPicUrl;

    public ar(String str) {
        this.mPicUrl = str;
        File file = new File(e.gHw);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final b We() {
        return null;
    }

    public final String Wf() {
        return e.gHw + g.s(this.mPicUrl.getBytes());
    }

    public final String Wg() {
        return this.mPicUrl;
    }

    public final String Wh() {
        return this.mPicUrl.hashCode();
    }

    public final String Wi() {
        return this.mPicUrl.hashCode();
    }

    public final boolean Wj() {
        return true;
    }

    public final boolean Wk() {
        return false;
    }

    public final Bitmap Wl() {
        return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        if (a.icf != aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, Wf(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
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
}
