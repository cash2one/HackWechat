package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ag.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class ag$c extends d {
    public static boolean yFN = false;

    public ag$c(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        b.hPA.w(arVar.fEJ);
        e eVar = (e) arVar;
        com.tencent.mm.modelstat.a.a(eVar.fEJ, com.tencent.mm.modelstat.a.a.hPx);
        if (2 != eVar.kTK) {
            cf cfVar = eVar.fEJ;
            if (cfVar.field_isSend == 0) {
                cf cfVar2 = eVar.fEJ;
                r nF = t.nF(cfVar2.field_imgPath);
                x.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + nF.status + " is sender:" + cfVar2.field_isSend);
                switch (eVar.kTK) {
                    case 3:
                        h(nF);
                        break;
                    case 4:
                        ar.Hg();
                        if (!c.isSDCardAvailable()) {
                            u.fI(this.yqa.getContext());
                            break;
                        } else {
                            t.nC(cfVar2.field_imgPath);
                            break;
                        }
                }
            }
            if (cfVar.field_isSend == 1) {
                cfVar = eVar.fEJ;
                if (cfVar == null) {
                    x.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
                    return;
                }
                r nr = o.TU().nr(cfVar.field_imgPath);
                if (nr == null) {
                    x.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", new Object[]{cfVar.field_imgPath});
                    return;
                }
                int i = nr.status;
                x.i("MicroMsg.DesignerClickListener", " videoSendEvent status : " + i);
                String string;
                switch (eVar.kTK) {
                    case 3:
                        ar.Hg();
                        if (!c.isSDCardAvailable()) {
                            u.fI(this.yqa.getContext());
                            return;
                        } else if (i == 113) {
                            x.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
                            h(nr);
                            return;
                        } else if (nr.Uh()) {
                            x.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
                            string = this.yqa.getContext().getString(R.l.eSX);
                            if (i == 142) {
                                string = this.yqa.getContext().getString(R.l.eSX);
                            } else if (i == j.CTRL_INDEX) {
                                string = this.yqa.getContext().getString(R.l.eSY);
                            } else if (i == com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX) {
                                string = this.yqa.getContext().getString(R.l.eSW);
                            }
                            h.b(this.yqa.getContext(), string, this.yqa.getContext().getString(R.l.cRU), true);
                            return;
                        } else {
                            cfVar.cju();
                            ar.Hg();
                            c.Fa().a(cfVar.field_msgId, cfVar);
                            if (nr.status == bc.CTRL_INDEX) {
                                t.nE(cfVar.field_imgPath);
                                return;
                            } else {
                                t.nA(cfVar.field_imgPath);
                                return;
                            }
                        }
                    case 4:
                        ar.Hg();
                        if (!c.isSDCardAvailable()) {
                            u.fI(this.yqa.getContext());
                            return;
                        } else if (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                            x.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
                            t.nC(cfVar.field_imgPath);
                            return;
                        } else {
                            string = cfVar.field_imgPath;
                            nr = t.nF(string);
                            if (nr == null) {
                                x.e("MicroMsg.VideoLogic", "ERR:" + g.zh() + " getinfo failed: " + string);
                                g.getLine();
                            } else if (nr.status == 104 || nr.status == 103) {
                                nr.status = 105;
                                nr.hVF = bh.Wo();
                                nr.fDt = 1280;
                                if (!t.e(nr)) {
                                    x.e("MicroMsg.VideoLogic", "ERR:" + g.zh() + " update failed: " + string);
                                    g.getLine();
                                }
                            } else {
                                x.e("MicroMsg.VideoLogic", "ERR:" + g.zh() + " get status failed: " + string + " status:" + nr.status);
                                g.getLine();
                            }
                            x.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
                            com.tencent.mm.sdk.b.b osVar = new os();
                            osVar.fGK.fnB = cfVar;
                            com.tencent.mm.sdk.b.a.xef.m(osVar);
                            return;
                        }
                    default:
                        return;
                }
            }
        } else if (com.tencent.mm.p.a.aW(this.yqa.getContext()) || com.tencent.mm.p.a.aU(this.yqa.getContext())) {
            x.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
        } else {
            Bundle bundle;
            cf cfVar3 = eVar.fEJ;
            int[] iArr = new int[2];
            int i2 = 0;
            int i3 = 0;
            if (view != null) {
                view.getLocationInWindow(iArr);
                i2 = view.getWidth();
                i3 = view.getHeight();
            }
            long j = cfVar3.field_msgId;
            long j2 = cfVar3.field_msgSvrId;
            String str = eVar.userName;
            String str2 = eVar.chatroomName;
            Intent intent = new Intent(this.yqa.getContext(), ImageGalleryUI.class);
            intent.putExtra("show_search_chat_content_result", this.yqa.yvY.ysa);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("key_is_biz_chat", this.yqa.ywd.vnK);
            intent.putExtra("key_biz_chat_id", this.yqa.ywd.cti());
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i2);
            intent.putExtra("img_gallery_height", i3);
            intent.putExtra("img_gallery_enter_from_chatting_ui", this.yqa.yvY.yAI);
            String crz = this.yqa.crz();
            String str3 = cfVar3.field_isSend == 1 ? this.yqa.ysf.hlJ : str;
            Bundle bundle2 = new Bundle();
            if (this.yqa.ysk) {
                str = "stat_scene";
                i2 = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (s.gF(crz)) {
                    i2 = 7;
                    bundle = bundle2;
                } else {
                    i2 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, i2);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
            bundle2.putString("stat_chat_talker_username", crz);
            bundle2.putString("stat_send_msg_user", str3);
            intent.putExtra("_stat_obj", bundle2);
            this.yqa.startActivity(intent);
            this.yqa.overridePendingTransition(0, 0);
            if (cfVar3.cji() && eVar.userName != null) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.yoO, cfVar3);
                if (eVar.userName.toLowerCase().endsWith("@chatroom")) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11444, new Object[]{Integer.valueOf(2)});
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11444, new Object[]{Integer.valueOf(1)});
                }
            }
        }
    }

    private void h(r rVar) {
        ar.Hg();
        if (!c.isSDCardAvailable()) {
            u.fI(this.yqa.getContext());
        } else if (rVar.status == bc.CTRL_INDEX) {
            t.nD(rVar.getFileName());
        } else if (ab.bC(this.yqa.getContext()) || yFN) {
            t.nB(rVar.getFileName());
        } else {
            yFN = true;
            h.a(this.yqa.getContext(), R.l.eSZ, R.l.dGO, new 1(this, rVar), new 2(this));
        }
    }
}
