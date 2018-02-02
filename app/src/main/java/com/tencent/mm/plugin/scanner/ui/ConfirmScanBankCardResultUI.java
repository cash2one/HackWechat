package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> pVb = new HashMap();
    protected Bitmap mBmp = null;
    private String pVa = null;
    private ImageView pVc;
    private EditText pVd;

    public static void c(Bitmap bitmap, String str) {
        if (bitmap != null && !bitmap.isRecycled() && !bh.ov(str)) {
            Intent intent = new Intent();
            intent.setClass(ac.getContext(), ConfirmScanBankCardResultUI.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("_card_num_", str);
            String str2 = "_image_cache_key_" + str;
            pVb.put(str2, bitmap);
            intent.putExtra("_image_cache_key_", str2);
            ac.getContext().startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setMMTitle(R.l.eIp);
        if (getIntent() == null) {
            x.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.pVa = getIntent().getStringExtra("_image_cache_key_");
            if (bh.ov(this.pVa)) {
                x.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) pVb.get(this.pVa);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    x.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            return;
        }
        CharSequence stringExtra = getIntent().getStringExtra("_card_num_");
        if (bh.ov(stringExtra)) {
            x.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            return;
        }
        this.pVc = (ImageView) findViewById(R.h.coR);
        this.pVd = (EditText) findViewById(R.h.cdc);
        this.pVc.setImageBitmap(this.mBmp);
        this.pVd.setText(stringExtra);
        findViewById(R.h.bPh).setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pVc != null) {
            this.pVc.setImageBitmap(null);
        }
        if (!bh.ov(this.pVa)) {
            pVb.remove(this.pVa);
        }
        if (this.mBmp != null) {
            this.mBmp.recycle();
        }
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
    }

    protected final int getLayoutId() {
        return R.i.deH;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
