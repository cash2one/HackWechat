package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.i;
import com.tencent.mm.ui.conversation.a.o;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.ad.d.a, b, ao {
    Context context;
    n pUH;
    List<com.tencent.mm.pluginsdk.ui.b.b> yVK = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> yVL = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> yVM = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> yVN = new LinkedList();
    List<com.tencent.mm.pluginsdk.ui.b.b> yVO = new LinkedList();
    c yVP;
    c yVQ;
    ListView yVR;
    View yVS;

    public final void a(Context context, ListView listView, View view) {
        this.context = context;
        this.yVR = listView;
        this.yVS = view;
        this.yVQ = new 1(this);
        com.tencent.mm.sdk.b.a.xef.b(this.yVQ);
        com.tencent.mm.sdk.b.b adVar = new ad();
        adVar.fnU.activity = (Activity) context;
        com.tencent.mm.sdk.b.a.xef.m(adVar);
        adVar = new ae();
        adVar.fnV.fnX = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zaF, null);
        com.tencent.mm.sdk.b.a.xef.m(adVar);
        com.tencent.mm.pluginsdk.ui.b.b bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zaz, null);
        adVar = new ae();
        adVar.fnV.fnX = bVar;
        adVar.fnV.fnW = false;
        adVar.fnV.level = 1;
        com.tencent.mm.sdk.b.a.xef.m(adVar);
        o oVar = (o) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zaE, null);
        adVar = new ae();
        adVar.fnV.fnX = oVar;
        adVar.fnV.fnW = false;
        adVar.fnV.level = 2;
        com.tencent.mm.sdk.b.a.xef.m(adVar);
        com.tencent.mm.ui.conversation.a.a aVar = (com.tencent.mm.ui.conversation.a.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zaB, null);
        adVar = new ae();
        adVar.fnV.fnX = aVar;
        adVar.fnV.fnW = false;
        adVar.fnV.level = 3;
        com.tencent.mm.sdk.b.a.xef.m(adVar);
        com.tencent.mm.ui.d.a aVar2 = (com.tencent.mm.ui.d.a) e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.zaG, new Object[]{com.tencent.mm.z.b.b.b.hir});
        adVar = new ae();
        adVar.fnV.fnX = aVar2;
        adVar.fnV.fnW = true;
        com.tencent.mm.sdk.b.a.xef.m(adVar);
        com.tencent.mm.sdk.b.a.xef.c(this.yVQ);
        List linkedList = new LinkedList();
        linkedList.addAll(this.yVK);
        linkedList.addAll(this.yVL);
        linkedList.addAll(this.yVM);
        linkedList.addAll(this.yVN);
        Collections.sort(linkedList, new 2(this));
        dx(linkedList);
        LinkedList linkedList2 = new LinkedList();
        bVar = (com.tencent.mm.pluginsdk.ui.b.b) e.a(context, com.tencent.mm.ui.conversation.a.e.a.zaA, null);
        if (!(bVar == null || bVar.getView() == null)) {
            listView.addFooterView(bVar.getView());
        }
        this.yVO.add(bVar);
        listView.addFooterView(new i(context).getView(), null, true);
        this.yVO.add(bVar);
        this.pUH = new 3(this);
        ar.a(this.pUH);
        this.yVP = new 4(this);
        com.tencent.mm.sdk.b.a.xef.b(this.yVP);
        ar.Hg();
        com.tencent.mm.z.c.a(this);
        cwo();
    }

    public final void cwo() {
        boolean z = true;
        if (this.context != null && ar.Hj()) {
            x.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[]{Integer.valueOf(hashCode())});
            boolean l = l(this.yVK, true);
            boolean l2 = l(this.yVL, true);
            boolean l3 = l(this.yVM, true);
            boolean l4 = l(this.yVN, true);
            if (!(l || l2 || l3 || l4)) {
                z = false;
            }
            if (l2) {
                dz(this.yVM);
                dz(this.yVN);
            } else if (l3) {
                dz(this.yVN);
            }
            if (z && this.yVR.getVisibility() != 0) {
                this.yVR.setVisibility(0);
                this.yVS.setVisibility(8);
            }
            for (com.tencent.mm.pluginsdk.ui.b.b bVar : this.yVO) {
                if (bVar != null) {
                    bVar.alg();
                }
            }
        }
    }

    public final void jh(String str) {
        if (ar.Hj() && !ar.Cs() && t.ou(str).length() > 0 && str.equals(q.FS())) {
            cwo();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (ar.Hj()) {
            ar.Hg();
            if (mVar == com.tencent.mm.z.c.CU()) {
                int aV = t.aV(obj);
                if (8193 == aV) {
                    cwo();
                }
                if (42 == aV) {
                    cwo();
                }
            }
        }
    }

    public final void GX() {
        cwo();
    }

    private void dx(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b view : list) {
            this.yVR.addHeaderView(view.getView());
        }
    }

    final void dy(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            if (bVar.getView() != null) {
                this.yVR.removeHeaderView(bVar.getView());
            }
        }
    }

    final boolean l(List<com.tencent.mm.pluginsdk.ui.b.b> list, boolean z) {
        boolean z2 = false;
        for (com.tencent.mm.pluginsdk.ui.b.b bVar : list) {
            boolean z3;
            View childAt = ((ViewGroup) bVar.getView()).getChildAt(0);
            if (bVar.alg()) {
                String str = "MicroMsg.BannerHelper";
                String str2 = "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d";
                Object[] objArr = new Object[4];
                objArr[0] = bVar;
                objArr[1] = Boolean.valueOf(z);
                z3 = childAt != null && childAt.getVisibility() == 0;
                objArr[2] = Boolean.valueOf(z3);
                objArr[3] = Integer.valueOf(hashCode());
                x.i(str, str2, objArr);
                if (!z) {
                    return true;
                }
                z3 = true;
            } else {
                if (childAt != null && childAt.getVisibility() == 0) {
                    x.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[]{bVar, Boolean.valueOf(z), Integer.valueOf(hashCode())});
                }
                z3 = z2;
            }
            z2 = z3;
        }
        return z2;
    }

    private static void dz(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b visibility : list) {
            visibility.setVisibility(8);
        }
    }

    static void dA(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b release : list) {
            release.release();
        }
    }

    static void dB(List<com.tencent.mm.pluginsdk.ui.b.b> list) {
        for (com.tencent.mm.pluginsdk.ui.b.b destroy : list) {
            destroy.destroy();
        }
        list.clear();
    }
}
