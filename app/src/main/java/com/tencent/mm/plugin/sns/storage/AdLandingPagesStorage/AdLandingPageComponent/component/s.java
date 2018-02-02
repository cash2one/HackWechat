package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class s extends l {
    public s(Context context, k kVar, ViewGroup viewGroup) {
        super(context, kVar, viewGroup);
    }

    protected final void d(Button button) {
        button.setOnClickListener(new 1(this));
    }

    public final void b(Context context, String str, String str2, int i) {
        String str3 = "";
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", bxl().rgY);
        intent.putExtra("sns_landing_pages_xml", "");
        if (bxr()) {
            intent.putExtra("sns_landing_pages_canvasid", str);
            intent.putExtra("sns_landing_pages_canvas_ext", str2);
        } else {
            intent.putExtra("sns_landing_pages_pageid", bh.VJ(str));
        }
        if (bxq()) {
            int[] iArr = new int[2];
            this.rjv.getLocationOnScreen(iArr);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_width", this.rjv.getWidth());
            intent.putExtra("img_gallery_height", this.rjv.getHeight());
        }
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", bxq());
        intent.putExtra("sns_landing_pages_extra", str3);
        intent.putExtra("sns_landing_pages_no_store", i);
        intent.putExtra("sns_landing_pages_ux_info", bxl().qZM);
        intent.putExtra("sns_landing_is_native_sight_ad", bxl().rgZ);
        if ((context instanceof Activity) && bxr() && bxl().rha == 2) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            str3 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bh.ov(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", bxl().rgK);
                    jSONObject.put("adBuffer", !bh.ov(str3) ? str3 : "");
                    jSONObject.put("preSessionId", stringExtra);
                } catch (Exception e) {
                }
                intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                intent.putExtra("sns_landing_pages_sessionId", valueOf);
                intent.putExtra("sns_landing_pages_ad_buffer", str3);
            }
        }
        if (context instanceof Activity) {
            str3 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_share_sns_id");
            intent.putExtra("sns_landing_pages_rawSnsId", str3);
            intent.putExtra("sns_landing_pages_share_sns_id", stringExtra2);
        }
        d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
    }

    private boolean bxq() {
        return ((k) bxl()).rgd == 1;
    }

    private boolean bxr() {
        return ((k) bxl()).rge == 1;
    }
}
