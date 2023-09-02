/*Eric Gutierrez 
* September 2 , 2022
 * Purpose: To validate credit cards using Luhn algorithm.If credit card is valid then 
 * the program will return a random pin 
 */
package creditCard;

import java.util.Random;
import java.util.Scanner;

public class CCValidation {

	public static void main(String[] args)
	{
		//set up a Scanner
		Scanner input = new Scanner(System.in);
		//set up a boolean named validCreditCard and set it to false       
		boolean validCreditCard = false;
		//loop while not a valid credit card  
		while(!validCreditCard)
		{

			//prompt the user for a potential credit card number                     
			System.out.print("Please enter your Credit Card Number: ");
			//Get the credit card number as a String - store in potentialCCN (use scanner's nextLine)
			String potentialCCN = input.nextLine(); 


			//use Luhn to validate credit card 

			//store the last digit AS AN INT for later use in lastDigit (requires Integer.parseInt(String)
			int lastDigit =	Integer.parseInt(potentialCCN.substring(potentialCCN.length()-1));


			//remove the last digit from potentialCCN and store in potentialCCN using String's substring
			potentialCCN = potentialCCN.substring(0,potentialCCN.length()-1);


			//create reversedCCN as a empty String by:
			String reversedCCN = "";

			//reverse the digits using a for loop by adding characters to reversedCCN
			for(int i = 0;i < potentialCCN.length(); i++)
			{
				char reversedNumbers = potentialCCN.charAt(i);
				reversedCCN = reversedNumbers+reversedCCN ;
			} //end the reverse the string loop


			//set boolean isOddDigit to false
			boolean isOddDigit = false;

			//set up an integer called current digit and set it to 0
			int currentDigit = 0;

			//create an integer named sum and set it to 0
			int sum = 0;


			//multiply the digits in odd positions by 2, then subtract 9 from any number higher than 9 using:


			//(for loop running 0 to less than length of reversed CCN)
			for(int i=0; i < reversedCCN.length()-1;i++)
			{
				//set currentDigit equal to the integer version of the current character
				currentDigit = Integer.parseInt(""+reversedCCN.charAt(i));


				//toggle isOddDigit
				isOddDigit = !isOddDigit;

				//if isOddDigit
				if(isOddDigit) 
				{

					//multiply currentDigit by 2 and store in currentDigit
					currentDigit*=2;

					//if currentDigit > 9, subtract 9 from currentDigit and store in currentDigit
					if(currentDigit>9) 
					{
						currentDigit=currentDigit-9;

					}
				}//endifisOdd


				// add currentDigit to sum and store in sum     
				sum = currentDigit + sum;

			}//end the for loop that runs from 0 to less than the length of reversed CCN     


			//if the last digit of sum + the last Digit ends in a zero, set isValidCreditCard to true

			if((sum+lastDigit)%10==0)
			{
				validCreditCard = true ;
			}//end if

			//if validCreditCard is false, output an appropriate message
			if(validCreditCard == false)
			{
				System.out.println("Invalid Credit Card try again: ");
				validCreditCard = false;
			} //end if

		}//end while that checks for valid credit card
		//issue a RANDOM PIN and print it out 
		Random rand= new Random();
		int Pin = rand.nextInt((9999-1111+1)+1111);

		System.out.println("Your PIN is "+Pin);

	}
}


