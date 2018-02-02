package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$5 implements Runnable {
    final /* synthetic */ CollectMainUI lnh;
    final /* synthetic */ LinearLayout lnj;

    CollectMainUI$5(CollectMainUI collectMainUI, LinearLayout linearLayout) {
        this.lnh = collectMainUI;
        this.lnj = linearLayout;
    }

    public final void run() {
        x.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[]{Integer.valueOf(this.lnj.getHeight()), Integer.valueOf(this.lnj.getWidth())});
        Bitmap createBitmap = Bitmap.createBitmap(this.lnj.getWidth(), this.lnj.getHeight(), Config.ARGB_8888);
        this.lnj.draw(new Canvas(createBitmap));
        try {
            String str = k.ccF() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
            d.a(createBitmap, 100, CompressFormat.PNG, str, false);
            Toast.makeText(this.lnh.mController.xIM, this.lnh.getString(i.uRe, new Object[]{str}), 1).show();
            k.b(str, this.lnh.mController.xIM);
        } catch (Exception e) {
            x.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e.getMessage());
        }
        this.lnh.lkr.setVisibility(8);
    }
}
