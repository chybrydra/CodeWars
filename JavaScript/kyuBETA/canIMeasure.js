/*
Given a jar of 'a' litre and 'b' litres (a > b) and a demand 'c' litres 
you have to find if it is possible to measure 'c' litres with those A and B litre jar
return true if it is possible to measure 'c' with 'a' and 'b' jars
*/

function canIMeasure(a,b,c) {
   if (c>b) return false;
   var gcd = greatestCommonDivisor(a,b);   
   if (c%gcd==0) return true;
   else return false;
}

function greatestCommonDivisor(x,y){
    if (!y) {
        return x;
    }
    return greatestCommonDivisor(y, x % y);
};