package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class AlbumPreviewUI$2 implements OnItemClickListener {
    final /* synthetic */ AlbumPreviewUI mSQ;

    AlbumPreviewUI$2(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        MediaItem qs;
        if (c.aNE().aOh() == 0 || c.aNE().aOh() == 5 || c.aNE().aOh() == 10 || c.aNE().aOh() == 11) {
            if (c.aNE().aOi() == 2) {
                h.a(this.mSQ, true, this.mSQ.getString(R.l.elI), "", this.mSQ.getString(R.l.dGA), this.mSQ.getString(R.l.dEn), new 1(this, i), null);
                return;
            }
            qs = AlbumPreviewUI.a(this.mSQ).qs(i);
            if (qs == null) {
                x.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", new Object[]{Integer.valueOf(i)});
                this.mSQ.setResult(0);
            } else {
                Intent intent = new Intent();
                if (qs.getType() == 2) {
                    intent.putExtra("is_video", true);
                    intent.putExtra("video_full_path", qs.hOo);
                }
                if (c.aNE().aOh() == 10) {
                    intent.putExtra("CropImage_OutputPath", qs.hOo);
                }
                intent.setData(Uri.parse(Uri.encode(qs.hOo)));
                x.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                this.mSQ.setResult(-1, intent);
            }
            this.mSQ.finish();
        } else if (c.aNE().aOh() == 4) {
            if (i < AlbumPreviewUI.a(this.mSQ).mRO.size()) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                return;
            }
            qs = AlbumPreviewUI.a(this.mSQ).qs(i);
            if (qs == null) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
            } else if (qs.getType() != 2 || AlbumPreviewUI.a(this.mSQ).mRL.size() == 0) {
                r2 = AlbumPreviewUI.a(this.mSQ).qr(qs.getType());
                c.w(r2);
                r3 = new Intent(this.mSQ, ImagePreviewUI.class);
                r3.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.mSQ).aOm());
                r3.putExtra("preview_all", true);
                r3.putExtra("preview_position", r2.indexOf(qs));
                this.mSQ.E(i - AlbumPreviewUI.a(this.mSQ).mRO.size(), true);
                r3.putExtra("send_raw_img", AlbumPreviewUI.d(this.mSQ));
                r3.putExtra("max_select_count", AlbumPreviewUI.i(this.mSQ));
                r3.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.mSQ));
                r3.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.mSQ));
                this.mSQ.startActivityForResult(r3, 0);
            } else {
                h.bu(this.mSQ.mController.xIM, a.ac(this.mSQ.mController.xIM, R.l.elc));
            }
        } else if (AlbumPreviewUI.n(this.mSQ)) {
            if (i < AlbumPreviewUI.a(this.mSQ).mRO.size()) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                return;
            }
            qs = AlbumPreviewUI.a(this.mSQ).qs(i);
            if (qs == null) {
                x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
            } else if (qs.getType() != 2 || AlbumPreviewUI.a(this.mSQ).mRL.size() == 0) {
                r2 = AlbumPreviewUI.a(this.mSQ).qr(qs.getType());
                c.w(r2);
                r3 = new Intent(this.mSQ, ImagePreviewUI.class);
                r3.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.mSQ).aOm());
                r3.putExtra("preview_all", true);
                r3.putExtra("preview_position", r2.indexOf(qs));
                this.mSQ.E(i - AlbumPreviewUI.a(this.mSQ).mRO.size(), true);
                r3.putExtra("send_raw_img", AlbumPreviewUI.d(this.mSQ));
                String str = "max_select_count";
                if (qs.getType() != 2) {
                    i2 = AlbumPreviewUI.i(this.mSQ);
                }
                r3.putExtra(str, i2);
                r3.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.mSQ));
                r3.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.mSQ));
                this.mSQ.startActivityForResult(r3, 0);
            } else {
                h.bu(this.mSQ.mController.xIM, a.ac(this.mSQ.mController.xIM, R.l.elc));
            }
        } else if (i < AlbumPreviewUI.a(this.mSQ).mRO.size()) {
            x.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
        } else {
            c.w(AlbumPreviewUI.a(this.mSQ).mRK);
            Intent intent2 = new Intent(this.mSQ, ImagePreviewUI.class);
            intent2.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.a(this.mSQ).aOm());
            intent2.putExtra("preview_all", true);
            intent2.putExtra("preview_position", i - AlbumPreviewUI.a(this.mSQ).mRO.size());
            this.mSQ.E(i - AlbumPreviewUI.a(this.mSQ).mRO.size(), true);
            intent2.putExtra("send_raw_img", AlbumPreviewUI.d(this.mSQ));
            intent2.putExtra("max_select_count", AlbumPreviewUI.i(this.mSQ));
            intent2.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.mSQ));
            intent2.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.mSQ));
            this.mSQ.startActivityForResult(intent2, 0);
        }
    }
}
