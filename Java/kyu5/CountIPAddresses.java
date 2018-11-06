/* kyu5
Write a function that accepts a starting and ending IPv4 address, and the number of IP addresses from start to end, excluding the end IP address.

All input to the function will be valid IPv4 addresses in the form of strings. The ending address will be at least one address higher than the starting address.
Examples

ipsBetween("10.0.0.0", "10.0.0.50")  =>   50 
ipsBetween("10.0.0.0", "10.0.1.0")   =>  256 
ipsBetween("20.0.0.10", "20.0.1.0")  =>  246
*/


public class CountIPAddresses {

  public static long ipsBetween(String start, String end) {
    String[] startIp = start.split("\\.");
    String[] endIp = end.split("\\.");
    
    long result1 = (Integer.parseInt(endIp[3])-Integer.parseInt(startIp[3]))*1;
    long result2 = (Integer.parseInt(endIp[2])-Integer.parseInt(startIp[2]))*256;
    long result3 = (Integer.parseInt(endIp[1])-Integer.parseInt(startIp[1]))*256*256;
    long result4 = (Integer.parseInt(endIp[0])-Integer.parseInt(startIp[0]))*256*256*256;
    
    return result1 + result2 + result3 + result4;
  }
}