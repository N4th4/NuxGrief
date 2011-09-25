package net.n4th4.bukkit.nuxgrief;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EndermanPickupEvent;
import org.bukkit.event.entity.EndermanPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.material.MaterialData;

public class NGEntityListener extends EntityListener {
    public final NuxGrief plugin;

    public NGEntityListener(NuxGrief instance) {
        plugin = instance;
    }

    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getTarget() instanceof Player) {
            String entityName = event.getEntity().getClass().getSimpleName();
            if (entityName.startsWith("Craft")) {
                entityName = entityName.substring(5).toLowerCase();
            }
            
            if (!((Player) event.getTarget()).hasPermission("nuxgrief.gettargeted." + entityName)) {
                event.setCancelled(true);
            }
        }
    }
    
    public void onEndermanPickup(EndermanPickupEvent event) {
        Enderman enderman = (Enderman) event.getEntity();
        MaterialData newBlockInHand = new MaterialData(event.getBlock().getTypeId(), event.getBlock().getData());
        enderman.setCarriedMaterial(newBlockInHand);
        event.setCancelled(true);
    }
    
    public void onEndermanPlace(EndermanPlaceEvent event) {
        Enderman enderman = (Enderman) event.getEntity();
        MaterialData newBlockInHand = new MaterialData(0);
        enderman.setCarriedMaterial(newBlockInHand);
        event.setCancelled(true);
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
