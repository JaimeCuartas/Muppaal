//This file was generated from (Academic) UPPAAL 4.1.3 (rev. 4577), September 2010

/*
TERMINATION (do both participants always reach their end states?)
*/
A<> (stTC == TC_ENDED_FAILED || stTC == TC_ENDED_EXITED || stTC == TC_ENDED_NOTCOMPLETED  || stTC == TC_ENDED) &&  (stP == P_ENDED_CANCELED || stP == P_ENDED_CLOSED || stP == P_ENDED_COMPENSATED || stP == P_ENDED)

/*
CORRECTNESS (can the participants enter any invalid states?)
*/
E<> !overflow && (tc.INVALID || par.INVALID)

/*
BOUNDEDNESS (do the buffers overflow?)
*/
E<> overflow
