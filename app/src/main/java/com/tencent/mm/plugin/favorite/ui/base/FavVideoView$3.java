package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

class FavVideoView$3 implements Runnable {
    final /* synthetic */ FavVideoView mvJ;
    final /* synthetic */ String mvK;

    FavVideoView$3(FavVideoView favVideoView, String str) {
        this.mvJ = favVideoView;
        this.mvK = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.mvK)), "video/*");
        try {
            this.mvJ.getContext().startActivity(intent);
        } catch (Exception e) {
            x.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
            h.h(this.mvJ.getContext(), R.l.efS, R.l.efT);
        }
    }
}
