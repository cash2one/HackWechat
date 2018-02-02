package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class l extends k {
    RelativeLayout nTM;
    Button rjv;
    View rjw;

    static /* synthetic */ void a(l lVar) {
        if (lVar.context instanceof SnsAdNativeLandingPagesUI) {
            ((SnsAdNativeLandingPagesUI) lVar.context).a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgu, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgr, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgs, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgt, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgp == 1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgq == 1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) lVar.rji).rgo == 1);
        }
        lVar.rjw.setPressed(false);
    }

    public l(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l bxl() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji;
    }

    protected final int bjK() {
        return i$g.qGM;
    }

    @TargetApi(17)
    protected final void bxa() {
        int i;
        this.riW = 0;
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgQ <= 0.0f || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgQ >= ((float) (width * 2))) {
            i = width;
        } else {
            i = ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgP) + (((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgQ) + ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgO));
        }
        this.nTM.setBackgroundColor(this.backgroundColor);
        if (bh.ov(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgm)) {
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (bh.ov(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgl) || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgj <= 0.0f) {
                boolean z = false;
            } else {
                try {
                    width = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgl);
                } catch (Throwable e) {
                    x.e("MicroMsg.Sns.AdLandingPageBtnComponent", bh.i(e));
                    width = 0;
                }
                gradientDrawable.setStroke((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgj, width);
                width = 1;
            }
            if (!bh.ov(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgk)) {
                int parseColor;
                try {
                    parseColor = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgk);
                } catch (Throwable e2) {
                    x.e("MicroMsg.Sns.AdLandingPageBtnComponent", bh.i(e2));
                    parseColor = 0;
                }
                gradientDrawable.setColor(parseColor);
                width = 1;
            }
            if (width != 0) {
                this.rjv.setBackgroundDrawable(gradientDrawable);
            }
        } else {
            d.a("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgm, false, 0, 0, new a(this) {
                final /* synthetic */ l rjx;

                {
                    this.rjx = r1;
                }

                public final void bxc() {
                }

                public final void bxd() {
                }

                @TargetApi(16)
                public final void KY(String str) {
                    try {
                        Drawable createFromPath = Drawable.createFromPath(str);
                        this.rjx.rjv.setBackground(createFromPath);
                        if (createFromPath != null && this.rjx.bxl().height > 0.0f && createFromPath.getIntrinsicHeight() > 0) {
                            this.rjx.rjv.setLayoutParams(new LayoutParams((int) ((this.rjx.bxl().height * ((float) createFromPath.getIntrinsicWidth())) / ((float) createFromPath.getIntrinsicHeight())), (int) this.rjx.bxl().height));
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                    }
                }
            });
        }
        this.rjv.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).title);
        d(this.rjv);
        this.rjv.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).azb);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgi != null && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgi.length() > 0) {
            try {
                this.rjv.setTextColor(Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgi));
            } catch (Exception e3) {
                x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[]{((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgi});
            }
        }
        try {
            this.rjv.setTextAlignment(4);
        } catch (Exception e4) {
            x.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).height > 0.0f) {
            this.rjv.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgO)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgP), (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).height));
        } else {
            this.rjv.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgO)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgP), this.rjv.getLayoutParams().height));
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgn == 1) {
            this.rjw.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgO)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgP), this.rjw.getLayoutParams().height));
            this.rjw.setVisibility(0);
            this.rjw.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ l rjx;

                {
                    this.rjx = r1;
                }

                public final boolean onLongClick(View view) {
                    l.a(this.rjx);
                    return true;
                }
            });
            this.rjw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ l rjx;

                {
                    this.rjx = r1;
                }

                public final void onClick(View view) {
                    this.rjx.bxk();
                    this.rjx.bxm();
                }
            });
            return;
        }
        this.rjw.setVisibility(8);
    }

    protected void d(Button button) {
        button.setOnClickListener(new 4(this));
    }

    protected final void bxm() {
        int intExtra;
        String str;
        int intExtra2;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l lVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji;
        String str2 = "";
        if (this.context instanceof Activity) {
            str2 = ac.Lb(((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_rawSnsId"));
            intExtra = ((Activity) this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
            str = str2;
            intExtra2 = ((Activity) this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
        } else {
            str = str2;
            intExtra2 = 0;
            intExtra = 0;
        }
        String str3;
        SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI;
        String str4;
        if (lVar.fpn == 4) {
            f fVar = (f) lVar;
            str3 = fVar.kLw;
            if (this.context instanceof SnsAdNativeLandingPagesUI) {
                snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                str2 = fVar.kKG;
                str4 = (str2 == null || !snsAdNativeLandingPagesUI.rxS.containsKey(str2)) ? str3 : (String) snsAdNativeLandingPagesUI.rxS.get(str2);
            } else {
                str4 = str3;
            }
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "ext is " + str4);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", fVar.kKG);
            intent.putExtra("key_card_ext", str4);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            com.tencent.mm.bm.d.b(this.context, "card", ".ui.CardDetailUI", intent);
        } else if (lVar.fpn == 8) {
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji) instanceof j) {
                Object stringExtra;
                Object stringExtra2;
                str2 = "";
                str4 = "";
                if ((this.context instanceof Activity) && bxe().rha == 2) {
                    stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                    stringExtra2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                } else {
                    r4 = str2;
                    str2 = str4;
                }
                str4 = ((j) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji)).rgK;
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                j jVar = (j) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji);
                AdLandingPagesProxy.getInstance().doOpenAppBrand(jVar.username, jVar.fIk, String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[]{stringExtra, stringExtra2, str4, valueOf, Integer.valueOf(lVar.rha), lVar.qZM, str, Integer.valueOf(intExtra)}));
            }
        } else if (lVar.fpn == 9) {
            g gVar = (g) lVar;
            Intent intent2 = new Intent();
            intent2.putExtra("map_view_type", 1);
            intent2.putExtra("kwebmap_slat", gVar.rfY.nQx);
            intent2.putExtra("kwebmap_lng", gVar.rfY.nQy);
            intent2.putExtra("kwebmap_scale", gVar.rfY.fzv);
            intent2.putExtra("kPoiName", gVar.rfY.fDu);
            intent2.putExtra("Kwebmap_locaion", gVar.rfY.nQz);
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + gVar.rfY.nQx + ", slong " + gVar.rfY.nQy + ", " + gVar.rfY.fDu);
            com.tencent.mm.bm.d.b(this.context, "location", ".ui.RedirectUI", intent2, 2);
        } else if (lVar.fpn == 10) {
            if (c.a.vup != null) {
                i iVar = (i) lVar;
                if (iVar.rfX.size() > 1) {
                    c.a.vup.a(this.context, iVar.rfX, new OnDismissListener(this) {
                        final /* synthetic */ l rjx;

                        {
                            this.rjx = r1;
                        }

                        public final void onDismiss(DialogInterface dialogInterface) {
                            ac.dw(this.rjx.context);
                        }
                    });
                } else if (iVar.rfX.size() > 0) {
                    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.context, (String) iVar.rfX.get(0));
                }
            }
        } else if (lVar.fpn != 11) {
            Intent intent3 = new Intent();
            str4 = lVar.rgg;
            if (!(TextUtils.isEmpty(lVar.rea) || TextUtils.isEmpty(lVar.reb))) {
                str4 = ac.l(str4, new String[]{"traceid=" + lVar.rea + "&aid=" + lVar.reb});
            }
            x.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[]{str4});
            intent3.putExtra("rawUrl", str4);
            intent3.putExtra("useJs", true);
            intent3.putExtra(DownloadSettingTable$Columns.TYPE, -255);
            intent3.putExtra("geta8key_scene", 2);
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rha == 0) {
                Parcelable snsAdClick = new SnsAdClick(str, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).qZM, intExtra2, intExtra);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                intent3.putExtra("jsapiargs", bundle);
            }
            if ((this.context instanceof Activity) && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rha == 2) {
                str3 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                str4 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                if (!bh.ov(str3)) {
                    str2 = String.valueOf(System.currentTimeMillis() / 1000);
                    str = "official_mall_%s_%s_%s_%s";
                    Object[] objArr = new Object[4];
                    if (bh.ov(str4)) {
                        str4 = "";
                    }
                    objArr[0] = str4;
                    objArr[1] = str3;
                    objArr[2] = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgK;
                    objArr[3] = str2;
                    str4 = String.format(str, objArr);
                    intent3.putExtra("prePublishId", str4);
                    intent3.putExtra("KPublisherId", str4);
                    intent3.putExtra("pay_channel", 47);
                }
            }
            com.tencent.mm.bm.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent3);
        } else if (this.context instanceof SnsAdNativeLandingPagesUI) {
            boolean z;
            snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
            s sVar = lVar.rgu;
            str2 = lVar.rgr;
            str = lVar.rgs;
            r4 = lVar.rgt;
            boolean z2 = lVar.rgp == 1;
            boolean z3 = lVar.rgq == 1;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) this.rji).rgo == 1) {
                z = true;
            } else {
                z = false;
            }
            snsAdNativeLandingPagesUI.a(sVar, str2, str, r4, z2, z3, z);
        }
    }

    @TargetApi(17)
    public final View bwW() {
        View view = this.contentView;
        this.nTM = (RelativeLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qDH);
        this.rjv = (Button) view.findViewById(com.tencent.mm.plugin.sns.i.f.qDG);
        this.rjw = view.findViewById(com.tencent.mm.plugin.sns.i.f.qDI);
        return view;
    }
}
