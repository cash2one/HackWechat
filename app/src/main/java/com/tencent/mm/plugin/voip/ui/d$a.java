package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ad.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public class d$a implements Runnable {
    final /* synthetic */ d sqk;

    public d$a(d dVar) {
        this.sqk = dVar;
    }

    public final void run() {
        x.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
        Bitmap a = b.a(this.sqk.gAb, false, -1);
        if (a != null && this.sqk.sqc != null) {
            int i = 0;
            while (true) {
                if ((this.sqk.sqc.getHeight() == 0 || this.sqk.sqc.getWidth() == 0) && i < 10) {
                    try {
                        Thread.sleep(300);
                        i++;
                    } catch (InterruptedException e) {
                        x.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                        return;
                    }
                }
            }
            if (a.getHeight() <= a.getWidth() && a.getHeight() / 5 > 0 && ((int) (((double) a.getHeight()) * 0.6d)) > 0) {
                a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
            }
            a = d.a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) this.sqk.sqc.getHeight())) / ((float) this.sqk.sqc.getWidth()))), true, false);
            if (a == null) {
                x.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                return;
            }
            try {
                a = d.c(a, 20);
                x.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                this.sqk.jKT.post(new 1(this, a));
            } catch (Exception e2) {
                x.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
            }
        }
    }
}
