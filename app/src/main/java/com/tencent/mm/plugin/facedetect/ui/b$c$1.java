package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.ui.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$c$1 implements OnClickListener {
    final /* synthetic */ c mkM;

    b$c$1(c cVar) {
        this.mkM = cVar;
    }

    public final void onClick(View view) {
        if (c.a(this.mkM).get() != null) {
            b bVar = (b) c.a(this.mkM).get();
            if (bVar.mkH != null) {
                bVar.mkH.aHm();
            }
            bVar.dismiss();
            return;
        }
        x.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
    }
}
