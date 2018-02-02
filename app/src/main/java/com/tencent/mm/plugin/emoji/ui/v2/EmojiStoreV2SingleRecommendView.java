package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class EmojiStoreV2SingleRecommendView extends RecommendView implements OnClickListener, b {
    private ViewGroup jFk;
    protected final int lAD = 131074;
    private final int lAE = 131075;
    private final int lAF = 131076;
    private final String lAG = "product_id";
    private final String lAH = "progress";
    private final String lAI = DownloadInfo.STATUS;
    private g lAg;
    private ImageView lCZ;
    private String lDs;
    private af lFk = new 1(this);
    private ImageView lHN;
    private TextView lHO;
    private TextView lHP;
    private Button lHQ;
    private ProgressBar lHR;
    private EmojiGroupInfo lHS;
    private boolean lHT = true;
    private c lHU = new 2(this);
    private String lyx;

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        this.lHT = z;
        init();
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        a.xef.b(this.lHU);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        a.xef.c(this.lHU);
    }

    private void init() {
        if (this.lHT) {
            this.jFk = (ViewGroup) v.fv(getContext()).inflate(R.i.dge, this);
        } else {
            this.jFk = (ViewGroup) v.fv(getContext()).inflate(R.i.dgf, this);
        }
        this.lCZ = (ImageView) this.jFk.findViewById(R.h.cdo);
        this.lHN = (ImageView) this.jFk.findViewById(R.h.cdz);
        this.lHO = (TextView) this.jFk.findViewById(R.h.cdZ);
        this.lHP = (TextView) this.jFk.findViewById(R.h.ceb);
        this.lHQ = (Button) this.jFk.findViewById(R.h.bBO);
        this.lHR = (ProgressBar) this.jFk.findViewById(R.h.cdv);
    }

    public final void yN(String str) {
        this.lyx = str;
        if (bh.ov(this.lyx)) {
            this.jFk.setVisibility(8);
            return;
        }
        this.lHS = i.aBE().lwM.bf(this.lyx, false);
        this.lCZ.setOnClickListener(this);
        this.lHQ.setOnClickListener(this);
        this.jFk.setOnClickListener(this);
        EmojiGroupInfo emojiGroupInfo = this.lHS;
        if (this.lHQ != null) {
            switch (emojiGroupInfo.field_buttonType) {
                case 1:
                    this.lHQ.setVisibility(0);
                    this.lHQ.setText(R.l.eas);
                    break;
                case 2:
                    this.lHQ.setVisibility(0);
                    this.lHQ.setText(R.l.euZ);
                    break;
                default:
                    this.lHQ.setVisibility(8);
                    break;
            }
        }
        if (!bh.ov(emojiGroupInfo.field_packName)) {
            this.lHO.setText(emojiGroupInfo.field_packName);
        }
        if (this.lHP != null) {
            if (bh.ov(emojiGroupInfo.field_recommandWord)) {
                this.lHP.setVisibility(8);
            } else {
                this.lHP.setVisibility(0);
                this.lHP.setText(emojiGroupInfo.field_recommandWord);
            }
        }
        this.lHR.setVisibility(8);
        o.PA().a(this.lHS.field_BigIconUrl, this.lHN, f.c(this.lyx, this.lHS.field_BigIconUrl, new Object[0]));
    }

    public final void I(String str, String str2, String str3) {
        ar.CG().a(new g(str, str2, str3), 0);
    }

    public final void aBw() {
    }

    public final void m(Message message) {
        if (this.lFk != null) {
            this.lFk.sendMessage(message);
        }
    }

    private void c(so soVar) {
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", soVar.vIR);
        intent.putExtra("extra_name", soVar.war);
        intent.putExtra("extra_copyright", soVar.waB);
        intent.putExtra("extra_coverurl", soVar.waz);
        intent.putExtra("extra_description", soVar.was);
        intent.putExtra("extra_price", soVar.wau);
        intent.putExtra("extra_type", soVar.wav);
        intent.putExtra("extra_flag", soVar.waw);
        intent.putExtra("extra_price_num", soVar.waC);
        intent.putExtra("extra_price_type", soVar.waD);
        intent.putExtra("preceding_scence", 108);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        getContext().startActivity(intent);
    }

    public void onClick(View view) {
        if (view == this.lCZ) {
            i.aBE().lwM.XQ(this.lyx);
            com.tencent.mm.plugin.report.service.g.pQN.h(12068, new Object[]{Integer.valueOf(2), this.lyx, Integer.valueOf(this.lHS.field_recommandType)});
        } else if (view == this.jFk) {
            c(this.lHS.cjY());
            com.tencent.mm.plugin.report.service.g.pQN.h(12068, new Object[]{Integer.valueOf(4), this.lyx, Integer.valueOf(this.lHS.field_recommandType)});
        } else if (view != this.lHQ) {
            x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
        } else if (this.lHS.field_buttonType == 1) {
            this.lAg = new g(this.lyx);
            ar.CG().a(this.lAg, 0);
            com.tencent.mm.plugin.report.service.g.pQN.h(12068, new Object[]{Integer.valueOf(3), this.lyx, Integer.valueOf(this.lHS.field_recommandType)});
            com.tencent.mm.plugin.report.service.g.pQN.h(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(8), "", this.lyx});
        } else if (this.lHS.field_buttonType == 2) {
            c(this.lHS.cjY());
            com.tencent.mm.plugin.report.service.g.pQN.h(12068, new Object[]{Integer.valueOf(4), this.lyx, Integer.valueOf(this.lHS.field_recommandType)});
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
    }
}
