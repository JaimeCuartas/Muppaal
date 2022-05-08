//This file was generated from UPPAAL 4.1.0 (rev. 3425), February 2008

/*
Consistency property checks the correctness of the protocol. Consistency is a safety property and it is expressed by an invariant  assertion. It states that the protocol is never in an inconsistent 
configuration where one process thinks that the transaction is committed while another process claims that it was aborted.
*/
A[] Consistency()
