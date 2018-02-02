package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mm.plugin.ah.a.e;
import com.tencent.mm.plugin.ah.a.h;
import com.tencent.mm.plugin.sight.decode.ui.c.1;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1$1 implements Runnable {
    final /* synthetic */ String jqK;
    final /* synthetic */ Bitmap pGu;
    final /* synthetic */ 1 quV;

    c$1$1(1 1, Bitmap bitmap, String str) {
        this.quV = 1;
        this.pGu = bitmap;
        this.jqK = str;
    }

    public final void run() {
        ImageView imageView = (ImageView) this.quV.quU.findViewById(e.cVH);
        imageView.setImageBitmap(this.pGu);
        imageView.setVisibility(0);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.jqK)), "video/*");
        try {
            this.quV.quU.getContext().startActivity(Intent.createChooser(intent, this.quV.quU.getContext().getString(h.sdA)));
        } catch (Exception e) {
            x.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.h(this.quV.quU.getContext(), h.sdC, h.sdD);
        }
    }
}
