package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.FriendPreference.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.z.s;

class FriendPreference$1$1 implements c {
    final /* synthetic */ String[] piI;
    final /* synthetic */ 1 pjX;

    FriendPreference$1$1(1 1, String[] strArr) {
        this.pjX = 1;
        this.piI = strArr;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                if (this.pjX.pjV != null && this.pjX.pjV.length() != 0) {
                    int lastIndexOf = this.pjX.pjV.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        FriendPreference.a(this.pjX.pjW, this.pjX.pjV.substring(lastIndexOf));
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.pjX.pjV != null && this.pjX.pjV.length() != 0) {
                    String substring = this.pjX.pjV.substring(0, this.pjX.pjV.lastIndexOf(32));
                    if (substring != null && substring.length() != 0) {
                        s.b(FriendPreference.c(this.pjX.pjW), substring.trim());
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (this.piI != null && this.piI.length > 2 && FriendPreference.a(this.pjX.pjW) != null && FriendPreference.c(this.pjX.pjW) != null) {
                    if (!(FriendPreference.a(this.pjX.pjW) == null || bh.ov(FriendPreference.a(this.pjX.pjW).hls))) {
                        FriendPreference.a(this.pjX.pjW, FriendPreference.c(this.pjX.pjW).field_username, FriendPreference.a(this.pjX.pjW).hls);
                        return;
                    }
                }
                return;
                break;
            case 3:
                break;
            default:
                return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("fromScene", 2);
        intent.putExtra("reportArgs", bundle);
        a.ifs.k(intent, FriendPreference.b(this.pjX.pjW));
    }
}
