package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.af.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class VerifyQQUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ VerifyQQUI ymV;
    final /* synthetic */ EditText ymW;
    final /* synthetic */ EditText ymX;

    VerifyQQUI$2(VerifyQQUI verifyQQUI, EditText editText, EditText editText2) {
        this.ymV = verifyQQUI;
        this.ymW = editText;
        this.ymX = editText2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String trim = this.ymW.getText().toString().trim();
        VerifyQQUI.a(this.ymV, this.ymX.getText().toString().trim());
        try {
            VerifyQQUI.a(this.ymV, Long.parseLong(trim));
            if (VerifyQQUI.b(this.ymV) < 10000) {
                h.h(this.ymV.mController.xIM, R.l.dLY, R.l.dLW);
            } else if (VerifyQQUI.c(this.ymV).equals("")) {
                h.h(this.ymV.mController.xIM, R.l.dLX, R.l.dLW);
            } else {
                this.ymV.aWs();
                k aVar = new a(VerifyQQUI.b(this.ymV), VerifyQQUI.c(this.ymV), "", "", "", VerifyQQUI.d(this.ymV), VerifyQQUI.e(this.ymV), false);
                ar.CG().a(aVar, 0);
                VerifyQQUI verifyQQUI = this.ymV;
                Context context = this.ymV.mController.xIM;
                this.ymV.getString(R.l.dMa);
                VerifyQQUI.a(verifyQQUI, h.a(context, this.ymV.getString(R.l.dLR), true, new 1(this, aVar)));
            }
        } catch (Exception e) {
            h.h(this.ymV.mController.xIM, R.l.dLY, R.l.dLW);
        }
        return true;
    }
}
