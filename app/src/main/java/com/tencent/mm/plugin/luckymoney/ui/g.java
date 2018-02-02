package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g {

    public static final class c {
        public boolean ojr = false;
        public int ojs = 0;
        public int resourceId = 0;
        public int textColor = Integer.MIN_VALUE;
        public int textSize = Integer.MIN_VALUE;
    }

    static class e implements d {
        c ojm;

        e() {
        }

        public final void a(Context context, ViewGroup viewGroup, ah ahVar) {
            if (!bh.ov(ahVar.name)) {
                View inflate = LayoutInflater.from(context).inflate(com.tencent.mm.plugin.wxpay.a.g.uCI, viewGroup, true);
                TextView textView = (TextView) inflate.findViewById(f.upG);
                ImageView imageView = (ImageView) inflate.findViewById(f.upF);
                if (bh.ov(ahVar.iconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    n.h(imageView, ahVar.iconUrl);
                    imageView.setVisibility(0);
                }
                if (!(this.ojm == null || this.ojm.textColor == Integer.MIN_VALUE)) {
                    textView.setTextColor(this.ojm.textColor);
                }
                if (this.ojm == null || this.ojm.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(d.bvs));
                } else {
                    textView.setTextSize(0, (float) this.ojm.textSize);
                }
                textView.setGravity(17);
                textView.setText(ahVar.name);
                if (!bh.ov(ahVar.content)) {
                    textView.setOnClickListener(new 1(this, ahVar, context));
                }
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ahVar.odF)});
                if (this.ojm != null) {
                    com.tencent.mm.protocal.f.eB(this.ojm.ojs, 0);
                }
            }
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ah ahVar, c cVar) {
        if (ahVar != null) {
            a(context, viewGroup, ahVar, cVar, ahVar.type);
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ah ahVar, c cVar, String str) {
        if (viewGroup != null && ahVar != null) {
            if (ahVar.gEx == 0) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + ahVar.gEx);
                viewGroup.setVisibility(8);
            } else if (!ahVar.type.equalsIgnoreCase(str)) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + ahVar.type + ", " + str);
                viewGroup.setVisibility(8);
            } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
                r0 = new e();
                r0.ojm = cVar;
                r0.a(context, viewGroup, ahVar);
            } else if (str.equalsIgnoreCase("Pic")) {
                r0 = new a();
                r0.ojm = cVar;
                r0.a(context, viewGroup, ahVar);
            } else if (str.equalsIgnoreCase("Appid")) {
                r0 = new b();
                r0.ojm = cVar;
                r0.a(context, viewGroup, ahVar);
            }
        }
    }
}
