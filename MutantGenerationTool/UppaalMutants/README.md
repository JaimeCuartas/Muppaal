# Uppaal Mutants

This repository contains a Model-Based Mutation Testing tool for Uppaal.

## Requirements

In order to use the tool you should have installed the following tools:

- OpenJDK 1.8.0_302 (Version that we have tested. 
However, our tool could be run on other versions of java. 
Although in case of problems, we recommend using this version)

## Usage

To use the Model-Based Mutation Testing prototype, follow the instructions:


```
usage: java -jar MutationUppaal.jar [OPTION]...
Where [-m <file>] model is a required option
If [-q <file>] query is missing, the execution of verifyta will be done
only with the model

 -h,--help                 Shows this help screen.
 -m,--model <path>         Required argument, specifies the file
                           containing the model to mutate.
 -q,--query <path>         Specifies the query file containing the
                           properties of the model.
 -v,--verifyTa <path>      Specifies the path where the uppaal verifyta
                           file is located to verify models.
 -p,--pathMutants <path>   Specifies the folder path where the mutants
                           will be located and the log file (if it is
                           indicated).
 -l,--log                  Produce a file that contains a record of
                           generated mutants in mutant folder.
 -tmi                      Enable tmi operator. Transition MIssing
                           operator removes a transition.
 -tad                      Enable tad operator. Transition ADd operator
                           adds a transition between two states. This
                           operator make an internal action (tau/siilent).
                           The new transitions will not be where the
                           automaton already had another transition
 -tadSync <action>         Enable tad operator. Transition ADd operator
                           adds a transition between two states. This
                           operator use the specified action as an output
                           action (action!). Be sure the action is on the
                           environment of the system to verify it. The new
                           transitions will not be where the automaton
                           already had another external transition
 -tadRandomSync            Enable tad operator. Transition ADd operator
                           adds a transition between two states. This
                           operator use a random channel on the
                           environment as an output action (a!). The new
                           transitions will not be where the automaton
                           already had another external transition
 -smi                      Enable smi operator. State MIssing operator
                           removes a state (other than the initial state)
                           and all its incoming/outgoing transitions.
 -smiNoRedundant           Enable smi operator. State MIssing operator
                           removes a state (other than the initial state)
                           and all its incoming/outgoing transitions. This
                           operator avoid some redundant mutants with the
                           tmi operator. Generate a subset of smi mutants
 -cxl                      Enable cxl operator. Constant eXchange L
                           operator increases the constant of a clock
                           constraint.
 -cxs                      Enable cxs operator. Constant eXchange S
                           operator decreases the constant of a clock
                           constraint.
 -ccn                      Enable ccn operator. Clock Constraint Negation
                           operator negates a clock constraint.
 -env <action>             Specify the name of the automaton to make the
                           mutants
-m,--model <path> is a required option
Try `java -jar MutationUppaal.jar -h' for more information.

```