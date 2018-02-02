package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsUploadSayFooter extends BasePanelKeybordLayout {
    private MMActivity fmM;
    private boolean okA = true;
    ImageButton oku;
    ChatFooterPanel okx;
    MMEditText rGA = null;

    static /* synthetic */ void b(SnsUploadSayFooter snsUploadSayFooter) {
        if (snsUploadSayFooter.okx.getVisibility() == 8) {
            snsUploadSayFooter.fmM.aWs();
            snsUploadSayFooter.okx.onResume();
            snsUploadSayFooter.okx.setVisibility(0);
            snsUploadSayFooter.rGA.requestFocus();
            snsUploadSayFooter.oku.setImageResource(i$e.qzQ);
            snsUploadSayFooter.okA = false;
            return;
        }
        snsUploadSayFooter.okA = false;
        snsUploadSayFooter.rGA.requestFocus();
        snsUploadSayFooter.hideSmileyPanel();
        snsUploadSayFooter.fmM.showVKB();
        snsUploadSayFooter.oku.setImageResource(i$e.qzU);
    }

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        this.oku = (ImageButton) ((ViewGroup) v.fv(this.fmM).inflate(g.qIi, this)).findViewById(f.bJQ);
        this.oku.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsUploadSayFooter rLG;

            {
                this.rLG = r1;
            }

            public final void onClick(View view) {
                SnsUploadSayFooter.b(this.rLG);
            }
        });
        if (e.vro == null) {
            this.okx = new d(this.fmM);
            return;
        }
        this.okx = e.vro.cv(getContext());
        this.okx.ej(ChatFooterPanel.SCENE_SNS);
        this.okx.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(f.cIu);
        linearLayout.setOnClickListener(null);
        linearLayout.addView(this.okx, -1, 0);
        this.okx.tj();
        this.okx.aF(false);
        this.okx.vjB = new 4(this);
    }

    public final boolean bCe() {
        return this.okx.getVisibility() == 0;
    }

    public final void bCf() {
        hideSmileyPanel();
        setVisibility(8);
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
