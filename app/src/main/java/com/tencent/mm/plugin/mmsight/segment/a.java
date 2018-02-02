package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements f {
    private String lAn;
    String oxg;
    String oxh;
    private MediaExtractor oxi;
    private List<a> oxj = new ArrayList();
    private List<a> oxk = new ArrayList();
    long oxl;
    long oxm;
    int oxn = -1;
    private boolean oxo = false;
    VideoTransPara oxp;
    int oxq = -1;

    public abstract int Fk(String str);

    public void a(String str, String str2, VideoTransPara videoTransPara) {
        x.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long Wq = bh.Wq();
        if (bh.ov(str) || bh.ov(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.bO(str) && file.canRead() && file.length() != 0) {
            this.oxh = str;
            this.oxg = str2;
            this.oxp = videoTransPara;
            this.oxi = new MediaExtractor();
            this.oxi.setDataSource(str);
            a(this.oxi);
            if (this.oxj == null || this.oxj.size() == 0) {
                throw new o("Can not find video or audio track in this video file.");
            }
            this.oxn = baX();
            this.oxq = Fk(str);
            this.oxo = true;
            x.e("BaseMediaCodecClipper", "init cost time %dms", Long.valueOf(bh.bA(Wq)));
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
    }

    private void a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !bh.ov(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                x.i("BaseMediaCodecClipper", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.oxk.add(new a(this, trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.oxj.add(new a(this, trackFormat, i));
                }
            }
        }
        x.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.oxk.size()), Integer.valueOf(this.oxj.size()));
    }

    public int x(long j, long j2) {
        if (this.oxo) {
            if (j < 0) {
                j = 0;
            }
            this.oxl = j;
            MediaFormat mediaFormat = ((a) this.oxj.get(0)).owb;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.oxm = j2;
                return a(this.oxi, this.oxk, this.oxj);
            }
            throw new o("Can not find duration.");
        }
        x.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    protected int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        return 0;
    }

    protected final String baW() {
        if (this.lAn == null) {
            this.lAn = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.lAn;
    }

    public final void release() {
        this.oxo = false;
        if (this.oxi != null) {
            this.oxi.release();
        }
    }

    private int baX() {
        int i;
        int i2 = -1;
        if (!(this.oxk == null || this.oxk.size() == 0)) {
            i = -1;
            for (a aVar : this.oxk) {
                if (aVar.owb.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.owb.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            i2 = i;
        }
        if (this.oxj == null || this.oxj.size() == 0) {
            return i2;
        }
        i = i2;
        for (a aVar2 : this.oxj) {
            if (aVar2.owb.containsKey("max-input-size")) {
                i2 = Math.max(aVar2.owb.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }
}
