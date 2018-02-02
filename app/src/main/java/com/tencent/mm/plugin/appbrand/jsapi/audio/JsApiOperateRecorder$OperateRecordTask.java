package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateRecorder.a;
import com.tencent.mm.plugin.appbrand.media.f;
import com.tencent.mm.plugin.appbrand.media.f.7;
import com.tencent.mm.plugin.appbrand.media.f.8;
import com.tencent.mm.plugin.appbrand.media.f.AnonymousClass6;
import com.tencent.mm.plugin.appbrand.media.g;
import com.tencent.mm.plugin.appbrand.media.record.RecordParam;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateRecorder$OperateRecordTask extends MainProcessTask {
    public static final Creator<JsApiOperateRecorder$OperateRecordTask> CREATOR = new 2();
    public int action;
    public String appId;
    private int duration = 0;
    private byte[] fCI;
    private boolean fCJ;
    private String filePath = "";
    private int fileSize = 0;
    public j jcM;
    public int jcN;
    public boolean jeA = false;
    b jeV;
    public String jeW;
    public String jey = "";
    private JsApiOperateRecorder jfk;
    public String jfl;
    private String jfm = "";
    private String jfn;
    private int jfo;
    private final c<li> jfp = new 1(this);
    public String processName = "";
    private String state = "";

    static /* synthetic */ void a(JsApiOperateRecorder$OperateRecordTask jsApiOperateRecorder$OperateRecordTask, li liVar) {
        Throwable e;
        long nanoTime = System.nanoTime();
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(jsApiOperateRecorder$OperateRecordTask.jfn);
            x.d("MicroMsg.JsApiOperateRecorder", "frameBufferPath:%s", new Object[]{jsApiOperateRecorder$OperateRecordTask.jfn});
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(liVar.fCH.fCI);
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                }
            } catch (FileNotFoundException e3) {
                e2 = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                        }
                    }
                    x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = fileOutputStream2;
                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                    }
                }
                x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
            } catch (Throwable th2) {
                e222 = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e222;
            }
        } catch (FileNotFoundException e6) {
            e222 = e6;
            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (IOException e7) {
            e222 = e7;
            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
        }
        x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
    }

    public JsApiOperateRecorder$OperateRecordTask(JsApiOperateRecorder jsApiOperateRecorder, j jVar, int i) {
        this.jfk = jsApiOperateRecorder;
        this.jcM = jVar;
        this.jcN = i;
        this.jfn = AppBrandLocalMediaObjectManager.genMediaFilePath(jVar.mAppId, "frameBuffer");
    }

    public JsApiOperateRecorder$OperateRecordTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(this.jfl);
            String optString = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.JsApiOperateRecorder", "operationType is null");
                this.jeA = true;
                this.action = -1;
                this.jey = "operationType is null";
                afp();
                return;
            }
            x.i("MicroMsg.JsApiOperateRecorder", "operationType;%s", new Object[]{optString});
            this.jeA = false;
            this.action = -1;
            boolean z2;
            if (optString.equals("start")) {
                int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60000);
                int optInt2 = jSONObject.optInt("sampleRate", 44100);
                int optInt3 = jSONObject.optInt("numberOfChannels", 2);
                int optInt4 = jSONObject.optInt("encodeBitRate", 128000);
                String optString2 = jSONObject.optString("format");
                int optInt5 = jSONObject.optInt("frameSize", 0);
                com.tencent.mm.plugin.appbrand.media.c.a(this.appId, this.jfp);
                com.tencent.mm.plugin.appbrand.media.c.aim();
                RecordParam recordParam = new RecordParam();
                recordParam.duration = optInt;
                recordParam.sampleRate = optInt2;
                recordParam.jAv = optInt3;
                recordParam.jAw = optInt4;
                recordParam.jfm = optString2;
                recordParam.scene = 8;
                recordParam.afs = optInt5;
                recordParam.gHg = System.currentTimeMillis();
                recordParam.processName = this.processName;
                recordParam.appId = this.appId;
                this.jfm = optString2;
                f Zs = com.tencent.mm.plugin.appbrand.app.f.Zs();
                x.i("MicroMsg.AudioRecordMgr", JsApiStartRecordVoice.NAME);
                if (Zs.jzG == null || recordParam.appId == null || recordParam.appId.equalsIgnoreCase(Zs.jzG.appId)) {
                    if (Zs.jzE) {
                        x.e("MicroMsg.AudioRecordMgr", "startRecord fail, is recording");
                    } else if (Zs.vg()) {
                        x.e("MicroMsg.AudioRecordMgr", "startRecord fail, is pause");
                    }
                    if (z) {
                        x.i("MicroMsg.JsApiOperateRecorder", "star record ok");
                        this.action = -1;
                    } else if (com.tencent.mm.plugin.appbrand.app.f.Zs().jzE) {
                        this.jeA = true;
                        this.jey = "start record fail";
                    } else {
                        this.jeA = true;
                        this.jey = "audio is recording, don't start record again";
                    }
                } else {
                    x.e("MicroMsg.AudioRecordMgr", "appId is diff, must stop record first");
                    Zs.vi();
                }
                z2 = !TextUtils.isEmpty(recordParam.jfm) && recordParam.duration >= 0 && recordParam.jAw > 0 && recordParam.sampleRate > 0 && recordParam.jAv > 0;
                if (!z2) {
                    x.e("MicroMsg.AudioRecordMgr", "startRecord fail, param is invalid");
                    com.tencent.mm.plugin.appbrand.media.j.kV(15);
                } else if (g.tk(recordParam.jfm)) {
                    if (TextUtils.isEmpty(recordParam.gHg)) {
                        recordParam.gHg = System.currentTimeMillis();
                    }
                    com.tencent.mm.plugin.appbrand.media.j.aiv();
                    x.i("MicroMsg.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", new Object[]{Integer.valueOf(recordParam.duration), Integer.valueOf(recordParam.jAv), Integer.valueOf(recordParam.sampleRate), Integer.valueOf(recordParam.jAw)});
                    if (recordParam.duration <= 0) {
                        recordParam.duration = 60000;
                    } else if (recordParam.duration >= 600000) {
                        recordParam.duration = 600000;
                    }
                    if (recordParam.jAv <= 0 && recordParam.jAv > 2) {
                        recordParam.jAv = 2;
                    }
                    if (recordParam.sampleRate > 48000) {
                        recordParam.sampleRate = 48000;
                    } else if (recordParam.sampleRate < 8000) {
                        recordParam.sampleRate = 8000;
                    }
                    if (recordParam.jAw > 320000) {
                        recordParam.jAw = 320000;
                    } else if (recordParam.jAw < 16000) {
                        recordParam.jAw = 16000;
                    }
                    e.post(new AnonymousClass6(Zs, recordParam), "app_brand_start_record");
                    z = true;
                } else {
                    x.e("MicroMsg.AudioRecordMgr", "startRecord fail, encode format %s is not support!", new Object[]{recordParam.jfm});
                    com.tencent.mm.plugin.appbrand.media.j.kV(16);
                }
                if (z) {
                    x.i("MicroMsg.JsApiOperateRecorder", "star record ok");
                    this.action = -1;
                } else if (com.tencent.mm.plugin.appbrand.app.f.Zs().jzE) {
                    this.jeA = true;
                    this.jey = "start record fail";
                } else {
                    this.jeA = true;
                    this.jey = "audio is recording, don't start record again";
                }
            } else if (optString.equals("resume")) {
                r0 = com.tencent.mm.plugin.appbrand.app.f.Zs();
                if (r0.jzE) {
                    x.e("MicroMsg.AudioRecordMgr", "resumeRecord fail, is recording");
                } else if (r0.jzG == null) {
                    x.e("MicroMsg.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
                } else {
                    com.tencent.mm.plugin.appbrand.media.j.aiv();
                    e.post(new 7(r0), "app_brand_resume_record");
                    z = true;
                }
                if (z) {
                    this.action = -1;
                    x.i("MicroMsg.JsApiOperateRecorder", "resume record ok");
                } else if (com.tencent.mm.plugin.appbrand.app.f.Zs().jzE) {
                    this.jeA = true;
                    this.jey = "audio is recording, don't resume record again";
                } else {
                    this.jeA = true;
                    this.jey = "resume record fail";
                }
            } else if (optString.equals("pause")) {
                r0 = com.tencent.mm.plugin.appbrand.app.f.Zs();
                x.i("MicroMsg.AudioRecordMgr", "pauseRecord");
                if (r0.jzD == null) {
                    x.e("MicroMsg.AudioRecordMgr", "mRecord is null");
                    z2 = false;
                } else if (r0.vg()) {
                    x.e("MicroMsg.AudioRecordMgr", "is paused, don't pause again");
                    z2 = true;
                } else {
                    e.post(new 8(r0), "app_brand_pause_record");
                    z2 = true;
                }
                if (z2) {
                    this.action = -1;
                    x.i("MicroMsg.JsApiOperateRecorder", "pause record ok");
                } else if (com.tencent.mm.plugin.appbrand.app.f.Zs().vg()) {
                    this.jeA = true;
                    this.jey = "audio is pause, don't pause record again";
                } else {
                    this.jeA = true;
                    this.jey = "pause record fail";
                }
            } else if (!optString.equals("stop")) {
                x.e("MicroMsg.JsApiOperateRecorder", "operationType is invalid");
                this.jeA = true;
                this.jey = "operationType is invalid";
            } else if (com.tencent.mm.plugin.appbrand.app.f.Zs().vi()) {
                this.action = -1;
                x.i("MicroMsg.JsApiOperateRecorder", "stop record ok");
            } else if (com.tencent.mm.plugin.appbrand.app.f.Zs().aip()) {
                this.jeA = true;
                this.jey = "audio is stop, don't stop record again";
            } else {
                this.jeA = true;
                this.jey = "stop record fail";
            }
            if (this.jeA) {
                x.e("MicroMsg.JsApiOperateRecorder", this.jey);
            }
            afp();
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", new Object[]{this.jfl});
            this.jeA = true;
            this.action = -1;
            this.jey = "parser data fail, data is invalid";
            x.e("MicroMsg.JsApiOperateRecorder", "exception:%s" + e.getMessage());
            afp();
        }
    }

    public final void Ys() {
        File file;
        FileInputStream fileInputStream;
        Throwable e;
        File file2;
        com.tencent.mm.plugin.appbrand.jsapi.f a;
        FileInputStream fileInputStream2 = null;
        if (this.jcM == null) {
            x.e("MicroMsg.JsApiOperateRecorder", "service is null, don't callback");
        } else if (this.action != -1) {
            com.tencent.mm.plugin.appbrand.jsapi.b aVar = new a();
            switch (this.action) {
                case 0:
                case 1:
                    JsApiOperateRecorder.a(this.jfk, true);
                    if (!JsApiOperateRecorder.afz().contains(this.appId)) {
                        com.tencent.mm.plugin.appbrand.c.a(this.appId, this.jeV);
                        JsApiOperateRecorder.afz().add(this.appId);
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    JsApiOperateRecorder.a(this.jfk, false);
                    if (this.action == 2 || this.action == 4) {
                        com.tencent.mm.plugin.appbrand.c.b(this.appId, this.jeV);
                        JsApiOperateRecorder.afz().remove(this.appId);
                        break;
                    }
            }
            if (this.action == 2) {
                AppBrandLocalMediaObject attach;
                Map hashMap = new HashMap();
                hashMap.put("state", this.state);
                x.i("MicroMsg.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", new Object[]{this.filePath, this.jfm});
                String str = this.jcM.mAppId;
                String str2 = this.filePath;
                String str3 = this.jfm;
                if (!TextUtils.isEmpty(str3)) {
                    if ("aac".equalsIgnoreCase(str3)) {
                        str3 = "m4a";
                    } else if ("mp3".equalsIgnoreCase(str3)) {
                        str3 = "mp3";
                    } else if ("wav".equalsIgnoreCase(str3)) {
                        str3 = "wav";
                    }
                    attach = AppBrandLocalMediaObjectManager.attach(str, str2, str3, false);
                    if (attach == null) {
                        hashMap.put("tempFilePath", attach.fus);
                    } else {
                        x.e("MicroMsg.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                        hashMap.put("tempFilePath", "");
                    }
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                    hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                    this.jeW = new JSONObject(hashMap).toString();
                }
                str3 = "";
                attach = AppBrandLocalMediaObjectManager.attach(str, str2, str3, false);
                if (attach == null) {
                    x.e("MicroMsg.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                    hashMap.put("tempFilePath", "");
                } else {
                    hashMap.put("tempFilePath", attach.fus);
                }
                hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                this.jeW = new JSONObject(hashMap).toString();
            }
            if (this.action == 5) {
                Map hashMap2 = new HashMap();
                hashMap2.put("state", this.state);
                hashMap2.put("isLastFrame", Boolean.valueOf(this.fCJ));
                if (this.jfo > 819200) {
                    long nanoTime = System.nanoTime();
                    try {
                        file = new File(this.jfn);
                        try {
                            if (file.exists()) {
                                fileInputStream = new FileInputStream(file);
                                try {
                                    this.fCI = new byte[this.jfo];
                                    fileInputStream.read(this.fCI);
                                    fileInputStream.close();
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable e2) {
                                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                                    }
                                    if (file.exists()) {
                                        file.delete();
                                    } else {
                                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                    }
                                } catch (FileNotFoundException e3) {
                                    e2 = e3;
                                    file2 = file;
                                    try {
                                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Throwable e22) {
                                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                                            }
                                        }
                                        if (file2 == null) {
                                        }
                                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                                        if (this.fCI != null) {
                                            x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                                        } else {
                                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                                        }
                                        if (l.a(this.jcM, hashMap2, aVar)) {
                                            this.jeW = new JSONObject(hashMap2).toString();
                                        }
                                        x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
                                        a = aVar.a(this.jcM);
                                        a.mData = this.jeW;
                                        a.afs();
                                    } catch (Throwable th) {
                                        e22 = th;
                                        file = file2;
                                        fileInputStream2 = fileInputStream;
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (Throwable e4) {
                                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e4, "", new Object[0]);
                                            }
                                        }
                                        if (file == null) {
                                        }
                                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        throw e22;
                                    }
                                } catch (IOException e5) {
                                    e22 = e5;
                                    fileInputStream2 = fileInputStream;
                                    try {
                                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (Throwable e222) {
                                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                                            }
                                        }
                                        if (file == null) {
                                        }
                                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                                        if (this.fCI != null) {
                                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                                        } else {
                                            x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                                        }
                                        if (l.a(this.jcM, hashMap2, aVar)) {
                                            this.jeW = new JSONObject(hashMap2).toString();
                                        }
                                        x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
                                        a = aVar.a(this.jcM);
                                        a.mData = this.jeW;
                                        a.afs();
                                    } catch (Throwable th2) {
                                        e222 = th2;
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (file == null && file.exists()) {
                                            file.delete();
                                        } else {
                                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        }
                                        throw e222;
                                    }
                                } catch (Throwable th3) {
                                    e222 = th3;
                                    fileInputStream2 = fileInputStream;
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                    }
                                    if (file == null) {
                                    }
                                    x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                    throw e222;
                                }
                                x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                            } else {
                                x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, return");
                                if (file.exists()) {
                                    file.delete();
                                } else {
                                    x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                }
                            }
                        } catch (FileNotFoundException e6) {
                            e222 = e6;
                            fileInputStream = null;
                            file2 = file;
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file2 == null) {
                            }
                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                            if (this.fCI != null) {
                                x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                            } else {
                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                            }
                            if (l.a(this.jcM, hashMap2, aVar)) {
                                this.jeW = new JSONObject(hashMap2).toString();
                            }
                            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
                            a = aVar.a(this.jcM);
                            a.mData = this.jeW;
                            a.afs();
                        } catch (IOException e7) {
                            e222 = e7;
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (file == null) {
                            }
                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                            if (this.fCI != null) {
                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                            } else {
                                x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                            }
                            if (l.a(this.jcM, hashMap2, aVar)) {
                                this.jeW = new JSONObject(hashMap2).toString();
                            }
                            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
                            a = aVar.a(this.jcM);
                            a.mData = this.jeW;
                            a.afs();
                        }
                    } catch (FileNotFoundException e8) {
                        e222 = e8;
                        fileInputStream = null;
                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (file2 == null && file2.exists()) {
                            file2.delete();
                        } else {
                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        }
                        x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                        if (this.fCI != null) {
                            x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                        } else {
                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                        }
                        if (l.a(this.jcM, hashMap2, aVar)) {
                            this.jeW = new JSONObject(hashMap2).toString();
                        }
                        x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
                        a = aVar.a(this.jcM);
                        a.mData = this.jeW;
                        a.afs();
                    } catch (IOException e9) {
                        e222 = e9;
                        file = null;
                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (file == null && file.exists()) {
                            file.delete();
                        } else {
                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        }
                        x.d("MicroMsg.JsApiOperateRecorder", "time:%d", new Object[]{Long.valueOf(System.nanoTime() - nanoTime)});
                        if (this.fCI != null) {
                            hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                        } else {
                            x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                        }
                        if (l.a(this.jcM, hashMap2, aVar)) {
                            this.jeW = new JSONObject(hashMap2).toString();
                        }
                        x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
                        a = aVar.a(this.jcM);
                        a.mData = this.jeW;
                        a.afs();
                    } catch (Throwable th4) {
                        e222 = th4;
                        file = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (file == null) {
                        }
                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        throw e222;
                    }
                }
                if (this.fCI != null) {
                    hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fCI));
                } else {
                    x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                }
                if (l.a(this.jcM, hashMap2, aVar)) {
                    this.jeW = new JSONObject(hashMap2).toString();
                }
            }
            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", new Object[]{Integer.valueOf(this.action), this.jeW});
            a = aVar.a(this.jcM);
            a.mData = this.jeW;
            a.afs();
        } else if (this.jeA) {
            x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder fail:%s", new Object[]{this.jey});
            this.jcM.E(this.jcN, this.jfk.e("fail:" + this.jey, null));
        } else {
            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder ok");
            this.jcM.E(this.jcN, this.jfk.e("ok", null));
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.jfl = parcel.readString();
        this.jeA = parcel.readInt() == 1;
        this.jey = parcel.readString();
        this.jeW = parcel.readString();
        this.action = parcel.readInt();
        this.filePath = parcel.readString();
        this.fileSize = parcel.readInt();
        this.duration = parcel.readInt();
        this.state = parcel.readString();
        this.jfm = parcel.readString();
        this.fCI = parcel.createByteArray();
        this.jfo = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.fCJ = z;
        this.jfn = parcel.readString();
        this.processName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.appId);
        parcel.writeString(this.jfl);
        parcel.writeInt(this.jeA ? 1 : 0);
        parcel.writeString(this.jey);
        parcel.writeString(this.jeW);
        parcel.writeInt(this.action);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.duration);
        parcel.writeString(this.state);
        parcel.writeString(this.jfm);
        parcel.writeByteArray(this.fCI);
        parcel.writeInt(this.jfo);
        if (!this.fCJ) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.jfn);
        parcel.writeString(this.processName);
    }
}
