package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.c.e;
import com.tencent.xweb.xwalk.e.a;
import com.tencent.xweb.xwalk.e.c;
import com.tencent.xweb.xwalk.e.d;
import org.xwalk.core.XWalkView;

public final class f implements e {
    j Ata;
    k Atb;
    XWalkView Atc;

    public f(XWalkView xWalkView) {
        this.Atc = xWalkView;
        this.Ata = new j(xWalkView);
        this.Atb = new k(xWalkView);
    }

    public final void x(String str, Bitmap bitmap) {
        this.Ata.a(this.Atc, str);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (customViewCallback instanceof a) {
            this.Ata.a(view, ((a) customViewCallback).AsW);
        }
    }

    public final void onHideCustomView() {
        this.Ata.cIT();
    }

    public final boolean a(String str, String str2, com.tencent.xweb.f fVar) {
        if (fVar instanceof c) {
            return this.Ata.b(this.Atc, str, str2, ((c) fVar).AsY);
        }
        return false;
    }

    public final boolean b(String str, String str2, com.tencent.xweb.f fVar) {
        if (fVar instanceof c) {
            return this.Ata.a(this.Atc, str, str2, ((c) fVar).AsY);
        }
        return false;
    }

    public final boolean a(String str, String str2, String str3, com.tencent.xweb.e eVar) {
        if (!(eVar instanceof d)) {
            return false;
        }
        return this.Ata.a(this.Atc, str, str2, str3, ((d) eVar).AsY);
    }
}
