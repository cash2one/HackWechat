package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity fmM;
    private boolean okA = true;
    private ImageButton oku;
    ChatFooterPanel okx;
    MMEditText rGA = null;
    SightRangeWidget rGB;
    SightLocationWidget rGC;

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        if (snsSightUploadSayFooter.okx.getVisibility() == 8) {
            snsSightUploadSayFooter.fmM.aWs();
            snsSightUploadSayFooter.okx.onResume();
            snsSightUploadSayFooter.okx.setVisibility(0);
            snsSightUploadSayFooter.rGA.requestFocus();
            snsSightUploadSayFooter.oku.setImageResource(i.qIU);
            snsSightUploadSayFooter.okA = false;
            return;
        }
        snsSightUploadSayFooter.okA = false;
        snsSightUploadSayFooter.rGA.requestFocus();
        snsSightUploadSayFooter.hideSmileyPanel();
        snsSightUploadSayFooter.fmM.showVKB();
        snsSightUploadSayFooter.oku.setImageResource(i.qIT);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.fmM, g.qHP, this);
        this.oku = (ImageButton) viewGroup.findViewById(f.bJQ);
        this.oku.setOnClickListener(new 4(this));
        if (e.vro == null) {
            this.okx = new d(this.fmM);
        } else {
            this.okx = e.vro.cv(getContext());
            this.okx.ej(ChatFooterPanel.SCENE_SNS);
            this.okx.setVisibility(8);
            ((LinearLayout) findViewById(f.cIu)).addView(this.okx, -1, 0);
            this.okx.tj();
            this.okx.aF(false);
            this.okx.vjB = new 5(this);
        }
        this.rGB = (SightRangeWidget) viewGroup.findViewById(f.qDe);
        this.rGB.rrm = null;
        this.rGB.style = 1;
        this.rGC = (SightLocationWidget) viewGroup.findViewById(f.qCO);
    }

    private void hideSmileyPanel() {
        this.okx.onPause();
        this.okx.setVisibility(8);
    }

    protected final List<View> aXT() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.okx);
        return arrayList;
    }
}
