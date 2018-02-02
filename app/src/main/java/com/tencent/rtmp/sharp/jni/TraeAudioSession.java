package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.liteav.basic.log.TXCLog;

public class TraeAudioSession extends BroadcastReceiver {
    static int s_nSessionIdAllocator = 0;
    final String TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    private boolean _canSwtich2Earphone = true;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private a mCallback;
    private Context mContext;
    private boolean mIsHostside = false;
    private long mSessionId = Long.MIN_VALUE;

    public static long requestSessionId() {
        long myPid = ((long) Process.myPid()) << 32;
        int i = s_nSessionIdAllocator + 1;
        s_nSessionIdAllocator = i;
        return myPid + ((long) i);
    }

    public static void ExConnectDevice(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
            context.sendBroadcast(intent);
        }
    }

    public TraeAudioSession(Context context, a aVar) {
        boolean z = false;
        TXCLog.w("TRAE", "TraeAudioSession create");
        if (Process.myPid() == TraeAudioManager._gHostProcessId) {
            z = true;
        }
        this.mIsHostside = z;
        this.mSessionId = requestSessionId();
        this.mCallback = aVar;
        this.mContext = context;
        if (context == null && QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "AudioSession | Invalid parameters: ctx = " + (context == null ? "null" : "{object}") + "; cb = " + (aVar == null ? "null" : "{object}"));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
        if (context != null) {
            try {
                context.registerReceiver(this, intentFilter);
            } catch (Exception e) {
            }
        }
        registerAudioSession(true);
    }

    public void release() {
        if (this.mContext != null) {
            try {
                this.mContext.unregisterReceiver(this);
            } catch (Exception e) {
            }
        }
        registerAudioSession(false);
        this.mContext = null;
        this.mCallback = null;
    }

    public void setCallback(a aVar) {
        this.mCallback = aVar;
    }

    private int registerAudioSession(boolean z) {
        if (this.mContext == null) {
            return -1;
        }
        if (this.mIsHostside) {
            return TraeAudioManager.registerAudioSession(z, this.mSessionId, this.mContext);
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_REGISTERAUDIOSESSION);
        intent.putExtra(TraeAudioManager.REGISTERAUDIOSESSION_ISREGISTER, z);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int startService(String str) {
        if (str == null || str.length() <= 0) {
            str = "internal_disable_dev_switch";
        }
        if (this.mIsHostside) {
            return TraeAudioManager.startService(TraeAudioManager.OPERATION_STARTSERVICE, this.mSessionId, this.mIsHostside, str);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTSERVICE);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_DEVICECONFIG, str);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int stopService() {
        if (this.mIsHostside) {
            return TraeAudioManager.stopService(TraeAudioManager.OPERATION_STOPSERVICE, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPSERVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getDeviceList() {
        if (this.mIsHostside) {
            return TraeAudioManager.getDeviceList(TraeAudioManager.OPERATION_GETDEVICELIST, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETDEVICELIST);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getStreamType() {
        if (this.mIsHostside) {
            return TraeAudioManager.getStreamType(TraeAudioManager.OPERATION_GETSTREAMTYPE, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETSTREAMTYPE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int connectDevice(String str) {
        if (this.mIsHostside) {
            return TraeAudioManager.connectDevice(TraeAudioManager.OPERATION_CONNECTDEVICE, this.mSessionId, this.mIsHostside, str);
        }
        if (this.mContext == null || str == null || str.length() <= 0) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
        intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int connectHighestPriorityDevice() {
        if (this.mIsHostside) {
            return TraeAudioManager.connectHighestPriorityDevice(TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int EarAction(int i) {
        if (this.mIsHostside) {
            return TraeAudioManager.earAction(TraeAudioManager.OPERATION_EARACTION, this.mSessionId, this.mIsHostside, i);
        }
        if (this.mContext == null || (i != 0 && i != 1)) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_EARACTION);
        intent.putExtra(TraeAudioManager.EXTRA_EARACTION, i);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int isDeviceChangabled() {
        if (this.mIsHostside) {
            return TraeAudioManager.isDeviceChangabled(TraeAudioManager.OPERATION_ISDEVICECHANGABLED, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_ISDEVICECHANGABLED);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getConnectedDevice() {
        if (this.mIsHostside) {
            return TraeAudioManager.getConnectedDevice(TraeAudioManager.OPERATION_GETCONNECTEDDEVICE, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTEDDEVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getConnectingDevice() {
        if (this.mIsHostside) {
            return TraeAudioManager.getConnectingDevice(TraeAudioManager.OPERATION_GETCONNECTINGDEVICE, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTINGDEVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int voiceCallPreprocess(int i, int i2) {
        if (this.mIsHostside) {
            return TraeAudioManager.voicecallPreprocess(TraeAudioManager.OPERATION_VOICECALL_PREPROCESS, this.mSessionId, this.mIsHostside, i, i2);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i);
        intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_PREPROCESS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int voiceCallPostprocess() {
        if (this.mIsHostside) {
            return TraeAudioManager.voicecallPostprocess(TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int voiceCallAudioParamChanged(int i, int i2) {
        if (this.mIsHostside) {
            return TraeAudioManager.voiceCallAudioParamChanged(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST, this.mSessionId, this.mIsHostside, i, i2);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i);
        intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_AUDIOPARAM_CHANGED);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z) {
        if (this.mIsHostside) {
            return TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i, i2, uri, str, z, 1, "normal-ring", false);
        } else if (this.mContext == null) {
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, "normal-ring");
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            return 0;
        }
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z, int i3, String str2) {
        if (this.mIsHostside) {
            return TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i, i2, uri, str, z, i3, str2, false);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
        intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
        intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
        intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i3);
        intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z, int i3, String str2, boolean z2) {
        if (this.mIsHostside) {
            return TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i, i2, uri, str, z, i3, str2, z2);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
        intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
        intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
        intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i3);
        intent.putExtra(TraeAudioManager.PARAM_RING_MODE, z2);
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int stopRing() {
        if (this.mIsHostside) {
            return TraeAudioManager.stopRing(TraeAudioManager.OPERATION_STOPRING, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int requestReleaseAudioFocus() {
        if (this.mIsHostside) {
            return TraeAudioManager.requestReleaseAudioFocus(TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int recoverAudioFocus() {
        if (this.mIsHostside) {
            return TraeAudioManager.recoverAudioFocus(TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS, this.mSessionId, this.mIsHostside);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        boolean z2 = false;
        if (intent != null) {
            try {
                long longExtra = intent.getLongExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
                String stringExtra = intent.getStringExtra(TraeAudioManager.PARAM_OPERATION);
                int intExtra = intent.getIntExtra(TraeAudioManager.PARAM_RES_ERRCODE, 0);
                String stringExtra2;
                String str;
                int intExtra2;
                String stringExtra3;
                if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY.equals(intent.getAction())) {
                    if (TraeAudioManager.NOTIFY_SERVICE_STATE.equals(stringExtra)) {
                        boolean booleanExtra = intent.getBooleanExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, false);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onServiceStateUpdate]" + (booleanExtra ? "on" : "off"));
                        }
                        if (this.mCallback != null) {
                            this.mCallback.a(booleanExtra);
                        }
                    } else if (TraeAudioManager.NOTIFY_DEVICELIST_UPDATE.equals(stringExtra)) {
                        String[] stringArrayExtra = intent.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                        stringExtra = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                        stringExtra2 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                        String stringExtra4 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                        str = "\n";
                        intExtra = 0;
                        while (intExtra < stringArrayExtra.length) {
                            str = str + "AudioSession|    " + intExtra + " " + stringArrayExtra[intExtra] + "\n";
                            if (stringArrayExtra[intExtra].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra[intExtra].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                                z = false;
                            }
                            intExtra++;
                        }
                        r1 = str + "\n";
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + stringExtra + " prevConnected:" + stringExtra2 + " bt:" + stringExtra4 + " Num:" + stringArrayExtra.length + r1);
                        }
                        this._canSwtich2Earphone = z;
                        this._connectedDev = stringExtra;
                        if (this.mCallback != null) {
                            this.mCallback.a(stringArrayExtra, stringExtra, stringExtra2, stringExtra4);
                        }
                    } else if (TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE.equals(stringExtra)) {
                        z = intent.getBooleanExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, true);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onDeviceChangabledUpdate]" + z);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.b(z);
                        }
                    } else if (TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE.equals(stringExtra)) {
                        intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onStreamTypeUpdate] err:" + intExtra + " st:" + intExtra2);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.a(intExtra2);
                        }
                    } else if (TraeAudioManager.NOTIFY_ROUTESWITCHSTART.equals(stringExtra)) {
                        stringExtra3 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_FROM);
                        r1 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_TO);
                        if (this.mCallback != null && stringExtra3 != null && r1 != null) {
                            this.mCallback.a(stringExtra3, r1);
                        }
                    } else if (TraeAudioManager.NOTIFY_ROUTESWITCHEND.equals(stringExtra)) {
                        stringExtra3 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_DEV);
                        longExtra = intent.getLongExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_TIME, -1);
                        if (this.mCallback != null && stringExtra3 != null && longExtra != -1) {
                            this.mCallback.a(stringExtra3, longExtra);
                        }
                    }
                } else if (!TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES.equals(intent.getAction()) || this.mSessionId != longExtra) {
                } else {
                    if (TraeAudioManager.OPERATION_GETDEVICELIST.equals(stringExtra)) {
                        String[] stringArrayExtra2 = intent.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                        String stringExtra5 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                        stringExtra = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                        stringExtra2 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                        String str2 = "\n";
                        int i = 0;
                        while (i < stringArrayExtra2.length) {
                            str2 = str2 + "AudioSession|    " + i + " " + stringArrayExtra2[i] + "\n";
                            if (stringArrayExtra2[i].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra2[i].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                                z = false;
                            }
                            i++;
                        }
                        String str3 = str2 + "\n";
                        this._canSwtich2Earphone = z;
                        this._connectedDev = stringExtra5;
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onGetDeviceListRes] err:" + intExtra + " connected:" + stringExtra5 + " prevConnected:" + stringExtra + " bt:" + stringExtra2 + " Num:" + stringArrayExtra2.length + str3);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.a(intExtra, stringArrayExtra2, stringExtra5, stringExtra, stringExtra2);
                        }
                    } else if (TraeAudioManager.OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                        str = intent.getStringExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " dev:" + str);
                        }
                        if (this.mCallback != null) {
                            a aVar = this.mCallback;
                            if (intExtra == 0) {
                                z2 = true;
                            }
                            aVar.a(intExtra, str, z2);
                        }
                    } else if (TraeAudioManager.OPERATION_EARACTION.equals(stringExtra)) {
                        intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_EARACTION, -1);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " earAction:" + intExtra2);
                        }
                    } else if (TraeAudioManager.OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                        boolean booleanExtra2 = intent.getBooleanExtra(TraeAudioManager.ISDEVICECHANGABLED_RESULT_ISCHANGABLED, false);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onIsDeviceChangabledRes] err:" + intExtra + " Changabled:" + (booleanExtra2 ? "Y" : "N"));
                        }
                        if (this.mCallback != null) {
                            this.mCallback.a(intExtra, booleanExtra2);
                        }
                    } else if (TraeAudioManager.OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                        stringExtra3 = intent.getStringExtra(TraeAudioManager.GETCONNECTEDDEVICE_RESULT_LIST);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + intExtra + " dev:" + stringExtra3);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.a(intExtra, stringExtra3);
                        }
                    } else if (TraeAudioManager.OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                        stringExtra3 = intent.getStringExtra(TraeAudioManager.GETCONNECTINGDEVICE_RESULT_LIST);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + intExtra + " dev:" + stringExtra3);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.b(intExtra, stringExtra3);
                        }
                    } else if (TraeAudioManager.OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                        intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + intExtra + " st:" + intExtra2);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.a(intExtra, intExtra2);
                        }
                    } else if (TraeAudioManager.NOTIFY_RING_COMPLETION.equals(stringExtra)) {
                        stringExtra3 = intent.getStringExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onRingCompletion] err:" + intExtra + " userData:" + stringExtra3);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.c(intExtra, stringExtra3);
                        }
                    } else if (TraeAudioManager.OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:" + intExtra);
                        }
                        if (this.mCallback != null) {
                            this.mCallback.b(intExtra);
                        }
                    }
                }
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + intent.toString() + " intent.getAction():" + intent.getAction() + " Exception:" + e.getMessage());
                }
            }
        }
    }
}
