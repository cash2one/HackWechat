package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.l;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

class ah$5 implements d {
    final /* synthetic */ au heR;
    final /* synthetic */ String jBa;
    final /* synthetic */ Context val$context;
    final /* synthetic */ boolean yxF;

    ah$5(au auVar, Context context, boolean z, String str) {
        this.heR = auVar;
        this.val$context = context;
        this.yxF = z;
        this.jBa = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        e bi;
        e bh;
        int i2 = 1;
        String str = menuItem.getTitle();
        if (this.heR.field_msgId > 0) {
            bi = o.Pw().bi(this.heR.field_msgId);
        } else {
            bi = null;
        }
        if ((bi == null || bi.hzP <= 0) && this.heR.field_msgSvrId > 0) {
            bh = o.Pw().bh(this.heR.field_msgSvrId);
        } else {
            bh = bi;
        }
        if (bh == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
        } else if (bh.offset < bh.hlp || bh.hlp == 0) {
            String str2;
            Bundle bundle;
            Intent intent = new Intent(this.val$context, ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", this.heR.field_msgId);
            intent.putExtra("img_gallery_msg_svr_id", this.heR.field_msgSvrId);
            intent.putExtra("img_gallery_talker", this.heR.field_talker);
            intent.putExtra("img_gallery_chatroom_name", this.heR.field_talker);
            intent.putExtra("img_gallery_is_restransmit_after_download", true);
            intent.putExtra("img_gallery_directly_send_name", str);
            intent.putExtra("start_chatting_ui", false);
            str = this.heR.field_talker;
            Bundle bundle2 = new Bundle();
            if (this.yxF) {
                str2 = "stat_scene";
                i2 = 2;
                bundle = bundle2;
            } else {
                str2 = "stat_scene";
                if (s.gF(str)) {
                    i2 = 7;
                    bundle = bundle2;
                } else {
                    bundle = bundle2;
                }
            }
            bundle.putInt(str2, i2);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(this.heR.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", str);
            bundle2.putString("stat_send_msg_user", this.jBa);
            intent.putExtra("_stat_obj", bundle2);
            this.val$context.startActivity(intent);
        } else {
            int i3;
            if (this.heR.field_isSend == 1) {
                int i4;
                if (bh.Pe()) {
                    i4 = 1;
                } else {
                    boolean z = false;
                }
                i3 = i4;
            } else if (!bh.Pe()) {
                i3 = 0;
            } else if (com.tencent.mm.a.e.bO(f.a(bh).hzQ)) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            String FS = q.FS();
            String m = o.Pw().m(f.c(bh), "", "");
            if (!bh.ov(m)) {
                x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[]{str, m});
                ar.CG().a(new l(4, FS, str, m, i3, null, 0, "", "", true, R.g.bAH), 0);
                bo.HS().c(bo.hhE, null);
            }
            g.pQN.h(10424, new Object[]{Integer.valueOf(3), Integer.valueOf(4), str});
            h.bu(this.val$context, this.val$context.getString(R.l.dGy));
        }
    }
}
