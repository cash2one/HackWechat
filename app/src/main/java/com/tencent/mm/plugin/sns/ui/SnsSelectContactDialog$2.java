package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class SnsSelectContactDialog$2 implements OnClickListener {
    final /* synthetic */ SnsSelectContactDialog rEU;

    SnsSelectContactDialog$2(SnsSelectContactDialog snsSelectContactDialog) {
        this.rEU = snsSelectContactDialog;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", bh.d(SnsSelectContactDialog.c(this.rEU), ","));
        this.rEU.setResult(-1, intent);
        this.rEU.finish();
    }
}
