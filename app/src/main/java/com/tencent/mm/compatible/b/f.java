package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class f {
    private static volatile f gCd = null;
    private static boolean gCg = false;
    public static boolean gCh = false;
    private static boolean gCi = false;
    private static boolean gCj = false;
    private static int gCp = 0;
    private static int gCq = 0;
    private static HashMap<Integer, String> gCr = new HashMap();
    private static int gCs = 0;
    private static int gCt = 0;
    private static HashMap<Integer, String> gCu = new HashMap();
    private static int gCv = 0;
    private static int gCw = 0;
    private static HashMap<Integer, String> gCx = new HashMap();
    public final AudioManager gCe;
    private int gCf = -1;
    private int gCk = 0;
    private final Set<a> gCl = new HashSet();
    private final int gCm = 1000;
    private af gCn = new af(this) {
        final /* synthetic */ f gCy;

        {
            this.gCy = r1;
        }

        public final void handleMessage(Message message) {
            x.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            this.gCy.fx(3);
        }
    };
    private int gCo = -1;

    public interface a {
        void er(int i);
    }

    public static f xG() {
        if (gCd == null) {
            synchronized (f.class) {
                if (gCd == null) {
                    gCd = new f(ac.getContext());
                }
            }
        }
        return gCd;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.gCl.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            this.gCl.remove(aVar);
        }
    }

    public final void fx(int i) {
        x.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.gCf));
        for (a er : this.gCl) {
            er.er(i);
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public f(Context context) {
        this.gCe = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        x.i("MicroMsg.MMAudioManager", "init dkbt %s", xP());
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ f gCy;

            {
                this.gCy = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
                this.gCy.fx(7);
            }
        }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ f gCy;

            {
                this.gCy = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("state", -1);
                int intExtra2 = intent.getIntExtra("microphone", -1);
                x.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                if (intExtra == 0) {
                    this.gCy.fx(6);
                } else if (intExtra == 1) {
                    this.gCy.xJ();
                }
            }
        }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ f gCy;

            {
                this.gCy = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    f.gCi = intent.getBooleanExtra("existing", false);
                    x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + f.gCi);
                }
            }
        }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ f gCy;

            {
                this.gCy = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                if (com.tencent.mm.compatible.util.f.fN(11)) {
                    f.gCg = true;
                    this.gCy.gCn.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ f gCy;

            {
                this.gCy = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
                f.gCg = false;
                if (q.gGe.gED == 1) {
                    com.tencent.mm.compatible.c.a.a(this.gCy.gCe);
                }
                this.gCy.fx(4);
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (com.tencent.mm.compatible.util.f.fM(11)) {
            context.registerReceiver(new BroadcastReceiver(this) {
                final /* synthetic */ f gCy;

                {
                    this.gCy = r1;
                }

                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                        if (intExtra == 2) {
                            f.gCg = true;
                            this.gCy.gCn.sendEmptyMessageDelayed(0, 1000);
                        } else if (intExtra == 0) {
                            f.gCg = false;
                            if (q.gGe.gED == 1) {
                                com.tencent.mm.compatible.c.a.a(this.gCy.gCe);
                            }
                            this.gCy.fx(4);
                        }
                    }
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
    }

    public final void xH() {
        x.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", xP());
        gCh = false;
        fx(2);
    }

    public final int xI() {
        this.gCf = -1;
        if (!xO()) {
            return -1;
        }
        boolean z;
        x.k("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", xP());
        AudioManager audioManager = this.gCe;
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            z = false;
        } else if (aq.vd()) {
            z = false;
        } else {
            x.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(q.gGe.gEF));
            if ((q.gGe.gEF == 1 || q.gGe.gEF == -1) && !audioManager.isBluetoothScoOn()) {
                x.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", bh.cgy());
                audioManager.startBluetoothSco();
            }
            z = true;
        }
        x.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", xP(), Boolean.valueOf(z));
        x.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + xP() + " ret:" + z);
        x.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", Boolean.valueOf(xL()));
        if (xL()) {
            return 1;
        }
        return 0;
    }

    public final void xJ() {
        gCh = false;
        x.k("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", xP());
        com.tencent.mm.compatible.c.a.a(this.gCe);
        this.gCn.removeCallbacksAndMessages(Integer.valueOf(1));
        x.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", xP());
    }

    public static boolean xK() {
        return false;
    }

    public final boolean xL() {
        return this.gCe.isBluetoothScoOn() || this.gCe.isBluetoothA2dpOn() || gCh;
    }

    @TargetApi(14)
    private static boolean xM() {
        try {
            if (VERSION.SDK_INT >= 14) {
                x.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    return true;
                }
                return false;
            } else if (gCg) {
                return true;
            } else {
                if (q.gGe.gEO == 1) {
                    return BluetoothAdapter.getDefaultAdapter().isEnabled();
                }
                return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    public final int ba(boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        return xL() ? 0 : i;
    }

    public static int xN() {
        ((AudioManager) ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isBluetoothScoOn();
        return 0;
    }

    public static boolean xO() {
        x.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + gCi + " , isUseHTCAccessory = " + gCj);
        if (gCi && !gCj) {
            return false;
        }
        x.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + gCg);
        if (xM()) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                x.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                return false;
            } else if (defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices == null || bondedDevices.size() == 0) {
                    x.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                    return false;
                }
                boolean z;
                for (BluetoothDevice bondState : bondedDevices) {
                    if (bondState.getBondState() == 12) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    x.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", Boolean.valueOf(true));
                    return true;
                }
                x.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                return false;
            } else {
                x.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                return false;
            }
        }
        x.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + gCg + " , isConnectHeadset() = " + xM());
        return false;
    }

    public final String xP() {
        return "mode:" + (this.gCe != null ? this.gCe.getMode() : 0) + " isSpeakerphoneOn:" + this.gCe.isSpeakerphoneOn() + " isBluetoothOn:" + xL() + " btStatus:" + this.gCf;
    }

    public final boolean xQ() {
        return this.gCe.getMode() == 0;
    }

    @TargetApi(11)
    public final boolean h(boolean z, boolean z2) {
        boolean z3 = true;
        int i = 0;
        int mode = this.gCe.getMode();
        x.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(xQ()), Boolean.valueOf(z), xP());
        if (aq.vd()) {
            x.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.gCf));
            return false;
        } else if (xL() || gCh) {
            x.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
            if (z2) {
                x.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                setMode(3);
            } else {
                setMode(0);
            }
            return false;
        } else {
            xU();
            if (z2) {
                if (q.gFV.gCG) {
                    if (q.gFV.yb()) {
                        if (q.gFV.gCI >= 0) {
                            setMode(q.gFV.gCI);
                        } else if (q.gFV.gCJ >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.gFV.gCK <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (q.gFV.yc()) {
                        if (z) {
                            if (q.gFV.yf()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.gFV.ye() < 0) {
                                return z;
                            }
                            setMode(q.gFV.ye());
                            return z;
                        }
                        if (q.gFV.yh()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.gFV.yg() < 0) {
                            return z;
                        }
                        setMode(q.gFV.yg());
                        return z;
                    }
                }
            } else if (q.gFV.gCG && q.gFV.yd()) {
                b bVar;
                if (z) {
                    boolean z4;
                    bVar = q.gFV;
                    if (bVar.yd()) {
                        mode = bVar.gCM & 16;
                        x.d("VoipAudioInfo", "enableSpeaker " + (mode > 0));
                        if (mode > 0) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        setSpeakerphoneOn(true);
                    }
                    if (q.gFV.yi() < 0) {
                        return z;
                    }
                    setMode(q.gFV.yi());
                    return z;
                }
                bVar = q.gFV;
                if (bVar.yd()) {
                    mode = bVar.gCM & 1;
                    x.d("VoipAudioInfo", "disableSpeaker " + (mode > 0));
                    if (mode <= 0) {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    setSpeakerphoneOn(false);
                }
                if (q.gFV.yj() < 0) {
                    return z;
                }
                setMode(q.gFV.yj());
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (xQ() == z) {
                    return z;
                }
                if (z) {
                    setMode(0);
                    return z;
                } else if (VERSION.SDK_INT >= 11 && l.xg() && 2 != q.gGe.gEP) {
                    setMode(3);
                    return z;
                } else if (VERSION.SDK_INT >= 11) {
                    setMode(3);
                    return z;
                } else {
                    setMode(2);
                    return z;
                }
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i = 3;
                }
                if (q.gFV.gDg >= 0) {
                    i = q.gFV.gDg;
                }
                x.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
                if (i != this.gCe.getMode()) {
                    setMode(i);
                }
                if (i != this.gCe.getMode()) {
                    if (this.gCk == 0) {
                        this.gCk = 1;
                    } else if (this.gCk == 2) {
                        this.gCk = 3;
                    }
                }
                if (this.gCe.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT >= 11) {
                    mode = 3;
                } else if (q.gGe.gEO == 1) {
                    x.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && l.xg() && 2 == q.gGe.gEP) {
                    mode = 2;
                }
                if (q.gFV.gDh >= 0) {
                    mode = q.gFV.gDh;
                }
                x.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + mode);
                if (mode != this.gCe.getMode()) {
                    setMode(mode);
                }
                if (mode != this.gCe.getMode()) {
                    if (this.gCk == 0) {
                        this.gCk = 2;
                    } else if (this.gCk == 1) {
                        this.gCk = 3;
                    }
                }
                if (!this.gCe.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    @TargetApi(11)
    public final boolean bb(boolean z) {
        int i = 3;
        int i2 = 0;
        x.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(xQ()), Boolean.valueOf(z), xP());
        if (aq.vd()) {
            x.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.gCf));
            return false;
        } else if (gCh) {
            setMode(3);
            return false;
        } else {
            xU();
            if (!q.gFV.gDF) {
                if (q.gFV.gCG) {
                    if (q.gFV.yb()) {
                        if (q.gFV.gCI >= 0) {
                            setMode(q.gFV.gCI);
                        } else if (q.gFV.gCJ >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.gFV.gCK <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (q.gFV.yc()) {
                        if (z) {
                            if (q.gFV.yf()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.gFV.ye() < 0) {
                                return z;
                            }
                            setMode(q.gFV.ye());
                            return z;
                        }
                        if (q.gFV.yh()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.gFV.yg() < 0) {
                            return z;
                        }
                        setMode(q.gFV.yg());
                        return z;
                    }
                }
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (q.gFV.gDg >= 0) {
                        i2 = q.gFV.gDg;
                    }
                    x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                    if (i2 != this.gCe.getMode()) {
                        setMode(i2);
                    }
                    if (this.gCe.isSpeakerphoneOn()) {
                        return z;
                    }
                    setSpeakerphoneOn(true);
                    return z;
                }
                if (VERSION.SDK_INT < 11) {
                    if (q.gGe.gEO == 1) {
                        x.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && l.xg() && 2 == q.gGe.gEP) {
                    i = 2;
                }
                if (q.gFV.gDh >= 0) {
                    i = q.gFV.gDh;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.gCe.getMode()) {
                    setMode(i);
                }
                if (!this.gCe.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (q.gFV.gDG >= 0) {
                    i2 = q.gFV.gDG;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                if (i2 != this.gCe.getMode()) {
                    setMode(i2);
                }
                if (this.gCe.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (q.gGe.gEO == 1) {
                        x.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (q.gFV.gDH >= 0) {
                    i = q.gFV.gDH;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.gCe.getMode()) {
                    setMode(i);
                }
                if (!this.gCe.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    public final boolean b(boolean z, int i) {
        int streamMaxVolume = this.gCe.getStreamMaxVolume(i);
        x.d("MicroMsg.MMAudioManager", "maxVolumn:" + streamMaxVolume);
        streamMaxVolume /= 3;
        int streamVolume = this.gCe.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            this.gCe.setStreamVolume(i, streamMaxVolume, 0);
        }
        x.i("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        return h(z, true);
    }

    public final boolean xR() {
        if (this.gCe != null) {
            return this.gCe.isWiredHeadsetOn();
        }
        return false;
    }

    public final void fy(int i) {
        if (this.gCe != null) {
            this.gCe.adjustStreamVolume(i, 1, 5);
        }
    }

    public final void fz(int i) {
        if (this.gCe != null) {
            this.gCe.adjustStreamVolume(i, -1, 5);
        }
    }

    public final void xS() {
        if (this.gCe != null) {
            this.gCe.setStreamMute(3, true);
        }
    }

    public final void xT() {
        if (this.gCe != null) {
            this.gCe.setStreamMute(3, false);
        }
    }

    private void xU() {
        if (this.gCe != null) {
            int mode = this.gCe.getMode();
            boolean isSpeakerphoneOn = this.gCe.isSpeakerphoneOn();
            Object fH = com.tencent.mm.compatible.d.l.yn().fH(98305);
            Object fH2 = com.tencent.mm.compatible.d.l.yn().fH(94209);
            if (fH == null) {
                com.tencent.mm.compatible.d.l.yn().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                x.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + isSpeakerphoneOn);
            }
            if (fH2 == null) {
                com.tencent.mm.compatible.d.l.yn().set(94209, Integer.valueOf(mode));
                x.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + mode);
            }
        }
    }

    @Deprecated
    public final void xV() {
        if (this.gCe != null) {
            Object fH = com.tencent.mm.compatible.d.l.yn().fH(98305);
            Object fH2 = com.tencent.mm.compatible.d.l.yn().fH(94209);
            if (fH != null) {
                x.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + fH);
                setSpeakerphoneOn(((Boolean) fH).booleanValue());
                com.tencent.mm.compatible.d.l.yn().set(98305, null);
            }
            if (fH2 != null) {
                int i;
                try {
                    x.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + fH2 + ",inmode:0");
                    i = bh.getInt(String.valueOf(fH2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                com.tencent.mm.compatible.d.l.yn().set(94209, null);
            }
        }
    }

    public final void setMode(int i) {
        if (this.gCe != null) {
            x.i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.gCe.getMode()), Integer.valueOf(i));
            this.gCe.setMode(i);
        }
    }

    public final void setSpeakerphoneOn(boolean z) {
        x.k("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + z, new Object[0]);
        if (this.gCe != null) {
            x.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + z);
            this.gCe.setSpeakerphoneOn(z);
        }
    }

    public final int xW() {
        int i = this.gCk;
        this.gCk = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        if (this.gCe != null) {
            return this.gCe.getStreamMaxVolume(i);
        }
        return 5;
    }

    public final int getStreamVolume(int i) {
        if (this.gCe != null) {
            return this.gCe.getStreamVolume(i);
        }
        return -1;
    }

    public final void aM(int i, int i2) {
        if (this.gCe != null) {
            x.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            this.gCe.setStreamVolume(i, i2, 0);
        }
    }

    public final int xX() {
        if (this.gCo == -1) {
            try {
                Field field = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
                if (!(field == null || this.gCe == null)) {
                    this.gCo = field.getInt(this.gCe);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + e.getMessage());
                this.gCo = 6;
            }
        }
        return this.gCo;
    }

    public static void fA(int i) {
        gCp++;
        x.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gCp), Integer.valueOf(gCq));
        gCr.put(Integer.valueOf(i), new ai().toString());
        xY();
    }

    public static void fB(int i) {
        gCq++;
        x.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gCp), Integer.valueOf(gCq));
        gCr.remove(Integer.valueOf(i));
    }

    public static void fC(int i) {
        gCs++;
        x.k("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gCs), Integer.valueOf(gCt));
        gCu.put(Integer.valueOf(i), new ai().toString());
        xY();
    }

    public static void fD(int i) {
        if (gCu.containsKey(Integer.valueOf(i))) {
            gCt++;
            x.k("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gCs), Integer.valueOf(gCt));
            gCu.remove(Integer.valueOf(i));
        }
    }

    public static void fE(int i) {
        gCv++;
        x.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gCv), Integer.valueOf(gCw));
        gCx.put(Integer.valueOf(i), new ai().toString());
        xY();
    }

    public static void fF(int i) {
        gCw++;
        x.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(gCv), Integer.valueOf(gCw));
        gCx.remove(Integer.valueOf(i));
    }

    private static void xY() {
        com.tencent.mm.sdk.b.b jkVar = new jk();
        if (gCp - gCq > 1) {
            jkVar.fzX.fzY = true;
            jkVar.fzX.fzZ = gCr.size();
        }
        if (gCv - gCw > 1) {
            jkVar.fzX.fAa = true;
            jkVar.fzX.fAb = gCx.size();
        }
        if (gCs - gCt > 1) {
            jkVar.fzX.fAc = true;
            jkVar.fzX.fAd = gCu.size();
        }
        if (jkVar.fzX.fAa || jkVar.fzX.fzY || jkVar.fzX.fAc) {
            x.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(jkVar.fzX.fzY), Integer.valueOf(jkVar.fzX.fzZ), Boolean.valueOf(jkVar.fzX.fAa), Integer.valueOf(jkVar.fzX.fAb), Boolean.valueOf(jkVar.fzX.fAc), Integer.valueOf(jkVar.fzX.fAd));
            com.tencent.mm.sdk.b.a.xef.m(jkVar);
        }
    }

    public static String xZ() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioTrack: \r\n");
        stringBuffer.append("leak: ").append(gCr.size()).append("init: ").append(gCp).append("release: ").append(gCq).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gCr.isEmpty()) {
            for (String append : gCr.values()) {
                stringBuffer.append(append).append("\r\n");
            }
        }
        stringBuffer.append("MediaPlayer: \r\n");
        stringBuffer.append("leak: ").append(gCx.size()).append("init: ").append(gCv).append("release: ").append(gCw).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gCx.isEmpty()) {
            for (String append2 : gCx.values()) {
                stringBuffer.append(append2).append("\r\n");
            }
        }
        stringBuffer.append("AudioRecord: \r\n");
        stringBuffer.append("leak: ").append(gCu.size()).append("init: ").append(gCs).append("release: ").append(gCs).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!gCu.isEmpty()) {
            for (String append22 : gCu.values()) {
                stringBuffer.append(append22).append("\r\n");
            }
        }
        x.e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer.toString());
        return stringBuffer.toString();
    }
}
