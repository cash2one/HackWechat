package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.g.a.kg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ImageGalleryUI$12 extends c<kg> {
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$12(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
        this.xen = kg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kg kgVar = (kg) bVar;
        if (kgVar != null && (kgVar instanceof kg)) {
            x.i("MicroMsg.ImageGalleryUI", "notify Event: %d", new Object[]{Integer.valueOf(kgVar.fBC.fBA)});
            if (kgVar.fBC.activity == this.yFy && kgVar.fBC.fov.equals(ImageGalleryUI.c(this.yFy))) {
                switch (kgVar.fBC.fBA) {
                    case 0:
                    case 1:
                    case 2:
                        break;
                    case 3:
                        this.yFy.finish();
                        break;
                    default:
                        break;
                }
            }
            x.e("MicroMsg.ImageGalleryUI", "not the same");
        } else {
            x.e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
        }
        return false;
    }
}
