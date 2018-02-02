package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.x;

class i$5 implements Runnable {
    final /* synthetic */ String qTs;
    final /* synthetic */ i yFV;
    final /* synthetic */ boolean yFZ;

    i$5(i iVar, String str, boolean z) {
        this.yFV = iVar;
        this.qTs = str;
        this.yFZ = z;
    }

    public final void run() {
        x.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[]{this.qTs, Boolean.valueOf(this.yFZ)});
        if (i.l(this.yFV) == null) {
            x.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
            return;
        }
        i$a com_tencent_mm_ui_chatting_gallery_i_a = (i$a) i.l(this.yFV).get(this.qTs);
        if (com_tencent_mm_ui_chatting_gallery_i_a != null && com_tencent_mm_ui_chatting_gallery_i_a.fnB != null) {
            r bq = i.bq(com_tencent_mm_ui_chatting_gallery_i_a.fnB);
            if (this.yFV.yCR.yCS.cuT() == com_tencent_mm_ui_chatting_gallery_i_a.pos) {
                i.a(this.yFV, com_tencent_mm_ui_chatting_gallery_i_a.fnB, bq, com_tencent_mm_ui_chatting_gallery_i_a.pos, this.yFZ);
                this.yFV.Zp(this.qTs);
                return;
            }
            x.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[]{Integer.valueOf(this.yFV.yCR.yCS.cuT()), Integer.valueOf(com_tencent_mm_ui_chatting_gallery_i_a.pos)});
        }
    }
}
