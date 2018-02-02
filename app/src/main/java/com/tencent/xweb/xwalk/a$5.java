package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import org.xwalk.core.R;
import org.xwalk.core.XWalkInitializer;

class a$5 implements OnClickListener {
    final /* synthetic */ a Asx;

    a$5(a aVar) {
        this.Asx = aVar;
    }

    public final void onClick(View view) {
        ((TextView) this.Asx.Asu.findViewById(R.id.txtVersion)).setText(this.Asx.Asp.getVersionInfo() + "\n" + XWalkInitializer.getXWalkInitializeLog());
    }
}
