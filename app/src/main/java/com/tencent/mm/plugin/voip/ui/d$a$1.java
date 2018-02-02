package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.voip.ui.d.a;
import com.tencent.wcdb.FileUtils;

class d$a$1 implements Runnable {
    final /* synthetic */ Bitmap sql;
    final /* synthetic */ a sqm;

    d$a$1(a aVar, Bitmap bitmap) {
        this.sqm = aVar;
        this.sql = bitmap;
    }

    public final void run() {
        if (this.sqm.sqk.sqd != null) {
            this.sqm.sqk.sqd.setBackgroundDrawable(new BitmapDrawable(this.sql));
            this.sqm.sqk.sqd.getBackground().setAlpha(FileUtils.S_IWUSR);
        }
        this.sqm.sqk.sqi = null;
    }
}
