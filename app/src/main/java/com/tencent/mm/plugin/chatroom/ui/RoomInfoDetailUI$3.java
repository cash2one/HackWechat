package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import com.tencent.mm.z.ba.a;

class RoomInfoDetailUI$3 implements a {
    final /* synthetic */ ProgressDialog lao;
    final /* synthetic */ RoomInfoDetailUI lbX;

    RoomInfoDetailUI$3(RoomInfoDetailUI roomInfoDetailUI, ProgressDialog progressDialog) {
        this.lbX = roomInfoDetailUI;
        this.lao = progressDialog;
    }

    public final boolean HB() {
        return RoomInfoDetailUI.b(this.lbX);
    }

    public final void HA() {
        if (this.lao != null) {
            this.lao.dismiss();
        }
    }
}
