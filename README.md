# MoneyChange-Coding-Exercise

My dynamic programming algorithm solution to the following coding problem:

My code works but here are their findings in my code:
- solution is good since it is a dynamic programming solution
- relatively fast
but
- no unit tests
- no input validation for the wrong command
- uses single-character variable names and also single case upper case variable name (i.e int[] M = new int[n+1])
method handling change logic also outputting the text to the user

The coding exercise:

Rocketmiles Software Engineering Coding Take-home
At Rocketmiles, our team loves traveling. However, many places we travel don’t accept our
credit cards, and we have to remember to bring dollar bills with us. We’ve had to correct a few
vendors about giving us the correct change from their cash registers; sometimes we get too
much and sometimes we get too little.
We’d like you to create a cash register app that should accept $20, $10, $5, $2 and $1 bills. It
should support putting money into the register and taking it out, as shown below. When asked to
provide change of a given amount, return the change as the number of bills that should be given
from the cash register. If you can’t make exact change, say so.
All input/output can be by command line. Below are some examples of how it would be used.
Please send your completed assignment as a ZIP file, or preferably as a link to a GitHub or
Bitbucket repository. Treat this assignment as though we were going to potentially push this
code to production.
The estimated time to complete this task is 3 hours. There is no deadline, but we respect your
time and understand that you have competing priorities. If you find yourself spending
significantly more time on this, please let us know, so we can help.
We look forward to seeing what you create!
Rocketmiles Engineering

Example usage:
// start program, waiting for a command
> java Main ...
ready
// show current state, including total and each denomination:
// $Total #$20 #$10 #$5 #$2 #$1
// for example, $68 1 2 3 4 5 means:
// Total=$68 $20x1 $10x2 $5x3 $2x4 $1x5
> show
$68 1 2 3 4 5
// put bills in each denomination: #$20 #$10 #$5 #$2 #$1
// and show current state
> put 1 2 3 0 5
$128 2 4 6 4 10
// take bills in each denomination: #$20 #$10 #$5 #$2 #$1
// and show current state
> take 1 4 3 0 10
$43 1 0 3 4 0
// show requested change in each denomination: #$20 #$10 #$5 #$2 #$1
// and remove money from cash register
> change 11
0 0 1 3 0
> show
$32 1 0 2 1 0
// show error if there are insufficient funds or no change can be made
> change 14
sorry
// exit program
> quit
Bye
