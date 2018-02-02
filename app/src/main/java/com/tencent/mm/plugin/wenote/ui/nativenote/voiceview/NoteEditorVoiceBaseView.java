package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

public class NoteEditorVoiceBaseView extends TextView implements a {
    private boolean bgH = false;
    private Context context;
    private int duration = -1;
    public int fvx;
    private AlphaAnimation pGA;
    private AnimationDrawable pGB;
    public String path = "";

    static /* synthetic */ void c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        x.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.fvx)});
        if (!a.bXQ().startPlay(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.fvx)) {
            Toast.makeText(noteEditorVoiceBaseView.getContext(), R.l.egV, 1).show();
        } else if (!noteEditorVoiceBaseView.bgH) {
            noteEditorVoiceBaseView.bgH = true;
            noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.pGB, null, null, null);
            noteEditorVoiceBaseView.pGB.stop();
            noteEditorVoiceBaseView.pGB.start();
        }
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bnj();
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
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

    public final void bnk() {
        if (this.pGA != null && this.pGA.isInitialized()) {
            setAnimation(null);
        }
        this.bgH = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.dxq), null, null, null);
        this.pGB.stop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoteEditorVoiceBaseView tYO;

            {
                this.tYO = r1;
            }

            public final void onClick(View view) {
                String str = "MicroMsg.NoteEditorVoiceBaseView";
                String str2 = "clicked path:%s, player isPlay:%s, path:%s";
                Object[] objArr = new Object[3];
                objArr[0] = this.tYO.path;
                objArr[1] = a.bXQ().aIA() ? "true" : "false";
                objArr[2] = a.bXQ().path;
                x.i(str, str2, objArr);
                if (!com.tencent.mm.p.a.aW(this.tYO.context) && !com.tencent.mm.p.a.aU(this.tYO.context)) {
                    if (!f.ze() && !bh.ov(this.tYO.path)) {
                        u.fI(view.getContext());
                    } else if (!k.bVQ().kEo) {
                        if (bh.az(this.tYO.path, "").equals(a.bXQ().path) && a.bXQ().aIA()) {
                            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.tYO;
                            x.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                            noteEditorVoiceBaseView.bnk();
                            a.bXQ().stopPlay();
                            return;
                        }
                        NoteEditorVoiceBaseView.c(this.tYO);
                    }
                }
            }
        });
    }

    public final void Ra(String str) {
        x.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!bh.az(str, "").equals(this.path)) {
            bnk();
        }
    }

    public final void bXP() {
        bnk();
    }
}
