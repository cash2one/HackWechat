package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.File;
import java.util.ArrayList;

public final class b extends c<ai> {
    private ArrayList<String> obx;

    public b() {
        this.obx = new ArrayList();
        this.xen = ai.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ai aiVar = (ai) bVar;
        if (!g.Dh().Cy()) {
            x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (aiVar instanceof ai) {
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            g.Dk();
            int intValue = ((Integer) g.Dj().CU().get(a.xre, Integer.valueOf(1))).intValue();
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:" + intValue);
            if (intValue == 0) {
                x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = aiVar.foq.for;
                String str2 = aiVar.foq.fos;
                int i = aiVar.foq.fot;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!an.isWifi(ac.getContext())) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.obx.contains(str)) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:" + str);
                } else {
                    String str3 = n.DW(str) + ".temp";
                    if (new File(str3).exists()) {
                        x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.obx.add(str);
                        new j().a(str, str2, i, str3, new 1(this));
                    }
                }
            }
        }
        return false;
    }
}
