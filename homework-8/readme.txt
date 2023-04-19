I first coded the Card class 
-each card object will take parameter for int suit and rank
-methods
--compareto method returns the difference in rank between the card object it was called on and the card object in the parameter 
-- toString method return print out the corresponding suits number to suits name and rank 1, 11, 12, 13 to its rank name 
    the rest ranks will print numeric value 
--getRank method returns the rank of the card object it was invoked on
--getSuit method returns the suit of the card object it was invoked on
--sameRank method return boolean true if the card object it was invoked on and the card object passed in param has same rank, false otherwise
--sameSuit method return boolean true if the card object it was invoked on and the card object passed in param has same suit, false otherwise
--diffRank method return the difference between the rank the card object it was invoked on and the card object passed in param

I then coded the deck class 
- a deck object has an array of cards of length 52 
-- for loop run 52 times and the if statement if side creates first 13 cards all in the suit clubs and increasing rank by one for each card (1, 2, 3,..., 13) 
-- the same is done with the rest three suits until we have our 52 cards deck
-- shuffle method shuffle the deck 100 times
--- 1. generate a rand int for index of the card array
--- 2. store first element in a tempCard
---3. pass the element of array with randomly generated index to the first element
---4. pass the element in tempcard which was teh original first element into random index  
---5.at the end of the shuffle instantiate top as 0 
--deal method return the card element with index top and prints error message if there is no cards left 
--- if the card was dealt top increment by one and deal card with initial top index was returned
--toString method go through all the card in the array cards and add them to one String separated by |, invoke the to string method in cards printing out each one

The player has a arraylist hand that will be dealt to him in Game, a starting bankroll of 50 and bet which will be decided by the player from an int taken in from the scanner
--the win variable specifies the amount won by specific kind of hand in the textbook
--addCard and removeCard method add or remove card from the hand. they will be used in the game when player wants to change the hand dealt to them
--bets method subtracts from the bankroll at the param amount
---error check is to make the max bet 5 and unable to bet more than the token he have in the bankroll
--winning method multiplies the amount won from specifc winning hand to the tokens bet and add that amount to bankroll
-- getWin return amount won from the hand (after multiplied to the bet)


In Game class
the game has a player a deck of cards and a hand dealt
when constructing the Game object, the player with bankroll of 50, hand and bets, a deck object(an arraylist of card objects) and a hand was instantiated 
There are two game constructors (overriding)
-if we pass in the cards(string array) in the command line argument then the test hand gets played
-- the hand in testhand is created by parsing each element in the testhand, the first char is suit and beyond that is rank
--the letter representation of suit is converted in numeric with if statement
--for each element in the String array testhand, a new card object is created and added to the player's hand with addCard method 
- if no arguments is passed in the command line, the other Game constructor was implemented 
-- the cards in the deck object (cards) was shuffled with shuffle method 
-- the for loop takes the first 5 cards in the cards(arraylist of cards) and adds them to hand array list
-- because the deck was shuffled, the first 5 cards in the deck are randomly distributed 

In the play method (called on the game object)
- we use the advance for loop to printout each card in hand (either randomly assigned or specified depending on which game constructor was called by param)
- then we ask if the player want to remove any cards and takes in the amount the player wants to remove with scanner
- for every card the player want to remove, I asked which card they want to remove, removes that card and print out the hand left
--if the amount to remove or index to remove is larger than the current hand or smaller than 0 then we tell the player it is not correct and ask for new input
-for every card removed we add to the hand with the deal method and print out every card in the hand after adding, this is the final hand  
- I then asked the player how many token they want to bet and takes in an integer to be the bet 
- the final hand is passed into check hand which checks what combination the hand matches with and return the name of that combo. the corresponding winning amount is and multiplied with token amount and returned through getwin method 
    the bankroll is also updated by adding the wining amount to existing token in bankroll and printed out.


----the onepair method take in the hand and compare the first card to the next, if they are same rank we add one to the pair and move to check the 2nd card to the next one until the fourth and fifth are checked
-----if the pair equals to 1 after we checked the entire hand then the if statetment of onepair is called and corresponding token and name is assigned 
----twopair invokes the onePair method, if onePair counted two pairs of cards of the samerank then return 1 which invoke the else if statement that scored the hand based on the win and name of twoPair
----threekind method is false if there is fullhouse or fourkind because the other two contains threekind but also has higher reward.
-----if the first and third card or second and fourth or third and fifth card has the same rank then there is three cards of same rank because the hand is sorted. The method return one if one of the above conditions are true
----straight method checks if the difference in rank of first and last card is 4 if so then the rank is consecutive, another situation is if the difference between the first and fourth card in rank is 3 and the last card is 1(ace) then straight also is true
        if straight method return true then the hand is scored b
----the flush method takes in a hand of 5 cards can checks if each cards is the same suit as the next one. if any one of them is not the same, the method return a boolean value false and the if statement in check hand does not execute 
-----if there are two cards of same rank then they are definitely of different suit so it also return false
---- fullhouse returns 1 and execute the if statement in checkhand if the first card and third card has same rank fourth fifth has same rank or first second has same rank and third fifth has same rank
----fourkind returns 1 and execute the if statement in checkhand if the first and fourth has same rank or second and fifth has same rank. It is checked before the three of a kind so if both are true the if statement of four of a kind gets executed
----straight flush method returns false if the hand is not straight or each card is not the same suit with the next card
-----straightflush is checked after royalflush so if both are true then you get royalflush 
----royal flush return false if either the hand is not in 10 11 12 13 1 or every card is not the same suit with the next one 
--- at the end of checkhand, the name of the win is returned and the win is passed into method winning to add that amount multiplied by bets to bankroll
--the end of play method prints the name of the won, the winning amount and current bankroll through corresponding methods
--I ordered the if/else if statement in checkhand to makesure the higher reward win is executed if multiple conditions are fullfilled 