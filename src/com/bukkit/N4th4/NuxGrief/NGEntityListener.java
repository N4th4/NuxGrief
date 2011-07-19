package com.bukkit.N4th4.NuxGrief;

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
            if (!plugin.permissions.has((Player) event.getTarget(), "nuxgrief.gettargeted")) {
                event.setCancelled(true);
            }
        }
    }
    
    public void onEntityDamage(EntityDamageEvent event) {
        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent event2 = (EntityDamageByEntityEvent) event;
            if (event2.getDamager() instanceof Player) {
                if (!plugin.permissions.has((Player) event2.getDamager(), "nuxgrief.damage")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
