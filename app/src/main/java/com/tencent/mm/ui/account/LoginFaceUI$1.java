package com.tencent.mm.ui.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;

class LoginFaceUI$1 implements OnClickListener {
    final /* synthetic */ LoginFaceUI xOo;

    LoginFaceUI$1(LoginFaceUI loginFaceUI) {
        this.xOo = loginFaceUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11557, new Object[]{Integer.valueOf(2)});
        Intent intent = new Intent();
        intent.putExtra("k_user_name", this.xOo.xOI);
        intent.putExtra("k_purpose", 2);
        intent.putExtra("k_need_signature", true);
        d.b(this.xOo.mController.xIM, "facedetect", ".ui.FaceDetectUI", intent, 1025);
    }
}
