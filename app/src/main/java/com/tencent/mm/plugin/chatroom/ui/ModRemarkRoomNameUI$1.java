package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class ModRemarkRoomNameUI$1 extends c<lj> {
    final /* synthetic */ ModRemarkRoomNameUI lbl;

    ModRemarkRoomNameUI$1(ModRemarkRoomNameUI modRemarkRoomNameUI) {
        this.lbl = modRemarkRoomNameUI;
        this.xen = lj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lj ljVar = (lj) bVar;
        String str = ljVar.fCK.fCL;
        String str2 = ljVar.fCK.fCM;
        int i = ljVar.fCK.ret;
        if (i != 0 && str2 != null) {
            h.b(this.lbl, str2, str, true);
            if (ModRemarkRoomNameUI.a(this.lbl) != null) {
                ar.Hg();
                com.tencent.mm.z.c.EX().c(ModRemarkRoomNameUI.a(this.lbl));
            }
        } else if (i == 0 && ModRemarkRoomNameUI.b(this.lbl)) {
            Intent intent = new Intent();
            intent.putExtra("room_name", ModRemarkRoomNameUI.c(this.lbl));
            this.lbl.setResult(-1, intent);
            this.lbl.finish();
        }
        if (ModRemarkRoomNameUI.d(this.lbl) != null) {
            ModRemarkRoomNameUI.d(this.lbl).dismiss();
        }
        return false;
    }
}
