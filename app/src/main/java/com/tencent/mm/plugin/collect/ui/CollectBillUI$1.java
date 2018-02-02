package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class CollectBillUI$1 implements e {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$1(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (i == 0 && i2 == 0) {
                List<cm> list = jVar.liE.vTI;
                if (list == null || list.isEmpty()) {
                    CollectBillUI.a(this.llV).setVisibility(8);
                    return;
                }
                for (cm cmVar : list) {
                    if (cmVar.type == 1 && !bh.ov(cmVar.fyY)) {
                        x.i("MicroMsg.CollectBillUI", "show notice");
                        CollectBillUI.a(this.llV).setText(cmVar.fyY);
                        CollectBillUI.a(this.llV).setOnClickListener(new 1(this, cmVar));
                        CollectBillUI.a(this.llV).setVisibility(0);
                        return;
                    }
                }
                CollectBillUI.a(this.llV).setVisibility(8);
                return;
            }
            x.e("MicroMsg.CollectBillUI", "net error: %s", new Object[]{jVar});
            CollectBillUI.a(this.llV).setVisibility(8);
        }
    }
}
