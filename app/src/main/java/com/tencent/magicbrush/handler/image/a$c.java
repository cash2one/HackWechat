package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;

class a$c implements Runnable {
    private String boL;
    private boolean boN;
    private a$b boO;
    final /* synthetic */ a boP;

    static /* synthetic */ void a(a$c com_tencent_magicbrush_handler_image_a_c) {
        synchronized (com_tencent_magicbrush_handler_image_a_c) {
            com_tencent_magicbrush_handler_image_a_c.boN = true;
            if (com_tencent_magicbrush_handler_image_a_c.boO != null) {
                com_tencent_magicbrush_handler_image_a_c.boO.boN = true;
            }
        }
    }

    private a$c(a aVar, String str) {
        this.boP = aVar;
        this.boN = false;
        this.boL = str;
    }

    public final void run() {
        Bitmap loadBitmapSync = this.boP.loadBitmapSync(this.boL);
        synchronized (this) {
            if (this.boN) {
                return;
            }
            this.boO = new a$b(this.boL, loadBitmapSync);
            this.boP.boE.e(this.boO);
        }
    }
}
