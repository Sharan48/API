package com.testvagrant.main;
import com.testvagrant.model.*;

import java.io.File;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RCbMain {
	public  static boolean validateTeamPlayers(List<Player> players){
		 String []forignPlayer= {"Faf Du Plessis","Glenn Maxwell","Wanindu Hasaranga","Josh Hazlewood"};
		 int foreignPlayerCount=0;
         boolean isWicketKepper=false;
       //for checking max 4 foreignplayer
			for(Player player: players) {
				for(int i=0;i<forignPlayer.length;i++) {
					if(forignPlayer[i].equals(player.getName())) {
						foreignPlayerCount++;
					}
				}
			}
			 //for checking at least one wicketKeeper
			for(Player player:players) {
				 if(player.getRole().equals("Wicket-keeper")) {
					 isWicketKepper=!isWicketKepper;
					 break;
				 }
			}
	
		 return foreignPlayerCount==4 && isWicketKepper;
	}
	  public static void main(String[] args) throws Exception {
		 
		  ObjectMapper mapper = new ObjectMapper();
    
			//JSON file to Java object
			Team team = mapper.readValue(new File(".\\Api\\response.json"), Team.class);
			
           
			//gettting player list
			List<Player> players=team.getPlayer();
			
			 System.out.println(validateTeamPlayers(players));
			
	  }
}
