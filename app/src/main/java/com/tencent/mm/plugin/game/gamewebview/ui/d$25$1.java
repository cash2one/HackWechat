package com.tencent.mm.plugin.game.gamewebview.ui;

import android.graphics.Color;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ui.d.25;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class d$25$1 implements ValueCallback<String> {
    final /* synthetic */ 25 mZI;

    d$25$1(25 25) {
        this.mZI = 25;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        x.d("MicroMsg.GameWebPageView", "get background color s = %s", new Object[]{str});
        if (!bh.ov(str)) {
            int color = d.t(this.mZI.mZC).getResources().getColor(R.e.buh);
            String[] split;
            if (d.aPq().matcher(str).matches()) {
                split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                if (split.length == 4) {
                    try {
                        color = Color.argb(bh.getInt(bh.ou(split[3]).trim(), 0), bh.getInt(bh.ou(split[0]).trim(), 0), bh.getInt(bh.ou(split[1]).trim(), 0), bh.getInt(bh.ou(split[2]).trim(), 0));
                    } catch (Exception e) {
                        x.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                        return;
                    }
                }
                return;
            } else if (d.aPr().matcher(str).matches()) {
                split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                if (split.length == 3) {
                    try {
                        color = Color.argb(255, bh.getInt(bh.ou(split[0]).trim(), 0), bh.getInt(bh.ou(split[1]).trim(), 0), bh.getInt(bh.ou(split[2]).trim(), 0));
                    } catch (Exception e2) {
                        x.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                        return;
                    }
                }
                return;
            } else {
                x.d("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
            }
            d.h(this.mZI.mZC).AF(color);
            d.h(this.mZI.mZC).bSv();
        }
    }
}
