package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SelectDelRoomMemberUI extends MMActivity {
    private ListView Fv;
    private boolean fzz;
    public HashSet<String> iiv;
    private boolean kZA;
    private q kZS;
    private String lbf;
    private String lbu;
    private int lbv;
    private String lbw;
    private boolean lbx;
    private String lcX;
    private String lcY;
    private String lda;
    private int ldq;
    private a ldr;
    private EditText lds;
    private String username;

    static /* synthetic */ ArrayList a(SelectDelRoomMemberUI selectDelRoomMemberUI) {
        ArrayList arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it = selectDelRoomMemberUI.iiv.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    static /* synthetic */ void a(SelectDelRoomMemberUI selectDelRoomMemberUI, String str, String str2, String str3) {
        if (bh.ov(str2)) {
            ar.Hg();
            bf EZ = c.EZ().EZ(str);
            if (!(EZ == null || bh.ov(EZ.field_encryptUsername))) {
                str2 = EZ.field_conRemark;
            }
        }
        if (!bh.ov(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (selectDelRoomMemberUI.fzz && selectDelRoomMemberUI.kZS != null) {
                intent.putExtra("Contact_RoomNickname", selectDelRoomMemberUI.kZS.gu(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", selectDelRoomMemberUI.lbu);
            ar.Hg();
            af WO = c.EY().WO(str);
            if (WO != null && ((int) WO.gJd) > 0 && a.fZ(WO.field_type)) {
                b oxVar = new ox();
                oxVar.fGO.intent = intent;
                oxVar.fGO.username = str;
                com.tencent.mm.sdk.b.a.xef.m(oxVar);
            }
            if (selectDelRoomMemberUI.fzz) {
                if (WO != null && WO.cia()) {
                    g.pQN.k(10298, WO.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (selectDelRoomMemberUI.kZA) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.z.q.gr(WO.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Contact_ChatRoomId", selectDelRoomMemberUI.lbf);
            com.tencent.mm.plugin.chatroom.a.ifs.d(intent, selectDelRoomMemberUI);
        }
    }

    static /* synthetic */ String b(q qVar, String str) {
        return qVar == null ? null : qVar.gu(str);
    }

    protected final int getLayoutId() {
        return R.i.dfr;
    }

    protected final void initView() {
        super.initView();
        this.lbf = getIntent().getStringExtra("RoomInfo_Id");
        this.lcY = getIntent().getStringExtra("Chatroom_member_list");
        this.fzz = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.kZA = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.lbx = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.lbw = getIntent().getStringExtra("room_owner_name");
        ar.Hg();
        this.kZS = c.Fh().hD(this.lbf);
        this.lbv = getIntent().getIntExtra("room_member_count", 0);
        this.ldq = getIntent().getIntExtra("list_attr", s.yTD);
        this.lbu = getIntent().getStringExtra("room_name");
        setMMTitle(getString(R.l.eGc) + "(" + this.lbv + ")");
        a(1, getString(R.l.dYu), new 1(this), p.b.xJA);
        setBackBtn(new 2(this));
        this.lds = (EditText) findViewById(R.h.cyt);
        this.lds.addTextChangedListener(new 3(this));
        this.Fv = (ListView) findViewById(R.h.bSK);
        x xVar = new x();
        q qVar = this.kZS;
        String str = this.lbf;
        List linkedList = new LinkedList();
        if (!bh.ov(this.lcX)) {
            linkedList = bh.F(this.lcX.split(","));
        }
        ar.Hg();
        bc EY = c.Fg().EY("@t.qq.com");
        if (EY != null) {
            linkedList.add(EY.name);
        }
        this.ldr = new a(this, qVar, str, linkedList, this.lbw);
        this.Fv.setAdapter(this.ldr);
        this.Fv.setOnItemClickListener(new 4(this));
        WZ();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iiv = new HashSet();
        initView();
    }

    public void onResume() {
        super.onResume();
        if (this.ldr != null) {
            ar.Hg();
            this.kZS = c.Fh().hD(this.lbf);
            List gj = m.gj(this.lbf);
            if (this.ldr != null) {
                this.ldr.at(gj);
            }
        }
    }

    private void WZ() {
        if (!s.fa(this.ldq, 64) || this.iiv.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.dYu));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.dYu) + "(" + this.iiv.size() + ")");
        enableOptionMenu(1, true);
    }
}
