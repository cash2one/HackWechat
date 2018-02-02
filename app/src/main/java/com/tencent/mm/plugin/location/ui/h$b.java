package com.tencent.mm.plugin.location.ui;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class h$b {
    final /* synthetic */ h nTH;
    boolean nTK = false;
    a nTL;
    private LayoutParams nlV;
    String username;

    class a {
        ImageView ijr;
        RelativeLayout nTM;
        final /* synthetic */ h$b nTN;

        a(h$b com_tencent_mm_plugin_location_ui_h_b) {
            this.nTN = com_tencent_mm_plugin_location_ui_h_b;
        }
    }

    public h$b(h hVar, String str) {
        this.nTH = hVar;
        this.username = str;
        if (bh.ov(str)) {
            x.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
            return;
        }
        this.nTL = new a(this);
        LayoutInflater layoutInflater = (LayoutInflater) this.nTH.context.getSystemService("layout_inflater");
        this.nTL.nTM = (RelativeLayout) layoutInflater.inflate(R.i.dmJ, null);
        this.nTL.ijr = (ImageView) this.nTL.nTM.findViewById(R.h.bLC);
        b.o(this.nTL.ijr, this.username);
        this.nTL.nTM.setTag(this.username);
        this.nlV = new LayoutParams(-2, -2);
        this.nlV.leftMargin = BackwardSupportUtil.b.b(this.nTH.context, 5.0f);
        this.nlV.rightMargin = BackwardSupportUtil.b.b(this.nTH.context, 5.0f);
        this.nlV.gravity = 17;
    }

    public final void aVS() {
        x.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[]{this.username});
        this.nTL.nTM.setBackgroundResource(R.g.bDx);
        this.nTL.nTM.invalidate();
        this.nTK = true;
    }

    public final void aVT() {
        x.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[]{this.username});
        this.nTL.nTM.setBackgroundResource(R.g.bDw);
        this.nTL.nTM.invalidate();
        this.nTK = false;
    }
}
