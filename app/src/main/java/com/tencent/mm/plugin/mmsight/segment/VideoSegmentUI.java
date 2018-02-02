package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.FileUtils;
import java.util.concurrent.CountDownLatch;

@a(3)
public class VideoSegmentUI extends MMActivity {
    private String fvC;
    private int hOr;
    private ProgressDialog iln = null;
    private Surface mSurface;
    private d mfB = new d(this);
    private RelativeLayout mxu;
    private VideoTransPara osr;
    private String oxC = "";
    private String ozK = null;
    private f ozL;
    private c ozM;
    private boolean ozN = false;
    private c ozO;
    private CountDownLatch ozP = new CountDownLatch(2);
    private int ozQ = 10000;
    private boolean ozR = false;
    private boolean ozS = false;
    private boolean ozT = false;
    private com.tencent.mm.plugin.mmsight.segment.c.b ozU = new 2(this);
    private c.a ozV = new 3(this);
    private com.tencent.mm.plugin.mmsight.segment.a.a.d ozW = new 4(this);

    private class b implements SurfaceTextureListener {
        final /* synthetic */ VideoSegmentUI ozX;

        private b(VideoSegmentUI videoSegmentUI) {
            this.ozX = videoSegmentUI;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.ozX.ozR);
            objArr[1] = Boolean.valueOf(this.ozX.ozM == null);
            x.i(str, str2, objArr);
            this.ozX.mSurface = new Surface(surfaceTexture);
            if (this.ozX.ozM == null && this.ozX.ozR) {
                x.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    this.ozX.a(false, this.ozX.mSurface);
                    if (!(this.ozX.ozO == null || this.ozX.ozM == null)) {
                        this.ozX.ozM.setLoop((int) (((float) this.ozX.hOr) * this.ozX.ozO.baZ()), (int) (((float) this.ozX.hOr) * this.ozX.ozO.bba()));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", e.getMessage());
                }
                this.ozX.ozR = false;
            }
            this.ozX.ozP.countDown();
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            x.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", bh.cgy());
            try {
                if (this.ozX.ozM != null) {
                    x.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    this.ozX.ozM.release();
                    this.ozX.ozM = null;
                    this.ozX.ozR = true;
                }
                this.ozX.mSurface = null;
            } catch (Exception e) {
            }
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        videoSegmentUI.setBackBtn(new 5(videoSegmentUI));
        videoSegmentUI.setMMTitle(f.oyu);
        videoSegmentUI.a(0, com.tencent.mm.bv.a.ac(videoSegmentUI.mController.xIM, f.dFl), new 6(videoSegmentUI), com.tencent.mm.ui.p.b.xJz);
        videoSegmentUI.enableOptionMenu(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || bh.ov(intent.getStringExtra("key_video_path"))) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            videoSegmentUI.finish();
            return;
        }
        videoSegmentUI.ozK = intent.getStringExtra("key_video_path");
        x.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", videoSegmentUI.ozK);
        if (videoSegmentUI.ozK == null || videoSegmentUI.ozK.length() == 0) {
            x.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            return;
        }
        videoSegmentUI.initView();
        try {
            videoSegmentUI.a(true, null);
            videoSegmentUI.ozO.a(new 12(videoSegmentUI));
            videoSegmentUI.ozO.a(videoSegmentUI.ozU);
            videoSegmentUI.ozO.Fl(videoSegmentUI.ozK);
            videoSegmentUI.ozL = new p();
            e.a(new d(videoSegmentUI, (byte) 0), "waiting_for_component_prepared.");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", e.getMessage());
            videoSegmentUI.finish();
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.oxC);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.fvC);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            return;
        }
        x.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", str);
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.ozP.getCount()) {
                    videoSegmentUI.ozP.countDown();
                    i++;
                } else {
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", e);
                return;
            }
        }
    }

    static /* synthetic */ void c(VideoSegmentUI videoSegmentUI) {
        videoSegmentUI.oxC = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        videoSegmentUI.fvC = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        e.post(new 8(videoSegmentUI), "delete_old_temp_video_file");
        if (bh.ov(videoSegmentUI.oxC) || bh.ov(videoSegmentUI.fvC)) {
            x.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            return;
        }
        videoSegmentUI.osr = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.osr == null) {
            x.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
        } else if (videoSegmentUI.ozK == null) {
            x.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
        } else if (videoSegmentUI.ozP.getCount() != 0) {
            x.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
        } else {
            x.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(f.dGO);
            videoSegmentUI.iln = h.a(videoSegmentUI, videoSegmentUI.getString(f.dHc), false, null);
            videoSegmentUI.ozO.gE(true);
            e.post(new 7(videoSegmentUI), "clip_video");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mfB));
        this.mfB.I(new 1(this));
    }

    protected final void initView() {
        this.ozO = (c) findViewById(k.c.oyq);
        this.mxu = (RelativeLayout) findViewById(k.c.cIu);
    }

    private void a(boolean z, Surface surface) {
        if (this.ozM != null) {
            x.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            return;
        }
        this.ozM = new c();
        this.ozN = false;
        this.ozM.setDataSource(this.ozK);
        this.ozM.a(new com.tencent.mm.plugin.mmsight.segment.a.a.a(this) {
            final /* synthetic */ VideoSegmentUI ozX;

            {
                this.ozX = r1;
            }

            public final boolean cP(int i, int i2) {
                x.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", Integer.valueOf(i), Integer.valueOf(i2));
                this.ozX.ozS = true;
                this.ozX.finish();
                VideoSegmentUI.b(this.ozX);
                return true;
            }
        });
        if (z) {
            this.ozM.a(this.ozW);
        }
        this.ozM.setAudioStreamType(3);
        this.ozM.setLooping(true);
        if (surface != null) {
            this.ozM.setSurface(surface);
        }
        this.ozM.ozV = this.ozV;
        this.ozM.a(new 10(this));
        this.ozM.prepareAsync();
        this.ozM.a(new 11(this));
    }

    protected void onResume() {
        if (this.ozM != null && this.ozN) {
            x.i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.ozM.start();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.ozM != null) {
            x.i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.ozM.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        x.i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        this.mfB.release();
        if (this.ozO != null) {
            this.ozO.release();
        }
        if (this.ozM != null) {
            this.ozM.release();
        }
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        if (this.ozL != null) {
            this.ozL.release();
        }
        j.ouM.Es();
    }

    protected final int getLayoutId() {
        return k.d.oyr;
    }
}
