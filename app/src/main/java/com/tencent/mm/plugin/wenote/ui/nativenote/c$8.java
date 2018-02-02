package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.base.u;

class c$8 implements OnClickListener {
    final /* synthetic */ c tXL;
    final /* synthetic */ Context val$context;

    c$8(c cVar, Context context) {
        this.tXL = cVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        c.bWp().W(-1, false);
        if (f.ze()) {
            Intent intent = new Intent(this.val$context, FileExplorerUI.class);
            intent.putExtra("key_title", this.val$context.getString(R.l.efZ));
            ((Activity) this.val$context).startActivityForResult(intent, 4099);
            return;
        }
        u.fI(this.val$context);
    }
}
