package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;

class CommonActivityTask$2 implements OnClickListener {
    final /* synthetic */ a mVN;
    final /* synthetic */ CommonActivityTask mVO;

    CommonActivityTask$2(CommonActivityTask commonActivityTask, a aVar) {
        this.mVO = commonActivityTask;
        this.mVN = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mVN.afh();
    }
}
