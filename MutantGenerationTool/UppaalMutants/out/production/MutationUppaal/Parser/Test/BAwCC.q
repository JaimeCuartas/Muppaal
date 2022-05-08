//This file was generated from (Academic) UPPAAL 4.1.3 (rev. 4577), September 2010

/*
TERMINATION (do both participants always reach their final states?)
*/
A<> stTC == TC_ENDED &&  stP == P_ENDED

/*
CORRECTNESS (is an invalid state reachable?)
*/
E<> !overflow && (tc.INVALID || par.INVALID)

/*
BOUNDEDNESS (do the buffers overflow?)
*/
E<> overflow
