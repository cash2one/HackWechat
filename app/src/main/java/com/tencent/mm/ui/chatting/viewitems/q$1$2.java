package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.viewitems.q.1;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class q$1$2 implements d {
    final /* synthetic */ au heR;
    final /* synthetic */ int iSi;
    final /* synthetic */ View jLA;
    final /* synthetic */ String tIq;
    final /* synthetic */ 1 yLJ;
    final /* synthetic */ int yLK;

    q$1$2(1 1, View view, String str, au auVar, int i, int i2) {
        this.yLJ = 1;
        this.jLA = view;
        this.tIq = str;
        this.heR = auVar;
        this.yLK = i;
        this.iSi = i2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
        b sgVar;
        LinkedList linkedList;
        bmx com_tencent_mm_protocal_c_bmx;
        switch (menuItem.getItemId()) {
            case 0:
                ((aw) this.jLA.getTag(R.h.czp)).yOZ.setVisibility(0);
                sgVar = new sg();
                sgVar.fJX.fnl = this.tIq;
                sgVar.fJX.action = 1;
                sgVar.fJX.fJZ = 1;
                a.xef.m(sgVar);
                linkedList = new LinkedList();
                com_tencent_mm_protocal_c_bmx = new bmx();
                com_tencent_mm_protocal_c_bmx.wPY = this.tIq;
                com_tencent_mm_protocal_c_bmx.wPX = 0;
                com_tencent_mm_protocal_c_bmx.ktN = 1;
                linkedList.add(com_tencent_mm_protocal_c_bmx);
                q.B(2, q.a(this.yLJ.yLH), q.b(this.yLJ.yLH));
                ar.CG().a(1176, new 1(this));
                ar.CG().a(new k(linkedList), 0);
                if (q.c(this.yLJ.yLH) != null) {
                    q.c(this.yLJ.yLH).cpl();
                    return;
                }
                return;
            case 1:
                ((aw) this.jLA.getTag(R.h.czp)).yOZ.setVisibility(8);
                sgVar = new sg();
                sgVar.fJX.fnl = this.tIq;
                sgVar.fJX.action = 2;
                sgVar.fJX.fJZ = 1;
                a.xef.m(sgVar);
                linkedList = new LinkedList();
                com_tencent_mm_protocal_c_bmx = new bmx();
                com_tencent_mm_protocal_c_bmx.wPY = this.tIq;
                com_tencent_mm_protocal_c_bmx.wPX = 1;
                com_tencent_mm_protocal_c_bmx.ktN = 1;
                linkedList.add(com_tencent_mm_protocal_c_bmx);
                q.B(3, q.a(this.yLJ.yLH), q.b(this.yLJ.yLH));
                ar.CG().a(1176, new 2(this));
                ar.CG().a(new k(linkedList), 0);
                if (q.c(this.yLJ.yLH) != null) {
                    q.c(this.yLJ.yLH).cpl();
                    return;
                }
                return;
            case 2:
                ar.CG().a(1198, new 3(this));
                com.tencent.mm.ae.k oVar = new o(this.heR.field_content);
                q qVar = this.yLJ.yLH;
                Context context = this.jLA.getContext();
                this.jLA.getResources().getString(R.l.dGO);
                q.a(qVar, h.a(context, this.jLA.getResources().getString(R.l.dHc), true, new 4(this, oVar)));
                ar.CG().a(oVar, 0);
                q.B(4, q.a(this.yLJ.yLH), q.b(this.yLJ.yLH));
                return;
            default:
                return;
        }
    }
}
