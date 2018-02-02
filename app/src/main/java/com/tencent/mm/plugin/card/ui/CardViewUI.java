package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Collection;
import java.util.LinkedList;

public class CardViewUI extends CardBaseUI {
    private int aac = 1;
    private String hcc = "";
    private int kFm;
    private LinkedList<kp> kPY = new LinkedList();
    private int kRu;
    private String kVK;
    private View kVL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            return;
        }
        this.kFm = intent.getIntExtra("key_previous_scene", 7);
        this.kRu = intent.getIntExtra("key_from_appbrand_type", 0);
        this.aac = intent.getIntExtra("view_type", 0);
        this.kVK = intent.getStringExtra("user_name");
        Object stringExtra = intent.getStringExtra("card_list");
        this.hcc = getIntent().getStringExtra("key_template_id");
        if (this.aac == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                x.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                return;
            }
            Collection aZ = k.aZ(stringExtra, this.kFm);
            if (aZ != null && aZ.size() > 0) {
                this.kPY.clear();
                this.kPY.addAll(aZ);
            }
        }
        initView();
    }

    protected void onDestroy() {
        ar.CG().b(699, this);
        super.onDestroy();
    }

    public void onSwipeBack() {
        super.onSwipeBack();
        if (this.kFm == 26) {
            overridePendingTransition(0, 0);
        }
    }

    protected final void asS() {
        int i;
        if (this.aac == 0) {
            setMMTitle(R.l.dPQ);
        } else if (this.aac == 1) {
            setMMTitle(R.l.dOm);
        }
        ar.CG().a(699, this);
        int i2 = R.l.dNt;
        if (this.aac == 0) {
            dY(true);
            blp com_tencent_mm_protocal_c_blp = new blp();
            com_tencent_mm_protocal_c_blp.wPf = this.hcc;
            x.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.hcc});
            ar.CG().a(new t(this.kPY, com_tencent_mm_protocal_c_blp, this.kFm), 0);
            i = R.l.dNt;
        } else if (this.aac == 1) {
            this.kVL = View.inflate(this, R.i.dcm, null);
            if (this.kIh != null) {
                this.kIh.addView(this.kVL);
            }
            i = R.l.dPw;
        } else {
            i = i2;
        }
        findViewById(R.h.cAp).setVisibility(8);
        ((TextView) findViewById(R.h.cAr)).setText(i);
    }

    protected final int asT() {
        return a.kLI;
    }

    protected final BaseAdapter asU() {
        if (this.aac == 0) {
            return new g(getApplicationContext());
        }
        return super.asU();
    }

    protected final boolean asW() {
        if (this.aac == 1) {
            return false;
        }
        return super.asW();
    }

    protected final void b(b bVar) {
        if (this.aac == 1) {
            a((CardInfo) bVar);
        } else {
            super.b(bVar);
        }
    }

    protected final void asX() {
    }

    protected final void a(CardInfo cardInfo) {
        if (this.aac == 1) {
            this.kIm = cardInfo;
            j(this.kVK, 1, true);
            return;
        }
        super.a(cardInfo);
        if (this.kIm != null) {
            g.pQN.h(11582, new Object[]{"OperGift", Integer.valueOf(4), Integer.valueOf(this.kIm.atB().kJO), this.kIm.field_card_tp_id, this.kIm.field_card_id, this.kVK});
        }
    }

    protected final void a(b bVar) {
        if (this.aac == 0) {
            am.auF().kIm = (CardInfo) bVar;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) bVar).field_card_id);
            intent.putExtra("key_from_scene", 51);
            intent.putExtra("key_from_appbrand_type", this.kRu);
            startActivity(intent);
            return;
        }
        super.a(bVar);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        int i3 = 0;
        if (kVar instanceof t) {
            dY(false);
            if (i == 0 && i2 == 0) {
                Object obj = ((t) kVar).kLU;
                if (obj != null && obj.size() > 0) {
                    if (this.kIf instanceof g) {
                        g gVar = (g) this.kIf;
                        if (obj != null) {
                            gVar.kOM.clear();
                            gVar.kOM.addAll(obj);
                            gVar.kTO.clear();
                            while (i3 < obj.size()) {
                                gVar.kTO.add(new Boolean(true));
                                i3++;
                            }
                        }
                    }
                    this.kIf.notifyDataSetChanged();
                    return;
                }
                return;
            }
            d.b(this, str, i2);
            return;
        }
        super.a(i, i2, str, kVar);
    }
}
