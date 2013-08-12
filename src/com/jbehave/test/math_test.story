Scenario: Test Math.pow(x,y)
Given this table of numbers
   | Num1 | Num2 |
   | 2    | 2    |
   | 3    | 3    |
When the math operation 'Num1' to the power of 'Num2' is performed on each row
Then the results should match this table
   | Result |
   | 4      |
   | 27     |
   
   