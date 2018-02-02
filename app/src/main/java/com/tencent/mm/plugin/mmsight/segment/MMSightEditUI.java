package com.tencent.mm.plugin.mmsight.segment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.a.a$a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMSightEditUI extends MMActivity {
    private String fvC;
    private d mfB = new d(ac.getContext());
    private VideoTransPara osr;
    private VideoSeekBarEditorView oxA;
    private com.tencent.mm.plugin.mmsight.ui.a oxB;
    private String oxC;
    private boolean oxD = false;
    private boolean oxE = false;
    private f.a oxF = new 3(this);
    private ViewGroup oxy;
    private VideoPlayerTextureView oxz;
    private String videoPath;

    static /* synthetic */ void a(MMSightEditUI mMSightEditUI) {
        if (fs(mMSightEditUI)) {
            mMSightEditUI.cmY();
            mMSightEditUI.DR(0);
        }
        mMSightEditUI.oxy = (ViewGroup) mMSightEditUI.findViewById(com.tencent.mm.plugin.u.a.d.cIu);
        mMSightEditUI.oxz = (VideoPlayerTextureView) mMSightEditUI.findViewById(com.tencent.mm.plugin.u.a.d.oET);
        mMSightEditUI.oxA = (VideoSeekBarEditorView) mMSightEditUI.findViewById(com.tencent.mm.plugin.u.a.d.oEU);
        mMSightEditUI.videoPath = mMSightEditUI.getIntent().getStringExtra("key_video_path");
        mMSightEditUI.osr = (VideoTransPara) mMSightEditUI.getIntent().getParcelableExtra("key_video_para");
        mMSightEditUI.oxD = mMSightEditUI.getIntent().getBooleanExtra("key_need_clip_video_first", false);
        if (bh.ov(mMSightEditUI.videoPath)) {
            x.e("MicroMsg.MMSightEditUI", "error!, videoPath is null!!");
            return;
        }
        if (mMSightEditUI.osr == null) {
            x.e("MicroMsg.MMSightEditUI", "videoTransPara is null!, use SnsAlbumVideoTransPara");
            mMSightEditUI.osr = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        }
        x.i("MicroMsg.MMSightEditUI", "videoTransPara: %s", new Object[]{mMSightEditUI.osr});
        mMSightEditUI.oxz.setAlpha(0.0f);
        mMSightEditUI.oxz.setVideoPath(mMSightEditUI.videoPath);
        mMSightEditUI.oxz.ccJ();
        mMSightEditUI.oxz.quG = mMSightEditUI.oxF;
        mMSightEditUI.oxC = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        mMSightEditUI.fvC = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        if (ae.fy(mMSightEditUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) mMSightEditUI.oxA.getLayoutParams();
            marginLayoutParams.bottomMargin += ae.fx(mMSightEditUI);
            mMSightEditUI.oxA.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ void i(MMSightEditUI mMSightEditUI) {
        mMSightEditUI.oxB = new com.tencent.mm.plugin.mmsight.ui.a();
        mMSightEditUI.oxB.oBO = true;
        mMSightEditUI.oxB.oBS = 2;
        mMSightEditUI.oxB.oBM = new 2(mMSightEditUI);
        mMSightEditUI.oxB.oBR = mMSightEditUI.oxC;
        mMSightEditUI.oxB.a(mMSightEditUI, WXMediaMessage.TITLE_LENGTH_LIMIT, mMSightEditUI.videoPath, mMSightEditUI.oxA, mMSightEditUI.oxz, mMSightEditUI.oxy, mMSightEditUI.osr, mMSightEditUI.oxD);
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.gB(true);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.gB(false);
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mfB));
        this.mfB.I(new 1(this, bh.Wq()));
    }

    protected final int getLayoutId() {
        return e.oEZ;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
        if (this.oxB == null || !this.oxB.aeG()) {
            super.onBackPressed();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oxz != null) {
            this.oxz.pause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.oxz != null) {
            this.oxz.start();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oxz != null) {
            this.oxz.stop();
        }
        if (this.oxB != null) {
            if (this.oxE) {
                com.tencent.mm.plugin.mmsight.a.a.a(new a$a(this.oxB.scene));
            }
            this.oxB.release();
        }
    }
}
