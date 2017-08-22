package com.jimmyhowe.loggable;

import java.util.ArrayList;
import java.util.List;

public class Log implements Loggable
{
    /**
     * Filter applied to notes
     */
    private static LogFilter noteFilter;

    /**
     * Log Messages
     */
    private List<String> messages = new ArrayList<>();

    /**
     * Filter applied to information
     */
    private static LogFilter infoFilter;

    /**
     * Debug filter
     */
    private static LogFilter debugFilter;

    /**
     * Error message filter
     */
    private static LogFilter errorFilter;

    /**
     * @param filter Note Filter
     */
    public static void onNote(LogFilter filter)
    {
        noteFilter = filter;
    }

    public static void onInfo(LogFilter filter)
    {
        infoFilter = filter;
    }

    public static void onDebug(LogFilter filter)
    {
        debugFilter = filter;
    }

    public static void onError(LogFilter filter)
    {
        errorFilter = filter;
    }

    /**
     * Outputs the log to the console
     */
    public void toConsole()
    {
        messages.forEach(System.out::println);
    }

    /**
     * @param message
     */
    @Override
    public void note(String message)
    {
        messages.add((noteFilter != null) ? noteFilter.filter(message) : message);
    }

    /**
     * @param message
     */
    @Override
    public void info(String message)
    {
        messages.add((infoFilter != null) ? infoFilter.filter(message) : message);
    }

    /**
     * @param message
     */
    @Override
    public void debug(String message)
    {
        messages.add((debugFilter != null) ? debugFilter.filter(message) : message);
    }

    /**
     * @param message
     */
    @Override
    public void error(String message)
    {
        messages.add((errorFilter != null) ? errorFilter.filter(message) : message);
    }

    /**
     * @return as List
     */
    public List<String> asList()
    {
        return messages;
    }
}
