package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;

class c$3 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ OnClickListener vdj;

    c$3(Context context, OnClickListener onClickListener) {
        this.val$context = context;
        this.vdj = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_cleanui_from", 3);
        d.b(this.val$context, "favorite", ".ui.FavCleanUI", intent);
        dialogInterface.dismiss();
        if (this.vdj != null) {
            this.vdj.onClick(dialogInterface, -2);
        }
    }
}
