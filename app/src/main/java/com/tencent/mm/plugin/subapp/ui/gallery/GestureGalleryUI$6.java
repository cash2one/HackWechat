package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;

class GestureGalleryUI$6 implements d {
    final /* synthetic */ GestureGalleryUI rXs;

    GestureGalleryUI$6(GestureGalleryUI gestureGalleryUI) {
        this.rXs = gestureGalleryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        b cfVar;
        switch (menuItem.getItemId()) {
            case 1:
                if (bh.ov(GestureGalleryUI.b(this.rXs))) {
                    x.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
                    return;
                } else if (p.UR(GestureGalleryUI.b(this.rXs))) {
                    EmojiInfo yc;
                    EmojiInfo yc2 = ((c) g.k(c.class)).getEmojiMgr().yc(com.tencent.mm.a.g.bV(GestureGalleryUI.b(this.rXs)));
                    if (yc2 == null) {
                        yc = ((c) g.k(c.class)).getEmojiMgr().yc(((c) g.k(c.class)).getEmojiMgr().yd(GestureGalleryUI.b(this.rXs)));
                    } else {
                        yc = yc2;
                    }
                    int bN = yc == null ? 0 : e.bN(yc.ckB());
                    String b = yc == null ? GestureGalleryUI.b(this.rXs) : yc.ckB();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    int i2;
                    if ((com.tencent.mm.sdk.platformtools.d.decodeFile(b, options) == null || options.outHeight <= com.tencent.mm.k.b.zE()) && options.outWidth <= com.tencent.mm.k.b.zE()) {
                        i2 = 0;
                    } else {
                        i2 = true;
                    }
                    if (bN > com.tencent.mm.k.b.zF() || r0 != 0) {
                        h.a(this.rXs.mController.xIM, this.rXs.getString(R.l.dZJ), "", this.rXs.getString(R.l.epk), null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", yc == null ? "" : yc.Nr());
                    intent.putExtra("Retr_Msg_Type", 5);
                    intent.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.plugin.subapp.b.ifs.l(intent, this.rXs.mController.xIM);
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", GestureGalleryUI.b(this.rXs));
                    intent2.putExtra("Retr_Compress_Type", 0);
                    intent2.putExtra("Retr_Msg_Type", 0);
                    com.tencent.mm.plugin.subapp.b.ifs.l(intent2, this.rXs.mController.xIM);
                    return;
                }
            case 2:
                if (GestureGalleryUI.b(this.rXs) != null && !GestureGalleryUI.b(this.rXs).equals("")) {
                    ar.Hg();
                    if (com.tencent.mm.z.c.isSDCardAvailable()) {
                        k.h(GestureGalleryUI.b(this.rXs), this.rXs);
                        return;
                    } else {
                        u.fI(this.rXs);
                        return;
                    }
                }
                return;
            case 3:
                cfVar = new cf();
                f.a(cfVar, 1, GestureGalleryUI.b(this.rXs));
                cfVar.fqp.activity = this.rXs;
                cfVar.fqp.fqw = 32;
                a.xef.m(cfVar);
                return;
            case 4:
                x.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
                cfVar = new bz();
                cfVar.fqa.activity = this.rXs;
                cfVar.fqa.fov = GestureGalleryUI.e(this.rXs);
                cfVar.fqa.fqb = GestureGalleryUI.d(this.rXs);
                cfVar.fqa.fqc = GestureGalleryUI.h(this.rXs);
                cfVar.fqa.scene = GestureGalleryUI.i(this.rXs);
                cfVar.fqa.fqh = this.rXs.getIntent().getBundleExtra("_stat_obj");
                a.xef.m(cfVar);
                return;
            default:
                return;
        }
    }
}
