package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2$Args;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.plugin.game.c.ac;
import com.tencent.mm.plugin.game.c.ad;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private ProgressDialog kVi = null;
    private String mAppId;
    private String mPackageName;
    private String nlm;
    private String nln;
    private String nlo;
    private String nlp;
    private String nlq;
    private int nlr = 1;
    private String vz;

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI, String str) {
        Intent intent = new Intent();
        String l = g.l(createOrJoinChatroomUI, createOrJoinChatroomUI.mAppId);
        intent.putExtra("action", createOrJoinChatroomUI.vz);
        intent.putExtra("app_name", l);
        intent.putExtra("rawUrl", str);
        d.b(createOrJoinChatroomUI, "webview", ".ui.tools.game.GameChattingRoomWebViewUI", intent, 5);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        x.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.vz = intent.getStringExtra("action");
        this.mPackageName = intent.getStringExtra("package_name");
        this.mAppId = intent.getStringExtra("key_app_id");
        this.nlm = intent.getStringExtra("key_transaction");
        this.nln = intent.getStringExtra("group_id");
        this.nlo = intent.getStringExtra("chatroom_name");
        this.nlp = intent.getStringExtra("chatroom_nickname");
        this.nlq = intent.getStringExtra("ext_msg");
        if (bh.ov(this.vz) || bh.ov(this.mAppId) || bh.ov(this.nln)) {
            x.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            return;
        }
        this.kVi = h.a(this, getBaseContext().getString(R.l.eSI), true, null);
        b.a aVar;
        b JZ;
        if (this.vz.equals("action_create")) {
            x.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[]{this.mAppId, this.nln, this.nlo});
            aVar = new b.a();
            aVar.hmj = new ac();
            aVar.hmk = new ad();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.hmi = 1205;
            JZ = aVar.JZ();
            ac acVar = (ac) JZ.hmg.hmo;
            acVar.nfn = this.mAppId;
            acVar.ngx = this.nln;
            acVar.ngy = new com.tencent.mm.bq.b(this.nlo == null ? new byte[0] : this.nlo.getBytes());
            acVar.ngz = new com.tencent.mm.bq.b(this.nlp == null ? new byte[0] : this.nlp.getBytes());
            u.a(JZ, new 1(this));
        } else if (this.vz.equals("action_join")) {
            aVar = new b.a();
            aVar.hmj = new at();
            aVar.hmk = new au();
            aVar.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar.hmi = 1206;
            JZ = aVar.JZ();
            at atVar = (at) JZ.hmg.hmo;
            atVar.nfn = this.mAppId;
            atVar.ngx = this.nln;
            atVar.ngz = new com.tencent.mm.bq.b(this.nlp == null ? new byte[0] : this.nlp.getBytes());
            u.a(JZ, new 2(this));
        }
    }

    protected void onDestroy() {
        aRp();
        super.onDestroy();
    }

    private void aRp() {
        if (this.kVi != null && this.kVi.isShowing()) {
            this.kVi.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5) {
            if (i2 == 4) {
                qP(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    q.a.vcy.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                qP(-2);
            }
        }
        finish();
    }

    private void qP(int i) {
        f aZ = g.aZ(this.mAppId, true);
        Bundle bundle = new Bundle();
        if (this.vz.equals("action_create")) {
            Resp resp = new Resp();
            if (aZ != null) {
                resp.openId = aZ.field_openId;
            }
            resp.transaction = this.nlm;
            resp.extMsg = this.nlq;
            resp.errCode = i;
            resp.toBundle(bundle);
        } else if (this.vz.equals("action_join")) {
            JoinChatroom.Resp resp2 = new JoinChatroom.Resp();
            if (aZ != null) {
                resp2.openId = aZ.field_openId;
            }
            resp2.transaction = this.nlm;
            resp2.extMsg = this.nlq;
            resp2.errCode = i;
            resp2.toBundle(bundle);
        }
        MMessageActV2$Args mMessageActV2$Args = new MMessageActV2$Args();
        mMessageActV2$Args.targetPkgName = this.mPackageName;
        mMessageActV2$Args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(com.tencent.mm.sdk.platformtools.ac.getContext(), mMessageActV2$Args);
    }
}
