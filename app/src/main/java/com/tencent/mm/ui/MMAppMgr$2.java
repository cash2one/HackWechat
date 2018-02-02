package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mm.sdk.platformtools.f;

class MMAppMgr$2 implements OnClickListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ SharedPreferences tfz;
    final /* synthetic */ CheckBox xJT;
    final /* synthetic */ OnClickListener xJU;

    MMAppMgr$2(CheckBox checkBox, SharedPreferences sharedPreferences, Activity activity, OnClickListener onClickListener) {
        this.xJT = checkBox;
        this.tfz = sharedPreferences;
        this.icz = activity;
        this.xJU = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.xJT.isChecked()) {
            Editor edit = this.tfz.edit();
            edit.putBoolean("gprs_alert", false);
            edit.commit();
        }
        f.xeB = false;
        dialogInterface.dismiss();
        MMAppMgr.ft(this.icz);
        if (this.xJU != null) {
            this.xJU.onClick(dialogInterface, i);
        }
    }
}
