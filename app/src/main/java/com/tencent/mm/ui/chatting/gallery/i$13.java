package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.i.a;
import java.io.File;

class i$13 implements Runnable {
    final /* synthetic */ String mvK;
    final /* synthetic */ i yFV;

    i$13(i iVar, String str) {
        this.yFV = iVar;
        this.mvK = str;
    }

    public final void run() {
        if (this.yFV.yCR == null || this.yFV.yCR.cuz() == null || i.l(this.yFV) == null) {
            x.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
            return;
        }
        this.yFV.yCR.cuz().a(false, 0.0f);
        if (!bh.ov(this.mvK)) {
            x.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", this.mvK);
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(this.mvK)), "video/*");
                this.yFV.yCR.yCS.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                h.h(this.yFV.yCR.yCS, R.l.efS, R.l.efT);
            }
        }
        a aVar = (a) i.l(this.yFV).get(i.a(this.yFV));
        if (aVar != null && aVar.fnB != null) {
            this.yFV.Gg(aVar.pos);
        }
    }
}
