package com.tencent.mm.plugin.card.ui.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.g;

public final class n extends h {
    public n(g gVar, MMActivity mMActivity) {
        super(gVar, mMActivity);
    }

    public final int getLayoutId() {
        return R.i.dbL;
    }

    public final boolean i(b bVar) {
        if (bVar.atC().vRt) {
            oq oqVar = bVar.atC().vRs;
            if (oqVar == null || g.AA(oqVar.title)) {
                return true;
            }
            x.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
            return false;
        }
        x.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
        return false;
    }

    public final void d(ViewGroup viewGroup) {
        viewGroup.findViewById(R.h.bWw).setVisibility(8);
        viewGroup.findViewById(R.h.bWv).setVisibility(0);
    }

    public final void c(ViewGroup viewGroup, b bVar) {
        super.c(viewGroup, bVar);
        d(viewGroup, bVar);
    }

    final void d(final ViewGroup viewGroup, b bVar) {
        rs rsVar = bVar.atB().vSn;
        View findViewById = viewGroup.findViewById(R.h.bWy);
        if (rsVar == null || !rsVar.vZE) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        if (!g.AA(rsVar.vZF)) {
            ((TextView) viewGroup.findViewById(R.h.bWz)).setText(rsVar.vZF);
            ((ImageView) viewGroup.findViewById(R.h.bWx)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ n kWJ;

                public final void onClick(View view) {
                    Button button = (Button) viewGroup.findViewById(R.h.bWn);
                    View findViewById = viewGroup.findViewById(R.h.bWw);
                    if (button.getVisibility() != 0 || findViewById.getVisibility() != 0) {
                        if (findViewById.getVisibility() == 0) {
                            if (l.isNetworkAvailable(this.kWJ.kaY.mController.xIM)) {
                                findViewById.setVisibility(8);
                                viewGroup.findViewById(R.h.bWv).setVisibility(0);
                            } else {
                                d.a(this.kWJ.kaY, this.kWJ.kaY.getString(R.l.dOe), false);
                                return;
                            }
                        }
                        this.kWJ.kWw.d(c.kXt);
                    }
                }
            });
        }
    }

    public final boolean awX() {
        return false;
    }

    public final boolean awY() {
        return true;
    }

    public final void a(ViewGroup viewGroup, b bVar) {
        am.auQ().atS();
        viewGroup.findViewById(R.h.bWw).setVisibility(0);
        viewGroup.findViewById(R.h.bWv).setVisibility(8);
        oq oqVar = bVar.atC().vRs;
        if (oqVar != null) {
            viewGroup.findViewById(R.h.bWB).setVisibility(0);
            if (!g.AA(oqVar.title)) {
                Button button = (Button) viewGroup.findViewById(R.h.bWn);
                button.setText(oqVar.title);
                button.setVisibility(0);
                a(button, bVar);
                button.setOnClickListener(new 2(this, oqVar, bVar));
                if (!g.AA(oqVar.kJQ)) {
                    ((TextView) viewGroup.findViewById(R.h.bWp)).setText(oqVar.kJQ);
                }
                TextView textView = (TextView) viewGroup.findViewById(R.h.bWA);
                if (g.AA(oqVar.kJR)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setText(oqVar.kJR);
                textView.setVisibility(0);
            }
        }
    }

    public final void b(ViewGroup viewGroup, b bVar) {
        x.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        final View findViewById = viewGroup.findViewById(R.h.bWw);
        if (findViewById.getVisibility() == 0) {
            x.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(R.h.bWy);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.h.bWv);
        imageView.setVisibility(8);
        final View findViewById3 = viewGroup.findViewById(R.h.bWB);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(R.h.bWp)).setText(this.kaY.getResources().getString(R.l.dNQ));
        final Button button = (Button) viewGroup.findViewById(R.h.bWn);
        button.setVisibility(0);
        a(button, bVar);
        com.tencent.mm.plugin.card.a.g auQ = am.auQ();
        if (bVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            auQ.atS();
            k wj = am.auO().wj(bVar.atF());
            if (wj != null) {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[]{wj.field_card_id, wj.field_code_id});
                if (am.auO().bP(bVar.atF(), wj.field_code_id)) {
                    auQ.a(bVar.atF(), wj.field_code_id, c.kXs);
                } else {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[]{wj.field_card_id, wj.field_code_id});
                }
            } else {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        final ViewGroup viewGroup2 = viewGroup;
        final b bVar2 = bVar;
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ n kWJ;

            public final void onClick(View view) {
                findViewById.setVisibility(8);
                findViewById3.setVisibility(8);
                imageView.setVisibility(0);
                button.setVisibility(8);
                this.kWJ.kWw.d(c.kXs);
                this.kWJ.d(viewGroup2, bVar2);
            }
        });
    }

    private void a(Button button, b bVar) {
        String str = bVar.atB().hbM;
        if (!g.AA(str)) {
            int wO = l.wO(str);
            button.setText(this.kaY.getResources().getString(R.l.dNR));
            button.setTextColor(wO);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.kaY.getResources().getColor(R.e.brL));
            gradientDrawable.setStroke(2, wO);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
    }
}
