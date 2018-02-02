package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SnsUserUI$4 implements bb$a {
    final /* synthetic */ SnsUserUI rMb;

    SnsUserUI$4(SnsUserUI snsUserUI) {
        this.rMb = snsUserUI;
    }

    public final void bBJ() {
        if (SnsUserUI.b(this.rMb) == null) {
            SnsUserUI.a(this.rMb, ae.bvl());
        }
        a b = SnsUserUI.b(this.rMb);
        String c = SnsUserUI.c(this.rMb);
        SnsUserUI.d(this.rMb);
        b.b(2, c, SnsUserUI.f(this.rMb), SnsUserUI.e(this.rMb));
        ae.aNT().postDelayed(SnsUserUI.g(this.rMb), 3000);
    }

    public final ListView bBK() {
        return (ListView) this.rMb.findViewById(f.qFg);
    }

    public final MMPullDownView bBL() {
        return (MMPullDownView) this.rMb.findViewById(f.qFn);
    }

    public final int getType() {
        return 2;
    }

    public final void a(int i, List<Integer> list, List<Integer> list2) {
        at a;
        if (!(i == -1 || SnsUserUI.a(this.rMb) == null)) {
            a = SnsUserUI.a(this.rMb);
            if (a.rFa != null) {
                au auVar = a.rFa;
                m xo = ae.bvv().xo(i);
                if (!(xo == null || xo.bxV().wQo == null || auVar.list.size() <= 0)) {
                    auVar.list.add(1, xo);
                    auVar.bBt();
                    auVar.bBu();
                }
            }
        }
        if (SnsUserUI.a(this.rMb) != null && list != null && list2 != null) {
            a = SnsUserUI.a(this.rMb);
            if (a.rFa != null && list != null && list2 != null && list.size() + list2.size() != 0) {
                int i2;
                m mVar;
                au auVar2 = a.rFa;
                if (!(list == null || list.size() == 0)) {
                    x.d("MicroMsg.SnsSelfHelper", "remove Items");
                    for (Integer intValue : list) {
                        int intValue2 = intValue.intValue();
                        int size = auVar2.list.size();
                        for (i2 = 1; i2 < size; i2++) {
                            mVar = (m) auVar2.list.get(i2);
                            if (mVar != null && mVar.roJ == intValue2) {
                                auVar2.list.remove(i2);
                                break;
                            }
                        }
                    }
                }
                if (!(list2 == null || list2.size() == 0)) {
                    x.d("MicroMsg.SnsSelfHelper", "change Items");
                    LinkedList linkedList = new LinkedList();
                    i2 = 1;
                    while (i2 < auVar2.list.size()) {
                        mVar = (m) auVar2.list.get(i2);
                        if (mVar != null) {
                            for (Integer intValue3 : list2) {
                                int intValue4 = intValue3.intValue();
                                if (mVar.roJ == intValue4) {
                                    x.d("MicroMsg.SnsSelfHelper", "update list localId " + intValue4);
                                    auVar2.list.remove(i2);
                                    linkedList.add(ae.bvv().xo(intValue4));
                                    i2--;
                                    break;
                                }
                            }
                        }
                        i2++;
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        auVar2.list.add((m) it.next());
                    }
                }
                auVar2.bBt();
                auVar2.bBu();
            }
        }
    }

    public final boolean bBM() {
        return false;
    }

    public final void bBN() {
        a b = SnsUserUI.b(this.rMb);
        String c = SnsUserUI.c(this.rMb);
        SnsUserUI.d(this.rMb);
        b.a(2, c, SnsUserUI.f(this.rMb), SnsUserUI.e(this.rMb));
    }

    public final void bBO() {
    }

    public final void xM(int i) {
    }

    public final void L(int i, boolean z) {
        Object obj = null;
        if (SnsUserUI.a(this.rMb) != null) {
            at a = SnsUserUI.a(this.rMb);
            if (a.rFa != null) {
                au auVar = a.rFa;
                m xo = ae.bvv().xo(i);
                if (xo != null && xo.bxV().wQo != null && auVar.list.size() > 0) {
                    for (int i2 = 0; i2 < auVar.list.size(); i2++) {
                        if (((m) auVar.list.get(i2)).byq() == xo.byq()) {
                            obj = 1;
                            auVar.list.remove(i2);
                            break;
                        }
                    }
                    if (obj != null) {
                        auVar.list.add(xo);
                        auVar.bBt();
                        auVar.bBu();
                    }
                }
            }
        }
    }

    public final void iL(boolean z) {
    }
}
