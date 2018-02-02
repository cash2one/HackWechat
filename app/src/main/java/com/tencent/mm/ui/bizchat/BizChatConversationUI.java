package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.i;
import com.tencent.mm.z.s;
import java.util.Iterator;
import java.util.LinkedList;

public class BizChatConversationUI extends BaseConversationUI {
    private View contentView;

    public static class a extends b implements n, m.b {
        private TextView emptyTipTv;
        private String hpf;
        private boolean isCurrentActivity;
        private boolean isDeleteCancel = false;
        private ListView kBO;
        private p$d kBR;
        private long kGB;
        private String kGH;
        private com.tencent.mm.ui.tools.m kGe;
        private int kGp = 0;
        private int kGq = 0;
        private r tipDialog;
        private LinearLayout ynC;
        private b ynD;
        private j ynE;
        private int ynF = 0;
        private com.tencent.mm.ag.a.b.a ynG = new 11(this);
        private com.tencent.mm.ag.a.d.a ynH = new 13(this);
        private com.tencent.mm.ag.c.a ynI = new 14(this);

        static /* synthetic */ void a(a aVar, long j) {
            x.i("MicroMsg.BizChatConversationFmUI", "deleteChatroom");
            y.Mh().ag(j);
            aVar.isDeleteCancel = false;
            Context thisActivity = aVar.thisActivity();
            aVar.getString(R.l.dGO);
            aVar.tipDialog = h.a(thisActivity, aVar.getString(R.l.dHc), true, new 7(aVar));
            i.a(aVar.kGH, j, new 8(aVar, j));
        }

        static /* synthetic */ void a(a aVar, LinkedList linkedList) {
            if (linkedList.size() == 0) {
                x.i("MicroMsg.BizChatConversationFmUI", "userIdList is empty");
                return;
            }
            SharedPreferences sharedPreferences = aVar.getSharedPreferences(ac.cfs(), 0);
            if (sharedPreferences.getBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + aVar.kGH, true)) {
                x.i("MicroMsg.BizChatConversationFmUI", "updateData");
                long currentTimeMillis = System.currentTimeMillis();
                e eVar = y.Mj().gJP;
                long j = 0;
                if (eVar instanceof com.tencent.mm.by.h) {
                    j = ((com.tencent.mm.by.h) eVar).dz(Thread.currentThread().getId());
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    c kl = y.Mh().kl(str);
                    if (!(kl == null || kl.Mt())) {
                        j ca = y.Mj().ca(str);
                        str = ca != null ? ca.field_userName : null;
                        if (!(str == null || str.equals(kl.field_chatName))) {
                            kl.field_chatName = str;
                            y.Mh().b(kl);
                        }
                    }
                }
                if (eVar instanceof com.tencent.mm.by.h) {
                    ar.Hg();
                    com.tencent.mm.z.c.EV().fS(j);
                }
                sharedPreferences.edit().putBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + aVar.kGH, false).commit();
                x.d("MicroMsg.BizChatConversationFmUI", "updateData use time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }

        static /* synthetic */ void l(a aVar) {
            aVar.ynE = y.Mj().ca(y.Mj().cb(aVar.kGH));
            if (aVar.ynE == null || bh.ov(aVar.ynE.field_addMemberUrl)) {
                Toast.makeText(aVar.thisActivity(), aVar.getString(R.l.dMp), 0).show();
                aVar.cqH();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aVar.ynE.field_addMemberUrl);
            x.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", new Object[]{aVar.ynE.field_addMemberUrl});
            intent.putExtra("useJs", true);
            intent.addFlags(67108864);
            d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.kGH = thisActivity().getIntent().getStringExtra("Contact_User");
            x.i("MicroMsg.BizChatConversationFmUI", "[regitListener]");
            y.Mi().a(this.ynG, thisActivity().getMainLooper());
            y.Mh().a(this.ynH, thisActivity().getMainLooper());
            y.Mm().a(this.ynI, thisActivity().getMainLooper());
            ar.Hg();
            com.tencent.mm.z.c.Fd().a(this);
            this.emptyTipTv = (TextView) findViewById(R.h.cem);
            this.emptyTipTv.setText(R.l.eus);
            this.kBO = (ListView) findViewById(R.h.cSv);
            cqG();
            this.ynD = new b(thisActivity(), new 19(this), this.kGH);
            this.ynD.a(new 20(this));
            this.ynD.a(new 21(this));
            this.ynD.a(new MMSlideDelView.e(this) {
                final /* synthetic */ a ynJ;

                {
                    this.ynJ = r1;
                }

                public final void bo(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                    }
                }
            });
            this.kBO.setAdapter(this.ynD);
            this.kBR = new 15(this);
            com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(thisActivity());
            this.kBO.setOnTouchListener(new 16(this));
            this.kBO.setOnItemLongClickListener(new 17(this, iVar));
            this.kBO.setOnItemClickListener(new 18(this));
            setBackBtn(new 3(this));
            addIconOptionMenu(1, R.l.eRj, R.k.dva, new 4(this));
            addIconOptionMenu(2, R.l.dCm, R.k.duO, new 5(this));
            cqH();
            ar.Dm().g(new 10(this), 300);
            String cqI = cqI();
            if (cqI != null) {
                y.Mm();
                com.tencent.mm.ag.c.a(cqI, null);
                x.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[]{cqI});
            } else {
                x.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            Looper.myQueue().addIdleHandler(new 1(this));
            Intent intent = thisActivity().getIntent();
            if (t.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    fV(longExtra);
                }
            }
        }

        protected final int getLayoutId() {
            return R.i.dgv;
        }

        public final String getUserName() {
            if (bh.ov(this.hpf)) {
                return this.kGH;
            }
            return this.hpf;
        }

        public final void onDestroy() {
            x.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            y.Mi().a(this.ynG);
            y.Mh().a(this.ynH);
            y.Mm().a(this.ynI);
            if (ar.Hj()) {
                ar.Hg();
                com.tencent.mm.z.c.Fd().b(this);
            }
            this.ynD.aUn();
            b bVar = this.ynD;
            if (bVar.yns != null) {
                bVar.yns.clear();
                bVar.yns = null;
            }
            super.onDestroy();
        }

        public final void onResume() {
            super.onResume();
            ar.Hg();
            af WO = com.tencent.mm.z.c.EY().WO(this.kGH);
            if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                finish();
                return;
            }
            com.tencent.mm.ag.d jS = f.jS(this.kGH);
            if (jS == null || jS.field_enterpriseFather == null || !s.gE(jS.field_enterpriseFather)) {
                finish();
                return;
            }
            if (WO.AI()) {
                setTitleMuteIconVisibility(0);
            } else {
                setTitleMuteIconVisibility(8);
            }
            this.isCurrentActivity = true;
            this.ynD.a(null, null);
            ar.getNotification().eo(this.kGH);
        }

        public final void onPause() {
            x.i("MicroMsg.BizChatConversationFmUI", "on pause");
            ar.Hg();
            com.tencent.mm.z.c.Fd().Xa(this.kGH);
            com.tencent.mm.ag.a.b Mi = y.Mi();
            String str = this.kGH;
            if (bh.ov(str)) {
                x.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean fx = Mi.gJP.fx("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                x.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[]{Boolean.valueOf(fx), str});
            }
            if (this.ynD != null) {
                this.ynD.onPause();
            }
            this.isCurrentActivity = false;
            ar.getNotification().eo("");
            super.onPause();
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.ag.a.a aVar = (com.tencent.mm.ag.a.a) this.ynD.getItem(adapterContextMenuInfo.position);
            this.kGB = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.eul);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.euj);
            }
            y.Mi();
            if (com.tencent.mm.ag.a.b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.eum);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.euk);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, R.l.eup);
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                switch (i) {
                    case 1:
                        boolean z;
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null) {
                            String str;
                            x.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                            String string = bundleExtra.getString("enterprise_members");
                            wj wjVar = new wj();
                            c cVar = new c();
                            if (this.ynE != null) {
                                str = this.ynE.field_addMemberUrl;
                            } else {
                                str = null;
                            }
                            cVar.field_addMemberUrl = str;
                            cVar.field_brandUserName = this.kGH;
                            if (!com.tencent.mm.ag.a.e.a(cVar, string, null, wjVar)) {
                                z = false;
                            } else if (cVar.field_bizChatLocalId != -1) {
                                fV(cVar.field_bizChatLocalId);
                                z = true;
                            } else {
                                y.Ml();
                                final com.tencent.mm.ag.a.n a = com.tencent.mm.ag.a.h.a(this.kGH, wjVar, this);
                                Context thisActivity = thisActivity();
                                getString(R.l.dGO);
                                this.tipDialog = h.a(thisActivity, getString(R.l.dHc), true, new OnCancelListener(this) {
                                    final /* synthetic */ a ynJ;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        y.Ml();
                                        com.tencent.mm.ag.a.h.f(a);
                                    }
                                });
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            Toast.makeText(thisActivity(), getString(R.l.eEX), 0).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final void a(int i, k kVar) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (kVar.getType() == 1355) {
                c kl = y.Mh().kl(((com.tencent.mm.ag.a.n) kVar).Mz().vYt.wgJ.vNk);
                if (kl == null) {
                    Toast.makeText(ac.getContext(), getString(R.l.eEX), 0).show();
                } else {
                    fV(kl.field_bizChatLocalId);
                }
            }
        }

        private void cqG() {
            String cqI = cqI();
            this.ynF = g.bl(getContext(), cqI);
            if (this.ynF == 2 && this.ynC == null) {
                this.ynC = (LinearLayout) findViewById(R.h.bottom_bar);
                LayoutParams layoutParams = this.ynC.getLayoutParams();
                layoutParams.height = com.tencent.mm.bv.a.aa(getContext(), R.f.buH);
                this.ynC.setLayoutParams(layoutParams);
                View inflate = v.fv(getContext()).inflate(R.i.dgw, this.ynC, false);
                float eu = com.tencent.mm.bv.a.eu(getContext());
                ImageView imageView = (ImageView) inflate.findViewById(R.h.coO);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * eu);
                imageView.getLayoutParams().width = (int) (eu * ((float) i));
                imageView.requestLayout();
                ((TextView) inflate.findViewById(R.h.cSu)).setText(R.l.ecc);
                this.ynC.addView(inflate);
                inflate.setOnClickListener(new 12(this));
                g.m(getContext(), this.kGH, 4);
                g.bm(getContext(), cqI);
            }
            if (this.ynC == null) {
                return;
            }
            if (this.ynF == 2) {
                this.ynC.setVisibility(0);
            } else {
                this.ynC.setVisibility(8);
            }
        }

        private void cqH() {
            boolean z = false;
            String cb = y.Mj().cb(this.kGH);
            this.ynE = y.Mj().ca(cb);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.kGH;
            objArr[1] = cb;
            if (this.ynE == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (bh.ov(cb) || this.ynE == null || this.ynE.Mu() || bh.ov(this.ynE.field_addMemberUrl)) {
                y.Ml();
                com.tencent.mm.ag.a.h.a(this.kGH, this);
                Context thisActivity = thisActivity();
                getString(R.l.dGO);
                this.tipDialog = h.a(thisActivity, getString(R.l.dHc), true, new 9(this));
            }
        }

        private String cqI() {
            if (bh.ov(this.hpf)) {
                this.hpf = y.Mf().jK(this.kGH).Lm();
            }
            return this.hpf;
        }

        private void fV(long j) {
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.ui.startChatting(this.kGH, bundle, true);
        }

        public final void a(int i, m mVar, Object obj) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = v.fv(this).inflate(R.i.dbr, null);
        setContentView(this.contentView);
        this.conversationFm = new a();
        getSupportFragmentManager().aS().a(R.h.cws, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }
}
