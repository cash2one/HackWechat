package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class m$1 implements OnClickListener {
    final /* synthetic */ m kVO;

    m$1(m mVar) {
        this.kVO = mVar;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            String substring;
            if (str.contains(";")) {
                substring = str.substring(0, str.indexOf(";"));
            } else {
                substring = str;
            }
            h.a(m.a(this.kVO), true, substring, "", m.a(this.kVO).getString(R.l.dUO), m.a(this.kVO).getString(R.l.dEn), new 1(this, substring), null);
        }
    }
}
