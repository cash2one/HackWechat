package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI extends DrawStatusBarActivity implements e, a {
    int fGW = 8;
    private String hcc = "";
    private r jmO = null;
    protected ListView kIe = null;
    protected RelativeLayout kIg = null;
    private boolean kJZ = false;
    private String kLY = "";
    private int kLZ;
    private String kMa;
    private int kMb;
    private String kMc;
    private Button kOn;
    public int kOu = 0;
    private String kOv = "";
    private String kOw = "";
    public ArrayList<String> kOx = new ArrayList();
    public ArrayList<String> kOy = new ArrayList();
    HashMap<String, Integer> kPK = new HashMap();
    private View kPQ;
    private View kPR;
    private View kPS;
    protected a kPT = null;
    private View kPU;
    private View kPV;
    private TextView kPW;
    private Button kPX;
    LinkedList<kh> kPY = new LinkedList();
    int kPZ = 7;
    String kQa = "";
    String kQb = "";
    private String kQc = "";
    LinkedList<kh> kQd = new LinkedList();
    LinkedList<String> kQe = new LinkedList();

    static /* synthetic */ void a(CardAcceptCardListUI cardAcceptCardListUI, LinkedList linkedList) {
        cardAcceptCardListUI.dY(true);
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            kh khVar = (kh) linkedList.get(i);
            bia com_tencent_mm_protocal_c_bia = new bia();
            com_tencent_mm_protocal_c_bia.kJN = khVar.kJN;
            com_tencent_mm_protocal_c_bia.fGV = khVar.fGV;
            com_tencent_mm_protocal_c_bia.vEH = cardAcceptCardListUI.kQa;
            com_tencent_mm_protocal_c_bia.vEG = cardAcceptCardListUI.kQb;
            com_tencent_mm_protocal_c_bia.vEI = cardAcceptCardListUI.kPZ;
            linkedList2.add(com_tencent_mm_protocal_c_bia);
        }
        bii a = l.a(cardAcceptCardListUI.kOu, cardAcceptCardListUI.kOx, cardAcceptCardListUI.kOy);
        blp com_tencent_mm_protocal_c_blp = new blp();
        com_tencent_mm_protocal_c_blp.wPf = cardAcceptCardListUI.hcc;
        ar.CG().a(new g(0, linkedList2, "", cardAcceptCardListUI.kQc, a, cardAcceptCardListUI.fGW, com_tencent_mm_protocal_c_blp), 0);
    }

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.kPY.size(); i++) {
            linkedList.add(cardAcceptCardListUI.kPY.get(i));
        }
        return linkedList;
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        x.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        com.tencent.mm.plugin.report.service.g.pQN.h(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), "", "", "", ""});
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.kOu);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.kOv);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.kOw);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(R.l.dPl));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("KLabel_is_filter_private", true);
        d.b(cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.jwN = cardAcceptCardListUI;
    }

    protected final int getLayoutId() {
        return R.i.bPu;
    }

    protected final void initView() {
        setMMTitle(R.l.dNu);
        setBackBtn(new 1(this));
        this.kPQ = findViewById(R.h.bPu);
        this.kPR = findViewById(R.h.cSC);
        this.kPS = findViewById(R.h.ctb);
        this.kPR.setVisibility(4);
        this.kIe = (ListView) findViewById(16908298);
        this.kIg = (RelativeLayout) findViewById(R.h.bYR);
        this.kIe.setEmptyView(this.kIg);
        this.kPT = new a(this);
        this.kIe.setAdapter(this.kPT);
        this.kIe.setOnItemClickListener(new 2(this));
        this.kPU = findViewById(R.h.bPy);
        this.kOn = (Button) findViewById(R.h.bPp);
        this.kOn.setOnClickListener(new 3(this));
        this.kOn.setEnabled(false);
        this.kPV = findViewById(R.h.bRK);
        this.kPW = (TextView) findViewById(R.h.bRL);
        this.kPX = (Button) findViewById(R.h.bRJ);
        this.kPX.setOnClickListener(new 4(this));
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            nQ(2);
            return;
        }
        x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.fGW = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.kPZ = getIntent().getIntExtra("key_stastic_scene", 7);
        this.kQa = getIntent().getStringExtra("src_username");
        this.kQb = getIntent().getStringExtra("js_url");
        this.kQc = getIntent().getStringExtra("key_consumed_card_id");
        this.hcc = getIntent().getStringExtra("key_template_id");
        Collection aX = h.aX(stringExtra, this.fGW);
        if (aX == null || aX.size() == 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            nQ(2);
            return;
        }
        this.kPY.clear();
        this.kPY.addAll(aX);
        this.kQd.clear();
        this.kQe.clear();
        this.kPK.clear();
        LinkedList linkedList = this.kPY;
        dY(true);
        ar.CG().a(new ab(linkedList, this.fGW, stringExtra2, stringExtra3, this.kQa, this.kQb, this.kQc, this.kPZ), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(690, this);
        ar.CG().a(687, this);
        ar.CG().a(902, this);
        initView();
    }

    protected void onDestroy() {
        ar.CG().b(690, this);
        ar.CG().b(687, this);
        ar.CG().b(902, this);
        this.kPY.clear();
        a aVar = this.kPT;
        aVar.kOM.clear();
        aVar.mContext = null;
        super.onDestroy();
    }

    void dY(boolean z) {
        if (z) {
            this.jmO = r.b(this, getString(R.l.ctB), false, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + kVar.getType() + "errType = " + i + " errCode = " + i2);
            dY(false);
            com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            if (kVar instanceof p) {
                this.kLY = str;
            } else if (kVar instanceof g) {
                this.kLY = "";
            }
        } else if (kVar instanceof ab) {
            dY(false);
            ab abVar = (ab) kVar;
            r0 = abVar.kLN;
            this.kLZ = abVar.kLZ;
            this.kMa = abVar.kMa;
            this.kMb = abVar.kMb;
            this.kMc = abVar.kMc;
            x.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.kLZ + "  accept_button_wording: " + this.kMa);
            x.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.kMb + "  private_wording: " + this.kMc);
            List wH = f.wH(r0);
            Collection al = al(wH);
            if (wH == null || wH.size() <= 0) {
                x.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                x.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + wH.size());
                if (al != null && al.size() > 0) {
                    a aVar = this.kPT;
                    Map map = this.kPK;
                    if (al != null) {
                        aVar.kOM.clear();
                        aVar.kOM.addAll(al);
                        aVar.kPK.putAll(map);
                    }
                }
                this.kPT.notifyDataSetChanged();
                if (((CardInfo) wH.get(0)).ath()) {
                    this.kJZ = true;
                }
            }
            this.kPR.setVisibility(0);
            if (this.kPT.getCount() > 0) {
                Drawable ch;
                CardInfo nP = this.kPT.nP(0);
                m.a(this, nP);
                this.kPQ.setBackgroundColor(l.wO(nP.atB().hbM));
                com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, l.wO(nP.atB().hbM), true);
                this.kPU.setVisibility(0);
                Drawable stateListDrawable = new StateListDrawable();
                r2 = getResources().getDimensionPixelOffset(R.f.bwy);
                if (this.kLZ == 1) {
                    this.kOn.setEnabled(true);
                    ch = l.ch(l.wO(nP.atB().hbM), r2);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, l.ch(l.ba(nP.atB().hbM, ac.CTRL_BYTE), r2));
                    stateListDrawable.addState(new int[0], ch);
                } else {
                    this.kOn.setEnabled(false);
                    stateListDrawable.addState(new int[0], l.ch(l.ba(nP.atB().hbM, ac.CTRL_BYTE), r2));
                }
                this.kOn.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.kMa)) {
                    this.kOn.setText(this.kMa);
                }
                if (this.kMb == 1) {
                    int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.bvJ);
                    Drawable d = l.d(this, getResources().getColor(R.e.white), dimensionPixelOffset);
                    stateListDrawable = l.ch(getResources().getColor(R.e.white), dimensionPixelOffset);
                    ch = new StateListDrawable();
                    ch.addState(new int[]{16842919}, stateListDrawable);
                    ch.addState(new int[0], d);
                    this.kPX.setBackgroundDrawable(ch);
                    int[] iArr2 = new int[]{l.wO(nP.atB().hbM), getResources().getColor(R.e.white)};
                    this.kPX.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.kPV.setVisibility(0);
                    if (TextUtils.isEmpty(this.kMc)) {
                        this.kPW.setText(R.l.dPi);
                        return;
                    } else {
                        this.kPW.setText(this.kMc);
                        return;
                    }
                }
                this.kPV.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.kPR.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.bvS);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.f.bvx);
                this.kPR.setLayoutParams(layoutParams);
                this.kPR.invalidate();
                layoutParams = (LayoutParams) this.kPU.getLayoutParams();
                layoutParams.addRule(8, R.h.ctb);
                this.kPU.setLayoutParams(layoutParams);
                this.kPU.invalidate();
                return;
            }
            this.kPU.setVisibility(8);
            this.kPV.setVisibility(8);
            this.kPQ.setBackgroundColor(getResources().getColor(R.e.brI));
        } else if (kVar instanceof p) {
            dY(false);
            p pVar = (p) kVar;
            if (pVar.kLO != 0) {
                r0 = pVar.kLP;
                if (TextUtils.isEmpty(r0)) {
                    r0 = getString(R.l.dNI);
                }
                com.tencent.mm.ui.base.h.a(this, r0, null, false, new 5(this));
                this.kLY = pVar.kLN;
                return;
            }
            com.tencent.mm.ui.base.h.bu(this, getResources().getString(R.l.dOn));
            r0 = new Intent();
            r0.putExtra("card_list", pVar.kLN);
            setResult(-1, r0);
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            l.axe();
            finish();
        } else if (kVar instanceof g) {
            dY(false);
            String str2 = ((g) kVar).kLN;
            r2 = ((g) kVar).kLO;
            r0 = ((g) kVar).kLP;
            this.kLY = str2;
            if (r2 != 0) {
                if (TextUtils.isEmpty(r0)) {
                    r0 = getString(R.l.dPr);
                }
                com.tencent.mm.ui.base.h.a(this, r0, null, false, new OnClickListener(this) {
                    final /* synthetic */ CardAcceptCardListUI kQf;

                    {
                        this.kQf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kQf.nQ(2);
                    }
                });
                return;
            }
            com.tencent.mm.ui.base.h.bu(this, getResources().getString(R.l.dNz));
            r0 = new Intent();
            r0.putExtra("card_list", this.kLY);
            setResult(-1, r0);
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            l.axg();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            f.a(shareCardInfo, str2);
            l.a(shareCardInfo);
            am.auH().asi();
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            nQ(1);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void nQ(int i) {
        x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:" + i);
        Intent intent = new Intent();
        intent.putExtra("card_list", this.kLY);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
    }

    public final void b(int i, int i2, Intent intent) {
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.kOu = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.kOu)});
                    if (this.kOu >= 2) {
                        this.kOv = intent.getStringExtra("Klabel_name_list");
                        this.kOw = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.kOu), this.kOv});
                        if (TextUtils.isEmpty(this.kOv) && TextUtils.isEmpty(this.kOw)) {
                            x.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                            avq();
                            return;
                        }
                        List asList = Arrays.asList(this.kOv.split(","));
                        this.kOy = l.ao(asList);
                        this.kOx = l.an(asList);
                        if (this.kOw != null && this.kOw.length() > 0) {
                            this.kOx.addAll(Arrays.asList(this.kOw.split(",")));
                        }
                        if (this.kOy != null) {
                            x.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.kOy.size());
                        }
                        if (this.kOx != null) {
                            x.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.kOx.size());
                            Iterator it = this.kOx.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (TextUtils.isEmpty(this.kOv)) {
                            avq();
                            return;
                        } else if (this.kOu == 2) {
                            this.kPW.setText(getString(R.l.dPk, new Object[]{avc()}));
                            return;
                        } else if (this.kOu == 3) {
                            this.kPW.setText(getString(R.l.dPj, new Object[]{avc()}));
                            return;
                        } else {
                            return;
                        }
                    }
                    avq();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String avc() {
        if (!TextUtils.isEmpty(this.kOv) && !TextUtils.isEmpty(this.kOw)) {
            return this.kOv + "," + l.wS(this.kOw);
        }
        if (!TextUtils.isEmpty(this.kOv)) {
            return this.kOv;
        }
        if (TextUtils.isEmpty(this.kOw)) {
            return "";
        }
        return l.wS(this.kOw);
    }

    private void avq() {
        if (TextUtils.isEmpty(this.kMc)) {
            this.kPW.setText(R.l.dPi);
        } else {
            this.kPW.setText(this.kMc);
        }
    }

    private ArrayList<CardInfo> al(List<CardInfo> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            return null;
        }
        this.kQd.clear();
        this.kQe.clear();
        this.kPK.clear();
        ArrayList<CardInfo> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            CardInfo cardInfo = (CardInfo) list.get(i);
            if (this.kQe.contains(cardInfo.field_card_tp_id)) {
                this.kPK.put(cardInfo.field_card_tp_id, Integer.valueOf(((Integer) this.kPK.get(cardInfo.field_card_tp_id)).intValue() + 1));
            } else {
                arrayList.add(cardInfo);
                this.kPK.put(cardInfo.field_card_tp_id, Integer.valueOf(1));
                this.kQe.add(cardInfo.field_card_tp_id);
            }
        }
        return arrayList;
    }
}
