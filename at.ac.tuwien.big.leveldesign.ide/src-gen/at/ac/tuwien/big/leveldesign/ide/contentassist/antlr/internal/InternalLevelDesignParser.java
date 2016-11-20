package at.ac.tuwien.big.leveldesign.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import at.ac.tuwien.big.leveldesign.services.LevelDesignGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLevelDesignParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_DOUBLE", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spawn'", "'=>'", "'goal'", "'room'", "'{'", "'columns'", "'='", "'rows'", "'}'", "'monster'", "'@'", "'hp'", "'damage'", "'speed'", "'range'", "'aggroradius'", "'trapdoor'", "'wall'", "'from'", "'to'", "'entry'", "'exit'", "'('", "','", "')'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=7;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalLevelDesignParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLevelDesignParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLevelDesignParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLevelDesign.g"; }


    	private LevelDesignGrammarAccess grammarAccess;

    	public void setGrammarAccess(LevelDesignGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleLevel"
    // InternalLevelDesign.g:53:1: entryRuleLevel : ruleLevel EOF ;
    public final void entryRuleLevel() throws RecognitionException {
        try {
            // InternalLevelDesign.g:54:1: ( ruleLevel EOF )
            // InternalLevelDesign.g:55:1: ruleLevel EOF
            {
             before(grammarAccess.getLevelRule()); 
            pushFollow(FOLLOW_1);
            ruleLevel();

            state._fsp--;

             after(grammarAccess.getLevelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLevel"


    // $ANTLR start "ruleLevel"
    // InternalLevelDesign.g:62:1: ruleLevel : ( ( rule__Level__Group__0 ) ) ;
    public final void ruleLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:66:2: ( ( ( rule__Level__Group__0 ) ) )
            // InternalLevelDesign.g:67:2: ( ( rule__Level__Group__0 ) )
            {
            // InternalLevelDesign.g:67:2: ( ( rule__Level__Group__0 ) )
            // InternalLevelDesign.g:68:3: ( rule__Level__Group__0 )
            {
             before(grammarAccess.getLevelAccess().getGroup()); 
            // InternalLevelDesign.g:69:3: ( rule__Level__Group__0 )
            // InternalLevelDesign.g:69:4: rule__Level__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLevel"


    // $ANTLR start "entryRuleRoom"
    // InternalLevelDesign.g:78:1: entryRuleRoom : ruleRoom EOF ;
    public final void entryRuleRoom() throws RecognitionException {
        try {
            // InternalLevelDesign.g:79:1: ( ruleRoom EOF )
            // InternalLevelDesign.g:80:1: ruleRoom EOF
            {
             before(grammarAccess.getRoomRule()); 
            pushFollow(FOLLOW_1);
            ruleRoom();

            state._fsp--;

             after(grammarAccess.getRoomRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRoom"


    // $ANTLR start "ruleRoom"
    // InternalLevelDesign.g:87:1: ruleRoom : ( ( rule__Room__Group__0 ) ) ;
    public final void ruleRoom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:91:2: ( ( ( rule__Room__Group__0 ) ) )
            // InternalLevelDesign.g:92:2: ( ( rule__Room__Group__0 ) )
            {
            // InternalLevelDesign.g:92:2: ( ( rule__Room__Group__0 ) )
            // InternalLevelDesign.g:93:3: ( rule__Room__Group__0 )
            {
             before(grammarAccess.getRoomAccess().getGroup()); 
            // InternalLevelDesign.g:94:3: ( rule__Room__Group__0 )
            // InternalLevelDesign.g:94:4: rule__Room__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Room__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRoomAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRoom"


    // $ANTLR start "entryRuleConnection"
    // InternalLevelDesign.g:103:1: entryRuleConnection : ruleConnection EOF ;
    public final void entryRuleConnection() throws RecognitionException {
        try {
            // InternalLevelDesign.g:104:1: ( ruleConnection EOF )
            // InternalLevelDesign.g:105:1: ruleConnection EOF
            {
             before(grammarAccess.getConnectionRule()); 
            pushFollow(FOLLOW_1);
            ruleConnection();

            state._fsp--;

             after(grammarAccess.getConnectionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConnection"


    // $ANTLR start "ruleConnection"
    // InternalLevelDesign.g:112:1: ruleConnection : ( ( rule__Connection__Group__0 ) ) ;
    public final void ruleConnection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:116:2: ( ( ( rule__Connection__Group__0 ) ) )
            // InternalLevelDesign.g:117:2: ( ( rule__Connection__Group__0 ) )
            {
            // InternalLevelDesign.g:117:2: ( ( rule__Connection__Group__0 ) )
            // InternalLevelDesign.g:118:3: ( rule__Connection__Group__0 )
            {
             before(grammarAccess.getConnectionAccess().getGroup()); 
            // InternalLevelDesign.g:119:3: ( rule__Connection__Group__0 )
            // InternalLevelDesign.g:119:4: rule__Connection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Connection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConnectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConnection"


    // $ANTLR start "entryRuleMonster"
    // InternalLevelDesign.g:128:1: entryRuleMonster : ruleMonster EOF ;
    public final void entryRuleMonster() throws RecognitionException {
        try {
            // InternalLevelDesign.g:129:1: ( ruleMonster EOF )
            // InternalLevelDesign.g:130:1: ruleMonster EOF
            {
             before(grammarAccess.getMonsterRule()); 
            pushFollow(FOLLOW_1);
            ruleMonster();

            state._fsp--;

             after(grammarAccess.getMonsterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMonster"


    // $ANTLR start "ruleMonster"
    // InternalLevelDesign.g:137:1: ruleMonster : ( ( rule__Monster__Group__0 ) ) ;
    public final void ruleMonster() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:141:2: ( ( ( rule__Monster__Group__0 ) ) )
            // InternalLevelDesign.g:142:2: ( ( rule__Monster__Group__0 ) )
            {
            // InternalLevelDesign.g:142:2: ( ( rule__Monster__Group__0 ) )
            // InternalLevelDesign.g:143:3: ( rule__Monster__Group__0 )
            {
             before(grammarAccess.getMonsterAccess().getGroup()); 
            // InternalLevelDesign.g:144:3: ( rule__Monster__Group__0 )
            // InternalLevelDesign.g:144:4: rule__Monster__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Monster__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMonster"


    // $ANTLR start "entryRuleTrapdoor"
    // InternalLevelDesign.g:153:1: entryRuleTrapdoor : ruleTrapdoor EOF ;
    public final void entryRuleTrapdoor() throws RecognitionException {
        try {
            // InternalLevelDesign.g:154:1: ( ruleTrapdoor EOF )
            // InternalLevelDesign.g:155:1: ruleTrapdoor EOF
            {
             before(grammarAccess.getTrapdoorRule()); 
            pushFollow(FOLLOW_1);
            ruleTrapdoor();

            state._fsp--;

             after(grammarAccess.getTrapdoorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrapdoor"


    // $ANTLR start "ruleTrapdoor"
    // InternalLevelDesign.g:162:1: ruleTrapdoor : ( ( rule__Trapdoor__Group__0 ) ) ;
    public final void ruleTrapdoor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:166:2: ( ( ( rule__Trapdoor__Group__0 ) ) )
            // InternalLevelDesign.g:167:2: ( ( rule__Trapdoor__Group__0 ) )
            {
            // InternalLevelDesign.g:167:2: ( ( rule__Trapdoor__Group__0 ) )
            // InternalLevelDesign.g:168:3: ( rule__Trapdoor__Group__0 )
            {
             before(grammarAccess.getTrapdoorAccess().getGroup()); 
            // InternalLevelDesign.g:169:3: ( rule__Trapdoor__Group__0 )
            // InternalLevelDesign.g:169:4: rule__Trapdoor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Trapdoor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrapdoorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrapdoor"


    // $ANTLR start "entryRuleWall"
    // InternalLevelDesign.g:178:1: entryRuleWall : ruleWall EOF ;
    public final void entryRuleWall() throws RecognitionException {
        try {
            // InternalLevelDesign.g:179:1: ( ruleWall EOF )
            // InternalLevelDesign.g:180:1: ruleWall EOF
            {
             before(grammarAccess.getWallRule()); 
            pushFollow(FOLLOW_1);
            ruleWall();

            state._fsp--;

             after(grammarAccess.getWallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWall"


    // $ANTLR start "ruleWall"
    // InternalLevelDesign.g:187:1: ruleWall : ( ( rule__Wall__Group__0 ) ) ;
    public final void ruleWall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:191:2: ( ( ( rule__Wall__Group__0 ) ) )
            // InternalLevelDesign.g:192:2: ( ( rule__Wall__Group__0 ) )
            {
            // InternalLevelDesign.g:192:2: ( ( rule__Wall__Group__0 ) )
            // InternalLevelDesign.g:193:3: ( rule__Wall__Group__0 )
            {
             before(grammarAccess.getWallAccess().getGroup()); 
            // InternalLevelDesign.g:194:3: ( rule__Wall__Group__0 )
            // InternalLevelDesign.g:194:4: rule__Wall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Wall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWall"


    // $ANTLR start "entryRuleEntry"
    // InternalLevelDesign.g:203:1: entryRuleEntry : ruleEntry EOF ;
    public final void entryRuleEntry() throws RecognitionException {
        try {
            // InternalLevelDesign.g:204:1: ( ruleEntry EOF )
            // InternalLevelDesign.g:205:1: ruleEntry EOF
            {
             before(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getEntryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalLevelDesign.g:212:1: ruleEntry : ( ( rule__Entry__Group__0 ) ) ;
    public final void ruleEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:216:2: ( ( ( rule__Entry__Group__0 ) ) )
            // InternalLevelDesign.g:217:2: ( ( rule__Entry__Group__0 ) )
            {
            // InternalLevelDesign.g:217:2: ( ( rule__Entry__Group__0 ) )
            // InternalLevelDesign.g:218:3: ( rule__Entry__Group__0 )
            {
             before(grammarAccess.getEntryAccess().getGroup()); 
            // InternalLevelDesign.g:219:3: ( rule__Entry__Group__0 )
            // InternalLevelDesign.g:219:4: rule__Entry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleExit"
    // InternalLevelDesign.g:228:1: entryRuleExit : ruleExit EOF ;
    public final void entryRuleExit() throws RecognitionException {
        try {
            // InternalLevelDesign.g:229:1: ( ruleExit EOF )
            // InternalLevelDesign.g:230:1: ruleExit EOF
            {
             before(grammarAccess.getExitRule()); 
            pushFollow(FOLLOW_1);
            ruleExit();

            state._fsp--;

             after(grammarAccess.getExitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExit"


    // $ANTLR start "ruleExit"
    // InternalLevelDesign.g:237:1: ruleExit : ( ( rule__Exit__Group__0 ) ) ;
    public final void ruleExit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:241:2: ( ( ( rule__Exit__Group__0 ) ) )
            // InternalLevelDesign.g:242:2: ( ( rule__Exit__Group__0 ) )
            {
            // InternalLevelDesign.g:242:2: ( ( rule__Exit__Group__0 ) )
            // InternalLevelDesign.g:243:3: ( rule__Exit__Group__0 )
            {
             before(grammarAccess.getExitAccess().getGroup()); 
            // InternalLevelDesign.g:244:3: ( rule__Exit__Group__0 )
            // InternalLevelDesign.g:244:4: rule__Exit__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Exit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExitAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExit"


    // $ANTLR start "entryRuleCoordinate"
    // InternalLevelDesign.g:253:1: entryRuleCoordinate : ruleCoordinate EOF ;
    public final void entryRuleCoordinate() throws RecognitionException {
        try {
            // InternalLevelDesign.g:254:1: ( ruleCoordinate EOF )
            // InternalLevelDesign.g:255:1: ruleCoordinate EOF
            {
             before(grammarAccess.getCoordinateRule()); 
            pushFollow(FOLLOW_1);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getCoordinateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCoordinate"


    // $ANTLR start "ruleCoordinate"
    // InternalLevelDesign.g:262:1: ruleCoordinate : ( ( rule__Coordinate__Alternatives ) ) ;
    public final void ruleCoordinate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:266:2: ( ( ( rule__Coordinate__Alternatives ) ) )
            // InternalLevelDesign.g:267:2: ( ( rule__Coordinate__Alternatives ) )
            {
            // InternalLevelDesign.g:267:2: ( ( rule__Coordinate__Alternatives ) )
            // InternalLevelDesign.g:268:3: ( rule__Coordinate__Alternatives )
            {
             before(grammarAccess.getCoordinateAccess().getAlternatives()); 
            // InternalLevelDesign.g:269:3: ( rule__Coordinate__Alternatives )
            // InternalLevelDesign.g:269:4: rule__Coordinate__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCoordinateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCoordinate"


    // $ANTLR start "rule__Coordinate__Alternatives"
    // InternalLevelDesign.g:277:1: rule__Coordinate__Alternatives : ( ( ( rule__Coordinate__Group_0__0 ) ) | ( ( rule__Coordinate__Group_1__0 ) ) );
    public final void rule__Coordinate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:281:1: ( ( ( rule__Coordinate__Group_0__0 ) ) | ( ( rule__Coordinate__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==34) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_INT) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalLevelDesign.g:282:2: ( ( rule__Coordinate__Group_0__0 ) )
                    {
                    // InternalLevelDesign.g:282:2: ( ( rule__Coordinate__Group_0__0 ) )
                    // InternalLevelDesign.g:283:3: ( rule__Coordinate__Group_0__0 )
                    {
                     before(grammarAccess.getCoordinateAccess().getGroup_0()); 
                    // InternalLevelDesign.g:284:3: ( rule__Coordinate__Group_0__0 )
                    // InternalLevelDesign.g:284:4: rule__Coordinate__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Coordinate__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCoordinateAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLevelDesign.g:288:2: ( ( rule__Coordinate__Group_1__0 ) )
                    {
                    // InternalLevelDesign.g:288:2: ( ( rule__Coordinate__Group_1__0 ) )
                    // InternalLevelDesign.g:289:3: ( rule__Coordinate__Group_1__0 )
                    {
                     before(grammarAccess.getCoordinateAccess().getGroup_1()); 
                    // InternalLevelDesign.g:290:3: ( rule__Coordinate__Group_1__0 )
                    // InternalLevelDesign.g:290:4: rule__Coordinate__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Coordinate__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCoordinateAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Alternatives"


    // $ANTLR start "rule__Level__Group__0"
    // InternalLevelDesign.g:298:1: rule__Level__Group__0 : rule__Level__Group__0__Impl rule__Level__Group__1 ;
    public final void rule__Level__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:302:1: ( rule__Level__Group__0__Impl rule__Level__Group__1 )
            // InternalLevelDesign.g:303:2: rule__Level__Group__0__Impl rule__Level__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Level__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__0"


    // $ANTLR start "rule__Level__Group__0__Impl"
    // InternalLevelDesign.g:310:1: rule__Level__Group__0__Impl : ( 'spawn' ) ;
    public final void rule__Level__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:314:1: ( ( 'spawn' ) )
            // InternalLevelDesign.g:315:1: ( 'spawn' )
            {
            // InternalLevelDesign.g:315:1: ( 'spawn' )
            // InternalLevelDesign.g:316:2: 'spawn'
            {
             before(grammarAccess.getLevelAccess().getSpawnKeyword_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getSpawnKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__0__Impl"


    // $ANTLR start "rule__Level__Group__1"
    // InternalLevelDesign.g:325:1: rule__Level__Group__1 : rule__Level__Group__1__Impl rule__Level__Group__2 ;
    public final void rule__Level__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:329:1: ( rule__Level__Group__1__Impl rule__Level__Group__2 )
            // InternalLevelDesign.g:330:2: rule__Level__Group__1__Impl rule__Level__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Level__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__1"


    // $ANTLR start "rule__Level__Group__1__Impl"
    // InternalLevelDesign.g:337:1: rule__Level__Group__1__Impl : ( '=>' ) ;
    public final void rule__Level__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:341:1: ( ( '=>' ) )
            // InternalLevelDesign.g:342:1: ( '=>' )
            {
            // InternalLevelDesign.g:342:1: ( '=>' )
            // InternalLevelDesign.g:343:2: '=>'
            {
             before(grammarAccess.getLevelAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__1__Impl"


    // $ANTLR start "rule__Level__Group__2"
    // InternalLevelDesign.g:352:1: rule__Level__Group__2 : rule__Level__Group__2__Impl rule__Level__Group__3 ;
    public final void rule__Level__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:356:1: ( rule__Level__Group__2__Impl rule__Level__Group__3 )
            // InternalLevelDesign.g:357:2: rule__Level__Group__2__Impl rule__Level__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__2"


    // $ANTLR start "rule__Level__Group__2__Impl"
    // InternalLevelDesign.g:364:1: rule__Level__Group__2__Impl : ( ( rule__Level__SpawnRoomAssignment_2 ) ) ;
    public final void rule__Level__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:368:1: ( ( ( rule__Level__SpawnRoomAssignment_2 ) ) )
            // InternalLevelDesign.g:369:1: ( ( rule__Level__SpawnRoomAssignment_2 ) )
            {
            // InternalLevelDesign.g:369:1: ( ( rule__Level__SpawnRoomAssignment_2 ) )
            // InternalLevelDesign.g:370:2: ( rule__Level__SpawnRoomAssignment_2 )
            {
             before(grammarAccess.getLevelAccess().getSpawnRoomAssignment_2()); 
            // InternalLevelDesign.g:371:2: ( rule__Level__SpawnRoomAssignment_2 )
            // InternalLevelDesign.g:371:3: rule__Level__SpawnRoomAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__SpawnRoomAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getSpawnRoomAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__2__Impl"


    // $ANTLR start "rule__Level__Group__3"
    // InternalLevelDesign.g:379:1: rule__Level__Group__3 : rule__Level__Group__3__Impl rule__Level__Group__4 ;
    public final void rule__Level__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:383:1: ( rule__Level__Group__3__Impl rule__Level__Group__4 )
            // InternalLevelDesign.g:384:2: rule__Level__Group__3__Impl rule__Level__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Level__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__3"


    // $ANTLR start "rule__Level__Group__3__Impl"
    // InternalLevelDesign.g:391:1: rule__Level__Group__3__Impl : ( 'goal' ) ;
    public final void rule__Level__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:395:1: ( ( 'goal' ) )
            // InternalLevelDesign.g:396:1: ( 'goal' )
            {
            // InternalLevelDesign.g:396:1: ( 'goal' )
            // InternalLevelDesign.g:397:2: 'goal'
            {
             before(grammarAccess.getLevelAccess().getGoalKeyword_3()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getGoalKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__3__Impl"


    // $ANTLR start "rule__Level__Group__4"
    // InternalLevelDesign.g:406:1: rule__Level__Group__4 : rule__Level__Group__4__Impl rule__Level__Group__5 ;
    public final void rule__Level__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:410:1: ( rule__Level__Group__4__Impl rule__Level__Group__5 )
            // InternalLevelDesign.g:411:2: rule__Level__Group__4__Impl rule__Level__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Level__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__4"


    // $ANTLR start "rule__Level__Group__4__Impl"
    // InternalLevelDesign.g:418:1: rule__Level__Group__4__Impl : ( '=>' ) ;
    public final void rule__Level__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:422:1: ( ( '=>' ) )
            // InternalLevelDesign.g:423:1: ( '=>' )
            {
            // InternalLevelDesign.g:423:1: ( '=>' )
            // InternalLevelDesign.g:424:2: '=>'
            {
             before(grammarAccess.getLevelAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__4__Impl"


    // $ANTLR start "rule__Level__Group__5"
    // InternalLevelDesign.g:433:1: rule__Level__Group__5 : rule__Level__Group__5__Impl rule__Level__Group__6 ;
    public final void rule__Level__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:437:1: ( rule__Level__Group__5__Impl rule__Level__Group__6 )
            // InternalLevelDesign.g:438:2: rule__Level__Group__5__Impl rule__Level__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__Level__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__5"


    // $ANTLR start "rule__Level__Group__5__Impl"
    // InternalLevelDesign.g:445:1: rule__Level__Group__5__Impl : ( ( rule__Level__GoalRoomAssignment_5 ) ) ;
    public final void rule__Level__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:449:1: ( ( ( rule__Level__GoalRoomAssignment_5 ) ) )
            // InternalLevelDesign.g:450:1: ( ( rule__Level__GoalRoomAssignment_5 ) )
            {
            // InternalLevelDesign.g:450:1: ( ( rule__Level__GoalRoomAssignment_5 ) )
            // InternalLevelDesign.g:451:2: ( rule__Level__GoalRoomAssignment_5 )
            {
             before(grammarAccess.getLevelAccess().getGoalRoomAssignment_5()); 
            // InternalLevelDesign.g:452:2: ( rule__Level__GoalRoomAssignment_5 )
            // InternalLevelDesign.g:452:3: rule__Level__GoalRoomAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Level__GoalRoomAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getGoalRoomAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__5__Impl"


    // $ANTLR start "rule__Level__Group__6"
    // InternalLevelDesign.g:460:1: rule__Level__Group__6 : rule__Level__Group__6__Impl ;
    public final void rule__Level__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:464:1: ( rule__Level__Group__6__Impl )
            // InternalLevelDesign.g:465:2: rule__Level__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__6"


    // $ANTLR start "rule__Level__Group__6__Impl"
    // InternalLevelDesign.g:471:1: rule__Level__Group__6__Impl : ( ( ( rule__Level__RoomsAssignment_6 ) ) ( ( rule__Level__RoomsAssignment_6 )* ) ) ;
    public final void rule__Level__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:475:1: ( ( ( ( rule__Level__RoomsAssignment_6 ) ) ( ( rule__Level__RoomsAssignment_6 )* ) ) )
            // InternalLevelDesign.g:476:1: ( ( ( rule__Level__RoomsAssignment_6 ) ) ( ( rule__Level__RoomsAssignment_6 )* ) )
            {
            // InternalLevelDesign.g:476:1: ( ( ( rule__Level__RoomsAssignment_6 ) ) ( ( rule__Level__RoomsAssignment_6 )* ) )
            // InternalLevelDesign.g:477:2: ( ( rule__Level__RoomsAssignment_6 ) ) ( ( rule__Level__RoomsAssignment_6 )* )
            {
            // InternalLevelDesign.g:477:2: ( ( rule__Level__RoomsAssignment_6 ) )
            // InternalLevelDesign.g:478:3: ( rule__Level__RoomsAssignment_6 )
            {
             before(grammarAccess.getLevelAccess().getRoomsAssignment_6()); 
            // InternalLevelDesign.g:479:3: ( rule__Level__RoomsAssignment_6 )
            // InternalLevelDesign.g:479:4: rule__Level__RoomsAssignment_6
            {
            pushFollow(FOLLOW_7);
            rule__Level__RoomsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getRoomsAssignment_6()); 

            }

            // InternalLevelDesign.g:482:2: ( ( rule__Level__RoomsAssignment_6 )* )
            // InternalLevelDesign.g:483:3: ( rule__Level__RoomsAssignment_6 )*
            {
             before(grammarAccess.getLevelAccess().getRoomsAssignment_6()); 
            // InternalLevelDesign.g:484:3: ( rule__Level__RoomsAssignment_6 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLevelDesign.g:484:4: rule__Level__RoomsAssignment_6
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Level__RoomsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getLevelAccess().getRoomsAssignment_6()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__6__Impl"


    // $ANTLR start "rule__Room__Group__0"
    // InternalLevelDesign.g:494:1: rule__Room__Group__0 : rule__Room__Group__0__Impl rule__Room__Group__1 ;
    public final void rule__Room__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:498:1: ( rule__Room__Group__0__Impl rule__Room__Group__1 )
            // InternalLevelDesign.g:499:2: rule__Room__Group__0__Impl rule__Room__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Room__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__0"


    // $ANTLR start "rule__Room__Group__0__Impl"
    // InternalLevelDesign.g:506:1: rule__Room__Group__0__Impl : ( 'room' ) ;
    public final void rule__Room__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:510:1: ( ( 'room' ) )
            // InternalLevelDesign.g:511:1: ( 'room' )
            {
            // InternalLevelDesign.g:511:1: ( 'room' )
            // InternalLevelDesign.g:512:2: 'room'
            {
             before(grammarAccess.getRoomAccess().getRoomKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getRoomKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__0__Impl"


    // $ANTLR start "rule__Room__Group__1"
    // InternalLevelDesign.g:521:1: rule__Room__Group__1 : rule__Room__Group__1__Impl rule__Room__Group__2 ;
    public final void rule__Room__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:525:1: ( rule__Room__Group__1__Impl rule__Room__Group__2 )
            // InternalLevelDesign.g:526:2: rule__Room__Group__1__Impl rule__Room__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Room__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__1"


    // $ANTLR start "rule__Room__Group__1__Impl"
    // InternalLevelDesign.g:533:1: rule__Room__Group__1__Impl : ( ( rule__Room__NameAssignment_1 ) ) ;
    public final void rule__Room__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:537:1: ( ( ( rule__Room__NameAssignment_1 ) ) )
            // InternalLevelDesign.g:538:1: ( ( rule__Room__NameAssignment_1 ) )
            {
            // InternalLevelDesign.g:538:1: ( ( rule__Room__NameAssignment_1 ) )
            // InternalLevelDesign.g:539:2: ( rule__Room__NameAssignment_1 )
            {
             before(grammarAccess.getRoomAccess().getNameAssignment_1()); 
            // InternalLevelDesign.g:540:2: ( rule__Room__NameAssignment_1 )
            // InternalLevelDesign.g:540:3: rule__Room__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Room__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRoomAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__1__Impl"


    // $ANTLR start "rule__Room__Group__2"
    // InternalLevelDesign.g:548:1: rule__Room__Group__2 : rule__Room__Group__2__Impl rule__Room__Group__3 ;
    public final void rule__Room__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:552:1: ( rule__Room__Group__2__Impl rule__Room__Group__3 )
            // InternalLevelDesign.g:553:2: rule__Room__Group__2__Impl rule__Room__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Room__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__2"


    // $ANTLR start "rule__Room__Group__2__Impl"
    // InternalLevelDesign.g:560:1: rule__Room__Group__2__Impl : ( '{' ) ;
    public final void rule__Room__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:564:1: ( ( '{' ) )
            // InternalLevelDesign.g:565:1: ( '{' )
            {
            // InternalLevelDesign.g:565:1: ( '{' )
            // InternalLevelDesign.g:566:2: '{'
            {
             before(grammarAccess.getRoomAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__2__Impl"


    // $ANTLR start "rule__Room__Group__3"
    // InternalLevelDesign.g:575:1: rule__Room__Group__3 : rule__Room__Group__3__Impl rule__Room__Group__4 ;
    public final void rule__Room__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:579:1: ( rule__Room__Group__3__Impl rule__Room__Group__4 )
            // InternalLevelDesign.g:580:2: rule__Room__Group__3__Impl rule__Room__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Room__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__3"


    // $ANTLR start "rule__Room__Group__3__Impl"
    // InternalLevelDesign.g:587:1: rule__Room__Group__3__Impl : ( 'columns' ) ;
    public final void rule__Room__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:591:1: ( ( 'columns' ) )
            // InternalLevelDesign.g:592:1: ( 'columns' )
            {
            // InternalLevelDesign.g:592:1: ( 'columns' )
            // InternalLevelDesign.g:593:2: 'columns'
            {
             before(grammarAccess.getRoomAccess().getColumnsKeyword_3()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getColumnsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__3__Impl"


    // $ANTLR start "rule__Room__Group__4"
    // InternalLevelDesign.g:602:1: rule__Room__Group__4 : rule__Room__Group__4__Impl rule__Room__Group__5 ;
    public final void rule__Room__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:606:1: ( rule__Room__Group__4__Impl rule__Room__Group__5 )
            // InternalLevelDesign.g:607:2: rule__Room__Group__4__Impl rule__Room__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Room__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__4"


    // $ANTLR start "rule__Room__Group__4__Impl"
    // InternalLevelDesign.g:614:1: rule__Room__Group__4__Impl : ( ( '=' )? ) ;
    public final void rule__Room__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:618:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:619:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:619:1: ( ( '=' )? )
            // InternalLevelDesign.g:620:2: ( '=' )?
            {
             before(grammarAccess.getRoomAccess().getEqualsSignKeyword_4()); 
            // InternalLevelDesign.g:621:2: ( '=' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalLevelDesign.g:621:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getRoomAccess().getEqualsSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__4__Impl"


    // $ANTLR start "rule__Room__Group__5"
    // InternalLevelDesign.g:629:1: rule__Room__Group__5 : rule__Room__Group__5__Impl rule__Room__Group__6 ;
    public final void rule__Room__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:633:1: ( rule__Room__Group__5__Impl rule__Room__Group__6 )
            // InternalLevelDesign.g:634:2: rule__Room__Group__5__Impl rule__Room__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Room__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__5"


    // $ANTLR start "rule__Room__Group__5__Impl"
    // InternalLevelDesign.g:641:1: rule__Room__Group__5__Impl : ( ( rule__Room__ColumnsAssignment_5 ) ) ;
    public final void rule__Room__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:645:1: ( ( ( rule__Room__ColumnsAssignment_5 ) ) )
            // InternalLevelDesign.g:646:1: ( ( rule__Room__ColumnsAssignment_5 ) )
            {
            // InternalLevelDesign.g:646:1: ( ( rule__Room__ColumnsAssignment_5 ) )
            // InternalLevelDesign.g:647:2: ( rule__Room__ColumnsAssignment_5 )
            {
             before(grammarAccess.getRoomAccess().getColumnsAssignment_5()); 
            // InternalLevelDesign.g:648:2: ( rule__Room__ColumnsAssignment_5 )
            // InternalLevelDesign.g:648:3: rule__Room__ColumnsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Room__ColumnsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRoomAccess().getColumnsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__5__Impl"


    // $ANTLR start "rule__Room__Group__6"
    // InternalLevelDesign.g:656:1: rule__Room__Group__6 : rule__Room__Group__6__Impl rule__Room__Group__7 ;
    public final void rule__Room__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:660:1: ( rule__Room__Group__6__Impl rule__Room__Group__7 )
            // InternalLevelDesign.g:661:2: rule__Room__Group__6__Impl rule__Room__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Room__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__6"


    // $ANTLR start "rule__Room__Group__6__Impl"
    // InternalLevelDesign.g:668:1: rule__Room__Group__6__Impl : ( 'rows' ) ;
    public final void rule__Room__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:672:1: ( ( 'rows' ) )
            // InternalLevelDesign.g:673:1: ( 'rows' )
            {
            // InternalLevelDesign.g:673:1: ( 'rows' )
            // InternalLevelDesign.g:674:2: 'rows'
            {
             before(grammarAccess.getRoomAccess().getRowsKeyword_6()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getRowsKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__6__Impl"


    // $ANTLR start "rule__Room__Group__7"
    // InternalLevelDesign.g:683:1: rule__Room__Group__7 : rule__Room__Group__7__Impl rule__Room__Group__8 ;
    public final void rule__Room__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:687:1: ( rule__Room__Group__7__Impl rule__Room__Group__8 )
            // InternalLevelDesign.g:688:2: rule__Room__Group__7__Impl rule__Room__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Room__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__7"


    // $ANTLR start "rule__Room__Group__7__Impl"
    // InternalLevelDesign.g:695:1: rule__Room__Group__7__Impl : ( ( '=' )? ) ;
    public final void rule__Room__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:699:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:700:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:700:1: ( ( '=' )? )
            // InternalLevelDesign.g:701:2: ( '=' )?
            {
             before(grammarAccess.getRoomAccess().getEqualsSignKeyword_7()); 
            // InternalLevelDesign.g:702:2: ( '=' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalLevelDesign.g:702:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getRoomAccess().getEqualsSignKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__7__Impl"


    // $ANTLR start "rule__Room__Group__8"
    // InternalLevelDesign.g:710:1: rule__Room__Group__8 : rule__Room__Group__8__Impl rule__Room__Group__9 ;
    public final void rule__Room__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:714:1: ( rule__Room__Group__8__Impl rule__Room__Group__9 )
            // InternalLevelDesign.g:715:2: rule__Room__Group__8__Impl rule__Room__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__Room__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__8"


    // $ANTLR start "rule__Room__Group__8__Impl"
    // InternalLevelDesign.g:722:1: rule__Room__Group__8__Impl : ( ( rule__Room__RowsAssignment_8 ) ) ;
    public final void rule__Room__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:726:1: ( ( ( rule__Room__RowsAssignment_8 ) ) )
            // InternalLevelDesign.g:727:1: ( ( rule__Room__RowsAssignment_8 ) )
            {
            // InternalLevelDesign.g:727:1: ( ( rule__Room__RowsAssignment_8 ) )
            // InternalLevelDesign.g:728:2: ( rule__Room__RowsAssignment_8 )
            {
             before(grammarAccess.getRoomAccess().getRowsAssignment_8()); 
            // InternalLevelDesign.g:729:2: ( rule__Room__RowsAssignment_8 )
            // InternalLevelDesign.g:729:3: rule__Room__RowsAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Room__RowsAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getRoomAccess().getRowsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__8__Impl"


    // $ANTLR start "rule__Room__Group__9"
    // InternalLevelDesign.g:737:1: rule__Room__Group__9 : rule__Room__Group__9__Impl rule__Room__Group__10 ;
    public final void rule__Room__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:741:1: ( rule__Room__Group__9__Impl rule__Room__Group__10 )
            // InternalLevelDesign.g:742:2: rule__Room__Group__9__Impl rule__Room__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__Room__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__9"


    // $ANTLR start "rule__Room__Group__9__Impl"
    // InternalLevelDesign.g:749:1: rule__Room__Group__9__Impl : ( ( rule__Room__EntryAssignment_9 ) ) ;
    public final void rule__Room__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:753:1: ( ( ( rule__Room__EntryAssignment_9 ) ) )
            // InternalLevelDesign.g:754:1: ( ( rule__Room__EntryAssignment_9 ) )
            {
            // InternalLevelDesign.g:754:1: ( ( rule__Room__EntryAssignment_9 ) )
            // InternalLevelDesign.g:755:2: ( rule__Room__EntryAssignment_9 )
            {
             before(grammarAccess.getRoomAccess().getEntryAssignment_9()); 
            // InternalLevelDesign.g:756:2: ( rule__Room__EntryAssignment_9 )
            // InternalLevelDesign.g:756:3: rule__Room__EntryAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Room__EntryAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getRoomAccess().getEntryAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__9__Impl"


    // $ANTLR start "rule__Room__Group__10"
    // InternalLevelDesign.g:764:1: rule__Room__Group__10 : rule__Room__Group__10__Impl rule__Room__Group__11 ;
    public final void rule__Room__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:768:1: ( rule__Room__Group__10__Impl rule__Room__Group__11 )
            // InternalLevelDesign.g:769:2: rule__Room__Group__10__Impl rule__Room__Group__11
            {
            pushFollow(FOLLOW_14);
            rule__Room__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__10"


    // $ANTLR start "rule__Room__Group__10__Impl"
    // InternalLevelDesign.g:776:1: rule__Room__Group__10__Impl : ( ( rule__Room__ExitAssignment_10 ) ) ;
    public final void rule__Room__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:780:1: ( ( ( rule__Room__ExitAssignment_10 ) ) )
            // InternalLevelDesign.g:781:1: ( ( rule__Room__ExitAssignment_10 ) )
            {
            // InternalLevelDesign.g:781:1: ( ( rule__Room__ExitAssignment_10 ) )
            // InternalLevelDesign.g:782:2: ( rule__Room__ExitAssignment_10 )
            {
             before(grammarAccess.getRoomAccess().getExitAssignment_10()); 
            // InternalLevelDesign.g:783:2: ( rule__Room__ExitAssignment_10 )
            // InternalLevelDesign.g:783:3: rule__Room__ExitAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Room__ExitAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getRoomAccess().getExitAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__10__Impl"


    // $ANTLR start "rule__Room__Group__11"
    // InternalLevelDesign.g:791:1: rule__Room__Group__11 : rule__Room__Group__11__Impl rule__Room__Group__12 ;
    public final void rule__Room__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:795:1: ( rule__Room__Group__11__Impl rule__Room__Group__12 )
            // InternalLevelDesign.g:796:2: rule__Room__Group__11__Impl rule__Room__Group__12
            {
            pushFollow(FOLLOW_14);
            rule__Room__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__11"


    // $ANTLR start "rule__Room__Group__11__Impl"
    // InternalLevelDesign.g:803:1: rule__Room__Group__11__Impl : ( ( rule__Room__ExitConnectionAssignment_11 )? ) ;
    public final void rule__Room__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:807:1: ( ( ( rule__Room__ExitConnectionAssignment_11 )? ) )
            // InternalLevelDesign.g:808:1: ( ( rule__Room__ExitConnectionAssignment_11 )? )
            {
            // InternalLevelDesign.g:808:1: ( ( rule__Room__ExitConnectionAssignment_11 )? )
            // InternalLevelDesign.g:809:2: ( rule__Room__ExitConnectionAssignment_11 )?
            {
             before(grammarAccess.getRoomAccess().getExitConnectionAssignment_11()); 
            // InternalLevelDesign.g:810:2: ( rule__Room__ExitConnectionAssignment_11 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalLevelDesign.g:810:3: rule__Room__ExitConnectionAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__Room__ExitConnectionAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRoomAccess().getExitConnectionAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__11__Impl"


    // $ANTLR start "rule__Room__Group__12"
    // InternalLevelDesign.g:818:1: rule__Room__Group__12 : rule__Room__Group__12__Impl rule__Room__Group__13 ;
    public final void rule__Room__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:822:1: ( rule__Room__Group__12__Impl rule__Room__Group__13 )
            // InternalLevelDesign.g:823:2: rule__Room__Group__12__Impl rule__Room__Group__13
            {
            pushFollow(FOLLOW_14);
            rule__Room__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__12"


    // $ANTLR start "rule__Room__Group__12__Impl"
    // InternalLevelDesign.g:830:1: rule__Room__Group__12__Impl : ( ( rule__Room__WallsAssignment_12 )* ) ;
    public final void rule__Room__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:834:1: ( ( ( rule__Room__WallsAssignment_12 )* ) )
            // InternalLevelDesign.g:835:1: ( ( rule__Room__WallsAssignment_12 )* )
            {
            // InternalLevelDesign.g:835:1: ( ( rule__Room__WallsAssignment_12 )* )
            // InternalLevelDesign.g:836:2: ( rule__Room__WallsAssignment_12 )*
            {
             before(grammarAccess.getRoomAccess().getWallsAssignment_12()); 
            // InternalLevelDesign.g:837:2: ( rule__Room__WallsAssignment_12 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==29) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalLevelDesign.g:837:3: rule__Room__WallsAssignment_12
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Room__WallsAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRoomAccess().getWallsAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__12__Impl"


    // $ANTLR start "rule__Room__Group__13"
    // InternalLevelDesign.g:845:1: rule__Room__Group__13 : rule__Room__Group__13__Impl rule__Room__Group__14 ;
    public final void rule__Room__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:849:1: ( rule__Room__Group__13__Impl rule__Room__Group__14 )
            // InternalLevelDesign.g:850:2: rule__Room__Group__13__Impl rule__Room__Group__14
            {
            pushFollow(FOLLOW_14);
            rule__Room__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__13"


    // $ANTLR start "rule__Room__Group__13__Impl"
    // InternalLevelDesign.g:857:1: rule__Room__Group__13__Impl : ( ( rule__Room__TrapdoorsAssignment_13 )* ) ;
    public final void rule__Room__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:861:1: ( ( ( rule__Room__TrapdoorsAssignment_13 )* ) )
            // InternalLevelDesign.g:862:1: ( ( rule__Room__TrapdoorsAssignment_13 )* )
            {
            // InternalLevelDesign.g:862:1: ( ( rule__Room__TrapdoorsAssignment_13 )* )
            // InternalLevelDesign.g:863:2: ( rule__Room__TrapdoorsAssignment_13 )*
            {
             before(grammarAccess.getRoomAccess().getTrapdoorsAssignment_13()); 
            // InternalLevelDesign.g:864:2: ( rule__Room__TrapdoorsAssignment_13 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalLevelDesign.g:864:3: rule__Room__TrapdoorsAssignment_13
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Room__TrapdoorsAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getRoomAccess().getTrapdoorsAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__13__Impl"


    // $ANTLR start "rule__Room__Group__14"
    // InternalLevelDesign.g:872:1: rule__Room__Group__14 : rule__Room__Group__14__Impl rule__Room__Group__15 ;
    public final void rule__Room__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:876:1: ( rule__Room__Group__14__Impl rule__Room__Group__15 )
            // InternalLevelDesign.g:877:2: rule__Room__Group__14__Impl rule__Room__Group__15
            {
            pushFollow(FOLLOW_14);
            rule__Room__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Room__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__14"


    // $ANTLR start "rule__Room__Group__14__Impl"
    // InternalLevelDesign.g:884:1: rule__Room__Group__14__Impl : ( ( rule__Room__MonstersAssignment_14 )* ) ;
    public final void rule__Room__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:888:1: ( ( ( rule__Room__MonstersAssignment_14 )* ) )
            // InternalLevelDesign.g:889:1: ( ( rule__Room__MonstersAssignment_14 )* )
            {
            // InternalLevelDesign.g:889:1: ( ( rule__Room__MonstersAssignment_14 )* )
            // InternalLevelDesign.g:890:2: ( rule__Room__MonstersAssignment_14 )*
            {
             before(grammarAccess.getRoomAccess().getMonstersAssignment_14()); 
            // InternalLevelDesign.g:891:2: ( rule__Room__MonstersAssignment_14 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalLevelDesign.g:891:3: rule__Room__MonstersAssignment_14
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Room__MonstersAssignment_14();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getRoomAccess().getMonstersAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__14__Impl"


    // $ANTLR start "rule__Room__Group__15"
    // InternalLevelDesign.g:899:1: rule__Room__Group__15 : rule__Room__Group__15__Impl ;
    public final void rule__Room__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:903:1: ( rule__Room__Group__15__Impl )
            // InternalLevelDesign.g:904:2: rule__Room__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Room__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__15"


    // $ANTLR start "rule__Room__Group__15__Impl"
    // InternalLevelDesign.g:910:1: rule__Room__Group__15__Impl : ( '}' ) ;
    public final void rule__Room__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:914:1: ( ( '}' ) )
            // InternalLevelDesign.g:915:1: ( '}' )
            {
            // InternalLevelDesign.g:915:1: ( '}' )
            // InternalLevelDesign.g:916:2: '}'
            {
             before(grammarAccess.getRoomAccess().getRightCurlyBracketKeyword_15()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__Group__15__Impl"


    // $ANTLR start "rule__Connection__Group__0"
    // InternalLevelDesign.g:926:1: rule__Connection__Group__0 : rule__Connection__Group__0__Impl rule__Connection__Group__1 ;
    public final void rule__Connection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:930:1: ( rule__Connection__Group__0__Impl rule__Connection__Group__1 )
            // InternalLevelDesign.g:931:2: rule__Connection__Group__0__Impl rule__Connection__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Connection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__Group__0"


    // $ANTLR start "rule__Connection__Group__0__Impl"
    // InternalLevelDesign.g:938:1: rule__Connection__Group__0__Impl : ( ( rule__Connection__TypeAssignment_0 ) ) ;
    public final void rule__Connection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:942:1: ( ( ( rule__Connection__TypeAssignment_0 ) ) )
            // InternalLevelDesign.g:943:1: ( ( rule__Connection__TypeAssignment_0 ) )
            {
            // InternalLevelDesign.g:943:1: ( ( rule__Connection__TypeAssignment_0 ) )
            // InternalLevelDesign.g:944:2: ( rule__Connection__TypeAssignment_0 )
            {
             before(grammarAccess.getConnectionAccess().getTypeAssignment_0()); 
            // InternalLevelDesign.g:945:2: ( rule__Connection__TypeAssignment_0 )
            // InternalLevelDesign.g:945:3: rule__Connection__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Connection__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConnectionAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__Group__0__Impl"


    // $ANTLR start "rule__Connection__Group__1"
    // InternalLevelDesign.g:953:1: rule__Connection__Group__1 : rule__Connection__Group__1__Impl rule__Connection__Group__2 ;
    public final void rule__Connection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:957:1: ( rule__Connection__Group__1__Impl rule__Connection__Group__2 )
            // InternalLevelDesign.g:958:2: rule__Connection__Group__1__Impl rule__Connection__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Connection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Connection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__Group__1"


    // $ANTLR start "rule__Connection__Group__1__Impl"
    // InternalLevelDesign.g:965:1: rule__Connection__Group__1__Impl : ( '=>' ) ;
    public final void rule__Connection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:969:1: ( ( '=>' ) )
            // InternalLevelDesign.g:970:1: ( '=>' )
            {
            // InternalLevelDesign.g:970:1: ( '=>' )
            // InternalLevelDesign.g:971:2: '=>'
            {
             before(grammarAccess.getConnectionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getConnectionAccess().getEqualsSignGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__Group__1__Impl"


    // $ANTLR start "rule__Connection__Group__2"
    // InternalLevelDesign.g:980:1: rule__Connection__Group__2 : rule__Connection__Group__2__Impl ;
    public final void rule__Connection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:984:1: ( rule__Connection__Group__2__Impl )
            // InternalLevelDesign.g:985:2: rule__Connection__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Connection__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__Group__2"


    // $ANTLR start "rule__Connection__Group__2__Impl"
    // InternalLevelDesign.g:991:1: rule__Connection__Group__2__Impl : ( ( rule__Connection__NextRoomAssignment_2 ) ) ;
    public final void rule__Connection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:995:1: ( ( ( rule__Connection__NextRoomAssignment_2 ) ) )
            // InternalLevelDesign.g:996:1: ( ( rule__Connection__NextRoomAssignment_2 ) )
            {
            // InternalLevelDesign.g:996:1: ( ( rule__Connection__NextRoomAssignment_2 ) )
            // InternalLevelDesign.g:997:2: ( rule__Connection__NextRoomAssignment_2 )
            {
             before(grammarAccess.getConnectionAccess().getNextRoomAssignment_2()); 
            // InternalLevelDesign.g:998:2: ( rule__Connection__NextRoomAssignment_2 )
            // InternalLevelDesign.g:998:3: rule__Connection__NextRoomAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Connection__NextRoomAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConnectionAccess().getNextRoomAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__Group__2__Impl"


    // $ANTLR start "rule__Monster__Group__0"
    // InternalLevelDesign.g:1007:1: rule__Monster__Group__0 : rule__Monster__Group__0__Impl rule__Monster__Group__1 ;
    public final void rule__Monster__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1011:1: ( rule__Monster__Group__0__Impl rule__Monster__Group__1 )
            // InternalLevelDesign.g:1012:2: rule__Monster__Group__0__Impl rule__Monster__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Monster__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__0"


    // $ANTLR start "rule__Monster__Group__0__Impl"
    // InternalLevelDesign.g:1019:1: rule__Monster__Group__0__Impl : ( 'monster' ) ;
    public final void rule__Monster__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1023:1: ( ( 'monster' ) )
            // InternalLevelDesign.g:1024:1: ( 'monster' )
            {
            // InternalLevelDesign.g:1024:1: ( 'monster' )
            // InternalLevelDesign.g:1025:2: 'monster'
            {
             before(grammarAccess.getMonsterAccess().getMonsterKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getMonsterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__0__Impl"


    // $ANTLR start "rule__Monster__Group__1"
    // InternalLevelDesign.g:1034:1: rule__Monster__Group__1 : rule__Monster__Group__1__Impl rule__Monster__Group__2 ;
    public final void rule__Monster__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1038:1: ( rule__Monster__Group__1__Impl rule__Monster__Group__2 )
            // InternalLevelDesign.g:1039:2: rule__Monster__Group__1__Impl rule__Monster__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Monster__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__1"


    // $ANTLR start "rule__Monster__Group__1__Impl"
    // InternalLevelDesign.g:1046:1: rule__Monster__Group__1__Impl : ( ( rule__Monster__NameAssignment_1 )? ) ;
    public final void rule__Monster__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1050:1: ( ( ( rule__Monster__NameAssignment_1 )? ) )
            // InternalLevelDesign.g:1051:1: ( ( rule__Monster__NameAssignment_1 )? )
            {
            // InternalLevelDesign.g:1051:1: ( ( rule__Monster__NameAssignment_1 )? )
            // InternalLevelDesign.g:1052:2: ( rule__Monster__NameAssignment_1 )?
            {
             before(grammarAccess.getMonsterAccess().getNameAssignment_1()); 
            // InternalLevelDesign.g:1053:2: ( rule__Monster__NameAssignment_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalLevelDesign.g:1053:3: rule__Monster__NameAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monster__NameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__1__Impl"


    // $ANTLR start "rule__Monster__Group__2"
    // InternalLevelDesign.g:1061:1: rule__Monster__Group__2 : rule__Monster__Group__2__Impl rule__Monster__Group__3 ;
    public final void rule__Monster__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1065:1: ( rule__Monster__Group__2__Impl rule__Monster__Group__3 )
            // InternalLevelDesign.g:1066:2: rule__Monster__Group__2__Impl rule__Monster__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Monster__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__2"


    // $ANTLR start "rule__Monster__Group__2__Impl"
    // InternalLevelDesign.g:1073:1: rule__Monster__Group__2__Impl : ( ( '@' )? ) ;
    public final void rule__Monster__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1077:1: ( ( ( '@' )? ) )
            // InternalLevelDesign.g:1078:1: ( ( '@' )? )
            {
            // InternalLevelDesign.g:1078:1: ( ( '@' )? )
            // InternalLevelDesign.g:1079:2: ( '@' )?
            {
             before(grammarAccess.getMonsterAccess().getCommercialAtKeyword_2()); 
            // InternalLevelDesign.g:1080:2: ( '@' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalLevelDesign.g:1080:3: '@'
                    {
                    match(input,22,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getCommercialAtKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__2__Impl"


    // $ANTLR start "rule__Monster__Group__3"
    // InternalLevelDesign.g:1088:1: rule__Monster__Group__3 : rule__Monster__Group__3__Impl rule__Monster__Group__4 ;
    public final void rule__Monster__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1092:1: ( rule__Monster__Group__3__Impl rule__Monster__Group__4 )
            // InternalLevelDesign.g:1093:2: rule__Monster__Group__3__Impl rule__Monster__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Monster__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__3"


    // $ANTLR start "rule__Monster__Group__3__Impl"
    // InternalLevelDesign.g:1100:1: rule__Monster__Group__3__Impl : ( ( rule__Monster__PositionAssignment_3 ) ) ;
    public final void rule__Monster__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1104:1: ( ( ( rule__Monster__PositionAssignment_3 ) ) )
            // InternalLevelDesign.g:1105:1: ( ( rule__Monster__PositionAssignment_3 ) )
            {
            // InternalLevelDesign.g:1105:1: ( ( rule__Monster__PositionAssignment_3 ) )
            // InternalLevelDesign.g:1106:2: ( rule__Monster__PositionAssignment_3 )
            {
             before(grammarAccess.getMonsterAccess().getPositionAssignment_3()); 
            // InternalLevelDesign.g:1107:2: ( rule__Monster__PositionAssignment_3 )
            // InternalLevelDesign.g:1107:3: rule__Monster__PositionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Monster__PositionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getPositionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__3__Impl"


    // $ANTLR start "rule__Monster__Group__4"
    // InternalLevelDesign.g:1115:1: rule__Monster__Group__4 : rule__Monster__Group__4__Impl rule__Monster__Group__5 ;
    public final void rule__Monster__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1119:1: ( rule__Monster__Group__4__Impl rule__Monster__Group__5 )
            // InternalLevelDesign.g:1120:2: rule__Monster__Group__4__Impl rule__Monster__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__Monster__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__4"


    // $ANTLR start "rule__Monster__Group__4__Impl"
    // InternalLevelDesign.g:1127:1: rule__Monster__Group__4__Impl : ( '{' ) ;
    public final void rule__Monster__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1131:1: ( ( '{' ) )
            // InternalLevelDesign.g:1132:1: ( '{' )
            {
            // InternalLevelDesign.g:1132:1: ( '{' )
            // InternalLevelDesign.g:1133:2: '{'
            {
             before(grammarAccess.getMonsterAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__4__Impl"


    // $ANTLR start "rule__Monster__Group__5"
    // InternalLevelDesign.g:1142:1: rule__Monster__Group__5 : rule__Monster__Group__5__Impl rule__Monster__Group__6 ;
    public final void rule__Monster__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1146:1: ( rule__Monster__Group__5__Impl rule__Monster__Group__6 )
            // InternalLevelDesign.g:1147:2: rule__Monster__Group__5__Impl rule__Monster__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__5"


    // $ANTLR start "rule__Monster__Group__5__Impl"
    // InternalLevelDesign.g:1154:1: rule__Monster__Group__5__Impl : ( 'hp' ) ;
    public final void rule__Monster__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1158:1: ( ( 'hp' ) )
            // InternalLevelDesign.g:1159:1: ( 'hp' )
            {
            // InternalLevelDesign.g:1159:1: ( 'hp' )
            // InternalLevelDesign.g:1160:2: 'hp'
            {
             before(grammarAccess.getMonsterAccess().getHpKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getHpKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__5__Impl"


    // $ANTLR start "rule__Monster__Group__6"
    // InternalLevelDesign.g:1169:1: rule__Monster__Group__6 : rule__Monster__Group__6__Impl rule__Monster__Group__7 ;
    public final void rule__Monster__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1173:1: ( rule__Monster__Group__6__Impl rule__Monster__Group__7 )
            // InternalLevelDesign.g:1174:2: rule__Monster__Group__6__Impl rule__Monster__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__6"


    // $ANTLR start "rule__Monster__Group__6__Impl"
    // InternalLevelDesign.g:1181:1: rule__Monster__Group__6__Impl : ( ( '=' )? ) ;
    public final void rule__Monster__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1185:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:1186:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:1186:1: ( ( '=' )? )
            // InternalLevelDesign.g:1187:2: ( '=' )?
            {
             before(grammarAccess.getMonsterAccess().getEqualsSignKeyword_6()); 
            // InternalLevelDesign.g:1188:2: ( '=' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalLevelDesign.g:1188:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getEqualsSignKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__6__Impl"


    // $ANTLR start "rule__Monster__Group__7"
    // InternalLevelDesign.g:1196:1: rule__Monster__Group__7 : rule__Monster__Group__7__Impl rule__Monster__Group__8 ;
    public final void rule__Monster__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1200:1: ( rule__Monster__Group__7__Impl rule__Monster__Group__8 )
            // InternalLevelDesign.g:1201:2: rule__Monster__Group__7__Impl rule__Monster__Group__8
            {
            pushFollow(FOLLOW_20);
            rule__Monster__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__7"


    // $ANTLR start "rule__Monster__Group__7__Impl"
    // InternalLevelDesign.g:1208:1: rule__Monster__Group__7__Impl : ( ( rule__Monster__HpAssignment_7 ) ) ;
    public final void rule__Monster__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1212:1: ( ( ( rule__Monster__HpAssignment_7 ) ) )
            // InternalLevelDesign.g:1213:1: ( ( rule__Monster__HpAssignment_7 ) )
            {
            // InternalLevelDesign.g:1213:1: ( ( rule__Monster__HpAssignment_7 ) )
            // InternalLevelDesign.g:1214:2: ( rule__Monster__HpAssignment_7 )
            {
             before(grammarAccess.getMonsterAccess().getHpAssignment_7()); 
            // InternalLevelDesign.g:1215:2: ( rule__Monster__HpAssignment_7 )
            // InternalLevelDesign.g:1215:3: rule__Monster__HpAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Monster__HpAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getHpAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__7__Impl"


    // $ANTLR start "rule__Monster__Group__8"
    // InternalLevelDesign.g:1223:1: rule__Monster__Group__8 : rule__Monster__Group__8__Impl rule__Monster__Group__9 ;
    public final void rule__Monster__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1227:1: ( rule__Monster__Group__8__Impl rule__Monster__Group__9 )
            // InternalLevelDesign.g:1228:2: rule__Monster__Group__8__Impl rule__Monster__Group__9
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__8"


    // $ANTLR start "rule__Monster__Group__8__Impl"
    // InternalLevelDesign.g:1235:1: rule__Monster__Group__8__Impl : ( 'damage' ) ;
    public final void rule__Monster__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1239:1: ( ( 'damage' ) )
            // InternalLevelDesign.g:1240:1: ( 'damage' )
            {
            // InternalLevelDesign.g:1240:1: ( 'damage' )
            // InternalLevelDesign.g:1241:2: 'damage'
            {
             before(grammarAccess.getMonsterAccess().getDamageKeyword_8()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getDamageKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__8__Impl"


    // $ANTLR start "rule__Monster__Group__9"
    // InternalLevelDesign.g:1250:1: rule__Monster__Group__9 : rule__Monster__Group__9__Impl rule__Monster__Group__10 ;
    public final void rule__Monster__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1254:1: ( rule__Monster__Group__9__Impl rule__Monster__Group__10 )
            // InternalLevelDesign.g:1255:2: rule__Monster__Group__9__Impl rule__Monster__Group__10
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__9"


    // $ANTLR start "rule__Monster__Group__9__Impl"
    // InternalLevelDesign.g:1262:1: rule__Monster__Group__9__Impl : ( ( '=' )? ) ;
    public final void rule__Monster__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1266:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:1267:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:1267:1: ( ( '=' )? )
            // InternalLevelDesign.g:1268:2: ( '=' )?
            {
             before(grammarAccess.getMonsterAccess().getEqualsSignKeyword_9()); 
            // InternalLevelDesign.g:1269:2: ( '=' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalLevelDesign.g:1269:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getEqualsSignKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__9__Impl"


    // $ANTLR start "rule__Monster__Group__10"
    // InternalLevelDesign.g:1277:1: rule__Monster__Group__10 : rule__Monster__Group__10__Impl rule__Monster__Group__11 ;
    public final void rule__Monster__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1281:1: ( rule__Monster__Group__10__Impl rule__Monster__Group__11 )
            // InternalLevelDesign.g:1282:2: rule__Monster__Group__10__Impl rule__Monster__Group__11
            {
            pushFollow(FOLLOW_21);
            rule__Monster__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__10"


    // $ANTLR start "rule__Monster__Group__10__Impl"
    // InternalLevelDesign.g:1289:1: rule__Monster__Group__10__Impl : ( ( rule__Monster__DamageAssignment_10 ) ) ;
    public final void rule__Monster__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1293:1: ( ( ( rule__Monster__DamageAssignment_10 ) ) )
            // InternalLevelDesign.g:1294:1: ( ( rule__Monster__DamageAssignment_10 ) )
            {
            // InternalLevelDesign.g:1294:1: ( ( rule__Monster__DamageAssignment_10 ) )
            // InternalLevelDesign.g:1295:2: ( rule__Monster__DamageAssignment_10 )
            {
             before(grammarAccess.getMonsterAccess().getDamageAssignment_10()); 
            // InternalLevelDesign.g:1296:2: ( rule__Monster__DamageAssignment_10 )
            // InternalLevelDesign.g:1296:3: rule__Monster__DamageAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Monster__DamageAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getDamageAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__10__Impl"


    // $ANTLR start "rule__Monster__Group__11"
    // InternalLevelDesign.g:1304:1: rule__Monster__Group__11 : rule__Monster__Group__11__Impl rule__Monster__Group__12 ;
    public final void rule__Monster__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1308:1: ( rule__Monster__Group__11__Impl rule__Monster__Group__12 )
            // InternalLevelDesign.g:1309:2: rule__Monster__Group__11__Impl rule__Monster__Group__12
            {
            pushFollow(FOLLOW_22);
            rule__Monster__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__11"


    // $ANTLR start "rule__Monster__Group__11__Impl"
    // InternalLevelDesign.g:1316:1: rule__Monster__Group__11__Impl : ( 'speed' ) ;
    public final void rule__Monster__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1320:1: ( ( 'speed' ) )
            // InternalLevelDesign.g:1321:1: ( 'speed' )
            {
            // InternalLevelDesign.g:1321:1: ( 'speed' )
            // InternalLevelDesign.g:1322:2: 'speed'
            {
             before(grammarAccess.getMonsterAccess().getSpeedKeyword_11()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getSpeedKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__11__Impl"


    // $ANTLR start "rule__Monster__Group__12"
    // InternalLevelDesign.g:1331:1: rule__Monster__Group__12 : rule__Monster__Group__12__Impl rule__Monster__Group__13 ;
    public final void rule__Monster__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1335:1: ( rule__Monster__Group__12__Impl rule__Monster__Group__13 )
            // InternalLevelDesign.g:1336:2: rule__Monster__Group__12__Impl rule__Monster__Group__13
            {
            pushFollow(FOLLOW_22);
            rule__Monster__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__12"


    // $ANTLR start "rule__Monster__Group__12__Impl"
    // InternalLevelDesign.g:1343:1: rule__Monster__Group__12__Impl : ( ( '=' )? ) ;
    public final void rule__Monster__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1347:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:1348:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:1348:1: ( ( '=' )? )
            // InternalLevelDesign.g:1349:2: ( '=' )?
            {
             before(grammarAccess.getMonsterAccess().getEqualsSignKeyword_12()); 
            // InternalLevelDesign.g:1350:2: ( '=' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalLevelDesign.g:1350:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getEqualsSignKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__12__Impl"


    // $ANTLR start "rule__Monster__Group__13"
    // InternalLevelDesign.g:1358:1: rule__Monster__Group__13 : rule__Monster__Group__13__Impl rule__Monster__Group__14 ;
    public final void rule__Monster__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1362:1: ( rule__Monster__Group__13__Impl rule__Monster__Group__14 )
            // InternalLevelDesign.g:1363:2: rule__Monster__Group__13__Impl rule__Monster__Group__14
            {
            pushFollow(FOLLOW_23);
            rule__Monster__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__13"


    // $ANTLR start "rule__Monster__Group__13__Impl"
    // InternalLevelDesign.g:1370:1: rule__Monster__Group__13__Impl : ( ( rule__Monster__SpeedAssignment_13 ) ) ;
    public final void rule__Monster__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1374:1: ( ( ( rule__Monster__SpeedAssignment_13 ) ) )
            // InternalLevelDesign.g:1375:1: ( ( rule__Monster__SpeedAssignment_13 ) )
            {
            // InternalLevelDesign.g:1375:1: ( ( rule__Monster__SpeedAssignment_13 ) )
            // InternalLevelDesign.g:1376:2: ( rule__Monster__SpeedAssignment_13 )
            {
             before(grammarAccess.getMonsterAccess().getSpeedAssignment_13()); 
            // InternalLevelDesign.g:1377:2: ( rule__Monster__SpeedAssignment_13 )
            // InternalLevelDesign.g:1377:3: rule__Monster__SpeedAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Monster__SpeedAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getSpeedAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__13__Impl"


    // $ANTLR start "rule__Monster__Group__14"
    // InternalLevelDesign.g:1385:1: rule__Monster__Group__14 : rule__Monster__Group__14__Impl rule__Monster__Group__15 ;
    public final void rule__Monster__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1389:1: ( rule__Monster__Group__14__Impl rule__Monster__Group__15 )
            // InternalLevelDesign.g:1390:2: rule__Monster__Group__14__Impl rule__Monster__Group__15
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__14"


    // $ANTLR start "rule__Monster__Group__14__Impl"
    // InternalLevelDesign.g:1397:1: rule__Monster__Group__14__Impl : ( 'range' ) ;
    public final void rule__Monster__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1401:1: ( ( 'range' ) )
            // InternalLevelDesign.g:1402:1: ( 'range' )
            {
            // InternalLevelDesign.g:1402:1: ( 'range' )
            // InternalLevelDesign.g:1403:2: 'range'
            {
             before(grammarAccess.getMonsterAccess().getRangeKeyword_14()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getRangeKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__14__Impl"


    // $ANTLR start "rule__Monster__Group__15"
    // InternalLevelDesign.g:1412:1: rule__Monster__Group__15 : rule__Monster__Group__15__Impl rule__Monster__Group__16 ;
    public final void rule__Monster__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1416:1: ( rule__Monster__Group__15__Impl rule__Monster__Group__16 )
            // InternalLevelDesign.g:1417:2: rule__Monster__Group__15__Impl rule__Monster__Group__16
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__15"


    // $ANTLR start "rule__Monster__Group__15__Impl"
    // InternalLevelDesign.g:1424:1: rule__Monster__Group__15__Impl : ( ( '=' )? ) ;
    public final void rule__Monster__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1428:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:1429:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:1429:1: ( ( '=' )? )
            // InternalLevelDesign.g:1430:2: ( '=' )?
            {
             before(grammarAccess.getMonsterAccess().getEqualsSignKeyword_15()); 
            // InternalLevelDesign.g:1431:2: ( '=' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalLevelDesign.g:1431:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getEqualsSignKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__15__Impl"


    // $ANTLR start "rule__Monster__Group__16"
    // InternalLevelDesign.g:1439:1: rule__Monster__Group__16 : rule__Monster__Group__16__Impl rule__Monster__Group__17 ;
    public final void rule__Monster__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1443:1: ( rule__Monster__Group__16__Impl rule__Monster__Group__17 )
            // InternalLevelDesign.g:1444:2: rule__Monster__Group__16__Impl rule__Monster__Group__17
            {
            pushFollow(FOLLOW_24);
            rule__Monster__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__16"


    // $ANTLR start "rule__Monster__Group__16__Impl"
    // InternalLevelDesign.g:1451:1: rule__Monster__Group__16__Impl : ( ( rule__Monster__RangeAssignment_16 ) ) ;
    public final void rule__Monster__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1455:1: ( ( ( rule__Monster__RangeAssignment_16 ) ) )
            // InternalLevelDesign.g:1456:1: ( ( rule__Monster__RangeAssignment_16 ) )
            {
            // InternalLevelDesign.g:1456:1: ( ( rule__Monster__RangeAssignment_16 ) )
            // InternalLevelDesign.g:1457:2: ( rule__Monster__RangeAssignment_16 )
            {
             before(grammarAccess.getMonsterAccess().getRangeAssignment_16()); 
            // InternalLevelDesign.g:1458:2: ( rule__Monster__RangeAssignment_16 )
            // InternalLevelDesign.g:1458:3: rule__Monster__RangeAssignment_16
            {
            pushFollow(FOLLOW_2);
            rule__Monster__RangeAssignment_16();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getRangeAssignment_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__16__Impl"


    // $ANTLR start "rule__Monster__Group__17"
    // InternalLevelDesign.g:1466:1: rule__Monster__Group__17 : rule__Monster__Group__17__Impl rule__Monster__Group__18 ;
    public final void rule__Monster__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1470:1: ( rule__Monster__Group__17__Impl rule__Monster__Group__18 )
            // InternalLevelDesign.g:1471:2: rule__Monster__Group__17__Impl rule__Monster__Group__18
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__17"


    // $ANTLR start "rule__Monster__Group__17__Impl"
    // InternalLevelDesign.g:1478:1: rule__Monster__Group__17__Impl : ( 'aggroradius' ) ;
    public final void rule__Monster__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1482:1: ( ( 'aggroradius' ) )
            // InternalLevelDesign.g:1483:1: ( 'aggroradius' )
            {
            // InternalLevelDesign.g:1483:1: ( 'aggroradius' )
            // InternalLevelDesign.g:1484:2: 'aggroradius'
            {
             before(grammarAccess.getMonsterAccess().getAggroradiusKeyword_17()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getAggroradiusKeyword_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__17__Impl"


    // $ANTLR start "rule__Monster__Group__18"
    // InternalLevelDesign.g:1493:1: rule__Monster__Group__18 : rule__Monster__Group__18__Impl rule__Monster__Group__19 ;
    public final void rule__Monster__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1497:1: ( rule__Monster__Group__18__Impl rule__Monster__Group__19 )
            // InternalLevelDesign.g:1498:2: rule__Monster__Group__18__Impl rule__Monster__Group__19
            {
            pushFollow(FOLLOW_10);
            rule__Monster__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__18"


    // $ANTLR start "rule__Monster__Group__18__Impl"
    // InternalLevelDesign.g:1505:1: rule__Monster__Group__18__Impl : ( ( '=' )? ) ;
    public final void rule__Monster__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1509:1: ( ( ( '=' )? ) )
            // InternalLevelDesign.g:1510:1: ( ( '=' )? )
            {
            // InternalLevelDesign.g:1510:1: ( ( '=' )? )
            // InternalLevelDesign.g:1511:2: ( '=' )?
            {
             before(grammarAccess.getMonsterAccess().getEqualsSignKeyword_18()); 
            // InternalLevelDesign.g:1512:2: ( '=' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalLevelDesign.g:1512:3: '='
                    {
                    match(input,18,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMonsterAccess().getEqualsSignKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__18__Impl"


    // $ANTLR start "rule__Monster__Group__19"
    // InternalLevelDesign.g:1520:1: rule__Monster__Group__19 : rule__Monster__Group__19__Impl rule__Monster__Group__20 ;
    public final void rule__Monster__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1524:1: ( rule__Monster__Group__19__Impl rule__Monster__Group__20 )
            // InternalLevelDesign.g:1525:2: rule__Monster__Group__19__Impl rule__Monster__Group__20
            {
            pushFollow(FOLLOW_25);
            rule__Monster__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monster__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__19"


    // $ANTLR start "rule__Monster__Group__19__Impl"
    // InternalLevelDesign.g:1532:1: rule__Monster__Group__19__Impl : ( ( rule__Monster__AggroRadiusAssignment_19 ) ) ;
    public final void rule__Monster__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1536:1: ( ( ( rule__Monster__AggroRadiusAssignment_19 ) ) )
            // InternalLevelDesign.g:1537:1: ( ( rule__Monster__AggroRadiusAssignment_19 ) )
            {
            // InternalLevelDesign.g:1537:1: ( ( rule__Monster__AggroRadiusAssignment_19 ) )
            // InternalLevelDesign.g:1538:2: ( rule__Monster__AggroRadiusAssignment_19 )
            {
             before(grammarAccess.getMonsterAccess().getAggroRadiusAssignment_19()); 
            // InternalLevelDesign.g:1539:2: ( rule__Monster__AggroRadiusAssignment_19 )
            // InternalLevelDesign.g:1539:3: rule__Monster__AggroRadiusAssignment_19
            {
            pushFollow(FOLLOW_2);
            rule__Monster__AggroRadiusAssignment_19();

            state._fsp--;


            }

             after(grammarAccess.getMonsterAccess().getAggroRadiusAssignment_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__19__Impl"


    // $ANTLR start "rule__Monster__Group__20"
    // InternalLevelDesign.g:1547:1: rule__Monster__Group__20 : rule__Monster__Group__20__Impl ;
    public final void rule__Monster__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1551:1: ( rule__Monster__Group__20__Impl )
            // InternalLevelDesign.g:1552:2: rule__Monster__Group__20__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Monster__Group__20__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__20"


    // $ANTLR start "rule__Monster__Group__20__Impl"
    // InternalLevelDesign.g:1558:1: rule__Monster__Group__20__Impl : ( '}' ) ;
    public final void rule__Monster__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1562:1: ( ( '}' ) )
            // InternalLevelDesign.g:1563:1: ( '}' )
            {
            // InternalLevelDesign.g:1563:1: ( '}' )
            // InternalLevelDesign.g:1564:2: '}'
            {
             before(grammarAccess.getMonsterAccess().getRightCurlyBracketKeyword_20()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getRightCurlyBracketKeyword_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__Group__20__Impl"


    // $ANTLR start "rule__Trapdoor__Group__0"
    // InternalLevelDesign.g:1574:1: rule__Trapdoor__Group__0 : rule__Trapdoor__Group__0__Impl rule__Trapdoor__Group__1 ;
    public final void rule__Trapdoor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1578:1: ( rule__Trapdoor__Group__0__Impl rule__Trapdoor__Group__1 )
            // InternalLevelDesign.g:1579:2: rule__Trapdoor__Group__0__Impl rule__Trapdoor__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Trapdoor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trapdoor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__0"


    // $ANTLR start "rule__Trapdoor__Group__0__Impl"
    // InternalLevelDesign.g:1586:1: rule__Trapdoor__Group__0__Impl : ( 'trapdoor' ) ;
    public final void rule__Trapdoor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1590:1: ( ( 'trapdoor' ) )
            // InternalLevelDesign.g:1591:1: ( 'trapdoor' )
            {
            // InternalLevelDesign.g:1591:1: ( 'trapdoor' )
            // InternalLevelDesign.g:1592:2: 'trapdoor'
            {
             before(grammarAccess.getTrapdoorAccess().getTrapdoorKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTrapdoorAccess().getTrapdoorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__0__Impl"


    // $ANTLR start "rule__Trapdoor__Group__1"
    // InternalLevelDesign.g:1601:1: rule__Trapdoor__Group__1 : rule__Trapdoor__Group__1__Impl rule__Trapdoor__Group__2 ;
    public final void rule__Trapdoor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1605:1: ( rule__Trapdoor__Group__1__Impl rule__Trapdoor__Group__2 )
            // InternalLevelDesign.g:1606:2: rule__Trapdoor__Group__1__Impl rule__Trapdoor__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Trapdoor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trapdoor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__1"


    // $ANTLR start "rule__Trapdoor__Group__1__Impl"
    // InternalLevelDesign.g:1613:1: rule__Trapdoor__Group__1__Impl : ( ( rule__Trapdoor__NameAssignment_1 )? ) ;
    public final void rule__Trapdoor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1617:1: ( ( ( rule__Trapdoor__NameAssignment_1 )? ) )
            // InternalLevelDesign.g:1618:1: ( ( rule__Trapdoor__NameAssignment_1 )? )
            {
            // InternalLevelDesign.g:1618:1: ( ( rule__Trapdoor__NameAssignment_1 )? )
            // InternalLevelDesign.g:1619:2: ( rule__Trapdoor__NameAssignment_1 )?
            {
             before(grammarAccess.getTrapdoorAccess().getNameAssignment_1()); 
            // InternalLevelDesign.g:1620:2: ( rule__Trapdoor__NameAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalLevelDesign.g:1620:3: rule__Trapdoor__NameAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Trapdoor__NameAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrapdoorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__1__Impl"


    // $ANTLR start "rule__Trapdoor__Group__2"
    // InternalLevelDesign.g:1628:1: rule__Trapdoor__Group__2 : rule__Trapdoor__Group__2__Impl rule__Trapdoor__Group__3 ;
    public final void rule__Trapdoor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1632:1: ( rule__Trapdoor__Group__2__Impl rule__Trapdoor__Group__3 )
            // InternalLevelDesign.g:1633:2: rule__Trapdoor__Group__2__Impl rule__Trapdoor__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Trapdoor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Trapdoor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__2"


    // $ANTLR start "rule__Trapdoor__Group__2__Impl"
    // InternalLevelDesign.g:1640:1: rule__Trapdoor__Group__2__Impl : ( ( '@' )? ) ;
    public final void rule__Trapdoor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1644:1: ( ( ( '@' )? ) )
            // InternalLevelDesign.g:1645:1: ( ( '@' )? )
            {
            // InternalLevelDesign.g:1645:1: ( ( '@' )? )
            // InternalLevelDesign.g:1646:2: ( '@' )?
            {
             before(grammarAccess.getTrapdoorAccess().getCommercialAtKeyword_2()); 
            // InternalLevelDesign.g:1647:2: ( '@' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalLevelDesign.g:1647:3: '@'
                    {
                    match(input,22,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getTrapdoorAccess().getCommercialAtKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__2__Impl"


    // $ANTLR start "rule__Trapdoor__Group__3"
    // InternalLevelDesign.g:1655:1: rule__Trapdoor__Group__3 : rule__Trapdoor__Group__3__Impl ;
    public final void rule__Trapdoor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1659:1: ( rule__Trapdoor__Group__3__Impl )
            // InternalLevelDesign.g:1660:2: rule__Trapdoor__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Trapdoor__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__3"


    // $ANTLR start "rule__Trapdoor__Group__3__Impl"
    // InternalLevelDesign.g:1666:1: rule__Trapdoor__Group__3__Impl : ( ( rule__Trapdoor__PositionAssignment_3 ) ) ;
    public final void rule__Trapdoor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1670:1: ( ( ( rule__Trapdoor__PositionAssignment_3 ) ) )
            // InternalLevelDesign.g:1671:1: ( ( rule__Trapdoor__PositionAssignment_3 ) )
            {
            // InternalLevelDesign.g:1671:1: ( ( rule__Trapdoor__PositionAssignment_3 ) )
            // InternalLevelDesign.g:1672:2: ( rule__Trapdoor__PositionAssignment_3 )
            {
             before(grammarAccess.getTrapdoorAccess().getPositionAssignment_3()); 
            // InternalLevelDesign.g:1673:2: ( rule__Trapdoor__PositionAssignment_3 )
            // InternalLevelDesign.g:1673:3: rule__Trapdoor__PositionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Trapdoor__PositionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTrapdoorAccess().getPositionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__Group__3__Impl"


    // $ANTLR start "rule__Wall__Group__0"
    // InternalLevelDesign.g:1682:1: rule__Wall__Group__0 : rule__Wall__Group__0__Impl rule__Wall__Group__1 ;
    public final void rule__Wall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1686:1: ( rule__Wall__Group__0__Impl rule__Wall__Group__1 )
            // InternalLevelDesign.g:1687:2: rule__Wall__Group__0__Impl rule__Wall__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Wall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Wall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__0"


    // $ANTLR start "rule__Wall__Group__0__Impl"
    // InternalLevelDesign.g:1694:1: rule__Wall__Group__0__Impl : ( 'wall' ) ;
    public final void rule__Wall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1698:1: ( ( 'wall' ) )
            // InternalLevelDesign.g:1699:1: ( 'wall' )
            {
            // InternalLevelDesign.g:1699:1: ( 'wall' )
            // InternalLevelDesign.g:1700:2: 'wall'
            {
             before(grammarAccess.getWallAccess().getWallKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getWallAccess().getWallKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__0__Impl"


    // $ANTLR start "rule__Wall__Group__1"
    // InternalLevelDesign.g:1709:1: rule__Wall__Group__1 : rule__Wall__Group__1__Impl rule__Wall__Group__2 ;
    public final void rule__Wall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1713:1: ( rule__Wall__Group__1__Impl rule__Wall__Group__2 )
            // InternalLevelDesign.g:1714:2: rule__Wall__Group__1__Impl rule__Wall__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__Wall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Wall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__1"


    // $ANTLR start "rule__Wall__Group__1__Impl"
    // InternalLevelDesign.g:1721:1: rule__Wall__Group__1__Impl : ( ( rule__Wall__NameAssignment_1 ) ) ;
    public final void rule__Wall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1725:1: ( ( ( rule__Wall__NameAssignment_1 ) ) )
            // InternalLevelDesign.g:1726:1: ( ( rule__Wall__NameAssignment_1 ) )
            {
            // InternalLevelDesign.g:1726:1: ( ( rule__Wall__NameAssignment_1 ) )
            // InternalLevelDesign.g:1727:2: ( rule__Wall__NameAssignment_1 )
            {
             before(grammarAccess.getWallAccess().getNameAssignment_1()); 
            // InternalLevelDesign.g:1728:2: ( rule__Wall__NameAssignment_1 )
            // InternalLevelDesign.g:1728:3: rule__Wall__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Wall__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWallAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__1__Impl"


    // $ANTLR start "rule__Wall__Group__2"
    // InternalLevelDesign.g:1736:1: rule__Wall__Group__2 : rule__Wall__Group__2__Impl rule__Wall__Group__3 ;
    public final void rule__Wall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1740:1: ( rule__Wall__Group__2__Impl rule__Wall__Group__3 )
            // InternalLevelDesign.g:1741:2: rule__Wall__Group__2__Impl rule__Wall__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Wall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Wall__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__2"


    // $ANTLR start "rule__Wall__Group__2__Impl"
    // InternalLevelDesign.g:1748:1: rule__Wall__Group__2__Impl : ( 'from' ) ;
    public final void rule__Wall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1752:1: ( ( 'from' ) )
            // InternalLevelDesign.g:1753:1: ( 'from' )
            {
            // InternalLevelDesign.g:1753:1: ( 'from' )
            // InternalLevelDesign.g:1754:2: 'from'
            {
             before(grammarAccess.getWallAccess().getFromKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getWallAccess().getFromKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__2__Impl"


    // $ANTLR start "rule__Wall__Group__3"
    // InternalLevelDesign.g:1763:1: rule__Wall__Group__3 : rule__Wall__Group__3__Impl rule__Wall__Group__4 ;
    public final void rule__Wall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1767:1: ( rule__Wall__Group__3__Impl rule__Wall__Group__4 )
            // InternalLevelDesign.g:1768:2: rule__Wall__Group__3__Impl rule__Wall__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__Wall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Wall__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__3"


    // $ANTLR start "rule__Wall__Group__3__Impl"
    // InternalLevelDesign.g:1775:1: rule__Wall__Group__3__Impl : ( ( rule__Wall__FromAssignment_3 ) ) ;
    public final void rule__Wall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1779:1: ( ( ( rule__Wall__FromAssignment_3 ) ) )
            // InternalLevelDesign.g:1780:1: ( ( rule__Wall__FromAssignment_3 ) )
            {
            // InternalLevelDesign.g:1780:1: ( ( rule__Wall__FromAssignment_3 ) )
            // InternalLevelDesign.g:1781:2: ( rule__Wall__FromAssignment_3 )
            {
             before(grammarAccess.getWallAccess().getFromAssignment_3()); 
            // InternalLevelDesign.g:1782:2: ( rule__Wall__FromAssignment_3 )
            // InternalLevelDesign.g:1782:3: rule__Wall__FromAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Wall__FromAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWallAccess().getFromAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__3__Impl"


    // $ANTLR start "rule__Wall__Group__4"
    // InternalLevelDesign.g:1790:1: rule__Wall__Group__4 : rule__Wall__Group__4__Impl rule__Wall__Group__5 ;
    public final void rule__Wall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1794:1: ( rule__Wall__Group__4__Impl rule__Wall__Group__5 )
            // InternalLevelDesign.g:1795:2: rule__Wall__Group__4__Impl rule__Wall__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__Wall__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Wall__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__4"


    // $ANTLR start "rule__Wall__Group__4__Impl"
    // InternalLevelDesign.g:1802:1: rule__Wall__Group__4__Impl : ( 'to' ) ;
    public final void rule__Wall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1806:1: ( ( 'to' ) )
            // InternalLevelDesign.g:1807:1: ( 'to' )
            {
            // InternalLevelDesign.g:1807:1: ( 'to' )
            // InternalLevelDesign.g:1808:2: 'to'
            {
             before(grammarAccess.getWallAccess().getToKeyword_4()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getWallAccess().getToKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__4__Impl"


    // $ANTLR start "rule__Wall__Group__5"
    // InternalLevelDesign.g:1817:1: rule__Wall__Group__5 : rule__Wall__Group__5__Impl ;
    public final void rule__Wall__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1821:1: ( rule__Wall__Group__5__Impl )
            // InternalLevelDesign.g:1822:2: rule__Wall__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Wall__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__5"


    // $ANTLR start "rule__Wall__Group__5__Impl"
    // InternalLevelDesign.g:1828:1: rule__Wall__Group__5__Impl : ( ( rule__Wall__ToAssignment_5 ) ) ;
    public final void rule__Wall__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1832:1: ( ( ( rule__Wall__ToAssignment_5 ) ) )
            // InternalLevelDesign.g:1833:1: ( ( rule__Wall__ToAssignment_5 ) )
            {
            // InternalLevelDesign.g:1833:1: ( ( rule__Wall__ToAssignment_5 ) )
            // InternalLevelDesign.g:1834:2: ( rule__Wall__ToAssignment_5 )
            {
             before(grammarAccess.getWallAccess().getToAssignment_5()); 
            // InternalLevelDesign.g:1835:2: ( rule__Wall__ToAssignment_5 )
            // InternalLevelDesign.g:1835:3: rule__Wall__ToAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Wall__ToAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getWallAccess().getToAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__Group__5__Impl"


    // $ANTLR start "rule__Entry__Group__0"
    // InternalLevelDesign.g:1844:1: rule__Entry__Group__0 : rule__Entry__Group__0__Impl rule__Entry__Group__1 ;
    public final void rule__Entry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1848:1: ( rule__Entry__Group__0__Impl rule__Entry__Group__1 )
            // InternalLevelDesign.g:1849:2: rule__Entry__Group__0__Impl rule__Entry__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Entry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__0"


    // $ANTLR start "rule__Entry__Group__0__Impl"
    // InternalLevelDesign.g:1856:1: rule__Entry__Group__0__Impl : ( 'entry' ) ;
    public final void rule__Entry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1860:1: ( ( 'entry' ) )
            // InternalLevelDesign.g:1861:1: ( 'entry' )
            {
            // InternalLevelDesign.g:1861:1: ( 'entry' )
            // InternalLevelDesign.g:1862:2: 'entry'
            {
             before(grammarAccess.getEntryAccess().getEntryKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getEntryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__0__Impl"


    // $ANTLR start "rule__Entry__Group__1"
    // InternalLevelDesign.g:1871:1: rule__Entry__Group__1 : rule__Entry__Group__1__Impl rule__Entry__Group__2 ;
    public final void rule__Entry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1875:1: ( rule__Entry__Group__1__Impl rule__Entry__Group__2 )
            // InternalLevelDesign.g:1876:2: rule__Entry__Group__1__Impl rule__Entry__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Entry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__1"


    // $ANTLR start "rule__Entry__Group__1__Impl"
    // InternalLevelDesign.g:1883:1: rule__Entry__Group__1__Impl : ( ( rule__Entry__NameAssignment_1 ) ) ;
    public final void rule__Entry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1887:1: ( ( ( rule__Entry__NameAssignment_1 ) ) )
            // InternalLevelDesign.g:1888:1: ( ( rule__Entry__NameAssignment_1 ) )
            {
            // InternalLevelDesign.g:1888:1: ( ( rule__Entry__NameAssignment_1 ) )
            // InternalLevelDesign.g:1889:2: ( rule__Entry__NameAssignment_1 )
            {
             before(grammarAccess.getEntryAccess().getNameAssignment_1()); 
            // InternalLevelDesign.g:1890:2: ( rule__Entry__NameAssignment_1 )
            // InternalLevelDesign.g:1890:3: rule__Entry__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Entry__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__1__Impl"


    // $ANTLR start "rule__Entry__Group__2"
    // InternalLevelDesign.g:1898:1: rule__Entry__Group__2 : rule__Entry__Group__2__Impl rule__Entry__Group__3 ;
    public final void rule__Entry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1902:1: ( rule__Entry__Group__2__Impl rule__Entry__Group__3 )
            // InternalLevelDesign.g:1903:2: rule__Entry__Group__2__Impl rule__Entry__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Entry__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entry__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__2"


    // $ANTLR start "rule__Entry__Group__2__Impl"
    // InternalLevelDesign.g:1910:1: rule__Entry__Group__2__Impl : ( ( '@' )? ) ;
    public final void rule__Entry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1914:1: ( ( ( '@' )? ) )
            // InternalLevelDesign.g:1915:1: ( ( '@' )? )
            {
            // InternalLevelDesign.g:1915:1: ( ( '@' )? )
            // InternalLevelDesign.g:1916:2: ( '@' )?
            {
             before(grammarAccess.getEntryAccess().getCommercialAtKeyword_2()); 
            // InternalLevelDesign.g:1917:2: ( '@' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalLevelDesign.g:1917:3: '@'
                    {
                    match(input,22,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEntryAccess().getCommercialAtKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__2__Impl"


    // $ANTLR start "rule__Entry__Group__3"
    // InternalLevelDesign.g:1925:1: rule__Entry__Group__3 : rule__Entry__Group__3__Impl ;
    public final void rule__Entry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1929:1: ( rule__Entry__Group__3__Impl )
            // InternalLevelDesign.g:1930:2: rule__Entry__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entry__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__3"


    // $ANTLR start "rule__Entry__Group__3__Impl"
    // InternalLevelDesign.g:1936:1: rule__Entry__Group__3__Impl : ( ( rule__Entry__PositionAssignment_3 ) ) ;
    public final void rule__Entry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1940:1: ( ( ( rule__Entry__PositionAssignment_3 ) ) )
            // InternalLevelDesign.g:1941:1: ( ( rule__Entry__PositionAssignment_3 ) )
            {
            // InternalLevelDesign.g:1941:1: ( ( rule__Entry__PositionAssignment_3 ) )
            // InternalLevelDesign.g:1942:2: ( rule__Entry__PositionAssignment_3 )
            {
             before(grammarAccess.getEntryAccess().getPositionAssignment_3()); 
            // InternalLevelDesign.g:1943:2: ( rule__Entry__PositionAssignment_3 )
            // InternalLevelDesign.g:1943:3: rule__Entry__PositionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Entry__PositionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEntryAccess().getPositionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__Group__3__Impl"


    // $ANTLR start "rule__Exit__Group__0"
    // InternalLevelDesign.g:1952:1: rule__Exit__Group__0 : rule__Exit__Group__0__Impl rule__Exit__Group__1 ;
    public final void rule__Exit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1956:1: ( rule__Exit__Group__0__Impl rule__Exit__Group__1 )
            // InternalLevelDesign.g:1957:2: rule__Exit__Group__0__Impl rule__Exit__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Exit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exit__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__0"


    // $ANTLR start "rule__Exit__Group__0__Impl"
    // InternalLevelDesign.g:1964:1: rule__Exit__Group__0__Impl : ( 'exit' ) ;
    public final void rule__Exit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1968:1: ( ( 'exit' ) )
            // InternalLevelDesign.g:1969:1: ( 'exit' )
            {
            // InternalLevelDesign.g:1969:1: ( 'exit' )
            // InternalLevelDesign.g:1970:2: 'exit'
            {
             before(grammarAccess.getExitAccess().getExitKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getExitAccess().getExitKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__0__Impl"


    // $ANTLR start "rule__Exit__Group__1"
    // InternalLevelDesign.g:1979:1: rule__Exit__Group__1 : rule__Exit__Group__1__Impl rule__Exit__Group__2 ;
    public final void rule__Exit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1983:1: ( rule__Exit__Group__1__Impl rule__Exit__Group__2 )
            // InternalLevelDesign.g:1984:2: rule__Exit__Group__1__Impl rule__Exit__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Exit__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exit__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__1"


    // $ANTLR start "rule__Exit__Group__1__Impl"
    // InternalLevelDesign.g:1991:1: rule__Exit__Group__1__Impl : ( ( rule__Exit__NameAssignment_1 ) ) ;
    public final void rule__Exit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:1995:1: ( ( ( rule__Exit__NameAssignment_1 ) ) )
            // InternalLevelDesign.g:1996:1: ( ( rule__Exit__NameAssignment_1 ) )
            {
            // InternalLevelDesign.g:1996:1: ( ( rule__Exit__NameAssignment_1 ) )
            // InternalLevelDesign.g:1997:2: ( rule__Exit__NameAssignment_1 )
            {
             before(grammarAccess.getExitAccess().getNameAssignment_1()); 
            // InternalLevelDesign.g:1998:2: ( rule__Exit__NameAssignment_1 )
            // InternalLevelDesign.g:1998:3: rule__Exit__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Exit__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExitAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__1__Impl"


    // $ANTLR start "rule__Exit__Group__2"
    // InternalLevelDesign.g:2006:1: rule__Exit__Group__2 : rule__Exit__Group__2__Impl rule__Exit__Group__3 ;
    public final void rule__Exit__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2010:1: ( rule__Exit__Group__2__Impl rule__Exit__Group__3 )
            // InternalLevelDesign.g:2011:2: rule__Exit__Group__2__Impl rule__Exit__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Exit__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exit__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__2"


    // $ANTLR start "rule__Exit__Group__2__Impl"
    // InternalLevelDesign.g:2018:1: rule__Exit__Group__2__Impl : ( ( '@' )? ) ;
    public final void rule__Exit__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2022:1: ( ( ( '@' )? ) )
            // InternalLevelDesign.g:2023:1: ( ( '@' )? )
            {
            // InternalLevelDesign.g:2023:1: ( ( '@' )? )
            // InternalLevelDesign.g:2024:2: ( '@' )?
            {
             before(grammarAccess.getExitAccess().getCommercialAtKeyword_2()); 
            // InternalLevelDesign.g:2025:2: ( '@' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalLevelDesign.g:2025:3: '@'
                    {
                    match(input,22,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getExitAccess().getCommercialAtKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__2__Impl"


    // $ANTLR start "rule__Exit__Group__3"
    // InternalLevelDesign.g:2033:1: rule__Exit__Group__3 : rule__Exit__Group__3__Impl ;
    public final void rule__Exit__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2037:1: ( rule__Exit__Group__3__Impl )
            // InternalLevelDesign.g:2038:2: rule__Exit__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exit__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__3"


    // $ANTLR start "rule__Exit__Group__3__Impl"
    // InternalLevelDesign.g:2044:1: rule__Exit__Group__3__Impl : ( ( rule__Exit__PositionAssignment_3 ) ) ;
    public final void rule__Exit__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2048:1: ( ( ( rule__Exit__PositionAssignment_3 ) ) )
            // InternalLevelDesign.g:2049:1: ( ( rule__Exit__PositionAssignment_3 ) )
            {
            // InternalLevelDesign.g:2049:1: ( ( rule__Exit__PositionAssignment_3 ) )
            // InternalLevelDesign.g:2050:2: ( rule__Exit__PositionAssignment_3 )
            {
             before(grammarAccess.getExitAccess().getPositionAssignment_3()); 
            // InternalLevelDesign.g:2051:2: ( rule__Exit__PositionAssignment_3 )
            // InternalLevelDesign.g:2051:3: rule__Exit__PositionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Exit__PositionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getExitAccess().getPositionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__Group__3__Impl"


    // $ANTLR start "rule__Coordinate__Group_0__0"
    // InternalLevelDesign.g:2060:1: rule__Coordinate__Group_0__0 : rule__Coordinate__Group_0__0__Impl rule__Coordinate__Group_0__1 ;
    public final void rule__Coordinate__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2064:1: ( rule__Coordinate__Group_0__0__Impl rule__Coordinate__Group_0__1 )
            // InternalLevelDesign.g:2065:2: rule__Coordinate__Group_0__0__Impl rule__Coordinate__Group_0__1
            {
            pushFollow(FOLLOW_28);
            rule__Coordinate__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__0"


    // $ANTLR start "rule__Coordinate__Group_0__0__Impl"
    // InternalLevelDesign.g:2072:1: rule__Coordinate__Group_0__0__Impl : ( '(' ) ;
    public final void rule__Coordinate__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2076:1: ( ( '(' ) )
            // InternalLevelDesign.g:2077:1: ( '(' )
            {
            // InternalLevelDesign.g:2077:1: ( '(' )
            // InternalLevelDesign.g:2078:2: '('
            {
             before(grammarAccess.getCoordinateAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__0__Impl"


    // $ANTLR start "rule__Coordinate__Group_0__1"
    // InternalLevelDesign.g:2087:1: rule__Coordinate__Group_0__1 : rule__Coordinate__Group_0__1__Impl rule__Coordinate__Group_0__2 ;
    public final void rule__Coordinate__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2091:1: ( rule__Coordinate__Group_0__1__Impl rule__Coordinate__Group_0__2 )
            // InternalLevelDesign.g:2092:2: rule__Coordinate__Group_0__1__Impl rule__Coordinate__Group_0__2
            {
            pushFollow(FOLLOW_29);
            rule__Coordinate__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__1"


    // $ANTLR start "rule__Coordinate__Group_0__1__Impl"
    // InternalLevelDesign.g:2099:1: rule__Coordinate__Group_0__1__Impl : ( ( rule__Coordinate__ColumnAssignment_0_1 ) ) ;
    public final void rule__Coordinate__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2103:1: ( ( ( rule__Coordinate__ColumnAssignment_0_1 ) ) )
            // InternalLevelDesign.g:2104:1: ( ( rule__Coordinate__ColumnAssignment_0_1 ) )
            {
            // InternalLevelDesign.g:2104:1: ( ( rule__Coordinate__ColumnAssignment_0_1 ) )
            // InternalLevelDesign.g:2105:2: ( rule__Coordinate__ColumnAssignment_0_1 )
            {
             before(grammarAccess.getCoordinateAccess().getColumnAssignment_0_1()); 
            // InternalLevelDesign.g:2106:2: ( rule__Coordinate__ColumnAssignment_0_1 )
            // InternalLevelDesign.g:2106:3: rule__Coordinate__ColumnAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__ColumnAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinateAccess().getColumnAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__1__Impl"


    // $ANTLR start "rule__Coordinate__Group_0__2"
    // InternalLevelDesign.g:2114:1: rule__Coordinate__Group_0__2 : rule__Coordinate__Group_0__2__Impl rule__Coordinate__Group_0__3 ;
    public final void rule__Coordinate__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2118:1: ( rule__Coordinate__Group_0__2__Impl rule__Coordinate__Group_0__3 )
            // InternalLevelDesign.g:2119:2: rule__Coordinate__Group_0__2__Impl rule__Coordinate__Group_0__3
            {
            pushFollow(FOLLOW_28);
            rule__Coordinate__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__2"


    // $ANTLR start "rule__Coordinate__Group_0__2__Impl"
    // InternalLevelDesign.g:2126:1: rule__Coordinate__Group_0__2__Impl : ( ',' ) ;
    public final void rule__Coordinate__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2130:1: ( ( ',' ) )
            // InternalLevelDesign.g:2131:1: ( ',' )
            {
            // InternalLevelDesign.g:2131:1: ( ',' )
            // InternalLevelDesign.g:2132:2: ','
            {
             before(grammarAccess.getCoordinateAccess().getCommaKeyword_0_2()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getCommaKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__2__Impl"


    // $ANTLR start "rule__Coordinate__Group_0__3"
    // InternalLevelDesign.g:2141:1: rule__Coordinate__Group_0__3 : rule__Coordinate__Group_0__3__Impl rule__Coordinate__Group_0__4 ;
    public final void rule__Coordinate__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2145:1: ( rule__Coordinate__Group_0__3__Impl rule__Coordinate__Group_0__4 )
            // InternalLevelDesign.g:2146:2: rule__Coordinate__Group_0__3__Impl rule__Coordinate__Group_0__4
            {
            pushFollow(FOLLOW_30);
            rule__Coordinate__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__3"


    // $ANTLR start "rule__Coordinate__Group_0__3__Impl"
    // InternalLevelDesign.g:2153:1: rule__Coordinate__Group_0__3__Impl : ( ( rule__Coordinate__RowAssignment_0_3 ) ) ;
    public final void rule__Coordinate__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2157:1: ( ( ( rule__Coordinate__RowAssignment_0_3 ) ) )
            // InternalLevelDesign.g:2158:1: ( ( rule__Coordinate__RowAssignment_0_3 ) )
            {
            // InternalLevelDesign.g:2158:1: ( ( rule__Coordinate__RowAssignment_0_3 ) )
            // InternalLevelDesign.g:2159:2: ( rule__Coordinate__RowAssignment_0_3 )
            {
             before(grammarAccess.getCoordinateAccess().getRowAssignment_0_3()); 
            // InternalLevelDesign.g:2160:2: ( rule__Coordinate__RowAssignment_0_3 )
            // InternalLevelDesign.g:2160:3: rule__Coordinate__RowAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__RowAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getCoordinateAccess().getRowAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__3__Impl"


    // $ANTLR start "rule__Coordinate__Group_0__4"
    // InternalLevelDesign.g:2168:1: rule__Coordinate__Group_0__4 : rule__Coordinate__Group_0__4__Impl ;
    public final void rule__Coordinate__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2172:1: ( rule__Coordinate__Group_0__4__Impl )
            // InternalLevelDesign.g:2173:2: rule__Coordinate__Group_0__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__4"


    // $ANTLR start "rule__Coordinate__Group_0__4__Impl"
    // InternalLevelDesign.g:2179:1: rule__Coordinate__Group_0__4__Impl : ( ')' ) ;
    public final void rule__Coordinate__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2183:1: ( ( ')' ) )
            // InternalLevelDesign.g:2184:1: ( ')' )
            {
            // InternalLevelDesign.g:2184:1: ( ')' )
            // InternalLevelDesign.g:2185:2: ')'
            {
             before(grammarAccess.getCoordinateAccess().getRightParenthesisKeyword_0_4()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getRightParenthesisKeyword_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_0__4__Impl"


    // $ANTLR start "rule__Coordinate__Group_1__0"
    // InternalLevelDesign.g:2195:1: rule__Coordinate__Group_1__0 : rule__Coordinate__Group_1__0__Impl rule__Coordinate__Group_1__1 ;
    public final void rule__Coordinate__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2199:1: ( rule__Coordinate__Group_1__0__Impl rule__Coordinate__Group_1__1 )
            // InternalLevelDesign.g:2200:2: rule__Coordinate__Group_1__0__Impl rule__Coordinate__Group_1__1
            {
            pushFollow(FOLLOW_29);
            rule__Coordinate__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_1__0"


    // $ANTLR start "rule__Coordinate__Group_1__0__Impl"
    // InternalLevelDesign.g:2207:1: rule__Coordinate__Group_1__0__Impl : ( ( rule__Coordinate__ColumnAssignment_1_0 ) ) ;
    public final void rule__Coordinate__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2211:1: ( ( ( rule__Coordinate__ColumnAssignment_1_0 ) ) )
            // InternalLevelDesign.g:2212:1: ( ( rule__Coordinate__ColumnAssignment_1_0 ) )
            {
            // InternalLevelDesign.g:2212:1: ( ( rule__Coordinate__ColumnAssignment_1_0 ) )
            // InternalLevelDesign.g:2213:2: ( rule__Coordinate__ColumnAssignment_1_0 )
            {
             before(grammarAccess.getCoordinateAccess().getColumnAssignment_1_0()); 
            // InternalLevelDesign.g:2214:2: ( rule__Coordinate__ColumnAssignment_1_0 )
            // InternalLevelDesign.g:2214:3: rule__Coordinate__ColumnAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__ColumnAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getCoordinateAccess().getColumnAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_1__0__Impl"


    // $ANTLR start "rule__Coordinate__Group_1__1"
    // InternalLevelDesign.g:2222:1: rule__Coordinate__Group_1__1 : rule__Coordinate__Group_1__1__Impl rule__Coordinate__Group_1__2 ;
    public final void rule__Coordinate__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2226:1: ( rule__Coordinate__Group_1__1__Impl rule__Coordinate__Group_1__2 )
            // InternalLevelDesign.g:2227:2: rule__Coordinate__Group_1__1__Impl rule__Coordinate__Group_1__2
            {
            pushFollow(FOLLOW_28);
            rule__Coordinate__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_1__1"


    // $ANTLR start "rule__Coordinate__Group_1__1__Impl"
    // InternalLevelDesign.g:2234:1: rule__Coordinate__Group_1__1__Impl : ( ',' ) ;
    public final void rule__Coordinate__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2238:1: ( ( ',' ) )
            // InternalLevelDesign.g:2239:1: ( ',' )
            {
            // InternalLevelDesign.g:2239:1: ( ',' )
            // InternalLevelDesign.g:2240:2: ','
            {
             before(grammarAccess.getCoordinateAccess().getCommaKeyword_1_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getCommaKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_1__1__Impl"


    // $ANTLR start "rule__Coordinate__Group_1__2"
    // InternalLevelDesign.g:2249:1: rule__Coordinate__Group_1__2 : rule__Coordinate__Group_1__2__Impl ;
    public final void rule__Coordinate__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2253:1: ( rule__Coordinate__Group_1__2__Impl )
            // InternalLevelDesign.g:2254:2: rule__Coordinate__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_1__2"


    // $ANTLR start "rule__Coordinate__Group_1__2__Impl"
    // InternalLevelDesign.g:2260:1: rule__Coordinate__Group_1__2__Impl : ( ( rule__Coordinate__RowAssignment_1_2 ) ) ;
    public final void rule__Coordinate__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2264:1: ( ( ( rule__Coordinate__RowAssignment_1_2 ) ) )
            // InternalLevelDesign.g:2265:1: ( ( rule__Coordinate__RowAssignment_1_2 ) )
            {
            // InternalLevelDesign.g:2265:1: ( ( rule__Coordinate__RowAssignment_1_2 ) )
            // InternalLevelDesign.g:2266:2: ( rule__Coordinate__RowAssignment_1_2 )
            {
             before(grammarAccess.getCoordinateAccess().getRowAssignment_1_2()); 
            // InternalLevelDesign.g:2267:2: ( rule__Coordinate__RowAssignment_1_2 )
            // InternalLevelDesign.g:2267:3: rule__Coordinate__RowAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Coordinate__RowAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getCoordinateAccess().getRowAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__Group_1__2__Impl"


    // $ANTLR start "rule__Level__SpawnRoomAssignment_2"
    // InternalLevelDesign.g:2276:1: rule__Level__SpawnRoomAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__SpawnRoomAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2280:1: ( ( ( RULE_ID ) ) )
            // InternalLevelDesign.g:2281:2: ( ( RULE_ID ) )
            {
            // InternalLevelDesign.g:2281:2: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2282:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getSpawnRoomRoomCrossReference_2_0()); 
            // InternalLevelDesign.g:2283:3: ( RULE_ID )
            // InternalLevelDesign.g:2284:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getSpawnRoomRoomIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getSpawnRoomRoomIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getSpawnRoomRoomCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__SpawnRoomAssignment_2"


    // $ANTLR start "rule__Level__GoalRoomAssignment_5"
    // InternalLevelDesign.g:2295:1: rule__Level__GoalRoomAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Level__GoalRoomAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2299:1: ( ( ( RULE_ID ) ) )
            // InternalLevelDesign.g:2300:2: ( ( RULE_ID ) )
            {
            // InternalLevelDesign.g:2300:2: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2301:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getGoalRoomRoomCrossReference_5_0()); 
            // InternalLevelDesign.g:2302:3: ( RULE_ID )
            // InternalLevelDesign.g:2303:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getGoalRoomRoomIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getGoalRoomRoomIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getGoalRoomRoomCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__GoalRoomAssignment_5"


    // $ANTLR start "rule__Level__RoomsAssignment_6"
    // InternalLevelDesign.g:2314:1: rule__Level__RoomsAssignment_6 : ( ruleRoom ) ;
    public final void rule__Level__RoomsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2318:1: ( ( ruleRoom ) )
            // InternalLevelDesign.g:2319:2: ( ruleRoom )
            {
            // InternalLevelDesign.g:2319:2: ( ruleRoom )
            // InternalLevelDesign.g:2320:3: ruleRoom
            {
             before(grammarAccess.getLevelAccess().getRoomsRoomParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleRoom();

            state._fsp--;

             after(grammarAccess.getLevelAccess().getRoomsRoomParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__RoomsAssignment_6"


    // $ANTLR start "rule__Room__NameAssignment_1"
    // InternalLevelDesign.g:2329:1: rule__Room__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Room__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2333:1: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2334:2: ( RULE_ID )
            {
            // InternalLevelDesign.g:2334:2: ( RULE_ID )
            // InternalLevelDesign.g:2335:3: RULE_ID
            {
             before(grammarAccess.getRoomAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__NameAssignment_1"


    // $ANTLR start "rule__Room__ColumnsAssignment_5"
    // InternalLevelDesign.g:2344:1: rule__Room__ColumnsAssignment_5 : ( RULE_INT ) ;
    public final void rule__Room__ColumnsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2348:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2349:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2349:2: ( RULE_INT )
            // InternalLevelDesign.g:2350:3: RULE_INT
            {
             before(grammarAccess.getRoomAccess().getColumnsINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getColumnsINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__ColumnsAssignment_5"


    // $ANTLR start "rule__Room__RowsAssignment_8"
    // InternalLevelDesign.g:2359:1: rule__Room__RowsAssignment_8 : ( RULE_INT ) ;
    public final void rule__Room__RowsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2363:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2364:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2364:2: ( RULE_INT )
            // InternalLevelDesign.g:2365:3: RULE_INT
            {
             before(grammarAccess.getRoomAccess().getRowsINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getRoomAccess().getRowsINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__RowsAssignment_8"


    // $ANTLR start "rule__Room__EntryAssignment_9"
    // InternalLevelDesign.g:2374:1: rule__Room__EntryAssignment_9 : ( ruleEntry ) ;
    public final void rule__Room__EntryAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2378:1: ( ( ruleEntry ) )
            // InternalLevelDesign.g:2379:2: ( ruleEntry )
            {
            // InternalLevelDesign.g:2379:2: ( ruleEntry )
            // InternalLevelDesign.g:2380:3: ruleEntry
            {
             before(grammarAccess.getRoomAccess().getEntryEntryParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleEntry();

            state._fsp--;

             after(grammarAccess.getRoomAccess().getEntryEntryParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__EntryAssignment_9"


    // $ANTLR start "rule__Room__ExitAssignment_10"
    // InternalLevelDesign.g:2389:1: rule__Room__ExitAssignment_10 : ( ruleExit ) ;
    public final void rule__Room__ExitAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2393:1: ( ( ruleExit ) )
            // InternalLevelDesign.g:2394:2: ( ruleExit )
            {
            // InternalLevelDesign.g:2394:2: ( ruleExit )
            // InternalLevelDesign.g:2395:3: ruleExit
            {
             before(grammarAccess.getRoomAccess().getExitExitParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleExit();

            state._fsp--;

             after(grammarAccess.getRoomAccess().getExitExitParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__ExitAssignment_10"


    // $ANTLR start "rule__Room__ExitConnectionAssignment_11"
    // InternalLevelDesign.g:2404:1: rule__Room__ExitConnectionAssignment_11 : ( ruleConnection ) ;
    public final void rule__Room__ExitConnectionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2408:1: ( ( ruleConnection ) )
            // InternalLevelDesign.g:2409:2: ( ruleConnection )
            {
            // InternalLevelDesign.g:2409:2: ( ruleConnection )
            // InternalLevelDesign.g:2410:3: ruleConnection
            {
             before(grammarAccess.getRoomAccess().getExitConnectionConnectionParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleConnection();

            state._fsp--;

             after(grammarAccess.getRoomAccess().getExitConnectionConnectionParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__ExitConnectionAssignment_11"


    // $ANTLR start "rule__Room__WallsAssignment_12"
    // InternalLevelDesign.g:2419:1: rule__Room__WallsAssignment_12 : ( ruleWall ) ;
    public final void rule__Room__WallsAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2423:1: ( ( ruleWall ) )
            // InternalLevelDesign.g:2424:2: ( ruleWall )
            {
            // InternalLevelDesign.g:2424:2: ( ruleWall )
            // InternalLevelDesign.g:2425:3: ruleWall
            {
             before(grammarAccess.getRoomAccess().getWallsWallParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleWall();

            state._fsp--;

             after(grammarAccess.getRoomAccess().getWallsWallParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__WallsAssignment_12"


    // $ANTLR start "rule__Room__TrapdoorsAssignment_13"
    // InternalLevelDesign.g:2434:1: rule__Room__TrapdoorsAssignment_13 : ( ruleTrapdoor ) ;
    public final void rule__Room__TrapdoorsAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2438:1: ( ( ruleTrapdoor ) )
            // InternalLevelDesign.g:2439:2: ( ruleTrapdoor )
            {
            // InternalLevelDesign.g:2439:2: ( ruleTrapdoor )
            // InternalLevelDesign.g:2440:3: ruleTrapdoor
            {
             before(grammarAccess.getRoomAccess().getTrapdoorsTrapdoorParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleTrapdoor();

            state._fsp--;

             after(grammarAccess.getRoomAccess().getTrapdoorsTrapdoorParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__TrapdoorsAssignment_13"


    // $ANTLR start "rule__Room__MonstersAssignment_14"
    // InternalLevelDesign.g:2449:1: rule__Room__MonstersAssignment_14 : ( ruleMonster ) ;
    public final void rule__Room__MonstersAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2453:1: ( ( ruleMonster ) )
            // InternalLevelDesign.g:2454:2: ( ruleMonster )
            {
            // InternalLevelDesign.g:2454:2: ( ruleMonster )
            // InternalLevelDesign.g:2455:3: ruleMonster
            {
             before(grammarAccess.getRoomAccess().getMonstersMonsterParserRuleCall_14_0()); 
            pushFollow(FOLLOW_2);
            ruleMonster();

            state._fsp--;

             after(grammarAccess.getRoomAccess().getMonstersMonsterParserRuleCall_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Room__MonstersAssignment_14"


    // $ANTLR start "rule__Connection__TypeAssignment_0"
    // InternalLevelDesign.g:2464:1: rule__Connection__TypeAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Connection__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2468:1: ( ( RULE_STRING ) )
            // InternalLevelDesign.g:2469:2: ( RULE_STRING )
            {
            // InternalLevelDesign.g:2469:2: ( RULE_STRING )
            // InternalLevelDesign.g:2470:3: RULE_STRING
            {
             before(grammarAccess.getConnectionAccess().getTypeSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConnectionAccess().getTypeSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__TypeAssignment_0"


    // $ANTLR start "rule__Connection__NextRoomAssignment_2"
    // InternalLevelDesign.g:2479:1: rule__Connection__NextRoomAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Connection__NextRoomAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2483:1: ( ( ( RULE_ID ) ) )
            // InternalLevelDesign.g:2484:2: ( ( RULE_ID ) )
            {
            // InternalLevelDesign.g:2484:2: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2485:3: ( RULE_ID )
            {
             before(grammarAccess.getConnectionAccess().getNextRoomRoomCrossReference_2_0()); 
            // InternalLevelDesign.g:2486:3: ( RULE_ID )
            // InternalLevelDesign.g:2487:4: RULE_ID
            {
             before(grammarAccess.getConnectionAccess().getNextRoomRoomIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConnectionAccess().getNextRoomRoomIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getConnectionAccess().getNextRoomRoomCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Connection__NextRoomAssignment_2"


    // $ANTLR start "rule__Monster__NameAssignment_1"
    // InternalLevelDesign.g:2498:1: rule__Monster__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Monster__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2502:1: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2503:2: ( RULE_ID )
            {
            // InternalLevelDesign.g:2503:2: ( RULE_ID )
            // InternalLevelDesign.g:2504:3: RULE_ID
            {
             before(grammarAccess.getMonsterAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__NameAssignment_1"


    // $ANTLR start "rule__Monster__PositionAssignment_3"
    // InternalLevelDesign.g:2513:1: rule__Monster__PositionAssignment_3 : ( ruleCoordinate ) ;
    public final void rule__Monster__PositionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2517:1: ( ( ruleCoordinate ) )
            // InternalLevelDesign.g:2518:2: ( ruleCoordinate )
            {
            // InternalLevelDesign.g:2518:2: ( ruleCoordinate )
            // InternalLevelDesign.g:2519:3: ruleCoordinate
            {
             before(grammarAccess.getMonsterAccess().getPositionCoordinateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getMonsterAccess().getPositionCoordinateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__PositionAssignment_3"


    // $ANTLR start "rule__Monster__HpAssignment_7"
    // InternalLevelDesign.g:2528:1: rule__Monster__HpAssignment_7 : ( RULE_INT ) ;
    public final void rule__Monster__HpAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2532:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2533:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2533:2: ( RULE_INT )
            // InternalLevelDesign.g:2534:3: RULE_INT
            {
             before(grammarAccess.getMonsterAccess().getHpINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getHpINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__HpAssignment_7"


    // $ANTLR start "rule__Monster__DamageAssignment_10"
    // InternalLevelDesign.g:2543:1: rule__Monster__DamageAssignment_10 : ( RULE_INT ) ;
    public final void rule__Monster__DamageAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2547:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2548:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2548:2: ( RULE_INT )
            // InternalLevelDesign.g:2549:3: RULE_INT
            {
             before(grammarAccess.getMonsterAccess().getDamageINTTerminalRuleCall_10_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getDamageINTTerminalRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__DamageAssignment_10"


    // $ANTLR start "rule__Monster__SpeedAssignment_13"
    // InternalLevelDesign.g:2558:1: rule__Monster__SpeedAssignment_13 : ( RULE_DOUBLE ) ;
    public final void rule__Monster__SpeedAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2562:1: ( ( RULE_DOUBLE ) )
            // InternalLevelDesign.g:2563:2: ( RULE_DOUBLE )
            {
            // InternalLevelDesign.g:2563:2: ( RULE_DOUBLE )
            // InternalLevelDesign.g:2564:3: RULE_DOUBLE
            {
             before(grammarAccess.getMonsterAccess().getSpeedDOUBLETerminalRuleCall_13_0()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getSpeedDOUBLETerminalRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__SpeedAssignment_13"


    // $ANTLR start "rule__Monster__RangeAssignment_16"
    // InternalLevelDesign.g:2573:1: rule__Monster__RangeAssignment_16 : ( RULE_INT ) ;
    public final void rule__Monster__RangeAssignment_16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2577:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2578:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2578:2: ( RULE_INT )
            // InternalLevelDesign.g:2579:3: RULE_INT
            {
             before(grammarAccess.getMonsterAccess().getRangeINTTerminalRuleCall_16_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getRangeINTTerminalRuleCall_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__RangeAssignment_16"


    // $ANTLR start "rule__Monster__AggroRadiusAssignment_19"
    // InternalLevelDesign.g:2588:1: rule__Monster__AggroRadiusAssignment_19 : ( RULE_INT ) ;
    public final void rule__Monster__AggroRadiusAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2592:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2593:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2593:2: ( RULE_INT )
            // InternalLevelDesign.g:2594:3: RULE_INT
            {
             before(grammarAccess.getMonsterAccess().getAggroRadiusINTTerminalRuleCall_19_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMonsterAccess().getAggroRadiusINTTerminalRuleCall_19_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monster__AggroRadiusAssignment_19"


    // $ANTLR start "rule__Trapdoor__NameAssignment_1"
    // InternalLevelDesign.g:2603:1: rule__Trapdoor__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Trapdoor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2607:1: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2608:2: ( RULE_ID )
            {
            // InternalLevelDesign.g:2608:2: ( RULE_ID )
            // InternalLevelDesign.g:2609:3: RULE_ID
            {
             before(grammarAccess.getTrapdoorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTrapdoorAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__NameAssignment_1"


    // $ANTLR start "rule__Trapdoor__PositionAssignment_3"
    // InternalLevelDesign.g:2618:1: rule__Trapdoor__PositionAssignment_3 : ( ruleCoordinate ) ;
    public final void rule__Trapdoor__PositionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2622:1: ( ( ruleCoordinate ) )
            // InternalLevelDesign.g:2623:2: ( ruleCoordinate )
            {
            // InternalLevelDesign.g:2623:2: ( ruleCoordinate )
            // InternalLevelDesign.g:2624:3: ruleCoordinate
            {
             before(grammarAccess.getTrapdoorAccess().getPositionCoordinateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getTrapdoorAccess().getPositionCoordinateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Trapdoor__PositionAssignment_3"


    // $ANTLR start "rule__Wall__NameAssignment_1"
    // InternalLevelDesign.g:2633:1: rule__Wall__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Wall__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2637:1: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2638:2: ( RULE_ID )
            {
            // InternalLevelDesign.g:2638:2: ( RULE_ID )
            // InternalLevelDesign.g:2639:3: RULE_ID
            {
             before(grammarAccess.getWallAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWallAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__NameAssignment_1"


    // $ANTLR start "rule__Wall__FromAssignment_3"
    // InternalLevelDesign.g:2648:1: rule__Wall__FromAssignment_3 : ( ruleCoordinate ) ;
    public final void rule__Wall__FromAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2652:1: ( ( ruleCoordinate ) )
            // InternalLevelDesign.g:2653:2: ( ruleCoordinate )
            {
            // InternalLevelDesign.g:2653:2: ( ruleCoordinate )
            // InternalLevelDesign.g:2654:3: ruleCoordinate
            {
             before(grammarAccess.getWallAccess().getFromCoordinateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getWallAccess().getFromCoordinateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__FromAssignment_3"


    // $ANTLR start "rule__Wall__ToAssignment_5"
    // InternalLevelDesign.g:2663:1: rule__Wall__ToAssignment_5 : ( ruleCoordinate ) ;
    public final void rule__Wall__ToAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2667:1: ( ( ruleCoordinate ) )
            // InternalLevelDesign.g:2668:2: ( ruleCoordinate )
            {
            // InternalLevelDesign.g:2668:2: ( ruleCoordinate )
            // InternalLevelDesign.g:2669:3: ruleCoordinate
            {
             before(grammarAccess.getWallAccess().getToCoordinateParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getWallAccess().getToCoordinateParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wall__ToAssignment_5"


    // $ANTLR start "rule__Entry__NameAssignment_1"
    // InternalLevelDesign.g:2678:1: rule__Entry__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entry__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2682:1: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2683:2: ( RULE_ID )
            {
            // InternalLevelDesign.g:2683:2: ( RULE_ID )
            // InternalLevelDesign.g:2684:3: RULE_ID
            {
             before(grammarAccess.getEntryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEntryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__NameAssignment_1"


    // $ANTLR start "rule__Entry__PositionAssignment_3"
    // InternalLevelDesign.g:2693:1: rule__Entry__PositionAssignment_3 : ( ruleCoordinate ) ;
    public final void rule__Entry__PositionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2697:1: ( ( ruleCoordinate ) )
            // InternalLevelDesign.g:2698:2: ( ruleCoordinate )
            {
            // InternalLevelDesign.g:2698:2: ( ruleCoordinate )
            // InternalLevelDesign.g:2699:3: ruleCoordinate
            {
             before(grammarAccess.getEntryAccess().getPositionCoordinateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getEntryAccess().getPositionCoordinateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entry__PositionAssignment_3"


    // $ANTLR start "rule__Exit__NameAssignment_1"
    // InternalLevelDesign.g:2708:1: rule__Exit__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Exit__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2712:1: ( ( RULE_ID ) )
            // InternalLevelDesign.g:2713:2: ( RULE_ID )
            {
            // InternalLevelDesign.g:2713:2: ( RULE_ID )
            // InternalLevelDesign.g:2714:3: RULE_ID
            {
             before(grammarAccess.getExitAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExitAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__NameAssignment_1"


    // $ANTLR start "rule__Exit__PositionAssignment_3"
    // InternalLevelDesign.g:2723:1: rule__Exit__PositionAssignment_3 : ( ruleCoordinate ) ;
    public final void rule__Exit__PositionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2727:1: ( ( ruleCoordinate ) )
            // InternalLevelDesign.g:2728:2: ( ruleCoordinate )
            {
            // InternalLevelDesign.g:2728:2: ( ruleCoordinate )
            // InternalLevelDesign.g:2729:3: ruleCoordinate
            {
             before(grammarAccess.getExitAccess().getPositionCoordinateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCoordinate();

            state._fsp--;

             after(grammarAccess.getExitAccess().getPositionCoordinateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exit__PositionAssignment_3"


    // $ANTLR start "rule__Coordinate__ColumnAssignment_0_1"
    // InternalLevelDesign.g:2738:1: rule__Coordinate__ColumnAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Coordinate__ColumnAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2742:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2743:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2743:2: ( RULE_INT )
            // InternalLevelDesign.g:2744:3: RULE_INT
            {
             before(grammarAccess.getCoordinateAccess().getColumnINTTerminalRuleCall_0_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getColumnINTTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__ColumnAssignment_0_1"


    // $ANTLR start "rule__Coordinate__RowAssignment_0_3"
    // InternalLevelDesign.g:2753:1: rule__Coordinate__RowAssignment_0_3 : ( RULE_INT ) ;
    public final void rule__Coordinate__RowAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2757:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2758:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2758:2: ( RULE_INT )
            // InternalLevelDesign.g:2759:3: RULE_INT
            {
             before(grammarAccess.getCoordinateAccess().getRowINTTerminalRuleCall_0_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getRowINTTerminalRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__RowAssignment_0_3"


    // $ANTLR start "rule__Coordinate__ColumnAssignment_1_0"
    // InternalLevelDesign.g:2768:1: rule__Coordinate__ColumnAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__Coordinate__ColumnAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2772:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2773:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2773:2: ( RULE_INT )
            // InternalLevelDesign.g:2774:3: RULE_INT
            {
             before(grammarAccess.getCoordinateAccess().getColumnINTTerminalRuleCall_1_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getColumnINTTerminalRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__ColumnAssignment_1_0"


    // $ANTLR start "rule__Coordinate__RowAssignment_1_2"
    // InternalLevelDesign.g:2783:1: rule__Coordinate__RowAssignment_1_2 : ( RULE_INT ) ;
    public final void rule__Coordinate__RowAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLevelDesign.g:2787:1: ( ( RULE_INT ) )
            // InternalLevelDesign.g:2788:2: ( RULE_INT )
            {
            // InternalLevelDesign.g:2788:2: ( RULE_INT )
            // InternalLevelDesign.g:2789:3: RULE_INT
            {
             before(grammarAccess.getCoordinateAccess().getRowINTTerminalRuleCall_1_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getCoordinateAccess().getRowINTTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Coordinate__RowAssignment_1_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000030300040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000400400030L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040080L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000000L});

}