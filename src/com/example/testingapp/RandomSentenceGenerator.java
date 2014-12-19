package com.example.testingapp;

import java.util.Random;

public class RandomSentenceGenerator {
	 public String generateSentence() {
	
	 Random randomNumber = new Random();
	 String article1 = "a"; 
	 String article2 = "The"; 
	 String article3 = "an"; 
	 String article4 = "the"; 
	 String noun1 = "blanket"; 
	 String noun2 = "doctor"; 
	 String noun3 = "nurse"; 
	 String noun4 = "expert" ; 
	 String noun5 = "beginner"; 
	 String noun6 = "mouse"; 
	 String noun7 = "goat"; 
	 String noun8 = "protein";
	 String noun9 = "RedBull";
	 String noun10 = "Movie";
	 String noun11 = "processor";
	 String noun12 = "bicycle"; 
	 String nounA = "rock"; 
	 String nounB = "rules"; 
	 String nounC = "wall"; 
	 String nounD = "coffee"; 
	 String nounE = "laptop"; 
	 String verb1 = "tested"; 
	 String verb2 = "heard"; 
	 String verb3 = "disregarded" ; 
	 String verb4 = "running"; 
	 String verb5 = "cracked"; 
	 String verb6 = "followed"; 
	 String verb7 = "broke";
	 String verb8 = "laughing";
	 String verb9 = "sung";
	 String verb10 = "brought";
	 
	 String finalSentence = " "; 

	   for (int i = 0; i < 3; i++) 
	   {
		   switch (1 + (randomNumber.nextInt(4))%4)
		   {
			   case 1: 
				 finalSentence += article1 + " "; 
				 break; 
			   case 2: 
				 finalSentence += article2 + " "; 
				 break;
			   case 3: 
				  finalSentence += article3 + " "; 
				  break; 
			   case 4: 
				  finalSentence += article4 + " "; 
				  break; 
		   }
		   switch (1+(randomNumber.nextInt(11))%11 )
		   { 
				 case 1: 
				 finalSentence += noun1 + " "; 
				 break; 
				   case 2: 
				 finalSentence += noun2 + " "; 
				 break; 
				   case 3: 
				 finalSentence += noun3 + " "; 
				 break; 
				   case 4: 
				 finalSentence += noun4 + " "; 
				 break; 
				   case 5: 
				 finalSentence += noun5 + " "; 
				 break; 
				   case 6: 
				 finalSentence += noun6 + " "; 
				 break; 
				   case 7: 
				 finalSentence += noun7 + " "; 
				 break;
				   case 8: 
				 finalSentence += noun8 + " "; 
				 break;
				   case 9: 
				 finalSentence += noun9 + " "; 
				 break;
				   case 10: 
				 finalSentence += noun10 + " "; 
				 break;
				   case 11: 
				 finalSentence += noun11 + " "; 
				 break;
				   case 12: 
				 finalSentence += noun12 + " "; 
				 break;
	 			}
		   switch ((1 + randomNumber.nextInt(10))%10 )
		   { 
				   case 1: 
				 finalSentence += verb1 + " "; 
				 break; 
				   case 2: 
				 finalSentence += verb2 + " "; 
				 break; 
				   case 3: 
				 finalSentence += verb3 + " "; 
				 break; 
				   case 4: 
				 finalSentence += verb4 + " "; 
				 break; 
				   case 5: 
				 finalSentence += verb5 + " "; 
				 break; 
				   case 6: 
				 finalSentence += verb6 + " "; 
				 break; 
				   case 7: 
				 finalSentence += verb7 + " "; 
				 break;
				   case 8: 
				 finalSentence += verb8 + " "; 
				 break;
				   case 9: 
				 finalSentence += verb9 + " "; 
				 break;
				   case 10: 
				 finalSentence += verb10 + " "; 
				 break;
	   		} 
		   switch (1 + (randomNumber.nextInt(4))%4 )
		   {
		   	   case 1: 
				 finalSentence += article1 + " "; 
				 break; 
			   case 2: 
				 finalSentence += article2 + " "; 
				 break;
			   case 3: 
				  finalSentence += article3 + " "; 
				  break; 
			   case 4: 
				  finalSentence += article4 + " "; 
				  break; 
			 } 
		   switch (1 + (randomNumber.nextInt(6))%6)
		   { 
				   case 1: 
				 finalSentence += nounA + ","; 
				 break; 
				   case 2: 
				 finalSentence += nounB + "-"; 
				 break; 
				   case 3: 
				 finalSentence += nounC + " "; 
				 break; 
				   case 4: 
				 finalSentence += nounD + "'"; 
				 break; 
				   case 5: 
				 finalSentence += nounE + "/"; 
				 break; 
				   case 6: 
				 finalSentence += nounE + "#"; 
				 break; 
	   		}
	   }
	return finalSentence;
	}
}
