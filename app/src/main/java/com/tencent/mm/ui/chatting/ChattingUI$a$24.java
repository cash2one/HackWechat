package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.z.ar;

class ChattingUI$a$24 implements OnCancelListener {
    final /* synthetic */ au heZ;
    final /* synthetic */ a ywR;
    final /* synthetic */ z ywX;

    public ChattingUI$a$24(a aVar, au auVar, z zVar) {
        this.ywR = aVar;
        this.heZ = auVar;
        this.ywX = zVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.ChattingUI", "cancel revoke msg:%d", new Object[]{Long.valueOf(this.heZ.field_msgId)});
        ar.CG().c(this.ywX);
    }
}
