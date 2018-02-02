package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.google.a.a.e;
import com.tencent.mm.R;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.au.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private Map<String, Long> oGE = new ConcurrentHashMap();

    final void a(String str, a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner msg:" + a + " buffer len " + decode.length);
        try {
            bb bbVar = (bb) e.a(new bb(), decode, decode.length);
            if (bbVar == null) {
                x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  is null! xml:" + a);
            } else if (this.oGE.get(bbVar.groupId) == null || ((Long) this.oGE.get(bbVar.groupId)).longValue() < bbVar.zQf) {
                this.oGE.put(bbVar.groupId, Long.valueOf(bbVar.zQf));
                bw bwVar = aVar.hmq;
                String a2 = n.a(bwVar.vGX);
                String a3 = n.a(bwVar.vGY);
                ar.Hg();
                String str2 = (String) c.CU().get(2, null);
                if (str2 == null) {
                    x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "userName is null");
                    return;
                }
                String str3 = str2.equals(a2) ? a3 : a2;
                String str4 = bbVar.zQd;
                Object obj;
                String str5;
                Object obj2;
                if (bbVar.zQc == 1) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerBegin,show bar!");
                    String[] strArr = bbVar.zQe;
                    obj = null;
                    str5 = "";
                    for (av avVar : bbVar.zOe) {
                        str5 = str5 + avVar.zOC + ",";
                        if (avVar.zOC != null && avVar.zOC.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str6 : strArr) {
                        if (str6 != null && str6.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        o.bcX().FB(str3);
                        o.bcX().bcG().remove(str3);
                    } else if (!(o.bcX().bcG().contains(str3) || r5 == null)) {
                        o.bcX().bcG().add(str3);
                    }
                    if (str2.equals(str4)) {
                        o.bcV().b(str3, str4, false, false);
                    } else if (obj != null && r5 == null) {
                        o.bcV().b(str3, str4, false, false);
                    } else if (obj == null || r5 == null) {
                        o.bcV().b(str3, str4, true, false);
                    } else {
                        o.bcV().b(str3, str4, true, true);
                    }
                    o.bcX().a(str3, bbVar);
                    o.bcU().oFQ.ba(bh.e((Integer) ar.He().get(1)), q.FS());
                } else if (bbVar.zQc == 2) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange!2,member size : " + bbVar.zOe.length);
                    String[] strArr2 = bbVar.zQe;
                    obj = null;
                    str5 = "";
                    for (av avVar2 : bbVar.zOe) {
                        str5 = str5 + avVar2.zOC + ",";
                        if (avVar2.zOC != null && avVar2.zOC.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "in voiceGroupMem!");
                            obj = 1;
                        }
                    }
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "memberUserNames :" + str5);
                    obj2 = null;
                    for (String str7 : strArr2) {
                        if (str7 != null && str7.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "isInvitedNotFriend true! In invitelist and with talk creator is not friend!");
                            obj2 = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        if (!o.bcX().FC(str3) && o.bcX().bcG().contains(str3) && o.bcX().dp(str3, str2)) {
                            o.bcV();
                            e.Fp(str3);
                        }
                        o.bcX().FB(str3);
                        o.bcX().bcG().remove(str3);
                    } else if (!(o.bcX().bcG().contains(str3) || r5 == null)) {
                        o.bcX().bcG().add(str3);
                    }
                    o.bcU().oFQ.ba(bh.e((Integer) ar.He().get(1)), q.FS());
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                    g bcX = o.bcX();
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", new Object[]{str3});
                    b FE = o.bcR().FE(str3);
                    if (FE == null) {
                        x.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                        bcX.a(str3, bbVar);
                    } else if (FE.field_roomId != bbVar.slB) {
                        x.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + FE.field_roomId + "bannerinfo.roomid:" + bbVar.slB);
                    } else if (g.c(str3, bbVar)) {
                        bcX.FD(str3);
                    } else {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                    }
                } else if (bbVar.zQc == 0) {
                    x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get WxVoiceBannerEnd,dismiss bar!");
                    if (!o.bcX().FC(str3) && o.bcX().bcG().contains(str3) && o.bcX().dp(str3, str2)) {
                        o.bcV();
                        e.Fp(str3);
                    }
                    e bcV = o.bcV();
                    cf auVar = new au();
                    auVar.setType(64);
                    auVar.aq(System.currentTimeMillis());
                    auVar.eQ(6);
                    auVar.setContent(ac.getContext().getString(R.l.ewG));
                    if (m.gd(str3)) {
                        auVar.dS(str3);
                        auVar.setContent(auVar.field_content);
                        ar.Hg();
                        c.Fa().Q(auVar);
                    }
                    if (!(bcV.oGt == null || !str3.equals(bcV.oGt.zQs) || bcV.oGv.cfK())) {
                        x.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                        bcV.oGt = null;
                        bcV.oGu = 0;
                        bcV.oGv.TG();
                    }
                    o.bcX().FA(str3);
                    o.bcX().FB(str3);
                    o.bcX().bcG().remove(str3);
                } else if (bbVar.zQc == 3) {
                    for (av avVar3 : bbVar.zOe) {
                        if (avVar3.zOC != null && avVar3.zOC.equals(str2)) {
                            x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "wxVoiceBannerWaitTimeOut in voiceGroupMem!");
                        }
                    }
                } else {
                    x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "get bannerinfo voicestatus is invalidate!: voicestatus:" + bbVar.zQc);
                }
            } else {
                x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "msg for this groupId : " + bbVar.groupId + " is early than last msg, so we do not process,now return.");
            }
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "parse  bannerinfo  failure! xml:" + a, new Object[]{e.getMessage()});
        }
    }
}
