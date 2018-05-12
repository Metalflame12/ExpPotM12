package me.metalflame12.ExpPotM12;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by lucas on 11/05/2017.
 */
public class Eventos implements Listener {

    @EventHandler
    public void usouExpPot(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.getItemInHand().getType().equals(Material.EXP_BOTTLE)){
            if((e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
                ItemStack exppot = e.getPlayer().getItemInHand();
                if(exppot.hasItemMeta()){
                    ItemMeta meta = exppot.getItemMeta();
                    List<String> lore = meta.getLore();
                    if(lore.get(0).contains("§aLevel: ")) {
                        e.setCancelled(true);
                        int lvlint = Integer.parseInt(lore.get(0).replace("§aLevel: ", ""));
                        int plvl = p.getLevel();
                        p.setLevel(plvl + lvlint);
                        p.sendMessage("§aVocê usou uma ExpPot, foi adicionado " + lvlint + " no seu Exp total.");
                        exppot.setAmount(exppot.getAmount() -1);
                    }
                }
            }
        }
    }
}

