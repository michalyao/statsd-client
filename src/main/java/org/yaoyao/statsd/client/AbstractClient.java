package org.yaoyao.statsd.client;

import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractClient extends TimerTask  implements Client  {
    private ByteBuffer sendBuffer;
    private Timer flushTimer;

    protected synchronized void setBufferSize(short packetBufferSize) {
        if (sendBuffer != null) {
            flush();
        }
        sendBuffer = ByteBuffer.allocate(packetBufferSize);

    }

    @Override
    public void enableMultiMetrics(boolean enable) {

    }


    protected synchronized boolean startFlushTimer(long period) {
        if (flushTimer == null) {
            if (period <= 0) {
                period = 2000;
            }
            flushTimer = new Timer();
            flushTimer.schedule(this, period, period);
            return true;
        }
        return false;
    }


    protected synchronized void stopFlushTimer() {
        if (flushTimer != null) {
            flushTimer.cancel();
            flushTimer = null;
        }
    }


    public void run() {
        flush();
    }


    public boolean timing(String key, int value) {
        return false;
    }

    public boolean timing(String key, int value, double sampleRate) {
        return false;
    }


    public boolean decrement(String key) {
        return false;
    }

    public boolean decrement(String key, int magnitude) {
        return false;
    }


    public boolean decrement(String key, int magnitude, double sampleRate) {
        return false;
    }


    public boolean decrement(String... keys) {
        return false;
    }


    public boolean decrement(int magnitude, String... keys) {
        return false;
    }

    public boolean decrement(int magnitude, double sampleRate, String... keys) {
        return false;
    }


    public boolean increment(String key) {
        return false;
    }


    public boolean increment(String key, int magnitude) {
        return false;
    }


    public boolean increment(String key, int magnitude, double sampleRate) {
        return false;
    }


    public boolean increment(int magnitude, double sampleRate, String keys) {
        return false;
    }


    public boolean gauge(String key, double magnitude, double sampleRate) {
        return false;
    }


    public boolean gauge(String key, double magnitude) {
        return false;
    }


    public boolean send(double sampleRate, String... stats) {
        return false;
    }


    public abstract boolean doSend(String stat);



    public abstract boolean flush();
}
