package com.tencent.mm.plugin.favorite.ui.base;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class FavVoiceBaseView$a extends af {
    boolean isPaused;
    final /* synthetic */ FavVoiceBaseView mvR;
    float mvS;
    float mvT;
    int mvU;
    int mvV;

    private FavVoiceBaseView$a(FavVoiceBaseView favVoiceBaseView) {
        this.mvR = favVoiceBaseView;
    }

    public final void pO(int i) {
        this.isPaused = false;
        this.mvS = j.bv((long) i);
        this.mvT = this.mvS;
        this.mvV = a.fromDPToPix(this.mvR.getContext(), 3);
        FavVoiceBaseView.a(this.mvR).setText(g.v(this.mvR.getContext(), (int) this.mvS));
        FavVoiceBaseView.b(this.mvR).setImageResource(R.k.dBy);
        FavVoiceBaseView.b(this.mvR).setContentDescription(this.mvR.getContext().getResources().getString(R.l.dGk));
        FavVoiceBaseView.c(this.mvR).setWidth(this.mvV);
    }

    public final void begin() {
        stop();
        this.isPaused = false;
        FavVoiceBaseView.b(this.mvR).setImageResource(R.k.dBz);
        FavVoiceBaseView.b(this.mvR).setContentDescription(this.mvR.getContext().getResources().getString(R.l.dFV));
        sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
    }

    public final void stop() {
        this.isPaused = false;
        removeMessages(Downloads.RECV_BUFFER_SIZE);
        pO(FavVoiceBaseView.d(this.mvR));
    }

    public final void aJC() {
        this.mvU = ((int) ((1.0f - (this.mvT / this.mvS)) * ((float) (FavVoiceBaseView.e(this.mvR).getWidth() - this.mvV)))) + this.mvV;
        FavVoiceBaseView.a(this.mvR).setText(g.v(this.mvR.getContext(), Math.min((int) Math.ceil((double) this.mvT), (int) this.mvS)));
        FavVoiceBaseView.c(this.mvR).setWidth(this.mvU);
    }

    public final void ff(boolean z) {
        this.mvV = a.fromDPToPix(this.mvR.getContext(), 3);
        FavVoiceBaseView.b(this.mvR).setImageResource(R.k.dBy);
        FavVoiceBaseView.b(this.mvR).setContentDescription(this.mvR.getContext().getResources().getString(R.l.dGk));
        aJC();
        if (z) {
            FavVoiceBaseView.b(this.mvR).setImageResource(R.k.dBz);
            FavVoiceBaseView.b(this.mvR).setContentDescription(this.mvR.getContext().getResources().getString(R.l.dFV));
            sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        }
    }

    public final void handleMessage(Message message) {
        this.mvT = Math.max(0.0f, this.mvT - 0.256f);
        aJC();
        if (this.mvT > 0.1f) {
            sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 256);
        }
    }
}
