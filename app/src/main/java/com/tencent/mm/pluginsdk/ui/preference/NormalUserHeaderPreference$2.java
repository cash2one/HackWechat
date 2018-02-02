package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.storage.x;

class NormalUserHeaderPreference$2 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$2(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.vtY = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        String str = NormalUserHeaderPreference.b(this.vtY).field_username;
        f fVar = new f(NormalUserHeaderPreference.a(this.vtY), str);
        if (x.gy(str)) {
            x.WD(str);
        }
        fVar.caa();
    }
}
