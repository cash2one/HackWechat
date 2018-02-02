package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.c.a;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.i;
import com.tencent.mm.z.s;

public class EnterpriseConversationUI$a extends BaseConversationUI$b implements e, b {
    private l contextMenuHelper;
    private TextView emptyTipTv;
    private int fromScene;
    private long gzo = 0;
    long hQr = 0;
    private String hog;
    private boolean isDeleteCancel = false;
    private String kGs = "";
    private long kiR = 0;
    private d onK;
    private r tipDialog;
    private ListView yWg;
    private String yWi;
    private m yZb;
    private h yZc;
    private String yZd = null;
    private af yZe;
    private int yZf = -2;
    private String yZg = null;
    private LinearLayout ynC = null;
    private int ynF = 0;
    private a ynI = new 10(this);

    static /* synthetic */ void ZH(String str) {
        ar.Hg();
        if (c.EY().WO(str) == null) {
            x.e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = " + str);
            return;
        }
        ar.Hg();
        if (c.Fd().Xf(str)) {
            s.s(str, true);
        } else {
            i.fZ(str);
        }
    }

    static /* synthetic */ void a(EnterpriseConversationUI$a enterpriseConversationUI$a, int i) {
        if (i <= 0) {
            enterpriseConversationUI$a.emptyTipTv.setVisibility(0);
            enterpriseConversationUI$a.yWg.setVisibility(8);
            return;
        }
        enterpriseConversationUI$a.emptyTipTv.setVisibility(8);
        enterpriseConversationUI$a.yWg.setVisibility(0);
    }

    static /* synthetic */ void a(EnterpriseConversationUI$a enterpriseConversationUI$a, com.tencent.mm.ag.d dVar, int i, int i2) {
        com.tencent.mm.ag.b jx = y.Mm().jx(enterpriseConversationUI$a.hog);
        long j = jx != null ? jx.field_wwCorpId : 0;
        long j2 = jx != null ? jx.field_wwUserVid : 0;
        int i3 = i2 > 0 ? 1 : 2;
        long Lj = dVar == null ? 0 : dVar.Lj();
        g.pQN.h(14507, new Object[]{Long.valueOf(j), Long.valueOf(Lj), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i)});
        x.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[]{Long.valueOf(j), Long.valueOf(Lj), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i)});
    }

    static /* synthetic */ void a(EnterpriseConversationUI$a enterpriseConversationUI$a, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.EnterpriseConversationUI", "Delete Conversation and messages fail because username is null or nil.");
            return;
        }
        ar.Hg();
        cf Ew = c.Fa().Ew(str);
        com.tencent.mm.bq.a qaVar = new qa();
        qaVar.vYI = new bdo().UA(bh.ou(str));
        qaVar.vHe = Ew.field_msgSvrId;
        ar.Hg();
        c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(8, qaVar));
        enterpriseConversationUI$a.isDeleteCancel = false;
        Context thisActivity = enterpriseConversationUI$a.thisActivity();
        enterpriseConversationUI$a.getString(R.l.dGO);
        final ProgressDialog a = h.a(thisActivity, enterpriseConversationUI$a.getString(R.l.dHc), true, new OnCancelListener(enterpriseConversationUI$a) {
            final /* synthetic */ EnterpriseConversationUI$a yZh;

            {
                this.yZh = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.yZh.isDeleteCancel = true;
            }
        });
        ba.a(str, new ba.a(enterpriseConversationUI$a) {
            final /* synthetic */ EnterpriseConversationUI$a yZh;

            public final boolean HB() {
                return this.yZh.isDeleteCancel;
            }

            public final void HA() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        ar.Hg();
        c.Fd().WX(str);
        com.tencent.mm.ag.d jK = y.Mf().jK(str);
        ar.Hg();
        c.Fc().Wt(jK.field_enterpriseFather);
    }

    static /* synthetic */ void b(EnterpriseConversationUI$a enterpriseConversationUI$a) {
        enterpriseConversationUI$a.ynF = com.tencent.mm.ui.g.bl(enterpriseConversationUI$a.getContext(), enterpriseConversationUI$a.hog);
        if (enterpriseConversationUI$a.ynF == 2 && enterpriseConversationUI$a.ynC == null) {
            enterpriseConversationUI$a.ynC = (LinearLayout) enterpriseConversationUI$a.findViewById(R.h.bottom_bar);
            LayoutParams layoutParams = enterpriseConversationUI$a.ynC.getLayoutParams();
            layoutParams.height = com.tencent.mm.bv.a.aa(enterpriseConversationUI$a.getContext(), R.f.buH);
            enterpriseConversationUI$a.ynC.setLayoutParams(layoutParams);
            View inflate = v.fv(enterpriseConversationUI$a.getContext()).inflate(R.i.dgw, enterpriseConversationUI$a.ynC, false);
            float eu = com.tencent.mm.bv.a.eu(enterpriseConversationUI$a.getContext());
            ImageView imageView = (ImageView) inflate.findViewById(R.h.coO);
            int i = imageView.getLayoutParams().height;
            imageView.getLayoutParams().height = (int) (((float) i) * eu);
            imageView.getLayoutParams().width = (int) (eu * ((float) i));
            imageView.requestLayout();
            TextView textView = (TextView) inflate.findViewById(R.h.cSu);
            com.tencent.mm.ag.b jx = y.Mm().jx(enterpriseConversationUI$a.hog);
            if (jx == null || jx.field_chatOpen || jx.field_use_preset_banner_tips) {
                textView.setText(R.l.ecg);
            } else {
                y.Mm();
                y.Mm();
                textView.setText(com.tencent.mm.ag.c.hn(0));
            }
            com.tencent.mm.ui.g.ab(enterpriseConversationUI$a.hog, 1, 2);
            enterpriseConversationUI$a.ynC.addView(inflate);
            inflate.setOnClickListener(new 13(enterpriseConversationUI$a));
            com.tencent.mm.ui.g.m(enterpriseConversationUI$a.getContext(), enterpriseConversationUI$a.hog, 3);
            com.tencent.mm.ui.g.bm(enterpriseConversationUI$a.getContext(), enterpriseConversationUI$a.hog);
        }
        if (enterpriseConversationUI$a.ynC == null) {
            return;
        }
        if (enterpriseConversationUI$a.ynF == 2) {
            enterpriseConversationUI$a.ynC.setVisibility(0);
            com.tencent.mm.ag.b jx2 = y.Mm().jx(enterpriseConversationUI$a.hog);
            int i2 = jx2 != null ? jx2.field_qyUin : 0;
            int i3 = jx2 != null ? jx2.field_userUin : 0;
            long j = jx2 != null ? jx2.field_wwCorpId : 0;
            long j2 = jx2 != null ? jx2.field_wwUserVid : 0;
            g.pQN.h(13656, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2)});
            x.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        enterpriseConversationUI$a.ynC.setVisibility(8);
    }

    static /* synthetic */ void b(EnterpriseConversationUI$a enterpriseConversationUI$a, String str) {
        Context context = enterpriseConversationUI$a.getContext();
        h.a(context, context.getString(R.l.ebM), "", context.getString(R.l.ebL), context.getString(R.l.dEn), new 6(enterpriseConversationUI$a, str, context), null);
    }

    static /* synthetic */ String p(EnterpriseConversationUI$a enterpriseConversationUI$a) {
        if (enterpriseConversationUI$a.yZd == null) {
            y.Mf();
            String jO = com.tencent.mm.ag.e.jO(enterpriseConversationUI$a.hog);
            if (bh.ov(jO)) {
                jO = "";
            }
            enterpriseConversationUI$a.yZd = jO;
        }
        return bh.ov(enterpriseConversationUI$a.yZd) ? null : enterpriseConversationUI$a.yZd;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hog = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
        this.yWi = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
        this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
        setMMTitle(this.yWi);
        this.yWg = (ListView) findViewById(R.h.cSv);
        this.emptyTipTv = (TextView) findViewById(R.h.cem);
        this.emptyTipTv.setText(R.l.ebQ);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ EnterpriseConversationUI$a yZh;

            {
                this.yZh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.yZh.finish();
                return true;
            }
        });
        setToTop(new 11(this));
        if (f.jS(this.hog) != null) {
            if (this.hog != null) {
                e 12 = new 12(this);
                y.Mm();
                com.tencent.mm.ag.c.a(this.hog, 12);
                x.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[]{this.hog});
            } else {
                x.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
            }
            addIconOptionMenu(1, R.l.eRj, R.k.dva, new 14(this));
            addIconOptionMenu(2, R.l.dCm, R.k.duO, new 15(this));
            this.yZc = new h(thisActivity(), this.hog, new 16(this));
            this.yZc.a(new 17(this));
            this.yZc.a(new 18(this));
            this.yZc.a(new MMSlideDelView.e(this) {
                final /* synthetic */ EnterpriseConversationUI$a yZh;

                {
                    this.yZh = r1;
                }

                public final void bo(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                        return;
                    }
                    EnterpriseConversationUI$a.a(this.yZh, obj.toString());
                }
            });
            this.yWg.setAdapter(this.yZc);
            this.yWg.setOnItemClickListener(new 3(this));
            this.contextMenuHelper = new l(thisActivity());
            this.onK = new 4(this);
            this.yWg.setOnItemLongClickListener(new 5(this));
        }
        this.gzo = System.currentTimeMillis() / 1000;
        ar.Hg();
        aj WY = c.Fd().WY(this.hog);
        if (WY != null) {
            this.yZf = WY.field_unReadCount;
            if (this.yZf == 0 && WY.field_unReadMuteCount > 0) {
                this.yZf = -1;
            }
            this.kiR = WY.field_conversationTime / 1000;
            this.yZg = WY.field_isSend == 1 ? null : WY.field_digestUser;
        }
        y.Mm().a(this.ynI, thisActivity().getMainLooper());
        ar.Hg();
        c.Fd().a(this);
        ar.Hg();
        c.EY().a(this);
        if (this.yZc != null) {
            if (this.yZe == null) {
                this.yZe = new 9(this);
            } else {
                this.yZe.removeMessages(1);
            }
            this.yZe.sendEmptyMessageDelayed(1, 500);
        }
    }

    protected final int getLayoutId() {
        return R.i.dgv;
    }

    public final String getUserName() {
        return this.hog;
    }

    public final void onDestroy() {
        y.Mm().a(this.ynI);
        if (ar.Hj()) {
            ar.Hg();
            c.Fd().b(this);
            ar.Hg();
            c.EY().b(this);
        }
        if (this.yZc != null) {
            b bVar = this.yZc;
            bVar.yWW.TG();
            if (bVar.yns != null) {
                bVar.yns.clear();
                bVar.yns = null;
            }
            bVar.aUn();
            bVar.xIi = null;
            ar.Hg();
            c.Fd().b(bVar);
        }
        ar.CG().b(1394, this);
        if (this.gzo > 0 && this.hQr > 0) {
            long j = this.hQr - this.gzo;
            com.tencent.mm.ag.b jx = y.Mm().jx(this.hog);
            int i = jx != null ? jx.field_qyUin : 0;
            int i2 = jx != null ? jx.field_userUin : 0;
            g.pQN.h(13465, new Object[]{"", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j)});
            x.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j)});
        }
        super.onDestroy();
    }

    public final void onResume() {
        x.v("MicroMsg.EnterpriseConversationUI", "on resume");
        if (this.yZc != null) {
            this.yZc.onResume();
        }
        super.onResume();
        if (!s.gE(this.hog)) {
            finish();
        }
    }

    public final void onPause() {
        x.v("MicroMsg.EnterpriseConversationUI", "on pause");
        ar.Hg();
        c.Fd().Xa(this.hog);
        if (this.yZc != null) {
            this.yZc.onPause();
        }
        super.onPause();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.f.aZh().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.h(thisActivity(), getContext().getString(R.l.eic));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
            bmp bjq = ((com.tencent.mm.plugin.profile.a.c) kVar).bjq();
            bmq bjp = ((com.tencent.mm.plugin.profile.a.c) kVar).bjp();
            if (bjp == null || bjp.vNw == null || bjp.vNw.ret != 0) {
                if (bjp == null || bjp.vNw == null) {
                    x.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                    return;
                }
                x.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(bjp.vNw.ret)});
            } else if (bjq.wPS) {
                com.tencent.mm.sdk.e.c jS = f.jS(bjq.vNq);
                jS.field_brandFlag |= 1;
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_ari = new ari();
                com_tencent_mm_protocal_c_ari.hvH = jS.field_brandFlag;
                com_tencent_mm_protocal_c_ari.ksU = bjq.vNq;
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_ari));
                y.Mf().c(jS, new String[0]);
                ar.Hg();
                c.Fd().WX(jS.field_username);
                ar.Hg();
                if (c.Fd().Xi(jS.field_enterpriseFather) <= 0) {
                    ar.Hg();
                    c.Fd().WX(jS.field_enterpriseFather);
                    return;
                }
                ar.Hg();
                c.Fc().Wt(jS.field_enterpriseFather);
            }
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ar.Hg();
        com.tencent.mm.g.b.af WO = c.EY().WO(this.kGs);
        if (WO == null) {
            x.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.kGs);
            return;
        }
        CharSequence AQ = WO.AQ();
        if (AQ.toLowerCase().endsWith("@chatroom") && bh.ov(WO.field_nickname)) {
            AQ = getString(R.l.dSN);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(thisActivity(), AQ));
        if (WO.AL()) {
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.eum);
        } else {
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.eca);
        }
        contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.l.ebU);
        contextMenu.add(adapterContextMenuInfo.position, 1, 2, R.l.eup);
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
    }
}
