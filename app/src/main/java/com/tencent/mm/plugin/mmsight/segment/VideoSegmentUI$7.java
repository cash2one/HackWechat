package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$7 implements Runnable {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$7(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void run() {
        boolean z = true;
        String str = null;
        try {
            VideoSegmentUI.d(this.ozX).stop();
            int e = VideoSegmentUI.e(this.ozX);
            long Wq = bh.Wq();
            VideoSegmentUI.i(this.ozX).a(VideoSegmentUI.f(this.ozX), VideoSegmentUI.g(this.ozX), VideoSegmentUI.h(this.ozX));
            if (VideoSegmentUI.i(this.ozX).x((long) (VideoSegmentUI.j(this.ozX).baZ() * ((float) e)), (long) (((float) e) * VideoSegmentUI.j(this.ozX).bba())) < 0) {
                x.i("MicroMsg.VideoSegmentUI", "clip failed! %s", new Object[]{Integer.valueOf(VideoSegmentUI.i(this.ozX).x((long) (VideoSegmentUI.j(this.ozX).baZ() * ((float) e)), (long) (((float) e) * VideoSegmentUI.j(this.ozX).bba())))});
                ag.y(new Runnable(this) {
                    final /* synthetic */ VideoSegmentUI$7 ozZ;

                    {
                        this.ozZ = r1;
                    }

                    public final void run() {
                        if (VideoSegmentUI.k(this.ozZ.ozX) != null) {
                            VideoSegmentUI.k(this.ozZ.ozX).dismiss();
                        }
                        if (VideoSegmentUI.j(this.ozZ.ozX) != null) {
                            VideoSegmentUI.j(this.ozZ.ozX).gE(false);
                        }
                        Toast.makeText(this.ozZ.ozX, f.oyv, 1).show();
                    }
                });
                return;
            }
            Bitmap mz = d.mz(VideoSegmentUI.g(this.ozX));
            if (mz != null) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (d.a(mz.getWidth(), mz.getHeight(), VideoSegmentUI.h(this.ozX).hup, pInt, pInt2)) {
                    mz = Bitmap.createScaledBitmap(mz, pInt.value, pInt2.value, true);
                }
                x.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", new Object[]{Integer.valueOf(mz.getWidth()), Integer.valueOf(mz.getHeight())});
                com.tencent.mm.sdk.platformtools.d.a(mz, 80, CompressFormat.JPEG, VideoSegmentUI.l(this.ozX), true);
                x.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", new Object[]{Long.valueOf(bh.bA(Wq))});
            } else {
                x.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
            }
            ag.y(new Runnable(this) {
                final /* synthetic */ VideoSegmentUI$7 ozZ;

                public final void run() {
                    if (VideoSegmentUI.k(this.ozZ.ozX) != null) {
                        VideoSegmentUI.k(this.ozZ.ozX).dismiss();
                    }
                    if (VideoSegmentUI.j(this.ozZ.ozX) != null) {
                        VideoSegmentUI.j(this.ozZ.ozX).gE(false);
                    }
                    VideoSegmentUI.a(this.ozZ.ozX, z, str);
                }
            });
        } catch (Throwable e2) {
            Throwable th = e2;
            str = th.getMessage();
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", th, "UnexpectedException when clip : [%s]", new Object[]{th.getMessage()});
            z = false;
        }
    }
}
