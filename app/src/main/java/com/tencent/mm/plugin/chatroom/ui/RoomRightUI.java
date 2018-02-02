package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI extends MMPreference implements e {
    private f ilB;
    private ProgressDialog iln = null;
    private String lbZ = "";
    private int lca = 0;

    static /* synthetic */ void a(RoomRightUI roomRightUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new q(roomRightUI, new a(roomRightUI) {
            final /* synthetic */ RoomRightUI lcb;

            {
                this.lcb = r1;
            }

            public final void el(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    public final int XB() {
        return R.o.fbW;
    }

    private void axR() {
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(135175, null), 0);
        Preference YN = this.ilB.YN("settings_room_size");
        if (YN != null && a > 0) {
            YN.setSummary(getResources().getQuantityString(R.j.duJ, a, new Object[]{Integer.valueOf(a)}));
            YN.setEnabled(false);
        } else if (YN != null) {
            this.ilB.c(YN);
        }
        this.ilB.YN("room_right_max_tip").setTitle(getString(R.l.eFT, new Object[]{Integer.valueOf(a)}));
        ar.Hg();
        int a2 = bh.a((Integer) c.CU().get(135176, null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.ilB.YN("settings_room_grant");
        if (roomGrantPreference != null && a2 <= 0) {
            this.ilB.c(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            CharSequence charSequence = getString(R.l.eFV, new Object[]{Integer.valueOf(a2)});
            roomGrantPreference.lbT = charSequence;
            if (roomGrantPreference.lbS != null) {
                roomGrantPreference.lbS.setText(charSequence);
            }
        }
        Preference YN2 = this.ilB.YN("room_right_tip");
        Preference YN3 = this.ilB.YN("room_right_grant_tip");
        if (a2 <= 0) {
            if (YN2 != null) {
                this.ilB.c(YN2);
            }
            if (YN3 != null) {
                this.ilB.c(YN3);
            }
            Preference YN4 = this.ilB.YN("room_grant_to_friend");
            if (YN4 != null) {
                this.ilB.c(YN4);
            }
            if (roomGrantPreference != null) {
                this.ilB.c(roomGrantPreference);
                return;
            }
            return;
        }
        CharSequence string = getString(R.l.eFW, new Object[]{Integer.valueOf(a2), Integer.valueOf(a)});
        if (YN2 != null) {
            YN2.setTitle(string);
        }
        string = getString(R.l.eFS, new Object[]{Integer.valueOf(this.lca)});
        if (YN3 != null) {
            YN3.setTitle(string);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        this.lca = bh.a((Integer) c.CU().get(135177, null), 0);
        ar.CG().a(339, this);
        ar.CG().a(30, this);
        ar.Hg();
        c.CU().set(135184, Boolean.valueOf(false));
        initView();
    }

    public void onResume() {
        super.onResume();
        axR();
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(ac.getPackageName(), ac.getPackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            List linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", bh.d(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        ar.CG().b(339, this);
        ar.CG().b(30, this);
    }

    protected final void initView() {
        this.ilB = this.yjd;
        setMMTitle(R.l.eMR);
        setBackBtn(new 1(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 1:
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    x.d("MicroMsg.RoomRightUI", "pick user %s", new Object[]{stringExtra});
                    if (!bh.ov(stringExtra)) {
                        this.lbZ = stringExtra;
                        stringExtra = this.lbZ;
                        ar.Hg();
                        com.tencent.mm.l.a WO = c.EY().WO(stringExtra);
                        h.a(this.mController.xIM, getString(R.l.eFs, new Object[]{WO.AQ(), Integer.valueOf(this.lca)}), "", new 2(this, stringExtra), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void G(final LinkedList<String> linkedList) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ac.getContext().getString(R.l.dQz);
        linkedList.size();
        int i = R.l.eFU;
        Object[] objArr = new Object[1];
        List linkedList2 = new LinkedList();
        if (ar.Hj() && linkedList != null) {
            for (String gu : linkedList) {
                linkedList2.add(r.gu(gu));
            }
        }
        objArr[0] = bh.d(linkedList2, string);
        h.a((Context) this, getString(i, objArr), getString(R.l.dGO), new OnClickListener(this) {
            final /* synthetic */ RoomRightUI lcb;

            public final void onClick(DialogInterface dialogInterface, int i) {
                RoomRightUI.a(this.lcb, linkedList);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
        }
        if (kVar.getType() == 339) {
            String str2;
            ar.Hg();
            com.tencent.mm.l.a WO = c.EY().WO(this.lbZ);
            if (WO == null || ((int) WO.gJd) == 0) {
                str2 = this.lbZ;
            } else {
                str2 = WO.AQ();
            }
            if (i == 0 && i2 == 0) {
                h.b(this, getString(R.l.eFv, new Object[]{str2}), getString(R.l.dGO), true);
                if (this.ilB != null) {
                    axR();
                    this.ilB.notifyDataSetChanged();
                }
            } else if (i2 == -251) {
                h.b(this, getString(R.l.eFt, new Object[]{str2, Integer.valueOf(this.lca)}), getString(R.l.dGO), true);
            } else if (i2 == -44) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.lbZ);
                G(linkedList);
            } else if (i2 == -22) {
                h.b(this, getString(R.l.eFu, new Object[]{str2}), getString(R.l.dGO), true);
            } else {
                Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
            }
        }
    }
}
