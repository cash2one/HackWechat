package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import org.xwalk.core.XWalkEnvironment;

class a$4 implements OnClickListener {
    final /* synthetic */ a Asx;

    a$4(a aVar) {
        this.Asx = aVar;
    }

    public final void onClick(View view) {
        XWalkEnvironment.clearAllVersion(this.Asx.Aqf);
    }
}
