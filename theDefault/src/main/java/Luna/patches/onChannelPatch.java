package Luna.patches;


import Luna.interfaces.OnChannelOrb;
import com.evacipated.cardcrawl.mod.stslib.relics.OnChannelRelic;

import com.evacipated.cardcrawl.modthespire.lib.*;

import com.megacrit.cardcrawl.actions.GameActionManager;

import com.megacrit.cardcrawl.characters.AbstractPlayer;

import com.megacrit.cardcrawl.orbs.AbstractOrb;


import javassist.CtBehavior;



@SpirePatch(

        clz=AbstractPlayer.class,

        method="channelOrb"

)

public class onChannelPatch
{

    @SpireInsertPatch(

            locator=Locator.class

    )

    public static void Insert(AbstractPlayer __intance, AbstractOrb orbToSet)

    {

        for (AbstractOrb orb : __intance.orbs) {

            if (orb instanceof OnChannelOrb) {

                ((OnChannelOrb)orb).onChannel(orbToSet);

            }

        }

    }



    private static class Locator extends SpireInsertLocator

    {

        @Override

        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception

        {

            Matcher finalMatcher = new Matcher.FieldAccessMatcher(GameActionManager.class, "orbsChanneledThisCombat");

            return LineFinder.findInOrder(ctMethodToPatch, finalMatcher);

        }

    }

}