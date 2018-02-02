package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import java.util.List;

class FriendPreference$1 implements OnClickListener {
    final /* synthetic */ String pjV;
    final /* synthetic */ FriendPreference pjW;

    FriendPreference$1(FriendPreference friendPreference, String str) {
        this.pjW = friendPreference;
        this.pjV = str;
    }

    public final void onClick(View view) {
        String[] stringArray;
        if (FriendPreference.a(this.pjW) == null || bh.ov(FriendPreference.a(this.pjW).hls)) {
            stringArray = FriendPreference.b(this.pjW).getResources().getStringArray(R.c.bqY);
        } else {
            stringArray = FriendPreference.b(this.pjW).getResources().getStringArray(R.c.bqX);
        }
        if (a.ift.ur()) {
            List F = bh.F(stringArray);
            F.add(FriendPreference.b(this.pjW).getResources().getString(R.l.dSt));
            stringArray = (String[]) F.toArray(new String[F.size()]);
            g.pQN.h(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
        }
        h.a(FriendPreference.b(this.pjW), null, stringArray, null, new 1(this, stringArray));
    }
}
