package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;

class ad$2 implements OnClickListener {
    final /* synthetic */ ad ruF;

    ad$2(ad adVar) {
        this.ruF = adVar;
    }

    public final void onClick(View view) {
        if (FileOp.bO(this.ruF.videoPath)) {
            int width;
            int height;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                width = view.getWidth();
                height = view.getHeight();
            } else {
                height = 0;
                width = 0;
            }
            Intent intent = new Intent(this.ruF.fmM, SnsOnlineVideoActivity.class);
            intent.putExtra("intent_videopath", this.ruF.videoPath);
            intent.putExtra("intent_thumbpath", this.ruF.fvC);
            intent.putExtra("intent_isad", false);
            intent.putExtra("intent_ispreview", true);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            this.ruF.fmM.startActivity(intent);
            this.ruF.fmM.overridePendingTransition(0, 0);
            return;
        }
        x.i("MicroMsg.SightWidget", "click videopath is not exist " + this.ruF.videoPath);
    }
}
