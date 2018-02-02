package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private ListView inm;
    private d mfB = new d(this);
    private a oDk;
    private LinkedList<b> oDl = new LinkedList();
    private CaptureMMProxy ora;

    class a extends BaseAdapter {
        final /* synthetic */ SightSettingsUI oDm;

        a(SightSettingsUI sightSettingsUI) {
            this.oDm = sightSettingsUI;
        }

        public final int getCount() {
            return this.oDm.oDl.size();
        }

        public final Object getItem(int i) {
            return this.oDm.oDl.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View textView = new TextView(this.oDm);
            b bVar = (b) getItem(i);
            textView.setText(bVar.oDp + "->:" + bVar.tc(((Integer) bVar.oDm.ora.get(bVar.oDs, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new 1(this, bVar));
            return textView;
        }
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "打开测试信息", com.tencent.mm.storage.w.a.xsG, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "对焦方案", com.tencent.mm.storage.w.a.xsN, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "裁剪方案", com.tencent.mm.storage.w.a.xsO, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "是否把双通音频压成单通道", com.tencent.mm.storage.w.a.xsP, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "Thread", com.tencent.mm.storage.w.a.xsL, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "裁剪预览MediaPlayer", com.tencent.mm.storage.w.a.xsQ, new String[]{"default", "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "音频录制方案", com.tencent.mm.storage.w.a.xsR, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDl.add(new b(sightSettingsUI2, "预设配置", com.tencent.mm.storage.w.a.xsK, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转", "MediaCodec+1080p双倍码率+后压+实时压缩"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        sightSettingsUI.inm = (ListView) sightSettingsUI.findViewById(com.tencent.mm.plugin.u.a.d.ctf);
        sightSettingsUI.oDk = new a(sightSettingsUI);
        sightSettingsUI.inm.setAdapter(sightSettingsUI.oDk);
    }

    protected final int getLayoutId() {
        return e.oFa;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ora = new CaptureMMProxy(this.mfB);
        this.mfB.I(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.mfB.release();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
