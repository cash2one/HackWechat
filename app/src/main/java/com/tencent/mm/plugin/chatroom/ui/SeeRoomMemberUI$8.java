package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SeeRoomMemberUI$8 implements OnItemLongClickListener {
    final /* synthetic */ SeeRoomMemberUI lde;

    SeeRoomMemberUI$8(SeeRoomMemberUI seeRoomMemberUI) {
        this.lde = seeRoomMemberUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (SeeRoomMemberUI.j(this.lde)) {
            af afVar = SeeRoomMemberUI.c(this.lde).og(i).jLe;
            if (afVar != null) {
                if (!SeeRoomMemberUI.f(this.lde).field_roomowner.equals(afVar.field_username)) {
                    h.a(this.lde, this.lde.getString(R.l.eFa), "", new 1(this, i), new 2(this));
                }
            }
        } else {
            x.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
        return true;
    }
}
