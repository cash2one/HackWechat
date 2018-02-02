package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.r;
import com.tencent.wcdb.FileUtils;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private int gUf = 0;
    private TextPaint gu;
    private String jKk;
    private TextView kTq;
    private ImageView lRr;

    public void setAlpha(float f) {
        this.kTq.setAlpha(f);
        this.lRr.setAlpha(f);
    }

    public ExdeviceRankChampionInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dgY, this, true);
        this.gu = new TextPaint(1);
        this.kTq = (TextView) inflate.findViewById(R.h.cSg);
        this.lRr = (ImageView) inflate.findViewById(R.h.bLD);
        this.lRr.setOnClickListener(new 1(this, context));
        this.kTq.setOnClickListener(new 2(this, context));
        try {
            this.gUf = context.getResources().getDimensionPixelSize(R.f.buU);
            if (this.gUf <= 0) {
                this.gUf = FileUtils.S_IWUSR;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.gUf <= 0) {
                this.gUf = FileUtils.S_IWUSR;
            }
        } catch (Throwable th) {
            if (this.gUf <= 0) {
                this.gUf = FileUtils.S_IWUSR;
            }
        }
        x.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[]{Integer.valueOf(this.gUf)});
    }

    public final void zq(String str) {
        this.jKk = str;
        if (this.kTq != null) {
            if (bh.ov(str)) {
                this.kTq.setVisibility(8);
                this.kTq.setText("");
            } else {
                this.kTq.setVisibility(0);
                Context context = getContext();
                int i = R.l.ecG;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(i.a(getContext(), r.gu(this.jKk)), this.gu, (float) this.gUf, TruncateAt.END);
                x.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[]{i.a(getContext(), context.getString(i, objArr))});
                this.kTq.setText(i.b(getContext(), r0, this.kTq.getTextSize()));
            }
        }
        if (this.lRr == null) {
            return;
        }
        if (bh.ov(str)) {
            this.lRr.setVisibility(4);
            return;
        }
        b.o(this.lRr, str);
        this.lRr.setVisibility(0);
    }
}
