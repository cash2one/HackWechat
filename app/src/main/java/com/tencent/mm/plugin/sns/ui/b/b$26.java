package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class b$26 extends c {
    final /* synthetic */ b rPY;

    b$26(b bVar) {
        this.rPY = bVar;
    }

    public final boolean cL(View view) {
        Object tag = view.getTag();
        if (!(tag instanceof r)) {
            return false;
        }
        r rVar = (r) tag;
        bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
        if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 10 || com_tencent_mm_protocal_c_bnp.wQo.vYc == 17 || com_tencent_mm_protocal_c_bnp.wQo.vYc == 22 || com_tencent_mm_protocal_c_bnp.wQo.vYc == 23) {
            return false;
        }
        this.rPY.rPp.a(view, rVar.frH, com_tencent_mm_protocal_c_bnp);
        return true;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        Object tag = view.getTag();
        if (tag instanceof r) {
            r rVar = (r) tag;
            bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
            if (d.OQ("favorite")) {
                b dhVar;
                switch (com_tencent_mm_protocal_c_bnp.wQo.vYc) {
                    case 3:
                        contextMenu.add(0, 3, 0, view.getContext().getString(j.eAd));
                        dhVar = new dh();
                        dhVar.frQ.frH = rVar.frH;
                        a.xef.m(dhVar);
                        if (dhVar.frR.frp) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(j.qJu));
                            break;
                        }
                        break;
                    case 4:
                        contextMenu.add(0, 4, 0, view.getContext().getString(j.eAd));
                        dhVar = new dh();
                        dhVar.frQ.frH = rVar.frH;
                        a.xef.m(dhVar);
                        if (dhVar.frR.frp) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(j.qJu));
                            break;
                        }
                        break;
                    case 9:
                        contextMenu.add(0, 5, 0, view.getContext().getString(j.eAd));
                        break;
                    case 14:
                        contextMenu.add(0, 9, 0, view.getContext().getString(j.eAd));
                        break;
                    case 15:
                        contextMenu.add(0, 10, 0, view.getContext().getString(j.eAd));
                        break;
                    case 26:
                        contextMenu.add(0, 22, 0, view.getContext().getString(j.eAd));
                        break;
                    default:
                        contextMenu.add(0, 3, 0, view.getContext().getString(j.eAd));
                        break;
                }
            }
            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, ae.bvv().Lm(rVar.frH));
        }
    }
}
