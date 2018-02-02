package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import com.tencent.magicbrush.engine.c;

class a$b implements Runnable {
    private String boL;
    private Bitmap boM;
    volatile boolean boN;

    private a$b(String str, Bitmap bitmap) {
        this.boN = false;
        this.boL = str;
        this.boM = bitmap;
    }

    public final void run() {
        if (this.boN) {
            this.boM.recycle();
        } else {
            c.a(this.boL, this.boM);
        }
    }
}
