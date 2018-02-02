package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI extends MMActivity {
    private long duration = -1;
    private VideoView rZL;
    private String rZM = null;
    private final int rZN = 3000;
    private af rZO = new 2(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.rZM = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        setMMTitle(R.l.eTl);
        setBackBtn(new 1(this));
        initView();
    }

    public void onStart() {
        super.onStart();
    }

    protected final void initView() {
        this.rZL = (VideoView) findViewById(R.h.cVn);
        this.rZL.hXb = new 3(this);
        this.rZL.zqn = new 4(this);
        findViewById(R.h.cVm).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI rZP;

            {
                this.rZP = r1;
            }

            public final void onClick(View view) {
                this.rZP.rZO.removeMessages(0);
                if (this.rZP.mController.isTitleShowing()) {
                    this.rZP.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    this.rZP.mController.hideTitleView();
                    return;
                }
                this.rZP.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.rZP.mController.showTitleView();
                this.rZP.rZO.removeMessages(0);
                this.rZP.rZO.sendEmptyMessageDelayed(0, 3000);
            }
        });
        this.rZL.hXa = new 6(this);
        if (this.rZM != null) {
            this.rZL.stopPlayback();
            VideoView videoView = this.rZL;
            videoView.vyB = this.rZM;
            videoView.vyD = false;
            videoView.zqp = 0;
            videoView.aJH();
            videoView.requestLayout();
            videoView.invalidate();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.rZL.isPlaying()) {
            VideoView videoView = this.rZL;
            if (videoView.qxO != null && videoView.vyC && videoView.qxO.isPlaying()) {
                videoView.qxO.pause();
            }
            videoView.vyD = false;
        }
        finish();
        overridePendingTransition(0, 0);
        this.rZO.removeMessages(0);
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xIy);
        ((ViewGroup) this.mController.xIy.getParent()).removeView(this.mController.xIy);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xIy, 0);
    }

    protected final int getLayoutId() {
        return R.i.dtv;
    }
}
