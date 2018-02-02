package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.b;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.g.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BankRemitSelectBankUI$4 implements a {
    final /* synthetic */ BankRemitSelectBankUI pJH;
    final /* synthetic */ h pJI;

    BankRemitSelectBankUI$4(BankRemitSelectBankUI bankRemitSelectBankUI, h hVar) {
        this.pJH = bankRemitSelectBankUI;
        this.pJI = hVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        List arrayList = new ArrayList();
        List<ez> list = this.pJI.pHj.wiM;
        List<ez> list2 = this.pJI.pHj.wiL;
        Comparator bVar = new b();
        if (!(list == null || list.isEmpty())) {
            x.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", new Object[]{Integer.valueOf(list2.size())});
            for (ez ezVar : list) {
                d dVar = new d();
                dVar.ykk = "☆";
                dVar.data = ezVar;
                arrayList.add(dVar);
            }
        }
        if (!(list2 == null || list2.isEmpty())) {
            x.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", new Object[]{Integer.valueOf(list2.size())});
            Collections.sort(list2, bVar);
            for (ez ezVar2 : list2) {
                if (!bh.ov(ezVar2.nBM)) {
                    String str2;
                    if (bh.ov(ezVar2.vKN)) {
                        str2 = com.tencent.mm.plugin.remittance.bankcard.model.a.In(ezVar2.nBM);
                    } else {
                        x.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", new Object[]{ezVar2.vKN});
                        str2 = ezVar2.vKN.toUpperCase().charAt(0);
                    }
                    d dVar2 = new d();
                    dVar2.ykk = str2;
                    dVar2.data = ezVar2;
                    arrayList.add(dVar2);
                }
            }
        }
        BankRemitSelectBankUI.a(this.pJH).cZ(arrayList);
    }
}
