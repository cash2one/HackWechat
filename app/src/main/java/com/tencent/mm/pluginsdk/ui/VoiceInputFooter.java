package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter extends BasePanelKeybordLayout {
    private MMActivity fmM;
    LinearLayout oDy;
    ChatFooterPanel okx;
    MMEditText rGA = null;
    n vlG;
    ImageButton vlH;
    private ImageButton vlI;
    private boolean vlJ = false;
    private boolean vlK = false;
    private final int vlL = 1;
    private final int vlM = 2;
    a vlN;

    static /* synthetic */ void c(VoiceInputFooter voiceInputFooter) {
        voiceInputFooter.rGA.requestFocus();
        if (voiceInputFooter.vlJ) {
            voiceInputFooter.caw();
            voiceInputFooter.fmM.showVKB();
        } else {
            voiceInputFooter.vlJ = true;
            voiceInputFooter.fmM.aWs();
            if (voiceInputFooter.bCe()) {
                voiceInputFooter.hideSmileyPanel();
            }
            if (voiceInputFooter.vlG != null) {
                voiceInputFooter.vlG.setVisibility(0);
            }
            voiceInputFooter.vlI.setImageResource(R.g.bBo);
            int ab = a.ab(voiceInputFooter.fmM, R.f.byh);
            voiceInputFooter.vlI.setPadding(ab, 0, ab, 0);
            voiceInputFooter.vlH.setImageResource(R.g.bBn);
            voiceInputFooter.vlH.setVisibility(8);
            if (voiceInputFooter.vlN != null) {
                voiceInputFooter.vlN.kV(true);
            }
        }
        pY(2);
    }

    static /* synthetic */ void d(VoiceInputFooter voiceInputFooter) {
        if (voiceInputFooter.cav()) {
            voiceInputFooter.caw();
        }
        if (voiceInputFooter.vlK) {
            voiceInputFooter.rGA.requestFocus();
            voiceInputFooter.hideSmileyPanel();
            voiceInputFooter.fmM.showVKB();
            voiceInputFooter.vlH.setImageResource(R.g.bBn);
        } else {
            voiceInputFooter.fmM.aWs();
            voiceInputFooter.vlK = true;
            voiceInputFooter.okx.onResume();
            voiceInputFooter.okx.setVisibility(0);
            voiceInputFooter.rGA.requestFocus();
            voiceInputFooter.vlH.setImageResource(R.g.bBo);
            voiceInputFooter.vlI.setImageResource(R.g.bHn);
        }
        pY(1);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) v.fv(this.fmM).inflate(R.i.dtB, this);
        this.vlI = (ImageButton) viewGroup.findViewById(R.h.bJW);
        this.vlI.setOnClickListener(new 3(this));
        this.vlH = (ImageButton) viewGroup.findViewById(R.h.bJQ);
        this.vlH.setOnClickListener(new 4(this));
        if (e.vro == null) {
            this.okx = new d(this.fmM);
            return;
        }
        this.okx = e.vro.cv(getContext());
        this.okx.ej(ChatFooterPanel.SCENE_SNS);
        this.okx.setVisibility(8);
        this.oDy = (LinearLayout) findViewById(R.h.cIu);
        this.oDy.setOnClickListener(null);
        this.oDy.addView(this.okx, -1, 0);
        this.okx.tj();
        this.okx.aF(false);
        this.okx.vjB = new 5(this);
    }

    public final boolean bCe() {
        return this.okx.getVisibility() == 0;
    }

    public final boolean cav() {
        return this.vlG.getVisibility() == 0;
    }

    final void caw() {
        this.vlJ = false;
        if (this.vlG != null) {
            this.vlG.pause();
            this.vlG.setVisibility(8);
            this.vlI.setImageResource(R.g.bHn);
            this.vlI.setPadding(0, 0, a.ab(this.fmM, R.f.byh), 0);
            this.vlH.setVisibility(0);
            if (this.vlN != null) {
                this.vlN.kV(false);
            }
        }
    }

    final void hideSmileyPanel() {
        this.vlK = false;
        this.okx.onPause();
        this.okx.setVisibility(8);
    }

    protected final List<View> aXT() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.okx);
        arrayList.add(this.vlG);
        return arrayList;
    }

    private static void pY(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            return;
        }
        x.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.pQN.c(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }
}
