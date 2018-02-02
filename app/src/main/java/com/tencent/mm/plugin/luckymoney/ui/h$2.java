package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.luckymoney.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h$c;

class h$2 implements h$c {
    final /* synthetic */ h ojQ;

    h$2(h hVar) {
        this.ojQ = hVar;
    }

    public final void jl(int i) {
        String b;
        switch (i) {
            case 0:
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "shareImgToFriend");
                b = h.b(this.ojQ);
                Context c = h.c(this.ojQ);
                if (bh.ov(b)) {
                    x.w("MicroMsg.LuckyMoneyApplication", "share image to friend fail, imgPath is null");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", b);
                    intent.putExtra("Retr_Compress_Type", 0);
                    intent.putExtra("Retr_Msg_Type", 0);
                    a.ifs.l(intent, c);
                }
                if (h.d(this.ojQ) == 1) {
                    g.pQN.h(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                    return;
                }
                g.pQN.h(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(2)});
                return;
            case 1:
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "saveImg");
                b = h.b(this.ojQ);
                CharSequence string = h.c(this.ojQ).getString(i.uKI);
                Context c2 = h.c(this.ojQ);
                if (bh.ov(b)) {
                    x.w("MicroMsg.LuckyMoneyApplication", "save image fail, path is null");
                } else if (!d.a(b, c2, i.uRe)) {
                    Toast.makeText(c2, string, 1).show();
                }
                if (h.d(this.ojQ) == 1) {
                    g.pQN.h(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
                    return;
                }
                g.pQN.h(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(2)});
                return;
            case 2:
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "doFav");
                h.e(this.ojQ);
                if (h.d(this.ojQ) == 1) {
                    g.pQN.h(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
                    return;
                }
                g.pQN.h(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(2)});
                return;
            default:
                return;
        }
    }
}
