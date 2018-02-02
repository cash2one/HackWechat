package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class ab extends q {
    private static final int[] xMf = new int[]{2, 1, 4, 10, 3, Integer.MAX_VALUE};
    private LayoutInflater DF;
    private Context mContext;
    private SparseArray<c> xMb;
    private a xMd;
    aa xMe = null;

    public ab(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
        this.mContext = actionBarActivity;
        this.DF = LayoutInflater.from(actionBarActivity);
        nv(false);
        this.xMe = aa.cnB();
    }

    public final boolean dM() {
        int i = 0;
        this.xMe.lY(false);
        if (this.xMe.xMb.size() != 0) {
            this.xMb = this.xMe.xMb;
        } else {
            x.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.xMb != null) {
                this.xMb.clear();
            } else {
                this.xMb = new SparseArray();
            }
            for (int i2 = 0; i2 < xMf.length; i2++) {
                this.xMb.put(i2, new c(Eb(xMf[i2])));
            }
        }
        try {
            ar.Hg();
            if (((Boolean) c.CU().get(a.xpJ, Boolean.valueOf(false))).booleanValue()) {
                while (i < this.xMb.size() && ((c) this.xMb.get(i)).xMk.xMn != 2147483646) {
                    i++;
                }
                if (i == this.xMb.size()) {
                    this.xMb.put(this.xMb.size(), new c(Eb(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.xMd != null) {
            this.xMd.notifyDataSetChanged();
        }
        return super.dM();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        boolean z2 = false;
        if (this.mContext instanceof ActionBarActivity) {
            ((ActionBarActivity) this.mContext).supportInvalidateOptionsMenu();
        }
        int i2 = ((c) this.xMb.get(i)).xMk.xMn;
        g.pQN.h(11104, new Object[]{Integer.valueOf(i2)});
        if (com.tencent.mm.kernel.g.h(d.class) != null) {
            ((d) com.tencent.mm.kernel.g.h(d.class)).ami();
        }
        Intent intent;
        String str;
        int a;
        Intent intent2;
        bi HR;
        switch (i2) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                com.tencent.mm.bm.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(R.l.dDn));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.p(s.yTF, 256, WXMediaMessage.TITLE_LENGTH_LIMIT));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                this.mContext.startActivity(intent);
                break;
            case 4:
                b riVar = new ri();
                riVar.fJc.fJe = true;
                com.tencent.mm.sdk.b.a.xef.m(riVar);
                str = riVar.fJd.fJg;
                if (!bh.ov(str)) {
                    x.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + str);
                    h.a(this.mContext, this.mContext.getString(R.l.eQx), "", this.mContext.getString(R.l.dFU), this.mContext.getString(R.l.dEn), new 1(this), new OnClickListener(this) {
                        final /* synthetic */ ab xMg;

                        {
                            this.xMg = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                }
                VoipAddressUI.fR(this.mContext);
                break;
            case 5:
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    u.fI(this.mContext);
                    break;
                }
                ar.Hg();
                str = (String) c.CU().get(2, null);
                Intent intent3 = new Intent();
                intent3.putExtra("sns_userName", str);
                intent3.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent3.addFlags(67108864);
                ar.Hg();
                a = bh.a((Integer) c.CU().get(68389, null), 0);
                ar.Hg();
                c.CU().set(68389, Integer.valueOf(a + 1));
                com.tencent.mm.bm.d.b(this.mContext, "sns", ".ui.SnsUserUI", intent3);
                break;
            case 6:
                com.tencent.mm.bm.d.y(this.mContext, "favorite", ".ui.FavoriteIndexUI");
                break;
            case 7:
                com.tencent.mm.bm.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                com.tencent.mm.bm.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                com.tencent.mm.bm.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                g.pQN.h(11265, new Object[]{Integer.valueOf(3)});
                if (!(com.tencent.mm.p.a.aV(this.mContext) || com.tencent.mm.au.a.Qj())) {
                    com.tencent.mm.bm.d.y(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    u.fI(this.mContext);
                    break;
                }
                f.vz(10);
                ar.Hg();
                str = (String) c.CU().get(68377, null);
                ar.Hg();
                c.CU().set(68377, "");
                intent2 = new Intent();
                intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                boolean z3 = bh.ov(str);
                if (n.qQA == null) {
                    z2 = z3;
                } else if (n.qQA.Tq() <= 0) {
                    z2 = z3;
                }
                intent2.putExtra("sns_resume_state", z2);
                com.tencent.mm.bm.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent2);
                break;
            case 12:
                ar.Hg();
                if (!c.isSDCardAvailable()) {
                    u.fI(this.mContext);
                    break;
                }
                com.tencent.mm.bm.d.y(this.mContext, "game", ".ui.GameCenterUI");
                new af().postDelayed(new 3(this), 100);
                break;
            case 13:
                com.tencent.mm.sdk.b.a.xef.m(new ne());
                com.tencent.mm.bm.d.y(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                ar.Hg();
                if (!bh.c((Boolean) c.CU().get(4103, null))) {
                    com.tencent.mm.bm.d.y(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                HR = bi.HR();
                if (HR != null) {
                    String ou = bh.ou(HR.getProvince());
                    a = bh.a(Integer.valueOf(HR.fWf), 0);
                    if (!bh.ov(ou) && a != 0) {
                        ar.Hg();
                        Boolean bool = (Boolean) c.CU().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, R.i.dmB, null);
                            CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.csH);
                            checkBox.setChecked(false);
                            h.a(this.mContext, this.mContext.getString(R.l.dGO), inflate, new 4(this, checkBox), null);
                            break;
                        }
                        LauncherUI cmG = LauncherUI.cmG();
                        if (cmG != null) {
                            cmG.xGS.xGh.Yp("tab_find_friend");
                        }
                        com.tencent.mm.bk.a.dV(this.mContext);
                        break;
                    }
                    com.tencent.mm.bm.d.y(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                com.tencent.mm.bm.d.y(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
                break;
            case 15:
                HR = bi.HQ();
                if (bh.a(Integer.valueOf(HR.fWf), 0) > 0 && !bh.ov(HR.getProvince())) {
                    com.tencent.mm.bm.d.y(this.mContext, "bottle", ".ui.BottleBeachUI");
                    break;
                } else {
                    com.tencent.mm.bm.d.y(this.mContext, "bottle", ".ui.BottleWizardStep1");
                    break;
                }
                break;
            case 16:
                ar.Hg();
                if (!c.ET()) {
                    com.tencent.mm.bm.d.y(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.bm.d.y(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((com.tencent.mm.z.q.Gd() & 65536) != 0) {
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.bm.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.bm.d.y(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                com.tencent.mm.bm.d.y(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.bm.d.y(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                Context context = this.mContext;
                intent2 = new Intent();
                intent2.putExtra("key_from_scene", 2);
                com.tencent.mm.bm.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                if (com.tencent.mm.s.c.Bq().aR(262159, 266248)) {
                    com.tencent.mm.s.c.Bq().aS(262159, 266248);
                    g.pQN.h(14396, new Object[]{Integer.valueOf(2)});
                    break;
                }
                break;
            case 22:
                com.tencent.mm.pluginsdk.wallet.h.W(this.mContext, 1);
                break;
            case 2147483645:
                intent2 = new Intent();
                ar.Hg();
                str = (String) c.CU().get(a.xvg, "");
                if (!bh.ov(str)) {
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bm.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
                    break;
                }
                com.tencent.mm.pluginsdk.d.dZ(this.mContext);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                com.tencent.mm.bm.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case Integer.MAX_VALUE:
                g.pQN.k(10919, "1-6");
                com.tencent.mm.pluginsdk.d.dZ(this.mContext);
                break;
        }
        this.xMe.Ea(i2);
        dismiss();
    }

    public static d Eb(int i) {
        Context context = ac.getContext();
        switch (i) {
            case 1:
                if (HomeUI.xGa.booleanValue()) {
                    return new d(1, context.getString(R.l.euR), "", R.k.dzy, R.e.bui);
                }
                return new d(1, context.getString(R.l.euR), "", R.k.dzz, 0);
            case 2:
                if (HomeUI.xGb.booleanValue()) {
                    return new d(2, context.getString(R.l.euU), "", R.k.dzH, R.e.bui);
                }
                return new d(2, context.getString(R.l.euU), "", R.k.dzI, 0);
            case 3:
                return new d(3, context.getString(R.l.euV), "", R.k.dxi, 0);
            case 4:
                if (1 == bh.getInt(com.tencent.mm.k.g.zY().getValue("VOIPCallType"), 0)) {
                    return new d(4, context.getString(R.l.euW), "", R.k.dzS, 0);
                }
                return new d(4, context.getString(R.l.euS), "", R.k.dzA, 0);
            case 5:
                return new d(5, context.getString(R.l.eLX), "", R.k.dzN, 0);
            case 6:
                return new d(6, context.getString(R.l.eLL), "", R.k.dzE, 0);
            case 7:
                return new d(7, context.getString(R.l.eLM), "", R.k.dzC, 0);
            case 8:
                return new d(8, context.getString(R.l.eaj), "", R.k.dzD, 0);
            case 9:
                return new d(9, context.getString(R.l.eLZ), "", R.k.dzL, 0);
            case 10:
                return new d(10, context.getString(R.l.ehu), "", R.k.dzO, 0);
            case 11:
                return new d(11, context.getString(R.l.ePQ), "", R.k.dzK, 0);
            case 12:
                return new d(12, context.getString(R.l.emQ), "", R.k.dzG, 0);
            case 13:
                return new d(13, context.getString(R.l.eOL), "", R.k.dzR, 0);
            case 14:
                return new d(14, context.getString(R.l.exr), "", R.k.dzM, 0);
            case 15:
                return new d(15, context.getString(R.l.dMD), "", R.k.dzB, 0);
            case 16:
                return new d(16, context.getString(R.l.eKN), "", R.k.dzT, 0);
            case 17:
                return new d(17, context.getString(R.l.euJ), "", R.k.dzJ, 0);
            case 18:
                return new d(18, context.getString(R.l.ehv), "", R.k.dzP, 0);
            case 19:
                return new d(19, context.getString(R.l.ehw), "", R.k.duR, 0);
            case 20:
                ar.Hg();
                if (((Integer) c.CU().get(a.xrD, Integer.valueOf(0))).intValue() <= 1) {
                    return new d(20, context.getString(R.l.dDm), "", R.k.dAs, 0);
                }
                break;
            case 22:
                ar.Hg();
                if (((Integer) c.CU().get(a.xrD, Integer.valueOf(0))).intValue() == 8) {
                    return new d(22, context.getString(R.l.eAR), "", R.k.dzx, 0);
                }
                break;
            case 2147483645:
                return new d(2147483645, context.getString(R.l.eLh), "", R.k.dzF, 0);
            case 2147483646:
                return new d(2147483646, "TIT", "", R.k.dzC, 0);
            case Integer.MAX_VALUE:
                return new d(Integer.MAX_VALUE, context.getString(R.l.eLq), "", R.k.dzF, 0);
        }
        return null;
    }

    protected final BaseAdapter asU() {
        if (this.xMd == null) {
            this.xMd = new a(this, (byte) 0);
        }
        return this.xMd;
    }
}
