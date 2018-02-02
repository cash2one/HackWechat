package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class q implements a {
    private Context context;

    public q(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.dVd);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.hk((com.tencent.mm.z.q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0);
    }
}
