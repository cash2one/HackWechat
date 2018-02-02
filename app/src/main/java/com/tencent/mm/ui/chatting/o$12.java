package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.a.3;
import com.tencent.mm.ui.chatting.b.d;
import com.tencent.mm.ui.chatting.b.r;
import com.tencent.mm.ui.chatting.b.r.1;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.ArrayList;

class o$12 implements a {
    g pkB = null;
    final /* synthetic */ o ysq;

    o$12(o oVar) {
        this.ysq = oVar;
    }

    public final void aYN() {
        if (!com.tencent.mm.p.a.aU(o.f(this.ysq).getContext())) {
            b soVar = new so();
            com.tencent.mm.sdk.b.a.xef.m(soVar);
            if (this.ysq.crz().equals(soVar.fKm.talker) || !(soVar.fKm.fKo || soVar.fKm.fKp)) {
                if (1 == com.tencent.mm.k.g.zY().getInt("EnableVoiceVoipFromPlugin", 0)) {
                    this.pkB = new g(o.f(this.ysq).getContext(), g.ztp, false);
                    this.pkB.rKC = new 1(this);
                    this.pkB.rKD = new 2(this);
                    this.pkB.bUk();
                } else {
                    this.ysq.crC();
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(11033, new Object[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0)});
                return;
            }
            Toast.makeText(o.f(this.ysq).getContext(), soVar.fKm.fKn ? R.l.dNq : R.l.dNr, 0).show();
            x.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        }
    }

    public final void aYO() {
        if (!com.tencent.mm.p.a.aU(o.f(this.ysq).getContext())) {
            b soVar = new so();
            com.tencent.mm.sdk.b.a.xef.m(soVar);
            if (this.ysq.crz().equals(soVar.fKm.talker) || !(soVar.fKm.fKo || soVar.fKm.fKp)) {
                this.ysq.crB();
                return;
            }
            Toast.makeText(o.f(this.ysq).getContext(), soVar.fKm.fKn ? R.l.dNq : R.l.dNr, 0).show();
            x.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        }
    }

    public final void aYP() {
        if (!com.tencent.mm.p.a.aW(o.f(this.ysq).getContext()) && !com.tencent.mm.p.a.aU(o.f(this.ysq).getContext())) {
            x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(o.f(this.ysq).thisActivity(), "android.permission.RECORD_AUDIO", 81, "", "")), bh.cgy(), o.f(this.ysq).thisActivity()});
            if (com.tencent.mm.pluginsdk.g.a.a(o.f(this.ysq).thisActivity(), "android.permission.RECORD_AUDIO", 81, "", "")) {
                this.ysq.crD();
            }
        }
    }

    public final void aYQ() {
        int i;
        r rVar = o.f(this.ysq).yvX;
        if (rVar.fhr.csi().cia() || s.hk(rVar.fhr.crz()) || com.tencent.mm.storage.x.Wx(rVar.fhr.crz()) || com.tencent.mm.storage.x.Wz(rVar.fhr.crz()) || com.tencent.mm.storage.x.gy(rVar.fhr.crz()) || rVar.fhr.crz().equals(q.FS())) {
            i = 0;
        } else {
            i = 1;
        }
        h.a(rVar.fhr.csq().getContext(), null, i == 0 ? new String[]{rVar.fhr.csq().getMMString(R.l.etk)} : new String[]{rVar.fhr.csq().getMMString(R.l.etk), rVar.fhr.csq().getMMString(R.l.etl)}, null, new 1(rVar));
    }

    public final void aYR() {
        d dVar = o.f(this.ysq).yvW;
        Intent intent = new Intent(dVar.fhr.csq().getContext(), SelectContactUI.class);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.p(new int[]{com.tencent.mm.ui.contact.s.yTH, 2048}));
        intent.putExtra("list_type", 4);
        intent.putExtra("received_card_name", dVar.fhr.crz());
        intent.putExtra("block_contact", dVar.fhr.crz());
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", dVar.fhr.csq().getMMString(R.l.dDo));
        dVar.fhr.csq().startActivityForResult(intent, 223);
    }

    public final void sq(int i) {
        switch (i) {
            case 0:
                File file = new File(e.gHu);
                if (file.exists() || file.mkdir()) {
                    x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(o.f(this.ysq).thisActivity(), "android.permission.CAMERA", 20, "", "")), bh.cgy(), o.f(this.ysq).thisActivity()});
                    if (com.tencent.mm.pluginsdk.g.a.a(o.f(this.ysq).thisActivity(), "android.permission.CAMERA", 20, "", "")) {
                        this.ysq.crE();
                        return;
                    }
                    return;
                }
                Toast.makeText(o.f(this.ysq).getContext(), o.f(this.ysq).getString(R.l.dTe), 1).show();
                return;
            case 1:
                String string = o.f(this.ysq).getSharedPreferences(ac.cfs(), 0).getString("gallery", "1");
                f.vz(19);
                if (string.equalsIgnoreCase("0")) {
                    k.k(o.f(this.ysq));
                } else {
                    string = o.f(this.ysq).csv();
                    String crz = o.f(this.ysq).crz();
                    if (o.o(this.ysq) && o.ysd) {
                        k.b(o.f(this.ysq), 3, string, crz);
                    } else if (com.tencent.mm.storage.x.fV(crz)) {
                        k.a(o.f(this.ysq), 12, string, crz);
                    } else {
                        k.a(o.f(this.ysq), 3, string, crz);
                    }
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
                ag.h(new 3(this), 1000);
                return;
            default:
                return;
        }
    }

    public final void b(com.tencent.mm.pluginsdk.model.app.f fVar) {
        com.tencent.mm.ui.chatting.b.a aVar = o.f(this.ysq).ywa;
        if (fVar == null) {
            x.e("MicroMsg.ChattingUI.AppImp", "onAppSelected, info is null, %s", new Object[]{bh.cgy()});
            return;
        }
        if (!(fVar == null || !com.tencent.mm.pluginsdk.model.app.f.vef.equals(fVar.field_appId) || aVar.pLQ == null)) {
            aVar.pLQ.aK(2, aVar.fhr.csi().field_username);
        }
        if (fVar.bYD()) {
            if (fVar == null || !fVar.bYD()) {
                x.e("MicroMsg.ChattingUI.AppImp", "serviceAppSelect not service app");
            } else if (aVar.fhr.csi() == null || bh.ov(aVar.fhr.csi().field_username)) {
                x.e("MicroMsg.ChattingUI.AppImp", "serviceAppSelect talker is null");
            } else {
                x.i("MicroMsg.ChattingUI.AppImp", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(fVar.fQZ), fVar.field_packageName, fVar.field_appId});
                if (fVar.fQZ == 2 && !bh.ov(fVar.fQY)) {
                    aVar.n(fVar);
                } else if (fVar.fQZ == 3) {
                    if (bh.ov(fVar.field_openId)) {
                        an.bip().OI(fVar.field_appId);
                        x.e("MicroMsg.ChattingUI.AppImp", "JUMP 3RD APP fail, openId is null, go get it");
                    } else if (aVar.yyA == null || bh.ov(fVar.field_packageName)) {
                        x.e("MicroMsg.ChattingUI.AppImp", "JUMP 3RD APP fail");
                        aVar.n(fVar);
                    } else {
                        x.i("MicroMsg.ChattingUI.AppImp", "JUMP 3RD APP success[%s]", new Object[]{Boolean.valueOf(aVar.yyA.fM(fVar.field_packageName, fVar.field_openId))});
                        if (!aVar.yyA.fM(fVar.field_packageName, fVar.field_openId)) {
                            aVar.n(fVar);
                        }
                    }
                } else if (fVar.fQZ == 1) {
                    x.i("MicroMsg.ChattingUI.AppImp", "JUMP NATIVE ForwardUrl[%s]", new Object[]{fVar.fQY});
                    q$a.vcy.a(aVar.fhr.csq().getContext(), fVar.fQY, false, new 3(aVar));
                }
            }
        } else if (fVar.field_status == 3) {
            x.e("MicroMsg.ChattingUI.AppImp", "onAppSeleted fail, app is in blacklist, packageName = " + fVar.field_packageName);
        } else if (!aVar.yyA.fM(fVar.field_packageName, fVar.field_openId) && fVar.field_status == 5) {
            x.d("MicroMsg.ChattingUI.AppImp", "SuggestionApp appSuggestionIntroUrl = %s", new Object[]{fVar.fQM});
            if (!bh.ov(fVar.fQM)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", fVar.fQM);
                com.tencent.mm.bm.d.b(aVar.fhr.csq().getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        }
    }

    public final void aYS() {
        com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
    }

    public final void aYT() {
        Intent intent = new Intent();
        Iterable arrayList = new ArrayList();
        arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (com.tencent.mm.ag.f.eE(o.p(this.ysq).field_username)) {
            arrayList.add("4");
            arrayList.add("7");
            arrayList.add("9");
            arrayList.add(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
            arrayList.add("11");
            arrayList.add("12");
            arrayList.add("13");
            arrayList.add("15");
            arrayList.add("16");
            arrayList.add("17");
            arrayList.add("18");
        }
        intent.putExtra("key_to_user", o.p(this.ysq).field_username);
        intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
        com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "favorite", ".ui.FavSelectUI", intent);
        com.tencent.mm.plugin.report.service.g.pQN.h(14103, new Object[]{Integer.valueOf(1)});
    }

    public final void aYU() {
        Intent intent = new Intent();
        intent.putExtra("service_app_talker_user", this.ysq.crz());
        com.tencent.mm.bm.d.a(o.f(this.ysq), "subapp", ".ui.openapi.ServiceAppUI", intent, 222);
    }

    public final void aYV() {
        Intent intent = new Intent();
        intent.putExtra("download_entrance_scene", 17);
        intent.putExtra("preceding_scence", 13);
        com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        com.tencent.mm.plugin.report.service.g.pQN.h(12065, new Object[]{Integer.valueOf(4)});
    }

    public final void sr(int i) {
        if (!com.tencent.mm.p.a.aV(o.f(this.ysq).thisActivity()) && !com.tencent.mm.p.a.aW(o.f(this.ysq).thisActivity()) && !com.tencent.mm.p.a.aU(o.f(this.ysq).thisActivity())) {
            this.ysq.Ft(i);
        }
    }

    public final void aYW() {
        com.tencent.mm.plugin.report.service.g.pQN.h(12097, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
        com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
        if (o.q(this.ysq)) {
            com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2)});
            Intent intent = new Intent();
            int gl = m.gl(this.ysq.crz());
            intent.putExtra("key_way", 1);
            intent.putExtra("key_chatroom_num", gl);
            intent.putExtra("key_type", 1);
            intent.putExtra("key_from", 1);
            intent.putExtra("key_username", this.ysq.crz());
            intent.putExtra("pay_channel", 14);
            com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
            return;
        }
        ar.Hg();
        Integer num = (Integer) c.CU().get(w.a.xnD, Integer.valueOf(0));
        ar.Hg();
        Integer num2 = (Integer) c.CU().get(w.a.xnE, Integer.valueOf(0));
        if (num.intValue() == 1 || num2.intValue() == 1) {
            if ((q.FZ() == 0 ? 1 : 0) != 0) {
                h.a(o.f(this.ysq).getContext(), null, new String[]{o.f(this.ysq).getString(R.l.dSa), o.f(this.ysq).getString(R.l.dSb)}, null, new 4(this));
                return;
            }
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
        intent = new Intent();
        intent.putExtra("key_way", 0);
        intent.putExtra("key_type", 0);
        intent.putExtra("key_from", 1);
        intent.putExtra("key_username", this.ysq.crz());
        intent.putExtra("pay_channel", 11);
        com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
    }

    public final void aYX() {
        ar.Hg();
        c.CU().set(81, Boolean.valueOf(false));
        if (com.tencent.mm.sdk.platformtools.an.isNetworkConnected(o.f(this.ysq).getContext())) {
            this.ysq.crA();
        } else {
            com.tencent.mm.au.a.a(o.f(this.ysq).getContext(), R.l.eVz, null);
        }
    }

    public final void aYY() {
        Intent intent = new Intent();
        intent.putExtra("enterprise_scene", 4);
        intent.putExtra("enterprise_biz_name", this.ysq.crz());
        intent.putExtra("biz_chat_chat_id", o.f(this.ysq).ywd.cti());
        com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
    }

    public final void aYZ() {
        if (o.q(this.ysq)) {
            Intent intent = new Intent();
            intent.putExtra("enter_scene", 1);
            intent.putExtra("chatroom_name", this.ysq.crz());
            com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "aa", ".ui.LaunchAAUI", intent);
        }
    }

    public final void aZa() {
        com.tencent.mm.plugin.report.service.g.pQN.h(14523, new Object[]{Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.setClass(o.f(this.ysq).getContext(), NewFileExplorerUI.class);
        intent.putExtra("TO_USER", o.r(this.ysq));
        o.f(this.ysq).startActivityForResult(intent, GameJsApiGetOpenDeviceId.CTRL_BYTE);
    }
}
