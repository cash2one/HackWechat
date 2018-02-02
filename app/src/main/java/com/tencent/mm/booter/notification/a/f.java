package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.IOException;
import java.nio.charset.Charset;

public final class f {
    Context context;
    boolean gAv;
    MediaPlayer gAw;
    @SuppressLint({"HandlerLeak"})
    af gAx;
    private af gAy;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String gAA;
        final /* synthetic */ boolean gAB = false;
        final /* synthetic */ f gAz;

        AnonymousClass2(f fVar, String str, boolean z) {
            this.gAz = fVar;
            this.gAA = str;
        }

        public final void run() {
            f fVar = this.gAz;
            String str = this.gAA;
            boolean z = this.gAB;
            if (fVar.context == null) {
                fVar.context = ac.getContext();
            }
            if (fVar.context == null) {
                x.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
                return;
            }
            try {
                AudioManager audioManager = (AudioManager) fVar.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager.getStreamVolume(5) != 0) {
                    Uri defaultUri;
                    fVar.gAx.removeMessages(305419896);
                    fVar.gAx.sendEmptyMessageDelayed(305419896, 8000);
                    x.i("MicroMsg.Notification.Tool.Sound", "doPlaySound playerIsInit: %s", new Object[]{Boolean.valueOf(fVar.gAv)});
                    if (fVar.gAv) {
                        try {
                            if (fVar.gAw != null) {
                                if (fVar.gAw.isPlaying()) {
                                    fVar.gAw.stop();
                                }
                                fVar.gAw.release();
                                x.i("MicroMsg.Notification.Tool.Sound", "try to release player before playSound playerIsInit: %s", new Object[]{Boolean.valueOf(fVar.gAv)});
                            }
                        } catch (IllegalStateException e) {
                            x.w("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error");
                            if (fVar.gAw != null) {
                                fVar.gAw.release();
                            }
                        }
                        fVar.gAv = false;
                    }
                    fVar.gAw = new j();
                    x.i("MicroMsg.Notification.Tool.Sound", "doPlaySound player: %s", new Object[]{fVar.gAw});
                    MediaPlayer mediaPlayer = fVar.gAw;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (bh.ov(str)) {
                        defaultUri = RingtoneManager.getDefaultUri(2);
                    } else if (z) {
                        AssetFileDescriptor openFd = fVar.context.getAssets().openFd(str);
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                        defaultUri = null;
                    } else {
                        defaultUri = Uri.parse(str);
                    }
                    if (defaultUri != null) {
                        try {
                            mediaPlayer.setDataSource(fVar.context, defaultUri);
                        } catch (IOException e2) {
                            if (bh.ov(str)) {
                                x.i("MicroMsg.Notification.Tool.Sound", "setPlayerDataSource IOException soundUri:%s, isAsset:%s", new Object[]{str, Boolean.valueOf(z)});
                            } else {
                                mediaPlayer.setDataSource(fVar.context, RingtoneManager.getDefaultUri(2));
                            }
                        }
                    }
                    x.i("MicroMsg.Notification.Tool.Sound", "summeranrt setPlayerDataSource tid[%d] [%d]ms", new Object[]{Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (audioManager.isWiredHeadsetOn()) {
                        com.tencent.mm.compatible.b.f.xN();
                        x.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", new Object[]{Integer.valueOf(0)});
                        float streamVolume = (float) audioManager.getStreamVolume(0);
                        float streamMaxVolume = (float) audioManager.getStreamMaxVolume(0);
                        float streamVolume2 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                        x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s, maxVolume: %s, toneScale: %s", new Object[]{Float.valueOf(streamVolume), Float.valueOf(streamMaxVolume), Float.valueOf(streamVolume / streamMaxVolume)});
                        x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneMUSICVolume: %s, maxMUSICVolume: %s, toneMusicScale: %s", new Object[]{Float.valueOf(r3), Float.valueOf(r5), Float.valueOf(streamVolume2)});
                        if (streamVolume / streamMaxVolume > streamVolume2) {
                            streamVolume = streamMaxVolume * streamVolume2;
                            x.d("MicroMsg.Notification.Tool.Sound", "headset on, toneVolume: %s", new Object[]{Float.valueOf(streamVolume)});
                        }
                        audioManager.setSpeakerphoneOn(false);
                        x.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", new Object[]{Integer.valueOf(q.gGe.gFA)});
                        if (q.gGe.gFA == 1) {
                            x.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            fVar.gAw.setOnCompletionListener(new 3(fVar, audioManager));
                            fVar.gAw.setOnErrorListener(new 4(fVar, audioManager));
                        } else {
                            fVar.gAw.setOnCompletionListener(new 5(fVar));
                            fVar.gAw.setOnErrorListener(new 6(fVar));
                        }
                        fVar.gAw.setAudioStreamType(0);
                        fVar.gAw.setLooping(true);
                        fVar.gAw.prepare();
                        fVar.gAw.setVolume(streamVolume / streamMaxVolume, streamVolume / streamMaxVolume);
                        fVar.gAw.setLooping(false);
                        fVar.gAw.start();
                        fVar.gAv = true;
                        return;
                    }
                    x.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", new Object[]{Integer.valueOf(audioManager.getStreamVolume(5)), str});
                    fVar.gAw.setOnCompletionListener(new 7(fVar));
                    fVar.gAw.setOnErrorListener(new 8(fVar));
                    fVar.gAw.setAudioStreamType(5);
                    fVar.gAw.setLooping(true);
                    fVar.gAw.prepare();
                    fVar.gAw.setLooping(false);
                    fVar.gAw.start();
                    fVar.gAv = true;
                    String str2 = "MicroMsg.Notification.Tool.Sound";
                    String str3 = "doPlaySound start finish playerIsInit:%s, myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(fVar.gAv);
                    objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                    objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                    x.i(str2, str3, objArr);
                }
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e3, "PlaySound Exception:", new Object[0]);
                try {
                    if (fVar.gAw != null) {
                        fVar.gAw.release();
                    }
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.Notification.Tool.Sound", e32, "try to release player in Exception:", new Object[0]);
                }
            }
        }
    }

    private f() {
        String str = null;
        this.gAv = false;
        this.gAw = null;
        this.gAx = new af(this, Looper.getMainLooper()) {
            final /* synthetic */ f gAz;

            public final void handleMessage(Message message) {
                x.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer playerIsInit:%s", new Object[]{Boolean.valueOf(this.gAz.gAv)});
                try {
                    if (this.gAz.gAw != null) {
                        if (this.gAz.gAw.isPlaying()) {
                            this.gAz.gAw.stop();
                        }
                        this.gAz.gAw.release();
                        this.gAz.gAv = false;
                        x.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer done playerIsInit:%s", new Object[]{Boolean.valueOf(this.gAz.gAv)});
                    }
                } catch (IllegalStateException e) {
                    x.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander,playerIsInit:%s", new Object[]{Boolean.valueOf(this.gAz.gAv)});
                    if (this.gAz.gAw != null) {
                        this.gAz.gAw.release();
                    }
                }
            }
        };
        this.context = ac.getContext();
        String str2 = w.gZK + "deviceconfig.cfg";
        x.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", new Object[]{str2, Boolean.valueOf(e.bO(str2))});
        if (e.bO(str2)) {
            byte[] e = e.e(str2, 0, -1);
            if (!bh.bw(e)) {
                str2 = new String(e, Charset.defaultCharset());
                if (!bh.ov(str2)) {
                    str = str2;
                }
            }
        }
        q.eI(str);
    }

    public final synchronized void ev(String str) {
        if (this.gAy == null) {
            x.i("MicroMsg.Notification.Tool.Sound", "playSound playHandler == null");
            HandlerThread cZ = com.tencent.mm.sdk.f.e.cZ("playSoundThread", 0);
            cZ.start();
            this.gAy = new af(cZ.getLooper());
        }
        this.gAy.post(new AnonymousClass2(this, str, false));
    }
}
