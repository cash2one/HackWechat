package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m$a;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.Map;

public class AddMoreFriendsUI extends MMPreference {
    private f ilB;
    private final int rYk = 4;
    private final int rYl = 9;

    public final int XB() {
        return R.o.fbd;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        CharSequence string;
        super.onResume();
        if (d.OQ("brandservice")) {
            this.ilB.bk("find_friends_by_web", false);
        } else {
            this.ilB.bk("find_friends_by_web", true);
        }
        this.ilB.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.ilB.YN("find_friends_by_input");
        addFriendSearchPreference.rYb = getString(R.l.dXk);
        addFriendSearchPreference.rYd = new 2(this);
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.ilB.YN("find_friends_info");
        String FS = q.FS();
        String FT = q.FT();
        ar.Hg();
        String Vk = ao.Vk((String) c.CU().get(6, null));
        if (!bh.ov(FT)) {
            string = getString(R.l.ehy, new Object[]{FT});
        } else if (!x.WB(FS)) {
            string = getString(R.l.ehy, new Object[]{FS});
        } else if (bh.ov(Vk)) {
            string = getString(R.l.ehA);
        } else {
            string = getString(R.l.ehz, new Object[]{ao.Vj(Vk)});
        }
        preferenceInfoCategory.setTitle(string);
        preferenceInfoCategory.xJs = R.g.bDe;
        OnClickListener 3 = new 3(this);
        preferenceInfoCategory.yjR = 3;
        preferenceInfoCategory.yjS = 3;
        ((AddFriendItemPreference) this.ilB.YN("find_friends_create_pwdgroup")).qho = 8;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.yjd != null) {
            Preference YN = this.yjd.YN("find_friends_by_web");
            if (YN != null) {
                YN.setEnabled(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.ibD)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            g.pQN.h(11265, Integer.valueOf(1));
            if (!(a.aV(this) || com.tencent.mm.au.a.Qj())) {
                d.b(this, "scanner", ".ui.BaseScanUI", intent);
            }
            return true;
        } else if ("find_friends_by_other_way".equals(preference.ibD)) {
            if (m.NN() != m$a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.A(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_web".equals(preference.ibD)) {
            if (com.tencent.mm.plugin.aj.a.g.zM(0)) {
                Intent QM = b.QM();
                QM.putExtra("KRightBtn", true);
                QM.putExtra("ftsneedkeyboard", true);
                QM.putExtra("key_load_js_without_delay", true);
                QM.putExtra("ftsType", 1);
                QM.putExtra("ftsbizscene", 9);
                Map b = b.b(9, true, 0);
                String zH = com.tencent.mm.plugin.aj.a.g.zH(bh.VI((String) b.get("scene")));
                b.put("sessionId", zH);
                b.put("subSessionId", zH);
                QM.putExtra("sessionId", zH);
                QM.putExtra("subSessionId", zH);
                QM.putExtra("rawUrl", b.r(b));
                d.b(this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM);
                preference.setEnabled(false);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        } else if ("find_friends_by_radar".equals(preference.ibD)) {
            d.y(this, "radar", ".ui.RadarSearchUI");
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.ibD)) {
            g.pQN.h(11140, Integer.valueOf(1));
            d.y(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            return true;
        } else if (!"find_friends_by_invite".equals(preference.ibD)) {
            return false;
        } else {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            g.pQN.h(14034, Integer.valueOf(intExtra));
            Intent intent2 = new Intent(this, InviteFriendsBy3rdUI.class);
            intent2.putExtra("Invite_friends", intExtra);
            startActivity(intent2);
            return true;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dCv);
        this.ilB = this.yjd;
        Preference addFriendItemPreference = new AddFriendItemPreference(this.mController.xIM);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle(R.l.ehr);
        int i = R.k.dvf;
        addFriendItemPreference.Kw = i;
        Drawable drawable = addFriendItemPreference.mContext.getResources().getDrawable(i);
        if ((drawable == null && addFriendItemPreference.jY != null) || !(drawable == null || addFriendItemPreference.jY == drawable)) {
            addFriendItemPreference.jY = drawable;
            addFriendItemPreference.notifyChanged();
        }
        addFriendItemPreference.setSummary(R.l.ehs);
        if ((bh.getInt(com.tencent.mm.k.g.zY().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.ilB.a(addFriendItemPreference, 4);
        }
        setBackBtn(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
