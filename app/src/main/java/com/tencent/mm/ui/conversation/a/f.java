package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class f extends b {
    String zaI = null;
    String zaJ = null;

    public f(Context context, String str, String str2) {
        super(context);
        this.zaI = str;
        this.zaJ = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(R.h.bTy);
            this.view.setOnClickListener(new 1(this));
            imageView.setImageBitmap(com.tencent.mm.ad.b.a(this.zaI, true, -1));
        }
    }

    public final int getLayoutId() {
        return R.i.deo;
    }

    public final void destroy() {
    }
}
