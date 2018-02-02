package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;

class a$4 implements OnClickListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ Bundle jrm;
    final /* synthetic */ int sKm;
    final /* synthetic */ boolean sKp = false;

    a$4(Bundle bundle, int i, Activity activity, boolean z) {
        this.jrm = bundle;
        this.sKm = i;
        this.icz = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        Bundle bundle = this.jrm;
        if (this.jrm == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", this.sKm);
        bundle.putBoolean("key_from_set_pwd", true);
        a.a(this.icz, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        e.a(19, bh.Wo(), this.sKm);
        dialogInterface.dismiss();
        if (this.sKp) {
            this.icz.finish();
        }
    }
}
