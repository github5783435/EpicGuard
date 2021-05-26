/*
 * EpicGuard is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EpicGuard is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package me.xneox.epicguard.core.util;

import de.leonhard.storage.util.Valid;
import de.leonhard.storage.util.Valid;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public final class FileUtils {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void downloadFile(@Nonnull String urlFrom, @Nonnull File file) throws IOException {
        Valid.notNull(urlFrom, "Download URL cannot be null!");
        Valid.notNull(urlFrom, "Target file cannot be null!");

        file.delete();
        file.createNewFile();

        URLConnection connection = new URL(urlFrom).openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/4.0");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        ReadableByteChannel channel = Channels.newChannel(connection.getInputStream());
        FileOutputStream out = new FileOutputStream(file);
        out.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);

        out.close();
        channel.close();
    }

    private FileUtils() {
    }
}
