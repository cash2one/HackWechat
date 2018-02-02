package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.u;

class b$14 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$14(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        try {
            int LG = u.LG((String) view.getTag());
            Intent intent = new Intent();
            intent.putExtra("sns_label_sns_info", LG);
            a.ifs.x(intent, this.rPY.activity);
        } catch (Exception e) {
        }
    }
}
