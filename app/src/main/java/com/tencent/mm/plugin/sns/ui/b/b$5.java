package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class b$5 extends c {
    final /* synthetic */ b rPY;

    b$5(b bVar) {
        this.rPY = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view != null && (view.getTag() instanceof ap)) {
            String str = ((ap) view.getTag()).fus;
            m Lm = ae.bvv().Lm(str);
            if (d.OQ("favorite")) {
                contextMenu.add(0, 2, 0, this.rPY.activity.getString(j.eAd));
                b dhVar = new dh();
                dhVar.frQ.frH = str;
                a.xef.m(dhVar);
                if (dhVar.frR.frp) {
                    contextMenu.add(0, 18, 0, this.rPY.activity.getString(j.qJu));
                }
            }
            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Lm);
            if (d.OQ("photoedit")) {
                int width;
                int height;
                MenuItem add = contextMenu.add(0, 21, 0, this.rPY.activity.getString(j.qKz));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
        }
    }

    public final boolean cL(View view) {
        if (!(view.getTag() instanceof ap)) {
            return false;
        }
        String str = ((ap) view.getTag()).fus;
        this.rPY.rPp.a(view, str, ae.bvv().Lm(str).bxV());
        return true;
    }
}
