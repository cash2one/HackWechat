package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class OnlineVideoView$8 implements Runnable {
    final /* synthetic */ String mvK;
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$8(OnlineVideoView onlineVideoView, String str) {
        this.rvm = onlineVideoView;
        this.mvK = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.mvK)), "video/*");
        try {
            this.rvm.getContext().startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
            h.h(this.rvm.getContext(), j.efS, j.efT);
        }
    }
}
