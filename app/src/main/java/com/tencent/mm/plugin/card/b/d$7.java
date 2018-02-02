package com.tencent.mm.plugin.card.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMActivity;

class d$7 implements OnClickListener {
    final /* synthetic */ MMActivity jvm;

    public d$7(MMActivity mMActivity) {
        this.jvm = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jvm.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
}
