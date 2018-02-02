package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.b;
import com.tencent.mm.ag.h.a;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.t;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.bgz;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.protocal.c.cai;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.xwalk.core.R$styleable;

public final class c implements e, a, n, com.tencent.mm.pluginsdk.c.a {
    MMActivity fmM;
    private SharedPreferences gZO;
    private List<d.a> hop;
    private b hoq;
    private boolean hox;
    private String hoz;
    f ilB;
    boolean isDeleteCancel;
    x jLe;
    d kEC;
    private boolean kTc;
    private CheckBoxPreference kZJ;
    String mOi;
    private boolean phD;
    private int phF;
    private String phJ;
    private j piK;
    private List<WxaEntryInfo> piL;
    private pq piM;
    private boolean piN;
    private boolean piO;
    boolean piP;
    private int piQ;
    private String piR;
    private boolean piS;
    i piT;
    private Bundle piU;
    SnsAdClick piV;
    private String piW;
    r tipDialog;

    static /* synthetic */ void a(c cVar) {
        g gVar = new g(cVar.fmM, g.ztp, false);
        gVar.rKC = new 18(cVar);
        gVar.rKD = new p$d(cVar) {
            final /* synthetic */ c piX;

            {
                this.piX = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                c cVar;
                switch (menuItem.getItemId()) {
                    case 1:
                        cVar = this.piX;
                        Intent intent = new Intent();
                        intent.putExtra("Select_Talker_Name", cVar.jLe.field_username);
                        intent.putExtra("Select_block_List", cVar.jLe.field_username);
                        intent.putExtra("Select_Send_Card", true);
                        intent.putExtra("Select_Conv_Type", 3);
                        intent.putExtra("mutil_select_is_ret", true);
                        com.tencent.mm.plugin.profile.a.ifs.a(intent, cVar.fmM);
                        return;
                    case 2:
                        this.piX.fmM.getString(R.l.eiy, new Object[]{this.piX.jLe.AQ()});
                        h.a(this.piX.fmM, this.piX.fmM.getString(R.l.dUx), "", this.piX.fmM.getString(R.l.dUw), this.piX.fmM.getString(R.l.dEn), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 piY;

                            {
                                this.piY = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                c cVar = this.piY.piX;
                                String str = cVar.jLe.field_username;
                                ar.Hg();
                                cf Ew = com.tencent.mm.z.c.Fa().Ew(str);
                                ar.Hg();
                                com.tencent.mm.z.c.EX().b(new com.tencent.mm.ay.d(str, Ew.field_msgSvrId));
                                cVar.isDeleteCancel = false;
                                Context context = cVar.fmM;
                                cVar.fmM.getString(R.l.dGO);
                                cVar.tipDialog = h.a(context, cVar.fmM.getString(R.l.dHc), true, new 8(cVar));
                                ba.a(str, new ba.a(cVar) {
                                    final /* synthetic */ c piX;

                                    {
                                        this.piX = r1;
                                    }

                                    public final boolean HB() {
                                        return this.piX.isDeleteCancel;
                                    }

                                    public final void HA() {
                                        if (this.piX.tipDialog != null) {
                                            this.piX.tipDialog.dismiss();
                                            this.piX.tipDialog = null;
                                        }
                                    }
                                });
                            }
                        }, null);
                        return;
                    case 3:
                        this.piX.bjx();
                        return;
                    case 4:
                        c cVar2 = this.piX;
                        ((com.tencent.mm.pluginsdk.h) com.tencent.mm.kernel.g.h(com.tencent.mm.pluginsdk.h.class)).a(cVar2.kEC, cVar2.fmM, cVar2.jLe, true, new Runnable(cVar2) {
                            final /* synthetic */ c piX;

                            {
                                this.piX = r1;
                            }

                            public final void run() {
                                this.piX.aw(4, null);
                                if (this.piX.fmM.getIntent().getIntExtra("Kdel_from", -1) == 1) {
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.bm.d.b(this.piX.fmM, "shake", ".ui.ShakeReportUI", intent);
                                }
                            }
                        });
                        return;
                    case 5:
                        cVar = this.piX;
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + cVar.jLe.field_username);
                        com.tencent.mm.plugin.base.model.b.M(cVar.fmM, cVar.jLe.field_username);
                        ag.h(new 7(cVar), 1000);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUk();
    }

    private c(MMActivity mMActivity) {
        this.piM = null;
        this.piN = false;
        this.piO = false;
        this.hox = false;
        this.piP = false;
        this.piQ = 0;
        this.piT = null;
        this.gZO = null;
        this.piV = null;
        this.piW = null;
        this.tipDialog = null;
        this.isDeleteCancel = false;
        this.fmM = mMActivity;
    }

    public c(MMActivity mMActivity, String str, pq pqVar) {
        this(mMActivity);
        this.phJ = str;
        this.piM = pqVar;
    }

    public final boolean vQ(String str) {
        int i = 4;
        if (str == null) {
            return false;
        }
        String str2;
        String str3;
        if (str.equals("contact_info_verifyuser_weibo")) {
            com.tencent.mm.plugin.profile.ui.a.a aVar = new com.tencent.mm.plugin.profile.ui.a.a(this.fmM);
            str2 = this.jLe.fWt;
            str3 = this.jLe.field_username;
            if (str2 == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ViewTWeibo", "null weibo id");
                return true;
            }
            ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, aVar);
            aVar.plp = new com.tencent.mm.plugin.profile.a.a(bh.ou(str2).replace("http://t.qq.com/", "").trim(), str3);
            ar.CG().a(aVar.plp, 0);
            aVar.plq.J(3000, 3000);
            return true;
        } else if ("contact_info_biz_go_chatting".endsWith(str)) {
            if (this.piV != null) {
                com.tencent.mm.sdk.b.b ndVar = new nd();
                this.piV.hOx = 5;
                ndVar.fFd.fFe = this.piV;
                com.tencent.mm.sdk.b.a.xef.m(ndVar);
            }
            if (this.kEC == null || !(this.kEC.Le() || this.kEC.Lg())) {
                r0 = new Intent();
                if (this.fmM.getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false)) {
                    r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                if (this.phD) {
                    r0.putExtra("Chat_User", this.jLe.field_username);
                    r0.putExtra("Chat_Mode", 1);
                    this.fmM.setResult(-1, r0);
                } else {
                    r0.putExtra("Chat_User", this.jLe.field_username);
                    r0.putExtra("Chat_Mode", 1);
                    r0.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.profile.a.ifs.e(r0, this.fmM);
                }
            } else {
                r0 = new Intent();
                if (this.kEC.Lg()) {
                    str2 = this.kEC.Lm();
                    if (bh.ov(str2)) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "contact_info_biz_go_chatting fatherUserName is empty");
                        return false;
                    }
                    r0.putExtra("enterprise_biz_name", str2);
                    r0.putExtra("enterprise_biz_display_name", com.tencent.mm.z.r.gu(str2));
                } else {
                    r0.putExtra("enterprise_biz_name", this.jLe.field_username);
                    r0.putExtra("enterprise_biz_display_name", com.tencent.mm.z.r.gu(this.jLe.field_username));
                }
                r0.addFlags(67108864);
                com.tencent.mm.bm.d.a(this.fmM, ".ui.conversation.EnterpriseConversationUI", r0);
                this.fmM.finish();
            }
            aw(5, null);
            return true;
        } else if ("contact_info_biz_add".endsWith(str)) {
            if (this.fmM.getIntent() != null && this.fmM.getIntent().getBooleanExtra("KIsHardDevice", false)) {
                r0 = this.fmM.getIntent().getStringExtra("KHardDeviceBindTicket");
                if (bh.ov(r0)) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
                } else if (!bjw()) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "IsHardDevice, bindTicket = %s", new Object[]{r0});
                    ar.CG().a(536, this);
                    com.tencent.mm.sdk.b.b ctVar = new ct();
                    ctVar.fqX.fqZ = r0;
                    ctVar.fqX.opType = 1;
                    com.tencent.mm.sdk.b.a.xef.m(ctVar);
                    k kVar = ctVar.fqY.frb;
                    r1 = this.fmM;
                    this.fmM.getString(R.l.dGO);
                    this.tipDialog = h.a(r1, this.fmM.getString(R.l.dHc), true, new 4(this, kVar));
                    if (this.piQ != 0) {
                        return true;
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(11263, new Object[]{Integer.valueOf(this.piQ), this.jLe.field_username});
                    return true;
                }
            }
            com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.fmM, new 5(this));
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(this.phF));
            if (this.hoz != null) {
                aVar2.vmQ = this.hoz;
            }
            if (!bh.ov(this.mOi)) {
                aVar2.mOi = this.mOi;
            }
            aVar2.vmX = true;
            aVar2.a(this.jLe.field_username, linkedList, this.piW);
            if (this.piQ != 0) {
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(11263, new Object[]{Integer.valueOf(this.piQ), this.jLe.field_username});
            return true;
        } else if ("contact_info_biz_read_msg_online".endsWith(str)) {
            return true;
        } else {
            if (!"contact_info_stick_biz".equals(str)) {
                int i2;
                if (!(!"contact_info_guarantee_info".equals(str) || this.hoq.Lx() == null || bh.ov(this.hoq.Lx().hps))) {
                    r0 = new Intent();
                    r0.putExtra("rawUrl", this.hoq.Lx().hps);
                    r0.putExtra("useJs", true);
                    r0.putExtra("vertical_scroll", true);
                    r0.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bm.d.b(this.fmM, "webview", ".ui.tools.WebViewUI", r0);
                }
                if (str.startsWith("contact_info_bizinfo_external#")) {
                    i2 = bh.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                    if (i2 >= 0 && i2 < this.hop.size()) {
                        d.a aVar3 = (d.a) this.hop.get(i2);
                        str2 = aVar3.url;
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        intent.putExtra("geta8key_scene", 3);
                        intent.putExtra("KPublisherId", "brand_profile");
                        intent.putExtra("prePublishId", "brand_profile");
                        if ((this.piU != null && (this.phF == 39 || this.phF == 56 || this.phF == 35)) || this.phF == 87 || this.phF == 89 || this.phF == 85 || this.phF == 88) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "from biz search.");
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("KFromBizSearch", true);
                            bundle.putBundle("KBizSearchExtArgs", this.piU);
                            intent.putExtra("jsapiargs", bundle);
                            i = com.tencent.mm.l.a.fZ(this.jLe.field_type) ? 7 : 6;
                            int identifier = this.fmM.getResources().getIdentifier(aVar3.hot, "string", this.fmM.getPackageName());
                            r0 = aVar3.title;
                            if (identifier > 0) {
                                r0 = this.fmM.getString(identifier);
                            }
                            aw(i, r0);
                        }
                        com.tencent.mm.bm.d.b(this.fmM, "webview", ".ui.tools.WebViewUI", intent);
                        return true;
                    }
                }
                if ("contact_info_subscribe_bizinfo".endsWith(str) || "contact_info_show_brand".endsWith(str) || "contact_info_locate".endsWith(str)) {
                    final d dVar = this.kEC;
                    if (dVar == null) {
                        return true;
                    }
                    if ("contact_info_subscribe_bizinfo".endsWith(str)) {
                        if (!dVar.Ld()) {
                            if (dVar.KW()) {
                                dVar.field_brandFlag |= 1;
                                if (this.hoq == null && dVar != null) {
                                    this.hoq = dVar.bI(false);
                                }
                                if (this.hoq != null && this.hoq.Lq() && com.tencent.mm.bm.d.OQ("brandservice")) {
                                    this.ilB.bk("contact_info_template_recv", false);
                                } else {
                                    this.ilB.bk("contact_info_template_recv", true);
                                }
                            } else {
                                dVar.field_brandFlag &= -2;
                                this.ilB.bk("contact_info_template_recv", true);
                            }
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                            Object[] objArr = new Object[4];
                            objArr[0] = dVar.field_username;
                            objArr[1] = Integer.valueOf(1);
                            if (dVar.KW()) {
                                i = 3;
                            }
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(0);
                            gVar.h(13307, objArr);
                        } else if (dVar != null) {
                            if (dVar.Lg()) {
                                ar.CG().a(1363, this);
                                if (((CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo")).isChecked()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                }
                                k bVar = new com.tencent.mm.plugin.profile.a.b(dVar.field_username, i2);
                                ar.CG().a(bVar, 0);
                                Context context = this.fmM;
                                this.fmM.getString(R.l.dGO);
                                this.tipDialog = h.a(context, this.fmM.getString(R.l.dHc), true, new 14(this, bVar));
                            } else if (dVar.Le()) {
                                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
                                y.Mm();
                                final com.tencent.mm.ag.x a = com.tencent.mm.ag.c.a(dVar.field_username, !checkBoxPreference.isChecked(), this);
                                r1 = this.fmM;
                                this.fmM.getString(R.l.dGO);
                                this.tipDialog = h.a(r1, this.fmM.getString(R.l.dHc), true, new OnCancelListener(this) {
                                    final /* synthetic */ c piX;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        y.Mm();
                                        com.tencent.mm.ag.c.a(a);
                                    }
                                });
                            }
                        }
                    } else if ("contact_info_show_brand".endsWith(str)) {
                        boolean z;
                        if ((dVar.field_brandFlag & 2) == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            dVar.field_brandFlag |= 2;
                        } else {
                            dVar.field_brandFlag &= -3;
                        }
                    } else if ("contact_info_locate".endsWith(str)) {
                        if (dVar.KX()) {
                            dVar.field_brandFlag &= -5;
                        } else {
                            this.piT = h.a(this.fmM, this.fmM.getString(R.l.dQE, new Object[]{this.jLe.AQ()}), this.fmM.getString(R.l.dGO), new 1(this, dVar), new OnClickListener(this) {
                                final /* synthetic */ c piX;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dVar.field_hadAlert = 1;
                                    this.piX.a(dVar, false);
                                }
                            });
                        }
                    }
                    if (dVar.Lg() || dVar.Le()) {
                        return true;
                    }
                    a(dVar, false);
                    return true;
                } else if ("contact_info_verifyuser".endsWith(str)) {
                    r0 = this.kEC;
                    if (r0 == null) {
                        return true;
                    }
                    b bI = r0.bI(false);
                    if (bI == null) {
                        return true;
                    }
                    r0 = null;
                    if (bI.Lz() != null && !bh.ov(bI.Lz().hpn)) {
                        r0 = bI.Lz().hpn;
                    } else if (!(bI.LA() == null || bh.ov(bI.LA().hpv))) {
                        r0 = bI.LA().hpv;
                    }
                    if (bh.ov(r0)) {
                        return true;
                    }
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0);
                    r1.putExtra("useJs", true);
                    r1.putExtra("vertical_scroll", true);
                    r1.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bm.d.b(this.fmM, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else if ("contact_info_trademark".endsWith(str)) {
                    r0 = this.kEC;
                    if (r0 == null || r0.bI(false) == null || bh.ov(r0.bI(false).Ls())) {
                        return true;
                    }
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0.bI(false).Ls());
                    r1.putExtra("useJs", true);
                    r1.putExtra("vertical_scroll", true);
                    r1.putExtra("geta8key_scene", 3);
                    com.tencent.mm.bm.d.b(this.fmM, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else {
                    if ("contact_is_mute".endsWith(str)) {
                        this.kTc = !this.kTc;
                        if (this.kTc) {
                            s.n(this.jLe);
                        } else {
                            s.o(this.jLe);
                        }
                        hh(this.kTc);
                    }
                    if ("enterprise_contact_info_enter".equals(str)) {
                        if (this.fmM == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise context is null");
                        } else if (this.kEC == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "EnterEnterprise bizInfo is null");
                        } else {
                            r0 = new Intent();
                            r0.putExtra("enterprise_biz_name", this.kEC.field_username);
                            r0.addFlags(67108864);
                            com.tencent.mm.bm.d.b(this.fmM, "brandservice", ".ui.EnterpriseBizContactListUI", r0);
                        }
                    }
                    if ("contact_info_biz_disable".equals(str)) {
                        h.a(this.fmM, this.fmM.getString(R.l.ebM), "", this.fmM.getString(R.l.ebL), this.fmM.getString(R.l.dEn), new 12(this), null);
                    }
                    if ("contact_info_biz_enable".equals(str)) {
                        hg(true);
                    }
                    if ("contact_info_template_recv".equals(str)) {
                        r0 = new Intent();
                        r0.putExtra("enterprise_biz_name", this.kEC.field_username);
                        com.tencent.mm.bm.d.b(this.fmM, "brandservice", ".ui.ReceiveTemplateMsgMgrUI", r0);
                    }
                    if ("contact_info_service_phone".equals(str)) {
                        Preference YN = this.ilB.YN("contact_info_service_phone");
                        if (!(YN == null || YN.getSummary() == null || bh.ov(YN.getSummary().toString()))) {
                            str3 = YN.getSummary().toString();
                            h.a(this.fmM, true, str3, "", this.fmM.getString(R.l.dUO), this.fmM.getString(R.l.dEn), new 6(this, str3), null);
                        }
                    }
                    if ("contact_info_expose_btn".equals(str)) {
                        bjx();
                    }
                    if (!str.equals("biz_placed_to_the_top")) {
                        return true;
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "changePlacedTop");
                    if (this.gZO == null) {
                        this.gZO = this.fmM.getSharedPreferences(this.fmM.getPackageName() + "_preferences", 0);
                    }
                    if (this.jLe == null) {
                        return true;
                    }
                    if (this.jLe.AL()) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "unSetPlaceTop:%s", new Object[]{this.jLe.field_username});
                        s.s(this.jLe.field_username, true);
                        this.gZO.edit().putBoolean("biz_placed_to_the_top", false).commit();
                        return true;
                    }
                    com.tencent.mm.z.i.fZ(this.jLe.field_username);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "setPlaceTop:%s", new Object[]{this.jLe.field_username});
                    this.gZO.edit().putBoolean("biz_placed_to_the_top", true).commit();
                    return true;
                }
            } else if (((CheckBoxPreference) this.ilB.YN("contact_info_stick_biz")).isChecked()) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13307, new Object[]{this.jLe.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
                com.tencent.mm.z.i.fZ(this.jLe.field_username);
                return true;
            } else {
                s.s(this.jLe.field_username, true);
                com.tencent.mm.plugin.report.service.g.pQN.h(13307, new Object[]{this.jLe.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0)});
                return true;
            }
        }
    }

    final void hg(boolean z) {
        final k cVar = new com.tencent.mm.plugin.profile.a.c(this.kEC.field_username, !z);
        ar.CG().a(1394, this);
        ar.CG().a(cVar, 0);
        Context context = this.fmM;
        this.fmM.getString(R.l.dGO);
        this.tipDialog = h.a(context, this.fmM.getString(R.l.dHc), true, new OnCancelListener(this) {
            final /* synthetic */ c piX;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(cVar);
                ar.CG().b(1394, this.piX);
            }
        });
    }

    final void a(d dVar, boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("contact_info_locate");
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_ari = new ari();
        com_tencent_mm_protocal_c_ari.hvH = dVar.field_brandFlag;
        com_tencent_mm_protocal_c_ari.ksU = this.jLe.field_username;
        if (uQ(this.phF)) {
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(58, com_tencent_mm_protocal_c_ari));
        } else {
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_ari));
        }
        y.Mf().c(dVar, new String[0]);
        checkBoxPreference.tSw = dVar.KW();
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.tSw = dVar.KX();
        }
        if (z) {
            bju();
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        Assert.assertTrue(xVar != null);
        if (bh.ou(xVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.ilB = fVar;
        this.jLe = xVar;
        this.phD = z;
        this.phF = i;
        this.piQ = this.fmM.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.piV = (SnsAdClick) this.fmM.getIntent().getParcelableExtra("KSnsAdTag");
        this.piU = this.fmM.getIntent().getBundleExtra("Contact_Ext_Args");
        this.piW = this.fmM.getIntent().getStringExtra("key_add_contact_report_info");
        bju();
        String stringExtra = this.fmM.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bh.ov(stringExtra)) {
            this.fmM.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
            h.a(this.fmM, stringExtra, "", this.fmM.getString(R.l.dFU), null);
        }
        if (xVar != null) {
            y.Mp().jw(xVar.field_username);
            if (com.tencent.mm.ag.f.jV(xVar.field_username)) {
                stringExtra = xVar.field_username;
                if (com.tencent.mm.ag.f.eE(stringExtra)) {
                    y.Ml();
                    com.tencent.mm.ag.a.h.a(stringExtra, this);
                    stringExtra = com.tencent.mm.ag.f.jS(stringExtra).Lm();
                    if (stringExtra != null) {
                        y.Mp().jw(stringExtra);
                    }
                } else if (com.tencent.mm.ag.f.jX(stringExtra)) {
                    y.Mm();
                    com.tencent.mm.ag.c.a(stringExtra, this);
                    y.Mf();
                    stringExtra = com.tencent.mm.ag.e.jO(stringExtra);
                    if (stringExtra != null) {
                        y.Mp().jw(stringExtra);
                    }
                }
            }
        }
        return true;
    }

    private void bju() {
        d dVar;
        CheckBoxPreference checkBoxPreference;
        Preference YN;
        KeyValuePreference keyValuePreference;
        Bitmap b;
        boolean z;
        Drawable bitmapDrawable;
        String string;
        Bitmap b2;
        CharSequence charSequence;
        IndexOutOfBoundsException e;
        int indexOf;
        com.tencent.mm.ag.g kc;
        com.tencent.mm.ag.h Mg;
        IconWidgetPreference iconWidgetPreference;
        com.tencent.mm.ag.i Me;
        com.tencent.mm.ag.g kb;
        CheckBoxPreference checkBoxPreference2;
        String AQ;
        int identifier;
        arS();
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fbm);
        if (this.piP) {
            this.ilB.bk("contact_info_time_expired", true);
        }
        d jS = com.tencent.mm.ag.f.jS(this.jLe.field_username);
        this.hop = null;
        this.hoq = null;
        this.piL = null;
        if ((jS == null || jS.bI(false) == null) && this.piM != null) {
            jS = new d();
            jS.field_username = this.jLe.field_username;
            jS.field_brandFlag = this.piM.hvH;
            jS.field_brandIconURL = this.piM.hvK;
            jS.field_brandInfo = this.piM.hvJ;
            jS.field_extInfo = this.piM.hvI;
            dVar = jS;
        } else {
            dVar = jS;
        }
        if (dVar != null && dVar.field_brandInfo == null && dVar.field_extInfo == null && this.piM != null) {
            dVar.field_username = this.jLe.field_username;
            dVar.field_brandFlag = this.piM.hvH;
            dVar.field_brandIconURL = this.piM.hvK;
            dVar.field_brandInfo = this.piM.hvJ;
            dVar.field_extInfo = this.piM.hvI;
        }
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.ilB.YN("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference == null || bh.ov(this.jLe.field_username)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "head pref is null");
            this.ilB.bk("contact_info_header_bizinfo", true);
        } else {
            af afVar = this.jLe;
            bizInfoHeaderPreference.phs = this.phJ;
            bizInfoHeaderPreference.kEC = dVar;
            bizInfoHeaderPreference.onDetach();
            ar.Hg();
            com.tencent.mm.z.c.EY().a(bizInfoHeaderPreference);
            com.tencent.mm.ad.n.Jz().d(bizInfoHeaderPreference);
            y.Mn().a(bizInfoHeaderPreference);
            bizInfoHeaderPreference.jLe = afVar;
            Assert.assertTrue("initView: contact username is null", bh.ou(afVar.field_username).length() > 0);
            bizInfoHeaderPreference.initView();
        }
        this.ilB.bk("biz_placed_to_the_top", true);
        this.ilB.bk("contact_info_biz_enable", true);
        this.ilB.bk("contact_info_biz_disable", true);
        this.ilB.bk("contact_info_stick_biz", true);
        if (dVar != null) {
            b bVar;
            if (dVar.Lf()) {
                this.ilB.bk("contact_info_biz_add", true);
                this.ilB.bk("contact_info_expose_btn", true);
                this.ilB.bk("contact_is_mute", false);
                this.kTc = this.jLe.AI();
                if (dVar.Lg()) {
                    this.ilB.bk("contact_info_biz_go_chatting", true);
                    this.ilB.bk("contact_info_stick_biz", !com.tencent.mm.l.a.fZ(this.jLe.field_type));
                    checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_stick_biz");
                    checkBoxPreference.tSw = this.jLe.AL();
                    checkBoxPreference.setTitle(R.l.ebJ);
                    bjy();
                } else {
                    this.ilB.bk("contact_info_subscribe_bizinfo", true);
                    this.ilB.bk("contact_info_biz_go_chatting", true);
                    if (dVar.KW()) {
                        this.ilB.bk("contact_info_biz_enable", true);
                        this.ilB.bk("contact_info_biz_disable", false);
                        this.ilB.YN("contact_info_biz_disable").setTitle(R.l.ebL);
                        this.ilB.bk("contact_is_mute", false);
                        this.ilB.bk("biz_placed_to_the_top", false);
                        this.kZJ = (CheckBoxPreference) this.ilB.YN("biz_placed_to_the_top");
                        this.kZJ.setTitle(R.l.eca);
                        bjy();
                        if (dVar.Lh()) {
                            this.ilB.bk("contact_info_locate", true);
                        }
                    } else {
                        this.ilB.bk("contact_info_biz_enable", false);
                        this.ilB.bk("contact_info_biz_disable", true);
                        this.ilB.YN("contact_info_biz_enable").setTitle(R.l.ebN);
                        this.ilB.bk("contact_is_mute", true);
                        this.ilB.bk("biz_placed_to_the_top", true);
                        this.ilB.bk("contact_info_locate", true);
                    }
                }
                hh(this.kTc);
            } else if (dVar.Le()) {
                this.ilB.bk("contact_info_locate", true);
                this.ilB.bk("contact_info_subscribe_bizinfo", false);
                this.ilB.bk("enterprise_contact_info_enter", false);
                this.ilB.YN("contact_info_biz_go_chatting").setTitle(R.l.ebO);
                this.ilB.bk("contact_info_stick_biz", !com.tencent.mm.l.a.fZ(this.jLe.field_type));
                checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_stick_biz");
                checkBoxPreference.tSw = this.jLe.AL();
                checkBoxPreference.setTitle(R.l.ebR);
                bjy();
                this.ilB.bk("contact_is_mute", true);
                this.kTc = this.jLe.AI();
                hh(this.kTc);
                this.ilB.YN("contact_is_mute").setSummary(R.l.dUQ);
            } else {
                f fVar = this.ilB;
                String str = "contact_info_stick_biz";
                boolean z2 = s.gR(this.jLe.field_username) || !com.tencent.mm.l.a.fZ(this.jLe.field_type);
                fVar.bk(str, z2);
                ((CheckBoxPreference) this.ilB.YN("contact_info_stick_biz")).tSw = this.jLe.AL();
                this.ilB.bk("contact_is_mute", true);
                this.kTc = false;
            }
            this.kEC = dVar;
            this.hop = dVar.Ln();
            this.hoq = dVar.bI(false);
            this.piL = this.hoq.Lo();
            if (this.hoq.Lp()) {
                this.ilB.YN("near_field_service").setSummary(R.l.eXE);
            } else {
                this.ilB.bk("near_field_service", true);
            }
            if (this.hoq.Lu() != null) {
                this.piO = true;
                if (Hx(this.hoq.Lu())) {
                    this.piN = true;
                    if (!com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "expireTime not null, and %s is not my contact", new Object[]{this.jLe.field_username});
                        bjv();
                        if (s.hl(this.jLe.field_username) || Hz(this.jLe.field_username)) {
                            bjv();
                        }
                    }
                }
                this.ilB.bk("contact_info_time_expired", true);
                bjv();
            } else {
                this.ilB.bk("contact_info_time_expired", true);
            }
            if (this.hoq.Lr() != null && this.hoq.Lr().length() > 0) {
                this.hoz = this.hoq.Lr();
            }
            bVar = this.hoq;
            if (bVar.hou != null) {
                bVar.hox = "1".equals(bVar.hou.optString("IsShowMember"));
            }
            this.hox = bVar.hox;
            if (bh.ov(this.hoq.LF())) {
                this.ilB.bk("contact_info_service_phone", true);
            } else {
                this.ilB.bk("contact_info_service_phone", false);
                YN = this.ilB.YN("contact_info_service_phone");
                if (YN != null) {
                    YN.setSummary(this.hoq.LF());
                    YN.kXT = this.fmM.getResources().getColor(R.e.btd);
                }
            }
        } else {
            this.ilB.bk("contact_info_time_expired", true);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "get biz info from storage, but return null");
        }
        if (bh.ov(this.jLe.signature)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not desc info");
            this.ilB.bk("contact_info_user_desc", true);
            if (!this.piN) {
                this.ilB.bk("contact_info_time_expired", true);
            }
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_user_desc");
            if (keyValuePreference != null) {
                if (bh.ou(this.jLe.signature).trim().length() <= 0) {
                    this.ilB.bk("contact_info_user_desc", true);
                } else {
                    keyValuePreference.cqo();
                    keyValuePreference.yiT = false;
                    keyValuePreference.xID = this.fmM.getString(R.l.dVj);
                    keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.i.a(this.fmM, this.jLe.signature));
                    keyValuePreference.mx(false);
                    if (ak.a.hfN != null) {
                        b = BackwardSupportUtil.b.b(ak.a.hfN.gO(this.jLe.field_verifyFlag), 2.0f);
                    } else {
                        b = null;
                    }
                    String str2 = "MicroMsg.ContactWidgetBizInfo";
                    String str3 = "verify bmp is null ? %B";
                    Object[] objArr = new Object[1];
                    if (b == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    com.tencent.mm.sdk.platformtools.x.i(str2, str3, objArr);
                    if (b != null) {
                        bitmapDrawable = new BitmapDrawable(this.fmM.getResources(), b);
                    } else {
                        bitmapDrawable = null;
                    }
                    keyValuePreference.yjb = bitmapDrawable;
                    keyValuePreference.yiZ = 8;
                }
            }
        }
        if (this.hoq != null && this.hoq.Lz() != null && !bh.ov(this.hoq.Lz().hpl)) {
            b.d Lz = this.hoq.Lz();
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.cqo();
                keyValuePreference.yiT = false;
                if (bh.ov(Lz.hpm)) {
                    switch (Lz.hpk) {
                        case 0:
                            string = this.fmM.getResources().getString(R.l.dXg);
                            break;
                        case 1:
                            string = this.fmM.getResources().getString(R.l.dNf);
                            break;
                        case 2:
                            string = this.fmM.getResources().getString(R.l.dNg);
                            break;
                        default:
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "getVerifyStr, error type %d", new Object[]{Integer.valueOf(Lz.hpk)});
                            string = this.fmM.getResources().getString(R.l.dVj);
                            break;
                    }
                    keyValuePreference.xID = string;
                } else {
                    keyValuePreference.xID = Lz.hpm;
                }
                if (ak.a.hfN != null) {
                    b2 = BackwardSupportUtil.b.b(ak.a.hfN.gO(this.jLe.field_verifyFlag), 2.0f);
                } else {
                    b2 = null;
                }
                if (b2 != null) {
                    bitmapDrawable = new BitmapDrawable(this.fmM.getResources(), b2);
                } else {
                    bitmapDrawable = null;
                }
                str3 = "MicroMsg.ContactWidgetBizInfo";
                String str4 = "verify bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (b2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr2[0] = Boolean.valueOf(z);
                com.tencent.mm.sdk.platformtools.x.i(str3, str4, objArr2);
                keyValuePreference.yjb = bitmapDrawable;
                if (Lz.hpl != null) {
                    str3 = Lz.hpo;
                    CharSequence a = com.tencent.mm.pluginsdk.ui.d.i.a(this.fmM, Lz.hpl.trim());
                    if (bh.ov(str3)) {
                        charSequence = a;
                    } else {
                        try {
                            charSequence = new SpannableString(str3 + " " + a);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str3.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                                keyValuePreference.setSummary(charSequence);
                                if (this.hoq != null) {
                                }
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                                this.ilB.bk("contact_info_trademark", true);
                                if (this.hoq != null) {
                                }
                                this.ilB.bk("contact_info_privilege", true);
                                indexOf = this.ilB.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                                if (!this.piN) {
                                }
                                this.ilB.bk("contact_info_verifyuser_weibo", true);
                                if (this.hoq != null) {
                                }
                                this.ilB.bk("contact_info_reputation", true);
                                this.ilB.bk("contact_info_guarantee_info", true);
                                this.ilB.bk("contact_info_scope_of_business", true);
                                if (this.piL != null) {
                                }
                                this.ilB.bk("contact_info_bindwxainfo", true);
                                string = this.fmM.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.piS)});
                                if (!this.piS) {
                                    this.piR = string;
                                    if (this.hoq != null) {
                                        bVar = this.hoq;
                                        if (bVar.hou != null) {
                                            bVar.hoS = bVar.hou.optInt("FunctionFlag");
                                        }
                                        if ((bVar.hoS & d.hoo) > 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (bh.ov(string)) {
                                            kc = y.Me().kc(this.jLe.field_username);
                                            if (kc == null) {
                                                this.ilB.bk("contact_info_kf_worker", true);
                                                y.Mg().a(this);
                                                Mg = y.Mg();
                                                string = this.jLe.field_username;
                                                str = q.FS();
                                                if (bh.ov(string)) {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                                } else {
                                                    com.tencent.mm.kernel.g.Di().gPJ.a(new t(string, str), 0);
                                                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(Mg.hpH.size())});
                                                }
                                                this.piS = true;
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{kc.field_openId});
                                                this.ilB.bk("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.ilB.YN("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(kc.field_nickname);
                                                b2 = com.tencent.mm.ad.b.a(kc.field_openId, false, -1);
                                                if (b2 == null) {
                                                    c(kc);
                                                    Hy(kc.field_openId);
                                                } else {
                                                    iconWidgetPreference.A(b2);
                                                }
                                            }
                                        } else {
                                            Me = y.Me();
                                            kb = Me.kb(string);
                                            y.Mg().a(this);
                                            y.Mg().af(this.jLe.field_username, string);
                                            this.piS = true;
                                            if (kb == null) {
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                                kc = Me.kc(this.jLe.field_username);
                                            } else {
                                                kc = kb;
                                            }
                                            if (kc == null) {
                                                this.ilB.bk("contact_info_kf_worker", true);
                                            } else {
                                                this.ilB.bk("contact_info_kf_worker", false);
                                                iconWidgetPreference = (IconWidgetPreference) this.ilB.YN("contact_info_kf_worker");
                                                iconWidgetPreference.setSummary(kc.field_nickname);
                                                b2 = com.tencent.mm.ad.b.a(kc.field_openId, false, -1);
                                                if (b2 == null) {
                                                    c(kc);
                                                    Hy(kc.field_openId);
                                                } else {
                                                    iconWidgetPreference.A(b2);
                                                }
                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{kc.field_openId, kc.field_nickname});
                                            }
                                        }
                                    }
                                    this.ilB.bk("contact_info_kf_worker", true);
                                }
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.fmM.getIntent().getBooleanExtra("KIsHardDevice", false))});
                                if (this.fmM.getIntent() == null) {
                                }
                                if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                                    if (dVar != null) {
                                        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
                                        checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("contact_info_locate");
                                        if (!dVar.Lg()) {
                                            checkBoxPreference.setTitle(R.l.ebK);
                                            this.piK = y.Mj().ca(y.Mj().cb(dVar.field_username));
                                            if (this.piK != null) {
                                                if (this.piK.ho(4)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                checkBoxPreference.tSw = z;
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                            }
                                        } else if (dVar.Le()) {
                                            checkBoxPreference.setTitle(R.l.ebH);
                                            checkBoxPreference.tSw = y.Mm().jB(dVar.field_username);
                                        } else {
                                            checkBoxPreference.tSw = dVar.KW();
                                        }
                                        if (dVar.KW()) {
                                            this.hoq = dVar.bI(false);
                                            if (this.hoq == null) {
                                            }
                                            this.ilB.bk("contact_info_template_recv", true);
                                        } else {
                                            this.ilB.bk("contact_info_template_recv", true);
                                        }
                                        if (dVar.bI(false).La()) {
                                            checkBoxPreference2.tSw = dVar.KX();
                                        } else {
                                            this.ilB.bk("contact_info_locate", true);
                                            checkBoxPreference2.tSw = dVar.KX();
                                        }
                                    } else {
                                        this.ilB.bk("contact_info_subscribe_bizinfo", true);
                                        this.ilB.bk("contact_info_locate", true);
                                        this.ilB.bk("contact_info_template_recv", true);
                                    }
                                    this.ilB.bk("contact_info_biz_read_msg_online", true);
                                    this.ilB.bk("contact_info_biz_add", true);
                                    AQ = this.jLe.AQ();
                                    if (AQ != null) {
                                        this.fmM.setMMTitle(AQ);
                                    }
                                    if (s.gR(this.jLe.field_username)) {
                                        this.ilB.YN("contact_info_biz_go_chatting").setTitle(R.l.dWn);
                                        this.fmM.setMMTitle(R.l.dXc);
                                    }
                                    if (!s.hl(this.jLe.field_username)) {
                                    }
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.jLe.field_username});
                                bjv();
                                YN = this.ilB.YN("contact_info_biz_add");
                                YN.setTitle(R.l.dUy);
                                if (uQ(this.phF)) {
                                    if (dVar == null) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    } else {
                                        ((CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo")).tSw = dVar.KW();
                                        this.ilB.bk("contact_info_subscribe_bizinfo", false);
                                    }
                                }
                                this.fmM.showOptionMenu(false);
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            IndexOutOfBoundsException indexOutOfBoundsException = e3;
                            charSequence = a;
                            e = indexOutOfBoundsException;
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "verifySummary setSpan error: %s", new Object[]{e.getMessage()});
                            keyValuePreference.setSummary(charSequence);
                            if (this.hoq != null) {
                            }
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
                            this.ilB.bk("contact_info_trademark", true);
                            if (this.hoq != null) {
                            }
                            this.ilB.bk("contact_info_privilege", true);
                            indexOf = this.ilB.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
                            if (this.piN) {
                            }
                            this.ilB.bk("contact_info_verifyuser_weibo", true);
                            if (this.hoq != null) {
                            }
                            this.ilB.bk("contact_info_reputation", true);
                            this.ilB.bk("contact_info_guarantee_info", true);
                            this.ilB.bk("contact_info_scope_of_business", true);
                            if (this.piL != null) {
                            }
                            this.ilB.bk("contact_info_bindwxainfo", true);
                            string = this.fmM.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.piS)});
                            if (this.piS) {
                                this.piR = string;
                                if (this.hoq != null) {
                                    bVar = this.hoq;
                                    if (bVar.hou != null) {
                                        bVar.hoS = bVar.hou.optInt("FunctionFlag");
                                    }
                                    if ((bVar.hoS & d.hoo) > 0) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (bh.ov(string)) {
                                        Me = y.Me();
                                        kb = Me.kb(string);
                                        y.Mg().a(this);
                                        y.Mg().af(this.jLe.field_username, string);
                                        this.piS = true;
                                        if (kb == null) {
                                            kc = kb;
                                        } else {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                                            kc = Me.kc(this.jLe.field_username);
                                        }
                                        if (kc == null) {
                                            this.ilB.bk("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.ilB.YN("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(kc.field_nickname);
                                            b2 = com.tencent.mm.ad.b.a(kc.field_openId, false, -1);
                                            if (b2 == null) {
                                                iconWidgetPreference.A(b2);
                                            } else {
                                                c(kc);
                                                Hy(kc.field_openId);
                                            }
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{kc.field_openId, kc.field_nickname});
                                        } else {
                                            this.ilB.bk("contact_info_kf_worker", true);
                                        }
                                    } else {
                                        kc = y.Me().kc(this.jLe.field_username);
                                        if (kc == null) {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{kc.field_openId});
                                            this.ilB.bk("contact_info_kf_worker", false);
                                            iconWidgetPreference = (IconWidgetPreference) this.ilB.YN("contact_info_kf_worker");
                                            iconWidgetPreference.setSummary(kc.field_nickname);
                                            b2 = com.tencent.mm.ad.b.a(kc.field_openId, false, -1);
                                            if (b2 == null) {
                                                iconWidgetPreference.A(b2);
                                            } else {
                                                c(kc);
                                                Hy(kc.field_openId);
                                            }
                                        } else {
                                            this.ilB.bk("contact_info_kf_worker", true);
                                            y.Mg().a(this);
                                            Mg = y.Mg();
                                            string = this.jLe.field_username;
                                            str = q.FS();
                                            if (bh.ov(string)) {
                                                com.tencent.mm.kernel.g.Di().gPJ.a(new t(string, str), 0);
                                                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(Mg.hpH.size())});
                                            } else {
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                                            }
                                            this.piS = true;
                                        }
                                    }
                                }
                                this.ilB.bk("contact_info_kf_worker", true);
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.fmM.getIntent().getBooleanExtra("KIsHardDevice", false))});
                            if (this.fmM.getIntent() == null) {
                            }
                            if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.jLe.field_username});
                                bjv();
                                YN = this.ilB.YN("contact_info_biz_add");
                                YN.setTitle(R.l.dUy);
                                if (uQ(this.phF)) {
                                    if (dVar == null) {
                                        ((CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo")).tSw = dVar.KW();
                                        this.ilB.bk("contact_info_subscribe_bizinfo", false);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                                    }
                                }
                                this.fmM.showOptionMenu(false);
                            }
                            if (dVar != null) {
                                this.ilB.bk("contact_info_subscribe_bizinfo", true);
                                this.ilB.bk("contact_info_locate", true);
                                this.ilB.bk("contact_info_template_recv", true);
                            } else {
                                checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
                                checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("contact_info_locate");
                                if (!dVar.Lg()) {
                                    checkBoxPreference.setTitle(R.l.ebK);
                                    this.piK = y.Mj().ca(y.Mj().cb(dVar.field_username));
                                    if (this.piK != null) {
                                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                                    } else {
                                        if (this.piK.ho(4)) {
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        checkBoxPreference.tSw = z;
                                    }
                                } else if (dVar.Le()) {
                                    checkBoxPreference.tSw = dVar.KW();
                                } else {
                                    checkBoxPreference.setTitle(R.l.ebH);
                                    if (y.Mm().jB(dVar.field_username)) {
                                    }
                                    checkBoxPreference.tSw = y.Mm().jB(dVar.field_username);
                                }
                                if (dVar.KW()) {
                                    this.ilB.bk("contact_info_template_recv", true);
                                } else {
                                    this.hoq = dVar.bI(false);
                                    if (this.hoq == null) {
                                    }
                                    this.ilB.bk("contact_info_template_recv", true);
                                }
                                if (dVar.bI(false).La()) {
                                    this.ilB.bk("contact_info_locate", true);
                                    checkBoxPreference2.tSw = dVar.KX();
                                } else {
                                    checkBoxPreference2.tSw = dVar.KX();
                                }
                            }
                            this.ilB.bk("contact_info_biz_read_msg_online", true);
                            this.ilB.bk("contact_info_biz_add", true);
                            AQ = this.jLe.AQ();
                            if (AQ != null) {
                                this.fmM.setMMTitle(AQ);
                            }
                            if (s.gR(this.jLe.field_username)) {
                                this.ilB.YN("contact_info_biz_go_chatting").setTitle(R.l.dWn);
                                this.fmM.setMMTitle(R.l.dXc);
                            }
                            if (!s.hl(this.jLe.field_username)) {
                                return;
                            }
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.ilB.bk("contact_info_verifyuser", true);
            }
        } else if (this.hoq == null || this.hoq.LA() == null || bh.ov(this.hoq.LA().hpu)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not verify info");
            this.ilB.bk("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.hoq.LA().hpu);
            }
        }
        if (this.hoq != null || bh.ov(this.hoq.Lt())) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "has not trademark info");
            this.ilB.bk("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_trademark");
            if (keyValuePreference != null) {
                keyValuePreference.cqo();
                keyValuePreference.yiT = false;
                if (ak.a.hfN != null) {
                    b = com.tencent.mm.sdk.platformtools.d.CZ(R.k.dwi);
                } else {
                    b = null;
                }
                str2 = "MicroMsg.ContactWidgetBizInfo";
                str3 = "trademark bmp is null ? %B";
                objArr = new Object[1];
                if (b == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                com.tencent.mm.sdk.platformtools.x.i(str2, str3, objArr);
                if (b != null) {
                    bitmapDrawable = new BitmapDrawable(this.fmM.getResources(), b);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.yjb = bitmapDrawable;
                keyValuePreference.setSummary(this.hoq.Lt());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "trademark name : %s, url : %s.", new Object[]{this.hoq.Lt(), this.hoq.Ls()});
            }
        }
        if (this.hoq != null || this.hoq.Lv() == null || this.hoq.Lv().size() <= 0) {
            this.ilB.bk("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_privilege");
            keyValuePreference.cqo();
            keyValuePreference.mx(false);
            keyValuePreference.yjc.clear();
            for (b.f fVar2 : this.hoq.Lv()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.fmM, R.i.dmw, null);
                ((ImageView) linearLayout.findViewById(R.h.cpk)).setImageDrawable(new a(this.fmM.getResources(), fVar2.iconUrl));
                CharSequence charSequence2 = fVar2.description;
                identifier = this.fmM.getResources().getIdentifier(fVar2.hpt, "string", this.fmM.getPackageName());
                if (identifier > 0) {
                    charSequence2 = this.fmM.getString(identifier);
                }
                ((TextView) linearLayout.findViewById(R.h.summary)).setText(charSequence2);
                keyValuePreference.yjc.add(linearLayout);
            }
        }
        indexOf = this.ilB.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.hop == null || this.hop.size() <= 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "pos no more");
        } else {
            int size = this.hop.size() - 1;
            while (size >= 0) {
                if (this.hop.get(size) != null && ((!this.fmM.getString(R.l.dUA).equals(((d.a) this.hop.get(size)).title) || this.hox) && !(bh.ov(((d.a) this.hop.get(size)).title) && bh.ov(((d.a) this.hop.get(size)).hot)))) {
                    Preference preference = new Preference(this.fmM);
                    preference.setKey("contact_info_bizinfo_external#" + size);
                    charSequence = ((d.a) this.hop.get(size)).title;
                    int identifier2 = this.fmM.getResources().getIdentifier(((d.a) this.hop.get(size)).hot, "string", this.fmM.getPackageName());
                    if (identifier2 > 0) {
                        charSequence = this.fmM.getString(identifier2);
                    }
                    if (this.kEC.Ld() && ("__mp_wording__brandinfo_history_massmsg".equals(((d.a) this.hop.get(size)).hot) || r1.equals(this.fmM.getString(R.l.dBR)))) {
                        charSequence = this.fmM.getString(R.l.ebG);
                    }
                    preference.setTitle(charSequence);
                    if (!bh.ov(((d.a) this.hop.get(size)).description)) {
                        preference.setSummary(((d.a) this.hop.get(size)).description);
                    }
                    if (bh.ou(((d.a) this.hop.get(size)).hot).equals("__mp_wording__brandinfo_feedback")) {
                        identifier2 = this.ilB.indexOf("contact_info_scope_of_business");
                        if (identifier2 > 0) {
                            identifier = identifier2 + 1;
                            this.ilB.a(preference, identifier);
                            if (bh.ou(((d.a) this.hop.get(size)).hot).equals("__mp_wording__brandinfo_biz_detail")) {
                                this.ilB.a(new PreferenceSmallCategory(this.fmM), identifier);
                            }
                        }
                    }
                    identifier = indexOf;
                    this.ilB.a(preference, identifier);
                    if (bh.ou(((d.a) this.hop.get(size)).hot).equals("__mp_wording__brandinfo_biz_detail")) {
                        this.ilB.a(new PreferenceSmallCategory(this.fmM), identifier);
                    }
                }
                size--;
            }
        }
        if (this.piN || !s.v(this.jLe) || this.jLe.fWt == null || this.jLe.fWt.equals("")) {
            this.ilB.bk("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(bh.az(this.jLe.field_weiboNickname, "") + this.fmM.getString(R.l.eMX, new Object[]{s.hu(this.jLe.fWt)}));
                keyValuePreference.kXT = com.tencent.mm.bv.a.c(this.fmM, R.e.btd);
                keyValuePreference.mx(false);
            }
        }
        if (this.hoq != null || this.hoq.Lx() == null) {
            this.ilB.bk("contact_info_reputation", true);
            this.ilB.bk("contact_info_guarantee_info", true);
            this.ilB.bk("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ilB.YN("contact_info_reputation");
            if (this.hoq.Lx().hpp > 0) {
                bizInfoPayInfoIconPreference.uJ(this.hoq.Lx().hpp);
            } else {
                this.ilB.bk("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ilB.YN("contact_info_guarantee_info");
            if (this.hoq.Lx().hpr == null || this.hoq.Lx().hpr.size() <= 0) {
                this.ilB.bk("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.bo(this.hoq.Lx().hpr);
            }
            keyValuePreference = (KeyValuePreference) this.ilB.YN("contact_info_scope_of_business");
            if (bh.ov(this.hoq.Lx().hpq)) {
                this.ilB.bk("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary(this.hoq.Lx().hpq);
                keyValuePreference.yiZ = 4;
                keyValuePreference.mx(false);
            }
        }
        if (this.piL != null || this.piL.size() <= 0) {
            this.ilB.bk("contact_info_bindwxainfo", true);
        } else {
            this.ilB.bk("contact_info_bindwxainfo", false);
            BizBindWxaInfoPreference bizBindWxaInfoPreference = (BizBindWxaInfoPreference) this.ilB.YN("contact_info_bindwxainfo");
            d dVar2 = this.kEC;
            Collection collection = this.piL;
            bizBindWxaInfoPreference.phg = true;
            bizBindWxaInfoPreference.ilX = dVar2;
            if (bizBindWxaInfoPreference.jVn == null) {
                bizBindWxaInfoPreference.jVn = new LinkedList();
            } else {
                bizBindWxaInfoPreference.jVn.clear();
            }
            if (!(collection == null || collection.isEmpty())) {
                bizBindWxaInfoPreference.jVn.addAll(collection);
            }
            bizBindWxaInfoPreference.acD();
        }
        string = this.fmM.getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updateKF %s, %b", new Object[]{string, Boolean.valueOf(this.piS)});
        if (this.piS) {
            this.piR = string;
            if (this.hoq != null) {
                bVar = this.hoq;
                if (bVar.hou != null) {
                    bVar.hoS = bVar.hou.optInt("FunctionFlag");
                }
                if ((bVar.hoS & d.hoo) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && this.jLe != null) {
                    if (bh.ov(string)) {
                        kc = y.Me().kc(this.jLe.field_username);
                        if (kc == null) {
                            this.ilB.bk("contact_info_kf_worker", true);
                            y.Mg().a(this);
                            Mg = y.Mg();
                            string = this.jLe.field_username;
                            str = q.FS();
                            if (bh.ov(string)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
                            } else {
                                com.tencent.mm.kernel.g.Di().gPJ.a(new t(string, str), 0);
                                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", new Object[]{string, Integer.valueOf(Mg.hpH.size())});
                            }
                            this.piS = true;
                        } else {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "has default kf %s", new Object[]{kc.field_openId});
                            this.ilB.bk("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.ilB.YN("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(kc.field_nickname);
                            b2 = com.tencent.mm.ad.b.a(kc.field_openId, false, -1);
                            if (b2 == null) {
                                c(kc);
                                Hy(kc.field_openId);
                            } else {
                                iconWidgetPreference.A(b2);
                            }
                        }
                    } else {
                        Me = y.Me();
                        kb = Me.kb(string);
                        if (kb == null || com.tencent.mm.ag.i.a(kb)) {
                            y.Mg().a(this);
                            y.Mg().af(this.jLe.field_username, string);
                            this.piS = true;
                        }
                        if (kb == null) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "no such kf, get default kf");
                            kc = Me.kc(this.jLe.field_username);
                        } else {
                            kc = kb;
                        }
                        if (kc == null) {
                            this.ilB.bk("contact_info_kf_worker", true);
                        } else {
                            this.ilB.bk("contact_info_kf_worker", false);
                            iconWidgetPreference = (IconWidgetPreference) this.ilB.YN("contact_info_kf_worker");
                            iconWidgetPreference.setSummary(kc.field_nickname);
                            b2 = com.tencent.mm.ad.b.a(kc.field_openId, false, -1);
                            if (b2 == null) {
                                c(kc);
                                Hy(kc.field_openId);
                            } else {
                                iconWidgetPreference.A(b2);
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "kf worker %s, %s", new Object[]{kc.field_openId, kc.field_nickname});
                        }
                    }
                }
            }
            this.ilB.bk("contact_info_kf_worker", true);
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "KIsardDevice(%b)", new Object[]{Boolean.valueOf(this.fmM.getIntent().getBooleanExtra("KIsHardDevice", false))});
        if (this.fmM.getIntent() == null && this.fmM.getIntent().getBooleanExtra("KIsHardDevice", false)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "Hard device biz...");
            z2 = bjw();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "contact.isContact()(%b), isHardDeviceBound(%b)", new Object[]{Boolean.valueOf(com.tencent.mm.l.a.fZ(this.jLe.field_type)), Boolean.valueOf(z2)});
            if (com.tencent.mm.l.a.fZ(this.jLe.field_type) && z2) {
                if (dVar != null) {
                    checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
                    checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("contact_info_locate");
                    if (dVar.Lg()) {
                        this.piK = y.Mj().ca(y.Mj().cb(dVar.field_username));
                        if (this.piK != null) {
                            checkBoxPreference.tSw = !this.piK.ho(4);
                        } else {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                        }
                    } else {
                        checkBoxPreference.tSw = dVar.KW();
                    }
                    if (dVar.KW()) {
                        if (this.hoq == null && dVar != null) {
                            this.hoq = dVar.bI(false);
                        }
                        if (this.hoq != null && this.hoq.Lq() && com.tencent.mm.bm.d.OQ("brandservice")) {
                            this.ilB.bk("contact_info_template_recv", false);
                        } else {
                            this.ilB.bk("contact_info_template_recv", true);
                        }
                    } else {
                        this.ilB.bk("contact_info_template_recv", true);
                    }
                    if (dVar.bI(false).La()) {
                        checkBoxPreference2.tSw = dVar.KX();
                    } else {
                        this.ilB.bk("contact_info_locate", true);
                        checkBoxPreference2.tSw = dVar.KX();
                    }
                } else {
                    this.ilB.bk("contact_info_subscribe_bizinfo", true);
                    this.ilB.bk("contact_info_locate", true);
                    this.ilB.bk("contact_info_template_recv", true);
                }
                this.ilB.bk("contact_info_biz_read_msg_online", true);
                this.ilB.bk("contact_info_biz_add", true);
                AQ = this.jLe.AQ();
                if (AQ != null) {
                    this.fmM.setMMTitle(AQ);
                }
                if (s.gR(this.jLe.field_username)) {
                    this.ilB.YN("contact_info_biz_go_chatting").setTitle(R.l.dWn);
                    this.fmM.setMMTitle(R.l.dXc);
                }
                if (!s.hl(this.jLe.field_username) && this.kEC != null && !this.kEC.Lf()) {
                    this.fmM.addIconOptionMenu(0, R.g.bDI, new 16(this));
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my hard biz contact", new Object[]{this.jLe.field_username});
            bjv();
            Preference YN2 = this.ilB.YN("contact_info_biz_add");
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "isBizConferenceAccount(%b)", new Object[]{Boolean.valueOf(this.piO)});
            if (YN2 != null) {
                if (z2) {
                    YN2.setTitle(R.l.dUy);
                } else {
                    YN2.setTitle(R.l.dUv);
                }
            }
            if (uQ(this.phF)) {
                if (dVar == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo")).tSw = dVar.KW();
                    this.ilB.bk("contact_info_subscribe_bizinfo", false);
                }
            }
            this.fmM.showOptionMenu(false);
        } else if (com.tencent.mm.l.a.fZ(this.jLe.field_type)) {
            if (dVar != null) {
                checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
                checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("contact_info_locate");
                if (!dVar.Lg()) {
                    checkBoxPreference.setTitle(R.l.ebK);
                    this.piK = y.Mj().ca(y.Mj().cb(dVar.field_username));
                    if (this.piK != null) {
                        if (this.piK.ho(4)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        checkBoxPreference.tSw = z;
                    } else {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null");
                    }
                } else if (dVar.Le()) {
                    checkBoxPreference.setTitle(R.l.ebH);
                    if (y.Mm().jB(dVar.field_username)) {
                    }
                    checkBoxPreference.tSw = y.Mm().jB(dVar.field_username);
                } else {
                    checkBoxPreference.tSw = dVar.KW();
                }
                if (dVar.KW()) {
                    if (this.hoq == null && dVar != null) {
                        this.hoq = dVar.bI(false);
                    }
                    if (this.hoq == null && this.hoq.Lq() && com.tencent.mm.bm.d.OQ("brandservice")) {
                        this.ilB.bk("contact_info_template_recv", false);
                    } else {
                        this.ilB.bk("contact_info_template_recv", true);
                    }
                } else {
                    this.ilB.bk("contact_info_template_recv", true);
                }
                if (dVar.bI(false).La()) {
                    checkBoxPreference2.tSw = dVar.KX();
                } else {
                    this.ilB.bk("contact_info_locate", true);
                    checkBoxPreference2.tSw = dVar.KX();
                }
            } else {
                this.ilB.bk("contact_info_subscribe_bizinfo", true);
                this.ilB.bk("contact_info_locate", true);
                this.ilB.bk("contact_info_template_recv", true);
            }
            this.ilB.bk("contact_info_biz_read_msg_online", true);
            this.ilB.bk("contact_info_biz_add", true);
            AQ = this.jLe.AQ();
            if (AQ != null) {
                this.fmM.setMMTitle(AQ);
            }
            if (s.gR(this.jLe.field_username)) {
                this.ilB.YN("contact_info_biz_go_chatting").setTitle(R.l.dWn);
                this.fmM.setMMTitle(R.l.dXc);
            }
            if (!s.hl(this.jLe.field_username) && this.kEC != null) {
                this.fmM.addIconOptionMenu(0, R.g.bDI, new 17(this));
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "%s is not my contact", new Object[]{this.jLe.field_username});
            bjv();
            YN = this.ilB.YN("contact_info_biz_add");
            if (YN != null && this.piO) {
                YN.setTitle(R.l.dUy);
            }
            if (uQ(this.phF)) {
                if (dVar == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "bizinfo is null in temp session");
                } else {
                    ((CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo")).tSw = dVar.KW();
                    this.ilB.bk("contact_info_subscribe_bizinfo", false);
                }
            }
            this.fmM.showOptionMenu(false);
        }
    }

    private void bjv() {
        if (this.jLe == null || !com.tencent.mm.l.a.fZ(this.jLe.field_type) || s.gR(this.jLe.field_username) || Hz(this.jLe.field_username)) {
            this.ilB.bk("contact_is_mute", true);
            if (this.jLe == null || com.tencent.mm.l.a.fZ(this.jLe.field_type) || !uQ(this.phF)) {
                this.ilB.bk("contact_info_expose_btn", true);
            } else {
                this.ilB.bk("contact_info_expose_btn", false);
            }
        } else {
            this.ilB.bk("contact_is_mute", false);
        }
        this.ilB.bk("contact_info_verifyuser_weibo", true);
        this.ilB.bk("contact_info_subscribe_bizinfo", true);
        this.ilB.bk("contact_info_template_recv", true);
        this.ilB.bk("contact_info_locate", true);
        if (this.piN) {
            this.ilB.bk("contact_info_biz_add", true);
        } else {
            this.ilB.bk("contact_info_time_expired", true);
        }
        if (this.jLe == null || !((s.hl(this.jLe.field_username) || Hz(this.jLe.field_username)) && com.tencent.mm.l.a.fZ(this.jLe.field_type))) {
            this.ilB.bk("contact_info_biz_go_chatting", true);
        } else {
            this.ilB.bk("contact_info_biz_go_chatting", false);
        }
        if (Hz(this.jLe.field_username)) {
            this.ilB.bk("contact_info_user_desc", true);
        }
    }

    public final boolean arS() {
        BizInfoHeaderPreference bizInfoHeaderPreference = (BizInfoHeaderPreference) this.ilB.YN("contact_info_header_bizinfo");
        if (bizInfoHeaderPreference != null) {
            bizInfoHeaderPreference.onDetach();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.fmM == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "null == context");
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.f.aZh().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.h(this.fmM, this.fmM.getString(R.l.eic));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static boolean Hx(String str) {
        try {
            long j = bh.getLong(str, 0);
            if (j <= 0 || j - (System.currentTimeMillis() / 1000) >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final void aw(int i, String str) {
        if (this.piU == null || !(this.phF == 39 || this.phF == 56 || this.phF == 35 || this.phF == 87 || this.phF == 88 || this.phF == 89 || this.phF == 85)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
        } else if (this.jLe == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetBizInfo", "contact is null.");
        } else {
            int i2;
            String string = this.piU.getString("Contact_Ext_Args_Search_Id");
            String ou = bh.ou(this.piU.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.piU.getInt("Contact_Ext_Args_Index");
            switch (this.phF) {
                case 35:
                    i2 = 1;
                    break;
                case 85:
                    i2 = 5;
                    break;
                case R$styleable.AppCompatTheme_colorControlHighlight /*87*/:
                    i2 = 2;
                    break;
                case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
                    i2 = 3;
                    break;
                case R$styleable.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String ou2 = bh.ou(this.piU.getString("Contact_Ext_Extra_Params"));
            String str2 = ou + "," + i + "," + bh.ou(this.jLe.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bh.ov(str)) {
                str2 = str2 + ",," + ou2;
            } else {
                str2 = str2 + "," + str + "," + ou2;
            }
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactWidgetBizInfo", "report 10866: %s", new Object[]{str2});
            com.tencent.mm.plugin.report.service.g.pQN.k(10866, str2);
        }
    }

    private boolean bjw() {
        if (this.fmM.getIntent() == null) {
            return false;
        }
        String stringExtra = this.fmM.getIntent().getStringExtra("device_id");
        String stringExtra2 = this.fmM.getIntent().getStringExtra("device_type");
        com.tencent.mm.sdk.b.b cxVar = new cx();
        cxVar.fri.ffq = stringExtra;
        cxVar.fri.frg = stringExtra2;
        com.tencent.mm.sdk.b.a.xef.m(cxVar);
        return cxVar.frj.frk;
    }

    final void bjx() {
        if (this.jLe != null && !bh.ov(this.jLe.field_username)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.jLe.field_username}));
            intent.putExtra("showShare", false);
            com.tencent.mm.bm.d.b(this.fmM, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private void hh(boolean z) {
        if (this.jLe != null) {
            if (this.fmM != null) {
                if (!z || com.tencent.mm.ag.f.eE(this.jLe.field_username)) {
                    this.fmM.setTitleMuteIconVisibility(8);
                } else {
                    this.fmM.setTitleMuteIconVisibility(0);
                }
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_is_mute");
            if (checkBoxPreference != null) {
                checkBoxPreference.tSw = z;
            }
        }
    }

    private void Hy(final String str) {
        ag.h(new Runnable(this) {
            final /* synthetic */ c piX;

            public final void run() {
                if (this.piX.ilB == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar screen is null");
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) this.piX.ilB.YN("contact_info_kf_worker");
                if (iconWidgetPreference != null && this.piX.ilB != null) {
                    Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
                    if (a != null) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "LazyGetAvatar success %s, update screen", new Object[]{str});
                        iconWidgetPreference.A(a);
                        this.piX.ilB.notifyDataSetChanged();
                    }
                }
            }
        }, 2000);
    }

    private static void c(com.tencent.mm.ag.g gVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.ad.i JQ = com.tencent.mm.ad.n.JQ();
        if (JQ.jm(gVar.field_openId) == null) {
            com.tencent.mm.ad.h hVar = new com.tencent.mm.ad.h();
            hVar.username = gVar.field_openId;
            hVar.hlx = gVar.field_headImgUrl;
            hVar.bA(false);
            hVar.fWe = 3;
            JQ.a(hVar);
        }
        com.tencent.mm.ad.n.JS().iZ(gVar.field_openId);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "downloadKFAvatar, %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(int i, int i2, String str, k kVar) {
        bgz com_tencent_mm_protocal_c_bgz = null;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.piS = false;
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (kVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "scene == null");
            return;
        }
        ar.CG().b(kVar.getType(), this);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 536) {
                ar.CG().b(536, this);
                bju();
                return;
            } else if (kVar.getType() == 1363) {
                bha com_tencent_mm_protocal_c_bha;
                com.tencent.mm.plugin.profile.a.b bVar = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (bVar.gJQ == null || bVar.gJQ.hmh.hmo == null) {
                    com_tencent_mm_protocal_c_bha = null;
                } else {
                    com_tencent_mm_protocal_c_bha = (bha) bVar.gJQ.hmh.hmo;
                }
                com.tencent.mm.plugin.profile.a.b bVar2 = (com.tencent.mm.plugin.profile.a.b) kVar;
                if (!(bVar2.gJQ == null || bVar2.gJQ.hmg.hmo == null)) {
                    com_tencent_mm_protocal_c_bgz = (bgz) bVar2.gJQ.hmg.hmo;
                }
                if (com_tencent_mm_protocal_c_bha == null || com_tencent_mm_protocal_c_bha.vNw == null || com_tencent_mm_protocal_c_bha.vNw.ret != 0 || com_tencent_mm_protocal_c_bha.vNt == null || bh.ov(com_tencent_mm_protocal_c_bha.vNt.vNr)) {
                    if (com_tencent_mm_protocal_c_bha == null || com_tencent_mm_protocal_c_bha.vNw == null) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:resp == null");
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd err:code:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bha.vNw.ret)});
                    return;
                } else if (com_tencent_mm_protocal_c_bha.vNt == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "willen onSceneEnd resp.user == null");
                    return;
                } else {
                    j ca = y.Mj().ca(com_tencent_mm_protocal_c_bha.vNt.vNr);
                    if (ca == null) {
                        ca = new j();
                        ca.field_userId = com_tencent_mm_protocal_c_bha.vNt.vNr;
                    }
                    ca.field_userName = com_tencent_mm_protocal_c_bha.vNt.kNz;
                    ca.field_brandUserName = com_tencent_mm_protocal_c_bgz.vNq;
                    ca.field_UserVersion = com_tencent_mm_protocal_c_bha.vNt.ver;
                    ca.field_headImageUrl = com_tencent_mm_protocal_c_bha.vNt.vNl;
                    ca.field_profileUrl = com_tencent_mm_protocal_c_bha.vNt.vNz;
                    ca.field_bitFlag = com_tencent_mm_protocal_c_bha.vNt.vNm;
                    ca.field_addMemberUrl = com_tencent_mm_protocal_c_bha.vNt.vNp;
                    ca.field_needToUpdate = false;
                    if (!y.Mj().b(ca)) {
                        y.Mj().a(ca);
                        return;
                    }
                    return;
                }
            } else if (kVar.getType() == 1394) {
                bmp bjq = ((com.tencent.mm.plugin.profile.a.c) kVar).bjq();
                bmq bjp = ((com.tencent.mm.plugin.profile.a.c) kVar).bjp();
                if (bjp != null && bjp.vNw != null && bjp.vNw.ret == 0) {
                    boolean z;
                    if (bjq.wPS) {
                        z = false;
                    } else {
                        z = true;
                    }
                    d dVar;
                    if (z) {
                        ae aeVar;
                        dVar = this.kEC;
                        dVar.field_brandFlag &= -2;
                        a(dVar, true);
                        ar.Hg();
                        if (com.tencent.mm.z.c.Fd().WY(dVar.field_username) == null) {
                            aeVar = new ae(dVar.field_username);
                            aeVar.dH(bh.ou(this.kEC.Lm()));
                            ar.Hg();
                            au Ex = com.tencent.mm.z.c.Fa().Ex(dVar.field_username);
                            if (Ex != null) {
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().d(aeVar);
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().ad(Ex);
                            } else {
                                aeVar.ciy();
                                ar.Hg();
                                com.tencent.mm.z.c.Fd().d(aeVar);
                            }
                        }
                        ar.Hg();
                        if (com.tencent.mm.z.c.Fd().WY(dVar.field_enterpriseFather) == null) {
                            aeVar = new ae(dVar.field_enterpriseFather);
                            aeVar.ciy();
                            ar.Hg();
                            com.tencent.mm.z.c.Fd().d(aeVar);
                            return;
                        }
                        ar.Hg();
                        com.tencent.mm.z.c.Fc().Wt(dVar.field_enterpriseFather);
                        return;
                    }
                    dVar = this.kEC;
                    dVar.field_brandFlag |= 1;
                    a(dVar, true);
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().WX(dVar.field_username);
                    ar.Hg();
                    if (com.tencent.mm.z.c.Fd().Xi(dVar.field_enterpriseFather) <= 0) {
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().WX(dVar.field_enterpriseFather);
                        return;
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.Fc().Wt(dVar.field_enterpriseFather);
                    return;
                } else if (bjp == null || bjp.vNw == null) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                    return;
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(bjp.vNw.ret)});
                    return;
                }
            } else if (kVar.getType() == 1343) {
                bju();
                return;
            } else if (kVar.getType() == 1228) {
                bju();
                return;
            } else {
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
    }

    public final void c(LinkedList<cai> linkedList) {
        y.Mg().b((a) this);
        if (this.ilB == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, screen is null");
        } else if (this.jLe == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, contact is null");
        } else if (linkedList == null || linkedList.size() <= 0) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "onKFSceneEnd, worker is null");
        } else {
            if (!bh.ov(this.piR)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cai com_tencent_mm_protocal_c_cai = (cai) it.next();
                    if (com_tencent_mm_protocal_c_cai.wZT != null && com_tencent_mm_protocal_c_cai.wZT.equals(this.piR)) {
                        this.ilB.bk("contact_info_kf_worker", false);
                        this.ilB.YN("contact_info_kf_worker").setSummary(com_tencent_mm_protocal_c_cai.wvW);
                        return;
                    }
                }
            }
            this.ilB.bk("contact_info_kf_worker", false);
            this.ilB.YN("contact_info_kf_worker").setSummary(((cai) linkedList.get(0)).wvW);
        }
    }

    public final void a(int i, k kVar) {
        if (this.kEC != null && this.kEC.Lg() && kVar.getType() == 1354) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("contact_info_subscribe_bizinfo");
            this.piK = y.Mj().ca(y.Mj().cb(this.kEC.field_username));
            if (this.piK != null) {
                checkBoxPreference.tSw = !this.piK.ho(4);
                this.ilB.notifyDataSetChanged();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetBizInfo", "bizChatMyuser bizChatUserInfo is null after GetBizChatMyUserInfo");
        }
    }

    final boolean Hz(String str) {
        return str.equals("weixinsrc") || this.jLe.field_username.equalsIgnoreCase("gh_6e99ff560306");
    }

    public final String LX() {
        return "MicroMsg.ContactWidgetBizInfo";
    }

    private void bjy() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetBizInfo", "updatePlaceTop");
        if (this.gZO == null) {
            this.gZO = this.fmM.getSharedPreferences(this.fmM.getPackageName() + "_preferences", 0);
        }
        if (this.kZJ != null) {
            if (this.jLe != null) {
                this.gZO.edit().putBoolean("biz_placed_to_the_top", this.jLe.AL()).commit();
            } else {
                this.gZO.edit().putBoolean("biz_placed_to_the_top", false).commit();
            }
        }
        this.ilB.notifyDataSetChanged();
    }

    private static boolean uQ(int i) {
        if (i == 81 || i == 92 || i == 93 || i == 94) {
            return true;
        }
        return false;
    }
}
