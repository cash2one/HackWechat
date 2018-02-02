package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    f jKn;
    private b kIK;
    private List<com.tencent.mm.plugin.card.model.b> kIO = new ArrayList();
    private TextView kQt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.kIK = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.kIK == null || this.kIK.atB() == null || this.kIK.atC() == null) {
            x.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kIK.atB().kKZ)) {
            stringBuilder.append(this.kIK.atB().kKZ);
        }
        stringBuilder.append(getString(R.l.dNZ));
        setMMTitle(stringBuilder.toString());
        setBackBtn(new 1(this));
        this.jKn = this.yjd;
        this.kIO.clear();
        if (this.kIK.atC().vRa != null && this.kIK.atC().vRa.size() > 0) {
            this.kIO.addAll(l.am(this.kIK.atC().vRa));
        }
        if (this.kIK.atC().vRb != null && this.kIK.atC().vRb.size() > 0) {
            Collection am = l.am(this.kIK.atC().vRb);
            ((com.tencent.mm.plugin.card.model.b) am.get(0)).kKb = true;
            this.kIO.addAll(am);
        }
        avt();
        avs();
        avr();
        if (!TextUtils.isEmpty(this.kIK.atB().vRK)) {
            Preference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.i.dnt);
            cardTextPreference.setTitle(getString(R.l.dOS));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.axk();
            avt();
            this.jKn.a(cardTextPreference);
        }
        if (!TextUtils.isEmpty(this.kIK.atB().vRH)) {
            avt();
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.i.dnt);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle(R.l.dOB);
            cardTextPreference.setSummary(this.kIK.atB().vRH);
            cardTextPreference.kXT = getResources().getColor(R.e.btd);
            cardTextPreference.axj();
            this.jKn.a(cardTextPreference);
            wz("");
        }
        if (this.kIK.atB() != null && !TextUtils.isEmpty(this.kIK.atB().bhd) && this.kQt != null) {
            this.kQt.setText(this.kIK.atB().bhd);
            this.kQt.setVisibility(0);
        }
    }

    private void avr() {
        for (int i = 0; i < this.kIO.size(); i++) {
            com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kIO.get(i);
            Preference preference = new Preference(this);
            preference.setLayoutResource(R.i.dnt);
            preference.setKey(bVar.title);
            preference.setTitle(bVar.title);
            if (!TextUtils.isEmpty(bVar.kJQ)) {
                preference.setSummary(bVar.kJQ);
            }
            if (bVar.kKb) {
                avt();
            }
            this.jKn.a(preference);
        }
    }

    private void avs() {
        if (this.kIK.atB().vRJ != null && this.kIK.atB().vRJ != null) {
            for (int i = 0; i < this.kIK.atB().vRJ.size(); i++) {
                oq oqVar = (oq) this.kIK.atB().vRJ.get(i);
                if (!TextUtils.isEmpty(oqVar.kJQ)) {
                    Preference cardTextPreference = new CardTextPreference(this);
                    cardTextPreference.setLayoutResource(R.i.dnt);
                    cardTextPreference.setTitle(oqVar.kJQ);
                    cardTextPreference.axk();
                    wz(oqVar.title);
                    this.jKn.a(cardTextPreference);
                }
            }
            avt();
        }
    }

    private void avt() {
        this.jKn.a(new PreferenceSmallCategory(this));
    }

    private void wz(String str) {
        Preference preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle(" ");
        } else {
            preferenceTitleCategory.setTitle(str);
        }
        this.jKn.a(preferenceTitleCategory);
    }

    public final int XB() {
        return R.o.fbl;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.ibD.equals("card_phone")) {
            String str = this.kIK.atB().vRH;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            startActivity(intent);
        }
        if (preference.ibD.equals("key_pic_detail")) {
            com.tencent.mm.plugin.card.b.b.a(this, this.kIK.atB().vRK, 0);
        } else {
            for (int i = 0; i < this.kIO.size(); i++) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kIO.get(i);
                if (!(bVar.title == null || !bVar.title.equals(preference.ibD) || TextUtils.isEmpty(bVar.url))) {
                    if (com.tencent.mm.plugin.card.b.b.d(this.kIK.atF(), bVar.vRx, bVar.vRy, 1028, 0)) {
                        break;
                    }
                    com.tencent.mm.plugin.card.b.b.a(this, bVar.url, 1);
                }
            }
        }
        return false;
    }

    public final View avu() {
        View inflate = getLayoutInflater().inflate(R.i.cPa, null);
        this.kQt = (TextView) inflate.findViewById(R.h.cOY);
        this.kQt.setVisibility(8);
        return inflate;
    }
}
