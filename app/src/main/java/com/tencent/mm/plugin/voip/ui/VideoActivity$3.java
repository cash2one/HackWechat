package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VideoActivity$3 implements OnClickListener {
    final /* synthetic */ VideoActivity spY;

    VideoActivity$3(VideoActivity videoActivity) {
        this.spY = videoActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.spY.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
