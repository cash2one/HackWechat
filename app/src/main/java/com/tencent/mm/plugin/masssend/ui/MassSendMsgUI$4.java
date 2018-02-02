package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelvideo.c;

class MassSendMsgUI$4 implements OnCancelListener {
    final /* synthetic */ MassSendMsgUI onR;
    final /* synthetic */ c onS;

    MassSendMsgUI$4(MassSendMsgUI massSendMsgUI, c cVar) {
        this.onR = massSendMsgUI;
        this.onS = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.onS.hTo = null;
    }
}
