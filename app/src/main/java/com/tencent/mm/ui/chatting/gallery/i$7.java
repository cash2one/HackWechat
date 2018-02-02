package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.x;

class i$7 implements e {
    final /* synthetic */ i yFV;

    i$7(i iVar) {
        this.yFV = iVar;
    }

    public final void bbH() {
        x.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[]{Integer.valueOf(this.yFV.hashCode())});
        try {
            this.yFV.yCR.cuz().a(true, 1.0f);
        } catch (Exception e) {
            x.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e.toString());
        }
    }
}
