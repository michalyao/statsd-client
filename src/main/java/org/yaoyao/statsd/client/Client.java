package org.yaoyao.statsd.client;

public interface Client {

    void enableMultiMetrics(boolean enable);
    boolean timing(String key, int value);
    boolean timing(String key, int value, double sampleRate);
    boolean decrement(String key);
    boolean decrement(String key, int magnitude);
    boolean decrement(String key, int magnitude, double sampleRate);
    boolean decrement(String... keys);
    boolean decrement(int magnitude, String... keys);
    boolean decrement(int magnitude, double sampleRate, String... keys);
    boolean increment(String key);
    boolean increment(String key, int magnitude);
    boolean increment(String key, int magnitude, double sampleRate);
    boolean increment(int magnitude, double sampleRate, String keys);
    boolean gauge(String key, double magnitude, double sampleRate);
    boolean gauge(String key, double magnitude);
    boolean send(double sampleRate, String... stats);
    boolean doSend(String stat);

}
