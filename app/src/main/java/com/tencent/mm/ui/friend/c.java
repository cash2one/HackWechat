package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;

public final class c implements OnClickListener {
    private Context context;
    private a zcD;

    public c(Context context, a aVar) {
        this.context = context;
        this.zcD = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        String str = bVar.zcF;
        int[] iArr = new int[]{o.bY(str)};
        new g(this.context, new 1(this, bVar.position)).q(iArr);
    }
}
