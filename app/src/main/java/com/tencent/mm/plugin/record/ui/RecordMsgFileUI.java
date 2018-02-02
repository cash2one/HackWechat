package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.k.g;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI extends MMActivity implements c {
    private long fqm;
    private uq fve;
    private af hae;
    private TextView jCQ;
    private f kTe = null;
    private ProgressBar lAk;
    private TextView lgz;
    private String mediaId;
    private Button mvW;
    private Button mvX;
    private Button mvY;
    private MMImageView mvZ;
    private TextView mwa;
    private View mwb;
    private View mwc;
    private boolean mwg = false;
    private boolean mwk = false;
    private boolean mwl = false;
    private com.tencent.mm.plugin.record.b.f pGp;

    static /* synthetic */ void h(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.bnh());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.bnh());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.fve.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        d.a(recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return R.i.dia;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hae = new af();
        this.pGp = new com.tencent.mm.plugin.record.b.f();
        this.fqm = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c Ik = h.Ik(getIntent().getStringExtra("record_xml"));
        if (Ik == null) {
            x.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = Ik.hdX.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.mvG.equals(stringExtra)) {
                this.fve = uqVar;
            }
        }
        if (this.fve == null) {
            x.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            return;
        }
        this.mediaId = h.d(this.fve.mvG, this.fqm, true);
        this.mvW = (Button) findViewById(R.h.cDp);
        this.mvX = (Button) findViewById(R.h.cBI);
        this.mvY = (Button) findViewById(R.h.ccw);
        this.mvZ = (MMImageView) findViewById(R.h.coO);
        this.lgz = (TextView) findViewById(R.h.cyB);
        this.jCQ = (TextView) findViewById(R.h.cSe);
        this.mwc = findViewById(R.h.ccO);
        this.mwb = findViewById(R.h.ccK);
        this.lAk = (ProgressBar) findViewById(R.h.ccJ);
        this.mwa = (TextView) findViewById(R.h.ccL);
        if (4 == getType()) {
            setMMTitle(R.l.egS);
        } else if (15 == getType()) {
            setMMTitle(R.l.egA);
            findViewById(R.h.cUI).setBackgroundResource(R.e.black);
        } else {
            setMMTitle(R.l.efx);
        }
        if (getType() == 4) {
            this.mvZ.setImageResource(R.k.dvA);
        } else {
            this.mvZ.setImageResource(com.tencent.mm.pluginsdk.c.Rd(this.fve.wcY));
        }
        this.lgz.setText(this.fve.title);
        setBackBtn(new 1(this));
        this.mvX.setOnClickListener(new 7(this));
        String str = this.fve.wcQ;
        if (!bh.ov(str)) {
            this.mvW.setOnClickListener(new 8(this, str));
        }
        this.mvY.setOnClickListener(new 9(this));
        this.mwc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordMsgFileUI pGq;

            {
                this.pGq = r1;
            }

            public final void onClick(View view) {
                this.pGq.aJG();
            }
        });
        if (getType() != 15 || bh.VI(g.zY().getValue("SightForwardEnable")) == 1) {
            addIconOptionMenu(0, R.g.bDI, new 11(this));
        } else {
            x.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        if (bh.ov(this.fve.wcJ) || bh.ov(this.fve.wcL)) {
            aJE();
        } else if (h.d(this.fve, this.fqm)) {
            enableOptionMenu(true);
            bng();
        } else {
            com.tencent.mm.plugin.record.a.f Ij = n.getRecordMsgCDNStorage().Ij(this.mediaId);
            if (Ij == null || 2 == Ij.field_status) {
                aJG();
            } else if (4 == Ij.field_status) {
                aJE();
            } else if (Ij.field_status == 0 || 1 == Ij.field_status) {
                aJF();
            } else {
                x.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                aJG();
            }
            enableOptionMenu(false);
        }
        n.getRecordMsgCDNStorage().a(this);
    }

    private int getType() {
        int i = this.fve.bjS;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void aJE() {
        this.mvY.setVisibility(8);
        this.mvW.setVisibility(8);
        this.mvX.setVisibility(8);
        this.mwb.setVisibility(8);
        this.jCQ.setVisibility(0);
        if (this.fve.bjS == 4) {
            this.jCQ.setGravity(17);
            this.jCQ.setText(R.l.efY);
            return;
        }
        this.jCQ.setGravity(17);
        this.jCQ.setText(R.l.efX);
    }

    private void aJF() {
        this.mvY.setVisibility(8);
        this.mvW.setVisibility(8);
        this.mvX.setVisibility(8);
        this.jCQ.setVisibility(8);
        this.mwb.setVisibility(0);
        b(n.getRecordMsgCDNStorage().Ij(this.mediaId));
    }

    private void aJG() {
        this.mwb.setVisibility(8);
        this.mvX.setVisibility(8);
        if (bh.ov(this.fve.wcQ)) {
            this.mvW.setVisibility(8);
        } else {
            this.mvW.setVisibility(0);
        }
        this.mvY.setVisibility(0);
        this.mvY.setText(R.l.efH);
        this.jCQ.setVisibility(8);
    }

    private void bng() {
        if (!(getType() != 15 || this.fve.wdJ == null || bh.ov(this.fve.wdJ.hdo) || bh.ov(this.fve.wdJ.hds))) {
            this.mwl = true;
            this.mvZ.setVisibility(8);
            this.mwb.setVisibility(8);
            this.mvY.setVisibility(8);
            this.mvW.setVisibility(8);
            this.mvX.setVisibility(8);
            this.jCQ.setVisibility(8);
            String c = h.c(this.fve, this.fqm);
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zg() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cUI);
            this.kTe = com.tencent.mm.pluginsdk.ui.tools.n.er(this.mController.xIM);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.kTe, 0, layoutParams);
            this.kTe.a(new 12(this));
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zg() + " initView :" + c);
            if (c != null) {
                this.kTe.stop();
                this.kTe.setVideoPath(c);
            }
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zg() + " initView");
            if (ar.ux() != null) {
                ar.ux().wB();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.mwb.setVisibility(8);
            this.mvY.setVisibility(4);
            if (bh.ov(this.fve.wcQ)) {
                this.mvW.setVisibility(8);
            } else {
                this.mvW.setVisibility(0);
            }
            this.mvX.setVisibility(0);
            this.jCQ.setVisibility(0);
        } else if (!this.mwl) {
            this.mwb.setVisibility(8);
            this.mvY.setVisibility(8);
            this.mvW.setVisibility(8);
            this.mvX.setVisibility(0);
            this.mvX.setText(R.l.efI);
            this.jCQ.setVisibility(8);
            aJH();
        }
    }

    protected void onDestroy() {
        if (this.kTe != null) {
            this.kTe.a(null);
            this.kTe.stop();
            this.kTe.onDetach();
            if (ar.ux() != null) {
                ar.ux().wA();
            }
        }
        super.onDestroy();
        n.getRecordMsgCDNStorage().b(this);
        this.pGp.destory();
    }

    protected void onResume() {
        super.onResume();
        if (this.kTe != null) {
            this.kTe.start();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kTe != null) {
            this.kTe.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a(this, i, i2, intent, true, R.l.dZc, R.l.dZd, 5);
        if (i2 == -1 && i == 1001) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null);
            x.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            final Runnable 13 = new 13(this, a);
            if (!bh.ov(stringExtra)) {
                final List F = bh.F(stringExtra.split(","));
                if (getType() == 4 || getType() == 15) {
                    ar.Dm().F(new 14(this, F, str, 13));
                } else {
                    ar.Dm().F(new Runnable(this) {
                        final /* synthetic */ RecordMsgFileUI pGq;

                        public final void run() {
                            String c = h.c(this.pGq.fve, this.pGq.fqm);
                            IMediaObject wXFileObject = new WXFileObject();
                            wXFileObject.setFilePath(c);
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXFileObject;
                            wXMediaMessage.title = this.pGq.fve.title;
                            wXMediaMessage.description = this.pGq.fve.desc;
                            wXMediaMessage.thumbData = bh.readFromFile(h.f(this.pGq.fve, this.pGq.fqm));
                            for (String str : F) {
                                l.a(wXMediaMessage, "", "", str, 3, null);
                                com.tencent.mm.plugin.messenger.a.f.aZh().dj(str, str);
                            }
                            ag.y(13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult2";
                        }
                    });
                }
            }
        }
    }

    private String bnh() {
        File file = new File(h.f(this.fve, this.fqm));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(com.tencent.mm.z.c.Fw()).append("web/").append(com.tencent.mm.a.g.s(bh.az(this.fve.fqf, "").getBytes())).toString();
    }

    private void b(com.tencent.mm.plugin.record.a.f fVar) {
        int max;
        int i;
        int i2 = 0;
        if (fVar != null) {
            max = (int) ((((float) fVar.field_offset) / ((float) Math.max(1, fVar.field_totalLen))) * 100.0f);
            i2 = fVar.field_offset;
            i = fVar.field_totalLen;
        } else {
            i = (int) this.fve.wde;
            max = 0;
        }
        this.hae.post(new Runnable(this) {
            final /* synthetic */ RecordMsgFileUI pGq;

            public final void run() {
                this.pGq.lAk.setProgress(max);
                this.pGq.mwa.setText(this.pGq.getString(R.l.eeV, new Object[]{bh.ah((float) i2), bh.ah((float) i)}));
            }
        });
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        if (fVar == null) {
            x.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            return;
        }
        x.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[]{this.mediaId, fVar.field_mediaId});
        if (this.mediaId.equals(fVar.field_mediaId)) {
            switch (fVar.field_status) {
                case 2:
                    this.hae.post(new 4(this));
                    return;
                case 3:
                    this.hae.post(new 6(this));
                    return;
                case 4:
                    this.hae.post(new 5(this));
                    return;
                default:
                    b(fVar);
                    return;
            }
        }
    }

    private void aJH() {
        if (!this.mwk) {
            this.mwk = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_fav_path", h.c(this.fve, this.fqm));
            intent.putExtra("key_detail_fav_thumb_path", h.f(this.fve, this.fqm));
            intent.putExtra("key_detail_fav_video_duration", this.fve.duration);
            intent.putExtra("key_detail_statExtStr", this.fve.fGG);
            intent.putExtra("key_detail_fav_video_scene_from", 1);
            d.b(this, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }
}
