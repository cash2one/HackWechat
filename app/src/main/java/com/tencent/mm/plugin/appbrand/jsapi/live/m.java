package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher$ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class m implements ITXLivePushListener {
    boolean gNe = false;
    private boolean jkS = false;
    String jlA;
    private boolean jlB = false;
    private boolean jlC = false;
    TXLivePusher$ITXSnapshotListener jlD;
    private int jlE = 2;
    private int jlF = -1;
    private int jlG = -1;
    private int jlH = 0;
    boolean jlI = true;
    private String jlJ = "high";
    private int jlK = 5;
    private int jlL = 3;
    private String jlM = "";
    private boolean jlN = false;
    TXCloudVideoView jlj;
    private String jlq = "vertical";
    private boolean jlw = false;
    private TXLivePushConfig jlx;
    TXLivePusher jly;
    ITXLivePushListener jlz;
    private Context mContext;
    private boolean mFrontCamera = true;
    private int mMode = 1;
    private boolean mMute = false;

    public m(Context context) {
        this.mContext = context;
        this.jlx = new TXLivePushConfig();
        this.jly = new TXLivePusher(context);
        this.jly.setConfig(this.jlx);
        this.jly.setPushListener(this);
    }

    public final j st(String str) {
        if (str == null) {
            return new j(-1, "invalid params");
        }
        x.i("TXLivePusherJSAdapter", "operateLivePusher: " + str);
        if (str.equalsIgnoreCase("switchCamera")) {
            this.mFrontCamera = !this.mFrontCamera;
            this.jlx.setFrontCamera(this.mFrontCamera);
        }
        if (!this.gNe) {
            return new j(-3, "uninited livePusher");
        }
        if (str.equalsIgnoreCase("start")) {
            if (!(this.jlA == null || this.jlA.isEmpty() || this.jly.isPushing())) {
                this.jlj.setVisibility(0);
                if (this.jlI) {
                    this.jly.startCameraPreview(this.jlj);
                }
                this.jly.startPusher(this.jlA);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            this.jly.stopCameraPreview(true);
            this.jly.stopPusher();
        } else if (str.equalsIgnoreCase("pause")) {
            this.jly.pausePusher();
        } else if (str.equalsIgnoreCase("resume")) {
            this.jly.resumePusher();
        } else if (str.equalsIgnoreCase("switchCamera")) {
            this.jly.switchCamera();
        } else if (!str.equalsIgnoreCase("snapshot")) {
            return new j(-4, "invalid operate command");
        } else {
            TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener = this.jlD;
            if (this.jly != null && this.jly.isPushing()) {
                this.jly.snapshot(tXLivePusher$ITXSnapshotListener);
            }
        }
        return new j();
    }

    public final j cN(boolean z) {
        this.jlB = this.jly.isPushing();
        if (!this.jlB) {
            return new j();
        }
        if (!z) {
            return st("pause");
        }
        this.jlC = z;
        if (this.jkS && this.jlz != null) {
            this.jlz.onPushEvent(5000, new Bundle());
        }
        return st("stop");
    }

    public final j agv() {
        if (!this.jlB) {
            return new j();
        }
        if (this.jlC) {
            return st("start");
        }
        return st("resume");
    }

    public final void onPushEvent(int i, Bundle bundle) {
        if (i == TXLiveConstants.PUSH_ERR_NET_DISCONNECT) {
            st("stop");
        }
        if (this.jkS && this.jlz != null) {
            this.jlz.onPushEvent(i, bundle);
        }
    }

    public final void onNetStatus(Bundle bundle) {
        if (this.jlz != null) {
            this.jlz.onNetStatus(bundle);
        }
    }

    final void c(Bundle bundle, boolean z) {
        if (z || bundle.keySet().size() != 0) {
            int i;
            String string;
            int i2;
            boolean z2;
            boolean z3;
            String string2;
            int i3;
            int i4;
            String string3;
            Bitmap decodeFile;
            boolean z4;
            Object obj;
            boolean z5;
            int i5 = bundle.getInt("mode", this.mMode);
            if (z || i5 != this.mMode) {
                switch (i5) {
                    case 1:
                        this.jly.setVideoQuality(1, false, false);
                        break;
                    case 2:
                        this.jly.setVideoQuality(2, true, false);
                        break;
                    case 3:
                        this.jly.setVideoQuality(3, true, false);
                        break;
                    case 4:
                        this.jly.setVideoQuality(4, true, false);
                        break;
                    case 5:
                        this.jly.setVideoQuality(5, true, false);
                        break;
                    case 6:
                        this.jly.setVideoQuality(6, false, false);
                        break;
                }
            }
            int i6 = this.jlF;
            int i7 = this.jlG;
            int i8 = bundle.getInt("minBitrate", -1);
            int i9 = bundle.getInt("maxBitrate", -1);
            if (!(i8 == -1 || i9 == -1)) {
                if (i8 < 200) {
                    i8 = 200;
                }
                if (i9 > 1000) {
                    i9 = 1000;
                }
                if (i8 <= i9) {
                    i7 = i8;
                    i = bundle.getInt("aspect", this.jlE);
                    string = bundle.getString("audioQuality", this.jlJ);
                    if (i5 == 6) {
                        if (i == 1) {
                            this.jlx.setVideoResolution(13);
                        } else if (i == 2) {
                            this.jlx.setVideoResolution(0);
                        }
                        if (!(i7 == -1 || i9 == -1 || i7 > i9)) {
                            this.jlx.setMinVideoBitrate(i7);
                            this.jlx.setMaxVideoBitrate(i9);
                        }
                        if (string.equalsIgnoreCase("low")) {
                            this.jlx.setAudioSampleRate(16000);
                        } else if (string.equalsIgnoreCase("high")) {
                            this.jlx.setAudioSampleRate(48000);
                        }
                    }
                    i2 = bundle.getInt("focusMode", this.jlH);
                    this.jlx.setTouchFocus(i2 == 0);
                    z2 = bundle.getBoolean("enableCamera", this.jlI);
                    this.jlx.enablePureAudioPush(z2);
                    if (i5 == 6) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    string2 = bundle.getString("orientation", this.jlq);
                    i6 = 0;
                    if (string2.equalsIgnoreCase("horizontal")) {
                        this.jlx.setHomeOrientation(0);
                        i6 = 90;
                    } else if (string2.equalsIgnoreCase("vertical")) {
                        this.jlx.setHomeOrientation(1);
                        i6 = 0;
                    }
                    i3 = bundle.getInt("beauty", this.jlK);
                    i4 = bundle.getInt("whiteness", this.jlL);
                    this.jlx.setBeautyFilter(i3, i4, 5);
                    string3 = bundle.getString("backgroundImage", this.jlM);
                    decodeFile = BitmapFactory.decodeFile(string3);
                    if (decodeFile != null) {
                        this.jlx.setPauseImg(decodeFile);
                    }
                    z4 = bundle.getBoolean("backgroundMute", this.jlN);
                    if (z4) {
                        this.jlx.setPauseFlag(1);
                    } else {
                        this.jlx.setPauseFlag(3);
                    }
                    obj = null;
                    if (!(i == this.jlE && i7 == this.jlF && i9 == this.jlG && i2 == this.jlH && z3 == this.jlI && i3 == this.jlK && i4 == this.jlL && z4 == this.jlN && string3.equalsIgnoreCase(this.jlM) && string2.equalsIgnoreCase(this.jlq) && string.equalsIgnoreCase(this.jlJ))) {
                        obj = 1;
                    }
                    if (z || r5 != null) {
                        this.jly.setConfig(this.jlx);
                        this.jly.setRenderRotation(i6);
                        this.jly.setBeautyFilter(0, i3, i4, 2);
                    }
                    if (this.jly.isPushing()) {
                        if (z3 == this.jlI) {
                            if (z3) {
                                this.jly.stopCameraPreview(true);
                            } else {
                                this.jly.stopCameraPreview(true);
                                this.jly.startCameraPreview(this.jlj);
                            }
                        } else if (this.jlI && !string2.equalsIgnoreCase(this.jlq)) {
                            this.jly.stopCameraPreview(true);
                            this.jly.startCameraPreview(this.jlj);
                        }
                    }
                    this.mMode = i5;
                    this.jlE = i;
                    this.jlH = i2;
                    this.jlI = z3;
                    this.jlq = string2;
                    this.jlK = i3;
                    this.jlL = i4;
                    this.jlN = z4;
                    this.jlM = string3;
                    this.jlF = i7;
                    this.jlG = i9;
                    this.jlJ = string;
                    this.jkS = bundle.getBoolean("needEvent", this.jkS);
                    z5 = bundle.getBoolean("muted", this.mMute);
                    if (z || z5 != this.mMute) {
                        this.jly.setMute(z5);
                    }
                    this.mMute = z5;
                    z5 = bundle.getBoolean("debug", this.jlw);
                    if (z || z5 != this.jlw) {
                        this.jlj.showLog(z5);
                    }
                    this.jlw = z5;
                }
            }
            i9 = i7;
            i7 = i6;
            i = bundle.getInt("aspect", this.jlE);
            string = bundle.getString("audioQuality", this.jlJ);
            if (i5 == 6) {
                if (i == 1) {
                    this.jlx.setVideoResolution(13);
                } else if (i == 2) {
                    this.jlx.setVideoResolution(0);
                }
                this.jlx.setMinVideoBitrate(i7);
                this.jlx.setMaxVideoBitrate(i9);
                if (string.equalsIgnoreCase("low")) {
                    this.jlx.setAudioSampleRate(16000);
                } else if (string.equalsIgnoreCase("high")) {
                    this.jlx.setAudioSampleRate(48000);
                }
            }
            i2 = bundle.getInt("focusMode", this.jlH);
            if (i2 == 0) {
            }
            this.jlx.setTouchFocus(i2 == 0);
            z2 = bundle.getBoolean("enableCamera", this.jlI);
            if (z2) {
            }
            this.jlx.enablePureAudioPush(z2);
            if (i5 == 6) {
                z3 = z2;
            } else {
                z3 = true;
            }
            string2 = bundle.getString("orientation", this.jlq);
            i6 = 0;
            if (string2.equalsIgnoreCase("horizontal")) {
                this.jlx.setHomeOrientation(0);
                i6 = 90;
            } else if (string2.equalsIgnoreCase("vertical")) {
                this.jlx.setHomeOrientation(1);
                i6 = 0;
            }
            i3 = bundle.getInt("beauty", this.jlK);
            i4 = bundle.getInt("whiteness", this.jlL);
            this.jlx.setBeautyFilter(i3, i4, 5);
            string3 = bundle.getString("backgroundImage", this.jlM);
            decodeFile = BitmapFactory.decodeFile(string3);
            if (decodeFile != null) {
                this.jlx.setPauseImg(decodeFile);
            }
            z4 = bundle.getBoolean("backgroundMute", this.jlN);
            if (z4) {
                this.jlx.setPauseFlag(1);
            } else {
                this.jlx.setPauseFlag(3);
            }
            obj = null;
            obj = 1;
            this.jly.setConfig(this.jlx);
            this.jly.setRenderRotation(i6);
            this.jly.setBeautyFilter(0, i3, i4, 2);
            if (this.jly.isPushing()) {
                if (z3 == this.jlI) {
                    this.jly.stopCameraPreview(true);
                    this.jly.startCameraPreview(this.jlj);
                } else if (z3) {
                    this.jly.stopCameraPreview(true);
                } else {
                    this.jly.stopCameraPreview(true);
                    this.jly.startCameraPreview(this.jlj);
                }
            }
            this.mMode = i5;
            this.jlE = i;
            this.jlH = i2;
            this.jlI = z3;
            this.jlq = string2;
            this.jlK = i3;
            this.jlL = i4;
            this.jlN = z4;
            this.jlM = string3;
            this.jlF = i7;
            this.jlG = i9;
            this.jlJ = string;
            this.jkS = bundle.getBoolean("needEvent", this.jkS);
            z5 = bundle.getBoolean("muted", this.mMute);
            this.jly.setMute(z5);
            this.mMute = z5;
            z5 = bundle.getBoolean("debug", this.jlw);
            this.jlj.showLog(z5);
            this.jlw = z5;
        }
    }

    static void c(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("pushUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("backgroundImage") || str2.equalsIgnoreCase("audioQuality")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("focusMode") || str2.equalsIgnoreCase("beauty") || str2.equalsIgnoreCase("whiteness") || str2.equalsIgnoreCase("aspect") || str2.equalsIgnoreCase("minBitrate") || str2.equalsIgnoreCase("maxBitrate")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("hide") || str2.equalsIgnoreCase("autopush") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("enableCamera") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        x.i("TXLivePusherJSAdapter", str);
    }
}
