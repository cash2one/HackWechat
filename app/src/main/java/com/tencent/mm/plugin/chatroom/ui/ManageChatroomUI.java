package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;

public class ManageChatroomUI extends MMPreference {
    private SharedPreferences gZO = null;
    private f ilB;
    CheckBoxPreference lbe;
    private String lbf;
    private String lbg;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.lbf = getIntent().getStringExtra("RoomInfo_Id");
        this.lbg = getIntent().getStringExtra("room_owner_name");
        this.ilB = this.yjd;
        if (this.ilB != null) {
            setMMTitle(R.l.euD);
            this.lbe = (CheckBoxPreference) this.ilB.YN("allow_by_identity");
            this.ilB.bk("select_enable_qrcode", true);
            this.ilB.bk("select_into_room_type", true);
            setBackBtn(new 1(this));
        }
    }

    protected void onResume() {
        boolean z = false;
        ar.Hg();
        q hD = c.Fh().hD(this.lbf);
        if (hD != null && this.gZO == null) {
            this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
            Editor edit = this.gZO.edit();
            String str = "allow_by_identity";
            if (hD.chT() == 2) {
                z = true;
            }
            edit.putBoolean(str, z).commit();
        }
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int XB() {
        return R.o.fbR;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.ibD;
        x.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[]{str});
        if (str.equals("room_transfer_room_ower")) {
            x.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[]{this.lbf});
            str = bh.d(m.gj(this.lbf), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", com.tencent.mm.z.q.FS());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("frome_scene", 2);
            intent.putExtra("RoomInfo_Id", this.lbf);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(R.l.eGd));
            intent.setClass(this, SelectMemberUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.lbe.isChecked();
            g.pQN.a(219, 22, 1, true);
            x.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[]{this.lbf, Boolean.valueOf(isChecked)});
            a com_tencent_mm_protocal_c_arj = new arj();
            com_tencent_mm_protocal_c_arj.vYJ = bh.ou(this.lbf);
            if (!isChecked) {
                i = 0;
            }
            com_tencent_mm_protocal_c_arj.pQk = i;
            b aVar = new e.a(66, com_tencent_mm_protocal_c_arj);
            ar.Hg();
            c.EX().b(aVar);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    x.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[]{this.lbf, Integer.valueOf(intent.getIntExtra("into_room_type", -1))});
                    a com_tencent_mm_protocal_c_arj = new arj();
                    com_tencent_mm_protocal_c_arj.vYJ = bh.ou(this.lbf);
                    com_tencent_mm_protocal_c_arj.pQk = r0;
                    b aVar = new e.a(66, com_tencent_mm_protocal_c_arj);
                    ar.Hg();
                    c.EX().b(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
