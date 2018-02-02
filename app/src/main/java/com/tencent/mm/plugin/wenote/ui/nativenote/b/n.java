package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class n extends h {
    private final af tRr = new 2(this);
    public LinearLayout tYG;
    public LinearLayout tYH;
    public NoteEditorVoiceBaseView tYI;
    public ImageView tYJ;
    private TextView tYK;
    private TextView tYL;
    private k tYM;

    public n(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        this.tYG = (LinearLayout) view.findViewById(R.h.cBf);
        this.tYH = (LinearLayout) view.findViewById(R.h.cBe);
        this.tYJ = (ImageView) view.findViewById(R.h.cBg);
        this.tYK = (TextView) view.findViewById(R.h.cBh);
        this.tYL = (TextView) view.findViewById(R.h.cBi);
        this.tYI = (NoteEditorVoiceBaseView) view.findViewById(R.h.cAP);
        a bXQ = a.bXQ();
        NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.tYI;
        if (noteEditorVoiceBaseView != null) {
            for (Object obj : bXQ.gxL) {
                if (noteEditorVoiceBaseView == obj) {
                    break;
                }
            }
            bXQ.gxL.add(noteEditorVoiceBaseView);
        }
        this.tYh.setVisibility(0);
        this.tYG.setVisibility(8);
        this.tYH.setVisibility(0);
        this.fvf.setVisibility(8);
        this.tYc.setVisibility(8);
        this.tYh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ n tYN;

            {
                this.tYN = r1;
            }

            public final void onClick(View view) {
                if (this.tYN.tYM != null && this.tYN.tYM.tRH.booleanValue()) {
                    this.tYN.tYM.tRI = Boolean.valueOf(true);
                }
            }
        });
    }

    public final void a(b bVar, int i, int i2) {
        this.tYM = (k) bVar;
        if (this.tYM.tRQ) {
            this.tYH.setVisibility(0);
            this.tYG.setVisibility(8);
            this.tYh.setPadding(0, 0, 0, 0);
            if (bVar.tRA) {
                this.tYI.setBackgroundResource(R.g.bHX);
            } else {
                this.tYI.setBackgroundResource(R.g.bHW);
            }
            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.tYI;
            String str = this.tYM.fCa;
            int i3 = this.tYM.fvx;
            CharSequence charSequence = this.tYM.tSf;
            noteEditorVoiceBaseView.path = bh.az(str, "");
            noteEditorVoiceBaseView.fvx = i3;
            noteEditorVoiceBaseView.setText(charSequence);
        } else {
            this.tYh.setPadding(26, 7, 0, 7);
            this.tYH.setVisibility(8);
            this.tYG.setVisibility(0);
            ImageView imageView = this.tYJ;
            if (imageView.getAnimation() != null) {
                imageView.startAnimation(imageView.getAnimation());
            } else {
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setRepeatCount(-1);
                alphaAnimation.setRepeatMode(2);
                imageView.startAnimation(alphaAnimation);
            }
            if (this.tYM.tRH.booleanValue()) {
                this.tRr.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
                this.tYK.setText(R.l.eha);
                this.tYL.setText(" " + com.tencent.mm.bi.b.v(ac.getContext(), this.tYM.tSe).toString());
            } else {
                this.tYK.setText(R.l.egZ);
                this.tYL.setText(" " + com.tencent.mm.bi.b.v(ac.getContext(), (int) com.tencent.mm.bi.b.bv((long) this.tYM.fvy)).toString());
            }
        }
        super.a(bVar, i, i2);
    }

    public final int bXO() {
        return 4;
    }
}
