package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.u;

class c$9 implements OnClickListener {
    final /* synthetic */ c tXL;
    final /* synthetic */ Context val$context;

    c$9(c cVar, Context context) {
        this.tXL = cVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        c.bWp().W(-1, false);
        x.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (a.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            Intent intent = new Intent();
            intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
            intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
            intent.putExtra("map_view_type", 3);
            d.b(this.val$context, "location", ".ui.RedirectUI", intent, 4098);
        }
    }
}
