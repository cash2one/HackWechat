package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.facedetect.a$b;
import com.tencent.mm.plugin.facedetect.a$i;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.aq;
import java.io.File;

public class FaceDebugUI extends MMPreference {
    private f ilB;
    private View lCk;
    private CheckBoxPreference miA = null;
    private CheckBoxPreference miB = null;
    private CheckBoxPreference miC = null;
    private CheckBoxPreference miD = null;
    private CheckBoxPreference miy = null;
    private CheckBoxPreference miz = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lCk = findViewById(e.cwn);
        this.lCk.setBackgroundResource(a$b.white);
        aHe();
        setMMTitle(getString(h.mdR));
        setBackBtn(new 1(this));
    }

    private void aHe() {
        this.ilB = this.yjd;
        this.miy = (CheckBoxPreference) this.ilB.YN("face_debug_switch");
        this.miz = (CheckBoxPreference) this.ilB.YN("face_debug_save_pic_switch");
        this.miA = (CheckBoxPreference) this.ilB.YN("face_debug_save_final_switch");
        this.miB = (CheckBoxPreference) this.ilB.YN("face_debug_save_lipreading_switch");
        this.miC = (CheckBoxPreference) this.ilB.YN("face_debug_save_voice_switch");
        this.miD = (CheckBoxPreference) this.ilB.YN("face_debug_force_upload_video");
        this.ilB.notifyDataSetChanged();
    }

    protected void onResume() {
        super.onResume();
        aHf();
    }

    protected void onStop() {
        super.onStop();
    }

    private void aHf() {
        boolean aGu = com.tencent.mm.plugin.facedetect.model.e.aGu();
        boolean aGw = com.tencent.mm.plugin.facedetect.model.e.aGw();
        boolean aGx = com.tencent.mm.plugin.facedetect.model.e.aGx();
        boolean aGy = com.tencent.mm.plugin.facedetect.model.e.aGy();
        boolean aGz = com.tencent.mm.plugin.facedetect.model.e.aGz();
        boolean aGv = com.tencent.mm.plugin.facedetect.model.e.aGv();
        if (aGu) {
            this.miy.mv(true);
            this.ilB.bk("face_debug_save_pic_switch", false);
            this.ilB.bk("face_debug_save_final_switch", false);
            this.ilB.bk("face_debug_save_lipreading_switch", false);
            this.ilB.bk("face_debug_save_voice_switch", false);
            this.ilB.bk("face_debug_force_upload_video", false);
            this.miz.mv(aGw);
            this.miA.mv(aGx);
            this.miB.mv(aGy);
            this.miC.mv(aGz);
            this.miD.mv(aGv);
        } else {
            this.miy.mv(false);
            this.ilB.bk("face_debug_save_pic_switch", true);
            this.ilB.bk("face_debug_save_final_switch", true);
            this.ilB.bk("face_debug_save_lipreading_switch", true);
            this.ilB.bk("face_debug_save_voice_switch", true);
            this.ilB.bk("face_debug_force_upload_video", true);
        }
        this.ilB.notifyDataSetChanged();
    }

    public final int XB() {
        return a$i.meE;
    }

    public final boolean a(f fVar, Preference preference) {
        aHe();
        if ("face_debug_switch".equals(preference.ibD)) {
            com.tencent.mm.plugin.facedetect.model.e.eN(this.miy.isChecked());
            aHf();
            return true;
        } else if ("face_debug_save_pic_switch".equals(preference.ibD)) {
            com.tencent.mm.plugin.facedetect.model.e.eO(this.miz.isChecked());
            aHf();
            return true;
        } else if ("face_debug_save_final_switch".equals(preference.ibD)) {
            com.tencent.mm.plugin.facedetect.model.e.eP(this.miA.isChecked());
            aHf();
            return true;
        } else if ("face_debug_save_lipreading_switch".equals(preference.ibD)) {
            com.tencent.mm.plugin.facedetect.model.e.eQ(this.miB.isChecked());
            aHf();
            return true;
        } else if ("face_debug_save_voice_switch".equals(preference.ibD)) {
            com.tencent.mm.plugin.facedetect.model.e.eR(this.miC.isChecked());
            aHf();
            return true;
        } else if ("face_debug_force_upload_video".equals(preference.ibD)) {
            com.tencent.mm.plugin.facedetect.model.e.eS(this.miD.isChecked());
            aHf();
            return true;
        } else if ("face_debug_clear_resource".equals(preference.ibD)) {
            r2 = new File(n.py(0));
            if (r2.exists()) {
                r2.delete();
            }
            File file = new File(n.py(1));
            if (file.exists()) {
                file.delete();
            }
            aq.hfP.S("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
            aq.hfP.S("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
            return true;
        } else if (!"face_debug_check_resource".equals(preference.ibD)) {
            return false;
        } else {
            r2 = new File(n.py(0));
            File file2 = new File(n.py(1));
            u.makeText(this.mController.xIM, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[]{Boolean.valueOf(r2.exists()), Boolean.valueOf(file2.exists())}), 0).show();
            x.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[]{g.i(r2)});
            x.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[]{g.i(file2)});
            return true;
        }
    }
}
