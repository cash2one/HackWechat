package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.g;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int irz;
    private int lDQ;
    private String lDR;
    private String lDS;
    private String lDT;
    private String lDU;
    private String lDV;

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        g gVar = new g(emojiStoreTopicUI.mController.xIM, g.ztp, false);
        gVar.rKC = new 3(emojiStoreTopicUI);
        gVar.rKD = new 4(emojiStoreTopicUI);
        gVar.bUk();
        com.tencent.mm.plugin.report.service.g.pQN.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.lDQ)});
    }

    protected final void aCg() {
        super.aCg();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.pQN.h(12740, new Object[]{Integer.valueOf(3), "", "", Integer.valueOf(this.lDQ), Integer.valueOf(this.irz)});
    }

    protected final void initView() {
        this.lDQ = getIntent().getIntExtra("topic_id", -1);
        this.lDR = getIntent().getStringExtra("topic_name");
        this.lDU = getIntent().getStringExtra("topic_ad_url");
        this.lDS = getIntent().getStringExtra("topic_icon_url");
        this.lDT = getIntent().getStringExtra("topic_desc");
        this.lDV = getIntent().getStringExtra("sns_object_data");
        this.irz = getIntent().getIntExtra("extra_scence", 0);
        if (!bh.ov(this.lDV)) {
            this.lDQ = EmojiLogic.yq(this.lDV);
            this.lDR = EmojiLogic.yr(this.lDV);
            this.lDS = EmojiLogic.yt(this.lDV);
            this.lDT = EmojiLogic.ys(this.lDV);
            this.lDU = EmojiLogic.yu(this.lDV);
        }
        setMMTitle(this.lDR);
        super.initView();
        addIconOptionMenu(0, R.k.dzQ, new 1(this));
        showOptionMenu(0, false);
        yD(this.lDU);
    }

    protected final void yD(String str) {
        if (this.lAr != null && this.lAs != null && !bh.ov(str)) {
            a.getDensity(this);
            EmojiInfo a = EmojiLogic.a("Toptic", 8, str, true);
            if (a == null) {
                o.PA().a(str, null, f.c("Toptic", str, new Object[]{"Toptic", "BANNER"}), new 2(this));
                return;
            }
            this.lAs.cR(a.ckB(), null);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void a(com.tencent.mm.plugin.emoji.model.f fVar, boolean z, boolean z2) {
        super.a(fVar, z, z2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        aCx();
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bh.ov(stringExtra)) {
                x.d("MicroMsg.emoji.EmojiStoreTopicUI", ".." + stringExtra);
                int i3 = this.lDQ;
                String str = this.lDR;
                String str2 = this.lDT;
                String str3 = this.lDS;
                String str4 = this.lDU;
                i.aBA();
                k.a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(boolean z, com.tencent.mm.plugin.emoji.model.f fVar, boolean z2, boolean z3) {
        super.a(z, fVar, z2, z3);
    }

    protected final int aCq() {
        return 7;
    }

    public final int aCr() {
        return this.lDQ;
    }

    protected final boolean aCy() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a aCj() {
        return new com.tencent.mm.plugin.emoji.a.f(this.mController.xIM);
    }

    protected final boolean aCo() {
        if (bh.ov(this.lDU)) {
            return false;
        }
        return true;
    }

    protected final boolean aCn() {
        return false;
    }

    public final void l(Message message) {
        super.l(message);
        if (message.what == HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION) {
            yD(this.lDU);
        }
    }

    protected final int aCh() {
        return 11;
    }

    protected final int aCi() {
        return 14;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        super.a(i, i2, str, kVar);
        if (this.lAv) {
            showOptionMenu(0, false);
        } else {
            showOptionMenu(0, true);
        }
    }
}
