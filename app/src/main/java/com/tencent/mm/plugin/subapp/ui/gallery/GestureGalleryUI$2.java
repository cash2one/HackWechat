package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.mm.g.a.kg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class GestureGalleryUI$2 extends c<kg> {
    final /* synthetic */ GestureGalleryUI rXs;

    GestureGalleryUI$2(GestureGalleryUI gestureGalleryUI) {
        this.rXs = gestureGalleryUI;
        this.xen = kg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kg kgVar = (kg) bVar;
        if (kgVar != null) {
            x.i("MicroMsg.GestureGalleryUI", "notify Event: %d", new Object[]{Integer.valueOf(kgVar.fBC.fBA)});
            if (kgVar.fBC.activity == this.rXs && kgVar.fBC.fov.equals(GestureGalleryUI.e(this.rXs))) {
                switch (kgVar.fBC.fBA) {
                    case 0:
                    case 1:
                    case 2:
                        break;
                    case 3:
                        this.rXs.finish();
                        break;
                    default:
                        break;
                }
            }
            x.e("MicroMsg.GestureGalleryUI", "not the same");
        } else {
            x.e("MicroMsg.GestureGalleryUI", "NotifyDealQBarStrResultEvent is null.");
        }
        return false;
    }
}
