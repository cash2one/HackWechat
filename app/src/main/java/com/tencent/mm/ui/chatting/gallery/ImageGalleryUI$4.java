package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.p.d;
import java.util.ArrayList;
import java.util.List;

class ImageGalleryUI$4 implements d {
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$4(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        cf cuy;
        r nF;
        switch (menuItem.getItemId()) {
            case 0:
                cuy = ImageGalleryUI.f(this.yFy).cuy();
                if (cuy == null || !cuy.cjh()) {
                    ImageGalleryUI.f(this.yFy).FM(this.yFy.mTN.yF);
                    return;
                }
                nF = t.nF(cuy.field_imgPath);
                if (nF.status == 199 || nF.status == 199) {
                    ImageGalleryUI.f(this.yFy).FM(this.yFy.mTN.yF);
                    return;
                }
                ImageGalleryUI.b(this.yFy, t.d(cuy.field_msgId, 1));
                ImageGalleryUI.f(this.yFy).FR(this.yFy.mTN.yF);
                return;
            case 1:
                cuy = ImageGalleryUI.f(this.yFy).cuy();
                if (cuy == null || !cuy.cjh()) {
                    List arrayList = new ArrayList();
                    arrayList.add(ImageGalleryUI.f(this.yFy).cuy());
                    b.hPA.y((au) arrayList.get(0));
                    b.c(this.yFy.mController.xIM, arrayList);
                    return;
                }
                nF = t.nF(cuy.field_imgPath);
                if (nF.status == 199 || nF.status == 199) {
                    List arrayList2 = new ArrayList();
                    arrayList2.add(ImageGalleryUI.f(this.yFy).cuy());
                    b.c(this.yFy.mController.xIM, arrayList2);
                    return;
                }
                ImageGalleryUI.b(this.yFy, t.d(cuy.field_msgId, 2));
                ImageGalleryUI.f(this.yFy).FR(this.yFy.mTN.yF);
                return;
            case 2:
                if (com.tencent.mm.bm.d.OQ("favorite")) {
                    ImageGalleryUI.f(this.yFy).FO(this.yFy.mTN.yF);
                    return;
                }
                return;
            case 3:
                x.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                com.tencent.mm.sdk.b.b bzVar = new bz();
                bzVar.fqa.activity = this.yFy;
                bzVar.fqa.fov = ImageGalleryUI.c(this.yFy);
                bzVar.fqa.fqb = ImageGalleryUI.v(this.yFy);
                bzVar.fqa.fqc = ImageGalleryUI.w(this.yFy);
                bzVar.fqa.scene = 37;
                bzVar.fqa.fqh = this.yFy.getIntent().getBundleExtra("_stat_obj");
                ImageGalleryUI.a(this.yFy, bzVar);
                ImageGalleryUI.b(this.yFy, bzVar);
                a.xef.m(bzVar);
                return;
            case 4:
                ImageGalleryUI.f(this.yFy).FN(this.yFy.mTN.yF);
                return;
            case 5:
                ImageGalleryUI.x(this.yFy);
                return;
            case 6:
                if (b.aW(ImageGalleryUI.f(this.yFy).cuy())) {
                    ImageGalleryUI.y(this.yFy);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
