package at.ac.tuwien.big.leveldesign.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.ac.tuwien.big.leveldesign.services.LevelDesignGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLevelDesignParser extends AbstractInternalAntlrParser {
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

        public InternalLevelDesignParser(TokenStream input, LevelDesignGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Level";
       	}

       	@Override
       	protected LevelDesignGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleLevel"
    // InternalLevelDesign.g:64:1: entryRuleLevel returns [EObject current=null] : iv_ruleLevel= ruleLevel EOF ;
    public final EObject entryRuleLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLevel = null;


        try {
            // InternalLevelDesign.g:64:46: (iv_ruleLevel= ruleLevel EOF )
            // InternalLevelDesign.g:65:2: iv_ruleLevel= ruleLevel EOF
            {
             newCompositeNode(grammarAccess.getLevelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLevel=ruleLevel();

            state._fsp--;

             current =iv_ruleLevel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLevel"


    // $ANTLR start "ruleLevel"
    // InternalLevelDesign.g:71:1: ruleLevel returns [EObject current=null] : (otherlv_0= 'spawn' otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'goal' otherlv_4= '=>' ( (otherlv_5= RULE_ID ) ) ( (lv_rooms_6_0= ruleRoom ) )+ ) ;
    public final EObject ruleLevel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_rooms_6_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:77:2: ( (otherlv_0= 'spawn' otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'goal' otherlv_4= '=>' ( (otherlv_5= RULE_ID ) ) ( (lv_rooms_6_0= ruleRoom ) )+ ) )
            // InternalLevelDesign.g:78:2: (otherlv_0= 'spawn' otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'goal' otherlv_4= '=>' ( (otherlv_5= RULE_ID ) ) ( (lv_rooms_6_0= ruleRoom ) )+ )
            {
            // InternalLevelDesign.g:78:2: (otherlv_0= 'spawn' otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'goal' otherlv_4= '=>' ( (otherlv_5= RULE_ID ) ) ( (lv_rooms_6_0= ruleRoom ) )+ )
            // InternalLevelDesign.g:79:3: otherlv_0= 'spawn' otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'goal' otherlv_4= '=>' ( (otherlv_5= RULE_ID ) ) ( (lv_rooms_6_0= ruleRoom ) )+
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLevelAccess().getSpawnKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getLevelAccess().getEqualsSignGreaterThanSignKeyword_1());
            		
            // InternalLevelDesign.g:87:3: ( (otherlv_2= RULE_ID ) )
            // InternalLevelDesign.g:88:4: (otherlv_2= RULE_ID )
            {
            // InternalLevelDesign.g:88:4: (otherlv_2= RULE_ID )
            // InternalLevelDesign.g:89:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(otherlv_2, grammarAccess.getLevelAccess().getSpawnRoomRoomCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getLevelAccess().getGoalKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getLevelAccess().getEqualsSignGreaterThanSignKeyword_4());
            		
            // InternalLevelDesign.g:108:3: ( (otherlv_5= RULE_ID ) )
            // InternalLevelDesign.g:109:4: (otherlv_5= RULE_ID )
            {
            // InternalLevelDesign.g:109:4: (otherlv_5= RULE_ID )
            // InternalLevelDesign.g:110:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLevelRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_5, grammarAccess.getLevelAccess().getGoalRoomRoomCrossReference_5_0());
            				

            }


            }

            // InternalLevelDesign.g:121:3: ( (lv_rooms_6_0= ruleRoom ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLevelDesign.g:122:4: (lv_rooms_6_0= ruleRoom )
            	    {
            	    // InternalLevelDesign.g:122:4: (lv_rooms_6_0= ruleRoom )
            	    // InternalLevelDesign.g:123:5: lv_rooms_6_0= ruleRoom
            	    {

            	    					newCompositeNode(grammarAccess.getLevelAccess().getRoomsRoomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_rooms_6_0=ruleRoom();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLevelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"rooms",
            	    						lv_rooms_6_0,
            	    						"at.ac.tuwien.big.leveldesign.LevelDesign.Room");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLevel"


    // $ANTLR start "entryRuleRoom"
    // InternalLevelDesign.g:144:1: entryRuleRoom returns [EObject current=null] : iv_ruleRoom= ruleRoom EOF ;
    public final EObject entryRuleRoom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoom = null;


        try {
            // InternalLevelDesign.g:144:45: (iv_ruleRoom= ruleRoom EOF )
            // InternalLevelDesign.g:145:2: iv_ruleRoom= ruleRoom EOF
            {
             newCompositeNode(grammarAccess.getRoomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoom=ruleRoom();

            state._fsp--;

             current =iv_ruleRoom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoom"


    // $ANTLR start "ruleRoom"
    // InternalLevelDesign.g:151:1: ruleRoom returns [EObject current=null] : (otherlv_0= 'room' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'columns' (otherlv_4= '=' )? ( (lv_columns_5_0= RULE_INT ) ) otherlv_6= 'rows' (otherlv_7= '=' )? ( (lv_rows_8_0= RULE_INT ) ) ( (lv_entry_9_0= ruleEntry ) ) ( (lv_exit_10_0= ruleExit ) ) ( (lv_exitConnection_11_0= ruleConnection ) )? ( (lv_walls_12_0= ruleWall ) )* ( (lv_trapdoors_13_0= ruleTrapdoor ) )* ( (lv_monsters_14_0= ruleMonster ) )* otherlv_15= '}' ) ;
    public final EObject ruleRoom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_columns_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_rows_8_0=null;
        Token otherlv_15=null;
        EObject lv_entry_9_0 = null;

        EObject lv_exit_10_0 = null;

        EObject lv_exitConnection_11_0 = null;

        EObject lv_walls_12_0 = null;

        EObject lv_trapdoors_13_0 = null;

        EObject lv_monsters_14_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:157:2: ( (otherlv_0= 'room' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'columns' (otherlv_4= '=' )? ( (lv_columns_5_0= RULE_INT ) ) otherlv_6= 'rows' (otherlv_7= '=' )? ( (lv_rows_8_0= RULE_INT ) ) ( (lv_entry_9_0= ruleEntry ) ) ( (lv_exit_10_0= ruleExit ) ) ( (lv_exitConnection_11_0= ruleConnection ) )? ( (lv_walls_12_0= ruleWall ) )* ( (lv_trapdoors_13_0= ruleTrapdoor ) )* ( (lv_monsters_14_0= ruleMonster ) )* otherlv_15= '}' ) )
            // InternalLevelDesign.g:158:2: (otherlv_0= 'room' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'columns' (otherlv_4= '=' )? ( (lv_columns_5_0= RULE_INT ) ) otherlv_6= 'rows' (otherlv_7= '=' )? ( (lv_rows_8_0= RULE_INT ) ) ( (lv_entry_9_0= ruleEntry ) ) ( (lv_exit_10_0= ruleExit ) ) ( (lv_exitConnection_11_0= ruleConnection ) )? ( (lv_walls_12_0= ruleWall ) )* ( (lv_trapdoors_13_0= ruleTrapdoor ) )* ( (lv_monsters_14_0= ruleMonster ) )* otherlv_15= '}' )
            {
            // InternalLevelDesign.g:158:2: (otherlv_0= 'room' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'columns' (otherlv_4= '=' )? ( (lv_columns_5_0= RULE_INT ) ) otherlv_6= 'rows' (otherlv_7= '=' )? ( (lv_rows_8_0= RULE_INT ) ) ( (lv_entry_9_0= ruleEntry ) ) ( (lv_exit_10_0= ruleExit ) ) ( (lv_exitConnection_11_0= ruleConnection ) )? ( (lv_walls_12_0= ruleWall ) )* ( (lv_trapdoors_13_0= ruleTrapdoor ) )* ( (lv_monsters_14_0= ruleMonster ) )* otherlv_15= '}' )
            // InternalLevelDesign.g:159:3: otherlv_0= 'room' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'columns' (otherlv_4= '=' )? ( (lv_columns_5_0= RULE_INT ) ) otherlv_6= 'rows' (otherlv_7= '=' )? ( (lv_rows_8_0= RULE_INT ) ) ( (lv_entry_9_0= ruleEntry ) ) ( (lv_exit_10_0= ruleExit ) ) ( (lv_exitConnection_11_0= ruleConnection ) )? ( (lv_walls_12_0= ruleWall ) )* ( (lv_trapdoors_13_0= ruleTrapdoor ) )* ( (lv_monsters_14_0= ruleMonster ) )* otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getRoomAccess().getRoomKeyword_0());
            		
            // InternalLevelDesign.g:163:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLevelDesign.g:164:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLevelDesign.g:164:4: (lv_name_1_0= RULE_ID )
            // InternalLevelDesign.g:165:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRoomAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getRoomAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getRoomAccess().getColumnsKeyword_3());
            		
            // InternalLevelDesign.g:189:3: (otherlv_4= '=' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalLevelDesign.g:190:4: otherlv_4= '='
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getRoomAccess().getEqualsSignKeyword_4());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:195:3: ( (lv_columns_5_0= RULE_INT ) )
            // InternalLevelDesign.g:196:4: (lv_columns_5_0= RULE_INT )
            {
            // InternalLevelDesign.g:196:4: (lv_columns_5_0= RULE_INT )
            // InternalLevelDesign.g:197:5: lv_columns_5_0= RULE_INT
            {
            lv_columns_5_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_columns_5_0, grammarAccess.getRoomAccess().getColumnsINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"columns",
            						lv_columns_5_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_6=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getRoomAccess().getRowsKeyword_6());
            		
            // InternalLevelDesign.g:217:3: (otherlv_7= '=' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalLevelDesign.g:218:4: otherlv_7= '='
                    {
                    otherlv_7=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getRoomAccess().getEqualsSignKeyword_7());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:223:3: ( (lv_rows_8_0= RULE_INT ) )
            // InternalLevelDesign.g:224:4: (lv_rows_8_0= RULE_INT )
            {
            // InternalLevelDesign.g:224:4: (lv_rows_8_0= RULE_INT )
            // InternalLevelDesign.g:225:5: lv_rows_8_0= RULE_INT
            {
            lv_rows_8_0=(Token)match(input,RULE_INT,FOLLOW_13); 

            					newLeafNode(lv_rows_8_0, grammarAccess.getRoomAccess().getRowsINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRoomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"rows",
            						lv_rows_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalLevelDesign.g:241:3: ( (lv_entry_9_0= ruleEntry ) )
            // InternalLevelDesign.g:242:4: (lv_entry_9_0= ruleEntry )
            {
            // InternalLevelDesign.g:242:4: (lv_entry_9_0= ruleEntry )
            // InternalLevelDesign.g:243:5: lv_entry_9_0= ruleEntry
            {

            					newCompositeNode(grammarAccess.getRoomAccess().getEntryEntryParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_14);
            lv_entry_9_0=ruleEntry();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRoomRule());
            					}
            					set(
            						current,
            						"entry",
            						lv_entry_9_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Entry");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLevelDesign.g:260:3: ( (lv_exit_10_0= ruleExit ) )
            // InternalLevelDesign.g:261:4: (lv_exit_10_0= ruleExit )
            {
            // InternalLevelDesign.g:261:4: (lv_exit_10_0= ruleExit )
            // InternalLevelDesign.g:262:5: lv_exit_10_0= ruleExit
            {

            					newCompositeNode(grammarAccess.getRoomAccess().getExitExitParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_15);
            lv_exit_10_0=ruleExit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRoomRule());
            					}
            					set(
            						current,
            						"exit",
            						lv_exit_10_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Exit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLevelDesign.g:279:3: ( (lv_exitConnection_11_0= ruleConnection ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalLevelDesign.g:280:4: (lv_exitConnection_11_0= ruleConnection )
                    {
                    // InternalLevelDesign.g:280:4: (lv_exitConnection_11_0= ruleConnection )
                    // InternalLevelDesign.g:281:5: lv_exitConnection_11_0= ruleConnection
                    {

                    					newCompositeNode(grammarAccess.getRoomAccess().getExitConnectionConnectionParserRuleCall_11_0());
                    				
                    pushFollow(FOLLOW_16);
                    lv_exitConnection_11_0=ruleConnection();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRoomRule());
                    					}
                    					set(
                    						current,
                    						"exitConnection",
                    						lv_exitConnection_11_0,
                    						"at.ac.tuwien.big.leveldesign.LevelDesign.Connection");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalLevelDesign.g:298:3: ( (lv_walls_12_0= ruleWall ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==29) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLevelDesign.g:299:4: (lv_walls_12_0= ruleWall )
            	    {
            	    // InternalLevelDesign.g:299:4: (lv_walls_12_0= ruleWall )
            	    // InternalLevelDesign.g:300:5: lv_walls_12_0= ruleWall
            	    {

            	    					newCompositeNode(grammarAccess.getRoomAccess().getWallsWallParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_walls_12_0=ruleWall();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"walls",
            	    						lv_walls_12_0,
            	    						"at.ac.tuwien.big.leveldesign.LevelDesign.Wall");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalLevelDesign.g:317:3: ( (lv_trapdoors_13_0= ruleTrapdoor ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==28) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalLevelDesign.g:318:4: (lv_trapdoors_13_0= ruleTrapdoor )
            	    {
            	    // InternalLevelDesign.g:318:4: (lv_trapdoors_13_0= ruleTrapdoor )
            	    // InternalLevelDesign.g:319:5: lv_trapdoors_13_0= ruleTrapdoor
            	    {

            	    					newCompositeNode(grammarAccess.getRoomAccess().getTrapdoorsTrapdoorParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_trapdoors_13_0=ruleTrapdoor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"trapdoors",
            	    						lv_trapdoors_13_0,
            	    						"at.ac.tuwien.big.leveldesign.LevelDesign.Trapdoor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalLevelDesign.g:336:3: ( (lv_monsters_14_0= ruleMonster ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalLevelDesign.g:337:4: (lv_monsters_14_0= ruleMonster )
            	    {
            	    // InternalLevelDesign.g:337:4: (lv_monsters_14_0= ruleMonster )
            	    // InternalLevelDesign.g:338:5: lv_monsters_14_0= ruleMonster
            	    {

            	    					newCompositeNode(grammarAccess.getRoomAccess().getMonstersMonsterParserRuleCall_14_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_monsters_14_0=ruleMonster();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"monsters",
            	    						lv_monsters_14_0,
            	    						"at.ac.tuwien.big.leveldesign.LevelDesign.Monster");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_15=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getRoomAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoom"


    // $ANTLR start "entryRuleConnection"
    // InternalLevelDesign.g:363:1: entryRuleConnection returns [EObject current=null] : iv_ruleConnection= ruleConnection EOF ;
    public final EObject entryRuleConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnection = null;


        try {
            // InternalLevelDesign.g:363:51: (iv_ruleConnection= ruleConnection EOF )
            // InternalLevelDesign.g:364:2: iv_ruleConnection= ruleConnection EOF
            {
             newCompositeNode(grammarAccess.getConnectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnection=ruleConnection();

            state._fsp--;

             current =iv_ruleConnection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnection"


    // $ANTLR start "ruleConnection"
    // InternalLevelDesign.g:370:1: ruleConnection returns [EObject current=null] : ( ( (lv_type_0_0= RULE_STRING ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleConnection() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalLevelDesign.g:376:2: ( ( ( (lv_type_0_0= RULE_STRING ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalLevelDesign.g:377:2: ( ( (lv_type_0_0= RULE_STRING ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalLevelDesign.g:377:2: ( ( (lv_type_0_0= RULE_STRING ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            // InternalLevelDesign.g:378:3: ( (lv_type_0_0= RULE_STRING ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) )
            {
            // InternalLevelDesign.g:378:3: ( (lv_type_0_0= RULE_STRING ) )
            // InternalLevelDesign.g:379:4: (lv_type_0_0= RULE_STRING )
            {
            // InternalLevelDesign.g:379:4: (lv_type_0_0= RULE_STRING )
            // InternalLevelDesign.g:380:5: lv_type_0_0= RULE_STRING
            {
            lv_type_0_0=(Token)match(input,RULE_STRING,FOLLOW_3); 

            					newLeafNode(lv_type_0_0, grammarAccess.getConnectionAccess().getTypeSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getConnectionAccess().getEqualsSignGreaterThanSignKeyword_1());
            		
            // InternalLevelDesign.g:400:3: ( (otherlv_2= RULE_ID ) )
            // InternalLevelDesign.g:401:4: (otherlv_2= RULE_ID )
            {
            // InternalLevelDesign.g:401:4: (otherlv_2= RULE_ID )
            // InternalLevelDesign.g:402:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnectionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getConnectionAccess().getNextRoomRoomCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnection"


    // $ANTLR start "entryRuleMonster"
    // InternalLevelDesign.g:417:1: entryRuleMonster returns [EObject current=null] : iv_ruleMonster= ruleMonster EOF ;
    public final EObject entryRuleMonster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonster = null;


        try {
            // InternalLevelDesign.g:417:48: (iv_ruleMonster= ruleMonster EOF )
            // InternalLevelDesign.g:418:2: iv_ruleMonster= ruleMonster EOF
            {
             newCompositeNode(grammarAccess.getMonsterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMonster=ruleMonster();

            state._fsp--;

             current =iv_ruleMonster; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMonster"


    // $ANTLR start "ruleMonster"
    // InternalLevelDesign.g:424:1: ruleMonster returns [EObject current=null] : (otherlv_0= 'monster' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) otherlv_4= '{' otherlv_5= 'hp' (otherlv_6= '=' )? ( (lv_hp_7_0= RULE_INT ) ) otherlv_8= 'damage' (otherlv_9= '=' )? ( (lv_damage_10_0= RULE_INT ) ) otherlv_11= 'speed' (otherlv_12= '=' )? ( (lv_speed_13_0= RULE_DOUBLE ) ) otherlv_14= 'range' (otherlv_15= '=' )? ( (lv_range_16_0= RULE_INT ) ) otherlv_17= 'aggroradius' (otherlv_18= '=' )? ( (lv_aggroRadius_19_0= RULE_INT ) ) otherlv_20= '}' ) ;
    public final EObject ruleMonster() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_hp_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_damage_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token lv_speed_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_range_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_aggroRadius_19_0=null;
        Token otherlv_20=null;
        EObject lv_position_3_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:430:2: ( (otherlv_0= 'monster' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) otherlv_4= '{' otherlv_5= 'hp' (otherlv_6= '=' )? ( (lv_hp_7_0= RULE_INT ) ) otherlv_8= 'damage' (otherlv_9= '=' )? ( (lv_damage_10_0= RULE_INT ) ) otherlv_11= 'speed' (otherlv_12= '=' )? ( (lv_speed_13_0= RULE_DOUBLE ) ) otherlv_14= 'range' (otherlv_15= '=' )? ( (lv_range_16_0= RULE_INT ) ) otherlv_17= 'aggroradius' (otherlv_18= '=' )? ( (lv_aggroRadius_19_0= RULE_INT ) ) otherlv_20= '}' ) )
            // InternalLevelDesign.g:431:2: (otherlv_0= 'monster' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) otherlv_4= '{' otherlv_5= 'hp' (otherlv_6= '=' )? ( (lv_hp_7_0= RULE_INT ) ) otherlv_8= 'damage' (otherlv_9= '=' )? ( (lv_damage_10_0= RULE_INT ) ) otherlv_11= 'speed' (otherlv_12= '=' )? ( (lv_speed_13_0= RULE_DOUBLE ) ) otherlv_14= 'range' (otherlv_15= '=' )? ( (lv_range_16_0= RULE_INT ) ) otherlv_17= 'aggroradius' (otherlv_18= '=' )? ( (lv_aggroRadius_19_0= RULE_INT ) ) otherlv_20= '}' )
            {
            // InternalLevelDesign.g:431:2: (otherlv_0= 'monster' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) otherlv_4= '{' otherlv_5= 'hp' (otherlv_6= '=' )? ( (lv_hp_7_0= RULE_INT ) ) otherlv_8= 'damage' (otherlv_9= '=' )? ( (lv_damage_10_0= RULE_INT ) ) otherlv_11= 'speed' (otherlv_12= '=' )? ( (lv_speed_13_0= RULE_DOUBLE ) ) otherlv_14= 'range' (otherlv_15= '=' )? ( (lv_range_16_0= RULE_INT ) ) otherlv_17= 'aggroradius' (otherlv_18= '=' )? ( (lv_aggroRadius_19_0= RULE_INT ) ) otherlv_20= '}' )
            // InternalLevelDesign.g:432:3: otherlv_0= 'monster' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) otherlv_4= '{' otherlv_5= 'hp' (otherlv_6= '=' )? ( (lv_hp_7_0= RULE_INT ) ) otherlv_8= 'damage' (otherlv_9= '=' )? ( (lv_damage_10_0= RULE_INT ) ) otherlv_11= 'speed' (otherlv_12= '=' )? ( (lv_speed_13_0= RULE_DOUBLE ) ) otherlv_14= 'range' (otherlv_15= '=' )? ( (lv_range_16_0= RULE_INT ) ) otherlv_17= 'aggroradius' (otherlv_18= '=' )? ( (lv_aggroRadius_19_0= RULE_INT ) ) otherlv_20= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getMonsterAccess().getMonsterKeyword_0());
            		
            // InternalLevelDesign.g:436:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalLevelDesign.g:437:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalLevelDesign.g:437:4: (lv_name_1_0= RULE_ID )
                    // InternalLevelDesign.g:438:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getMonsterAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMonsterRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalLevelDesign.g:454:3: (otherlv_2= '@' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalLevelDesign.g:455:4: otherlv_2= '@'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getMonsterAccess().getCommercialAtKeyword_2());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:460:3: ( (lv_position_3_0= ruleCoordinate ) )
            // InternalLevelDesign.g:461:4: (lv_position_3_0= ruleCoordinate )
            {
            // InternalLevelDesign.g:461:4: (lv_position_3_0= ruleCoordinate )
            // InternalLevelDesign.g:462:5: lv_position_3_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getMonsterAccess().getPositionCoordinateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_position_3_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMonsterRule());
            					}
            					set(
            						current,
            						"position",
            						lv_position_3_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_20); 

            			newLeafNode(otherlv_4, grammarAccess.getMonsterAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,23,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getMonsterAccess().getHpKeyword_5());
            		
            // InternalLevelDesign.g:487:3: (otherlv_6= '=' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalLevelDesign.g:488:4: otherlv_6= '='
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_6, grammarAccess.getMonsterAccess().getEqualsSignKeyword_6());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:493:3: ( (lv_hp_7_0= RULE_INT ) )
            // InternalLevelDesign.g:494:4: (lv_hp_7_0= RULE_INT )
            {
            // InternalLevelDesign.g:494:4: (lv_hp_7_0= RULE_INT )
            // InternalLevelDesign.g:495:5: lv_hp_7_0= RULE_INT
            {
            lv_hp_7_0=(Token)match(input,RULE_INT,FOLLOW_21); 

            					newLeafNode(lv_hp_7_0, grammarAccess.getMonsterAccess().getHpINTTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonsterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"hp",
            						lv_hp_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_8=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getMonsterAccess().getDamageKeyword_8());
            		
            // InternalLevelDesign.g:515:3: (otherlv_9= '=' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalLevelDesign.g:516:4: otherlv_9= '='
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_9, grammarAccess.getMonsterAccess().getEqualsSignKeyword_9());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:521:3: ( (lv_damage_10_0= RULE_INT ) )
            // InternalLevelDesign.g:522:4: (lv_damage_10_0= RULE_INT )
            {
            // InternalLevelDesign.g:522:4: (lv_damage_10_0= RULE_INT )
            // InternalLevelDesign.g:523:5: lv_damage_10_0= RULE_INT
            {
            lv_damage_10_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_damage_10_0, grammarAccess.getMonsterAccess().getDamageINTTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonsterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"damage",
            						lv_damage_10_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_11=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_11, grammarAccess.getMonsterAccess().getSpeedKeyword_11());
            		
            // InternalLevelDesign.g:543:3: (otherlv_12= '=' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalLevelDesign.g:544:4: otherlv_12= '='
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_24); 

                    				newLeafNode(otherlv_12, grammarAccess.getMonsterAccess().getEqualsSignKeyword_12());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:549:3: ( (lv_speed_13_0= RULE_DOUBLE ) )
            // InternalLevelDesign.g:550:4: (lv_speed_13_0= RULE_DOUBLE )
            {
            // InternalLevelDesign.g:550:4: (lv_speed_13_0= RULE_DOUBLE )
            // InternalLevelDesign.g:551:5: lv_speed_13_0= RULE_DOUBLE
            {
            lv_speed_13_0=(Token)match(input,RULE_DOUBLE,FOLLOW_25); 

            					newLeafNode(lv_speed_13_0, grammarAccess.getMonsterAccess().getSpeedDOUBLETerminalRuleCall_13_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonsterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"speed",
            						lv_speed_13_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.DOUBLE");
            				

            }


            }

            otherlv_14=(Token)match(input,26,FOLLOW_10); 

            			newLeafNode(otherlv_14, grammarAccess.getMonsterAccess().getRangeKeyword_14());
            		
            // InternalLevelDesign.g:571:3: (otherlv_15= '=' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==18) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalLevelDesign.g:572:4: otherlv_15= '='
                    {
                    otherlv_15=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_15, grammarAccess.getMonsterAccess().getEqualsSignKeyword_15());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:577:3: ( (lv_range_16_0= RULE_INT ) )
            // InternalLevelDesign.g:578:4: (lv_range_16_0= RULE_INT )
            {
            // InternalLevelDesign.g:578:4: (lv_range_16_0= RULE_INT )
            // InternalLevelDesign.g:579:5: lv_range_16_0= RULE_INT
            {
            lv_range_16_0=(Token)match(input,RULE_INT,FOLLOW_26); 

            					newLeafNode(lv_range_16_0, grammarAccess.getMonsterAccess().getRangeINTTerminalRuleCall_16_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonsterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"range",
            						lv_range_16_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_17=(Token)match(input,27,FOLLOW_10); 

            			newLeafNode(otherlv_17, grammarAccess.getMonsterAccess().getAggroradiusKeyword_17());
            		
            // InternalLevelDesign.g:599:3: (otherlv_18= '=' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalLevelDesign.g:600:4: otherlv_18= '='
                    {
                    otherlv_18=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_18, grammarAccess.getMonsterAccess().getEqualsSignKeyword_18());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:605:3: ( (lv_aggroRadius_19_0= RULE_INT ) )
            // InternalLevelDesign.g:606:4: (lv_aggroRadius_19_0= RULE_INT )
            {
            // InternalLevelDesign.g:606:4: (lv_aggroRadius_19_0= RULE_INT )
            // InternalLevelDesign.g:607:5: lv_aggroRadius_19_0= RULE_INT
            {
            lv_aggroRadius_19_0=(Token)match(input,RULE_INT,FOLLOW_27); 

            					newLeafNode(lv_aggroRadius_19_0, grammarAccess.getMonsterAccess().getAggroRadiusINTTerminalRuleCall_19_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonsterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"aggroRadius",
            						lv_aggroRadius_19_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_20=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_20, grammarAccess.getMonsterAccess().getRightCurlyBracketKeyword_20());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMonster"


    // $ANTLR start "entryRuleTrapdoor"
    // InternalLevelDesign.g:631:1: entryRuleTrapdoor returns [EObject current=null] : iv_ruleTrapdoor= ruleTrapdoor EOF ;
    public final EObject entryRuleTrapdoor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrapdoor = null;


        try {
            // InternalLevelDesign.g:631:49: (iv_ruleTrapdoor= ruleTrapdoor EOF )
            // InternalLevelDesign.g:632:2: iv_ruleTrapdoor= ruleTrapdoor EOF
            {
             newCompositeNode(grammarAccess.getTrapdoorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrapdoor=ruleTrapdoor();

            state._fsp--;

             current =iv_ruleTrapdoor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrapdoor"


    // $ANTLR start "ruleTrapdoor"
    // InternalLevelDesign.g:638:1: ruleTrapdoor returns [EObject current=null] : (otherlv_0= 'trapdoor' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) ) ;
    public final EObject ruleTrapdoor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_position_3_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:644:2: ( (otherlv_0= 'trapdoor' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) ) )
            // InternalLevelDesign.g:645:2: (otherlv_0= 'trapdoor' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) )
            {
            // InternalLevelDesign.g:645:2: (otherlv_0= 'trapdoor' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) )
            // InternalLevelDesign.g:646:3: otherlv_0= 'trapdoor' ( (lv_name_1_0= RULE_ID ) )? (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getTrapdoorAccess().getTrapdoorKeyword_0());
            		
            // InternalLevelDesign.g:650:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalLevelDesign.g:651:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalLevelDesign.g:651:4: (lv_name_1_0= RULE_ID )
                    // InternalLevelDesign.g:652:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getTrapdoorAccess().getNameIDTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTrapdoorRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_1_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            // InternalLevelDesign.g:668:3: (otherlv_2= '@' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalLevelDesign.g:669:4: otherlv_2= '@'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getTrapdoorAccess().getCommercialAtKeyword_2());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:674:3: ( (lv_position_3_0= ruleCoordinate ) )
            // InternalLevelDesign.g:675:4: (lv_position_3_0= ruleCoordinate )
            {
            // InternalLevelDesign.g:675:4: (lv_position_3_0= ruleCoordinate )
            // InternalLevelDesign.g:676:5: lv_position_3_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getTrapdoorAccess().getPositionCoordinateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_position_3_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTrapdoorRule());
            					}
            					set(
            						current,
            						"position",
            						lv_position_3_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrapdoor"


    // $ANTLR start "entryRuleWall"
    // InternalLevelDesign.g:697:1: entryRuleWall returns [EObject current=null] : iv_ruleWall= ruleWall EOF ;
    public final EObject entryRuleWall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWall = null;


        try {
            // InternalLevelDesign.g:697:45: (iv_ruleWall= ruleWall EOF )
            // InternalLevelDesign.g:698:2: iv_ruleWall= ruleWall EOF
            {
             newCompositeNode(grammarAccess.getWallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWall=ruleWall();

            state._fsp--;

             current =iv_ruleWall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWall"


    // $ANTLR start "ruleWall"
    // InternalLevelDesign.g:704:1: ruleWall returns [EObject current=null] : (otherlv_0= 'wall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_from_3_0= ruleCoordinate ) ) otherlv_4= 'to' ( (lv_to_5_0= ruleCoordinate ) ) ) ;
    public final EObject ruleWall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_from_3_0 = null;

        EObject lv_to_5_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:710:2: ( (otherlv_0= 'wall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_from_3_0= ruleCoordinate ) ) otherlv_4= 'to' ( (lv_to_5_0= ruleCoordinate ) ) ) )
            // InternalLevelDesign.g:711:2: (otherlv_0= 'wall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_from_3_0= ruleCoordinate ) ) otherlv_4= 'to' ( (lv_to_5_0= ruleCoordinate ) ) )
            {
            // InternalLevelDesign.g:711:2: (otherlv_0= 'wall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_from_3_0= ruleCoordinate ) ) otherlv_4= 'to' ( (lv_to_5_0= ruleCoordinate ) ) )
            // InternalLevelDesign.g:712:3: otherlv_0= 'wall' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_from_3_0= ruleCoordinate ) ) otherlv_4= 'to' ( (lv_to_5_0= ruleCoordinate ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getWallAccess().getWallKeyword_0());
            		
            // InternalLevelDesign.g:716:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLevelDesign.g:717:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLevelDesign.g:717:4: (lv_name_1_0= RULE_ID )
            // InternalLevelDesign.g:718:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWallAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWallRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getWallAccess().getFromKeyword_2());
            		
            // InternalLevelDesign.g:738:3: ( (lv_from_3_0= ruleCoordinate ) )
            // InternalLevelDesign.g:739:4: (lv_from_3_0= ruleCoordinate )
            {
            // InternalLevelDesign.g:739:4: (lv_from_3_0= ruleCoordinate )
            // InternalLevelDesign.g:740:5: lv_from_3_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getWallAccess().getFromCoordinateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_29);
            lv_from_3_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWallRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_3_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,31,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getWallAccess().getToKeyword_4());
            		
            // InternalLevelDesign.g:761:3: ( (lv_to_5_0= ruleCoordinate ) )
            // InternalLevelDesign.g:762:4: (lv_to_5_0= ruleCoordinate )
            {
            // InternalLevelDesign.g:762:4: (lv_to_5_0= ruleCoordinate )
            // InternalLevelDesign.g:763:5: lv_to_5_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getWallAccess().getToCoordinateParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_to_5_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWallRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_5_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWall"


    // $ANTLR start "entryRuleEntry"
    // InternalLevelDesign.g:784:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // InternalLevelDesign.g:784:46: (iv_ruleEntry= ruleEntry EOF )
            // InternalLevelDesign.g:785:2: iv_ruleEntry= ruleEntry EOF
            {
             newCompositeNode(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntry=ruleEntry();

            state._fsp--;

             current =iv_ruleEntry; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // InternalLevelDesign.g:791:1: ruleEntry returns [EObject current=null] : (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) ) ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_position_3_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:797:2: ( (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) ) )
            // InternalLevelDesign.g:798:2: (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) )
            {
            // InternalLevelDesign.g:798:2: (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) )
            // InternalLevelDesign.g:799:3: otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEntryAccess().getEntryKeyword_0());
            		
            // InternalLevelDesign.g:803:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLevelDesign.g:804:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLevelDesign.g:804:4: (lv_name_1_0= RULE_ID )
            // InternalLevelDesign.g:805:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalLevelDesign.g:821:3: (otherlv_2= '@' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalLevelDesign.g:822:4: otherlv_2= '@'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getEntryAccess().getCommercialAtKeyword_2());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:827:3: ( (lv_position_3_0= ruleCoordinate ) )
            // InternalLevelDesign.g:828:4: (lv_position_3_0= ruleCoordinate )
            {
            // InternalLevelDesign.g:828:4: (lv_position_3_0= ruleCoordinate )
            // InternalLevelDesign.g:829:5: lv_position_3_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getEntryAccess().getPositionCoordinateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_position_3_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntryRule());
            					}
            					set(
            						current,
            						"position",
            						lv_position_3_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleExit"
    // InternalLevelDesign.g:850:1: entryRuleExit returns [EObject current=null] : iv_ruleExit= ruleExit EOF ;
    public final EObject entryRuleExit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExit = null;


        try {
            // InternalLevelDesign.g:850:45: (iv_ruleExit= ruleExit EOF )
            // InternalLevelDesign.g:851:2: iv_ruleExit= ruleExit EOF
            {
             newCompositeNode(grammarAccess.getExitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExit=ruleExit();

            state._fsp--;

             current =iv_ruleExit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExit"


    // $ANTLR start "ruleExit"
    // InternalLevelDesign.g:857:1: ruleExit returns [EObject current=null] : (otherlv_0= 'exit' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) ) ;
    public final EObject ruleExit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_position_3_0 = null;



        	enterRule();

        try {
            // InternalLevelDesign.g:863:2: ( (otherlv_0= 'exit' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) ) )
            // InternalLevelDesign.g:864:2: (otherlv_0= 'exit' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) )
            {
            // InternalLevelDesign.g:864:2: (otherlv_0= 'exit' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) ) )
            // InternalLevelDesign.g:865:3: otherlv_0= 'exit' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '@' )? ( (lv_position_3_0= ruleCoordinate ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getExitAccess().getExitKeyword_0());
            		
            // InternalLevelDesign.g:869:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLevelDesign.g:870:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLevelDesign.g:870:4: (lv_name_1_0= RULE_ID )
            // InternalLevelDesign.g:871:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getExitAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExitRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalLevelDesign.g:887:3: (otherlv_2= '@' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalLevelDesign.g:888:4: otherlv_2= '@'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getExitAccess().getCommercialAtKeyword_2());
                    			

                    }
                    break;

            }

            // InternalLevelDesign.g:893:3: ( (lv_position_3_0= ruleCoordinate ) )
            // InternalLevelDesign.g:894:4: (lv_position_3_0= ruleCoordinate )
            {
            // InternalLevelDesign.g:894:4: (lv_position_3_0= ruleCoordinate )
            // InternalLevelDesign.g:895:5: lv_position_3_0= ruleCoordinate
            {

            					newCompositeNode(grammarAccess.getExitAccess().getPositionCoordinateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_position_3_0=ruleCoordinate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExitRule());
            					}
            					set(
            						current,
            						"position",
            						lv_position_3_0,
            						"at.ac.tuwien.big.leveldesign.LevelDesign.Coordinate");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExit"


    // $ANTLR start "entryRuleCoordinate"
    // InternalLevelDesign.g:916:1: entryRuleCoordinate returns [EObject current=null] : iv_ruleCoordinate= ruleCoordinate EOF ;
    public final EObject entryRuleCoordinate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinate = null;


        try {
            // InternalLevelDesign.g:916:51: (iv_ruleCoordinate= ruleCoordinate EOF )
            // InternalLevelDesign.g:917:2: iv_ruleCoordinate= ruleCoordinate EOF
            {
             newCompositeNode(grammarAccess.getCoordinateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCoordinate=ruleCoordinate();

            state._fsp--;

             current =iv_ruleCoordinate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoordinate"


    // $ANTLR start "ruleCoordinate"
    // InternalLevelDesign.g:923:1: ruleCoordinate returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) | ( ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) ) ) ) ;
    public final EObject ruleCoordinate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_column_1_0=null;
        Token otherlv_2=null;
        Token lv_row_3_0=null;
        Token otherlv_4=null;
        Token lv_column_5_0=null;
        Token otherlv_6=null;
        Token lv_row_7_0=null;


        	enterRule();

        try {
            // InternalLevelDesign.g:929:2: ( ( (otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) | ( ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) ) ) ) )
            // InternalLevelDesign.g:930:2: ( (otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) | ( ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) ) ) )
            {
            // InternalLevelDesign.g:930:2: ( (otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) | ( ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_INT) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalLevelDesign.g:931:3: (otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
                    {
                    // InternalLevelDesign.g:931:3: (otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
                    // InternalLevelDesign.g:932:4: otherlv_0= '(' ( (lv_column_1_0= RULE_INT ) ) otherlv_2= ',' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,34,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getCoordinateAccess().getLeftParenthesisKeyword_0_0());
                    			
                    // InternalLevelDesign.g:936:4: ( (lv_column_1_0= RULE_INT ) )
                    // InternalLevelDesign.g:937:5: (lv_column_1_0= RULE_INT )
                    {
                    // InternalLevelDesign.g:937:5: (lv_column_1_0= RULE_INT )
                    // InternalLevelDesign.g:938:6: lv_column_1_0= RULE_INT
                    {
                    lv_column_1_0=(Token)match(input,RULE_INT,FOLLOW_30); 

                    						newLeafNode(lv_column_1_0, grammarAccess.getCoordinateAccess().getColumnINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCoordinateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"column",
                    							lv_column_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,35,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getCoordinateAccess().getCommaKeyword_0_2());
                    			
                    // InternalLevelDesign.g:958:4: ( (lv_row_3_0= RULE_INT ) )
                    // InternalLevelDesign.g:959:5: (lv_row_3_0= RULE_INT )
                    {
                    // InternalLevelDesign.g:959:5: (lv_row_3_0= RULE_INT )
                    // InternalLevelDesign.g:960:6: lv_row_3_0= RULE_INT
                    {
                    lv_row_3_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_row_3_0, grammarAccess.getCoordinateAccess().getRowINTTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCoordinateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"row",
                    							lv_row_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getCoordinateAccess().getRightParenthesisKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLevelDesign.g:982:3: ( ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) ) )
                    {
                    // InternalLevelDesign.g:982:3: ( ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) ) )
                    // InternalLevelDesign.g:983:4: ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ',' ( (lv_row_7_0= RULE_INT ) )
                    {
                    // InternalLevelDesign.g:983:4: ( (lv_column_5_0= RULE_INT ) )
                    // InternalLevelDesign.g:984:5: (lv_column_5_0= RULE_INT )
                    {
                    // InternalLevelDesign.g:984:5: (lv_column_5_0= RULE_INT )
                    // InternalLevelDesign.g:985:6: lv_column_5_0= RULE_INT
                    {
                    lv_column_5_0=(Token)match(input,RULE_INT,FOLLOW_30); 

                    						newLeafNode(lv_column_5_0, grammarAccess.getCoordinateAccess().getColumnINTTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCoordinateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"column",
                    							lv_column_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,35,FOLLOW_11); 

                    				newLeafNode(otherlv_6, grammarAccess.getCoordinateAccess().getCommaKeyword_1_1());
                    			
                    // InternalLevelDesign.g:1005:4: ( (lv_row_7_0= RULE_INT ) )
                    // InternalLevelDesign.g:1006:5: (lv_row_7_0= RULE_INT )
                    {
                    // InternalLevelDesign.g:1006:5: (lv_row_7_0= RULE_INT )
                    // InternalLevelDesign.g:1007:6: lv_row_7_0= RULE_INT
                    {
                    lv_row_7_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_row_7_0, grammarAccess.getCoordinateAccess().getRowINTTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCoordinateRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"row",
                    							lv_row_7_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCoordinate"

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
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000030300040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000030300000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010300000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000400400030L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000040080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});

}