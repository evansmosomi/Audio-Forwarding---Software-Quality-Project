package com.rom1v.sndcpy;

import static org.junit.jupiter.api.Assertions.*;

class RecordServiceTest {

    private static final String ACTION_STOP = "com.rom1v.sndcpy.STOP";
    private static final short START_NOT_STICKY = 0;
    private Object Runnable;

    @org.junit.jupiter.api.Test
    void start() {
    }

    @org.junit.jupiter.api.Test
    void onCreate() {
    }

    @org.junit.jupiter.api.Test
    void onStartCommandActionStop() {
        String action= ACTION_STOP;
        assertEquals(START_NOT_STICKY,onStartCommand());
    }


    @org.junit.jupiter.api.Test
    double onBind(){
        assertEquals(null,onBind());
        return 0;
    }

    @org.junit.jupiter.api.Test
    void onDestroy() {
        Thread recorderThread = new Thread((java.lang.Runnable) Runnable);
        assertNotNull(recorderThread);
    }
}