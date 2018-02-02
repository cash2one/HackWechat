package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class AlbumPreviewUI$15 implements OnMenuItemClickListener {
    final /* synthetic */ AlbumPreviewUI mSQ;

    AlbumPreviewUI$15(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean z = false;
        x.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[]{Integer.valueOf(c.aNL()), Boolean.valueOf(AlbumPreviewUI.l(this.mSQ))});
        try {
            AlbumPreviewUI.b(this.mSQ).aj(11610, (AlbumPreviewUI.l(this.mSQ) ? 3 : 2) + "," + c.aNL());
        } catch (Throwable e) {
            x.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
        }
        if (AlbumPreviewUI.m(this.mSQ) < 0) {
            try {
                AlbumPreviewUI.a(this.mSQ, AlbumPreviewUI.b(this.mSQ).zH());
            } catch (Throwable e2) {
                AlbumPreviewUI.a(this.mSQ, JceStruct.JCE_MAX_STRING_LENGTH);
                x.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", new Object[]{e2.getMessage()});
                x.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
            }
        }
        c.aNK();
        if (AlbumPreviewUI.a(this.mSQ).aOm().size() == 0) {
            x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
            this.mSQ.setResult(-2);
            this.mSQ.finish();
        } else {
            Intent intent = new Intent();
            int aOi = c.aNE().aOi();
            if (AlbumPreviewUI.l(this.mSQ)) {
                aOi = 1;
            }
            if (AlbumPreviewUI.n(this.mSQ)) {
                aOi = 1;
            }
            ArrayList arrayList;
            GalleryItem$MediaItem galleryItem$MediaItem;
            if (aOi == 1) {
                String str = "CropImage_Compress_Img";
                boolean z2 = AlbumPreviewUI.l(this.mSQ) ? true : !AlbumPreviewUI.d(this.mSQ);
                intent.putExtra(str, z2);
                arrayList = AlbumPreviewUI.a(this.mSQ).mRL;
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    galleryItem$MediaItem = (GalleryItem$MediaItem) it.next();
                    if (!galleryItem$MediaItem.mMimeType.equals("edit") || bh.ov(galleryItem$MediaItem.mRe)) {
                        arrayList2.add(galleryItem$MediaItem.hOo);
                    } else {
                        arrayList2.add(galleryItem$MediaItem.mRe);
                    }
                }
                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList2);
                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.mSQ));
                AlbumPreviewUI.p(this.mSQ);
                this.mSQ.setResult(-1, intent);
                AlbumPreviewUI.q(this.mSQ);
                if (bh.ov(AlbumPreviewUI.j(this.mSQ)) || "medianote".equals(AlbumPreviewUI.k(this.mSQ))) {
                    this.mSQ.finish();
                } else if (bh.Wq() - AlbumPreviewUI.r(this.mSQ) < 1000) {
                    x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                } else {
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    AlbumPreviewUI.a(this.mSQ, bh.Wq());
                    intent.setClassName(this.mSQ, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.mSQ));
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.mSQ));
                    this.mSQ.startActivityForResult(intent, 4373);
                }
            } else if (aOi == 2) {
                x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                a SD = a.SD((String) AlbumPreviewUI.a(this.mSQ).aOm().get(0));
                SD.hX = AlbumPreviewUI.m(this.mSQ);
                aOi = SD.cci();
                if (aOi == 0) {
                    intent.setData(Uri.fromFile(new File((String) AlbumPreviewUI.a(this.mSQ).aOm().get(0))));
                    intent.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.a(this.mSQ).aOm());
                    this.mSQ.setResult(-1, intent);
                    AlbumPreviewUI.q(this.mSQ);
                    this.mSQ.finish();
                } else if (aOi == 2) {
                    AlbumPreviewUI.s(this.mSQ);
                } else {
                    AlbumPreviewUI.t(this.mSQ);
                }
            } else if (aOi != 3) {
                x.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                this.mSQ.setResult(-2);
                this.mSQ.finish();
            } else if (bh.Wq() - AlbumPreviewUI.r(this.mSQ) < 1000) {
                x.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
            } else {
                AlbumPreviewUI.a(this.mSQ, bh.Wq());
                arrayList = AlbumPreviewUI.a(this.mSQ).mRL;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    galleryItem$MediaItem = (GalleryItem$MediaItem) it2.next();
                    if (galleryItem$MediaItem.getType() == 1) {
                        if (!galleryItem$MediaItem.mMimeType.equals("edit") || bh.ov(galleryItem$MediaItem.mRe)) {
                            arrayList4.add(galleryItem$MediaItem.hOo);
                        } else {
                            arrayList4.add(galleryItem$MediaItem.mRe);
                        }
                    } else if (galleryItem$MediaItem.getType() == 2) {
                        arrayList3.add(galleryItem$MediaItem.hOo);
                    }
                }
                String str2 = "CropImage_Compress_Img";
                if (AlbumPreviewUI.l(this.mSQ)) {
                    z = true;
                } else if (!AlbumPreviewUI.d(this.mSQ)) {
                    z = true;
                }
                intent.putExtra(str2, z);
                intent.putStringArrayListExtra("key_select_video_list", arrayList3);
                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.o(this.mSQ));
                AlbumPreviewUI.p(this.mSQ);
                if (arrayList4.size() > 0) {
                    intent.setClassName(this.mSQ, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.j(this.mSQ));
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.k(this.mSQ));
                    intent.putExtra("CropImage_limit_Img_Size", 26214400);
                    x.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    this.mSQ.startActivityForResult(intent, 4373);
                } else {
                    x.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                    this.mSQ.setResult(-1, intent);
                    this.mSQ.finish();
                }
            }
        }
        return true;
    }
}
