package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.RoomInfoDetailUI.2;

class RoomInfoDetailUI$2$3 implements OnClickListener {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ 2 lbY;

    RoomInfoDetailUI$2$3(2 2, ProgressDialog progressDialog) {
        this.lbY = 2;
        this.lao = progressDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lao.show();
        RoomInfoDetailUI.a(this.lbY.lbX, false);
        RoomInfoDetailUI.a(this.lbY.lbX, this.lao);
    }
}
