package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.1;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.2;
import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.6;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;

@a(3)
public class VoiceInputUI extends MMActivity {
    private String fKe;
    private String fpb;
    private Button lEE;
    private int offset;
    private int textChangeCount = 0;
    private MMEditText vmn;
    private VoiceInputFooter vmo;
    private String vmp;
    private long vmq = 0;
    private boolean vmr = true;
    private boolean vms = false;
    private OnTouchListener vmt = new 2(this);
    private OnMenuItemClickListener vmu = new 3(this);
    private VoiceInputFooter.a vmv = new 4(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        Intent intent = getIntent();
        if (intent != null) {
            this.fpb = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.vmp = intent.getStringExtra("punctuation");
            this.fKe = intent.getStringExtra("userCode");
        }
        this.vmq = bh.Wq();
        this.textChangeCount = 0;
        this.vms = false;
        this.vmr = true;
        this.vmn = (MMEditText) findViewById(R.h.cWn);
        this.lEE = (Button) findViewById(R.h.cWm);
        this.vmn.addTextChangedListener(new 5(this));
        this.lEE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceInputUI vmw;

            {
                this.vmw = r1;
            }

            public final void onClick(View view) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 3;
                VoiceInputUI.a(voiceInputBehavior);
                this.vmw.BU(7);
            }
        });
        setMMTitle(getString(R.l.eTx));
        enableOptionMenu(true);
        setBackBtn(new 1(this));
        this.vmn.setOnTouchListener(this.vmt);
        this.vmn.aak(this.fpb);
        if (this.offset != -1) {
            this.vmn.setSelection(this.offset);
        }
        this.vmo = (VoiceInputFooter) findViewById(R.h.cIF);
        VoiceInputFooter voiceInputFooter = this.vmo;
        MMEditText mMEditText = this.vmn;
        String str = this.vmp;
        voiceInputFooter.rGA = mMEditText;
        mMEditText.setOnClickListener(new 1(voiceInputFooter));
        mMEditText.setOnEditorActionListener(new 2(voiceInputFooter));
        if (voiceInputFooter.vlG == null) {
            voiceInputFooter.vlG = new n(voiceInputFooter.getContext(), true, voiceInputFooter.rGA);
            voiceInputFooter.vlG.vrT = new 6(voiceInputFooter);
            voiceInputFooter.vlG.Cq(j.aQ(voiceInputFooter.getContext()));
        }
        voiceInputFooter.vlG.ccc();
        voiceInputFooter.vlG.cbi();
        voiceInputFooter.vlG.setVisibility(8);
        n nVar = voiceInputFooter.vlG;
        if (str != null) {
            nVar.vsp = str;
        }
        nVar.cce();
        voiceInputFooter.oDy.addView(voiceInputFooter.vlG, -1, 0);
        this.vmo.vlN = this.vmv;
    }

    protected void onResume() {
        super.onResume();
        this.vmn.requestFocus();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.vmo != null) {
            VoiceInputFooter voiceInputFooter = this.vmo;
            if (voiceInputFooter.okx != null) {
                voiceInputFooter.okx.ti();
                voiceInputFooter.okx.destroy();
            }
            if (voiceInputFooter.vlG != null) {
                voiceInputFooter.vlG.destroy();
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dtA;
    }

    public void onSwipeBack() {
        BU(3);
        super.onSwipeBack();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            BU(2);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void BU(int i) {
        x.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[]{Integer.valueOf(i), bh.cgy().toString()});
        if (i == 8) {
            pY(7);
        } else {
            pY(i);
        }
        b sjVar = new sj();
        if (i == 7) {
            sjVar.fKc.action = 1;
        } else if (i == 8) {
            sjVar.fKc.action = 4;
        } else {
            sjVar.fKc.action = 2;
        }
        if (this.vms) {
            sjVar.fKc.fKd = 1;
        } else {
            sjVar.fKc.fKd = 2;
        }
        sjVar.fKc.result = this.vmn.getText().toString();
        sjVar.fKc.fKe = this.fKe;
        com.tencent.mm.sdk.b.a.xef.m(sjVar);
        bh.hideVKB(this.vmn);
        super.finish();
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        x.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
        com.tencent.mm.bq.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.pQN.c(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }

    private void pY(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.vmq != 0) {
            voiceInputBehavior.textChangeTime = bh.bA(this.vmq);
            this.vmq = 0;
        }
        a(voiceInputBehavior);
    }
}
