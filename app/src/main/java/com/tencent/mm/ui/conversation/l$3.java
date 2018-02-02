package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class l$3 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ SharedPreferences yZV;
    final /* synthetic */ boolean yZW;
    final /* synthetic */ int yZX;
    final /* synthetic */ int yZY;

    l$3(SharedPreferences sharedPreferences, Context context, boolean z, int i, int i2) {
        this.yZV = sharedPreferences;
        this.val$context = context;
        this.yZW = z;
        this.yZX = i;
        this.yZY = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yZV.edit().putInt("show_rating_flag", 4).commit();
        String str = "market://details?id=" + ac.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.val$context.startActivity(intent);
        x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.yZV.edit().putBoolean("show_rating_again", false).commit();
        l.cwO();
        if (this.yZW) {
            g.pQN.h(11216, new Object[]{Integer.valueOf(5), Integer.valueOf(this.yZX), Integer.valueOf(this.yZY)});
            return;
        }
        g.pQN.h(11216, new Object[]{Integer.valueOf(4), Integer.valueOf(this.yZX), Integer.valueOf(this.yZY)});
    }
}
