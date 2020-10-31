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

package me.xneox.epicguard.core.check;

import me.xneox.epicguard.core.EpicGuard;
import me.xneox.epicguard.core.config.MessagesConfiguration;
import me.xneox.epicguard.core.config.PluginConfiguration;
import me.xneox.epicguard.core.manager.StorageManager;
import me.xneox.epicguard.core.user.BotUser;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class Check {
    private final EpicGuard epicGuard;

    public Check(EpicGuard epicGuard) {
        this.epicGuard = epicGuard;
    }

    @Nonnull
    public EpicGuard getEpicGuard() {
        return this.epicGuard;
    }

    @Nonnull
    public PluginConfiguration getConfig() {
        return this.epicGuard.getConfig();
    }

    @Nonnull
    public MessagesConfiguration getMessages() {
        return this.epicGuard.getMessages();
    }

    @Nonnull
    public StorageManager getStorage() {
        return this.epicGuard.getStorageManager();
    }

    public boolean isAttack() {
        return this.epicGuard.getAttackManager().isAttack();
    }

    @Nonnull
    public abstract List<String> getKickMessage();

    public abstract boolean shouldBlacklist();

    /**
     * @return true if detection is positive (detected as bot).
     * @param user An {@link BotUser} object with the information about the user.
     */
    public abstract boolean handle(@Nonnull BotUser user);
}
