package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.m;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ a oBU;

    a$4(a aVar, Bitmap bitmap) {
        this.oBU = aVar;
        this.jsN = bitmap;
    }

    public final void run() {
        int i;
        int i2;
        int i3;
        a Js = d.Js(this.oBU.videoPath);
        if (Js != null) {
            i = Js.width;
            i2 = Js.height;
            i3 = Js.videoBitrate;
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.oBU.videoPath);
            i = bh.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
            i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
            i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(20), -1);
            mediaMetadataRetriever.release();
        }
        if (i <= 0 || i2 <= 0 || i3 <= 0) {
            x.e("MicroMsg.MMSightVideoEditor", "doRemuxVideo, retrieve video metadata error, width: %s, height: %s, bitrate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int min;
        String str;
        long Wq;
        if (this.oBU.oBO && this.oBU.osr != null) {
            Point point;
            if (i3 > this.oBU.osr.videoBitrate) {
                i3 = this.oBU.osr.videoBitrate;
            }
            int i4 = this.oBU.osr.width;
            int i5 = this.oBU.osr.height;
            x.d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
            if (i > i4 || i2 > i5) {
                int max = Math.max(i, i2);
                min = Math.min(i, i2);
                int max2 = Math.max(i4, i5);
                int min2 = Math.min(i4, i5);
                if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                    x.i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
                    point = null;
                } else if (max / 2 == max2 && min / 2 == min2) {
                    x.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
                    i4 = i / 2;
                    i5 = i2 / 2;
                    if (i4 % 2 != 0) {
                        i4++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    point = new Point(i4, i5);
                } else {
                    max /= 2;
                    min /= 2;
                    if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                        Point point2 = new Point();
                        if (i < i2) {
                            i5 = Math.min(i4, i5);
                            i4 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) i5)));
                        } else {
                            i4 = Math.min(i4, i5);
                            i5 = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i4)));
                        }
                        if (i4 % 2 != 0) {
                            i4++;
                        }
                        if (i5 % 2 != 0) {
                            i5++;
                        }
                        x.i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
                        point2.x = i5;
                        point2.y = i4;
                        point = point2;
                    } else {
                        x.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
                        i4 = i / 2;
                        i5 = i2 / 2;
                        if (i4 % 2 != 0) {
                            i4++;
                        }
                        if (i5 % 2 != 0) {
                            i5++;
                        }
                        point = new Point(i4, i5);
                    }
                }
            } else {
                x.i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
                point = null;
            }
            if (point != null) {
                i = point.x;
                i2 = point.y;
                min = i3;
                str = this.oBU.videoPath + "remuxOutput.mp4";
                if (!bh.ov(this.oBU.oBR)) {
                    str = this.oBU.oBR;
                }
                if (this.oBU.oBF >= 0 || this.oBU.oBG <= 0) {
                    if (this.oBU.oBS == -1 && (this.oBU.oBS == 1 || this.oBU.oBS == 2)) {
                        this.oBU.oBL = com.tencent.mm.plugin.mmsight.api.a.oqW.a(this.oBU.oBS, this.oBU.videoPath, str, i, i2, min, this.oBU.osr.fps);
                    } else {
                        this.oBU.oBL = com.tencent.mm.plugin.mmsight.api.a.oqW.a(this.oBU.videoPath, str, i, i2, min, this.oBU.osr.fps);
                    }
                } else if (this.oBU.oBS == -1 || !(this.oBU.oBS == 1 || this.oBU.oBS == 2)) {
                    this.oBU.oBL = com.tencent.mm.plugin.mmsight.api.a.oqW.a(this.oBU.videoPath, str, i, i2, min, this.oBU.osr.fps, (long) this.oBU.oBF, (long) this.oBU.oBG);
                } else {
                    this.oBU.oBL = com.tencent.mm.plugin.mmsight.api.a.oqW.a(this.oBU.oBS, this.oBU.videoPath, str, i, i2, min, this.oBU.osr.fps, (long) this.oBU.oBF, (long) this.oBU.oBG);
                }
                x.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", new Object[]{Integer.valueOf(this.oBU.oBS), this.oBU.oBL});
                if (this.oBU.oBL != null) {
                    ag.y(new 1(this));
                }
                m.sV(this.oBU.oBL.getType());
                Wq = bh.Wq();
                if (this.jsN != null) {
                    this.oBU.oBL.z(this.jsN);
                }
                if (this.oBU.oBL.aZQ() >= 0) {
                    x.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", new Object[]{Integer.valueOf(this.oBU.oBL.aZQ())});
                    ag.y(new 2(this));
                    m.sW(this.oBU.oBL.getType());
                    return;
                }
                if (bh.ov(this.oBU.oBR)) {
                    FileOp.at(str, this.oBU.videoPath);
                }
                m.B(this.oBU.oBL.getType(), bh.bA(Wq));
                b bVar = this.oBU.oBT;
                boolean z = this.oBU.oBF < 0 && this.oBU.oBG > 0;
                bVar.oxd = z;
                this.oBU.oBT.oxa = this.oBU.oBG - this.oBU.oBF;
                this.oBU.oBT.owZ = Js != null ? 0 : Js.mxs;
                ag.y(new 3(this));
                return;
            }
        }
        min = i3;
        str = this.oBU.videoPath + "remuxOutput.mp4";
        if (bh.ov(this.oBU.oBR)) {
            str = this.oBU.oBR;
        }
        if (this.oBU.oBF >= 0) {
        }
        if (this.oBU.oBS == -1) {
        }
        this.oBU.oBL = com.tencent.mm.plugin.mmsight.api.a.oqW.a(this.oBU.videoPath, str, i, i2, min, this.oBU.osr.fps);
        x.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", new Object[]{Integer.valueOf(this.oBU.oBS), this.oBU.oBL});
        if (this.oBU.oBL != null) {
            m.sV(this.oBU.oBL.getType());
            Wq = bh.Wq();
            if (this.jsN != null) {
                this.oBU.oBL.z(this.jsN);
            }
            if (this.oBU.oBL.aZQ() >= 0) {
                if (bh.ov(this.oBU.oBR)) {
                    FileOp.at(str, this.oBU.videoPath);
                }
                m.B(this.oBU.oBL.getType(), bh.bA(Wq));
                b bVar2 = this.oBU.oBT;
                if (this.oBU.oBF < 0) {
                }
                bVar2.oxd = z;
                this.oBU.oBT.oxa = this.oBU.oBG - this.oBU.oBF;
                if (Js != null) {
                }
                this.oBU.oBT.owZ = Js != null ? 0 : Js.mxs;
                ag.y(new 3(this));
                return;
            }
            x.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", new Object[]{Integer.valueOf(this.oBU.oBL.aZQ())});
            ag.y(new 2(this));
            m.sW(this.oBU.oBL.getType());
            return;
        }
        ag.y(new 1(this));
    }
}
