package com.massivecraft.factions.cmd.points;

import com.massivecraft.factions.FactionsPlugin;
import com.massivecraft.factions.cmd.CommandContext;
import com.massivecraft.factions.cmd.CommandRequirements;
import com.massivecraft.factions.cmd.FCommand;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdPoints extends FCommand {

     public CmdPointsRemove cmdPointsRemove = new CmdPointsRemove();
     public CmdPointsSet cmdPointsSet = new CmdPointsSet();
     public CmdPointsAdd cmdPointsAdd = new CmdPointsAdd();

     public CmdPoints() {
          super();
          this.aliases.add("points");

          this.requirements = new CommandRequirements.Builder(Permission.POINTS)
                  .playerOnly()
                  .build();


          this.addSubCommand(this.cmdPointsAdd);
          this.addSubCommand(this.cmdPointsRemove);
          this.addSubCommand(this.cmdPointsSet);
     }


     @Override
     public void perform(CommandContext context) {
          if (!FactionsPlugin.getInstance().getConfig().getBoolean("f-points.Enabled", true)) {
               context.msg(TL.GENERIC_DISABLED);
               return;
          }
          context.commandChain.add(this);
          FactionsPlugin.getInstance().cmdAutoHelp.execute(context);
     }

     @Override
     public TL getUsageTranslation() {
          return TL.COMMAND_POINTS_DESCRIPTION;
     }


}
