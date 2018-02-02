package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.x;

class l$2 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ SharedPreferences yZV;

    l$2(SharedPreferences sharedPreferences, Context context) {
        this.yZV = sharedPreferences;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yZV.edit().putInt("show_rating_flag", 2).commit();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        l.cwO();
        l.fV(this.val$context);
        x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
    }
}
