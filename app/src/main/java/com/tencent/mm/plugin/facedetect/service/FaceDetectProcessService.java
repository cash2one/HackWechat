package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectProcessService extends Service {
    private a mik = new a(this);
    public g mil = null;
    private Messenger mim = null;
    private a mio = null;

    static /* synthetic */ void a(FaceDetectProcessService faceDetectProcessService, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.setData(bundle);
        faceDetectProcessService.n(obtain);
    }

    public void onCreate() {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", Integer.valueOf(hashCode()));
        super.onCreate();
        this.mil = new g();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
        if (intent == null) {
            x.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
            return super.onStartCommand(intent, i, i2);
        }
        Messenger messenger = (Messenger) intent.getParcelableExtra("k_messenger");
        if (messenger != null) {
            this.mim = messenger;
            return super.onStartCommand(intent, i, i2);
        }
        x.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", Integer.valueOf(intent.getIntExtra("k_cmd", -1)));
        switch (intent.getIntExtra("k_cmd", -1)) {
            case 0:
                a aVar;
                int engineInit;
                String stringExtra = intent.getStringExtra("k_bio_id");
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_bio_config");
                FaceContextData.a((FaceContextData) intent.getParcelableExtra("k_ontext_data"));
                switch (intent.getIntExtra("k_server_scene", 2)) {
                    case 0:
                    case 1:
                        aVar = null;
                        break;
                    case 2:
                    case 5:
                        aVar = new b();
                        break;
                    default:
                        aVar = null;
                        break;
                }
                this.mio = aVar;
                g gVar = this.mil;
                if (gVar.mgj != null) {
                    x.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
                    gVar.aGI();
                }
                if (n.aGO()) {
                    gVar.mgj = new FaceProNative();
                    engineInit = gVar.mgj.engineInit(stringExtra, byteArrayExtra, n.aGQ(), n.aGR());
                    x.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", Integer.valueOf(engineInit));
                } else {
                    x.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
                    engineInit = -4;
                }
                cv(0, engineInit);
                break;
            case 1:
                final o anonymousClass1 = new o(this) {
                    final /* synthetic */ FaceDetectProcessService mip;

                    {
                        this.mip = r1;
                    }

                    public final void b(FaceResult faceResult) {
                        int i = -1;
                        String str = "MicroMsg.FaceDetectProcessService";
                        String str2 = "alvinluo release out result == null:%b, result: %d";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(faceResult == null);
                        objArr[1] = Integer.valueOf(faceResult != null ? faceResult.result : -1);
                        x.i(str, str2, objArr);
                        if (faceResult == null || faceResult.result != 0) {
                            x.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
                            if (faceResult != null) {
                                i = faceResult.result;
                            }
                            this.mip.cv(1, i);
                            return;
                        }
                        f.w(new 1(this, faceResult));
                    }
                };
                f.w(new Runnable(this) {
                    final /* synthetic */ FaceDetectProcessService mip;

                    public final void run() {
                        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
                        final FaceResult aGH = this.mip.mil.aGH();
                        ag.y(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 miu;

                            public final void run() {
                                anonymousClass1.b(aGH);
                            }
                        });
                    }
                });
                break;
            case 4:
                a.aHt().mkZ = intent.getBooleanExtra("key_is_need_video", false);
                break;
            case 5:
                if (this.mio != null) {
                    this.mio.B(intent);
                    break;
                }
                break;
            default:
                x.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", Integer.valueOf(hashCode()));
        this.mik = new a(this);
        return this.mik;
    }

    public boolean onUnbind(Intent intent) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
        super.onDestroy();
    }

    private void n(Message message) {
        try {
            if (this.mim != null) {
                x.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", Integer.valueOf(message.what), message.toString(), Integer.valueOf(this.mim.hashCode()));
                this.mim.send(message);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectProcessService", e, "", new Object[0]);
        }
    }

    private void cv(int i, int i2) {
        x.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        n(message);
    }
}
