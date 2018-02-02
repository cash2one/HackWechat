package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.a.e;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ay;
import com.tencent.mm.z.c;

public final class k extends b {
    protected ay zaT = null;

    static /* synthetic */ void o(Context context, boolean z) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            intent.putExtra("is_bind_for_contact_sync", z);
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.A(context, intent);
            e ie = g.Ij().ie("4");
            if (ie != null && !bh.ov(ie.value) && (ie.value.equals("1") || ie.value.equals("2"))) {
                g.Ij().ie("4").result = "1";
                f.ij("4");
                if (ie.value.equals("1")) {
                    ar.Hg();
                    c.CU().set(328195, Boolean.valueOf(true));
                    return;
                }
                ar.Hg();
                c.CU().set(328196, Boolean.valueOf(true));
            } else if (z) {
                com.tencent.mm.plugin.report.service.g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            }
        }
    }

    public k(Context context, ay ayVar) {
        super(context);
        this.zaT = ayVar;
        if (this.view != null) {
            OnClickListener 3;
            MMImageView mMImageView = (MMImageView) this.view.findViewById(R.h.cuS);
            TextView textView = (TextView) this.view.findViewById(R.h.cuT);
            switch (this.zaT.type) {
                case 1:
                    mMImageView.setImageResource(R.k.dBp);
                    textView.setText(R.l.dKo);
                    break;
                case 2:
                    mMImageView.setImageResource(R.k.dBq);
                    textView.setText(R.l.ehG);
                    break;
                case 3:
                    mMImageView.setImageResource(R.k.dBo);
                    textView.setText(R.l.dKw);
                    break;
                case 4:
                    mMImageView.setImageResource(R.k.dBv);
                    textView.setText(R.l.dKq);
                    break;
                case 6:
                    mMImageView.setImageResource(R.k.dBr);
                    textView.setText(R.l.dKu);
                    break;
                case 7:
                    mMImageView.setImageResource(R.k.dBs);
                    textView.setText(R.l.dKt);
                    break;
                case 8:
                    mMImageView.setImageResource(R.k.dBt);
                    textView.setText(R.l.dKv);
                    break;
                case 9:
                    mMImageView.setImageResource(R.k.dBu);
                    textView.setText(R.l.dKr);
                    break;
                case 10:
                    mMImageView.setImageResource(R.k.dBn);
                    textView.setText(R.l.dKn);
                    break;
            }
            View view = this.view;
            int i = this.zaT.type;
            int i2 = this.zaT.showType;
            switch (i) {
                case 1:
                    3 = new 3(this, i, i2);
                    break;
                case 2:
                    3 = new 4(this, i, i2);
                    break;
                case 3:
                    3 = new 2(this, i, i2);
                    break;
                case 4:
                    3 = new 1(this, i, i2);
                    break;
                case 6:
                    3 = new 5(this, i, i2);
                    break;
                case 7:
                    3 = new 6(this, i, i2);
                    break;
                case 8:
                    3 = new 7(this, i, i2);
                    break;
                case 9:
                    3 = new 8(this, i, i2);
                    break;
                case 10:
                    3 = new 9(this, i, i2);
                    break;
                default:
                    3 = null;
                    break;
            }
            view.setOnClickListener(3);
        }
    }

    public final int getLayoutId() {
        return R.i.dmX;
    }

    public final void destroy() {
    }
}
