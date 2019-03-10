package Luna.actions;

import Luna.orbs.*;
import Luna.powers.CommonPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.ChemicalX;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

public class ChangeStanceAction extends AbstractGameAction {

    private AbstractPlayer p;
    private AbstractOrb o;
private int baseStacks;
    public ChangeStanceAction(AbstractOrb newOrb, int baseStacks)

    {
this.o = newOrb;
        this.p = p;
        this.baseStacks = baseStacks;
    }

    @Override
    public void update() {

        if((this.o.ID.contains("Stance") || this.o.name.contains("Stance")) && !(AbstractDungeon.player.orbs.get(0).ID == this.o.ID)){
            int stacks = AbstractDungeon.player.orbs.get(0).passiveAmount + baseStacks;

          //  AbstractDungeon.actionManager.addToBottom(new EvokeOrbAction(1));
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(this.o));

            this.o.passiveAmount += stacks;

                if (this.o.ID.equals(SlashOrb.ORB_ID)){
                AbstractDungeon.actionManager.addToBottom(
                        new ApplyPowerAction(p, p, new StrengthPower( p, 2), 2));

                AbstractDungeon.actionManager.addToBottom(
                        new ApplyPowerAction(p, p, new DexterityPower( p, -1), -1));
            }//////////////
                if (this.o.ID.equals(EngardeOrb.ORB_ID)){
                AbstractDungeon.actionManager.addToBottom(
                        new ApplyPowerAction(p, p, new DexterityPower( p, 2), 2));

                AbstractDungeon.actionManager.addToBottom(
                        new ApplyPowerAction(p, p, new StrengthPower( p, -1), -1));
            }/////////////
            if (this.o.ID.equals("ParryStance")){

            }////////////
            if (this.o.ID.equals("PierceStance")){

            }////////////
            if (this.o.ID.equals("AceStance")){

            }////////////

            this.o.update();
        }else if((this.o.ID.contains("Stance") || this.o.name.contains("Stance")) && (AbstractDungeon.player.orbs.get(0).ID == this.o.ID)){
            AbstractDungeon.player.orbs.get(0).passiveAmount += baseStacks;
        }
        
        isDone = true;
    }
}
