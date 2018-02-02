package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class TraeAudioManager extends BroadcastReceiver {
    public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
    public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
    public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
    static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
    public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
    public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
    public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
    static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
    public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
    public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
    public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
    public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
    public static final String DEVICE_NONE = "DEVICE_NONE";
    public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
    public static final int DEVICE_STATUS_CONNECTED = 2;
    public static final int DEVICE_STATUS_CONNECTING = 1;
    public static final int DEVICE_STATUS_DISCONNECTED = 0;
    public static final int DEVICE_STATUS_DISCONNECTING = 3;
    public static final int DEVICE_STATUS_ERROR = -1;
    public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
    public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
    public static final int EARACTION_AWAY = 0;
    public static final int EARACTION_CLOSE = 1;
    public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
    public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
    public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
    public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
    public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
    public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
    public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_DEFAULT = 0;
    public static final int FORCE_DIGITAL_DOCK = 9;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_NO_BT_A2DP = 10;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_DOCK = 3;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
    public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
    public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
    public static boolean IsMusicScene = false;
    public static boolean IsUpdateSceneFlag = false;
    public static final int MODE_MUSIC_PLAYBACK = 2;
    public static final int MODE_MUSIC_PLAY_RECORD = 1;
    public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
    public static final int MODE_VOICE_CHAT = 0;
    public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
    public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
    public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
    public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
    public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
    public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
    public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
    public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
    private static final int NUM_FORCE_CONFIG = 11;
    private static final int NUM_FORCE_USE = 4;
    public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
    public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
    public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
    public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
    public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
    public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
    public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
    public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
    public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
    public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
    public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
    public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
    public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
    public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
    public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
    public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
    public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
    public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
    public static final String PARAM_DEVICE = "PARAM_DEVICE";
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
    public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
    public static final String PARAM_OPERATION = "PARAM_OPERATION";
    public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
    public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
    public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
    public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
    public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
    public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
    public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
    public static final String PARAM_RING_URI = "PARAM_RING_URI";
    public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
    public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
    public static final String PARAM_STATUS = "PARAM_STATUS";
    public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
    public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
    public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
    public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
    public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
    public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
    public static final int RES_ERRCODE_NONE = 0;
    public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
    public static final int RES_ERRCODE_SERVICE_OFF = 1;
    public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
    public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
    public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
    public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
    public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    static int _gHostProcessId = -1;
    static TraeAudioManager _ginstance = null;
    static ReentrantLock _glock = new ReentrantLock();
    static final String[] forceName = new String[]{"FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK"};
    boolean IsBluetoothA2dpExisted = true;
    int _activeMode = 0;
    AudioManager _am = null;
    TraeAudioSessionHost _audioSessionHost = null;
    d _bluetoothCheck = null;
    Context _context = null;
    e _deviceConfigManager = null;
    ReentrantLock _lock = new ReentrantLock();
    int _modePolicy = -1;
    int _prevMode = 0;
    int _streamType = 0;
    k _switchThread = null;
    f mTraeAudioManagerLooper = null;
    String sessionConnectedDev = DEVICE_NONE;

    @TargetApi(11)
    class a extends d implements ServiceListener {
        Context a = null;
        e b = null;
        BluetoothAdapter c = null;
        BluetoothProfile d = null;
        final /* synthetic */ TraeAudioManager e;
        private final ReentrantLock f = new ReentrantLock();

        a(TraeAudioManager traeAudioManager) {
            this.e = traeAudioManager;
            super(traeAudioManager);
        }

        @TargetApi(11)
        public boolean a(Context context, e eVar) {
            AudioDeviceInterface.LogTraceEntry("");
            if (context != null && eVar != null) {
                this.a = context;
                this.b = eVar;
                this.c = BluetoothAdapter.getDefaultAdapter();
                if (this.c != null) {
                    this.f.lock();
                    try {
                        if (this.c.isEnabled() && this.d == null && !this.c.getProfileProxy(this.a, this, 1)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
                            }
                            this.f.unlock();
                            return false;
                        }
                        this.f.unlock();
                        AudioDeviceInterface.LogTraceExit();
                        return true;
                    } catch (Throwable th) {
                        this.f.unlock();
                    }
                } else if (!QLog.isColorLevel()) {
                    return false;
                } else {
                    QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
                    return false;
                }
            } else if (!QLog.isColorLevel()) {
                return false;
            } else {
                QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
                return false;
            }
        }

        public void a() {
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.d);
            this.f.lock();
            try {
                if (this.c != null) {
                    if (this.d != null) {
                        this.c.closeProfileProxy(1, this.d);
                    }
                    this.d = null;
                }
                this.f.unlock();
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " closeProfileProxy:e:" + e.getMessage());
                }
                this.f.unlock();
            } catch (Throwable th) {
                this.f.unlock();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        public boolean b() {
            boolean z = false;
            this.f.lock();
            try {
                if (this.d != null) {
                    List connectedDevices = this.d.getConnectedDevices();
                    if (connectedDevices == null) {
                        return z;
                    }
                    if (connectedDevices.size() > 0) {
                        z = true;
                    }
                }
                this.f.unlock();
                return z;
            } finally {
                this.f.unlock();
            }
        }

        @TargetApi(11)
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + i + " proxy:" + bluetoothProfile);
            if (i == 1) {
                this.f.lock();
                try {
                    List connectedDevices;
                    if (!(this.d == null || this.d == bluetoothProfile)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + bluetoothProfile + " _profile:" + this.d);
                        }
                        this.c.closeProfileProxy(1, this.d);
                        this.d = null;
                    }
                    this.d = bluetoothProfile;
                    if (this.d != null) {
                        connectedDevices = this.d.getConnectedDevices();
                    } else {
                        connectedDevices = null;
                    }
                    if (!(connectedDevices == null || this.d == null)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + connectedDevices.size() + " _profile:" + this.d);
                        }
                        for (int i2 = 0; i2 < connectedDevices.size(); i2++) {
                            int connectionState;
                            BluetoothDevice bluetoothDevice = (BluetoothDevice) connectedDevices.get(i2);
                            try {
                                if (this.d != null) {
                                    connectionState = this.d.getConnectionState(bluetoothDevice);
                                    if (connectionState == 2) {
                                        this.b.b(bluetoothDevice.getName());
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, "   " + i2 + " " + bluetoothDevice.getName() + " ConnectionState:" + connectionState);
                                    }
                                }
                            } catch (Exception e) {
                            }
                            connectionState = 0;
                            if (connectionState == 2) {
                                this.b.b(bluetoothDevice.getName());
                            }
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, "   " + i2 + " " + bluetoothDevice.getName() + " ConnectionState:" + connectionState);
                            }
                        }
                    }
                    this.f.unlock();
                    if (this.b != null) {
                        CharSequence d;
                        if (this.e._deviceConfigManager != null) {
                            d = this.e._deviceConfigManager.d();
                        } else {
                            d = null;
                        }
                        if (TextUtils.isEmpty(d)) {
                            this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                        } else if (b()) {
                            this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                            this.e.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                        } else {
                            this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                        }
                    }
                } catch (Throwable th) {
                    this.f.unlock();
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }

        @TargetApi(11)
        public void onServiceDisconnected(int i) {
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + i);
            if (i == 1) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
                }
                if (b()) {
                    this.e.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
                this.f.lock();
                try {
                    if (this.d != null) {
                        this.c.closeProfileProxy(1, this.d);
                        this.d = null;
                    }
                    this.f.unlock();
                } catch (Throwable th) {
                    this.f.unlock();
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }

        void a(IntentFilter intentFilter) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " " + c() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        }

        void a(Context context, Intent intent) {
            int intExtra;
            int intExtra2;
            BluetoothDevice bluetoothDevice;
            if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(intExtra2));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "    EXTRA_DEVICE " + bluetoothDevice + " " + (bluetoothDevice != null ? bluetoothDevice.getName() : " "));
                }
                if (intExtra == 2) {
                    String name;
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "   dev:" + bluetoothDevice.getName() + " connected,start sco...");
                    }
                    this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    e eVar = this.b;
                    if (bluetoothDevice != null) {
                        name = bluetoothDevice.getName();
                    } else {
                        name = "unkown";
                    }
                    eVar.b(name);
                } else if (intExtra == 0) {
                    this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            } else if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + bluetoothDevice);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + b(intExtra2));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(intExtra));
                }
            } else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                switch (defaultAdapter.getProfileConnectionState(2)) {
                    case 0:
                        QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
                        this.e.IsBluetoothA2dpExisted = false;
                        return;
                    case 2:
                        QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
                        this.e.IsBluetoothA2dpExisted = true;
                        return;
                    default:
                        QLog.w("TRAE", 2, "BluetoothA2dp" + defaultAdapter.getProfileConnectionState(2));
                        return;
                }
            }
        }

        public String c() {
            return "BluetoohHeadsetCheck";
        }
    }

    class b extends d {
        final /* synthetic */ TraeAudioManager a;

        b(TraeAudioManager traeAudioManager) {
            this.a = traeAudioManager;
            super(traeAudioManager);
        }

        public boolean a(Context context, e eVar) {
            return true;
        }

        public void a() {
        }

        public boolean b() {
            return false;
        }

        void a(IntentFilter intentFilter) {
        }

        void a(Context context, Intent intent) {
        }

        public String c() {
            return "BluetoohHeadsetCheckFake";
        }
    }

    class c extends d {
        Class<?> a = null;
        Class<?> b = null;
        Object c = null;
        Method d = null;
        Context e = null;
        e f = null;
        final /* synthetic */ TraeAudioManager g;

        c(TraeAudioManager traeAudioManager) {
            this.g = traeAudioManager;
            super(traeAudioManager);
        }

        public boolean a(Context context, e eVar) {
            AudioDeviceInterface.LogTraceEntry("");
            this.e = context;
            this.f = eVar;
            if (this.e == null || this.f == null) {
                return false;
            }
            try {
                this.a = Class.forName("android.bluetooth.BluetoothHeadset");
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
                }
            }
            if (this.a == null) {
                return false;
            }
            try {
                this.b = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + e2);
                }
            }
            try {
                this.d = this.a.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            } catch (NoSuchMethodException e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
                }
            }
            if (this.d == null) {
                return false;
            }
            try {
                this.c = this.a.getConstructor(new Class[]{Context.class, this.b}).newInstance(new Object[]{context, null});
            } catch (IllegalArgumentException e4) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                }
            } catch (InstantiationException e5) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                }
            } catch (IllegalAccessException e6) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                }
            } catch (InvocationTargetException e7) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                }
            } catch (NoSuchMethodException e8) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                }
            }
            if (this.c == null) {
                return false;
            }
            this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, b());
            if (b()) {
                this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                this.g.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
            } else {
                this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
            }
            AudioDeviceInterface.LogTraceExit();
            return true;
        }

        public void a() {
            AudioDeviceInterface.LogTraceEntry("");
            if (this.c != null) {
                Method declaredMethod;
                try {
                    declaredMethod = this.a.getDeclaredMethod("close", new Class[0]);
                } catch (NoSuchMethodException e) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
                    }
                    declaredMethod = null;
                }
                if (declaredMethod != null) {
                    try {
                        declaredMethod.invoke(this.c, new Object[0]);
                    } catch (IllegalArgumentException e2) {
                    } catch (IllegalAccessException e3) {
                    } catch (InvocationTargetException e4) {
                    }
                    this.a = null;
                    this.b = null;
                    this.c = null;
                    this.d = null;
                    AudioDeviceInterface.LogTraceExit();
                }
            }
        }

        public boolean b() {
            Object obj = null;
            if (this.d == null || this.d == null) {
                return false;
            }
            try {
                obj = this.d.invoke(this.c, new Object[0]);
            } catch (IllegalArgumentException e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
                }
            } catch (IllegalAccessException e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
                }
            } catch (InvocationTargetException e3) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset res:" + (obj != null ? " Y" : "N"));
            }
            if (obj != null) {
                return true;
            }
            return false;
        }

        void a(IntentFilter intentFilter) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " " + c() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
        }

        void a(Context context, Intent intent) {
            int intExtra;
            int intExtra2;
            int intExtra3;
            if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
                intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE " + intExtra);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE " + intExtra2);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE " + intExtra3);
                }
                if (intExtra3 == 2) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                } else if (intExtra3 == 0) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            } else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(intent.getAction())) {
                intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE " + intExtra);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE " + intExtra2);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE " + intExtra3);
                }
                if (intExtra3 == 2) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                } else if (intExtra3 == 0) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            }
        }

        public String c() {
            return "BluetoohHeadsetCheckFor2x";
        }
    }

    class e {
        HashMap<String, a> a = new HashMap();
        String b = TraeAudioManager.DEVICE_NONE;
        String c = TraeAudioManager.DEVICE_NONE;
        String d = TraeAudioManager.DEVICE_NONE;
        ReentrantLock e = new ReentrantLock();
        boolean f = false;
        String g = "unknow";
        final /* synthetic */ TraeAudioManager h;

        public e(TraeAudioManager traeAudioManager) {
            this.h = traeAudioManager;
        }

        public boolean a(String str) {
            AudioDeviceInterface.LogTraceEntry(" strConfigs:" + str);
            if (str == null || str.length() <= 0) {
                return false;
            }
            String replace = str.replace("\n", "").replace("\r", "");
            if (replace == null || replace.length() <= 0) {
                return false;
            }
            if (replace.indexOf(";") < 0) {
                replace = replace + ";";
            }
            String[] split = replace.split(";");
            if (split == null || 1 > split.length) {
                return false;
            }
            this.e.lock();
            for (int i = 0; i < split.length; i++) {
                a(split[i], i);
            }
            this.e.unlock();
            this.h.printDevices();
            return true;
        }

        boolean a(String str, int i) {
            AudioDeviceInterface.LogTraceEntry(" devName:" + str + " priority:" + i);
            a aVar = new a(this);
            if (aVar.a(str, i)) {
                if (!this.a.containsKey(str)) {
                    this.a.put(str, aVar);
                    this.f = true;
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, " n" + e() + " 0:" + a(0));
                    }
                    AudioDeviceInterface.LogTraceExit();
                    return true;
                } else if (!QLog.isColorLevel()) {
                    return false;
                } else {
                    QLog.e("TRAE", 2, "err dev exist!");
                    return false;
                }
            } else if (!QLog.isColorLevel()) {
                return false;
            } else {
                QLog.e("TRAE", 2, " err dev init!");
                return false;
            }
        }

        public void a() {
            this.e.lock();
            this.a.clear();
            this.b = TraeAudioManager.DEVICE_NONE;
            this.c = TraeAudioManager.DEVICE_NONE;
            this.d = TraeAudioManager.DEVICE_NONE;
            this.e.unlock();
        }

        public boolean b() {
            this.e.lock();
            boolean z = this.f;
            this.e.unlock();
            return z;
        }

        public void c() {
            this.e.lock();
            this.f = false;
            this.e.unlock();
        }

        public boolean a(String str, boolean z) {
            boolean z2;
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar == null || aVar.b() == z) {
                z2 = false;
            } else {
                aVar.a(z);
                this.f = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " ++setVisible:" + str + (z ? " Y" : " N"));
                }
                z2 = true;
            }
            this.e.unlock();
            return z2;
        }

        public void b(String str) {
            if (str == null) {
                this.g = "unknow";
            } else if (str.isEmpty()) {
                this.g = "unknow";
            } else {
                this.g = str;
            }
        }

        public String d() {
            return this.g;
        }

        public boolean c(String str) {
            boolean b;
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar != null) {
                b = aVar.b();
            } else {
                b = false;
            }
            this.e.unlock();
            return b;
        }

        public int d(String str) {
            int c;
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar != null) {
                c = aVar.c();
            } else {
                c = -1;
            }
            this.e.unlock();
            return c;
        }

        public int e() {
            this.e.lock();
            int size = this.a.size();
            this.e.unlock();
            return size;
        }

        public String a(int i) {
            a aVar;
            String a;
            String str = TraeAudioManager.DEVICE_NONE;
            this.e.lock();
            int i2 = 0;
            for (Entry entry : this.a.entrySet()) {
                if (i2 == i) {
                    aVar = (a) entry.getValue();
                    break;
                }
                i2++;
            }
            aVar = null;
            if (aVar != null) {
                a = aVar.a();
            } else {
                a = str;
            }
            this.e.unlock();
            return a;
        }

        public String e(String str) {
            this.e.lock();
            a aVar = null;
            for (Entry entry : this.a.entrySet()) {
                entry.getKey();
                entry.getValue();
                a aVar2 = (a) entry.getValue();
                if (!(aVar2 == null || !aVar2.b() || aVar2.a().equals(str))) {
                    if (aVar == null) {
                        aVar = aVar2;
                    } else {
                        if (aVar2.c() < aVar.c()) {
                            aVar2 = aVar;
                        }
                        aVar = aVar2;
                    }
                }
            }
            this.e.unlock();
            return aVar != null ? aVar.a() : TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public String f() {
            this.e.lock();
            a aVar = null;
            for (Entry entry : this.a.entrySet()) {
                entry.getKey();
                entry.getValue();
                a aVar2 = (a) entry.getValue();
                if (aVar2 != null && aVar2.b()) {
                    if (aVar == null) {
                        aVar = aVar2;
                    } else {
                        if (aVar2.c() < aVar.c()) {
                            aVar2 = aVar;
                        }
                        aVar = aVar2;
                    }
                }
            }
            this.e.unlock();
            return aVar != null ? aVar.a() : TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public String g() {
            String str;
            this.e.lock();
            a aVar = (a) this.a.get(this.d);
            if (aVar == null || !aVar.b()) {
                str = null;
            } else {
                str = this.d;
            }
            this.e.unlock();
            return str;
        }

        public String h() {
            this.e.lock();
            String m = m();
            this.e.unlock();
            return m;
        }

        public String i() {
            this.e.lock();
            String n = n();
            this.e.unlock();
            return n;
        }

        public boolean f(String str) {
            boolean z;
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar == null || !aVar.b()) {
                z = false;
            } else {
                this.d = str;
                z = true;
            }
            this.e.unlock();
            return z;
        }

        public boolean g(String str) {
            boolean z;
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar == null || !aVar.b()) {
                z = false;
            } else {
                if (!(this.c == null || this.c.equals(str))) {
                    this.b = this.c;
                }
                this.c = str;
                this.d = "";
                z = true;
            }
            this.e.unlock();
            return z;
        }

        public HashMap<String, Object> j() {
            HashMap<String, Object> hashMap = new HashMap();
            this.e.lock();
            hashMap.put(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, l());
            hashMap.put(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, m());
            hashMap.put(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, n());
            this.e.unlock();
            return hashMap;
        }

        public ArrayList<String> k() {
            ArrayList arrayList = new ArrayList();
            this.e.lock();
            ArrayList<String> l = l();
            this.e.unlock();
            return l;
        }

        ArrayList<String> l() {
            ArrayList<String> arrayList = new ArrayList();
            for (Entry value : this.a.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar != null && aVar.b()) {
                    arrayList.add(aVar.a());
                }
            }
            return arrayList;
        }

        String m() {
            String str = TraeAudioManager.DEVICE_NONE;
            a aVar = (a) this.a.get(this.c);
            if (aVar == null || !aVar.b()) {
                return str;
            }
            return this.c;
        }

        String n() {
            String str = TraeAudioManager.DEVICE_NONE;
            a aVar = (a) this.a.get(this.b);
            if (aVar == null || !aVar.b()) {
                return str;
            }
            return this.b;
        }
    }

    public static boolean checkDevName(String str) {
        if (str == null) {
            return false;
        }
        if (DEVICE_SPEAKERPHONE.equals(str) || DEVICE_EARPHONE.equals(str) || DEVICE_WIREDHEADSET.equals(str) || DEVICE_BLUETOOTHHEADSET.equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isHandfree(String str) {
        if (checkDevName(str) && DEVICE_SPEAKERPHONE.equals(str)) {
            return true;
        }
        return false;
    }

    void printDevices() {
        int i = 0;
        AudioDeviceInterface.LogTraceEntry("");
        int e = this._deviceConfigManager.e();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectedDevice:" + this._deviceConfigManager.h());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectingDevice:" + this._deviceConfigManager.g());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   prevConnectedDevice:" + this._deviceConfigManager.i());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AHPDevice:" + this._deviceConfigManager.f());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   deviceNamber:" + e);
        }
        for (int i2 = 0; i2 < e; i2++) {
            String a = this._deviceConfigManager.a(i2);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i2 + " devName:" + a + " Visible:" + this._deviceConfigManager.c(a) + " Priority:" + this._deviceConfigManager.d(a));
            }
        }
        String[] strArr = (String[]) this._deviceConfigManager.k().toArray(new String[0]);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AvailableNamber:" + strArr.length);
        }
        while (i < strArr.length) {
            String str = strArr[i];
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i + " devName:" + str + " Visible:" + this._deviceConfigManager.c(str) + " Priority:" + this._deviceConfigManager.d(str));
            }
            i++;
        }
        AudioDeviceInterface.LogTraceExit();
    }

    static boolean isCloseSystemAPM(int i) {
        if (i != -1) {
            return false;
        }
        if (Build.MANUFACTURER.equals("Xiaomi")) {
            if (Build.MODEL.equals("MI 2")) {
                return true;
            }
            if (Build.MODEL.equals("MI 2A")) {
                return true;
            }
            if (Build.MODEL.equals("MI 2S")) {
                return true;
            }
            if (Build.MODEL.equals("MI 2SC")) {
                return true;
            }
            return false;
        } else if (Build.MANUFACTURER.equals("samsung") && Build.MODEL.equals("SCH-I959")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean IsEabiLowVersionByAbi(String str) {
        if (str == null) {
            return true;
        }
        if (str.contains("x86")) {
            return false;
        }
        if (str.contains("mips")) {
            return false;
        }
        if (str.equalsIgnoreCase("armeabi") || !str.equalsIgnoreCase("armeabi-v7a")) {
            return true;
        }
        return false;
    }

    static boolean IsEabiLowVersion() {
        String str = Build.CPU_ABI;
        String str2 = "unknown";
        if (VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("CPU_ABI2").get(null);
            } catch (Exception e) {
                if (IsEabiLowVersionByAbi(str)) {
                    return true;
                }
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str + " CPU_ABI2:" + str2);
        }
        if (IsEabiLowVersionByAbi(str) && IsEabiLowVersionByAbi(str2)) {
            return true;
        }
        return false;
    }

    static int getAudioSource(int i) {
        int i2 = 0;
        if (IsMusicScene) {
            return 0;
        }
        if (!IsEabiLowVersion()) {
            int i3 = VERSION.SDK_INT;
            if (i >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i + " source:" + i);
                }
                return i;
            }
            if (i3 >= 11) {
                i2 = 7;
            }
            if (!QLog.isColorLevel()) {
                return i2;
            }
            QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i + " source:" + i2);
            return i2;
        } else if (!QLog.isColorLevel()) {
            return 0;
        } else {
            QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + i + " source:0");
            return 0;
        }
    }

    static int getAudioStreamType(int i) {
        int i2 = 3;
        if (!IsMusicScene) {
            if (!IsEabiLowVersion()) {
                int i3 = VERSION.SDK_INT;
                if (i >= 0) {
                    i2 = i;
                } else if (i3 >= 9) {
                    i2 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + i + " streamType:" + i2);
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + i + " streamType:3");
            }
        }
        return i2;
    }

    static int getCallAudioMode(int i) {
        int i2 = 0;
        if (IsMusicScene) {
            return 0;
        }
        if (!IsEabiLowVersion()) {
            int i3 = VERSION.SDK_INT;
            if (i >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + i + " mode:" + i);
                }
                return i;
            }
            if (i3 >= 11) {
                i2 = 3;
            }
            if (!QLog.isColorLevel()) {
                return i2;
            }
            QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + i + " mode:" + i2 + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
            return i2;
        } else if (!QLog.isColorLevel()) {
            return 0;
        } else {
            QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + i + " mode:0");
            return 0;
        }
    }

    void updateDeviceStatus() {
        int e = this._deviceConfigManager.e();
        for (int i = 0; i < e; i++) {
            boolean a;
            String a2 = this._deviceConfigManager.a(i);
            if (a2 != null) {
                if (a2.equals(DEVICE_BLUETOOTHHEADSET)) {
                    if (this._bluetoothCheck == null) {
                        a = this._deviceConfigManager.a(a2, false);
                    } else {
                        a = this._deviceConfigManager.a(a2, this._bluetoothCheck.b());
                    }
                } else if (a2.equals(DEVICE_WIREDHEADSET)) {
                    a = this._deviceConfigManager.a(a2, this._am.isWiredHeadsetOn());
                } else if (a2.equals(DEVICE_SPEAKERPHONE)) {
                    this._deviceConfigManager.a(a2, true);
                }
                if (a && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "pollUpdateDevice dev:" + a2 + " Visible:" + this._deviceConfigManager.c(a2));
                }
            }
            a = false;
            QLog.w("TRAE", 2, "pollUpdateDevice dev:" + a2 + " Visible:" + this._deviceConfigManager.c(a2));
        }
        checkAutoDeviceListUpdate();
    }

    void _updateEarphoneVisable() {
        if (this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
            }
            this._deviceConfigManager.a(DEVICE_EARPHONE, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
        }
        this._deviceConfigManager.a(DEVICE_EARPHONE, true);
    }

    void checkAutoDeviceListUpdate() {
        if (this._deviceConfigManager.b()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.c();
            internalSendMessage(32785, new HashMap());
        }
    }

    void checkDevicePlug(String str, boolean z) {
        if (this._deviceConfigManager.b()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkDevicePlug got update dev:" + str + (z ? " piugin" : " plugout") + " connectedDev:" + this._deviceConfigManager.h());
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.c();
            HashMap hashMap;
            if (z) {
                hashMap = new HashMap();
                hashMap.put(PARAM_DEVICE, str);
                internalSendMessage(32786, hashMap);
                return;
            }
            String h = this._deviceConfigManager.h();
            if (h.equals(str) || h.equals(DEVICE_NONE)) {
                hashMap = new HashMap();
                hashMap.put(PARAM_DEVICE, str);
                internalSendMessage(32787, hashMap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ---No switch,plugout:" + str + " connectedDev:" + h);
            }
            internalSendMessage(32785, new HashMap());
        }
    }

    public static int SetSpeakerForTest(Context context, boolean z) {
        int i = -1;
        _glock.lock();
        if (_ginstance != null) {
            i = _ginstance.InternalSetSpeaker(context, z);
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
        }
        _glock.unlock();
        return i;
    }

    int InternalSetSpeaker(Context context, boolean z) {
        if (context != null) {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager != null) {
                if (QLog.isColorLevel()) {
                    String str;
                    String str2 = "TRAE";
                    StringBuilder append = new StringBuilder("InternalSetSpeaker entry:speaker:").append(audioManager.isSpeakerphoneOn() ? "Y" : "N").append("-->:");
                    if (z) {
                        str = "Y";
                    } else {
                        str = "N";
                    }
                    QLog.w(str2, 2, append.append(str).toString());
                }
                if (isCloseSystemAPM(this._modePolicy) && this._activeMode != 2) {
                    return InternalSetSpeakerSpe(audioManager, z);
                }
                if (audioManager.isSpeakerphoneOn() != z) {
                    audioManager.setSpeakerphoneOn(z);
                }
                int i = audioManager.isSpeakerphoneOn() == z ? 0 : -1;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + z + " res:" + i + " mode:" + audioManager.getMode());
                }
                return i;
            } else if (!QLog.isColorLevel()) {
                return -1;
            } else {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
                return -1;
            }
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
            return -1;
        }
    }

    int InternalSetSpeakerSpe(AudioManager audioManager, boolean z) {
        int i = 0;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
        }
        if (z) {
            InternalSetMode(0);
            audioManager.setSpeakerphoneOn(true);
            setForceUse(1, 1);
        } else {
            InternalSetMode(3);
            audioManager.setSpeakerphoneOn(false);
            setForceUse(1, 0);
        }
        if (audioManager.isSpeakerphoneOn() != z) {
            i = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + z + " res:" + i + " mode:" + audioManager.getMode());
        }
        return i;
    }

    void InternalSetMode(int i) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "SetMode entry:" + i);
        }
        if (this._am != null) {
            this._am.setMode(i);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "setMode:" + i + (this._am.getMode() != i ? "fail" : "success"));
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setMode:" + i + " fail am=null");
        }
    }

    public static int registerAudioSession(boolean z, long j, Context context) {
        int i = -1;
        _glock.lock();
        if (_ginstance != null) {
            if (z) {
                _ginstance._audioSessionHost.add(j, context);
            } else {
                _ginstance._audioSessionHost.remove(j);
            }
            i = 0;
        }
        _glock.unlock();
        return i;
    }

    public static int sendMessage(int i, HashMap<String, Object> hashMap) {
        int i2 = -1;
        _glock.lock();
        if (_ginstance != null) {
            i2 = _ginstance.internalSendMessage(i, hashMap);
        }
        _glock.unlock();
        return i2;
    }

    public static int init(Context context) {
        TXCLog.w("TRAE", "TraeAudioManager init _ginstance:" + _ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance == null) {
            _ginstance = new TraeAudioManager(context);
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public static void uninit() {
        TXCLog.w("TRAE", "TraeAudioManager uninit _ginstance:" + _ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance != null) {
            _ginstance.release();
            _ginstance = null;
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
    }

    TraeAudioManager(Context context) {
        AudioDeviceInterface.LogTraceEntry(" context:" + context);
        if (context != null) {
            this._context = context;
            this.mTraeAudioManagerLooper = new f(this, this);
            AudioDeviceInterface.LogTraceExit();
        }
    }

    public void release() {
        AudioDeviceInterface.LogTraceEntry("");
        if (this.mTraeAudioManagerLooper != null) {
            this.mTraeAudioManagerLooper.a();
            this.mTraeAudioManagerLooper = null;
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            try {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra(PARAM_OPERATION);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + intent.getAction());
                }
                if (this._deviceConfigManager != null) {
                    boolean c = this._deviceConfigManager.c(DEVICE_WIREDHEADSET);
                    boolean c2 = this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET);
                    if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                        onHeadsetPlug(context, intent);
                        if (!c && this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
                            checkDevicePlug(DEVICE_WIREDHEADSET, true);
                        }
                        if (c && !this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
                            checkDevicePlug(DEVICE_WIREDHEADSET, false);
                        }
                    } else if (!"android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                        if (ACTION_TRAEAUDIOMANAGER_REQUEST.equals(action)) {
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, "   OPERATION:" + stringExtra);
                            }
                            if (OPERATION_REGISTERAUDIOSESSION.equals(stringExtra)) {
                                registerAudioSession(intent.getBooleanExtra(REGISTERAUDIOSESSION_ISREGISTER, false), intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), context);
                            } else if (OPERATION_STARTSERVICE.equals(stringExtra)) {
                                startService(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getStringExtra(EXTRA_DATA_DEVICECONFIG));
                            } else if (OPERATION_STOPSERVICE.equals(stringExtra)) {
                                stopService(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETDEVICELIST.equals(stringExtra)) {
                                getDeviceList(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                                getStreamType(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                                connectDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getStringExtra(CONNECTDEVICE_DEVICENAME));
                            } else if (OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE.equals(stringExtra)) {
                                connectHighestPriorityDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_EARACTION.equals(stringExtra)) {
                                earAction(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(EXTRA_EARACTION, -1));
                            } else if (OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                                isDeviceChangabled(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                                getConnectedDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                                getConnectingDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                                voicecallPreprocess(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_MODEPOLICY, -1), intent.getIntExtra(PARAM_STREAMTYPE, -1));
                            } else if (OPERATION_VOICECALL_POSTPROCESS.equals(stringExtra)) {
                                voicecallPostprocess(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_VOICECALL_AUDIOPARAM_CHANGED.equals(stringExtra)) {
                                voiceCallAudioParamChanged(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_MODEPOLICY, -1), intent.getIntExtra(PARAM_STREAMTYPE, -1));
                            } else if (OPERATION_STARTRING.equals(stringExtra)) {
                                int intExtra = intent.getIntExtra(PARAM_RING_DATASOURCE, -1);
                                int intExtra2 = intent.getIntExtra(PARAM_RING_RSID, -1);
                                Uri uri = (Uri) intent.getParcelableExtra(PARAM_RING_URI);
                                String stringExtra2 = intent.getStringExtra(PARAM_RING_FILEPATH);
                                boolean booleanExtra = intent.getBooleanExtra(PARAM_RING_LOOP, false);
                                String stringExtra3 = intent.getStringExtra(PARAM_RING_USERDATA_STRING);
                                startRing(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intExtra, intExtra2, uri, stringExtra2, booleanExtra, intent.getIntExtra(PARAM_RING_LOOPCOUNT, 1), stringExtra3, intent.getBooleanExtra(PARAM_RING_MODE, false));
                            } else if (OPERATION_STOPRING.equals(stringExtra)) {
                                stopRing(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            }
                        } else if (this._deviceConfigManager != null) {
                            if (this._bluetoothCheck != null) {
                                this._bluetoothCheck.a(context, intent, this._deviceConfigManager);
                            }
                            if (!c2 && this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET)) {
                                checkDevicePlug(DEVICE_BLUETOOTHHEADSET, true);
                            }
                            if (c2 && !this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET)) {
                                checkDevicePlug(DEVICE_BLUETOOTHHEADSET, false);
                            }
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "_deviceConfigManager null!");
                }
            } catch (Exception e) {
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "onReceive intent or context is null!");
        }
    }

    void onHeadsetPlug(Context context, Intent intent) {
        String str = "";
        String stringExtra = intent.getStringExtra("name");
        if (stringExtra == null) {
            stringExtra = "unkonw";
        }
        stringExtra = str + " [" + stringExtra + "] ";
        int intExtra = intent.getIntExtra("state", -1);
        if (intExtra != -1) {
            stringExtra = stringExtra + (intExtra == 0 ? "unplugged" : "plugged");
        }
        stringExtra = stringExtra + " mic:";
        int intExtra2 = intent.getIntExtra("microphone", -1);
        if (intExtra2 != -1) {
            stringExtra = stringExtra + (intExtra2 == 1 ? "Y" : "unkown");
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug:: " + stringExtra);
        }
        this._deviceConfigManager.a(DEVICE_WIREDHEADSET, 1 == intExtra);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug exit");
        }
    }

    int internalSendMessage(int i, HashMap<String, Object> hashMap) {
        if (this.mTraeAudioManagerLooper != null) {
            return this.mTraeAudioManagerLooper.a(i, hashMap);
        }
        return -1;
    }

    static int getDeviceList(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32774, hashMap);
    }

    static int getStreamType(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32784, hashMap);
    }

    static int startService(String str, long j, boolean z, String str2) {
        if (str2.length() <= 0) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(EXTRA_DATA_DEVICECONFIG, str2);
        return sendMessage(32772, hashMap);
    }

    static int stopService(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32773, hashMap);
    }

    static int connectDevice(String str, long j, boolean z, String str2) {
        if (str2 == null) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(CONNECTDEVICE_DEVICENAME, str2);
        hashMap.put(PARAM_DEVICE, str2);
        return sendMessage(32775, hashMap);
    }

    static int connectHighestPriorityDevice(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32789, hashMap);
    }

    static int earAction(String str, long j, boolean z, int i) {
        if (i != 0 && i != 1) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(EXTRA_EARACTION, Integer.valueOf(i));
        return sendMessage(32776, hashMap);
    }

    static int isDeviceChangabled(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32777, hashMap);
    }

    static int getConnectedDevice(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32778, hashMap);
    }

    static int getConnectingDevice(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32779, hashMap);
    }

    static int voicecallPreprocess(String str, long j, boolean z, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i2));
        return sendMessage(32780, hashMap);
    }

    static int voicecallPostprocess(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32781, hashMap);
    }

    static int voiceCallAudioParamChanged(String str, long j, boolean z, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i2));
        return sendMessage(32788, hashMap);
    }

    static int startRing(String str, long j, boolean z, int i, int i2, Uri uri, String str2, boolean z2, int i3, String str3, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_RING_DATASOURCE, Integer.valueOf(i));
        hashMap.put(PARAM_RING_RSID, Integer.valueOf(i2));
        hashMap.put(PARAM_RING_URI, uri);
        hashMap.put(PARAM_RING_FILEPATH, str2);
        hashMap.put(PARAM_RING_LOOP, Boolean.valueOf(z2));
        hashMap.put(PARAM_RING_LOOPCOUNT, Integer.valueOf(i3));
        hashMap.put(PARAM_RING_MODE, Boolean.valueOf(z3));
        hashMap.put(PARAM_RING_USERDATA_STRING, str3);
        return sendMessage(32782, hashMap);
    }

    static int stopRing(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32783, hashMap);
    }

    static int requestReleaseAudioFocus(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32790, hashMap);
    }

    static int recoverAudioFocus(String str, long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32791, hashMap);
    }

    int InternalSessionConnectDevice(HashMap<String, Object> hashMap) {
        AudioDeviceInterface.LogTraceEntry("");
        if (hashMap == null || this._context == null) {
            return -1;
        }
        if (IsMusicScene) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "MusicScene: InternalSessionConnectDevice failed");
            }
            return -1;
        }
        int i;
        String str = (String) hashMap.get(PARAM_DEVICE);
        TXCLog.w("TRAE", "ConnectDevice: " + str);
        boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
        if (!checkDevName(str)) {
            i = 7;
        } else if (!this._deviceConfigManager.c(str)) {
            i = 8;
        } else if (InternalIsDeviceChangeable) {
            i = 0;
        } else {
            i = 9;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "sessonID:" + ((Long) hashMap.get(PARAM_SESSIONID)) + " devName:" + str + " bChangabled:" + (InternalIsDeviceChangeable ? "Y" : "N") + " err:" + i);
        }
        Intent intent;
        if (i != 0) {
            intent = new Intent();
            intent.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
            sendResBroadcast(intent, hashMap, i);
            return -1;
        } else if (str.equals(this._deviceConfigManager.h())) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " --has connected!");
            }
            intent = new Intent();
            intent.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
            sendResBroadcast(intent, hashMap, i);
            return 0;
        } else {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " --connecting...");
            }
            InternalConnectDevice(str, hashMap, false);
            AudioDeviceInterface.LogTraceExit();
            return 0;
        }
    }

    int InternalSessionEarAction(HashMap<String, Object> hashMap) {
        return 0;
    }

    int InternalConnectDevice(String str, HashMap<String, Object> hashMap, boolean z) {
        AudioDeviceInterface.LogTraceEntry(" devName:" + str);
        if (str == null) {
            return -1;
        }
        if (IsMusicScene && str.equals(DEVICE_EARPHONE)) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, "MusicScene, Connect device:" + str + " failed");
            return -1;
        } else if (!z && !this._deviceConfigManager.h().equals(DEVICE_NONE) && str.equals(this._deviceConfigManager.h())) {
            return 0;
        } else {
            if (checkDevName(str) && this._deviceConfigManager.c(str)) {
                if (InternalIsDeviceChangeable()) {
                    if (this._switchThread != null) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "_switchThread:" + this._switchThread.b());
                        }
                        this._switchThread.f();
                        this._switchThread = null;
                    }
                    if (str.equals(DEVICE_EARPHONE)) {
                        this._switchThread = new h(this);
                    } else if (str.equals(DEVICE_SPEAKERPHONE)) {
                        this._switchThread = new j(this);
                    } else if (str.equals(DEVICE_WIREDHEADSET)) {
                        this._switchThread = new i(this);
                    } else if (str.equals(DEVICE_BLUETOOTHHEADSET)) {
                        this._switchThread = new g(this);
                    }
                    if (this._switchThread != null) {
                        this._switchThread.a(hashMap);
                        this._switchThread.start();
                    }
                    AudioDeviceInterface.LogTraceExit();
                    return 0;
                } else if (!QLog.isColorLevel()) {
                    return -1;
                } else {
                    QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
                    return -1;
                }
            } else if (!QLog.isColorLevel()) {
                return -1;
            } else {
                QLog.e("TRAE", 2, " checkDevName fail");
                return -1;
            }
        }
    }

    int InternalSessionIsDeviceChangabled(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra(ISDEVICECHANGABLED_RESULT_ISCHANGABLED, InternalIsDeviceChangeable());
        sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    boolean InternalIsDeviceChangeable() {
        String g = this._deviceConfigManager.g();
        if (g == null || g.equals(DEVICE_NONE) || g.equals("")) {
            return true;
        }
        return false;
    }

    int InternalSessionGetConnectedDevice(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTEDDEVICE_RESULT_LIST, this._deviceConfigManager.h());
        sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    int InternalSessionGetConnectingDevice(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTINGDEVICE_RESULT_LIST, this._deviceConfigManager.g());
        sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    int sendResBroadcast(Intent intent, HashMap<String, Object> hashMap, int i) {
        if (this._context == null) {
            return -1;
        }
        Long l = (Long) hashMap.get(PARAM_SESSIONID);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " sessonID:" + l + " " + ((String) hashMap.get(PARAM_OPERATION)));
        }
        if (l == null || l.longValue() == Long.MIN_VALUE) {
            InternalNotifyDeviceListUpdate();
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "sendResBroadcast sid null,don't send res");
            }
            return -1;
        }
        final Long l2 = (Long) hashMap.get(PARAM_SESSIONID);
        final String str = (String) hashMap.get(PARAM_OPERATION);
        final Intent intent2 = intent;
        final int i2 = i;
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ TraeAudioManager e;

            public void run() {
                intent2.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
                intent2.putExtra(TraeAudioManager.PARAM_SESSIONID, l2);
                intent2.putExtra(TraeAudioManager.PARAM_OPERATION, str);
                intent2.putExtra(TraeAudioManager.PARAM_RES_ERRCODE, i2);
                if (this.e._context != null) {
                    this.e._context.sendBroadcast(intent2);
                }
            }
        });
        return 0;
    }

    int InternalNotifyDeviceListUpdate() {
        AudioDeviceInterface.LogTraceEntry("");
        if (this._context == null) {
            return -1;
        }
        HashMap j = this._deviceConfigManager.j();
        new Handler(Looper.getMainLooper()).post(new 2(this, (ArrayList) j.get(EXTRA_DATA_AVAILABLEDEVICE_LIST), (String) j.get(EXTRA_DATA_CONNECTEDDEVICE), (String) j.get(EXTRA_DATA_PREV_CONNECTEDDEVICE)));
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    int InternalNotifyDeviceChangableUpdate() {
        if (this._context == null) {
            return -1;
        }
        final boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ TraeAudioManager b;

            public void run() {
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE);
                intent.putExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, InternalIsDeviceChangeable);
                if (this.b._context != null) {
                    this.b._context.sendBroadcast(intent);
                }
            }
        });
        return 0;
    }

    public d CreateBluetoothCheck(Context context, e eVar) {
        d aVar;
        if (VERSION.SDK_INT >= 11) {
            aVar = new a(this);
        } else if (VERSION.SDK_INT != 18) {
            aVar = new c(this);
        } else {
            aVar = new b(this);
        }
        if (!aVar.a(context, eVar)) {
            aVar = new b(this);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "CreateBluetoothCheck:" + aVar.c() + " skip android4.3:" + (VERSION.SDK_INT == 18 ? "Y" : "N"));
        }
        return aVar;
    }

    static String getForceConfigName(int i) {
        if (i < 0 || i >= forceName.length) {
            return "unknow";
        }
        return forceName[i];
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeMethod Exception:" + e.getMessage());
            }
        }
        return obj2;
    }

    public static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class[] clsArr) {
        Object obj = null;
        try {
            obj = Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
        } catch (ClassNotFoundException e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "ClassNotFound:" + str);
            }
        } catch (NoSuchMethodException e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "NoSuchMethod:" + str2);
            }
        } catch (IllegalArgumentException e3) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "IllegalArgument:" + str2);
            }
        } catch (IllegalAccessException e4) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "IllegalAccess:" + str2);
            }
        } catch (InvocationTargetException e5) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InvocationTarget:" + str2);
            }
        } catch (Exception e6) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + e6.getMessage());
            }
        }
        return obj;
    }

    static void setParameters(String str) {
        Object[] objArr = new Object[]{str};
        Class[] clsArr = new Class[]{String.class};
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setParameters  :" + str);
        }
        invokeStaticMethod("android.media.AudioSystem", "setParameters", objArr, clsArr);
    }

    static void setPhoneState(int i) {
        invokeStaticMethod("android.media.AudioSystem", "setPhoneState", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
    }

    static void setForceUse(int i, int i2) {
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "setForceUse", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, new Class[]{Integer.TYPE, Integer.TYPE});
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setForceUse  usage:" + i + " config:" + i2 + " ->" + getForceConfigName(i2) + " res:" + invokeStaticMethod);
        }
    }

    static int getForceUse(int i) {
        Integer num;
        Integer valueOf = Integer.valueOf(0);
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "getForceUse", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        if (invokeStaticMethod != null) {
            num = (Integer) invokeStaticMethod;
        } else {
            num = valueOf;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "getForceUse  usage:" + i + " config:" + num + " ->" + getForceConfigName(num.intValue()));
        }
        return num.intValue();
    }

    static void forceVolumeControlStream(AudioManager audioManager, int i) {
        Object invokeMethod = invokeMethod(audioManager, "forceVolumeControlStream", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + i + " res:" + invokeMethod);
        }
    }
}
