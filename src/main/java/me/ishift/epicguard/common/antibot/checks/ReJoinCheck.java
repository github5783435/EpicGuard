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

package me.ishift.epicguard.common.antibot.checks;

import lombok.AllArgsConstructor;
import me.ishift.epicguard.common.AttackManager;
import me.ishift.epicguard.common.antibot.Check;
import me.ishift.epicguard.common.data.StorageManager;
import me.ishift.epicguard.common.data.config.Configuration;

@AllArgsConstructor
public class ReJoinCheck implements Check {
    private final AttackManager manager;

    @Override
    public boolean execute(String address, String nickname) {
        if (Configuration.rejoinCheck && this.manager.isAttackMode() && !this.manager.getStorageManager().getStorage().getRejoinData().contains(nickname)) {
            this.manager.getStorageManager().getStorage().getRejoinData().add(nickname);
            return true;
        }
        return false;
    }
}
