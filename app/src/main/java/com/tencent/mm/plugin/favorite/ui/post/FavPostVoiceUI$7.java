package com.tencent.mm.plugin.favorite.ui.post;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FavPostVoiceUI$7 implements a {
    final /* synthetic */ FavPostVoiceUI myN;

    FavPostVoiceUI$7(FavPostVoiceUI favPostVoiceUI) {
        this.myN = favPostVoiceUI;
    }

    public final boolean uF() {
        if (FavPostVoiceUI.q(this.myN) == -1) {
            FavPostVoiceUI.a(this.myN, bh.Wq());
        }
        long bA = bh.bA(FavPostVoiceUI.q(this.myN));
        if (bA >= 3590000 && bA <= 3600000) {
            if (FavPostVoiceUI.r(this.myN) == null) {
                FavPostVoiceUI.a(this.myN, Toast.makeText(this.myN, this.myN.getString(R.l.duo, new Object[]{Integer.valueOf((int) ((3600000 - bA) / 1000))}), 0));
            } else {
                FavPostVoiceUI.r(this.myN).setText(this.myN.getString(R.l.duo, new Object[]{Integer.valueOf((int) ((3600000 - bA) / 1000))}));
            }
            FavPostVoiceUI.r(this.myN).show();
        }
        if (bA < 3600000) {
            return true;
        }
        x.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
        FavPostVoiceUI.s(this.myN);
        FavPostVoiceUI.p(this.myN);
        return false;
    }
}
