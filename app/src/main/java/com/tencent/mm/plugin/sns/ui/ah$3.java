package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class ah$3 extends w$a {
    final /* synthetic */ ah rvK;

    ah$3(ah ahVar) {
        this.rvK = ahVar;
    }

    public final void xs(int i) {
        x.d("MicroMsg.PicWidget", "I click");
        if (i < 0) {
            this.rvK.bzY();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.rvK.fmM, SnsUploadBrowseUI.class);
        intent.putExtra("sns_gallery_position", i);
        intent.putExtra("sns_gallery_temp_paths", this.rvK.rvD.rvO);
        this.rvK.fmM.startActivityForResult(intent, 7);
    }
}
