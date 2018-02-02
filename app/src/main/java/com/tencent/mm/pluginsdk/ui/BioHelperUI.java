package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI extends MMActivity {
    private String jKk;
    private int lJY;
    private String lcJ;
    private int mType;
    private String nMi;
    private String vjq;
    private b vjr;

    private class a implements b {
        final /* synthetic */ BioHelperUI vjs;

        private a(BioHelperUI bioHelperUI) {
            this.vjs = bioHelperUI;
        }

        public final void ad(Intent intent) {
        }

        public final String bZW() {
            return this.vjs.getString(R.l.dMf);
        }

        public final int bZX() {
            return R.g.bCb;
        }

        public final String bZY() {
            return this.vjs.getString(R.l.dMg);
        }

        public final String bZZ() {
            return this.vjs.getString(R.l.dMd);
        }

        public final void en(Context context) {
            Intent intent = new Intent();
            intent.putExtra("k_user_name", this.vjs.jKk);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_ticket", this.vjs.lcJ);
            d.b(this.vjs.mController.xIM, "facedetect", ".ui.FaceDetectUI", intent, 1025);
        }

        public final void d(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == 2 && intent != null) {
                this.vjs.finish();
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                String str = "MicroMsg.BioHelperUI";
                String str2 = "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bh.ov(stringExtra));
                if (!bh.ov(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                x.i(str, str2, objArr);
            }
        }
    }

    private class c implements b {
        private int irz;
        final /* synthetic */ BioHelperUI vjs;

        private c(BioHelperUI bioHelperUI) {
            this.vjs = bioHelperUI;
        }

        public final void ad(Intent intent) {
            if (intent != null) {
                this.irz = intent.getIntExtra("kscene_type", 73);
            }
        }

        public final String bZW() {
            return this.vjs.getString(R.l.dMi);
        }

        public final int bZX() {
            return R.g.bHj;
        }

        public final String bZY() {
            return this.vjs.getString(R.l.dMh);
        }

        public final String bZZ() {
            return this.vjs.getString(R.l.dMe);
        }

        public final void en(Context context) {
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.irz);
            intent.putExtra("Kusername", this.vjs.jKk);
            intent.putExtra("Kvertify_key", this.vjs.lcJ);
            d.b(context, "voiceprint", ".ui.VoiceLoginUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }

        public final void d(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == -1) {
                if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    String str = "MicroMsg.BioHelperUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bh.ov(stringExtra));
                    if (!bh.ov(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    x.d(str, str2, objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", this.vjs.lJY);
                    this.vjs.setResult(-1, intent2);
                }
                this.vjs.finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        b bVar = null;
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        x.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", new Object[]{Integer.valueOf(this.mType)});
        this.jKk = bh.az(getIntent().getStringExtra("Kusername"), null);
        this.lcJ = bh.az(getIntent().getStringExtra("Kvertify_key"), null);
        this.vjq = bh.az(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.nMi = bh.az(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.lJY = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            bVar = new c();
        } else if (this.mType == 1) {
            bVar = new a();
        } else {
            x.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.vjr = bVar;
        if (this.vjr == null || bh.ov(this.jKk) || bh.ov(this.lcJ)) {
            x.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.h.bNL);
        if (bh.ov(this.nMi)) {
            textView.setText(this.vjr.bZZ());
        } else {
            textView.setText(this.nMi);
        }
        setMMTitle(this.vjr.bZW());
        ((ImageView) findViewById(R.h.bNJ)).setImageResource(this.vjr.bZX());
        setBackBtn(new 1(this));
        this.vjr.ad(getIntent());
        Button button = (Button) findViewById(R.h.bNM);
        button.setText(this.vjr.bZY());
        button.setOnClickListener(new 2(this));
        findViewById(R.h.bNK).setOnClickListener(new 3(this));
    }

    protected final int getLayoutId() {
        return R.i.dbn;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BioHelperUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.vjr.d(i, i2, intent);
    }
}
