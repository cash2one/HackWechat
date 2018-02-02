package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;

class MallIndexBaseUI$2 implements b$d {
    final /* synthetic */ MallIndexBaseUI oma;

    MallIndexBaseUI$2(MallIndexBaseUI mallIndexBaseUI) {
        this.oma = mallIndexBaseUI;
    }

    public final void a(int i, MallFunction mallFunction) {
        if (mallFunction != null) {
            int i2;
            String str = mallFunction.pBK;
            if (bh.ov(str)) {
                i2 = 1;
            } else {
                g.Dk();
                String str2 = (String) g.Dj().CU().get(a.xqq, null);
                if (bh.ov(str2)) {
                    i2 = 0;
                } else {
                    String[] split = str2.split(",");
                    if (split == null || split.length == 0) {
                        i2 = 0;
                    } else {
                        for (String equals : split) {
                            if (equals.equals(str)) {
                                i2 = 1;
                                break;
                            }
                        }
                        i2 = 0;
                    }
                }
            }
            if (i2 != 0 || bh.ov(mallFunction.sQu)) {
                this.oma.a(mallFunction, i);
            } else {
                x.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[]{mallFunction.pBK});
                h.a(this.oma.mController.xIM, mallFunction.sQu, this.oma.getString(i.uLY), this.oma.getString(i.uNV), new 1(this, mallFunction, i));
            }
            x.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[]{Integer.valueOf(mallFunction.type)});
            com.tencent.mm.plugin.report.service.g.pQN.h(14419, new Object[]{this.oma.ned, Integer.valueOf(4), Integer.valueOf(mallFunction.type)});
            return;
        }
        x.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[]{Integer.valueOf(i)});
    }
}
