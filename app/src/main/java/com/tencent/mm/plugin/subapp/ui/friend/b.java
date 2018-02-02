package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b extends o<com.tencent.mm.bf.b> {
    private Context context;
    private OnClickListener rWP = new 2(this);
    private OnClickListener rWQ = new OnClickListener(this) {
        final /* synthetic */ b rWR;

        {
            this.rWR = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                x.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                f mX = l.Tw().mX(bVar.username);
                if (mX == null || mX.field_msgContent == null) {
                    x.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + bVar.username);
                    return;
                }
                d Xu = d.Xu(mX.field_msgContent);
                x.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (Xu.xzv == 1) {
                    h.a(this.rWR.context, Xu.xzw, null, this.rWR.context.getString(R.l.eih), this.rWR.context.getString(R.l.dEn), true, new 1(this, mX), null);
                    return;
                }
                ar.Hg();
                bf EZ = c.EZ().EZ(bVar.username);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", bVar.username);
                intent.putExtra("Contact_Nick", bVar.fpL);
                if (EZ != null) {
                    intent.putExtra("Contact_RemarkName", EZ.field_conRemark);
                }
                if (!bh.ov(Xu.chatroomName)) {
                    ar.Hg();
                    q hD = c.Fh().hD(Xu.chatroomName);
                    if (hD != null) {
                        intent.putExtra("Contact_RoomNickname", hD.gu(Xu.rYX));
                    }
                }
                intent.putExtra("Contact_Scene", Xu.scene);
                intent.putExtra("Verify_ticket", Xu.mOi);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                intent.putExtra("sayhi_with_jump_to_profile", true);
                com.tencent.mm.bm.d.b(this.rWR.context, "profile", ".ui.SayHiWithSnsPermissionUI", intent);
            }
        }
    };

    static class a {
        public TextView pjY;
        public MaskLayout rWX;
        public Button rWY;
        public Button rWZ;
        public TextView rXa;
        public TextView rXb;
        public TextView rXc;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.bf.b) obj;
        if (obj == null) {
            obj = new com.tencent.mm.bf.b();
        }
        obj.b(cursor);
        return obj;
    }

    static /* synthetic */ void a(b bVar, String str) {
        if (bVar.context instanceof FMessageConversationUI) {
            ag.h(new 4(bVar, str), 200);
        }
    }

    public b(Context context) {
        super(context, new com.tencent.mm.bf.b());
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.dis, null);
            a aVar2 = new a();
            aVar2.rWX = (MaskLayout) view.findViewById(R.h.ciu);
            aVar2.pjY = (TextView) view.findViewById(R.h.cix);
            aVar2.rXc = (TextView) view.findViewById(R.h.civ);
            aVar2.rWY = (Button) view.findViewById(R.h.cir);
            aVar2.rWY.setOnClickListener(this.rWP);
            aVar2.rWZ = (Button) view.findViewById(R.h.ciA);
            aVar2.rWZ.setOnClickListener(this.rWQ);
            aVar2.rXa = (TextView) view.findViewById(R.h.ciy);
            aVar2.rXb = (TextView) view.findViewById(R.h.cit);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.bf.b bVar = (com.tencent.mm.bf.b) getItem(i);
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar.rWX.view, bVar.field_talker);
        aVar.pjY.setText(i.b(this.context, bVar.field_displayName, aVar.pjY.getTextSize()));
        com.tencent.mm.pluginsdk.ui.preference.b a;
        af WO;
        f mX;
        int i2;
        View findViewById;
        int i3;
        if (bVar.field_fmsgSysRowId <= 0) {
            x.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
            f mW = l.Tw().mW(bVar.field_talker);
            if (mW == null) {
                x.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + bVar.field_talker);
                aVar.rWY.setVisibility(8);
                aVar.rWZ.setVisibility(8);
                aVar.rXa.setVisibility(8);
                aVar.rXb.setVisibility(8);
                aVar.rXc.setVisibility(8);
            } else {
                a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, mW);
                x.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + bVar.field_talker);
                if (bVar.field_state == 1) {
                    ar.Hg();
                    WO = c.EY().WO(bVar.field_talker);
                    if (!(WO == null || ((int) WO.gJd) == 0 || com.tencent.mm.l.a.fZ(WO.field_type))) {
                        l.Tx().T(bVar.field_talker, 0);
                    }
                }
                if (a != null) {
                    x.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + bVar.field_talker);
                    aVar.rWY.setVisibility(8);
                    aVar.rWZ.setVisibility(8);
                    aVar.rXa.setVisibility(8);
                    aVar.rXb.setVisibility(8);
                    aVar.rXc.setVisibility(8);
                } else {
                    a.qra = bVar.field_addScene;
                    aVar.rXc.setText(i.b(this.context, a.hef, aVar.rXc.getTextSize()));
                    switch (bVar.field_state) {
                        case 0:
                            if (bVar.field_fmsgSysRowId > 0) {
                                x.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                                mX = l.Tw().mX(a.username);
                                i2 = mX != null ? 0 : mX.field_type;
                            } else {
                                i2 = bVar.field_recvFmsgType;
                            }
                            if (i2 != 0 || i2 == 3) {
                                aVar.rWY.setVisibility(0);
                                aVar.rWY.setTag(a);
                                aVar.rWZ.setVisibility(8);
                            } else {
                                aVar.rWZ.setVisibility(0);
                                aVar.rWZ.setTag(a);
                                aVar.rWY.setVisibility(8);
                            }
                            aVar.rXa.setVisibility(8);
                            aVar.rXb.setVisibility(8);
                            break;
                        case 1:
                            aVar.rXb.setVisibility(0);
                            aVar.rWY.setVisibility(8);
                            aVar.rWZ.setVisibility(8);
                            aVar.rXa.setVisibility(8);
                            break;
                        case 2:
                            aVar.rXa.setVisibility(0);
                            aVar.rWY.setVisibility(8);
                            aVar.rWZ.setVisibility(8);
                            aVar.rXb.setVisibility(8);
                            break;
                        default:
                            aVar.rWY.setVisibility(8);
                            aVar.rWZ.setVisibility(8);
                            aVar.rXa.setVisibility(8);
                            aVar.rXb.setVisibility(8);
                            break;
                    }
                    findViewById = view.findViewById(R.h.ciw);
                    if (bVar.field_isNew != 0) {
                        i3 = R.g.bDH;
                    } else {
                        i3 = R.g.bBw;
                    }
                    findViewById.setBackgroundResource(i3);
                }
            }
        } else {
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, bVar.field_fmsgSysRowId, bVar.field_fmsgIsSend % 2 == 0, bVar.field_talker, bVar.field_fmsgContent, bVar.field_fmsgType, bVar.field_contentFromUsername, bVar.field_contentNickname, bVar.field_contentPhoneNumMD5, bVar.field_contentFullPhoneNumMD5, bVar.field_contentVerifyContent, bVar.field_addScene);
            x.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + bVar.field_fmsgSysRowId + ", talker = " + bVar.field_talker);
            if (bVar.field_state == 1) {
                ar.Hg();
                WO = c.EY().WO(bVar.field_talker);
                l.Tx().T(bVar.field_talker, 0);
            }
            if (a != null) {
                a.qra = bVar.field_addScene;
                aVar.rXc.setText(i.b(this.context, a.hef, aVar.rXc.getTextSize()));
                switch (bVar.field_state) {
                    case 0:
                        if (bVar.field_fmsgSysRowId > 0) {
                            i2 = bVar.field_recvFmsgType;
                        } else {
                            x.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                            mX = l.Tw().mX(a.username);
                            if (mX != null) {
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                        aVar.rWY.setVisibility(0);
                        aVar.rWY.setTag(a);
                        aVar.rWZ.setVisibility(8);
                        aVar.rXa.setVisibility(8);
                        aVar.rXb.setVisibility(8);
                        break;
                    case 1:
                        aVar.rXb.setVisibility(0);
                        aVar.rWY.setVisibility(8);
                        aVar.rWZ.setVisibility(8);
                        aVar.rXa.setVisibility(8);
                        break;
                    case 2:
                        aVar.rXa.setVisibility(0);
                        aVar.rWY.setVisibility(8);
                        aVar.rWZ.setVisibility(8);
                        aVar.rXb.setVisibility(8);
                        break;
                    default:
                        aVar.rWY.setVisibility(8);
                        aVar.rWZ.setVisibility(8);
                        aVar.rXa.setVisibility(8);
                        aVar.rXb.setVisibility(8);
                        break;
                }
                findViewById = view.findViewById(R.h.ciw);
                if (bVar.field_isNew != 0) {
                    i3 = R.g.bBw;
                } else {
                    i3 = R.g.bDH;
                }
                findViewById.setBackgroundResource(i3);
            } else {
                x.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + bVar.field_talker);
                aVar.rWY.setVisibility(8);
                aVar.rWZ.setVisibility(8);
                aVar.rXa.setVisibility(8);
                aVar.rXb.setVisibility(8);
                aVar.rXc.setVisibility(8);
            }
        }
        return view;
    }

    public final void Xy() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(l.Tx().Tj());
            notifyDataSetChanged();
            return;
        }
        ag.y(new Runnable(this) {
            final /* synthetic */ b rWR;

            {
                this.rWR = r1;
            }

            public final void run() {
                this.rWR.setCursor(l.Tx().Tj());
                this.rWR.notifyDataSetChanged();
            }
        });
    }

    protected final void Xz() {
        aUn();
        Xy();
    }
}
