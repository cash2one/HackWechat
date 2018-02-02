package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import com.tencent.mm.plugin.downloader.b$c;
import com.tencent.mm.plugin.downloader.model.f.1.1;
import com.tencent.mm.sdk.platformtools.bh;

class f$1$1$1 implements Runnable {
    final /* synthetic */ 1 lsu;

    f$1$1$1(1 1) {
        this.lsu = 1;
    }

    public final void run() {
        PendingIntent pendingIntent = null;
        if (this.lsu.lst.lrK.field_fileType == 1) {
            pendingIntent = f.cc(this.lsu.lst.lrK.field_filePath, this.lsu.lst.lrK.field_md5);
        }
        f fVar;
        String str;
        if (this.lsu.lst.lrK.field_showNotification && bh.ov(this.lsu.lst.lrK.field_fileName)) {
            fVar = this.lsu.lst.lss;
            str = this.lsu.lst.lrK.field_downloadUrl;
            f.a(fVar, this.lsu.lst.val$context.getString(b$c.lrb), "", pendingIntent);
        } else if (this.lsu.lst.lrK.field_showNotification && !bh.ov(this.lsu.lst.lrK.field_fileName)) {
            fVar = this.lsu.lst.lss;
            str = this.lsu.lst.lrK.field_downloadUrl;
            f.a(fVar, this.lsu.lst.lrK.field_fileName, this.lsu.lst.val$context.getString(b$c.lrb), pendingIntent);
        }
        if (this.lsu.lst.lrK.field_autoInstall && this.lsu.lst.lrK.field_fileType == 1) {
            f.xK(this.lsu.lst.lrK.field_filePath);
        }
        f.a(this.lsu.lst.lss).b(this.lsu.lst.lrL, this.lsu.lst.lrK.field_filePath, this.lsu.lst.lrP);
    }
}
