package com.tencent.mm.ui.chatting.gallery;

import android.support.v4.view.ViewPager.e;
import android.view.View;
import com.tencent.mm.aq.f;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.x;

class ImageGalleryUI$5 implements e {
    final /* synthetic */ ImageGalleryUI yFy;
    private boolean yFz = false;

    ImageGalleryUI$5(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        if (ImageGalleryUI.f(this.yFy) != null) {
            View EQ = ImageGalleryUI.f(this.yFy).EQ(i);
            if (EQ == null) {
                x.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[]{Integer.valueOf(i)});
            }
            ImageGalleryUI.q(this.yFy);
            ImageGalleryUI.e(this.yFy, i);
            if (ImageGalleryUI.f(this.yFy) != null) {
                b f = ImageGalleryUI.f(this.yFy);
                f.yCY.cuG();
                f.yCZ.cuG();
                cf FL = ImageGalleryUI.f(this.yFy).FL(i);
                if (!((!b.aW(FL) && !b.aZ(FL)) || EQ == null || EQ.getTag() == null)) {
                    ((j) EQ.getTag()).yGx.cpS();
                }
                if (FL != null) {
                    this.yFy.gn(FL.field_msgId);
                }
                if (ImageGalleryUI.f(this.yFy) != null) {
                    com.tencent.mm.aq.e f2 = ImageGalleryUI.f(this.yFy).f(FL, false);
                    ImageGalleryUI.f(this.yFy);
                    if (b.a(FL, f2)) {
                        f2 = f.a(f2);
                        int i2 = f2.hlp;
                        x.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[]{Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) f2.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis())});
                        this.yFy.Gf(r0);
                    } else if (FL == null || FL.cjh() || !ImageGalleryUI.f(this.yFy).bb(FL)) {
                        this.yFy.ft(true);
                    } else {
                        this.yFy.ft(false);
                    }
                } else {
                    x.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                }
                if (FL == null) {
                    x.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + i);
                } else {
                    this.yFy.bp(FL);
                    ImageGalleryUI.g(this.yFy);
                }
            }
            if (ImageGalleryUI.f(this.yFy) != null) {
                ImageGalleryUI.f(this.yFy).ae(i);
            }
        }
    }

    public final void af(int i) {
        x.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[]{Integer.valueOf(i)});
        if (i == 2) {
            this.yFz = true;
            ImageGalleryUI.z(this.yFy);
            ImageGalleryUI.A(this.yFy);
            ImageGalleryUI.B(this.yFy);
        }
        if (i == 0) {
            if (this.yFz) {
                this.yFy.cva();
            }
            this.yFz = false;
        }
        if (ImageGalleryUI.f(this.yFy) != null) {
            b f = ImageGalleryUI.f(this.yFy);
            if (f.yCX != null) {
                d dVar = f.yCX;
                dVar.yi = i;
                if (dVar.yEl != null) {
                    dVar.yEl.af(i);
                }
            }
        }
    }
}
