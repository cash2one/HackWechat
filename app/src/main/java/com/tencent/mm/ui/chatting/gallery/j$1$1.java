package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.j.1;
import java.io.File;

class j$1$1 implements Runnable {
    final /* synthetic */ String jqK;
    final /* synthetic */ 1 yGB;

    j$1$1(1 1, String str) {
        this.yGB = 1;
        this.jqK = str;
    }

    public final void run() {
        if (bh.ov(this.jqK)) {
            h.h(this.yGB.yGA.yDo.yCS, R.l.eTc, R.l.dSB);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.jqK)), "video/*");
        try {
            this.yGB.yGA.yDo.yCS.startActivity(Intent.createChooser(intent, this.yGB.yGA.yDo.yCS.mController.xIM.getString(R.l.egS)));
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
            h.h(this.yGB.yGA.yDo.yCS, R.l.efS, R.l.efT);
        }
    }
}
