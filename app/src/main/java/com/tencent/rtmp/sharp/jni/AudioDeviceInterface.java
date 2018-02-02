package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface {
    private static boolean _dumpEnable = false;
    private static boolean _logEnable = true;
    private TraeAudioSession _as = null;
    private AudioManager _audioManager = null;
    private AudioRecord _audioRecord = null;
    private boolean _audioRouteChanged = false;
    private int _audioSource = 0;
    private int _audioSourcePolicy = -1;
    private int _audioStreamTypePolicy = -1;
    private AudioTrack _audioTrack = null;
    private int _bufferedPlaySamples = 0;
    private int _bufferedRecSamples = 0;
    private int _channelOutType = 4;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private Context _context = null;
    private boolean _doPlayInit = true;
    private boolean _doRecInit = true;
    private TraeAudioSession _init_as = null;
    private boolean _isPlaying = false;
    private boolean _isRecording = false;
    private int _modePolicy = -1;
    private ByteBuffer _playBuffer;
    private final ReentrantLock _playLock = new ReentrantLock();
    private int _playPosition = 0;
    private int _playSamplerate = 8000;
    private File _play_dump = null;
    private FileOutputStream _play_out = null;
    private boolean _preDone = false;
    private Condition _precon = this._prelock.newCondition();
    private ReentrantLock _prelock = new ReentrantLock();
    private ByteBuffer _recBuffer;
    private final ReentrantLock _recLock = new ReentrantLock();
    private File _rec_dump = null;
    private FileOutputStream _rec_out = null;
    private int _sceneModeKey = 0;
    private int _sessionId = 0;
    private int _streamType = 0;
    private byte[] _tempBufPlay;
    private byte[] _tempBufRec;
    private int switchState = 0;
    private boolean usingJava = true;

    public AudioDeviceInterface() {
        try {
            this._playBuffer = ByteBuffer.allocateDirect(1920);
            this._recBuffer = ByteBuffer.allocateDirect(1920);
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, e.getMessage());
            }
        }
        this._tempBufPlay = new byte[1920];
        this._tempBufRec = new byte[1920];
        int i = VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " SDK_INT:" + VERSION.SDK_INT);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
    }

    public void setContext(Context context) {
        this._context = context;
    }

    private int getLowlatencySamplerate() {
        if (this._context != null && VERSION.SDK_INT >= 9) {
            boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "LOW_LATENCY:" + (hasSystemFeature ? "Y" : "N"));
            }
            if (VERSION.SDK_INT < 17) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + VERSION.SDK_INT);
        }
        return 0;
    }

    private int getLowlatencyFramesPerBuffer() {
        if (this._context != null && VERSION.SDK_INT >= 9) {
            boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "LOW_LATENCY:" + (hasSystemFeature ? "Y" : "N"));
            }
            if (VERSION.SDK_INT < 17 && QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + VERSION.SDK_INT);
        }
        return 0;
    }

    @TargetApi(16)
    private int getAudioSessionId(AudioRecord audioRecord) {
        return 0;
    }

    private int InitSetting(int i, int i2, int i3, int i4) {
        this._audioSourcePolicy = i;
        this._audioStreamTypePolicy = i2;
        this._modePolicy = i3;
        this._sceneModeKey = i4;
        if (this._sceneModeKey == 1 || this._sceneModeKey == 2 || this._sceneModeKey == 3) {
            TraeAudioManager.IsMusicScene = true;
        } else {
            TraeAudioManager.IsMusicScene = false;
        }
        TraeAudioManager.IsUpdateSceneFlag = true;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " sceneModeKey:" + i4);
        }
        return 0;
    }

    private int InitRecording(int i, int i2) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording entry:" + i);
        }
        if (this._isRecording || this._audioRecord != null || i2 > 2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
            }
            return -1;
        }
        int i3 = 16;
        if (i2 == 2) {
            i3 = 12;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(i, i3, 2);
        int i4 = (((i * 20) * i2) * 2) / 1000;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + minBufferSize + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i4);
        }
        this._bufferedRecSamples = (i * 5) / 200;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
        }
        if (this._audioRecord != null) {
            this._audioRecord.release();
            this._audioRecord = null;
        }
        int[] iArr = new int[]{0, 1, 5, 0};
        iArr[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
        int i5 = minBufferSize;
        for (int i6 = 0; i6 < 4 && this._audioRecord == null; i6++) {
            this._audioSource = iArr[i6];
            int i7 = 1;
            while (i7 <= 2) {
                i5 = minBufferSize * i7;
                if (i5 >= i4 * 4 || i7 >= 2) {
                    try {
                        this._audioRecord = new AudioRecord(this._audioSource, i, i3, 2, i5);
                        if (this._audioRecord.getState() == 1) {
                            break;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + i5 + " sr:" + i + " as:" + this._audioSource);
                        }
                        this._audioRecord.release();
                        this._audioRecord = null;
                    } catch (Exception e) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, e.getMessage() + " _audioRecord:" + this._audioRecord);
                        }
                        if (this._audioRecord != null) {
                            this._audioRecord.release();
                        }
                        this._audioRecord = null;
                    }
                }
                i7++;
            }
        }
        if (this._audioRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitRecording fail!!!");
            }
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + i + " recBufSize:" + i5);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording exit");
        }
        return this._bufferedRecSamples;
    }

    private int InitPlayback(int i, int i2) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback entry: sampleRate " + i);
        }
        if (this._isPlaying || this._audioTrack != null || i2 > 2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
            }
            return -1;
        }
        int i3;
        if (this._audioManager == null) {
            try {
                this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, e.getMessage());
                }
                return -1;
            }
        }
        if (i2 == 2) {
            this._channelOutType = 12;
        } else {
            this._channelOutType = 4;
        }
        this._playSamplerate = i;
        int minBufferSize = AudioTrack.getMinBufferSize(i, this._channelOutType, 2);
        if (this._channelOutType == 12) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback, _channelOutType stero");
            } else if (this._channelOutType == 4 && QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback, _channelOutType Mono");
            }
        }
        int i4 = (((i * 20) * 1) * 2) / 1000;
        if (this._channelOutType == 12) {
            i3 = i4 * 2;
        } else {
            i3 = i4;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + minBufferSize + " 20msFz:" + i3);
        }
        this._bufferedPlaySamples = 0;
        if (this._audioTrack != null) {
            this._audioTrack.release();
            this._audioTrack = null;
        }
        int[] iArr = new int[]{0, 0, 3, 1};
        this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
        if (this._audioRouteChanged) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
            }
            if (this._audioManager.getMode() == 0 && this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                this._streamType = 3;
            } else {
                this._streamType = 0;
            }
            this._audioRouteChanged = false;
        }
        iArr[0] = this._streamType;
        int i5 = minBufferSize;
        for (int i6 = 0; i6 < 4 && this._audioTrack == null; i6++) {
            this._streamType = iArr[i6];
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + minBufferSize + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
            }
            int i7 = 1;
            while (i7 <= 2) {
                i5 = minBufferSize * i7;
                if (i5 >= i3 * 4 || i7 >= 2) {
                    try {
                        this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i5, 1);
                        if (this._audioTrack.getState() == 1) {
                            break;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + i5 + " sr:" + this._playSamplerate);
                        }
                        this._audioTrack.release();
                        this._audioTrack = null;
                    } catch (Exception e2) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, e2.getMessage() + " _audioTrack:" + this._audioTrack);
                        }
                        if (this._audioTrack != null) {
                            this._audioTrack.release();
                        }
                        this._audioTrack = null;
                    }
                }
                i7++;
            }
        }
        if (this._audioTrack == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback fail!!!");
            }
            return -1;
        }
        if (!(this._as == null || this._audioManager == null)) {
            this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
        }
        this._playPosition = this._audioTrack.getPlaybackHeadPosition();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i5);
        }
        AudioManager audioManager = this._audioManager;
        if (this._connectedDev.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
            i4 = 6;
        } else {
            i4 = this._audioTrack.getStreamType();
        }
        TraeAudioManager.forceVolumeControlStream(audioManager, i4);
        return 0;
    }

    private String getDumpFilePath(String str, int i) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + i + "-" + str;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump:" + str2);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump replace:" + str2.replace(" ", "_"));
        }
        return str2.replace(" ", "_");
    }

    private int StartRecording() {
        int i = -1;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StartRecording entry");
        }
        if (this._isRecording) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, "StartRecording _isRecording:" + this._isRecording);
            return -1;
        } else if (this._audioRecord != null) {
            try {
                this._audioRecord.startRecording();
                if (_dumpEnable) {
                    String str = "jnirecord.pcm";
                    if (this._audioManager != null) {
                        i = this._audioManager.getMode();
                    }
                    this._rec_dump = new File(getDumpFilePath(str, i));
                    try {
                        this._rec_out = new FileOutputStream(this._rec_dump);
                    } catch (FileNotFoundException e) {
                    }
                }
                this._isRecording = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StartRecording ok");
                }
                return 0;
            } catch (IllegalStateException e2) {
                if (!QLog.isColorLevel()) {
                    return -1;
                }
                QLog.e("TRAE", 2, "StartRecording fail");
                return -1;
            }
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, "StartRecording _audioRecord:" + this._audioRecord);
            return -1;
        }
    }

    private int StartPlayback() {
        int i = -1;
        if (this._isPlaying) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, "StartPlayback _isPlaying");
            return -1;
        } else if (this._audioTrack != null) {
            try {
                this._audioTrack.play();
                if (_dumpEnable) {
                    String str = "jniplay.pcm";
                    if (this._audioManager != null) {
                        i = this._audioManager.getMode();
                    }
                    this._play_dump = new File(getDumpFilePath(str, i));
                    try {
                        this._play_out = new FileOutputStream(this._play_dump);
                    } catch (FileNotFoundException e) {
                    }
                }
                this._isPlaying = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StartPlayback ok");
                }
                return 0;
            } catch (IllegalStateException e2) {
                if (!QLog.isColorLevel()) {
                    return -1;
                }
                QLog.e("TRAE", 2, "StartPlayback fail");
                return -1;
            }
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, "StartPlayback _audioTrack:" + this._audioTrack);
            return -1;
        }
    }

    private int StopRecording() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording entry");
        }
        if (this._audioRecord != null) {
            this._recLock.lock();
            try {
                if (this._audioRecord.getRecordingState() == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "StopRecording stop... state:" + this._audioRecord.getRecordingState());
                    }
                    this._audioRecord.stop();
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
                }
                this._audioRecord.release();
                this._audioRecord = null;
                this._isRecording = false;
                this._recLock.unlock();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopRecording exit ok");
                }
                return 0;
            } catch (IllegalStateException e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StopRecording  err");
                }
                this._recLock.unlock();
                return -1;
            } catch (Throwable th) {
                this._recLock.unlock();
            }
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, "UnintRecord:" + this._audioRecord);
            return -1;
        }
    }

    private int StopPlayback() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback entry _isPlaying:" + this._isPlaying);
        }
        if (this._audioTrack != null) {
            this._playLock.lock();
            try {
                if (this._audioTrack.getPlayState() == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "StopPlayback stoping...");
                    }
                    this._audioTrack.stop();
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
                    }
                    this._audioTrack.flush();
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
                }
                this._audioTrack.release();
                this._audioTrack = null;
                this._isPlaying = false;
                this._playLock.unlock();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopPlayback exit ok");
                }
                return 0;
            } catch (IllegalStateException e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StopPlayback err");
                }
                this._playLock.unlock();
                return -1;
            } catch (Throwable th) {
                this._playLock.unlock();
            }
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, "StopPlayback _isPlaying:" + this._isPlaying + " " + this._audioTrack);
            return -1;
        }
    }

    private int PlayAudio(int i) {
        Exception e;
        if (((!this._isPlaying ? 1 : 0) | (this._audioTrack == null ? 1 : 0)) != 0) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "PlayAudio: _isPlaying " + this._isPlaying + " " + this._audioTrack);
            }
            return -1;
        }
        this._playLock.lock();
        try {
            if (this._audioTrack == null) {
                this._playLock.unlock();
                return -2;
            }
            Object obj;
            if (this._doPlayInit) {
                try {
                    Process.setThreadPriority(-19);
                } catch (Exception e2) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "Set play thread priority failed: " + e2.getMessage());
                    }
                }
                this._doPlayInit = false;
            }
            if (_dumpEnable && this._play_out != null) {
                try {
                    this._play_out.write(this._tempBufPlay, 0, 0);
                } catch (IOException e3) {
                }
            }
            if (this._audioRouteChanged) {
                if (this._audioManager == null && this._context != null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (this._audioManager.getMode() == 0 && this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._streamType = 3;
                } else {
                    this._streamType = 0;
                }
                obj = this._streamType == this._audioTrack.getStreamType() ? null : 1;
                this._audioRouteChanged = false;
            } else {
                obj = null;
            }
            this._playBuffer.get(this._tempBufPlay);
            int i2;
            if (obj != null) {
                this._playBuffer.rewind();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " track resting: _streamType:" + this._streamType + " at.st:" + this._audioTrack.getStreamType());
                }
                if (this._audioTrack.getPlayState() == 3) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "StopPlayback stoping...");
                        }
                        this._audioTrack.stop();
                        this._audioTrack.flush();
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
                        }
                        this._audioTrack.release();
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
                        }
                        this._audioTrack = null;
                    } catch (IllegalStateException e4) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "StopPlayback err");
                        }
                    }
                }
                try {
                    int i3;
                    int minBufferSize = AudioTrack.getMinBufferSize(this._playSamplerate, this._channelOutType, 2);
                    int[] iArr = new int[]{0, 0, 3, 1};
                    iArr[0] = this._streamType;
                    i2 = (((this._playSamplerate * 20) * 1) * 2) / 1000;
                    if (this._channelOutType == 12) {
                        i3 = i2 * 2;
                    } else {
                        i3 = i2;
                    }
                    for (int i4 = 0; i4 < 4 && this._audioTrack == null; i4++) {
                        this._streamType = iArr[i4];
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + minBufferSize + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
                        }
                        int i5 = 1;
                        while (i5 <= 2) {
                            int i6 = minBufferSize * i5;
                            if (i6 >= i3 * 4 || i5 >= 2) {
                                try {
                                    this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i6, 1);
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " _audioTrack:" + this._audioTrack);
                                    }
                                    if (this._audioTrack.getState() == 1) {
                                        break;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + i6 + " sr:" + this._playSamplerate);
                                    }
                                    this._audioTrack.release();
                                    this._audioTrack = null;
                                } catch (Exception e22) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, e22.getMessage() + " _audioTrack:" + this._audioTrack);
                                    }
                                    if (this._audioTrack != null) {
                                        this._audioTrack.release();
                                    }
                                    this._audioTrack = null;
                                }
                            }
                            i5++;
                        }
                    }
                    if (this._audioTrack != null) {
                        try {
                            this._audioTrack.play();
                            this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
                            TraeAudioManager.forceVolumeControlStream(this._audioManager, this._connectedDev.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET) ? 6 : this._audioTrack.getStreamType());
                        } catch (Exception e5) {
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "  track reset used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                    }
                } catch (Exception e6) {
                    e22 = e6;
                }
            } else {
                i2 = this._audioTrack.write(this._tempBufPlay, 0, i);
                try {
                    this._playBuffer.rewind();
                    if (i2 < 0) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "Could not write data from sc (write = " + i2 + ", length = " + i + ")");
                        }
                        this._playLock.unlock();
                        return -1;
                    }
                    if (i2 != i) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "Could not write all data from sc (write = " + i2 + ", length = " + i + ")");
                        }
                    }
                    this._bufferedPlaySamples += i2 >> 1;
                    int playbackHeadPosition = this._audioTrack.getPlaybackHeadPosition();
                    if (playbackHeadPosition < this._playPosition) {
                        this._playPosition = 0;
                    }
                    this._bufferedPlaySamples -= playbackHeadPosition - this._playPosition;
                    this._playPosition = playbackHeadPosition;
                    i = i2;
                } catch (Exception e7) {
                    i = i2;
                    e22 = e7;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "PlayAudio Exception: " + e22.getMessage());
                        }
                        this._playLock.unlock();
                        return i;
                    } catch (Throwable th) {
                        this._playLock.unlock();
                    }
                }
            }
            this._playLock.unlock();
            return i;
        } catch (Exception e8) {
            e22 = e8;
            i = 0;
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "PlayAudio Exception: " + e22.getMessage());
            }
            this._playLock.unlock();
            return i;
        }
    }

    private int OpenslesNeedResetAudioTrack(boolean z) {
        try {
            if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
                return -1;
            }
            if (this._audioRouteChanged || z) {
                if (this._audioManager == null && this._context != null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (this._audioManager == null) {
                    return 0;
                }
                if (this._audioManager.getMode() == 0 && this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._audioStreamTypePolicy = 3;
                } else {
                    this._audioStreamTypePolicy = 0;
                }
                this._audioRouteChanged = false;
            }
            return this._audioStreamTypePolicy;
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "PlayAudio Exception: " + e.getMessage());
            }
        }
    }

    private int RecordAudio(int i) {
        Exception e;
        if (this._isRecording) {
            this._recLock.lock();
            int read;
            try {
                if (this._audioRecord == null) {
                    this._recLock.unlock();
                    return -2;
                }
                if (this._doRecInit) {
                    try {
                        Process.setThreadPriority(-19);
                    } catch (Exception e2) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "Set rec thread priority failed: " + e2.getMessage());
                        }
                    }
                    this._doRecInit = false;
                }
                this._recBuffer.rewind();
                read = this._audioRecord.read(this._tempBufRec, 0, i);
                if (read < 0) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "Could not read data from sc (read = " + read + ", length = " + i + ")");
                        }
                        this._recLock.unlock();
                        return -1;
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "RecordAudio Exception: " + e.getMessage());
                            }
                            this._recLock.unlock();
                            return read;
                        } catch (Throwable th) {
                            this._recLock.unlock();
                        }
                    }
                } else {
                    this._recBuffer.put(this._tempBufRec, 0, read);
                    if (_dumpEnable && this._rec_out != null) {
                        try {
                            this._rec_out.write(this._tempBufRec, 0, read);
                        } catch (IOException e4) {
                        }
                    }
                    if (read != i) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "Could not read all data from sc (read = " + read + ", length = " + i + ")");
                        }
                        this._recLock.unlock();
                        return -1;
                    }
                    this._recLock.unlock();
                    return read;
                }
            } catch (Exception e22) {
                e = e22;
                read = 0;
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "RecordAudio Exception: " + e.getMessage());
                }
                this._recLock.unlock();
                return read;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "RecordAudio: _isRecording " + this._isRecording);
        }
        return -1;
    }

    private int SetPlayoutVolume(int i) {
        if (this._audioManager == null && this._context != null) {
            this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this._audioManager == null) {
            return -1;
        }
        this._audioManager.setStreamVolume(0, i, 0);
        return 0;
    }

    private int GetPlayoutVolume() {
        if (this._audioManager == null && this._context != null) {
            this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this._audioManager != null) {
            return this._audioManager.getStreamVolume(0);
        }
        return -1;
    }

    public static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        stringBuffer.append(stackTrace[2].getClassName()).append(".").append(stackTrace[2].getMethodName()).append(": ").append(stackTrace[2].getLineNumber());
        return stringBuffer.toString();
    }

    public static final void LogTraceEntry(String str) {
        if (_logEnable) {
            String str2 = getTraceInfo() + " entry:" + str;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, str2);
            }
        }
    }

    public static final void LogTraceExit() {
        if (_logEnable) {
            String str = getTraceInfo() + " exit";
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, str);
            }
        }
    }

    private void onOutputChanage(String str) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " onOutputChanage:" + str);
        }
        setAudioRouteSwitchState(str);
        if (TraeAudioManager.isCloseSystemAPM(this._modePolicy) && this._sceneModeKey != 1 && this._sceneModeKey != 2 && this._sceneModeKey != 3) {
            String str2;
            String str3;
            this._connectedDev = str;
            if (QLog.isColorLevel()) {
                str2 = "TRAE";
                StringBuilder append = new StringBuilder(" onOutputChanage:").append(str);
                if (this._audioManager == null) {
                    str3 = " am==null";
                } else {
                    str3 = " mode:" + this._audioManager.getMode();
                }
                append = append.append(str3).append(" st:").append(this._streamType);
                if (this._audioTrack == null) {
                    str3 = "_audioTrack==null";
                } else {
                    str3 = " at.st:" + this._audioTrack.getStreamType();
                }
                QLog.w(str2, 2, append.append(str3).toString());
            }
            try {
                if (this._audioManager == null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (QLog.isColorLevel()) {
                    str2 = "TRAE";
                    StringBuilder append2 = new StringBuilder(" curr mode:").append(str);
                    if (this._audioManager == null) {
                        str3 = "am==null";
                    } else {
                        str3 = " mode:" + this._audioManager.getMode();
                    }
                    QLog.w(str2, 2, append2.append(str3).toString());
                }
                if (this._audioManager != null && this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._audioManager.setMode(0);
                }
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, e.getMessage());
                }
            }
            this._audioRouteChanged = true;
        }
    }

    public int call_preprocess() {
        LogTraceEntry("");
        this.switchState = 0;
        this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
        if (this._as == null) {
            QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck init: call_preprocess");
        }
        this._as = new TraeAudioSession(this._context, new 1(this));
        this._preDone = false;
        if (this._as != null) {
            this._prelock.lock();
            try {
                this._as.voiceCallPreprocess(this._modePolicy, this._streamType);
                this._as.connectHighestPriorityDevice();
                int i = 7;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    try {
                        if (this._preDone) {
                            break;
                        }
                        this._precon.await(1, TimeUnit.SECONDS);
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "call_preprocess waiting...  as:" + this._as);
                            i = i2;
                        } else {
                            i = i2;
                        }
                    } catch (InterruptedException e) {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "call_preprocess done!");
                }
                this._as.getConnectedDevice();
            } finally {
                this._prelock.unlock();
            }
        }
        LogTraceExit();
        return 0;
    }

    public int call_postprocess() {
        LogTraceEntry("");
        this.switchState = 0;
        if (this._as != null) {
            this._as.voiceCallPostprocess();
            this._as.release();
            this._as = null;
            QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck release: call_postprocess");
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        LogTraceExit();
        return 0;
    }

    public int call_preprocess_media() {
        LogTraceEntry("");
        this.switchState = 0;
        if (this._as == null) {
            QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck init: call_preprocess_media");
        }
        this._as = new TraeAudioSession(this._context, new 2(this));
        if (this._as != null) {
            try {
                if (this._audioManager == null) {
                    this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                if (this._audioManager != null) {
                    if (this._audioManager.getMode() == 2) {
                        int i = 5;
                        while (true) {
                            int i2 = i - 1;
                            if (i <= 0 || this._audioManager.getMode() != 2) {
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "media call_preprocess waiting...  mode:" + this._audioManager.getMode());
                            }
                            Thread.sleep(500);
                            i = i2;
                        }
                    }
                    if (this._audioManager.getMode() != 0) {
                        this._audioManager.setMode(0);
                    }
                }
                this._as.connectHighestPriorityDevice();
                this._as.getConnectedDevice();
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "call_preprocess done!");
                }
            } catch (InterruptedException e) {
            }
        }
        LogTraceExit();
        return 0;
    }

    public int call_postprocess_media() {
        LogTraceEntry("");
        this.switchState = 0;
        if (this._as != null) {
            this._as.release();
            this._as = null;
            QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck release: call_postprocess_media");
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        LogTraceExit();
        return 0;
    }

    public void setJavaInterface(int i) {
        if (i == 0) {
            this.usingJava = false;
        } else {
            this.usingJava = true;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setJavaInterface flg:" + i);
        }
    }

    private void setAudioRouteSwitchState(String str) {
        if (str.equals(TraeAudioManager.DEVICE_EARPHONE)) {
            this.switchState = 1;
        } else if (str.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
            this.switchState = 2;
        } else if (str.equals(TraeAudioManager.DEVICE_WIREDHEADSET)) {
            this.switchState = 3;
        } else if (str.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
            this.switchState = 4;
        } else {
            this.switchState = 0;
        }
    }

    public int getAudioRouteSwitchState() {
        return this.switchState;
    }

    private void initTRAEAudioManager() {
        if (this._context != null) {
            TraeAudioManager.init(this._context);
            if (this._init_as == null) {
                QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck init: initTRAEAudioManager");
                this._init_as = new TraeAudioSession(this._context, null);
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService");
            }
            this._init_as.startService(TraeAudioManager.MUSIC_CONFIG);
        }
    }

    private int getAndroidSdkVersion() {
        return VERSION.SDK_INT;
    }

    private void uninitTRAEAudioManager() {
        if (this._context != null) {
            if (this._init_as != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
                }
                this._init_as.stopService();
                this._init_as.release();
                this._init_as = null;
                QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck release: uninitTRAEAudioManager");
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
            }
            TraeAudioManager.uninit();
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
        }
    }
}
