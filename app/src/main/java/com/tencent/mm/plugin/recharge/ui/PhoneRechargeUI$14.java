package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class PhoneRechargeUI$14 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$14(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (this.pDm.getPackageManager().checkPermission("android.permission.READ_CONTACTS", ac.getPackageName()) == 0) {
            Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
            if (bh.k(this.pDm, intent)) {
                this.pDm.startActivityForResult(intent, 1);
                return;
            }
            return;
        }
        h.b(this.pDm, this.pDm.getString(i.uVU), "", true);
    }
}
