package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class SnsLongMsgUI$1 implements OnClickListener {
    final /* synthetic */ SnsLongMsgUI rDu;

    SnsLongMsgUI$1(SnsLongMsgUI snsLongMsgUI) {
        this.rDu = snsLongMsgUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.rDu, SnsUploadUI.class);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", bh.Wo());
        intent.putExtra("sns_comment_type", 1);
        intent.putExtra("Ksnsupload_type", 9);
        this.rDu.startActivity(intent);
        this.rDu.finish();
    }
}
