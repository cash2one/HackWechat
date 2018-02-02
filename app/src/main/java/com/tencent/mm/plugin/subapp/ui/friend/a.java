package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bf.b;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.l;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class a implements OnItemClickListener {
    private Context context;
    private boolean hmn = false;
    private b rWO;

    public a(Context context, b bVar, boolean z) {
        this.context = context;
        this.rWO = bVar;
        this.hmn = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.hmn) {
            i--;
        }
        b bVar = (b) this.rWO.getItem(i);
        if (bVar == null) {
            x.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = " + i);
        } else {
            g(this.context, bVar.field_talker, false);
        }
    }

    public static void g(Context context, String str, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            return;
        }
        x.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = " + str);
        l.Tx().mS(str);
        f mX = l.Tw().mX(str);
        if (mX == null) {
            x.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = " + str);
        } else if (mX.field_type == 0) {
            ar.Hg();
            com.tencent.mm.storage.au.a EK = c.Fa().EK(mX.field_msgContent);
            if (EK != null && EK.rYX.length() > 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("Contact_ShowFMessageList", true);
                bundle.putInt("Contact_Source_FMessage", EK.scene);
                ar.Hg();
                com.tencent.mm.storage.x WO = c.EY().WO(EK.rYX);
                if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                    com.tencent.mm.plugin.subapp.b.ift.a(context, WO, EK, bundle, "");
                } else if (EK.pjS > 0) {
                    if (bh.ov(EK.hwZ) && bh.ov(EK.hwW) && !bh.ov(EK.fpL)) {
                        bundle.putString("Contact_QQNick", EK.fpL);
                    }
                    com.tencent.mm.plugin.subapp.b.ift.a(context, EK, bundle);
                } else if (bh.ov(EK.xzj) && bh.ov(EK.xzk)) {
                    com.tencent.mm.plugin.subapp.b.ift.a(context, EK, bundle);
                } else {
                    com.tencent.mm.modelfriend.b kS = af.OD().kS(EK.xzj);
                    if (kS == null || kS.Nr() == null || kS.Nr().length() <= 0) {
                        kS = af.OD().kS(EK.xzk);
                        if (kS == null || kS.Nr() == null || kS.Nr().length() <= 0) {
                            if (WO == null || ((int) WO.gJd) <= 0) {
                                com.tencent.mm.plugin.subapp.b.ift.a(context, EK, bundle);
                            } else {
                                com.tencent.mm.plugin.subapp.b.ift.a(context, WO, EK, bundle, "");
                            }
                            x.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + EK.xzj + " fullMD5:" + EK.xzk);
                            return;
                        }
                    }
                    if (kS.getUsername() == null || kS.getUsername().length() <= 0) {
                        kS.username = EK.rYX;
                        kS.fDt = FileUtils.S_IWUSR;
                        if (af.OD().a(kS.Nr(), kS) == -1) {
                            x.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                            return;
                        }
                    }
                    com.tencent.mm.plugin.subapp.b.ift.a(context, EK, bundle);
                }
            }
        } else {
            a(context, mX, z);
        }
    }

    public static void a(Context context, f fVar, boolean z) {
        String str = fVar.field_msgContent;
        x.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : " + str);
        if (str != null && str.length() > 0) {
            ar.Hg();
            d EJ = c.Fa().EJ(str);
            if (EJ != null && !bh.ov(EJ.rYX)) {
                Assert.assertTrue(EJ.rYX.length() > 0);
                ar.Hg();
                com.tencent.mm.g.b.af WO = c.EY().WO(EJ.rYX);
                Intent intent = new Intent();
                if (z) {
                    intent.putExtra("Accept_NewFriend_FromOutside", true);
                }
                intent.putExtra("Contact_ShowUserName", false);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Scene", EJ.scene);
                intent.putExtra("Verify_ticket", EJ.mOi);
                intent.putExtra("Contact_Source_FMessage", EJ.scene);
                if (WO == null || ((int) WO.gJd) <= 0 || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                    if (fVar.field_type == 1 || fVar.field_type == 2) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_User", EJ.rYX);
                    intent.putExtra("Contact_Alias", EJ.gfN);
                    intent.putExtra("Contact_Nick", EJ.fpL);
                    intent.putExtra("Contact_QuanPin", EJ.hwV);
                    intent.putExtra("Contact_PyInitial", EJ.hwU);
                    intent.putExtra("Contact_Sex", EJ.fWf);
                    intent.putExtra("Contact_Signature", EJ.signature);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", EJ.getCity());
                    intent.putExtra("Contact_Province", EJ.getProvince());
                    intent.putExtra("Contact_Mobile_MD5", EJ.xzj);
                    intent.putExtra("Contact_full_Mobile_MD5", EJ.xzk);
                    intent.putExtra("Contact_KSnsBgUrl", EJ.xzt);
                } else {
                    intent.putExtra("Contact_User", WO.field_username);
                    com.tencent.mm.plugin.subapp.b.ift.a(intent, WO.field_username);
                }
                str = EJ.content;
                if (bh.ou(str).length() <= 0) {
                    switch (EJ.scene) {
                        case 18:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            str = context.getString(R.l.dRf);
                            break;
                        default:
                            str = context.getString(R.l.dRb);
                            break;
                    }
                }
                intent.putExtra("Contact_Content", str);
                if (EJ.xzv == 1 && !bh.ov(EJ.xzx)) {
                    intent.putExtra("Safety_Warning_Detail", EJ.xzx);
                }
                intent.putExtra("Contact_verify_Scene", EJ.scene);
                if ((EJ.scene == 14 || EJ.scene == 8) && !bh.ov(EJ.chatroomName)) {
                    ar.Hg();
                    q hD = c.Fh().hD(EJ.chatroomName);
                    if (hD != null) {
                        intent.putExtra("Contact_RoomNickname", hD.gu(EJ.rYX));
                    }
                }
                intent.putExtra("Contact_Uin", EJ.pjS);
                intent.putExtra("Contact_QQNick", EJ.hwW);
                intent.putExtra("Contact_Mobile_MD5", EJ.xzj);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                    intent.putExtra("Contact_KSnsIFlag", 0);
                }
                intent.putExtra("Contact_KSnsBgUrl", EJ.xzt);
                intent.putExtra("verify_gmail", EJ.pjU);
                intent.putExtra("source_from_user_name", EJ.vmS);
                intent.putExtra("source_from_nick_name", EJ.vmT);
                com.tencent.mm.bm.d.b(context, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }
}
