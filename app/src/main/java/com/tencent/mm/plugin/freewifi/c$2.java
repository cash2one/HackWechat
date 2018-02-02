package com.tencent.mm.plugin.freewifi;

import android.net.wifi.SupplicantState;

/* synthetic */ class c$2 {
    static final /* synthetic */ int[] mCa = new int[SupplicantState.values().length];

    static {
        try {
            mCa[SupplicantState.ASSOCIATED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            mCa[SupplicantState.ASSOCIATING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            mCa[SupplicantState.AUTHENTICATING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            mCa[SupplicantState.COMPLETED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            mCa[SupplicantState.DISCONNECTED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            mCa[SupplicantState.DORMANT.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            mCa[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            mCa[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            mCa[SupplicantState.INACTIVE.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            mCa[SupplicantState.INTERFACE_DISABLED.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
        try {
            mCa[SupplicantState.INVALID.ordinal()] = 11;
        } catch (NoSuchFieldError e11) {
        }
        try {
            mCa[SupplicantState.SCANNING.ordinal()] = 12;
        } catch (NoSuchFieldError e12) {
        }
        try {
            mCa[SupplicantState.UNINITIALIZED.ordinal()] = 13;
        } catch (NoSuchFieldError e13) {
        }
    }
}
