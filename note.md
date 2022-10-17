# Note for FNAF

## Algorithm

### Modeling the Game

By reading the source code I found that the only randomness comes from the behaviours of characters, which is simple coin process given certain game state, which is finite, and feasibly limited, since the characters do not take factors with large state space, e.g. power left, into account.
Each character $i$ can be considered as a probabilistic automaton with a state space $S^i$, state transision map $f^i$ with a probability $p\le\frac{1}{2}$ *(1)* that it would not work:



$${\text{Character i}} = \{S^i, f^i:\boldsymbol{S}\mapsto S^i\times(0,\frac{1}{2})\}$$

where $\boldsymbol{S}=S^{\text{office}}\times\prod\limits_{j\in{\text{Characters}}}S^j$

 

According to the definition of FNAF1, the state transition of characters except Foxy are deterministic, i.e. the transition graphs are lines. Defined by user themselves, however, they can be trees or graphs.



The model of state transition of entire game, as the multiplication of unit automata, can be seen as a larger automaton with probability or a chain of Markov stochastic process:

$${\text{Game}} = \{\boldsymbol{S},\tau\in\mathbb{N+},\eta:I\times\boldsymbol{S}\mapsto\boldsymbol{S},P_{|\boldsymbol{S}|\times|\boldsymbol{S}|},\delta:\boldsymbol{S}\times\mathbb{N+}\mapsto\{0,1,2\}\}$$

where $I$ is the player instruction, $\eta$ maps the player instruction with current state to a new state;

$P$ is the transition matrix, or transition function of the game.

$\tau$ is the discrete time, and $\delta$ maps time with game state to the result of game, which is the only part that conserns time, and does not affect other arguments.



What makes the game interesting is, that the game is a stochastic process with hidden state space, which need to be infered from observation, and observation itself is regarded as an action applied by agent that will affect the game. 

Another perspective is to consider the game with the agent as a whole automata, inside which the cells are not fully connected, and as the controll unit of the machine, the agent, sitting in office, knows how the other part would malfunction with a proper rate, but without the knowledge of the current state of them during a particular running, neither whether malfunction had really occured. The aim of this machine, both for the collection and for control unit, is to function long enough to a particular time, maintaining an attribute of this machine to be 1 (yeah, I know, the characters would disagree with this aim. But why can't we just think from the opposite? ) 

This transforms the problem into a very pragmatic one, where control unit should be designed to improve the reliability of the entire machine with elements with specific unreliability, which makes the problem quite inspiring. It turns to a system with a part simple enough with a failure possibility and a part precise but, perhaps, complicated.

**Note:** In case you argue that characters are designed to let the whole system fail, lets loosen *(1)* and allow the malfunction rate to be in $(0,1]$.





### Possible Solutions

