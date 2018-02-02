package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class RecordVoiceBaseView extends TextView implements a {
    private boolean bgH = false;
    private Context context;
    public int duration = -1;
    public int fvx;
    private AlphaAnimation pGA;
    private AnimationDrawable pGB;
    public m pGC;
    public String path = "";

    static /* synthetic */ void d(RecordVoiceBaseView recordVoiceBaseView) {
        x.d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.fvx)});
        if (!recordVoiceBaseView.pGC.startPlay(recordVoiceBaseView.path, recordVoiceBaseView.fvx)) {
            Toast.makeText(recordVoiceBaseView.getContext(), R.l.egV, 1).show();
        } else if (!recordVoiceBaseView.bgH) {
            recordVoiceBaseView.bgH = true;
            recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.pGB, null, null, null);
            recordVoiceBaseView.pGB.stop();
            recordVoiceBaseView.pGB.start();
        }
    }

    static /* synthetic */ boolean e(RecordVoiceBaseView recordVoiceBaseView) {
        x.i("MicroMsg.RecordVoiceBaseView", "resume play");
        m mVar = recordVoiceBaseView.pGC;
        x.i("MicroMsg.RecordVoiceHelper", "resume play");
        ae.Vc("keep_app_silent");
        if (mVar.mql != null) {
            return mVar.mql.vc();
        }
        x.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
        return false;
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bnj();
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        bnj();
    }

    private void bnj() {
        this.pGA = new AlphaAnimation(0.1f, 1.0f);
        this.pGA.setDuration(1000);
        this.pGA.setRepeatCount(-1);
        this.pGA.setRepeatMode(2);
        this.pGB = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.dxr);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pGB.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxs);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pGB.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxt);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pGB.addFrame(drawable, 300);
        this.pGB.setOneShot(false);
        this.pGB.setVisible(true, true);
    }

    private void bnk() {
        if (this.pGA != null && this.pGA.isInitialized()) {
            setAnimation(null);
        }
        this.bgH = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.dxq), null, null, null);
        this.pGB.stop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new 1(this));
    }

    public final void stopPlay() {
        x.d("MicroMsg.RecordVoiceBaseView", "stop play");
        bnk();
        this.pGC.stopPlay();
    }

    public final void Il(String str) {
        x.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!bh.az(str, "").equals(this.path)) {
            bnk();
        }
    }

    public final void onFinish() {
        stopPlay();
    }
}
