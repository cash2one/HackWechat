package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.ui.FavCleanUI.5.1.1;
import com.tencent.mm.plugin.favorite.ui.a.b;
import java.util.ArrayList;
import java.util.List;

class FavCleanUI$5$1$1$1 implements Runnable {
    final /* synthetic */ 1 msm;

    FavCleanUI$5$1$1$1(1 1) {
        this.msm = 1;
    }

    public final void run() {
        b e = this.msm.msl.msi.msh.mrZ;
        List<f> list = this.msm.msj;
        if (e.mul != null) {
            List arrayList = new ArrayList();
            for (f fVar : e.mul) {
                if (fVar != null) {
                    Object obj;
                    for (f fVar2 : list) {
                        if (fVar2 != null && fVar.field_localId == fVar2.field_localId) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        arrayList.add(fVar);
                    }
                }
            }
            e.mul = arrayList;
            arrayList = new ArrayList();
            for (Long l : e.muo) {
                Object obj2;
                for (f fVar3 : list) {
                    if (fVar3 != null && l.equals(Long.valueOf(fVar3.field_localId))) {
                        obj2 = 1;
                        break;
                    }
                }
                obj2 = null;
                if (obj2 == null) {
                    arrayList.add(l);
                }
            }
            e.muo = arrayList;
        }
        this.msm.msl.msi.msh.mrZ.notifyDataSetChanged();
        this.msm.msl.msi.msh.msc.aJy();
        this.msm.msk.dismiss();
    }

    public final String toString() {
        return super.toString() + "|batchDelFavItems";
    }
}
