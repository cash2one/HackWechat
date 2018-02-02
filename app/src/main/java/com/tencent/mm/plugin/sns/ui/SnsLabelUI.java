package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimatedExpandableListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI extends MMActivity implements e {
    public static int[] rCN = new int[]{j.qLr, j.qLp, j.qLl, j.qLe};
    private AnimatedExpandableListView rCM;
    private ArrayList<String> rCO;
    private String rCP;
    private String rCQ;
    aq rCR;
    private int rCS = 0;
    private boolean rCT;
    private boolean rCU = false;
    private boolean rCV = false;
    private boolean rCW = false;
    private int rCX;
    private r rCY;
    private String rCZ;
    private int rDa;
    private ArrayList<String> rDb;
    private ArrayList<String> rDc;
    private ArrayList<Long> rDd;
    private ArrayList<String[]> rDe;

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i, ArrayList arrayList, String str, View view) {
        if (snsLabelUI.rCR == null || snsLabelUI.rCR.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.dxP);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.dxO);
            } else {
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.qIE);
            }
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.dAM);
            } else {
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.qIZ);
            }
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.dAL);
            } else {
                ((ImageView) view.findViewById(f.qED)).setImageResource(i.qIY);
            }
        }
    }

    static /* synthetic */ void f(SnsLabelUI snsLabelUI) {
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(j.dDo));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", s.p(new int[]{s.yTE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        if (snsLabelUI.rCX == 2) {
            if (snsLabelUI.rCR.rDp.size() > 0) {
                intent.putExtra("already_select_contact", bh.d(snsLabelUI.rCR.rDp, ","));
            }
        } else if (snsLabelUI.rCX == 3 && snsLabelUI.rCR.rDq.size() > 0) {
            intent.putExtra("already_select_contact", bh.d(snsLabelUI.rCR.rDq, ","));
        }
        d.a((Context) snsLabelUI, ".ui.contact.SelectContactUI", intent, 4003);
    }

    protected final int getLayoutId() {
        return g.qHt;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.qMr);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(JsApiSetAudioState.CTRL_INDEX, this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(635, this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(638, this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        this.rCR = new aq(this);
        Intent intent = getIntent();
        if (intent == null) {
            this.rCS = 0;
            this.rCR.style = 0;
            this.rCP = null;
            this.rCQ = null;
        } else {
            this.rCS = intent.getIntExtra("KLabel_range_index", 0);
            this.rCR.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.rCP = intent.getStringExtra("Klabel_name_list");
            this.rCQ = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                setMMTitle(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.rCR.rDl = this.rCS;
        if (this.rCR.style == 1) {
            findViewById(f.qEC).setBackgroundResource(i$c.black);
        }
        if (this.rCS == 2) {
            if (!TextUtils.isEmpty(this.rCP)) {
                this.rCR.rDn = bh.F(this.rCP.split(","));
            }
            if (!TextUtils.isEmpty(this.rCQ)) {
                this.rCR.rDp = bh.F(this.rCQ.split(","));
            }
        } else if (this.rCS == 3) {
            if (!TextUtils.isEmpty(this.rCP)) {
                this.rCR.rDo = bh.F(this.rCP.split(","));
            }
            if (!TextUtils.isEmpty(this.rCQ)) {
                this.rCR.rDq = bh.F(this.rCQ.split(","));
            }
        }
        com.tencent.mm.kernel.g.Dk();
        this.rCT = ((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(335873, Boolean.valueOf(true))).booleanValue();
        if (this.rCT) {
            this.rCV = true;
            this.rCW = true;
            if (bBj() > 0) {
                this.rCU = true;
            }
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(new u(1), 0);
        }
        initView();
    }

    protected final void initView() {
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.rCM = (AnimatedExpandableListView) findViewById(f.qEB);
        this.rCO = (ArrayList) a.aUX().aUS();
        this.rCR.rDm = booleanExtra;
        this.rCR.Q(this.rCO);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.bvw);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.rCM.addHeaderView(view);
        this.rCM.setAdapter(this.rCR);
        if (this.rCR.rDl == 2) {
            this.rCM.expandGroup(2);
        } else if (this.rCR.rDl == 3) {
            this.rCM.expandGroup(3);
        }
        this.rCM.setOnGroupClickListener(new 1(this));
        this.rCM.setOnChildClickListener(new 3(this));
        setBackBtn(new 4(this));
        a(0, getString(j.qLg), new 5(this), b.xJz);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        Intent intent2;
        if (i2 == -1 && i == 4003) {
            x.i("MicroMsg.SnsLabelUI", "the Activity completed");
            stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (bh.ov(stringExtra)) {
                stringExtra = intent.getStringExtra("Select_Contact");
                this.rCQ = new String(stringExtra);
                x.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                if (this.rCX == 2) {
                    this.rCR.rDp.clear();
                    if (!bh.ov(stringExtra)) {
                        this.rCR.rDp.addAll(bh.F(stringExtra.split(",")));
                        this.rCR.rDl = this.rCX;
                    }
                } else if (this.rCX == 3) {
                    this.rCR.rDq.clear();
                    if (!bh.ov(stringExtra)) {
                        this.rCR.rDq.addAll(bh.F(stringExtra.split(",")));
                        this.rCR.rDl = this.rCX;
                    }
                }
                this.rCR.notifyDataSetChanged();
                this.rCM.expandGroup(this.rCX);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            d.b(this.mController.xIM, "label", ".ui.ContactLabelEditUI", intent2, 4002);
        } else if (i2 == -1 && i == 4001) {
            stringExtra = intent.getStringExtra("Select_Contact");
            x.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
            if (!bh.ov(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                d.b(this, "label", ".ui.ContactLabelEditUI", intent2, 4002);
            }
        } else if (i2 == 0 && i == 4002 && intent != null) {
            stringExtra = intent.getStringExtra("k_sns_label_add_label");
            this.rCZ = intent.getStringExtra("k_sns_label_add_label");
            this.rCM.postDelayed(new 7(this, stringExtra), 300);
        }
    }

    private void goBack() {
        boolean z = false;
        int i = this.rCR.rDl;
        if (this.rCR.rDl != this.rCS) {
            if ((i == 2 && (this.rCR.rDn.size() != 0 || this.rCR.rDp.size() != 0)) || (i == 3 && (this.rCR.rDo.size() != 0 || this.rCR.rDq.size() != 0))) {
                z = true;
            } else if (i == 1 || i == 0) {
                z = true;
            }
        } else if (!((i != 2 || this.rCR.rDn.size() == 0 || (bh.d(this.rCR.rDn, ",").equals(this.rCP) && bh.d(this.rCR.rDp, ",").equals(this.rCQ))) && (i != 3 || this.rCR.rDo.size() == 0 || (bh.d(this.rCR.rDo, ",").equals(this.rCP) && bh.d(this.rCR.rDq, ",").equals(this.rCQ))))) {
            z = true;
        }
        if (z) {
            h.a(this, true, getString(j.qLk), "", getString(j.qLj), getString(j.qLi), new 8(this), new 9(this));
        } else {
            bBh();
        }
    }

    private void bBh() {
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.rCS);
        if (this.rCS == 2 || this.rCS == 3) {
            intent.putExtra("Klabel_name_list", this.rCP);
            intent.putExtra("Kother_user_name_list", this.rCQ);
        }
        setResult(-1, intent);
        finish();
    }

    final void bBi() {
        Intent intent = new Intent();
        if (this.rCR.rDl == 2) {
            this.rCP = bh.d(this.rCR.rDn, ",");
            this.rCQ = bh.d(this.rCR.rDp, ",");
            intent.putExtra("Klabel_name_list", this.rCP);
            intent.putExtra("Kother_user_name_list", this.rCQ);
        } else if (this.rCR.rDl == 3) {
            this.rCP = bh.d(this.rCR.rDo, ",");
            this.rCQ = bh.d(this.rCR.rDq, ",");
            intent.putExtra("Klabel_name_list", this.rCP);
            intent.putExtra("Kother_user_name_list", this.rCQ);
        }
        intent.putExtra("Ktag_range_index", this.rCR.rDl);
        setResult(-1, intent);
        finish();
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(JsApiSetAudioState.CTRL_INDEX, this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(635, this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(638, this);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        super.onDestroy();
    }

    public void onResume() {
        if (this.rCR != null && this.rCZ == null) {
            this.rCO = (ArrayList) a.aUX().aUS();
            this.rCR.Q(this.rCO);
            if ((this.rCO == null || this.rCO.size() == 0) && !((this.rCQ != null && this.rCQ.length() != 0) || this.rCR.rDl == 0 || this.rCR.rDl == 1)) {
                this.rCR.rDl = 0;
            }
            this.rCR.notifyDataSetChanged();
        }
        this.rCZ = null;
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsLabelUI", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.rCV) {
            String str2;
            switch (kVar.getType()) {
                case JsApiDestroyInstanceAudio.CTRL_INDEX /*290*/:
                    if (i != 0 || i2 != 0) {
                        x.i("MicroMsg.SnsLabelUI", "dz: error at delete tag list!");
                        return;
                    }
                    return;
                case JsApiSetAudioState.CTRL_INDEX /*292*/:
                    if (i == 0 && i2 == 0) {
                        Cursor cursor = ae.bvB().getCursor();
                        this.rDa = cursor.getCount();
                        if (this.rDa > 0) {
                            Object obj;
                            cursor.moveToFirst();
                            com.tencent.mm.plugin.sns.storage.s sVar = new com.tencent.mm.plugin.sns.storage.s();
                            int count = cursor.getCount();
                            this.rDc = new ArrayList(count);
                            this.rDb = new ArrayList(count);
                            this.rDe = new ArrayList(count);
                            this.rDd = new ArrayList(count);
                            while (!cursor.isAfterLast()) {
                                sVar.b(cursor);
                                if (sVar.field_memberList == null || sVar.field_memberList.length() == 0) {
                                    x.e("MicroMsg.SnsLabelUI", "dz:snstaginfo memberlist is null.");
                                } else {
                                    this.rDe.add(sVar.field_memberList.split(","));
                                    String str3 = sVar.field_tagName;
                                    ArrayList arrayList = this.rDc;
                                    List aUU = a.aUX().aUU();
                                    if (aUU == null) {
                                        obj = str3;
                                    } else if (aUU.contains(str3)) {
                                        obj = String.format(getString(j.qLh), new Object[]{str3});
                                    } else {
                                        str2 = str3;
                                    }
                                    arrayList.add(obj);
                                    this.rDb.add(str3);
                                    this.rDd.add(Long.valueOf(sVar.field_tagId));
                                }
                                cursor.moveToNext();
                            }
                            cursor.close();
                            if (this.rDb.size() != 0) {
                                obj = 1;
                                break;
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        if (this.rCW) {
                            this.rCR.rDl = this.rCX;
                            this.rCM.El(this.rCX);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Dj().CU().set(335873, Boolean.valueOf(false));
                        }
                        cursor.close();
                        if (this.rCU) {
                            this.rCV = true;
                            a.aUX().aX(this.rDc);
                        } else {
                            this.rCV = false;
                        }
                    } else {
                        bBk();
                        x.i("MicroMsg.SnsLabelUI", "dz: error at get sns tag list!");
                    }
                    this.rCW = false;
                    return;
                case 635:
                    if (i == 0 && i2 == 0) {
                        bX(this.rDe);
                        return;
                    }
                    bBk();
                    x.i("MicroMsg.SnsLabelUI", "dz: error at add contact label!");
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        Iterator it = this.rDb.iterator();
                        Iterator it2 = this.rDd.iterator();
                        while (it.hasNext()) {
                            long longValue = ((Long) it2.next()).longValue();
                            str2 = (String) it.next();
                            if (longValue != 0) {
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Di().gPJ.a(new w(longValue, str2), 0);
                            }
                        }
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(335874, Integer.valueOf(0));
                        this.rCO = (ArrayList) a.aUX().aUS();
                        com.tencent.mm.plugin.report.service.g.pQN.h(11455, new Object[]{"", "", Integer.valueOf(this.rDa), Integer.valueOf(this.rDc.size())});
                        this.rCM.postDelayed(new 10(this), 600);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(335873, Boolean.valueOf(false));
                        return;
                    }
                    bBk();
                    x.i("MicroMsg.SnsLabelUI", "dz: error at modify label list!");
                    return;
                default:
                    return;
            }
        }
    }

    private static int bBj() {
        com.tencent.mm.kernel.g.Dk();
        return ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(335874, Integer.valueOf(0))).intValue();
    }

    private void bBk() {
        com.tencent.mm.plugin.report.service.g.pQN.h(11455, new Object[]{"", "", Integer.valueOf(this.rDa), Integer.valueOf(0)});
        com.tencent.mm.kernel.g.Dk();
        int intValue = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(335874, Integer.valueOf(0))).intValue() + 1;
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().set(335874, Integer.valueOf(intValue));
        this.rDc = null;
        this.rCW = false;
        this.rCV = false;
        if (this.rCY != null && this.rCY.isShowing()) {
            this.rCY.dismiss();
        }
        if (this.rCU) {
            this.rCU = false;
            return;
        }
        intValue = j.qLu;
        if (bBj() > 1) {
            intValue = j.qLt;
        }
        h.a(this, intValue, j.dFU, new 2(this));
    }

    private void bX(List<String[]> list) {
        if (this.rDc != null && this.rDc.size() != 0) {
            Iterator it = this.rDc.iterator();
            Iterator it2 = list.iterator();
            List arrayList = new ArrayList(this.rDc.size());
            List arrayList2 = new ArrayList(this.rDc.size());
            while (it.hasNext()) {
                arrayList.add(a.aUX().Do((String) it.next()));
                arrayList2.add(bh.d(Arrays.asList((Object[]) it2.next()), ","));
                this.rCV = true;
            }
            a.aUX().h(arrayList, arrayList2);
        }
    }
}
