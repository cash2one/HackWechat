package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.g.c;

class c$1 implements OnClickListener {
    final /* synthetic */ c nHO;

    c$1(c cVar) {
        this.nHO = cVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            c rw = this.nHO.rw(((Integer) view.getTag()).intValue());
            Intent intent = new Intent(c.a(this.nHO), IPCallUserProfileUI.class);
            intent.putExtra("IPCallProfileUI_contactid", rw.field_contactId);
            intent.putExtra("IPCallProfileUI_systemUsername", rw.field_systemAddressBookUsername);
            intent.putExtra("IPCallProfileUI_wechatUsername", rw.field_wechatUsername);
            c.b(this.nHO).startActivity(intent);
        }
    }
}
