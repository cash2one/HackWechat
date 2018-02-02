package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.f;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.q.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.4;
import com.tencent.mm.ui.base.TalkRoomPopupNav.5;
import com.tencent.mm.ui.base.TalkRoomPopupNav.8;
import com.tencent.mm.ui.base.TalkRoomPopupNav.9;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public final class aa implements f, l, q {
    public p fhr;
    public TalkRoomPopupNav yCh;
    public MultiTalkRoomPopupNav yCi;
    private a yCj = new 5(this);

    public aa(p pVar) {
        this.fhr = pVar;
    }

    public final void F(String str, String str2, String str3) {
        if (str.equals(this.fhr.csi().field_username)) {
            mO(false);
        }
    }

    public final void Rl(String str) {
        if (str.equals(this.fhr.csi().field_username)) {
            mO(false);
        }
    }

    public final void Rk(String str) {
        if (str.equals(this.fhr.csi().field_username)) {
            mO(false);
        }
    }

    private void a(a aVar) {
        if (this.yCh == null) {
            g.a(this.fhr.csq(), R.h.cVX);
            this.yCh = (TalkRoomPopupNav) this.fhr.csq().findViewById(R.h.cQh);
            if (this.yCh == null) {
                return;
            }
        }
        if (this.yCh != null) {
            this.yCh.yhq = aVar;
        }
    }

    public final void mO(boolean z) {
        if (!s.eV(this.fhr.csi().field_username) || this.fhr.csu()) {
            ctY();
            String str;
            if (com.tencent.mm.pluginsdk.q.a.vcw != null && com.tencent.mm.pluginsdk.q.a.vcw.DC(this.fhr.csi().field_username)) {
                a(this.yCj);
                if (this.yCh != null) {
                    List DA = com.tencent.mm.pluginsdk.q.a.vcw.DA(this.fhr.csi().field_username);
                    str = "";
                    if (DA == null || !DA.contains(this.fhr.csv())) {
                        this.yCh.EW(-1);
                        this.yCh.stop();
                        this.yCh.EU(R.g.bGV);
                        if (DA != null && DA.size() == 1) {
                            str = this.fhr.csq().getMMString(R.l.eRn, new Object[]{r.gu((String) DA.get(0))});
                        } else if (DA != null) {
                            str = this.fhr.csq().getMMString(R.l.eRp, new Object[]{Integer.valueOf(DA.size())});
                        }
                        this.yCh.EV(R.k.dBf);
                    } else {
                        this.yCh.EU(R.g.bGU);
                        str = this.fhr.csq().getMMString(R.l.eRo);
                        this.yCh.EV(R.k.dBg);
                        this.yCh.EW(R.k.dBh);
                        TalkRoomPopupNav talkRoomPopupNav = this.yCh;
                        if (talkRoomPopupNav.yhB == null || talkRoomPopupNav.yhC == null) {
                            talkRoomPopupNav.yhB = new AlphaAnimation(0.0f, 1.0f);
                            talkRoomPopupNav.yhB.setDuration(1000);
                            talkRoomPopupNav.yhB.setStartOffset(0);
                            talkRoomPopupNav.yhC = new AlphaAnimation(1.0f, 0.0f);
                            talkRoomPopupNav.yhC.setDuration(1000);
                            talkRoomPopupNav.yhC.setStartOffset(0);
                            talkRoomPopupNav.yhB.setAnimationListener(new 8(talkRoomPopupNav));
                            talkRoomPopupNav.yhC.setAnimationListener(new 9(talkRoomPopupNav));
                            talkRoomPopupNav.yhu.startAnimation(talkRoomPopupNav.yhB);
                        }
                    }
                    this.yCh.setVisibility(0);
                    this.yCh.YM(str);
                    this.fhr.FA(1);
                    return;
                }
                return;
            } else if (com.tencent.mm.pluginsdk.q.a.vcp != null && com.tencent.mm.pluginsdk.q.a.vcp.Mr(this.fhr.csi().field_username)) {
                a(this.yCj);
                b riVar = new ri();
                riVar.fJc.fJe = true;
                com.tencent.mm.sdk.b.a.xef.m(riVar);
                if (this.fhr.csi().field_username.equals(riVar.fJd.fJg)) {
                    this.yCh.EU(R.g.bGU);
                } else {
                    this.yCh.EU(R.g.bGV);
                }
                str = this.fhr.csq().getMMString(R.l.eQM, new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.q.a.vcp.Ms(this.fhr.csi().field_username).size())});
                this.yCh.EV(R.g.bGL);
                this.yCh.EW(-1);
                this.yCh.stop();
                this.yCh.setVisibility(0);
                this.yCh.YM(str);
                this.fhr.FA(1);
                return;
            } else if (!s.eV(this.fhr.csi().field_username) || com.tencent.mm.pluginsdk.q.a.vcx == null) {
                ctY();
                return;
            } else {
                com.tencent.mm.au.b FE = com.tencent.mm.pluginsdk.q.a.vcx.FE(this.fhr.csi().field_username);
                if (FE != null && FE.field_wxGroupId != null && FE.field_wxGroupId.equals(this.fhr.csi().field_username)) {
                    if (this.yCi == null) {
                        g.a(this.fhr.csq(), R.h.cVW);
                        this.yCi = (MultiTalkRoomPopupNav) this.fhr.csq().findViewById(R.h.cxZ);
                    }
                    if (this.yCi != null) {
                        x.i("MicroMsg.ChattingUI.TrackRoomImp", "show multiTalkBanner! ");
                        this.yCi.xLi = this.fhr.csi().field_username;
                        this.yCi.xLj = this.fhr.csv();
                        this.yCi.xLk = this.fhr.csu();
                        MultiTalkRoomPopupNav multiTalkRoomPopupNav = this.yCi;
                        multiTalkRoomPopupNav.xLp = false;
                        if (multiTalkRoomPopupNav.xLi == null || multiTalkRoomPopupNav.xLj == null) {
                            x.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.xLi + ",currentSenderUserName:" + multiTalkRoomPopupNav.xLj);
                        } else {
                            String str2 = multiTalkRoomPopupNav.xLi;
                            if (com.tencent.mm.pluginsdk.q.a.vcx == null || !com.tencent.mm.pluginsdk.q.a.vcx.Fs(str2)) {
                                multiTalkRoomPopupNav.cnv();
                            } else {
                                List Fu = com.tencent.mm.pluginsdk.q.a.vcx.Fu(str2);
                                if (Fu.size() == 0) {
                                    com.tencent.mm.pluginsdk.q.a.vcx.iF(str2);
                                    multiTalkRoomPopupNav.cnv();
                                } else {
                                    int dr = com.tencent.mm.pluginsdk.q.a.vcx.dr(str2, multiTalkRoomPopupNav.xLj);
                                    if (dr == 1) {
                                        multiTalkRoomPopupNav.xLl = MultiTalkRoomPopupNav.b.xLt;
                                        if (com.tencent.mm.pluginsdk.q.a.vcx.Fv(str2)) {
                                            multiTalkRoomPopupNav.cnv();
                                        } else {
                                            CharSequence gu = com.tencent.mm.pluginsdk.q.a.vcx.gu(com.tencent.mm.pluginsdk.q.a.vcx.dq(str2, multiTalkRoomPopupNav.xLj));
                                            multiTalkRoomPopupNav.xLe.setBackgroundResource(R.g.bDQ);
                                            multiTalkRoomPopupNav.xLg.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.btm));
                                            multiTalkRoomPopupNav.xLg.setText(gu);
                                            multiTalkRoomPopupNav.xLf.setVisibility(8);
                                            multiTalkRoomPopupNav.xLh.setVisibility(0);
                                            multiTalkRoomPopupNav.xLg.setVisibility(0);
                                            multiTalkRoomPopupNav.xLo.setVisibility(8);
                                        }
                                    } else if (dr == 10) {
                                        multiTalkRoomPopupNav.xLl = MultiTalkRoomPopupNav.b.xLu;
                                        if (com.tencent.mm.pluginsdk.q.a.vcx.Fv(str2)) {
                                            multiTalkRoomPopupNav.cnv();
                                        } else if (com.tencent.mm.pluginsdk.q.a.vcx.bct()) {
                                            multiTalkRoomPopupNav.cnv();
                                        } else {
                                            multiTalkRoomPopupNav.xLl = MultiTalkRoomPopupNav.b.xLv;
                                            multiTalkRoomPopupNav.Yq(ac.getContext().getString(R.l.ewC, new Object[]{Integer.valueOf(Fu.size())}));
                                        }
                                    } else {
                                        multiTalkRoomPopupNav.xLl = MultiTalkRoomPopupNav.b.xLv;
                                        multiTalkRoomPopupNav.Yq(ac.getContext().getString(R.l.ewC, new Object[]{Integer.valueOf(Fu.size())}));
                                    }
                                    multiTalkRoomPopupNav.setVisibility(0);
                                    multiTalkRoomPopupNav.xLd.setVisibility(0);
                                    multiTalkRoomPopupNav.xLe.setVisibility(0);
                                    if (multiTalkRoomPopupNav.xLm != null && (z || multiTalkRoomPopupNav.xLo == null || multiTalkRoomPopupNav.xLo.getVisibility() != 0)) {
                                        MultiTalkRoomPopupNav.a.a(multiTalkRoomPopupNav.xLm);
                                    }
                                    multiTalkRoomPopupNav.cX(MultiTalkRoomPopupNav.l(Fu, ""));
                                }
                            }
                        }
                        this.yCi.xLq = FE;
                        this.fhr.FA(1);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (this.yCh != null) {
            this.yCh.setVisibility(8);
            this.fhr.FA(-1);
        }
        if (this.yCi != null) {
            this.yCi.xLk = this.fhr.csu();
            this.yCi.setVisibility(8);
        }
    }

    private void ctY() {
        if (this.yCh != null) {
            this.yCh.setVisibility(8);
            this.yCh.EW(-1);
            this.yCh.stop();
            this.fhr.FA(-1);
        }
        if (this.yCi != null) {
            if (!com.tencent.mm.pluginsdk.q.a.vcx.Fs(this.fhr.crz())) {
                this.yCi.cnv();
            }
            this.yCi.setVisibility(8);
            this.fhr.FA(-1);
        }
    }

    public final void mP(boolean z) {
        if (!this.fhr.csi().field_username.toLowerCase().endsWith("@chatroom") || this.fhr.csu()) {
            b riVar = new ri();
            riVar.fJc.fJe = true;
            com.tencent.mm.sdk.b.a.xef.m(riVar);
            if (z) {
                if (bh.ov(riVar.fJd.fJg) || this.fhr.csi().field_username.equals(riVar.fJd.fJg)) {
                    Zk(this.fhr.csi().field_username);
                    return;
                } else if (this.yCh == null || this.yCh.getVisibility() != 0) {
                    h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eQu), null, new 10(this), new 11(this));
                    return;
                } else {
                    TalkRoomPopupNav talkRoomPopupNav = this.yCh;
                    ((TextView) talkRoomPopupNav.findViewById(R.h.cTg)).setText(this.fhr.csq().getMMString(R.l.eQu));
                    talkRoomPopupNav = this.yCh;
                    if (talkRoomPopupNav.yhv == null) {
                        talkRoomPopupNav.yhv = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yhx) * 1.0f) / ((float) talkRoomPopupNav.yhy), 1.0f);
                        talkRoomPopupNav.yhv.setDuration(300);
                        talkRoomPopupNav.yhv.setAnimationListener(new 4(talkRoomPopupNav));
                    }
                    if (talkRoomPopupNav.yhw == null) {
                        talkRoomPopupNav.yhw = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.bqa);
                        talkRoomPopupNav.yhw.setFillAfter(true);
                        talkRoomPopupNav.yhw.setAnimationListener(new 5(talkRoomPopupNav));
                    }
                    LayoutParams layoutParams = talkRoomPopupNav.myK.getLayoutParams();
                    layoutParams.height = talkRoomPopupNav.yhy;
                    talkRoomPopupNav.myK.setLayoutParams(layoutParams);
                    talkRoomPopupNav.myK.startAnimation(talkRoomPopupNav.yhv);
                    talkRoomPopupNav.xLd.startAnimation(talkRoomPopupNav.yhw);
                    talkRoomPopupNav.yhr.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.bpZ));
                    talkRoomPopupNav.yhr.setVisibility(0);
                    return;
                }
            } else if (com.tencent.mm.pluginsdk.q.a.vcw != null && com.tencent.mm.pluginsdk.q.a.vcw.DC(this.fhr.csi().field_username)) {
                String mMString;
                int i;
                List DA = com.tencent.mm.pluginsdk.q.a.vcw.DA(this.fhr.csi().field_username);
                if (DA == null || !DA.contains(this.fhr.csv())) {
                    mMString = this.fhr.csq().getMMString(R.l.eQz);
                    i = R.l.esp;
                } else {
                    mMString = this.fhr.csq().getMMString(R.l.eQy);
                    i = R.l.ebC;
                }
                g.pQN.h(10997, new Object[]{Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                i.a aVar = new i.a(this.fhr.csq().getContext());
                aVar.YG(mMString);
                aVar.EC(R.l.dEn).a(new 6(this));
                aVar.ED(i).b(new 7(this, z));
                aVar.akx().show();
                return;
            } else if (bh.ov(riVar.fJd.fJg) || this.fhr.csi().field_username.equals(riVar.fJd.fJg)) {
                Zk(this.fhr.csi().field_username);
                return;
            } else {
                h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eQu), null, new 8(this), new OnClickListener(this) {
                    final /* synthetic */ aa yCl;

                    {
                        this.yCl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
        }
        h.b(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.eQD), null, true);
    }

    public final void bm(String str, boolean z) {
        if ((com.tencent.mm.pluginsdk.q.a.vcw != null && com.tencent.mm.pluginsdk.q.a.vcw.DC(this.fhr.csi().field_username)) || z) {
            List DA = com.tencent.mm.pluginsdk.q.a.vcw.DA(this.fhr.csi().field_username);
            if (DA == null || !DA.contains(this.fhr.csv())) {
                g.pQN.h(10997, new Object[]{Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                h.a(this.fhr.csq().getContext(), this.fhr.csq().getMMString(R.l.ebF), null, new 2(this, str), new 3(this));
                return;
            }
        }
        Zj(str);
    }

    public final void Zj(String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 6);
        intent.putExtra("map_sender_name", this.fhr.csv());
        intent.putExtra("map_talker_name", this.fhr.crz());
        intent.putExtra("fromWhereShare", str);
        d.b(this.fhr.csq().getContext(), "location", ".ui.RedirectUI", intent);
    }

    final void Zk(String str) {
        Intent intent = new Intent();
        intent.putExtra("enter_room_username", str);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        d.b(this.fhr.csq().getContext(), "talkroom", ".ui.TalkRoomUI", intent);
    }
}
