package com.jimmyhowe.loggable;

public interface Loggable
{
    /**
     * @param message
     */
    void note(String message);

    /**
     * @param message
     */
    void info(String message);

    /**
     * @param message
     */
    void debug(String message);

    /**
     * @param message
     */
    void error(String message);
}
