package com.tencent.mm.plugin.profile.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.e.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.x;

class FriendPreference$2 implements b {
    final /* synthetic */ String gIT;
    final /* synthetic */ e hkF;
    final /* synthetic */ String piJ;
    final /* synthetic */ FriendPreference pjW;

    FriendPreference$2(FriendPreference friendPreference, e eVar, String str, String str2) {
        this.pjW = friendPreference;
        this.hkF = eVar;
        this.gIT = str;
        this.piJ = str2;
    }

    public final int ba(int i, int i2) {
        this.hkF.JD();
        x.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            n.Jz();
            if (FriendPreference.a(this.pjW, this.piJ, d.je(this.gIT))) {
                Toast.makeText(this.pjW.mContext, this.pjW.mContext.getString(R.l.dWm), 0).show();
                return 0;
            }
        }
        Toast.makeText(this.pjW.mContext, this.pjW.mContext.getString(R.l.dWk), 0).show();
        return 0;
    }
}
