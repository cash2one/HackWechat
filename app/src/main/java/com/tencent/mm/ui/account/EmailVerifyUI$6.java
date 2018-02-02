package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMAutoSwitchEditText;
import java.util.Iterator;

class EmailVerifyUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ EmailVerifyUI xNK;

    EmailVerifyUI$6(EmailVerifyUI emailVerifyUI) {
        this.xNK = emailVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        EmailVerifyUI emailVerifyUI = this.xNK;
        String str = "";
        Iterator it = EmailVerifyUI.e(this.xNK).xZF.iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bh.ov(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        EmailVerifyUI.b(emailVerifyUI, str);
        if (bh.ov(EmailVerifyUI.f(this.xNK)) || EmailVerifyUI.f(this.xNK).length() != 12) {
            this.xNK.enableOptionMenu(false);
        } else {
            EmailVerifyUI.a(this.xNK, EmailVerifyUI.f(this.xNK));
        }
        return true;
    }
}
