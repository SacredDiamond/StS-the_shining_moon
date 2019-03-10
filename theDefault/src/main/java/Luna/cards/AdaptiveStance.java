package Luna.cards;

import Luna.ShinyMoonBase;
import Luna.actions.ChangeStanceAction;
import Luna.characters.Luna;
import Luna.orbs.EngardeOrb;
import Luna.orbs.SlashOrb;
import Luna.powers.Stances.EngardePower;
import Luna.powers.Stances.ParryPower;
import Luna.powers.Stances.SlashPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import  Luna.actions.ChooseAction;
import static Luna.ShinyMoonBase.makeCardPath;

public class AdaptiveStance extends CustomCard {

    /*
     * Wiki-page: https://github.com/daviscook477/BaseMod/wiki/Custom-Cards
     *
     * Hold Place Gain 1(2) Keywords(s).
     */


    // TEXT DECLARATION

    public static final String ID = ShinyMoonBase.makeID("Adaptive");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("Skill.png");

    public static final String NAME = cardStrings.NAME;

    public static final String upgrade = cardStrings.UPGRADE_DESCRIPTION;
    public static final String[] extend = cardStrings.EXTENDED_DESCRIPTION;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = Luna.Enums.Luna_color;

    private static final int COST = 0;
    private static final int MAGIC = 1;
    private static final int DAM = 3;

    // Hey want a second magic/damage/block/unique number??? Great!
    // Go check out DefaultAttackWithVariable and Luna.variable.DefaultCustomVariable
    // that's how you get your own custom variable that you can use for anything you like.
    // Feel free to explore other mods to see what variabls they personally have and create your own ones.

    // /STAT DECLARATION/


    public AdaptiveStance() {
        super(ID, NAME, IMG, COST, DESCRIPTION+ extend[0], TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = MAGIC;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        ChooseAction choice = new ChooseAction(this, p, extend[2]);

        choice.add(extend[3], extend[4], () -> {
            tags.add(ShinyMoonBase.changeSLASH);
            AbstractDungeon.actionManager.addToBottom(new ChangeStanceAction(new SlashOrb(), magicNumber));
        });

        choice.add(extend[5], extend[6], () -> {
            tags.add(ShinyMoonBase.changeENGARDE);
            AbstractDungeon.actionManager.addToBottom(new ChangeStanceAction(new EngardeOrb(), magicNumber));
        });
if(upgraded){
        choice.add(extend[7], extend[8], () -> {
            tags.add(ShinyMoonBase.changePARRY);
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                    new ParryPower(p, p, magicNumber), magicNumber));
        });}

               /**/         AbstractDungeon.actionManager.addToBottom(choice);    /**/
    }

    @Override
    public void applyPowers(){
        super.applyPowers();

        if(magicNumber>1) {

            if(upgraded){
                this.rawDescription = upgrade;
            }else{
                this.rawDescription = DESCRIPTION;
            }
            this.rawDescription += AdaptiveStance.extend[1];
        }else {

            if(upgraded){
                this.rawDescription = upgrade;
            }else{
                this.rawDescription = DESCRIPTION;
            }
            this.rawDescription += AdaptiveStance.extend[0];
        }

        this.initializeDescription();
    }

    //Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.rawDescription = upgrade + extend[1];
            upgradeMagicNumber(1);
            initializeDescription();
        }
    }
}