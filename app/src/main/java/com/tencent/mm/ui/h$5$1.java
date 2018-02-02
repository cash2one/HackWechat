package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.h.5;

class h$5$1 implements Runnable {
    final /* synthetic */ String lwH;
    final /* synthetic */ Bitmap xFw;
    final /* synthetic */ 5 xFx;

    h$5$1(5 5, String str, Bitmap bitmap) {
        this.xFx = 5;
        this.lwH = str;
        this.xFw = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.FindMoreFriendsUI", "download url " + this.lwH + " , result " + (this.xFw == null));
        IconPreference iconPreference = (IconPreference) h.a(this.xFx.xFs).YN("jd_market_entrance");
        if (iconPreference != null) {
            if (this.lwH.equals(h.h(this.xFx.xFs))) {
                iconPreference.drawable = new BitmapDrawable(this.xFx.xFs.getContext().getResources(), this.xFw);
                h.i(this.xFx.xFs);
            } else if (this.lwH.equals(h.j(this.xFx.xFs))) {
                iconPreference.V(this.xFw);
                h.k(this.xFx.xFs);
            }
            h.a(this.xFx.xFs).notifyDataSetChanged();
        }
        if (this.lwH.equals(h.l(this.xFx.xFs))) {
            ((IconPreference) h.a(this.xFx.xFs).YN("find_friends_by_look")).drawable = new BitmapDrawable(this.xFx.xFs.getContext().getResources(), this.xFw);
            h.m(this.xFx.xFs);
            h.a(this.xFx.xFs).notifyDataSetChanged();
        }
        if (this.lwH.equals(h.n(this.xFx.xFs))) {
            ((IconPreference) h.a(this.xFx.xFs).YN("find_friends_by_search")).drawable = new BitmapDrawable(this.xFx.xFs.getContext().getResources(), this.xFw);
            h.o(this.xFx.xFs);
            h.a(this.xFx.xFs).notifyDataSetChanged();
        }
    }
}
