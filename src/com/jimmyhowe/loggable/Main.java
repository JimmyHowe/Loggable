package com.jimmyhowe.loggable;

import com.jimmyhowe.consolecolors.Console;

public class Main
{
    public static void main(String[] args)
    {
        QueryLog queryLog = new QueryLog();

        QueryLog.onNote(Console::white);
        QueryLog.onInfo(Console::cyan);
        QueryLog.onDebug(Console::yellow);
        QueryLog.onError(message -> Console.red(message.toUpperCase()));

        queryLog.note("Note");
        queryLog.info("Info");
        queryLog.debug("Debug");
        queryLog.error("Error");

        queryLog.toConsole();
    }
}
