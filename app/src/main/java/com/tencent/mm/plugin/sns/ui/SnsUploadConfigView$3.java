package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;

class SnsUploadConfigView$3 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView rLD;

    SnsUploadConfigView$3(SnsUploadConfigView snsUploadConfigView) {
        this.rLD = snsUploadConfigView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("is_force_unbind", true);
        intent.putExtra("shake_music", true);
        d.a(this.rLD.getContext(), ".ui.account.FacebookAuthUI", intent, 8);
    }
}
