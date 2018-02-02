package com.tencent.mm.plugin.collect.reward.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class QrRewardMainUI$8 implements Runnable {
    final /* synthetic */ QrRewardMainUI lkA;
    final /* synthetic */ ViewGroup lkD;
    final /* synthetic */ ImageView lkE;

    QrRewardMainUI$8(QrRewardMainUI qrRewardMainUI, ViewGroup viewGroup, ImageView imageView) {
        this.lkA = qrRewardMainUI;
        this.lkD = viewGroup;
        this.lkE = imageView;
    }

    public final void run() {
        x.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", new Object[]{Integer.valueOf(this.lkD.getHeight()), Integer.valueOf(this.lkD.getWidth())});
        Bitmap createBitmap = Bitmap.createBitmap(QrRewardMainUI.r(this.lkA).getWidth(), QrRewardMainUI.r(this.lkA).getHeight(), Config.ARGB_8888);
        QrRewardMainUI.r(this.lkA).draw(new Canvas(createBitmap));
        this.lkE.setImageBitmap(createBitmap);
        Bitmap createBitmap2 = Bitmap.createBitmap(this.lkD.getWidth(), this.lkD.getHeight(), Config.ARGB_8888);
        this.lkD.draw(new Canvas(createBitmap2));
        try {
            String str = k.ccF() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
            d.a(createBitmap2, 100, CompressFormat.PNG, str, false);
            Toast.makeText(this.lkA.mController.xIM, this.lkA.getString(a$i.dXO, new Object[]{str}), 1).show();
            k.b(str, this.lkA.mController.xIM);
        } catch (Exception e) {
            x.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + e.getMessage());
        }
        QrRewardMainUI.s(this.lkA).setVisibility(8);
        createBitmap2.recycle();
    }
}
