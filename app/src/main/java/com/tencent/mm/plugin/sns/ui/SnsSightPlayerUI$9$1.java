package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class SnsSightPlayerUI$9$1 implements Runnable {
    final /* synthetic */ String jqK;
    final /* synthetic */ Bitmap pGu;
    final /* synthetic */ 9 rGz;

    SnsSightPlayerUI$9$1(9 9, Bitmap bitmap, String str) {
        this.rGz = 9;
        this.pGu = bitmap;
        this.jqK = str;
    }

    public final void run() {
        ImageView imageView = (ImageView) this.rGz.rGv.findViewById(f.cVH);
        if (imageView != null) {
            imageView.setImageBitmap(this.pGu);
            imageView.setVisibility(0);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.jqK)), "video/*");
        try {
            this.rGz.rGv.mController.xIM.startActivity(Intent.createChooser(intent, this.rGz.rGv.mController.xIM.getString(j.egS)));
        } catch (Exception e) {
            x.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
            h.h(this.rGz.rGv.mController.xIM, j.efS, j.efT);
        }
    }
}
