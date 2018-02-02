package com.tencent.mm.plugin.chatroom.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.h.a;
import com.tencent.mm.plugin.chatroom.d.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements e {
    private ListView Fv;
    private String chatroomName;
    private q kZS;
    private a laN;
    private LinkedList<String> laO = new LinkedList();
    private int scene;
    private r tipDialog;

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            k gVar = new g(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
            delChatroomMemberUI.getString(R.l.dGO);
            delChatroomMemberUI.tipDialog = h.a(delChatroomMemberUI, delChatroomMemberUI.getString(R.l.eEY), true, new 2(delChatroomMemberUI, gVar));
            ar.CG().a(gVar, 0);
        }
    }

    static /* synthetic */ String b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        return delChatroomMemberUI.kZS == null ? null : delChatroomMemberUI.kZS.gu(str);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        ar.CG().a(179, this);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.laO.add(split[i]);
            i++;
        }
        ar.Hg();
        this.kZS = c.Fh().hD(this.chatroomName);
        initView();
    }

    public void onDestroy() {
        ar.CG().b(179, this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    protected final void initView() {
        setMMTitle(R.l.eFm);
        this.Fv = (ListView) findViewById(R.h.cvM);
        this.laN = new a(this);
        a aVar = this.laN;
        List<String> list = this.laO;
        if (list != null) {
            x.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", new Object[]{Integer.valueOf(list.size())});
            aVar.laQ.clear();
            for (String str : list) {
                ar.Hg();
                af WO = c.EY().WO(str);
                if (!(WO == null || bh.ov(WO.field_username) || !WO.field_username.equals(str))) {
                    aVar.laQ.add(WO);
                }
            }
        }
        this.Fv.setAdapter(this.laN);
        setBackBtn(new 1(this));
    }

    protected final int getLayoutId() {
        return R.i.dcR;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(R.l.eFk));
                this.laN.as(((g) kVar).fAN);
                this.Fv.post(new 5(this));
            }
        } else if (i2 == -2024) {
            a eA = a.eA(str);
            if (eA != null) {
                eA.a(this, null, null);
            } else {
                h.a(this.mController.xIM, getString(R.l.eFh), null, getString(R.l.eFi), false, new 3(this));
            }
        } else {
            h.a(this, getString(R.l.eFq), null, getString(R.l.dFU), false, new 4(this));
        }
    }
}
