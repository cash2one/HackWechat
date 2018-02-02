package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class ContactRemarkImagePreviewUI extends MMActivity {
    private MMGestureGallery kRW;
    private String username;
    private a yRA;
    private View yRw;
    private String yRx;
    private boolean yRy;
    private boolean yRz;

    static /* synthetic */ void d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        b cfVar = new cf();
        f.a(cfVar, 6, contactRemarkImagePreviewUI.yRx);
        cfVar.fqp.activity = contactRemarkImagePreviewUI;
        cfVar.fqp.fqw = 46;
        a.xef.m(cfVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.yRx = getIntent().getStringExtra("remark_image_path");
        this.yRy = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.yRz = getIntent().getBooleanExtra("view_only", false);
        if (bh.ov(this.username)) {
            finish();
        } else {
            initView();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.deU;
    }

    protected final void initView() {
        this.yRw = findViewById(R.h.bYH);
        this.kRW = (MMGestureGallery) findViewById(R.h.ckt);
        setMMTitle(R.l.evv);
        this.kRW.setVerticalFadingEdgeEnabled(false);
        this.kRW.setHorizontalFadingEdgeEnabled(false);
        l.bC(this.kRW);
        this.yRA = new a(this);
        this.yRA.imagePath = this.yRx;
        this.kRW.setAdapter(this.yRA);
        this.kRW.setOnItemClickListener(new 3(this));
        addIconOptionMenu(0, R.k.duY, new 1(this));
        setBackBtn(new 2(this));
    }

    private void mZ(boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        mZ(false);
        return true;
    }
}
