package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.ui.MMActivity;

public final class j {
    MMActivity iqt;
    int okn;
    int oko;

    public static final class a {
        public int kdK;
        public Drawable okp;
        public int okq;
        public int okr;
        public int oks;
        public int okt;
    }

    public j(MMActivity mMActivity) {
        this.iqt = mMActivity;
        if (aXQ()) {
            Window window = mMActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            this.oko = window.getStatusBarColor();
        }
    }

    private static boolean aXQ() {
        return VERSION.SDK_INT >= 21;
    }

    final void sm(int i) {
        if (aXQ()) {
            Window window = this.iqt.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    static a G(Context context, int i) {
        a aVar = new a();
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                aVar.okp = new ColorDrawable(resources.getColor(c.uaN));
                aVar.kdK = resources.getColor(c.uaO);
                aVar.okq = resources.getColor(c.uaS);
                aVar.okr = resources.getColor(c.uaS);
                aVar.oks = e.ucJ;
                aVar.okt = resources.getColor(c.uaU);
                break;
            default:
                aVar.okp = resources.getDrawable(e.ucI);
                aVar.kdK = -1;
                aVar.okr = resources.getColor(c.uaY);
                aVar.okt = resources.getColor(c.uaL);
                break;
        }
        return aVar;
    }
}
