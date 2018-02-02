package com.tencent.mm.plugin.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class SelectDelRoomMemberUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectDelRoomMemberUI ldt;

    SelectDelRoomMemberUI$1(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        this.ldt = selectDelRoomMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.ldt, this.ldt.getString(R.l.eFb), "", new OnClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI$1 ldu;

            {
                this.ldu = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", bh.d(SelectDelRoomMemberUI.a(this.ldu.ldt), ","));
                this.ldu.ldt.setResult(-1, intent);
                this.ldu.ldt.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ SelectDelRoomMemberUI$1 ldu;

            {
                this.ldu = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return false;
    }
}
