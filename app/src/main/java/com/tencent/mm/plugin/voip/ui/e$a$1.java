package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.voip.ui.e.a;

class e$a$1 implements Runnable {
    final /* synthetic */ Bitmap sql;
    final /* synthetic */ a srP;

    e$a$1(a aVar, Bitmap bitmap) {
        this.srP = aVar;
        this.sql = bitmap;
    }

    public final void run() {
        if (this.srP.srL.sqd != null) {
            this.srP.srL.sqd.setBackgroundDrawable(new BitmapDrawable(this.sql));
        }
        e.B(this.srP.srL);
    }
}
