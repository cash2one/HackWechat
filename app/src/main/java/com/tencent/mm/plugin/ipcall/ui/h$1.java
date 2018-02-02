package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;

class h$1 implements OnClickListener {
    final /* synthetic */ h nLs;

    h$1(h hVar) {
        this.nLs = hVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (c.cX(h.a(this.nLs))) {
                k rD = this.nLs.rD(intValue);
                com.tencent.mm.plugin.ipcall.a.g.c cVar = null;
                if (rD.field_addressId > 0) {
                    if (h.b(this.nLs).containsKey(Long.valueOf(rD.field_addressId))) {
                        cVar = (com.tencent.mm.plugin.ipcall.a.g.c) h.b(this.nLs).get(Long.valueOf(rD.field_addressId));
                    } else {
                        cVar = i.aTD().dy(rD.field_addressId);
                    }
                    if (cVar != null) {
                        h.b(this.nLs).put(Long.valueOf(rD.field_addressId), cVar);
                    }
                }
                Intent intent;
                if (cVar != null) {
                    intent = new Intent(h.c(this.nLs), IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", rD.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_contactId", cVar.field_contactId);
                    intent.putExtra("IPCallTalkUI_nickname", cVar.field_systemAddressBookUsername);
                    intent.putExtra("IPCallTalkUI_toWechatUsername", cVar.field_wechatUsername);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    g.pQN.h(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                    ((FragmentActivity) h.d(this.nLs)).startActivityForResult(intent, 1001);
                    return;
                }
                intent = new Intent(h.e(this.nLs), IPCallTalkUI.class);
                intent.putExtra("IPCallTalkUI_phoneNumber", rD.field_phonenumber);
                intent.putExtra("IPCallTalkUI_dialScene", 3);
                g.pQN.h(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                ((FragmentActivity) h.f(this.nLs)).startActivityForResult(intent, 1001);
            }
        }
    }
}
