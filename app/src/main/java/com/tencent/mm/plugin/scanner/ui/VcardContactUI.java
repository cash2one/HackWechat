package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.a.o.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static ArrayList<String> pZo = new ArrayList();
    private static int pZq = 1;
    private static int pZr = 1;
    private f ilB;
    private o pZn;
    private r pZp;

    static /* synthetic */ void a(VcardContactUI vcardContactUI, Intent intent) {
        int i = 2;
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        String Rf = vcardContactUI.pZn.pTo.Rf();
        if (bh.ov(Rf)) {
            x.e("MicroMsg.scanner.VardContactUI", "no contact user name");
        } else {
            intent.putExtra("name", Rf);
        }
        List list = vcardContactUI.pZn.pTx;
        if (list == null || list.size() <= 0) {
            i = 1;
        } else {
            a(list, intent, 2, 1);
        }
        List list2 = vcardContactUI.pZn.pTy;
        if (list2 != null && list2.size() > 0) {
            int i2 = i + 1;
            a(list2, intent, 1, i);
            i = i2;
        }
        list = vcardContactUI.pZn.pTz;
        if (list != null && list.size() > 0) {
            int i3 = i + 1;
            a(list, intent, 3, i);
            i = i3;
        }
        list = vcardContactUI.pZn.pTB;
        if (list != null && list.size() > 0) {
            i3 = i + 1;
            a(list, intent, 7, i);
            i = i3;
        }
        List list3 = vcardContactUI.pZn.pTA;
        if (list3 != null && list3.size() > 0) {
            a(list3, intent, 0, i);
        }
        if (!bh.ov(vcardContactUI.pZn.iIk)) {
            intent.putExtra("company", vcardContactUI.pZn.iIk);
        }
        if (!bh.ov(vcardContactUI.pZn.pTE)) {
            intent.putExtra("notes", vcardContactUI.pZn.pTE);
        }
        if (!bh.ov(vcardContactUI.pZn.fWi)) {
            intent.putExtra("email", vcardContactUI.pZn.fWi);
        }
        if (!bh.ov(vcardContactUI.pZn.title)) {
            intent.putExtra("job_title", vcardContactUI.pZn.title);
        }
        o oVar = vcardContactUI.pZn;
        a aVar = (oVar.pTu == null || oVar.pTu.Rf().length() <= 0) ? (oVar.pTv == null || oVar.pTv.Rf().length() <= 0) ? (oVar.pTw == null || oVar.pTw.Rf().length() <= 0) ? (oVar.pTt == null || oVar.pTt.Rf().length() <= 0) ? null : oVar.pTt : oVar.pTw : oVar.pTv : oVar.pTu;
        if (aVar != null && aVar.Rf().length() > 0) {
            intent.putExtra("postal", aVar.Rf());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("add_vcard_contact")) {
            h.a(this, "", new String[]{getString(R.l.eSq), getString(R.l.eSp)}, "", new c(this) {
                final /* synthetic */ VcardContactUI pZs;

                {
                    this.pZs = r1;
                }

                public final void jl(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            bo.HS().c(10238, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            VcardContactUI.a(this.pZs, intent);
                            this.pZs.startActivity(intent);
                            return;
                        case 1:
                            bo.HS().c(10239, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(this.pZs, intent);
                            this.pZs.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        String str;
        if (preference.ibD.equals("v_contact_info_photo_uri") || preference.ibD.equals("v_contact_info_home_page") || preference.ibD.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                r rVar = this.pZp;
                if (!rVar.plq.cfK()) {
                    x.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    x.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    rVar.url = charSequence;
                    ar.Hg();
                    str = (String) com.tencent.mm.z.c.CU().get(46, null);
                    if (str == null || str.length() == 0) {
                        rVar.b(charSequence, (int) System.currentTimeMillis(), new byte[0]);
                    } else {
                        ar.CG().a(233, rVar);
                        rVar.pZz = new l(charSequence, null, 4, (int) System.currentTimeMillis(), new byte[0]);
                        ar.CG().a(rVar.pZz, 0);
                        rVar.plq.J(3000, 3000);
                    }
                }
                return true;
            }
        } else if (pZo.contains(preference.ibD) && !preference.ibD.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                h.a(this, "", new String[]{getString(R.l.dSx)}, "", new c(this) {
                    final /* synthetic */ VcardContactUI pZs;

                    public final void jl(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                                this.pZs.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        } else if (preference.ibD.equals("v_contact_info_email")) {
            String[] strArr = new String[]{this.mController.xIM.getString(R.l.eJO), this.mController.xIM.getString(R.l.eJN)};
            h.a(this, "", strArr, "", new 2(this, preference.getSummary().toString()));
        }
        return false;
    }

    protected final void initView() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        this.pZp = new r(this);
        this.ilB = this.yjd;
        this.pZn = o.pTF;
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ VcardContactUI pZs;

            {
                this.pZs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pZs.finish();
                return true;
            }
        });
        setMMTitle("");
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fcB);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.ilB.YN("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            o oVar = this.pZn;
            if (oVar != null) {
                if (!bh.ov(oVar.pTo.Rf())) {
                    vcardContactUserHeaderPreference.pZy = oVar.pTo.Rf();
                }
                if (!bh.ov(oVar.bgo)) {
                    vcardContactUserHeaderPreference.bgo = oVar.bgo;
                }
                if (!bh.ov(oVar.pTC)) {
                    vcardContactUserHeaderPreference.pTC = oVar.pTC;
                }
                if (!bh.ov(oVar.title)) {
                    vcardContactUserHeaderPreference.title = oVar.title;
                }
            }
        }
        this.ilB.YO("c_contact_info_wx_id");
        if (bh.ov(this.pZn.iIb)) {
            this.ilB.YO("v_contact_info_photo_uri");
            this.ilB.YO("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ilB.YN("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.pZn.iIb);
                vcardContactLinkPreference.mx(false);
                vcardContactLinkPreference.yiT = false;
                pZq += 2;
                pZr += 2;
            }
        }
        a aVar = this.pZn.pTv;
        if (aVar != null && aVar.Rf().length() > 0) {
            dU(aVar.Rf(), this.mController.xIM.getString(R.l.eSt));
        }
        aVar = this.pZn.pTw;
        if (aVar != null && aVar.Rf().length() > 0) {
            dU(aVar.Rf(), this.mController.xIM.getString(R.l.eSA));
        }
        aVar = this.pZn.pTt;
        if (aVar != null && aVar.Rf().length() > 0) {
            dU(aVar.Rf(), this.mController.xIM.getString(R.l.eSr));
        }
        aVar = this.pZn.pTu;
        if (aVar != null && aVar.Rf().length() > 0) {
            dU(aVar.Rf(), this.mController.xIM.getString(R.l.eSr));
        }
        List list = this.pZn.pTz;
        if (list != null && list.size() > 0) {
            b(list, "WorkTel", this.mController.xIM.getString(R.l.eSB));
        }
        list = this.pZn.pTy;
        if (list != null && list.size() > 0) {
            b(list, "HomeTel", this.mController.xIM.getString(R.l.eSu));
        }
        list = this.pZn.pTA;
        if (list != null && list.size() > 0) {
            b(list, "VideoTEL", this.mController.xIM.getString(R.l.eSz));
        }
        list = this.pZn.pTB;
        if (list != null && list.size() > 0) {
            b(list, "NormalTel", this.mController.xIM.getString(R.l.eSw));
        }
        list = this.pZn.pTx;
        if (list != null && list.size() > 0) {
            b(list, "CellTel", this.mController.xIM.getString(R.l.eSs));
        }
        if (bh.ov(this.pZn.iIk)) {
            this.ilB.YO("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pZn.iIk);
                keyValuePreference.mx(false);
                keyValuePreference.yiT = true;
            }
        }
        if (bh.ov(this.pZn.pTD)) {
            this.ilB.YO("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pZn.pTD);
                keyValuePreference.mx(false);
                keyValuePreference.yiT = true;
            }
        }
        if (bh.ov(this.pZn.url)) {
            this.ilB.YO("v_contact_info_home_page");
            this.ilB.YO("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ilB.YN("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.pZn.url);
                vcardContactLinkPreference.mx(false);
                vcardContactLinkPreference.yiT = true;
            }
        }
        if (bh.ov(this.pZn.fWi)) {
            this.ilB.YO("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ilB.YN("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.pZn.fWi);
                vcardContactLinkPreference.mx(false);
                vcardContactLinkPreference.yiT = true;
            }
        }
        if (bh.ov(this.pZn.pTs)) {
            this.ilB.YO("v_contact_info_birthday");
            this.ilB.YO("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pZn.pTs);
                keyValuePreference.mx(false);
                keyValuePreference.yiT = true;
            }
        }
        if (bh.ov(this.pZn.pTE)) {
            this.ilB.YO("v_contact_info_remark");
            this.ilB.YO("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.ilB.YN("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pZn.pTE);
                keyValuePreference.mx(false);
                keyValuePreference.yiT = true;
            }
        }
        if (this.pZn.pTq == null || !this.pZn.pTq.pTI.contains("uri")) {
            this.ilB.YO("v_contact_info_logo");
            this.ilB.YO("v_category_logo");
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.ilB.YN("v_contact_info_logo");
        vcardContactLinkPreference.setSummary(this.pZn.pTq.pTJ);
        vcardContactLinkPreference.yiT = false;
        vcardContactLinkPreference.mx(false);
    }

    private void b(List<String> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                Preference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!pZo.contains(str + String.valueOf(str3))) {
                    pZo.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle(str2);
                vcardContactLinkPreference.setLayoutResource(R.i.dnt);
                vcardContactLinkPreference.setSummary(str3);
                vcardContactLinkPreference.mx(false);
                vcardContactLinkPreference.yiT = true;
                vcardContactLinkPreference.cqo();
                this.ilB.a(vcardContactLinkPreference, pZq);
            }
        }
    }

    private void dU(String str, String str2) {
        Preference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle((CharSequence) str2);
        keyValuePreference.setLayoutResource(R.i.dnt);
        keyValuePreference.mx(false);
        keyValuePreference.setSummary((CharSequence) str);
        keyValuePreference.yiT = false;
        keyValuePreference.cqo();
        this.ilB.a(keyValuePreference, pZr);
    }

    private static void a(List<String> list, Intent intent, int i, int i2) {
        for (String str : list) {
            if (i2 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i);
            }
        }
    }
}
