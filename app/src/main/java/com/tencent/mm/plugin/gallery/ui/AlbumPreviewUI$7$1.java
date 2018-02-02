package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.i.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.7;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class AlbumPreviewUI$7$1 implements OnClickListener {
    final /* synthetic */ 7 mSU;

    AlbumPreviewUI$7$1(7 7) {
        this.mSU = 7;
    }

    private void aOr() {
        String stringExtra = this.mSU.mSQ.getIntent().getStringExtra("to_user");
        String stringExtra2 = this.mSU.mSQ.getIntent().getStringExtra("file_name");
        String stringExtra3 = this.mSU.mSQ.getIntent().getStringExtra("video_path");
        String stringExtra4 = this.mSU.mSQ.getIntent().getStringExtra("video_full_path");
        String stringExtra5 = this.mSU.mSQ.getIntent().getStringExtra("video_thumb_path");
        try {
            Intent intent = new Intent();
            intent.setClassName(this.mSU.mSQ.mController.xIM.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
            intent.putExtra("VideoRecorder_ToUser", stringExtra);
            intent.putExtra("VideoRecorder_FileName", stringExtra2);
            intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
            intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
            intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
            x.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[]{intent});
            this.mSU.mSQ.startActivityForResult(intent, 4371);
        } catch (Exception e) {
            x.w("MicroMsg.AlbumPreviewUI", e.toString());
            if (!a.aV(this.mSU.mSQ.mController.xIM) && !a.aU(this.mSU.mSQ.mController.xIM)) {
                b.b(this.mSU.mSQ.mController.xIM, 4372);
            }
        }
    }

    public final void onClick(View view) {
        x.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", new Object[]{Integer.valueOf(AlbumPreviewUI.B(this.mSU.mSQ))});
        if (AlbumPreviewUI.C(this.mSU.mSQ)) {
            x.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
            return;
        }
        AlbumPreviewUI.D(this.mSU.mSQ);
        AlbumPreviewUI.E(this.mSU.mSQ);
        if (c.aNE().aOi() == 2 || c.aNE().aOh() == 13) {
            if (this.mSU.mSQ.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                int intExtra = this.mSU.mSQ.getIntent().getIntExtra("record_video_quality", 0);
                int intExtra2 = this.mSU.mSQ.getIntent().getIntExtra("record_video_time_limit", 0);
                k.a(this.mSU.mSQ.mController.xIM, this.mSU.mSQ.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
            } else if (this.mSU.mSQ.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                if (((SightParams) this.mSU.mSQ.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                    x.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                }
                if (c.aNE().aOh() != 13) {
                    k.a(this.mSU.mSQ.mController.xIM, 4375, this.mSU.mSQ.getIntent(), 3, 1);
                } else {
                    k.a(this.mSU.mSQ.mController.xIM, 4375, this.mSU.mSQ.getIntent(), 4, 1);
                }
            } else if (q.gGe.gES == 2) {
                aOr();
            } else if (q.gGe.gES != 1 || a.aV(this.mSU.mSQ.mController.xIM) || a.aU(this.mSU.mSQ.mController.xIM)) {
                aOr();
            } else {
                b.b(this.mSU.mSQ.mController.xIM, 4372);
            }
        } else if (c.aNE().aOi() == 1 || c.aNE().aOi() == 3) {
            File file = new File(e.gHu);
            if (file.exists() || file.mkdir()) {
                x.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.mSU.mSQ.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.mSU.mSQ.mController.xIM});
                if (com.tencent.mm.pluginsdk.g.a.a(this.mSU.mSQ.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
                    AlbumPreviewUI.F(this.mSU.mSQ);
                    return;
                }
                return;
            }
            Toast.makeText(this.mSU.mSQ.mController.xIM, this.mSU.mSQ.getString(R.l.dTe), 1).show();
        }
    }
}
