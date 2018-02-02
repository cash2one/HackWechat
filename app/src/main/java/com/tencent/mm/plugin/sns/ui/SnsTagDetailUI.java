package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI extends MMPreference implements e, b {
    protected String fqR = "";
    protected f ilB;
    protected ContactListExpandPreference kZG;
    protected long qUC;
    protected List<String> rGZ = new ArrayList();
    protected String rHa = "";
    private boolean rHb = false;
    protected a rHc = new 9(this);
    protected int scene = 0;
    protected r tipDialog = null;

    static /* synthetic */ void a(SnsTagDetailUI snsTagDetailUI) {
        String d = bh.d(snsTagDetailUI.rGZ, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(j.dDo));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.p(new int[]{s.yTE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("always_select_contact", d);
        d.a(snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void bAv() {
        x.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        g.Dk();
        g.Di().gPJ.a(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.a(JsApiCreateAudioInstance.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.a(JsApiSetAudioState.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.a(JsApiGetAudioState.CTRL_INDEX, this);
        g.Dk();
        ((h) g.h(h.class)).EY().a(this);
        if (ae.bvB().byR().size() == 0) {
            g.Dk();
            g.Di().gPJ.a(new u(1), 0);
            this.rHb = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bAv();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.qUC = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.qUC == 4) {
            this.rHa = getString(j.qMl);
        } else if (this.qUC == 5) {
            this.rHa = getString(j.qMq);
        } else {
            this.rHa = ae.bvB().eT(this.qUC).field_tagName;
        }
        if (this.qUC == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.rHa = bh.az(getIntent().getStringExtra("k_sns_tag_name"), "");
            ar bvj = ae.bvj();
            String FS = q.FS();
            List<String> F = bh.F(stringExtra.split(","));
            if (F != null) {
                for (String stringExtra2 : F) {
                    if (!(this.rGZ.contains(stringExtra2) || !com.tencent.mm.l.a.fZ(bvj.WO(stringExtra2).field_type) || FS.equals(stringExtra2))) {
                        this.rGZ.add(stringExtra2);
                    }
                }
            }
        } else {
            this.rGZ = bAy();
        }
        if (this.rHa == null || this.rHa.equals("")) {
            this.rHa = getString(j.qMk);
            this.rHa = ai.Kn(getString(j.qMk));
        }
        initView();
        bBw();
        updateTitle();
        if (this.qUC < 6) {
            this.ilB.YO("delete_tag_name");
            this.ilB.YO("delete_tag_name_category");
            if (this.qUC > 0) {
                this.ilB.YO("settings_tag_name");
                this.ilB.YO("settings_tag_name_category");
            }
        }
        if (this.qUC == 4) {
            this.ilB.YO("black");
            this.ilB.YO("group");
        } else if (this.qUC == 5) {
            this.ilB.YO("outside");
            this.ilB.YO("group");
        } else {
            this.ilB.YO("black");
            this.ilB.YO("outside");
        }
        if (this.qUC == 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.fqR = this.rHa + " " + bh.d(this.rGZ, ",");
    }

    protected void bAw() {
        x.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        g.Dk();
        g.Di().gPJ.b(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiCreateAudioInstance.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiSetAudioState.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiGetAudioState.CTRL_INDEX, this);
        g.Dk();
        if (g.Dh().Cy()) {
            g.Dk();
            ((h) g.h(h.class)).EY().b(this);
        }
    }

    public void onDestroy() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        bAw();
        super.onDestroy();
    }

    public final void a(int i, m mVar, Object obj) {
    }

    public final int XB() {
        return i.m.qNl;
    }

    public void onResume() {
        super.onResume();
        bBw();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str.equals("settings_tag_name") && (this.qUC >= 6 || this.qUC == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", bh.az(this.rHa, " "));
            com.tencent.mm.plugin.sns.c.a.ifs.a(intent, (Activity) this);
        }
        if (str.equals("delete_tag_name")) {
            com.tencent.mm.ui.base.h.a((Context) this, j.qJL, j.dGO, new 1(this), new 2(this));
        }
        return false;
    }

    protected final void updateTitle() {
        setMMTitle(this.rHa + "(" + this.rGZ.size() + ")");
    }

    private void bBw() {
        Preference YN = this.ilB.YN("settings_tag_name");
        if (YN != null) {
            if (this.rHa.length() > 20) {
                this.rHa = this.rHa.substring(0, 20);
            }
            YN.setSummary(this.rHa);
            this.ilB.notifyDataSetChanged();
        }
    }

    protected void bAx() {
        if (this.qUC != 0) {
            g.Dk();
            g.Di().gPJ.a(new w(this.qUC, this.rHa), 0);
        }
        getString(j.dGO);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(j.qMp), true, new 3(this));
    }

    protected final void initView() {
        this.ilB = this.yjd;
        this.kZG = (ContactListExpandPreference) this.ilB.YN("roominfo_contact_anchor");
        if (this.kZG != null) {
            this.kZG.a(this.ilB, this.kZG.ibD);
            this.kZG.la(true).lb(true);
            this.kZG.n(null, this.rGZ);
            this.kZG.a(new com.tencent.mm.pluginsdk.ui.applet.i.b(this) {
                final /* synthetic */ SnsTagDetailUI rHd;

                {
                    this.rHd = r1;
                }

                public final boolean oc(int i) {
                    boolean BZ;
                    ContactListExpandPreference contactListExpandPreference = this.rHd.kZG;
                    if (contactListExpandPreference.vol != null) {
                        BZ = contactListExpandPreference.vol.vnx.BZ(i);
                    } else {
                        BZ = true;
                    }
                    if (!BZ) {
                        x.d("MicroMsg.SnsTagDetailUI", "onItemLongClick " + i);
                    }
                    return true;
                }
            });
            this.kZG.a(this.rHc);
        }
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new 5(this));
        a(0, getString(j.dFl), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagDetailUI rHd;

            {
                this.rHd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rHd.aWq();
                return true;
            }
        }, p.b.xJz);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!(this.rHa + " " + bh.d(this.rGZ, ",")).equals(this.fqR) || this.qUC == 0) {
            com.tencent.mm.ui.base.h.a((Context) this, j.qMi, j.dGO, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI rHd;

                {
                    this.rHd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rHd.finish();
                }
            }, null);
        } else {
            finish();
        }
        return true;
    }

    protected void aWq() {
        if ((this.rHa + " " + bh.d(this.rGZ, ",")).equals(this.fqR) && this.qUC != 0) {
            finish();
        } else if (ae.bvB().p(this.qUC, this.rHa)) {
            com.tencent.mm.ui.base.h.b(this, getString(j.qMj, new Object[]{this.rHa}), getString(j.dGO), true);
        } else {
            final k vVar = new v(3, this.qUC, this.rHa, this.rGZ.size(), this.rGZ, this.scene);
            g.Dk();
            g.Di().gPJ.a(vVar, 0);
            getString(j.dGO);
            this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(j.qMp), true, new OnCancelListener(this) {
                final /* synthetic */ SnsTagDetailUI rHd;

                public final void onCancel(DialogInterface dialogInterface) {
                    g.Dk();
                    g.Di().gPJ.c(vVar);
                }
            });
        }
    }

    protected List<String> bAy() {
        List<String> linkedList = new LinkedList();
        com.tencent.mm.plugin.sns.storage.s eT = ae.bvB().eT(this.qUC);
        if (eT.field_memberList == null || eT.field_memberList.equals("")) {
            return linkedList;
        }
        return bh.F(eT.field_memberList.split(","));
    }

    protected void xe(String str) {
        if (str != null && !str.equals("")) {
            this.rGZ.remove(str);
            if (this.kZG != null) {
                this.kZG.bb(this.rGZ);
                this.kZG.notifyChanged();
            }
            if (this.rGZ.size() == 0 && this.kZG != null) {
                this.kZG.caZ();
                this.kZG.la(true).lb(false);
                this.ilB.notifyDataSetChanged();
            } else if (this.kZG != null) {
                this.kZG.la(true).lb(true);
            }
            updateTitle();
        }
    }

    protected void bW(List<String> list) {
        ar bvj = ae.bvj();
        String FS = q.FS();
        for (String str : list) {
            if (!(this.rGZ.contains(str) || !com.tencent.mm.l.a.fZ(bvj.WO(str).field_type) || FS.equals(str))) {
                this.rGZ.add(str);
            }
        }
        if (this.kZG != null) {
            this.kZG.bb(this.rGZ);
            this.kZG.notifyChanged();
        }
        if (this.rGZ.size() > 0) {
            this.kZG.la(true).lb(true);
        } else {
            this.kZG.la(true).lb(false);
        }
        updateTitle();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent != null) {
                        boolean z;
                        String stringExtra2 = intent.getStringExtra("Select_Contact");
                        if (bh.ou(q.FS()).equals(stringExtra2)) {
                            z = true;
                        } else if (this.rGZ == null) {
                            z = false;
                        } else {
                            z = false;
                            for (String stringExtra3 : this.rGZ) {
                                boolean z2;
                                if (stringExtra3.equals(stringExtra2)) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                        }
                        if (z) {
                            com.tencent.mm.ui.base.h.b(this, getString(j.dCA, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}), getString(j.dGO), true);
                            return;
                        }
                        List F = bh.F(stringExtra2.split(","));
                        if (F != null) {
                            bW(F);
                            break;
                        }
                        return;
                    }
                    return;
                case 2:
                    stringExtra3 = intent.getStringExtra("k_sns_tag_name");
                    if (stringExtra3 != null) {
                        this.rHa = stringExtra3;
                    }
                    updateTitle();
                    x.d("MicroMsg.SnsTagDetailUI", "updateName " + this.rHa);
                    break;
                default:
                    return;
            }
            if (!(this.rHa + " " + bh.d(this.rGZ, ",")).equals(this.fqR) || this.qUC == 0) {
                enableOptionMenu(true);
            } else {
                enableOptionMenu(false);
            }
        }
    }

    public void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (kVar.getType()) {
            case JsApiDestroyInstanceAudio.CTRL_INDEX /*290*/:
                finish();
                return;
            case JsApiCreateAudioInstance.CTRL_INDEX /*291*/:
                finish();
                return;
            case JsApiSetAudioState.CTRL_INDEX /*292*/:
                if (this.kZG != null && this.rHb && !(this instanceof SnsBlackDetailUI)) {
                    x.d("MicroMsg.SnsTagDetailUI", "update form net");
                    this.fqR = this.rHa + " " + bh.d(((u) kVar).eB(this.qUC), ",");
                    LinkedList linkedList = new LinkedList();
                    List<String> list = this.rGZ;
                    this.rGZ = bAy();
                    if (list != null) {
                        for (String str2 : list) {
                            if (!this.rGZ.contains(str2)) {
                                this.rGZ.add(str2);
                            }
                        }
                    }
                    this.kZG.bb(this.rGZ);
                    this.kZG.notifyChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
