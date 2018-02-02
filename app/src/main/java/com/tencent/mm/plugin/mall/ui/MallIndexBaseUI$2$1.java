package com.tencent.mm.plugin.mall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.2;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;

class MallIndexBaseUI$2$1 implements OnClickListener {
    final /* synthetic */ MallFunction omb;
    final /* synthetic */ int omc;
    final /* synthetic */ 2 omd;

    MallIndexBaseUI$2$1(2 2, MallFunction mallFunction, int i) {
        this.omd = 2;
        this.omb = mallFunction;
        this.omc = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = null;
        String str = this.omb.pBK;
        if (!bh.ov(str)) {
            g.Dk();
            Object obj2 = (String) g.Dj().CU().get(a.xqq, null);
            if (bh.ov(obj2)) {
                obj2 = str;
            } else {
                String[] split = obj2.split(",");
                if (split == null || split.length == 0) {
                    String str2 = str;
                } else {
                    for (String equals : split) {
                        if (equals.equals(str)) {
                            obj = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        obj2 = obj2 + "," + str;
                    }
                }
            }
            g.Dk();
            g.Dj().CU().a(a.xqq, obj2);
        }
        this.omd.oma.a(this.omb, this.omc);
    }
}
