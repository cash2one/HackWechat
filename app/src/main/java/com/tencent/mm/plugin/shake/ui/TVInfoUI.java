package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TVInfoUI extends MMPreference implements e, a {
    private long fqm;
    private TextView ihS;
    protected f ilB;
    protected ProgressDialog iln = null;
    private ImageView kSY;
    private boolean pWe = false;
    private boolean pYF = false;
    private TextView qsA;
    private c.a qsB;
    private b qsC;
    private String qsz = "";

    static /* synthetic */ void a(TVInfoUI tVInfoUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(tVInfoUI.getString(R.l.eYd));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(tVInfoUI.getString(R.l.eYe));
        linkedList2.add(Integer.valueOf(1));
        if (tVInfoUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            str = tVInfoUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true) ? tVInfoUI.getString(R.l.dEw) : "";
        } else {
            linkedList.add(tVInfoUI.getString(R.l.eAd));
            linkedList2.add(Integer.valueOf(2));
        }
        h.a(tVInfoUI, "", linkedList, linkedList2, str, false, new 6(tVInfoUI));
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && aVar.qbc != null && aVar.qbc.size() != 0 && tVInfoUI.ilB != null) {
            tVInfoUI.ilB.removeAll();
            for (int i = 0; i < aVar.qbc.size(); i++) {
                com.tencent.mm.plugin.shake.e.a aVar2 = (com.tencent.mm.plugin.shake.e.a) aVar.qbc.get(i);
                if (!(aVar2 == null || aVar2.hOg == null || aVar2.hOg.size() == 0)) {
                    for (int i2 = 0; i2 < aVar2.hOg.size(); i2++) {
                        String str = ((i * 100) + i2);
                        com.tencent.mm.plugin.shake.e.a.a aVar3 = (com.tencent.mm.plugin.shake.e.a.a) aVar2.hOg.get(i2);
                        Preference preference;
                        if (aVar3.type == 2) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(R.i.dtm);
                            preference.setTitle(bh.ov(aVar3.title) ? tVInfoUI.getResources().getString(R.l.ePf) : aVar3.title);
                            preference.setSummary(String.format(tVInfoUI.getResources().getString(R.l.ePe), new Object[]{Integer.valueOf(108)}));
                        } else if (aVar3.qsM == null || aVar3.qsM.size() <= 0) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(R.i.dtm);
                            preference.setTitle(aVar3.title);
                            preference.setSummary(aVar3.niP);
                            tVInfoUI.ilB.a(preference);
                        } else {
                            List arrayList = new ArrayList();
                            int i3 = 0;
                            while (i3 < aVar3.qsM.size() && i3 < 3 && (i3 != 2 || aVar3.title.length() <= 4)) {
                                arrayList.add(aVar3.qsM.get(i3));
                                i3++;
                            }
                            preference = new TVThumbPreference(tVInfoUI);
                            preference.setKey(str);
                            preference.qsJ = arrayList;
                            preference.setTitle(aVar3.title);
                            preference.jKn = tVInfoUI.ilB;
                            tVInfoUI.ilB.a(preference);
                        }
                    }
                }
            }
            tVInfoUI.ilB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 10);
        com.tencent.mm.plugin.shake.a.ifs.j(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        if (tVInfoUI.qsB == null) {
            x.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            return;
        }
        g.pQN.h(10987, new Object[]{Integer.valueOf(4), "", "", ""});
        String a = c.a(tVInfoUI.mController.xIM, tVInfoUI.qsB);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.qsC != null && tVInfoUI.pWe) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.qsC.Wf());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.ifs.l(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && !bh.ov(aVar.field_thumburl)) {
            tVInfoUI.qsC = new b(aVar);
            tVInfoUI.qsz = tVInfoUI.qsC.Wh();
            Bitmap a = j.a(tVInfoUI.qsC);
            x.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", new Object[]{a});
            if (a != null) {
                tVInfoUI.kSY.setImageBitmap(a);
                tVInfoUI.pWe = true;
                tVInfoUI.bph();
                return;
            }
            tVInfoUI.kSY.setImageDrawable(tVInfoUI.getResources().getDrawable(R.k.dBm));
        }
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        if (tVInfoUI.qsB == null) {
            x.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            return;
        }
        g.pQN.h(10987, new Object[]{Integer.valueOf(3), "", "", ""});
        Intent intent = new Intent();
        if (bh.ov(tVInfoUI.qsB.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.qsB.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.qsB.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.qsB.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.qsB.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(R.l.eIo));
        if (k.brA()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.qsB.field_thumburl);
        if (tVInfoUI.qsC != null && tVInfoUI.pWe) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.qsC.Wf());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.qsB));
        String hz = u.hz("shake_tv");
        u.GK().t(hz, true).o("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", hz);
        d.b(tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        if (tVInfoUI.qsB == null) {
            x.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            return;
        }
        g.pQN.h(10987, new Object[]{Integer.valueOf(5), "", "", ""});
        com.tencent.mm.sdk.b.b cfVar = new cf();
        ve veVar = new ve();
        vk vkVar = new vk();
        vn vnVar = new vn();
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        vkVar.CS(8);
        vkVar.fC(bh.Wp());
        if (k.brA()) {
            vkVar.Uo("wxaf060266bfa9a35c");
        }
        vnVar.Ur(tVInfoUI.qsB.field_title);
        if (bh.ov(tVInfoUI.qsB.field_topic)) {
            vnVar.Us(tVInfoUI.qsB.field_subtitle);
        } else {
            vnVar.Us(tVInfoUI.qsB.field_topic);
        }
        vnVar.Uu(c.b(tVInfoUI.qsB));
        vnVar.Ut(tVInfoUI.qsB.field_thumburl);
        cfVar.fqp.title = tVInfoUI.qsB.field_title;
        cfVar.fqp.desc = tVInfoUI.qsB.field_topic;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 15;
        veVar.a(vkVar);
        veVar.b(vnVar);
        cfVar.fqp.fqw = 12;
        cfVar.fqp.activity = tVInfoUI;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
    }

    protected final int getLayoutId() {
        return R.i.dtk;
    }

    public final int XB() {
        return R.o.fcA;
    }

    public final int asz() {
        return R.i.dtl;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j.b(this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(552, this);
    }

    protected void onPause() {
        ar.CG().b(552, this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c(this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eIl);
        this.ilB = this.yjd;
        this.ihS = (TextView) findViewById(R.h.cTA);
        this.qsA = (TextView) findViewById(R.h.cTB);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (bh.ov(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        x.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[]{stringExtra});
        this.qsB = c.Jo(stringExtra);
        if (this.qsB == null) {
            x.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            return;
        }
        a(this.qsB);
    }

    private void a(c.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        this.ihS.setText(aVar.field_title);
        if (bh.ov(aVar.field_topic)) {
            this.qsA.setVisibility(8);
        } else {
            this.qsA.setText(aVar.field_topic);
        }
        this.kSY = (ImageView) findViewById(R.h.cTz);
        if (!bh.ov(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(R.h.cTy);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new 1(this, aVar));
            this.kSY.setOnClickListener(new 2(this, aVar));
        }
        addIconOptionMenu(0, R.g.bDI, new 3(this));
        if (!(bh.ov(aVar.field_id) || this.pYF || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            x.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[]{aVar.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0))});
            ar.CG().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, r0), 0);
            this.pYF = true;
        }
        this.kSY.setVisibility(0);
        setBackBtn(new 4(this));
        x.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        ag.y(new 5(this, aVar));
    }

    private void bph() {
        this.fqm = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.fqm > 0 && ar.Hj()) {
            ar.Hg();
            com.tencent.mm.g.b.cf dH = com.tencent.mm.z.c.Fa().dH(this.fqm);
            if (dH.field_msgId > 0) {
                dH.dT(this.qsC.Wf());
                ar.Hg();
                com.tencent.mm.z.c.Fa().a(this.fqm, dH);
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.ibD});
        if (this.qsB == null || this.qsB.qbc == null) {
            x.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.ibD).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            x.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.qsB.qbc.size()) {
                x.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.qsB.qbc.size())});
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = (com.tencent.mm.plugin.shake.e.a) this.qsB.qbc.get(i);
            if (aVar == null) {
                x.w("MicroMsg.TVInfoUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.hOg.size()) {
                x.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.hOg.size())});
                return false;
            } else {
                com.tencent.mm.plugin.shake.e.a.a aVar2 = (com.tencent.mm.plugin.shake.e.a.a) aVar.hOg.get(i2);
                if (aVar2 == null) {
                    x.w("MicroMsg.TVInfoUI", "action == null");
                    return false;
                }
                x.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.qsL + ", targetDesc:" + aVar2.qsN + ", targetDesc2:" + aVar2.qsO);
                Intent intent;
                if (aVar2.type == 3) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", aVar2.qsL);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("geta8key_scene", 10);
                    intent.putExtra("srcUsername", aVar2.qsO);
                    com.tencent.mm.plugin.shake.a.ifs.j(intent, this);
                } else if (aVar2.type == 4) {
                    ar.Hg();
                    af WO = com.tencent.mm.z.c.EY().WO(aVar2.qsL);
                    if (WO != null) {
                        Intent intent2 = new Intent();
                        if (com.tencent.mm.l.a.fZ(WO.field_type) && WO.cia()) {
                            y.Mf().jK(aVar2.qsL);
                            if (aVar2.qsN.equals("1")) {
                                intent2.putExtra("Chat_User", aVar2.qsL);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.ifs.e(intent2, this);
                            }
                        }
                        intent2.putExtra("Contact_User", aVar2.qsL);
                        intent2.putExtra("force_get_contact", true);
                        d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    }
                } else if (aVar2.type == 5) {
                    com.tencent.mm.sdk.b.b gwVar = new gw();
                    gwVar.fxb.actionCode = 11;
                    gwVar.fxb.result = aVar2.qsL;
                    gwVar.fxb.context = this;
                    gwVar.fqI = null;
                    com.tencent.mm.sdk.b.a.xef.a(gwVar, Looper.myLooper());
                } else if (aVar2.type == 6) {
                    intent = new Intent();
                    intent.putExtra("key_product_id", aVar2.qsL);
                    intent.putExtra("key_product_scene", 9);
                    d.b(this, "product", ".ui.MallProductUI", intent);
                }
                return true;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
            return false;
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            x.d(str2, str3, objArr);
            try {
                ag.y(new 7(this, str, bitmap));
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                x.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar == null) {
            x.w("MicroMsg.TVInfoUI", "scene == null");
        } else if (kVar.getType() != 552) {
        } else {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, R.l.eIm, 0).show();
            } else if (this.qsB == null) {
                x.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
            } else {
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) kVar;
                agm com_tencent_mm_protocal_c_agm = (bVar.gJQ == null || bVar.gJQ.hmh.hmo == null) ? null : (agm) bVar.gJQ.hmh.hmo;
                if (com_tencent_mm_protocal_c_agm == null) {
                    x.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                } else if (com_tencent_mm_protocal_c_agm.vNZ != null) {
                    x.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + com_tencent_mm_protocal_c_agm.vNZ);
                    c.a Jo = c.Jo(com_tencent_mm_protocal_c_agm.vNZ);
                    if (this.qsB != null && this.qsB.field_xml != null && Jo != null && Jo.field_xml != null && !this.qsB.field_xml.equals(Jo.field_xml)) {
                        this.qsB = Jo;
                        a(this.qsB);
                    }
                }
            }
        }
    }
}
