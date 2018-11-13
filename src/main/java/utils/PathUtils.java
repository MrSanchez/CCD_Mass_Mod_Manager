package utils;

import app.Settings;

import java.io.File;

public class PathUtils
{
    public static String append(String ...paths) {
        StringBuilder builder = new StringBuilder();
        for(String path : paths) {
            builder.append(path);
            builder.append('/');
        }
        return builder.toString();
    }

    public static String fromGameDir(String ...paths) {
        StringBuilder builder = new StringBuilder(Settings.gameDirectory);
        if(builder.charAt(builder.length() - 1) != '/') builder.append('/');

        for(String path : paths) {
            builder.append(path);
            builder.append('/');
        }
        return builder.toString();
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }

    public static String removeFileExtension(String s) {
        String separator = File.separator;
        String filename;

        // Remove the path upto the filename.
        int lastSeparatorIndex = s.lastIndexOf(separator);
        if (lastSeparatorIndex == -1) {
            filename = s;
        } else {
            filename = s.substring(lastSeparatorIndex + 1);
        }

        // Remove the extension.
        int extensionIndex = filename.lastIndexOf(".");
        if (extensionIndex == -1)
            return filename;

        return filename.substring(0, extensionIndex);
    }
}
