package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.8;

class MassSendMsgUI$8$1 implements OnClickListener {
    final /* synthetic */ String jqK;
    final /* synthetic */ 8 onW;

    MassSendMsgUI$8$1(8 8, String str) {
        this.onW = 8;
        this.jqK = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("CropImage_OutputPath", this.jqK);
        MassSendMsgUI.a(this.onW.onR, intent);
    }
}
