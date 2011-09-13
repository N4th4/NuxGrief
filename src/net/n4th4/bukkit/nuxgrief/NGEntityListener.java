package net.n4th4.bukkit.nuxgrief;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTargetEvent;

public class NGEntityListener extends EntityListener {
    public final NuxGrief plugin;

    public NGEntityListener(NuxGrief instance) {
        plugin = instance;
    }

    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getTarget() instanceof Player) {
            if (!((Player) event.getTarget()).hasPermission("nuxgrief.gettargeted")) {
                event.setCancelled(true);
            }
        }
    }

    public void onEntityDamage(EntityDamageEvent event) {
        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent event2 = (EntityDamageByEntityEvent) event;
            if (event2.getDamager() instanceof Player) {
                if (!((Player) event2.getDamager()).hasPermission("nuxgrief.damage")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
