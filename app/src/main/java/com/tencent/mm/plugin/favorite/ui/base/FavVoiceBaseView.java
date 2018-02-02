package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.a.i;
import com.tencent.mm.plugin.favorite.a.i.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class FavVoiceBaseView extends LinearLayout implements a {
    private int duration;
    private int fvx;
    public i mqV;
    private ViewGroup mvM;
    private TextView mvN;
    private ImageButton mvO;
    private TextView mvP;
    private a mvQ;
    private String path = "";

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        x.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.fvx)});
        if (favVoiceBaseView.mqV.startPlay(favVoiceBaseView.path, favVoiceBaseView.fvx)) {
            favVoiceBaseView.mvN.setKeepScreenOn(true);
            favVoiceBaseView.mvQ.begin();
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), R.l.egV, 1).show();
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        x.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean aIB = favVoiceBaseView.mqV.aIB();
        a aVar = favVoiceBaseView.mvQ;
        aVar.isPaused = false;
        aVar.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        aVar.mvR.mvO.setImageResource(R.k.dBz);
        aVar.mvR.mvO.setContentDescription(aVar.mvR.getContext().getResources().getString(R.l.dFV));
        favVoiceBaseView.mvN.setKeepScreenOn(true);
        return aIB;
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[]{Boolean.valueOf(this.mvQ.isPaused)});
        if (this.mvQ.isPaused) {
            this.mvQ.postDelayed(new 1(this), 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mvM = (ViewGroup) findViewById(R.h.cWB);
        this.mvP = (TextView) findViewById(R.h.cWz);
        this.mvN = (TextView) findViewById(R.h.cWA);
        this.mvO = (ImageButton) findViewById(R.h.cWy);
        this.mvQ = new a(this, (byte) 0);
        this.mvO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavVoiceBaseView mvR;

            {
                this.mvR = r1;
            }

            public final void onClick(View view) {
                if (!com.tencent.mm.p.a.aW(view.getContext()) && !com.tencent.mm.p.a.aU(view.getContext())) {
                    if (!f.ze() && !bh.ov(this.mvR.path)) {
                        u.fI(view.getContext());
                    } else if (!bh.az(this.mvR.path, "").equals(this.mvR.mqV.path)) {
                        FavVoiceBaseView.i(this.mvR);
                    } else if (this.mvR.mqV.aIA()) {
                        this.mvR.aIC();
                    } else if (!FavVoiceBaseView.j(this.mvR)) {
                        FavVoiceBaseView.i(this.mvR);
                    }
                }
            }
        });
    }

    public final void H(String str, int i, int i2) {
        this.path = bh.az(str, "");
        this.fvx = i;
        this.duration = i2;
        if (!this.path.equals(this.mqV.path)) {
            this.mvQ.pO(i2);
        } else if (this.mqV.aIA()) {
            x.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPlay()");
            r0 = this.mvQ;
            this.mqV.vf();
            r0.ff(true);
        } else if (this.mqV.vg()) {
            x.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPause()");
            r0 = this.mvQ;
            this.mqV.vf();
            r0.ff(false);
        } else {
            this.mvQ.pO(i2);
        }
    }

    public final boolean aIC() {
        x.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean aIC = this.mqV.aIC();
        a aVar = this.mvQ;
        aVar.isPaused = true;
        aVar.removeMessages(Downloads.RECV_BUFFER_SIZE);
        aVar.mvR.mvO.setImageResource(R.k.dBy);
        aVar.mvR.mvO.setContentDescription(aVar.mvR.getContext().getResources().getString(R.l.dGk));
        this.mvN.setKeepScreenOn(false);
        return aIC;
    }

    public final void stopPlay() {
        x.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.mqV.stopPlay();
        this.mvQ.stop();
        this.mvN.setKeepScreenOn(false);
    }

    public final void bj(String str, int i) {
        x.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (bh.az(str, "").equals(this.path)) {
            this.mvN.setKeepScreenOn(true);
            this.mvQ.begin();
            return;
        }
        this.mvQ.stop();
        this.mvN.setKeepScreenOn(false);
    }

    public final void onFinish() {
        stopPlay();
    }

    public final void onPause() {
        aIC();
    }
}
