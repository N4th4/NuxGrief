package net.n4th4.bukkit.nuxgrief;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class NGPlayerListener extends PlayerListener {
    public final NuxGrief plugin;

    public NGPlayerListener(NuxGrief instance) {
        plugin = instance;
    }

    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        if (!event.getPlayer().hasPermission("nuxgrief.pickup")) {
            event.setCancelled(true);
        }
    }

    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) {
            return;
        }
        if (event.getClickedBlock().getType() == Material.CHEST && !event.getPlayer().hasPermission("nuxgrief.interact.chests")) {
            event.setCancelled(true);
        } else if (event.getClickedBlock().getType() == Material.FURNACE && !event.getPlayer().hasPermission("nuxgrief.interact.furnaces")) {
            event.setCancelled(true);
        } else if (event.getClickedBlock().getType() == Material.STORAGE_MINECART && !event.getPlayer().hasPermission("nuxgrief.interact.storage_minecarts")) {
            event.setCancelled(true);
        }
    }
}
