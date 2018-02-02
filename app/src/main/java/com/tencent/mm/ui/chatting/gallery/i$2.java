package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class i$2 implements Runnable {
    final /* synthetic */ i yFV;
    final /* synthetic */ int yFW;

    i$2(i iVar, int i) {
        this.yFV = iVar;
        this.yFW = i;
    }

    public final void run() {
        x.w("MicroMsg.Imagegallery.handler.video", "show play video error.");
        t.nI(i.a(this.yFV));
        if (this.yFV.yCR != null) {
            OnClickListener 1;
            j cuz = this.yFV.yCR.cuz();
            cuz.cvl().yGl.stop();
            cuz.a(false, 0.0f);
            String string = this.yFV.yCR.yCS.getString(R.l.eTc);
            if (this.yFW == -5103059 || this.yFW == -5103087) {
                string = this.yFV.yCR.yCS.getString(R.l.eTb);
                1 = new 1(this);
            } else {
                1 = new 2(this);
            }
            h.a(this.yFV.yCR.yCS, string, this.yFV.yCR.yCS.getString(R.l.dSB), 1);
            this.yFV.yFE.clear();
            ImageGalleryUI.cuU();
        }
    }
}
