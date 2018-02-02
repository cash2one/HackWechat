package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.ui.widget.g;
import java.util.List;

public final class m {
    g jDg;
    List<l> jDh;
    p jcr;
    String mAppId;

    public m(Context context, String str, p pVar, List<l> list) {
        this.mAppId = str;
        this.jcr = pVar;
        this.jDh = list;
        this.jDg = new g(context, g.ztp);
        View aeN = this.jcr.aeN();
        if (aeN != null) {
            this.jDg.dO(aeN);
        }
        this.jDg.rKC = new 1(this);
        this.jDg.rKD = new 2(this);
        if (this.jcr.jDZ) {
            g gVar = this.jDg;
            int parseColor = Color.parseColor("#000000");
            if (gVar.lCk != null) {
                gVar.lCk.setBackgroundColor(parseColor);
            }
            gVar.ztf = Boolean.valueOf((((0.299d * ((double) Color.red(parseColor))) + (0.587d * ((double) Color.green(parseColor)))) + (0.114d * ((double) Color.blue(parseColor)))) / 255.0d <= 0.7d);
            if (gVar.ztf.booleanValue() && gVar.ztn != null) {
                gVar.ztn.setImageDrawable(gVar.mContext.getResources().getDrawable(b.zyN));
            }
        }
        this.jDg.tGk = this.jcr.jDU;
        if (this.jcr.irP.Yz()) {
            this.jDg.tGl = this.jcr.jDU;
        }
        this.jDg.bUk();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new 3(this, context));
        }
    }
}
