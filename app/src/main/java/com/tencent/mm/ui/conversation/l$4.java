package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class l$4 implements OnClickListener {
    final /* synthetic */ SharedPreferences yZV;
    final /* synthetic */ boolean yZW;
    final /* synthetic */ int yZX;
    final /* synthetic */ int yZY;

    l$4(SharedPreferences sharedPreferences, boolean z, int i, int i2) {
        this.yZV = sharedPreferences;
        this.yZW = z;
        this.yZX = i;
        this.yZY = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yZV.edit().putInt("show_rating_flag", 4).commit();
        if (this.yZW) {
            this.yZV.edit().putBoolean("show_rating_again", false).commit();
            g.pQN.h(11216, new Object[]{Integer.valueOf(3), Integer.valueOf(this.yZX), Integer.valueOf(this.yZY)});
        } else {
            x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
            this.yZV.edit().putBoolean("show_rating_again", true).commit();
            g.pQN.h(11216, new Object[]{Integer.valueOf(6), Integer.valueOf(this.yZX), Integer.valueOf(this.yZY)});
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        l.cwO();
    }
}
