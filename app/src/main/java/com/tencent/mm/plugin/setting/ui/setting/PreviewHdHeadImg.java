package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class PreviewHdHeadImg extends MMActivity {
    private GetHdHeadImageGalleryView ojN;
    private final int qhr = 1;
    private final int qhs = 2;
    private e qht;
    private String qhu;
    private String username;

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        String str = com.tencent.mm.compatible.util.e.gHu + "hdImg_" + g.s(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + ".jpg";
        FileOp.deleteFile(str);
        FileOp.x(previewHdHeadImg.qhu, str);
        d.b(str, previewHdHeadImg.mController.xIM);
        Toast.makeText(previewHdHeadImg.mController.xIM, previewHdHeadImg.mController.xIM.getString(R.l.enz, new Object[]{com.tencent.mm.compatible.util.e.gHu}), 1).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dlu;
    }

    protected final void initView() {
        setMMTitle(R.l.eKW);
        this.username = q.FS();
        this.ojN = (GetHdHeadImageGalleryView) findViewById(R.h.ckt);
        this.ojN.username = this.username;
        bqu();
        addIconOptionMenu(0, R.g.bDI, new 1(this));
        setBackBtn(new 2(this));
    }

    private void bqu() {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            Bitmap a = b.a(this.username, true, -1);
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), R.g.bBB);
            }
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                x.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.ojN.setThumbImage(a);
            }
            n.Jz();
            Bitmap je = com.tencent.mm.ad.d.je(this.username);
            if (je == null || je.isRecycled()) {
                this.qht = new e();
                this.qht.a(this.username, new 3(this, a));
                return;
            }
            x.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            n.Jz();
            d(je, com.tencent.mm.ad.d.x(this.username, true));
            return;
        }
        u.fI(this.mController.xIM);
        d(n.Jz().bg(this.mController.xIM), null);
    }

    private void d(Bitmap bitmap, String str) {
        if (bitmap != null) {
            try {
                Bitmap createBitmap;
                if (bitmap.getWidth() < 480) {
                    float width = 480.0f / ((float) bitmap.getWidth());
                    Matrix matrix = new Matrix();
                    matrix.postScale(width, width);
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                } else {
                    createBitmap = bitmap;
                }
                x.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
                this.ojN.N(createBitmap);
                this.ojN.qhu = str;
                this.qhu = str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        n.Jz();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.ad.d.x(q.FS() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        com.tencent.mm.pluginsdk.n nVar = a.ifs;
                        ar.Hg();
                        nVar.a((Activity) this, intent, intent2, c.Fi(), 4, null);
                        return;
                    }
                    return;
                case 4:
                    new af(Looper.getMainLooper()).post(new 5(this));
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            x.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                            return;
                        } else {
                            new p(this.mController.xIM, stringExtra).c(1, new 6(this));
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2 || i == 4) {
            new af(Looper.getMainLooper()).post(new 4(this));
        }
    }
}
