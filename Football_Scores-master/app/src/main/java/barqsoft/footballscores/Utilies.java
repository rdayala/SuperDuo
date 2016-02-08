package barqsoft.footballscores;

import android.content.Context;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilies
{

    public static final int BUNDESLIGA1 = 394;
    public static final int BUNDESLIGA2 = 395;
    public static final int LIGUE1 = 396;
    public static final int LIGUE2 = 397;
    public static final int PREMIER_LEAGUE = 398;
    public static final int PRIMERA_DIVISION = 399;
    public static final int SEGUNDA_DIVISION = 400;
    public static final int SERIE_A = 401;
    public static final int PRIMERA_LIGA = 402;
    public static final int Bundesliga3 = 403;
    public static final int EREDIVISIE = 404;
    public static final int CHAMPIONS_LEAGUE = 405;




    public static String getLeague(int league_num, Context context)
    {
        switch (league_num)
        {
            case BUNDESLIGA1 : return context.getString(R.string.bundesliga1);
            case BUNDESLIGA2 : return context.getString(R.string.bundesliga2);
            case LIGUE1 : return context.getString(R.string.ligue1);
            case LIGUE2 : return context.getString(R.string.ligue2);
            case PREMIER_LEAGUE : return context.getString(R.string.premier_league);
            case PRIMERA_DIVISION : return context.getString(R.string.primera_divison);
            case SEGUNDA_DIVISION : return context.getString(R.string.segunda_divison);
            case SERIE_A : return context.getString(R.string.serie_a);

            case PRIMERA_LIGA : return context.getString(R.string.primeira_liga);
            case Bundesliga3 : return context.getString(R.string.bundesliga3);
            case EREDIVISIE : return context.getString(R.string.eredivisie);


            case CHAMPIONS_LEAGUE : return context.getString(R.string.champions_league);


            default: return context.getString(R.string.league_unknown);
        }
    }
    public static String getMatchDay(int match_day,int league_num, Context context)
    {
        if(league_num == CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return context.getString(R.string.group_stage_text) + " " + context.getString(R.string.matchday_text) +  " : 6";
            }
            else if(match_day == 7 || match_day == 8)
            {
                return context.getString(R.string.first_knockout_round);
            }
            else if(match_day == 9 || match_day == 10)
            {
                return context.getString(R.string.quarter_final);
            }
            else if(match_day == 11 || match_day == 12)
            {
                return context.getString(R.string.semi_final);
            }
            else
            {
                return context.getString(R.string.final_text);
            }
        }
        else
        {
            return context.getString(R.string.matchday_text) + " : " + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static String getScoresDescription(int home_goals,int awaygoals, String home_team, String away_team, String prefix, String matchNoScore)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return matchNoScore;
        }
        else
        {
            return prefix + " " + home_team + ": " + String.valueOf(home_goals) + " - " + away_team + ": " +  String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName (String teamname, Context context)
    {
        if (teamname==null){return R.drawable.no_icon;}
        if(context.getString(R.string.Arsenal_London_FC).equals(teamname) || context.getString(R.string.TESTING1).equals(teamname)){
            return R.drawable.arsenal;
        } else if(context.getString(R.string.Manchester_United_FC).equals(teamname) || context.getString(R.string.TESTING2).equals(teamname)){
            return R.drawable.manchester_united;
        } else if(context.getString(R.string.Swansea_City).equals(teamname) || context.getString(R.string.TESTING3).equals(teamname)){
            return R.drawable.swansea_city_afc;
        } else if(context.getString(R.string.Leicester_City).equals(teamname) || context.getString(R.string.TESTING5).equals(teamname)){
            return R.drawable.leicester_city_fc_hd_logo;
        } else if(context.getString(R.string.Everton_FC).equals(teamname)){
            return R.drawable.everton_fc_logo1;
        } else if(context.getString(R.string.West_Ham_United_FC).equals(teamname)){
            return R.drawable.west_ham;
        } else if(context.getString(R.string.Tottenham_Hotspur_FC).equals(teamname)){
            return R.drawable.tottenham_hotspur;
        } else if(context.getString(R.string.West_Bromwich_Albion).equals(teamname)){
            return R.drawable.west_bromwich_albion_hd_logo;
        } else if(context.getString(R.string.Sunderland_AFC).equals(teamname)){
            return R.drawable.sunderland;
        } else if(context.getString(R.string.Stoke_City_FC).equals(teamname)){
            return R.drawable.stoke_city;
        } else {
            return R.drawable.no_icon;
        }
    }
}
