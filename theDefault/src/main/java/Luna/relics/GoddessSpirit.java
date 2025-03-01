package Luna.relics;

import Luna.orbs.*;
import Luna.powers.Stances.SlashPower;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.relics.OnChannelRelic;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import Luna.ShinyMoonBase;
import Luna.util.TextureLoader;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

import static Luna.ShinyMoonBase.makeRelicOutlinePath;
import static Luna.ShinyMoonBase.makeRelicPath;

public class GoddessSpirit extends CustomRelic implements OnChannelRelic {

    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     *
     * whenever you enter a new stance of that turn, draw a card
     */

    // ID, images, text.
    public static final String ID = ShinyMoonBase.makeID("GoddessSpirit");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("placeholder_relic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"));

    public GoddessSpirit() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.MAGICAL);
    }

    public boolean SlashDraw = true;
    public boolean EngardeDraw = true;
    public boolean ParryDraw = true;
    public boolean PierceDraw = true;
    public boolean AceDraw = true;

    // Flash at the start of Battle.
    @Override
    public void atBattleStartPreDraw() {

        SlashDraw = true;
        EngardeDraw = true;
        ParryDraw = true;
        PierceDraw = true;
        AceDraw = true;
    }

    @Override
    public void atTurnStart() {
flash();

        SlashDraw = true;
        EngardeDraw = true;
        ParryDraw = true;
        PierceDraw = true;
        AceDraw = true;
    }
/*
    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        System.out.println("_------------------------------------_");
        System.out.println("_------------------------------------_");
        System.out.println(targetCard + " is played.");
        System.out.println("_------------------------------------_");
        System.out.println("_------------------------------------_");
        System.out.println();


                    ////////////////////////
        System.out.println("checking if " + targetCard + " is changing stance into SLASH....");
        System.out.println();
        System.out.print("checking if " + AbstractDungeon.player + " has SLASH.... | ");
        System.out.println(AbstractDungeon.player.hasPower(SlashPower.POWER_ID));
        System.out.println();
        System.out.print("checking if " + targetCard + " has SLASH tag.... | ");
        System.out.println(targetCard.hasTag(ShinyMoonBase.changeSLASH));
        System.out.println();
        System.out.print("checking if " + targetCard + " has can draw from SLASH.... | ");
        System.out.println(SlashDraw);
        System.out.println("_------------------------------------_");
        System.out.println("-.-.-.-CHECK DONE-.-.-.-");
        System.out.println("_------------------------------------_");
        System.out.println();
                                        //////////////

////////////////////
        if ((targetCard.hasTag(ShinyMoonBase.changeSLASH) || AbstractDungeon.player.hasPower(SlashPower.POWER_ID) ) && SlashDraw) {

            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
            SlashDraw = false;
        }
/////////////////////

                            /////////////////////
        System.out.println("checking if " + targetCard + " is changing stance into ENGARDE....");
        System.out.println();
        System.out.print("checking if " + targetCard + " has ENGARDE tag.... | ");
        System.out.println(targetCard.hasTag(ShinyMoonBase.changeENGARDE));
        System.out.println();
        System.out.print("checking if " + targetCard + " has can draw from ENGARDE.... | ");
        System.out.println(EngardeDraw);
        System.out.println("_------------------------------------_");
        System.out.println("-.-.-.-CHECK DONE-.-.-.-");
        System.out.println("_------------------------------------_");
        System.out.println();
                                ///////////////////
////////////
        if (targetCard.hasTag(ShinyMoonBase.changeENGARDE) && EngardeDraw) {

            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
            EngardeDraw = false;
        }
//////////

                                    /////////////////
        System.out.println("checking if " + targetCard + " is changing stance into PARRY....");
        System.out.println();
        System.out.print("checking if " + targetCard + " has PARRY tag.... | ");
        System.out.println(targetCard.hasTag(ShinyMoonBase.changePARRY));
        System.out.println();
        System.out.print("checking if " + targetCard + " has can draw from PARRY.... | ");
        System.out.println(ParryDraw);
        System.out.println("_------------------------------------_");
        System.out.println("-.-.-.-CHECK DONE-.-.-.-");
        System.out.println("_------------------------------------_");
        System.out.println();
                                ///////////////

////////////
        if (targetCard.hasTag(ShinyMoonBase.changePARRY) && ParryDraw) {

            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
            ParryDraw = false;
        }
/////////////

                                /////////////////
        System.out.println("checking if " + targetCard + " is changing stance into PIERCE....");
        System.out.println();
        System.out.print("checking if " + targetCard + " has PIERCE tag.... | ");
        System.out.println(targetCard.hasTag(ShinyMoonBase.changePIERCE));
        System.out.println();
        System.out.print("checking if " + targetCard + " has can draw from PIERCE.... | ");
        System.out.println(PierceDraw);
        System.out.println("_------------------------------------_");
        System.out.println("-.-.-.-CHECK DONE-.-.-.-");
                        ////////////////


        if (targetCard.hasTag(ShinyMoonBase.changePIERCE) && PierceDraw) {

            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
            PierceDraw = false;
        }

                             //////////
        System.out.println("checking if " + targetCard + " is changing stance into ACE....");
        System.out.println();
        System.out.print("checking if " + targetCard + " has ACE tag.... | ");
        System.out.println(targetCard.hasTag(ShinyMoonBase.changeACE));
        System.out.println();
        System.out.print("checking if " + targetCard + " has can draw from ACE.... | ");
        System.out.println(AceDraw);
        System.out.println("_------------------------------------_");
        System.out.println("-.-.-.-CHECK DONE-.-.-.-");
        System.out.println("_------------------------------------_");
        System.out.println();
                             /////////

////////////
        if (targetCard.hasTag(ShinyMoonBase.changeACE) && AceDraw) {

            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
            AceDraw = false;
        }
////////////////

        System.out.println("_DONE CHECKING " + targetCard + "_");
    }
*/

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void onChannel(AbstractOrb orb) {
        if(orb.ID == SlashOrb.ORB_ID || orb.ID == EngardeOrb.ORB_ID ||
                orb.ID == ParryOrb.ORB_ID || orb.ID == PierceOrb.ORB_ID ||
                orb.ID == AceOrb.ORB_ID ){

            if (orb.ID.equals("SlashStance")){flash();
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
                SlashDraw = false;}
            if (orb.ID.equals("EngardeStance")){flash();
                AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
                EngardeDraw = false;}
            if (orb.ID.equals("ParryStance")){flash();
                AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
                ParryDraw = false;}
            if (orb.ID.equals("PierceStance")){flash();
                AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
                PierceDraw = false;}
            if (orb.ID.equals("AceStance")){flash();
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
                AceDraw = false;}
        }
    }
}
