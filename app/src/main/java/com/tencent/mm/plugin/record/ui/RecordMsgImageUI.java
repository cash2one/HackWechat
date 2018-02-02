package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class RecordMsgImageUI extends MMActivity implements c {
    private long fqm = -1;
    private l juS;
    private List<uq> kFz = new LinkedList();
    private MMGestureGallery kRW;
    private p$d lET = new 9(this);
    private Runnable mrT = new 2(this);
    private Map<String, mr> msp = new HashMap();
    private com.tencent.mm.sdk.b.c msq = new 3(this);
    private f pGp;
    private a pGw;
    private int pGx = 0;
    private String pGy = null;

    static /* synthetic */ void a(RecordMsgImageUI recordMsgImageUI, bz bzVar) {
        int selectedItemPosition = recordMsgImageUI.kRW.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            x.w("MicroMsg.ShowImageUI", "error position");
            return;
        }
        uq vt = recordMsgImageUI.pGw.vt(selectedItemPosition);
        if (vt != null) {
            bzVar.fqa.imagePath = vt.wcJ;
            bzVar.fqa.fqg = vt.wcL;
        }
    }

    static /* synthetic */ void d(RecordMsgImageUI recordMsgImageUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(R.l.eEG));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(R.l.eAd));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(R.l.eHg));
        String bni = recordMsgImageUI.bni();
        mr mrVar = (mr) recordMsgImageUI.msp.get(bni);
        if (mrVar == null) {
            b mpVar = new mp();
            mpVar.fEA.filePath = bni;
            com.tencent.mm.sdk.b.a.xef.m(mpVar);
        } else if (!bh.ov(mrVar.fED.result)) {
            arrayList.add(Integer.valueOf(3));
            arrayList2.add(recordMsgImageUI.getString(com.tencent.mm.plugin.scanner.a.az(mrVar.fED.fqb, mrVar.fED.result) ? R.l.eCr : R.l.eCq));
        }
        if (!recordMsgImageUI.isFinishing()) {
            if (recordMsgImageUI.juS == null) {
                recordMsgImageUI.juS = new l(recordMsgImageUI.mController.xIM);
            }
            recordMsgImageUI.juS.rKC = new 7(recordMsgImageUI, arrayList, arrayList2);
            recordMsgImageUI.juS.rKD = recordMsgImageUI.lET;
            recordMsgImageUI.juS.e(new OnCancelListener(recordMsgImageUI) {
                final /* synthetic */ RecordMsgImageUI pGz;

                {
                    this.pGz = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.pGz.juS = null;
                }
            });
            h.a(recordMsgImageUI.mController.xIM, recordMsgImageUI.juS.bBX());
        }
    }

    static /* synthetic */ void f(RecordMsgImageUI recordMsgImageUI) {
        recordMsgImageUI.pGy = recordMsgImageUI.bni();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.pGy);
        d.a(recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return R.i.dsE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.pGp = new f();
        this.fqm = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c Ik = com.tencent.mm.plugin.record.b.h.Ik(getIntent().getStringExtra("record_xml"));
        if (Ik == null) {
            x.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = Ik.hdX.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.bjS == 2) {
                this.kFz.add(uqVar);
                if (uqVar.mvG.equals(stringExtra)) {
                    this.pGx = this.kFz.size() - 1;
                }
            }
        }
        if (this.kFz.isEmpty()) {
            x.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            return;
        }
        this.kRW = (MMGestureGallery) findViewById(R.h.ckt);
        this.kRW.setVerticalFadingEdgeEnabled(false);
        this.kRW.setHorizontalFadingEdgeEnabled(false);
        this.pGw = new a((byte) 0);
        this.pGw.kFz = this.kFz;
        this.pGw.fqm = this.fqm;
        this.pGw.pGp = this.pGp;
        this.kRW.setAdapter(this.pGw);
        this.kRW.setSelection(this.pGx);
        this.kRW.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ RecordMsgImageUI pGz;

            {
                this.pGz = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (com.tencent.mm.plugin.record.b.h.d(this.pGz.pGw.vt(i), this.pGz.fqm)) {
                    this.pGz.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(this.pGz.kFz.size())}));
                    this.pGz.enableOptionMenu(true);
                    return;
                }
                this.pGz.enableOptionMenu(false);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.kRW.zlf = new 4(this);
        this.kRW.zlg = new 5(this);
        fullScreenNoTitleBar(true);
        setBackBtn(new 6(this));
        n.getRecordMsgCDNStorage().a(this);
        com.tencent.mm.sdk.b.a.xef.b(this.msq);
    }

    protected void onDestroy() {
        n.getRecordMsgCDNStorage().b(this);
        this.pGp.destory();
        com.tencent.mm.sdk.b.a.xef.c(this.msq);
        super.onDestroy();
    }

    final String bni() {
        int selectedItemPosition = this.kRW.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            x.w("MicroMsg.ShowImageUI", "error position");
            return null;
        }
        x.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[]{Integer.valueOf(selectedItemPosition), com.tencent.mm.plugin.record.b.h.c(this.pGw.vt(selectedItemPosition), this.fqm)});
        return com.tencent.mm.plugin.record.b.h.c(this.pGw.vt(selectedItemPosition), this.fqm);
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xIy);
        ((ViewGroup) this.mController.xIy.getParent()).removeView(this.mController.xIy);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xIy, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1001 == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (!bh.ov(stringExtra)) {
                List F = bh.F(stringExtra.split(","));
                if (bh.cA(F)) {
                    x.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                    return;
                }
                final Dialog a = h.a(this.mController.xIM, getString(R.l.efz), false, null);
                ar.Dm().F(new 11(this, F, stringExtra2, new Runnable(this) {
                    final /* synthetic */ RecordMsgImageUI pGz;

                    public final void run() {
                        a.dismiss();
                    }
                }));
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        for (uq uqVar : this.kFz) {
            if (uqVar.mvG.equals(fVar.field_dataId)) {
                ag.y(this.mrT);
                return;
            }
        }
    }
}
