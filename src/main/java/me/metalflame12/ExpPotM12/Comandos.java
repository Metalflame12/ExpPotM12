package me.metalflame12.ExpPotM12;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Comandos implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("exppot")) {
            Player p = (Player) sender;
            int lvl = p.getLevel();
            if (lvl >= 1) {
                if (args.length == 0) {
                        ItemStack exppot = new ItemStack(Material.EXP_BOTTLE);
                        ItemMeta meta = exppot.getItemMeta();
                        ArrayList<String> lore = new ArrayList<String>();
                        lore.add("§aLevel: " + lvl);
                        lore.add("§aUse para par ter o Exp de volta!");
                        meta.setLore(lore);
                        exppot.setItemMeta(meta);
                        p.getInventory().addItem(exppot);
                        p.setLevel(0);
                }
                if(args.length == 1) {
                    if(args[0].matches("([0-9])+")){
                        int solicitado = Integer.parseInt(args[0]);
                        char primeiro = args[0].charAt(0);
                        if(solicitado <= lvl){
                            if((solicitado == 0) || (primeiro == '0')){
                                sender.sendMessage("§cNão permitido.");
                            }else {
                                ItemStack exppot = new ItemStack(Material.EXP_BOTTLE);
                                ItemMeta meta = exppot.getItemMeta();
                                ArrayList<String> lore = new ArrayList<String>();
                                lore.add("§aLevel: " + args[0]);
                                lore.add("§aUse para ter o Exp de volta!");
                                meta.setLore(lore);
                                exppot.setItemMeta(meta);
                                p.getInventory().addItem(exppot);
                                p.setLevel(lvl - solicitado);
                            }
                        }else{
                            sender.sendMessage("§cVocê não tem Exp suficiente.");
                        }
                    }else{
                        sender.sendMessage("§cSomente números.");
                    }
                }
            } else {
                p.sendMessage("§cVocê deve ter pelo menos 1 level de Exp.");
            }
        }
        return false;
    }
}
