package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import java.util.ArrayList;
import java.util.List;

public final class t implements e {
    final Context context;
    int fqb;
    int fqc;
    public int ktJ = 0;
    c msq = new 10(this);
    m qyg;
    String rsC;
    String rsF;
    boolean rsG = false;
    c rsI = new c<kg>(this) {
        final /* synthetic */ t rtq;

        {
            this.rtq = r2;
            this.xen = kg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kg kgVar = (kg) bVar;
            if (kgVar == null || !(kgVar instanceof kg)) {
                x.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                x.i("MicroMsg.GalleryTitleManager", "notify Event: %d", new Object[]{Integer.valueOf(kgVar.fBC.fBA)});
                if (!(kgVar.fBC.activity == ((Activity) this.rtq.context) && kgVar.fBC.fov.equals(this.rtq.rsF))) {
                    x.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            return false;
        }
    };
    SnsCmdList rti = new SnsCmdList();
    private final a rtj;
    g rtk = null;
    boolean rtl;
    aqr rtm;
    private final String rtn;
    public r tipDialog = null;
    String uT;

    static /* synthetic */ void LQ(String str) {
        b qmVar = new qm();
        qmVar.fHY.fuL = 3;
        qmVar.fHY.fus = str;
        a.xef.m(qmVar);
    }

    static /* synthetic */ void LR(String str) {
        b qmVar = new qm();
        qmVar.fHY.fuL = 1;
        qmVar.fHY.fIb = 2;
        qmVar.fHY.fus = str;
        a.xef.m(qmVar);
    }

    static /* synthetic */ void a(t tVar, Bundle bundle) {
        x.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        b bzVar = new bz();
        bzVar.fqa.activity = (Activity) tVar.context;
        bzVar.fqa.fov = tVar.rsF;
        bzVar.fqa.fqb = tVar.fqb;
        bzVar.fqa.fqc = tVar.fqc;
        bzVar.fqa.fqh = bundle;
        a.xef.m(bzVar);
    }

    static /* synthetic */ void a(t tVar, m mVar, aqr com_tencent_mm_protocal_c_aqr) {
        if (mVar == null) {
            x.i("MicroMsg.GalleryTitleManager", "error beacause info null");
        } else if (mVar.field_type == 1) {
            r1 = new cf();
            com.tencent.mm.plugin.sns.i.a.a(r1, mVar, com_tencent_mm_protocal_c_aqr.nGJ);
            r1.fqp.activity = (Activity) tVar.context;
            r1.fqp.fqw = 15;
            a.xef.m(r1);
        } else if (mVar == null) {
        } else {
            if (mVar.xl(32)) {
                r1 = new cf();
                com.tencent.mm.plugin.sns.i.a.a(r1, mVar);
                r1.fqp.activity = (Activity) tVar.context;
                r1.fqp.fqw = 16;
                a.xef.m(r1);
                return;
            }
            String byq = mVar.byq();
            r1 = new qm();
            r1.fHY.fuL = 2;
            r1.fHY.fHZ = 16;
            r1.fHY.fIa = false;
            r1.fHY.fus = byq;
            a.xef.m(r1);
        }
    }

    static /* synthetic */ void a(t tVar, m mVar, aqr com_tencent_mm_protocal_c_aqr, int i) {
        if (mVar == null) {
            x.e("MicroMsg.GalleryTitleManager", "error beacause info null");
            return;
        }
        Intent intent = new Intent();
        if (mVar.field_type == 1) {
            intent.putExtra("sns_send_data_ui_image_path", FlipView.f(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.l(com_tencent_mm_protocal_c_aqr), tVar.context));
            intent.putExtra("sns_send_data_ui_image_position", i);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", mVar.byq());
        d.a(tVar.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
    }

    public final void xr(int i) {
        if (i != 0) {
            this.rti.wt(i);
        }
    }

    public t(Context context, a aVar) {
        this.context = context;
        this.rtj = aVar;
        this.rtn = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
    }

    public final void bzp() {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rti);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
    }

    public final void a(boolean z, final m mVar, final aqr com_tencent_mm_protocal_c_aqr, boolean z2, final int i) {
        b dhVar;
        this.rtl = z;
        this.qyg = mVar;
        this.rtm = com_tencent_mm_protocal_c_aqr;
        this.uT = com_tencent_mm_protocal_c_aqr.nGJ;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (!z) {
            mVar.bxV();
            arrayList.add(this.context.getString(j.ePW));
            arrayList2.add(Integer.valueOf(3));
            if (d.OQ("favorite")) {
                arrayList.add(this.context.getString(j.eAd));
                arrayList2.add(Integer.valueOf(6));
            }
            if (mVar.field_type == 15 || mVar.field_type == 5) {
                arrayList.add(this.context.getString(j.eHh));
                arrayList2.add(Integer.valueOf(2));
            } else if (mVar.field_type == 1) {
                arrayList.add(this.context.getString(j.eHe));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.qMa));
                arrayList2.add(Integer.valueOf(2));
            }
            dhVar = new dh();
            dhVar.frQ.frH = mVar.byq();
            a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                arrayList.add(this.context.getString(j.qJu));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.rsF != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.az(this.fqb, this.rsF) ? this.context.getString(j.eCr) : this.context.getString(j.eCq));
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.rtk == null || !this.rsG) {
                    this.rtk = new g(this.context, g.ztp, false);
                } else {
                    this.rsG = false;
                }
                this.rtk.rKC = new 5(this, arrayList, arrayList2);
                this.rtk.rKD = new 6(this, mVar, com_tencent_mm_protocal_c_aqr, i);
                this.rtk.bUk();
            }
        } else if (mVar != null) {
            if (mVar.field_localPrivate > 0) {
                if (!bh.ov(ae.bvb()) && ae.bvb().equals(mVar.field_userName)) {
                    arrayList.add(this.context.getString(j.qMf));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(j.ePW));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(j.qMg));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(j.ePW));
                arrayList2.add(Integer.valueOf(3));
            }
            if (d.OQ("favorite")) {
                arrayList.add(this.context.getString(j.eAd));
                arrayList2.add(Integer.valueOf(6));
            }
            if (mVar.field_type == 15 || mVar.field_type == 5) {
                arrayList.add(this.context.getString(j.eHh));
                arrayList2.add(Integer.valueOf(2));
            } else if (mVar.field_type == 1) {
                arrayList.add(this.context.getString(j.eHe));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.qMa));
                arrayList2.add(Integer.valueOf(2));
            }
            dhVar = new dh();
            dhVar.frQ.frH = mVar.byq();
            a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                arrayList.add(this.context.getString(j.qJu));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.rsF != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.az(this.fqb, this.rsF) ? this.context.getString(j.eCr) : this.context.getString(j.eCq));
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.rtk == null || !this.rsG) {
                this.rtk = new g(this.context, g.ztp, false);
            } else {
                this.rsG = false;
            }
            this.rtk.rKC = new 1(this, arrayList, arrayList2);
            this.rtk.rKD = new p.d(this) {
                final /* synthetic */ t rtq;

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    x.d("MicroMsg.GalleryTitleManager", "showAlertWithDel " + itemId);
                    t tVar;
                    k qVar;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (mVar.bxV().wQo.vYd.size() > 1) {
                                h.a(this.rtq.context, this.rtq.context.getString(j.qLQ), "", new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass3 rts;

                                    {
                                        this.rts = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.rts.rtq.A(mVar);
                                    }
                                }, null);
                                return;
                            } else {
                                h.a(this.rtq.context, this.rtq.context.getString(j.qLO), "", new 2(this), null);
                                return;
                            }
                        case 1:
                            tVar = this.rtq;
                            m mVar = mVar;
                            if (mVar.byr() || mVar.bys()) {
                                ae.bvv().xp(mVar.roJ);
                                return;
                            }
                            qVar = new q(mVar.field_snsId, 2);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(qVar, 0);
                            context = tVar.context;
                            tVar.context.getString(j.dGO);
                            tVar.tipDialog = h.a(context, tVar.context.getString(j.qMd), true, new 8(tVar, qVar));
                            return;
                        case 2:
                            if (mVar != null && mVar.bxV().wQo != null) {
                                if (mVar.field_type != 15) {
                                    com.tencent.mm.pluginsdk.ui.tools.k.h(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.l(com_tencent_mm_protocal_c_aqr), this.rtq.context);
                                    return;
                                } else {
                                    t.LQ(mVar.byq());
                                    return;
                                }
                            }
                            return;
                        case 3:
                            if (mVar != null && mVar.bxV().wQo != null) {
                                if (mVar.bxV().wQo.vYc == 1) {
                                    this.rtq.LP(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.l(com_tencent_mm_protocal_c_aqr));
                                    return;
                                }
                                t.LR(mVar.byq());
                                return;
                            }
                            return;
                        case 5:
                            tVar = this.rtq;
                            qVar = new q(mVar.field_snsId, 3);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(qVar, 0);
                            context = tVar.context;
                            tVar.context.getString(j.dGO);
                            tVar.tipDialog = h.a(context, tVar.context.getString(j.qMd), true, new 9(tVar, qVar));
                            return;
                        case 6:
                            if (mVar != null && mVar.bxV().wQo != null) {
                                t.a(this.rtq, mVar, com_tencent_mm_protocal_c_aqr);
                                return;
                            }
                            return;
                        case 7:
                            Bundle bundle = new Bundle();
                            bundle.putString("stat_msg_id", "sns_" + i.eq(mVar.field_snsId));
                            bundle.putString("stat_send_msg_user", mVar.field_userName);
                            bundle.putInt("stat_scene", 3);
                            t.a(this.rtq, bundle);
                            return;
                        case 8:
                            t.a(this.rtq, mVar, com_tencent_mm_protocal_c_aqr, i);
                            return;
                        default:
                            return;
                    }
                }
            };
            this.rtk.ztB = new g.a(this) {
                final /* synthetic */ t rtq;

                {
                    this.rtq = r1;
                }

                public final void onDismiss() {
                    b akVar = new ak();
                    akVar.fow.filePath = this.rtq.rsC;
                    a.xef.m(akVar);
                    this.rtq.rtk = null;
                    this.rtq.rsC = null;
                    this.rtq.qyg = null;
                    this.rtq.uT = null;
                    this.rtq.rsF = null;
                    t tVar = this.rtq;
                    this.rtq.fqc = 0;
                    tVar.fqb = 0;
                }
            };
            this.rtk.bUk();
        } else {
            return;
        }
        if (true == z2) {
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Di().gPJ.Km() != 0) {
                dhVar = new mp();
                String str = am.r(ae.getAccSnsPath(), this.uT) + i.l(com_tencent_mm_protocal_c_aqr);
                dhVar.fEA.filePath = str;
                this.rsC = str;
                a.xef.m(dhVar);
            }
        }
    }

    protected final void A(m mVar) {
        if (mVar.byr() || mVar.bys()) {
            ae.bvv().xp(mVar.roJ);
            this.rti.wt(mVar.roJ);
            return;
        }
        ae.bvu().eD(mVar.field_snsId);
        k qVar = new q(mVar.field_snsId, 1);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(qVar, 0);
        Context context = this.context;
        this.context.getString(j.dGO);
        this.tipDialog = h.a(context, this.context.getString(j.qKt), true, new 7(this, qVar));
    }

    protected final void LP(String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.c.a.ifs.l(intent, this.context);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && kVar != null) {
            x.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            q qVar = (q) kVar;
            switch (qVar.type) {
                case -1:
                    this.rtj.ch("", qVar.type);
                    return;
                case 1:
                    this.rti.wt(qVar.qQY);
                    this.rtj.ch(u.ac("sns_table_", (long) qVar.qQY), qVar.type);
                    return;
                case 2:
                    this.rti.wu(qVar.qQY);
                    this.rtj.ch("", qVar.type);
                    return;
                case 3:
                    this.rti.wu(qVar.qQY);
                    this.rtj.ch(u.ac("sns_table_", (long) qVar.qQY), qVar.type);
                    return;
                default:
                    return;
            }
        }
    }
}
