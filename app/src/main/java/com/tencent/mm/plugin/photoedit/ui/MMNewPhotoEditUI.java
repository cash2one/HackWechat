package com.tencent.mm.plugin.photoedit.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.api.e;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.photoedit.PhotoEditProxy;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;

@a(19)
public class MMNewPhotoEditUI extends MMActivity implements e {
    private r jmO = null;
    private int kFm;
    private m oDu;
    private String pdn;
    private String pdo;
    private String pdp;
    private boolean pdq;
    private boolean pdr;
    private final d pds = new d(this);
    private PhotoEditProxy pdt;
    private Dialog pdu;

    static /* synthetic */ void a(MMNewPhotoEditUI mMNewPhotoEditUI) {
        Intent intent = mMNewPhotoEditUI.getIntent();
        mMNewPhotoEditUI.pdn = intent.getStringExtra("before_photo_edit");
        mMNewPhotoEditUI.pdo = intent.getStringExtra("after_photo_edit");
        mMNewPhotoEditUI.kFm = intent.getIntExtra("from_scene", 0);
        mMNewPhotoEditUI.pdr = intent.getBooleanExtra("from_scene_small_preview", false);
        mMNewPhotoEditUI.pdq = mMNewPhotoEditUI.pdt.isAutoSave();
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI, int i) {
        int i2 = 0;
        if (mMNewPhotoEditUI.kFm == JsApiDestroyInstanceAudio.CTRL_INDEX || mMNewPhotoEditUI.kFm == JsApiCreateAudioInstance.CTRL_INDEX) {
            i2 = 1;
        } else if (mMNewPhotoEditUI.kFm == 4 || mMNewPhotoEditUI.kFm == JsApiGetAudioState.CTRL_INDEX) {
            i2 = 2;
        }
        g.pQN.h(13858, new Object[]{Integer.valueOf(i2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i)});
        int sY = mMNewPhotoEditUI.oDu.sT().sY();
        int sX = mMNewPhotoEditUI.oDu.sT().sX();
        int sZ = mMNewPhotoEditUI.oDu.sT().sZ();
        int ta = mMNewPhotoEditUI.oDu.sT().ta();
        boolean tc = mMNewPhotoEditUI.oDu.sT().tc();
        boolean td = mMNewPhotoEditUI.oDu.sT().td();
        int tb = mMNewPhotoEditUI.oDu.sT().tb();
        String str = "MicroMsg.MMNewPhotoEditUI";
        String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,mSmallPreview:%s isRotaion:%s";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(sY);
        objArr[1] = Integer.valueOf(sX);
        objArr[2] = Integer.valueOf(sZ);
        objArr[3] = Integer.valueOf(ta);
        objArr[4] = Integer.valueOf(tc ? 1 : 0);
        objArr[5] = Integer.valueOf(tb);
        objArr[6] = Integer.valueOf(mMNewPhotoEditUI.pdr ? 5 : 4);
        objArr[7] = Boolean.valueOf(td);
        x.i(str, str2, objArr);
        g gVar = g.pQN;
        objArr = new Object[11];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(sY);
        objArr[3] = Integer.valueOf(sX);
        objArr[4] = Integer.valueOf(sZ);
        objArr[5] = Integer.valueOf(ta);
        objArr[6] = Integer.valueOf(tc ? 1 : 0);
        objArr[7] = Integer.valueOf(tb);
        objArr[8] = Integer.valueOf(1);
        objArr[9] = Integer.valueOf(mMNewPhotoEditUI.pdr ? 5 : 4);
        objArr[10] = Integer.valueOf(td ? 1 : 0);
        gVar.h(13857, objArr);
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("scene", 8);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.bm.d.a(mMNewPhotoEditUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void d(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[gotoImagePreviewUI] :%s", new Object[]{str});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList stringArrayListExtra = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList stringArrayListExtra2 = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i = 0;
        while (stringArrayListExtra != null && i < stringArrayListExtra.size()) {
            Object obj = (String) stringArrayListExtra.get(i);
            if (obj.equalsIgnoreCase(bh.ou(mMNewPhotoEditUI.pdn)) || obj.equalsIgnoreCase(bh.ou(mMNewPhotoEditUI.pdo))) {
                obj = str;
            }
            arrayList.add(obj);
            i++;
        }
        i = 0;
        while (stringArrayListExtra2 != null && i < stringArrayListExtra2.size()) {
            obj = (String) stringArrayListExtra2.get(i);
            if (obj.equalsIgnoreCase(bh.ou(mMNewPhotoEditUI.pdn)) || obj.equalsIgnoreCase(bh.ou(mMNewPhotoEditUI.pdo))) {
                obj = str;
            }
            arrayList2.add(obj);
            i++;
        }
        String str2 = null;
        if (!mMNewPhotoEditUI.pdq) {
            str2 = mMNewPhotoEditUI.pdt.getFullPath("photoEdited_" + System.currentTimeMillis());
            k.q(str, str2, false);
        }
        FileOp.deleteFile(mMNewPhotoEditUI.pdo);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("max_select_count", mMNewPhotoEditUI.getIntent().getIntExtra("max_select_count", 9));
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("before_photo_edit", mMNewPhotoEditUI.pdn);
        intent.putExtra("after_photo_edit", str);
        intent.putExtra("tmp_photo_edit", str2);
        Bundle bundle = new Bundle();
        bundle.putString("before_photo_edit", mMNewPhotoEditUI.pdn);
        bundle.putString("after_photo_edit", str);
        bundle.putInt("report_info_emotion_count", mMNewPhotoEditUI.oDu.sT().sY());
        bundle.putInt("report_info_text_count", mMNewPhotoEditUI.oDu.sT().sX());
        bundle.putInt("report_info_mosaic_count", mMNewPhotoEditUI.oDu.sT().sZ());
        bundle.putInt("report_info_doodle_count", mMNewPhotoEditUI.oDu.sT().ta());
        bundle.putBoolean("report_info_iscrop", mMNewPhotoEditUI.oDu.sT().tc());
        bundle.putInt("report_info_undo_count", mMNewPhotoEditUI.oDu.sT().tb());
        bundle.putBoolean("report_info_is_rotation", mMNewPhotoEditUI.oDu.sT().td());
        intent.putExtra("report_info", bundle);
        str2 = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!bh.ov(str2)) {
            intent.putExtra("GalleryUI_FromUser", str2);
        }
        if (!bh.ov(stringExtra)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMNewPhotoEditUI.setResult(-1, intent);
        mMNewPhotoEditUI.dY(false);
        mMNewPhotoEditUI.finish();
    }

    protected final int getLayoutId() {
        return R.i.doZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.i(true, 0);
        this.pdt = new PhotoEditProxy(this.pds);
        this.pds.I(new 1(this));
    }

    protected final void initView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.h.content);
        this.oDu = m.fdD.sU();
        m mVar = this.oDu;
        m.a.a aVar = new m.a.a();
        boolean z = (this.kFm == JsApiCreateAudioInstance.CTRL_INDEX || this.kFm == JsApiGetAudioState.CTRL_INDEX) ? false : true;
        aVar.fdF = z;
        aVar.fdH = true;
        aVar.fdE = c.fdK;
        aVar.path = this.pdn;
        mVar.a(aVar.tg());
        View ai = this.oDu.ai(this.mController.xIM);
        ai.a(this);
        frameLayout.addView(ai, new LayoutParams(-1, -1));
        ai.fds = new 2(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.oDu.onDestroy();
        this.pds.release();
    }

    public void onBackPressed() {
        if (!this.oDu.sS()) {
            if (this.kFm == JsApiDestroyInstanceAudio.CTRL_INDEX || this.kFm == JsApiCreateAudioInstance.CTRL_INDEX) {
                g.pQN.h(13859, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
            } else if (this.kFm == 4 || this.kFm == JsApiGetAudioState.CTRL_INDEX) {
                g.pQN.h(13859, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
            } else {
                g.pQN.h(13859, new Object[]{Integer.valueOf(0), Integer.valueOf(2)});
            }
            finish();
        }
    }

    public final void onFinish() {
        if (this.kFm == JsApiDestroyInstanceAudio.CTRL_INDEX || this.kFm == JsApiCreateAudioInstance.CTRL_INDEX) {
            g.pQN.h(13859, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        } else if (this.kFm == 4 || this.kFm == JsApiGetAudioState.CTRL_INDEX) {
            g.pQN.h(13859, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            g.pQN.h(13859, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
        if (this.kFm == JsApiCreateAudioInstance.CTRL_INDEX || this.kFm == JsApiGetAudioState.CTRL_INDEX) {
            l lVar = new l(this.mController.xIM);
            lVar.rKC = new 3(this);
            lVar.rKD = new 4(this);
            h.a(this.mController.xIM, lVar.bBX());
            return;
        }
        uB(-1);
    }

    public final void sW() {
        onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            x.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[]{intent.getStringExtra("Select_Conv_User"), this.pdp});
            this.pdu = h.a(this.mController.xIM, getString(R.l.eAa), false, null);
            this.pdt.sendImage(intent.getStringExtra("custom_send_text"), this.pdp, this.pdt.getSelfUsername(), r0);
            this.pdu.dismiss();
            if (this.pdq) {
                com.tencent.mm.platformtools.d.b(this.pdp, this);
            } else {
                FileOp.deleteFile(this.pdp);
            }
            finish();
        } else if (intent == null && !bh.ov(this.pdp) && this.kFm == JsApiCreateAudioInstance.CTRL_INDEX) {
            FileOp.deleteFile(this.pdp);
        }
    }

    private void uB(int i) {
        dY(true);
        this.oDu.a(new 5(this, i));
    }

    private void dY(boolean z) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.jmO = r.b(this, getString(R.l.ehQ), true, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
