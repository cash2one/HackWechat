package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.i$d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class SnsAdNativeLandingTestUI extends MMActivity {
    private int duration = 0;
    private af hae = new af();
    private double qve = 0.0d;
    private int rkQ;
    private VideoSightView ryG;
    SnsAdNativeLandingPagesVideoPlayerLoadingBar ryH;
    private int videoHeight;
    private int videoWidth;

    static /* synthetic */ void b(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.qve = snsAdNativeLandingTestUI.ryG.btg();
        snsAdNativeLandingTestUI.ryG.pause();
        snsAdNativeLandingTestUI.hae.post(new Runnable(snsAdNativeLandingTestUI) {
            final /* synthetic */ SnsAdNativeLandingTestUI ryI;

            {
                this.ryI = r1;
            }

            public final void run() {
                this.ryI.ryH.db(false);
            }
        });
    }

    static /* synthetic */ void c(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        snsAdNativeLandingTestUI.ryG.q(snsAdNativeLandingTestUI.qve);
        snsAdNativeLandingTestUI.ryG.start();
        snsAdNativeLandingTestUI.hae.post(new Runnable(snsAdNativeLandingTestUI) {
            final /* synthetic */ SnsAdNativeLandingTestUI ryI;

            {
                this.ryI = r1;
            }

            public final void run() {
                this.ryI.ryH.db(true);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        ((Button) findViewById(f.qEa)).setOnClickListener(new 1(this));
        ViewGroup viewGroup = (ViewGroup) findViewById(f.qDZ);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.xIM.getSystemService("layout_inflater");
        WindowManager windowManager = (WindowManager) this.mController.xIM.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        String str = "adId";
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str + "_image_" + ab.UZ("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
        str = str + "_stream_" + ab.UZ("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
        View inflate = layoutInflater.inflate(g.qGT, null);
        inflate.setMinimumHeight(height);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(f.qDK);
        this.ryG = new VideoSightView(this.mController.xIM);
        this.ryG.cP(false);
        viewGroup2.addView(this.ryG, 0, new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.b(this.mController.xIM, this.mController.xIM.getResources().getDimension(i$d.qyJ));
        this.ryH = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(this.mController.xIM);
        this.ryH.setVisibility(0);
        this.ryG.id(true);
        ((ViewGroup) inflate).addView(this.ryH, layoutParams);
        this.ryH.quk = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI ryI;

            {
                this.ryI = r1;
            }

            public final void agX() {
            }

            public final void kH(int i) {
                x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time " + i);
                this.ryI.qve = (double) i;
                this.ryI.ryG.q((double) i);
            }
        };
        this.ryH.i(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI ryI;

            {
                this.ryI = r1;
            }

            public final void onClick(View view) {
                if (this.ryI.ryG.isPlaying()) {
                    SnsAdNativeLandingTestUI.b(this.ryI);
                } else {
                    SnsAdNativeLandingTestUI.c(this.ryI);
                }
            }
        });
        this.ryH.db(this.ryG.isPlaying());
        this.ryH.setVisibility(0);
        this.ryH.seek(0);
        this.ryG.quG = new a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI ryI;

            {
                this.ryI = r1;
            }

            public final void hX() {
                if (this.ryI.ryH.fvG) {
                    SnsAdNativeLandingTestUI.c(this.ryI);
                }
            }

            public final void onError(int i, int i2) {
                this.ryI.ryG.stop();
            }

            public final void vh() {
            }

            public final int cf(int i, int i2) {
                ag.y(new 1(this, i, i2));
                return 0;
            }

            public final void cg(int i, int i2) {
                this.ryI.videoWidth = i;
                this.ryI.videoHeight = i2;
            }
        };
        this.ryG.rmu = false;
        this.ryG.setOnClickListener(new 6(this));
        viewGroup.addView(inflate, new LayoutParams(width, height));
        this.ryG.post(new 7(this));
        new a(str2, str3, ae.aNT(), new 8(this)).execute(new String[]{"http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150"});
        new a(str2, str, ae.aNT(), new 9(this), Downloads.SPLIT_RANGE_SIZE_WAP).execute(new String[]{"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400"});
    }

    protected final int getLayoutId() {
        return g.qGY;
    }
}
